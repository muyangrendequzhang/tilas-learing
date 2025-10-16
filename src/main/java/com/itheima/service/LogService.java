package com.itheima.service;

import com.itheima.pojo.OperateLog;
import com.itheima.pojo.PageResult;
import org.springframework.stereotype.Service;

@Service
public interface LogService {

    PageResult<OperateLog> page(Integer page, Integer pageSize);
}
