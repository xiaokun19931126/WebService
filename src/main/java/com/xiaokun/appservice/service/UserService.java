package com.xiaokun.appservice.service;


import com.xiaokun.appservice.bean.RestFulBean;
import com.xiaokun.appservice.bean.TokenBean;
import com.xiaokun.appservice.dao.TokenDao;
import com.xiaokun.appservice.dao.UserDao;
import com.xiaokun.appservice.bean.UserBean;
import com.xiaokun.appservice.util.MD5;
import com.xiaokun.appservice.util.RestFulUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 肖坤 on 2019/6/22.
 *
 * @author 肖坤
 * @date 2019/6/22
 */
@Transactional
public class UserService {

    public static final int TEN_SECONDS = 30 * 1000;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TokenDao tokenDao;

    public RestFulBean registorServer(UserBean userBean) {
        UserBean user = userDao.getUser(userBean.getPhone());
        if (user != null) {
            return RestFulUtil.getInstance().getResuFulBean(null, 1, "已经注册过了");
        } else {
            user = userDao.registor(userBean);
            if (user != null) {
                return RestFulUtil.getInstance().getResuFulBean(user, 0, "注册成功");
            } else {
                return RestFulUtil.getInstance().getResuFulBean(null, 1, "注册失败");
            }
        }
    }

    public RestFulBean<UserBean> login(String phone, String password) {
        RestFulBean user = userDao.login(phone, password);
        if (user != null) {
            if (user.getData() != null) {
                saveOrUpdateToken((UserBean) user.getData());
            }
            return user;
        } else {
            return RestFulUtil.getInstance().getResuFulBean(null, 1, "用户不存在");
        }
    }

    public RestFulBean<UserBean> userInfo(String phone) {
        UserBean user = userDao.getUser(phone);
        if (user != null) {
            return RestFulUtil.getInstance().getResuFulBean(user, 0, "获取成功");
        } else {
            return RestFulUtil.getInstance().getResuFulBean(null, 1, "用户不存在");
        }
    }

    /**
     * 只有登陆的时候才会调用此方法刷新token
     *
     * @param userBean
     */
    private void saveOrUpdateToken(UserBean userBean) {
        long time = System.currentTimeMillis();
        String token = null;
        try {
            token = MD5.encryptMD5(String.valueOf(time));
        } catch (Exception e) {
            e.printStackTrace();
        }
        userBean.setToken(token);
        //数据库获取是否有TokenBean
        TokenBean tokenBean = tokenDao.getTokenBean(userBean.getPhone());
        //如果token == null ，那么重新创建一个TokenBean
        if (tokenBean == null) {
            tokenBean = new TokenBean();
            tokenBean.setPhone(userBean.getPhone());
            tokenBean.setToken(userBean.getToken());
        } else {
            tokenBean.setToken(token);
        }
        //刷新过期时间
        tokenBean.setExpiredeTime(time + TEN_SECONDS);
        tokenDao.saveOrUpdageToken(tokenBean);
    }

}
