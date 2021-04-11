package com.demo.basic.config;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 14:53 2020/10/15
 */
@Slf4j
public class SeataFeignClientInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String xid = RootContext.getXID();
        if (StringUtils.isNotBlank(xid)) {
            requestTemplate.header(RootContext.KEY_XID, xid);
            log.info("分布式事务 xid:{}", xid);
        }
    }

}