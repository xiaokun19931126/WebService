package com.xiaokun.appservice.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiaokun.appservice.bean.RestFulBean;
import com.xiaokun.appservice.bean.TokenBean;
import com.xiaokun.appservice.dao.TokenDao;
import com.xiaokun.appservice.util.RestFulUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 肖坤 on 2019/6/22.
 *
 * @author 肖坤
 * @date 2019/6/22
 */
public class RestFulInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenDao tokenDao;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        String uri = request.getRequestURI();
        Map<String, String> headerMaps = new HashMap<String, String>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            headerMaps.put(key, value);
        }
        //不是do结尾的不验证
        if (!uri.endsWith("do")) {
            return true;
        }
        //登陆不验证 user/loginByPwd.do
        if (uri.endsWith("user/loginByPwd.do")) {
            return true;
        }
        //注册不验证
        if (uri.endsWith("user/register.do")) {
            return true;
        }
        //支付回调不验证
        if (uri.endsWith("pay/verifyalipayresult.do")) {
            return true;
        }

        if (tokenDao.isTokenAvailable(headerMaps.get("phone"))) {
            return true;
        } else {
            RestFulBean resuFulBean = RestFulUtil.getInstance().getResuFulBean(null, 1, "用户身份验证失败");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(JSONObject.toJSONString(resuFulBean, SerializerFeature.WriteMapNullValue));
            return false;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e) throws Exception {

    }
}
