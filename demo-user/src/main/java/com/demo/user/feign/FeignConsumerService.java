package com.demo.user.feign;

/**
 * @Author: sunYF
 * @Description:定义服务绑定接口
 * @Date: Create in 14:06 2020/8/28
 */

import com.demo.common.vo.ErrorCode;
import com.demo.common.vo.ResultPojo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "demo-order",fallback = FeignConsumerService.DefaultFallback.class)
@Service
public interface FeignConsumerService {

    /**
     *  服务名+上下文 TODO 计划去掉上下文
     *
     *  @param
     *  @return
     *  @date 2019/8/15 1:11
     */
    @GetMapping("/order/hello")
    ResultPojo hello(@RequestParam("userId") String userId);


    /**
     * 容错处理类，当调用失败时，简单返回空字符串
     */
    @Component
   class DefaultFallback implements FeignConsumerService{

        @Override
        public ResultPojo hello(String userId) {
            return ResultPojo.builder().code(ErrorCode.ERROR.getCode()).message(ErrorCode.ERROR.getMsg()).object("feign callback").build();
        }
    }
}
