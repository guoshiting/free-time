package com.gst.tool.util;

import com.csvreader.CsvWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvUtil {

    private String[] header;
    private String[] files;
    //private Class<?> clazz;
    private Map<String,Method> map = new HashMap<>();
    private CsvWriter csvWriter;

    public String[] getHeader() {
        return header;
    }

    public String[] getFiles() {
        return files;
    }

    private CsvUtil() {
    }

    private CsvUtil(String[] header,String[] files) {
        this.header = header;
        this.files = files;
    }

    public static CsvUtil newInstance() {
        return new CsvUtil();
    }

    public CsvUtil addHeader(String[] header) {
        this.header = header;
        return this;
    }
    public CsvUtil addFiles(String[] files) {
        this.files = files;
        return this;
    }

    public CsvUtil addClazz(Class clazz) {
        if(null == files || files.length  == 0) {
            throw new RuntimeException("请先添加属性名称,属性名称数组为空...");
        }
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if(method.getName().startsWith("get")) {
                map.put(lowerFirst(method.getName().substring(3)), method);
            }
        }
        return this;
    }

    private String lowerFirst(String fileName) {
        char[] chars = fileName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    public CsvUtil addOutputStream(OutputStream out) throws IOException {
        csvWriter = new CsvWriter(out, ',', Charset.forName("UTF8"));
        csvWriter.writeRecord(header);
        return this;
    }
    public CsvUtil addOutputStream(OutputStream out,Charset encoding) throws IOException {
        csvWriter = new CsvWriter(out, ',', encoding);
        csvWriter.writeRecord(header);
        return this;
    }

    /**
     *
     * @param list 数据
     * @param end 最后一行是否不换行 true不换号 false换行
     * @return
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws IOException
     */
    public CsvUtil write(List<?> list,boolean end) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
//		if(null == clazz) {
//			throw new RuntimeException("请先调用addClazz方法...");
//		}
        for (int i = 0; i < list.size(); i++) {
            for (String file : files) {
                csvWriter.write(map.get(file).invoke(list.get(i), null) == null ? "" : map.get(file).invoke(list.get(i), null).toString());// 预算编号
            }
            if(i != (list.size()-1) && end){
                csvWriter.endRecord();
            }else{
                csvWriter.endRecord();
            }
        }
        return this;
    }
    public void close() {
        if(null != csvWriter) {
            csvWriter.close();
        }
    }
//	public static void main(String[] args) throws Exception {
//		String[] str = {"姓名","年龄","性别"};
//		String[] files = {"name","age","sex"};
//		OutputStream out = new FileOutputStream(new File("D:\\DOC\\doc\\6.数据字典(开发)\\test.csv"));
//		List<A> list = new ArrayList<A>();
//		for(int i=0;i<100;i++) {
//			A a = new A();
//			a.setName(i+"name");
//			a.setAge(i+"age");
//			a.setSex(i+"sex");
//			list.add(a);
//		}
//		CsvUtil csvUtil = newInstance().addHeader(str).addFiles(files).addClazz(A.class).addOutputStream(out, Charset.forName("GBK"));
//		csvUtil.write(list);
//		csvUtil.close();
//	}
}
//
//class A{
//	private String name;
//	private String age;
//	private String sex;
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getAge() {
//		return age;
//	}
//	public void setAge(String age) {
//		this.age = age;
//	}
//	public String getSex() {
//		return sex;
//	}
//	public void setSex(String sex) {
//		this.sex = sex;
//	}
//	@Override
//	public String toString() {
//		return "A [name=" + name + ", age=" + age + ", sex=" + sex + "]";
//	}
//}