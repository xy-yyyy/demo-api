package com.demo.user.config;

import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

import java.io.IOException;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 14:51 2020/10/15
 */
@Slf4j
public class SeataRestTemplateInterceptor implements ClientHttpRequestInterceptor {

    /**
     * RestTemplate请求拦截器
     * 在头部设置全局事务ID
     * @param request request
     * @param body 书序
     * @param execution ClientHttpRequestExecution
     * @return ClientHttpResponse
     * @throws IOException 异常
     */
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpRequestWrapper requestWrapper = new HttpRequestWrapper(request);
        String xid = RootContext.getXID();
        if (StringUtils.isNotBlank(xid)) {
            requestWrapper.getHeaders().add(RootContext.KEY_XID, xid);
            log.info("分布式事务 xid:{}", xid);
        }
        return execution.execute(requestWrapper, body);
    }

}
