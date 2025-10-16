package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> findAll();

    void deleteById(Integer id);

    void addDept(Dept dept);

    Dept findById(Integer id);

    void setDeptName(Dept dept);

}
