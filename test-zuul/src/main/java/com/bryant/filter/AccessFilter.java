package com.bryant.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 简单的 zuul 过滤器，它实现了在请求被路由之前检查 HttpservletRequest 中是否有accessToken参数
 * 若有就进行路由，若没有就拒绝 访问，返回401 Unauthorized错误。
 */
public class AccessFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    private static final String FILTER_TYPE = "app token pre filter";

    /**
     * 过滤器的类型
     */
    @Override
    public String filterType() {
        return FILTER_TYPE;
    }

    /**
     * 过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，
     * 需要根据该方法返回的值来依次执行。
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要被执行
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     */
    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        logger.info("send () request to (]", request. getMethod () , request.getRequestURL () .toString ());

        String accessToken = request.getParameter("accessToken");
        if (StringUtils.isBlank(accessToken)) {
            logger.error("accessToken is empty..");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
        }

        logger.info("access token filter ok..");
        return null;
    }
}
