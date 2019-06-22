package com.xiaokun.appservice.dao;

import com.xiaokun.appservice.bean.TokenBean;

/**
 * Created by 肖坤 on 2019/6/22.
 *
 * @author 肖坤
 * @date 2019/6/22
 */
public interface TokenDao {
    /**
     * 登录或注册时写入token
     *
     * @param tokenBean
     */
    void saveOrUpdageToken(TokenBean tokenBean);

    /**
     * 根据电话号码获取token
     *
     * @param phone
     * @return
     */
    TokenBean getTokenBean(String phone);

    /**
     * 根据电话号码获取token
     *
     * @param phone
     * @return
     */
    boolean isTokenAvailable(String phone);
}
