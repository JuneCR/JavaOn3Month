package com.june.mapper;

import com.june.pojo.Employee;

/*
* 规定数据库方法即可
* */
public interface EmployeeMapper {
    Employee queryById(Integer id);
    int deleteById(Integer id);
}
