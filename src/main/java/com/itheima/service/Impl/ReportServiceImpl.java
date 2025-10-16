package com.itheima.service.Impl;

import com.itheima.mapper.ClazzMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.ClazzOption;
import com.itheima.pojo.JobOption;
import com.itheima.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public JobOption getEmpJobData() {
        List<Map<String, Object>> maps = empMapper.countEmpJobData();

        List<Object> pos = maps.stream().map(data -> data.get("pos")).toList();
        List<Object> num = maps.stream().map(data -> data.get("num")).toList();
        return new JobOption(pos,num);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        List<Map<String,Object>> mapList = empMapper.getGenderData();
        return mapList;
    }

    @Override
    public ClazzOption getClassNum() {
        List<Map<String,Object>> mapList = empMapper.getClassNum();
        List<Object> clazzList = mapList.stream().map(data->data.get("clazzList")).toList();
        List<Object> dataList = mapList.stream().map(data-> data.get("dataList")).toList();
        return new ClazzOption(dataList,clazzList);
    }

    @Override
    public List<Map<String, Object>> getDegreeInfo() {
        List<Map<String,Object>> mapList = clazzMapper.getDegreeInfo();
        return mapList;
    }
}
