package com.itheima.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentQueryParam {
    String name;
    Integer degree;
    Integer clazzId;
    Integer page;
    Integer pageSize;
}
