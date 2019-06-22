package com.xiaokun.appservice.bean;

/**
 * Created by 肖坤 on 2019/6/22.
 *
 * @author 肖坤
 * @date 2019/6/22
 */
public class TokenBean extends BaseBean {
    private Integer id;
    private String phone;
    private String token;
    /**
     * token过期时间
     */
    private long expiredeTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiredeTime() {
        return expiredeTime;
    }

    public void setExpiredeTime(long expiredeTime) {
        this.expiredeTime = expiredeTime;
    }
}
