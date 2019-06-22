package com.xiaokun.appservice.dao;

import com.xiaokun.appservice.bean.TokenBean;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by 肖坤 on 2019/6/22.
 *
 * @author 肖坤
 * @date 2019/6/22
 */
public class TokenDaoImpl extends HibernateDaoSupport implements TokenDao {

    public void saveOrUpdageToken(TokenBean tokenBean) {
        this.getHibernateTemplate().saveOrUpdate(tokenBean);
    }

    public TokenBean getTokenBean(String phone) {
        List<TokenBean> tokenBeanList = (List<TokenBean>) this.getHibernateTemplate().find("from TokenBean where phone =?", phone);
        if (tokenBeanList != null && tokenBeanList.size() > 0) {
            return tokenBeanList.get(0);
        }
        return null;
    }

    public boolean isTokenAvailable(String phone) {
        TokenBean tokenBean = getTokenBean(phone);
        if (tokenBean == null) {
            return false;
        } else {
            if (System.currentTimeMillis() > tokenBean.getExpiredeTime()) {
                //token已过期
                return false;
            } else {
                return true;
            }
        }
    }
}
