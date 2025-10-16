package com.itheima.controller;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @GetMapping()
    public Result pageCheck(ClazzQueryParam clazzQueryParam){
        log.info("收到查询消息：{}",clazzQueryParam.toString());
        PageResult<Clazz> pageResult = clazzService.pageCheck(clazzQueryParam);
        return Result.success(pageResult);
    }
    @PostMapping()
    public Result add(@RequestBody Clazz clazz){
        //使用RequestBody注释，使得接json文件
        log.info("接收到添加的信息{}",clazz.toString());
        clazzService.add(clazz);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getInfoById(@PathVariable Integer id){
        //通过注释获得路径后的值
        log.info("查询第{}号的课程信息",id);
        Clazz clazz = clazzService.getInfoById(id);
        return Result.success(clazz);
    }
    @PutMapping()
    public Result updateInfo(@RequestBody Clazz clazz){
        log.info("要修改的信息{}",clazz);
        clazzService.updateInfo(clazz);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result deleteClazz(@PathVariable Integer id){
        log.info("删除{}号课程",id);
        clazzService.deleteClazz(id);
        return Result.success();
    }
    @GetMapping("/list")
    public Result listAll(){
        log.info("得到全部的班级");
        List<Clazz> list = clazzService.listAll();
        return Result.success(list);
    }

}
