package com.itheima.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpExprMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.*;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogServiceImpl empLogService;

    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {

        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        List<Emp> list = empMapper.list(empQueryParam);
        Page<Emp> p = (Page<Emp>) list;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void add(Emp emp) {
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.add(emp);

            Integer id = emp.getId();
            List<EmpExpr> exprList = emp.getExprList();
            if (!exprList.isEmpty()) {
                for (EmpExpr empExpr : exprList) {
                    empExpr.setEmpId(id);
                }
                empExprMapper.add(exprList);
            }
        } finally {
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), emp.toString());
            empLogService.insertLog(empLog);
        }
    }

    @Transactional(rollbackFor = {Exception.class})//任意的异常都回滚
    @Override
    public void delete(List<Integer> ids) {
        //按照主键删除，员工信息和经历信息
        empMapper.delete(ids);

        empExprMapper.delete(ids);
    }

    @Override
    public Emp getInfo(Integer id) {

        Emp emp = empMapper.getInfo(id);
        return emp;
    }

    @Override
    public void update(Emp emp) {
        //1.更新员工信息
        empMapper.updateEmp(emp);
        //2.删除员工经历的信息根据主键id
        empExprMapper.delete(Arrays.asList(emp.getId()));
        //3.插入员工经历的信息
        List<EmpExpr> exprList = emp.getExprList();

        if (exprList != null) {
            if(!exprList.isEmpty()){
                for (EmpExpr empExpr : exprList) {
                    empExpr.setEmpId(emp.getId());
                }
                empExprMapper.add(exprList);
            }
        }
    }

    @Override
    public List<Emp> listAll() {
        List<Emp> list = empMapper.findAll();
        return list;
    }

    @Override
    public LoginInfo login(String username, String password) {
        Emp emp =empMapper.login(username,password);
        if(emp !=null){

            Map<String, Object> claims = new HashMap<>();
            claims.put("id",emp.getId());
            claims.put("username",emp.getUsername());
            String jwt = JwtUtils.generateToken(claims);
            LoginInfo info = new LoginInfo(emp.getId(),emp.getUsername(),emp.getName(),jwt);
            return info;
        }

        return null;
    }
}
