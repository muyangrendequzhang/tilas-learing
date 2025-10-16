package com.itheima.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.LogMapper;
import com.itheima.pojo.OperateLog;
import com.itheima.pojo.PageResult;
import com.itheima.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;
    @Override
    public PageResult<OperateLog> page(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<OperateLog> list = logMapper.selectAll();
        Page<OperateLog> page1 = (Page<OperateLog>) list;//这里的list被page继承，因为pagehelper存在所以可以直接强转

        return new PageResult<>(page1.getTotal(),page1.getResult());
    }
}
