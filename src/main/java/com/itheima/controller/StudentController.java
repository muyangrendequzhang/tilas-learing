package com.itheima.controller;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping()
    public Result page(StudentQueryParam studentQueryParam){
        log.info("分页查询找到的{}",studentQueryParam);
        PageResult<Student> pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }
    @PostMapping()
    public Result add(@RequestBody Student student){
        log.info("添加的学生信息{}",student);
        studentService.add(student);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getInfoById(@PathVariable Integer id){
        log.info("查询序号为{}的学生",id);
        Student student = studentService.getInfoById(id);
        return Result.success(student);
    }
    @PutMapping()
    public Result updateInfo(@RequestBody Student student){
        log.info("要修改的信息为{}",student);
        studentService.updateInfo(student);
        return Result.success();
    }
    @DeleteMapping("/{ids}")
    public Result deleteStudent(@PathVariable("ids") List<Integer> ids){
        log.info("删除号数为{}的学生",ids.toString());
        studentService.deleteStudent(ids);
        return Result.success();
    }
    @PutMapping("/violation/{id}/{score}")
    public Result dealStu(@PathVariable Integer id,@PathVariable Integer score){
        log.info("学号为{}的同学扣{}分",id,score);
        studentService.deal(id,score);
        return Result.success();
    }


}
