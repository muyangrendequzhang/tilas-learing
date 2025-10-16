package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import com.itheima.service.Impl.DeptServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DeptController {

    @Autowired
    private DeptServiceImpl deptService;

    @GetMapping("/depts")
    public Result findAll(){
        List<Dept>deptList = deptService.findAll();//调用service层的方法
        return Result.success(deptList);//返回正确后的信息

    }
    @Log
    @DeleteMapping("/depts")
    public Result deleteById(Integer id){
        //参数和请求同名
        log.info("修改的数据"+id);
        deptService.deleteById(id);
        return Result.success();
    }

    @Log
    @PostMapping("/depts")
    public Result postDept(@RequestBody Dept dept){
       log.info(dept.getName());
        deptService.addDept(dept);
        return Result.success();
    }

    @GetMapping("/depts/{id}")
    public Result findById(@PathVariable Integer id){
        log.info(id.toString());
        Dept dept= deptService.findById(id);
        return Result.success(dept);
    }

    @Log
    @PutMapping("/depts")
    public Result setDeptName(@RequestBody Dept dept){
        log.info(dept.toString());
        deptService.setDeptName(dept);
        return Result.success();
    }
}
