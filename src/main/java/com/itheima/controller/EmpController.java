package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.itheima.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping()
    public Result page(EmpQueryParam empQueryParam){
        log.info("接受到的信息{}{}",empQueryParam);

        PageResult<Emp> pageResult = empService.page(empQueryParam);

        return Result.success(pageResult);

    }
    @PostMapping()
    public Result add(@RequestBody Emp emp){
        log.info(emp.toString());
        empService.add(emp);
        return Result.success();
    }

    @DeleteMapping()
    public Result delete(@RequestParam List<Integer> ids){
        log.info("删除数据：{}",ids);
        empService.delete(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("收到数据：{}",id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }
    @PutMapping()
    public Result update(@RequestBody Emp emp){
        log.info("收到的更新信息：{}",emp.toString());
        empService.update(emp);
        return Result.success();
    }

    @GetMapping("/list")
    public Result listAll(){
        log.info("输出全部的员工信息");
        List<Emp> list = empService.listAll();
        return Result.success(list);
    }
}
