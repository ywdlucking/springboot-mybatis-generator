package com.ywd.web;

import com.ywd.model.User;
import com.ywd.model.UserExample;
import com.ywd.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ywd on 2019/8/14.
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping("/v1/admin")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("list")
    @ApiOperation(value = "获取用户列表")
    public List<User> list() {
        return userService.queryAll();
    }

    @GetMapping("query")
    @ApiOperation(value = "获取用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "分页页码", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "分页大小", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "时间", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "时间", dataType = "String")}
    )
    public List<User> query(
            @RequestParam(value = "startTime") String startTime,
            @RequestParam(value = "endTime") String endTime,
            @RequestParam(value = "pageNum") String pageNum,
            @RequestParam(value = "pageSize") String pageSize) {
        return userService.findListByCreateTime(startTime,endTime,pageNum,pageSize, "create_time");
    }
}
