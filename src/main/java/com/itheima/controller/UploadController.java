package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
public class UploadController {

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    /*@PostMapping("/upload")
    public Result upload(String name, Integer age, MultipartFile file) throws IOException {
        log.info("收到"+name+age+file.toString());

        String originalFilename = file.getOriginalFilename();

        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString()+extension;
        file.transferTo(new File("D:/develop/" + newFileName));
        return Result.success();
    }*/
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        String url = aliyunOSSOperator.upload(file.getBytes(),file.getOriginalFilename());
        return Result.success(url);
    }


}
