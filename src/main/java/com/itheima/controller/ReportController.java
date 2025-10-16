package com.itheima.controller;

import com.itheima.pojo.ClazzOption;
import com.itheima.pojo.JobOption;
import com.itheima.pojo.Result;
import com.itheima.service.Impl.ReportServiceImpl;
import com.itheima.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;


    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("员工信息数");
        JobOption jobOption =reportService.getEmpJobData();
        return Result.success(jobOption);
    }
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工的性别信息");
        List<Map<String,Object>> mapList =reportService.getEmpGenderData();
        return Result.success(mapList);
    }
    @GetMapping("/studentCountData")
    public Result getClassNum(){
        log.info("班级人数统计");
        ClazzOption clazzOption = reportService.getClassNum();
        return Result.success(clazzOption);
    }
    @GetMapping("/studentDegreeData")
    public Result getDegreeInfo(){
        log.info("班级学历统计");
        List<Map<String,Object>> mapList = reportService.getDegreeInfo();
        return Result.success(mapList);
    }
}
