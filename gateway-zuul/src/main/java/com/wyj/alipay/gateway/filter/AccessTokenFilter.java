package com.wyj.alipay.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created
 * Author: wyj
 * Email: 18346668711@163.com
 * Date: 2018/11/1
 */
public class AccessTokenFilter extends ZuulFilter {

    /*
     * pre-可以在请求被路由之前调用
     * route-在路由请求时候被调用
     * post-在route和error过滤器之后被调用
     * error-处理请求时发生错误时被调用
     *
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();

        HttpServletRequest request = requestContext.getRequest();

        String str = request.getParameter("accessToken");

        if (!StringUtils.isEmpty(str) && str.equals("admin")) {
            return null;
        }

        requestContext.setSendZuulResponse(false);
        requestContext.setResponseStatusCode(201);
        requestContext.setResponseBody("not authorized");
        return null;
    }
}
