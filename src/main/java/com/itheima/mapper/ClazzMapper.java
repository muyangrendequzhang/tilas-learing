package com.itheima.mapper;

import com.itheima.pojo.Clazz;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClazzMapper {
    List<Clazz> list();

    @Insert("INSERT into clazz(name, room, begin_date, end_date, master_id, subject, create_time, update_time) " +
            "values (#{name},#{room},#{beginDate},#{endDate},#{masterId},#{subject},#{createTime},#{updateTime});")
    void add(Clazz clazz);

    @Select("select * from clazz where id = #{id};")
    Clazz getInfoById(Integer id);

    void updateInfo(Clazz clazz);

    @Delete("delete from clazz where id = #{id}")
    void delete(Integer id);


    List<Map<String, Object>> getDegreeInfo();
}
