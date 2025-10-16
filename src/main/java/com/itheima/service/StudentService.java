package com.itheima.service;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    PageResult<Student> page(StudentQueryParam studentService);

    void add(Student student);

    Student getInfoById(Integer id);

    void updateInfo(Student student);

    void deleteStudent(List<Integer> ids);

    void deal(Integer id, Integer score);
}
