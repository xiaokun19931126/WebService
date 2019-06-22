package com.xiaokun.appservice.action;

import com.xiaokun.appservice.bean.RestFulBean;
import com.xiaokun.appservice.bean.UserBean;
import com.xiaokun.appservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 肖坤 on 2019/6/22.
 *
 * @author 肖坤
 * @date 2019/6/22
 */
@Controller
@RequestMapping("/user")
public class UserAction {

    @Autowired
    private UserService userService;

    /**
     * 注册
     *
     * @param userBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register.do", method = RequestMethod.PUT)
    public RestFulBean<UserBean> register(@RequestBody UserBean userBean) {
        return userService.registorServer(userBean);
    }

    /**
     * 登陆
     *
     * @param phone
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/loginByPwd.do", method = RequestMethod.GET)
    public RestFulBean<UserBean> loginByPwd(@RequestParam String phone, @RequestParam String password) {
        return userService.login(phone, password);
    }

    /**
     * 用户详情
     *
     * @param phone
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userinfo.do", method = RequestMethod.GET)
    public RestFulBean<UserBean> userInfo(String phone) {
        return userService.userInfo(phone);
    }


}
