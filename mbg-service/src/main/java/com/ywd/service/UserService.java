package com.ywd.service;

import com.ywd.mapper.UserMapper;
import com.ywd.model.User;
import com.ywd.model.UserExample;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ywd on 2019/8/14.
 */
@Service
@AllArgsConstructor
public class UserService {

    private UserMapper userMapper;

    public List<User> queryByExample(UserExample example) {
        return this.userMapper.selectByExample(example);
    }

    public List<User> queryAll() {
        return this.userMapper.selectByExample(null);
    }

    public List<User> findListByCreateTime(String startTime, String endTime, String begin, String pageSize, String order){
        return this.userMapper.findListByCreateTime(startTime, endTime, Integer.parseInt(begin)*Integer.parseInt(pageSize), Integer.parseInt(pageSize), order);
    }


}
