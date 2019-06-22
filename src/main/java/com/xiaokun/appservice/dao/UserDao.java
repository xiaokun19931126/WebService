package com.xiaokun.appservice.dao;

import com.xiaokun.appservice.bean.RestFulBean;
import com.xiaokun.appservice.bean.UserBean;

/**
 * Created by 肖坤 on 2019/6/22.
 *
 * @author 肖坤
 * @date 2019/6/22
 */
public interface UserDao {

    /**
     * 注册
     *
     * @param userBean
     */
    UserBean registor(UserBean userBean);

    /**
     * 登陆
     *
     * @return
     */
    RestFulBean login(String phone, String password);

    /**
     * 根据名字获取用户信息
     *
     * @param phone
     * @return
     */
    UserBean getUser(String phone);
}
