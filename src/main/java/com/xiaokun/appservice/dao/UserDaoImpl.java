package com.xiaokun.appservice.dao;

import com.xiaokun.appservice.bean.RestFulBean;
import com.xiaokun.appservice.bean.UserBean;
import com.xiaokun.appservice.util.RestFulUtil;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by 肖坤 on 2019/6/22.
 *
 * @author 肖坤
 * @date 2019/6/22
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    public UserBean registor(UserBean userBean) {
        this.getHibernateTemplate().save(userBean);
        return getUser(userBean.getPhone());
    }

    public RestFulBean login(String phone, String password) {
        List<UserBean> users = (List<UserBean>) this.getHibernateTemplate().find(
                "from UserBean where phone=?", phone);
        if (users != null && users.size() > 0) {
            UserBean userBean = users.get(0);
            if (userBean.getPassword().equals(password)) {
                return RestFulUtil.getInstance().getResuFulBean(userBean, 0, "登陆成功");
            } else {
                return RestFulUtil.getInstance().getResuFulBean(null, 2, "用户名或密码错误");
            }
        }
        return null;
    }

    public UserBean getUser(String phone) {
        List<UserBean> users = (List<UserBean>) this.getHibernateTemplate().find("from UserBean where phone=?", phone);
        if (users != null && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }
}
