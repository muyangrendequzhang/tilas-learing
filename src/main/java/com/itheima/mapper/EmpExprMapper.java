package com.itheima.mapper;

import com.itheima.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {



    void add(List<EmpExpr> exprList);

    void delete(List<Integer> ids);
}
