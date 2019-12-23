package com.gst.code.generator.common;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gst.code.generator.entity.TestCase;
import com.gst.code.generator.utils.JsonUtils;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Map;

public abstract class BaseServiceImpl<T,V> implements IBaseService<T,V> {

    public BaseMapper mapper;

    public abstract void setMapper();

    @Override
    public Message save(T t) {
        beforeSave(t);
        if(1==mapper.insert(t)){
            return Message.success();
        }
        return Message.failure(BaseCode.FAILED,"保存失败");
    }

    @Override
    public Message modifyById(T t) {
        beforeModify(t);
        if(1==mapper.updateByPrimaryKeySelective(t)){
            return Message.success();
        }
        return Message.failure(BaseCode.FAILED,"修改失败");
    }

    @Override
    public Message removeById(V id) {
        if(1==mapper.deleteByPrimaryKey(id)){
            return Message.success();
        }
        return Message.failure(BaseCode.FAILED,"删除失败");
    }

    @Override
    public Message queryById(V id) {
        mapper.selectByPrimaryKey(id);
        return Message.success(mapper.selectByPrimaryKey(id));
    }

    @Override
    public Message page(String limit, String offset, Map<String, Object> params,Class<T> clazz) {
        Integer pageSize = limit == null ? Integer.MAX_VALUE : Integer.valueOf(limit);
        Integer pageNum = offset == null ? 0 : Integer.valueOf(offset);
        PageHelper.startPage(pageNum,pageSize);
        if(CollectionUtils.isEmpty(params)){
            return Message.success(new PageInfo(mapper.selectAll()));
        } else{
            Example ex = new Example(clazz);
            Example.Criteria criteria = ex.createCriteria();
            for(Map.Entry<String, Object> entry:params.entrySet()){
                criteria.andEqualTo(entry.getKey(),entry.getValue());
            }
            return Message.success(new PageInfo(mapper.selectByExample(ex)));
        }
    }

    @Override
    public Message pageTime(String limit, String offset, Map<String, Object> params,Class<T> clazz,Map<String,String> mapTime) {
        Integer pageSize = limit == null ? Integer.MAX_VALUE : Integer.valueOf(limit);
        Integer pageNum = offset == null ? 1 : Integer.valueOf(offset);
        PageHelper.startPage(pageNum,pageSize);
        if(CollectionUtils.isEmpty(params)){
            return Message.success(new PageInfo(mapper.selectAll()));
        } else{
            Example ex = new Example(clazz);
            Example.Criteria criteria = ex.createCriteria();
            for(Map.Entry<String, Object> entry:params.entrySet()){
                if(!CollectionUtils.isEmpty(mapTime)){
                    if(null != mapTime.get(entry.getKey())){
                        if(entry.getKey().startsWith("start")){
                            criteria.andGreaterThanOrEqualTo(mapTime.get(entry),entry.getValue());
                            continue;
                        }else if(entry.getKey().startsWith("end")){
                            criteria.andLessThanOrEqualTo(mapTime.get(entry),entry.getValue());
                            continue;
                        }
                    }
                }
                criteria.andEqualTo(entry.getKey(),entry.getValue());
            }
            return Message.success(new PageInfo(mapper.selectByExample(ex)));
        }
    }

    public void beforeSave(T t) {
    }

    public void beforeModify(T t) {
    }
}
