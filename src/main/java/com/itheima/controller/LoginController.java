package com.itheima.controller;


import com.itheima.pojo.Emp;
import com.itheima.pojo.LoginInfo;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping()
    public Result login(@RequestBody Emp emp) {
        log.info("进行登录");
        LoginInfo info =empService.login(emp.getUsername(),emp.getPassword());
        if(info != null){
            return Result.success(info);
        }
        return Result.error("密码或者用户名错误");
    }
}
