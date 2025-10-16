package com.itheima.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());
        List<Student> list = studentMapper.page();
        Page<Student> list1 = (Page<Student>) list;
        return new PageResult<>(list1.getTotal(),list1.getResult());
    }

    @Override
    public void add(Student student) {
        studentMapper.add(student);
    }

    @Override
    public Student getInfoById(Integer id) {
        Student student = studentMapper.getInfoById(id);
        return student;
    }

    @Override
    public void updateInfo(Student student) {
        studentMapper.updateInfo(student);
    }

    @Override
    public void deleteStudent(List<Integer> ids) {
        studentMapper.delete(ids);
    }

    @Override
    public void deal(Integer id, Integer score) {
        Student student = studentMapper.getInfoById(id);
        Short tempViolationCount = student.getViolationCount();
        Short tempViolationScore =student.getViolationScore();
        tempViolationCount++;
        int temp =score+tempViolationScore;
        short temp1 =(short)temp;
        student.setViolationCount(tempViolationCount);
        student.setViolationScore(temp1);
        studentMapper.updateInfo(student);

    }
}
