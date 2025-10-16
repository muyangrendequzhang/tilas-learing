package com.itheima.service;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClazzService {
    PageResult<Clazz> pageCheck(ClazzQueryParam clazzQueryParam);



    void add(Clazz clazz);

    Clazz getInfoById(Integer id);

    void updateInfo(Clazz clazz);

    void deleteClazz(Integer id);

    List<Clazz> listAll();
}
