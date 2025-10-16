package com.itheima.service;

import com.itheima.pojo.ClazzOption;
import com.itheima.pojo.JobOption;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ReportService {
    JobOption getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();

    ClazzOption getClassNum();

    List<Map<String, Object>> getDegreeInfo();
}
