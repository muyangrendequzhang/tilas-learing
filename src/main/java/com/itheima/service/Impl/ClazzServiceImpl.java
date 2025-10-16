package com.itheima.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.ClazzMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public PageResult<Clazz> pageCheck(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(),clazzQueryParam.getPageSize());
        List<Clazz> list = clazzMapper.list();
        for (Clazz clazz : list) {
            if(clazz.getBeginDate().isAfter(LocalDate.now())){
                clazz.setStatus("未开班");
            }else if(clazz.getEndDate().isBefore(LocalDate.now())){
                clazz.setStatus("已结束");
            }else {
                clazz.setStatus("在读中");
            }

        }
        Page<Clazz> p = (Page<Clazz>) list;
        return new PageResult<Clazz>(p.getTotal(),p.getResult());
    }

    @Override
    public void add(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.add(clazz);
    }

    @Override
    public Clazz getInfoById(Integer id) {
        Clazz clazz = clazzMapper.getInfoById(id);
        return clazz;
    }

    @Override
    public void updateInfo(Clazz clazz) {
        clazzMapper.updateInfo(clazz);
    }

    @Override
    public void deleteClazz(Integer id) {
        clazzMapper.delete(id);
    }

    @Override
    public List<Clazz> listAll() {
        List<Clazz> list = clazzMapper.list();
        return list;
    }


}
