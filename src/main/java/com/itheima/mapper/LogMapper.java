package com.itheima.mapper;

import com.itheima.pojo.OperateLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {

    @Select("select o.*,e.name operate_emp_name from operate_log o left join emp e on o.operate_emp_id=e.id")
    List<OperateLog> selectAll();
}
