package com.gst.code.generator.generator;


import com.gst.code.generator.utils.StringUtils;
import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;
import sun.nio.cs.Surrogate;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {

    private static final String fileSuffix = ".java";
    private static String swaggerStr = "    @ApiModelProperty(\"%s\")";
    private static String notesStart = "/**";
    private static String notesEnd = "*/";
    private static String notesMiddle = "*";
    private static String methond1 = "@return";
    private static String methond2 = "@param";
    private static String importStr = "import io.swagger.annotations.ApiModelProperty;";

    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(
                Surrogate.Generator.class.getResourceAsStream("/generator/generatorConfig.xml"));
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        //myBatisGenerator.generate(null);
        entitySetSwagger(config);
    }

    private static void entitySetSwagger(Configuration config) {
        Context context = config.getContexts().get(0);
        JavaModelGeneratorConfiguration javaModel = context.getJavaModelGeneratorConfiguration();
        String path = javaModel.getTargetProject()+ File.separator + javaModel.getTargetPackage().replace(".",File.separator);
        List<TableConfiguration> tableConfigurations = context.getTableConfigurations();
        for (TableConfiguration tableConfiguration : tableConfigurations) {
            String filePath = path + File.separator + StringUtils.lineToHump(tableConfiguration.getTableName()) + fileSuffix;
            System.out.println(filePath);
            File file = new File(filePath);
            FileReader fileInputStream = null;
            BufferedReader br = null;
            FileWriter fileWriter = null;
            boolean notesflag = false;
            StringBuffer sb = new StringBuffer();
            try {
                fileInputStream = new FileReader(file);
                br = new BufferedReader(fileInputStream);
                String line = null;
                String note = "";
                while ((line = br.readLine()) != null){
                    if(notesflag && (line.contains(methond1)||line.contains(methond2))){
                        notesflag = false;
                    }
                    if(notesStart.equals(line.trim())){
                        notesflag = true;
                    }
                    if(notesflag && line.trim().startsWith(notesMiddle) && !line.trim().startsWith(notesEnd)){
                        note = line.replace(notesMiddle,"").trim();
                    }
                    sb.append(line);
                    sb.append("\r\n");
                    if(notesEnd.equals(line.trim())&&notesflag){
                        notesflag = false;
                        sb.append(String.format(swaggerStr,note));
                        sb.append("\r\n");
                    }
                    if(line.startsWith("improt")){
                        sb.append(importStr);
                        sb.append("\r\n");
                    }
                }
                if(StringUtils.isNotBlank(sb.toString())){
                    fileWriter = new FileWriter(file);
                    fileWriter.write(sb.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if(null != br){
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(null != fileInputStream){
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(null != fileWriter){
                    try {
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            //System.out.println(sb.toString());
        }
    }
}
