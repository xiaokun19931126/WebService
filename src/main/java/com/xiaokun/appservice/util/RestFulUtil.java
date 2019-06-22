package com.xiaokun.appservice.util;

import com.xiaokun.appservice.bean.RestFulBean;

/**
 * Created by 肖坤 on 2019/6/22.
 *
 * @author 肖坤
 * @date 2019/6/22
 */
public class RestFulUtil<T> {

    private RestFulUtil() {
    }

    public static RestFulUtil getInstance() {
        return new RestFulUtil();
    }

    public RestFulBean<T> getResuFulBean(T o, int status, String msg) {
        RestFulBean<T> objectRestFulBean = new RestFulBean<T>();
        objectRestFulBean.setStatus(status);
        objectRestFulBean.setMsg(msg);
        objectRestFulBean.setData(o);
        return objectRestFulBean;
    }
}
