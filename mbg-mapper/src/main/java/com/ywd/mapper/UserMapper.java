package com.ywd.mapper;

import com.github.mybatis.mapper.GenericMapper;
import com.ywd.model.User;
import com.ywd.model.UserExample;

import java.util.List;

/**
 * 由MBG工具自动生成，添加与扩展XML文件中对应的同名方法
 **/
public interface UserMapper extends GenericMapper<User, UserExample, Integer> {

    List<User> findListByCreateTime(String startTime, String endTime, Integer begin, Integer pageSize, String order);
}