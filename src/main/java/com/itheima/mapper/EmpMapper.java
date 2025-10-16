package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {


    List<Emp> list(EmpQueryParam empQueryParam);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)  "+
            "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void add(Emp emp);

    void delete(List<Integer> ids);

    Emp getInfo(Integer id);

    void updateEmp(Emp emp);
    //@Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc")

    @MapKey("pos")
    List<Map<String,Object>> countEmpJobData();

    List<Map<String, Object>> getGenderData();

    @Select("select * from emp")
    List<Emp> findAll();

    List<Map<String, Object>> getClassNum();

    @Select("select * from emp where username =#{username} and password = #{password}")
    Emp login(String username, String password);
}
