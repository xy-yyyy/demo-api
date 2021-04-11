package com.demo.user.controller.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import dubbo.DubboProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Dubbo消费端Demo
 * @Author: sunYF
 * @Description:
 * @Date: Create in 15:07 2020/8/28
 */
@RequestMapping("/dubbo")
@RestController
@Slf4j
public class DubboConsumerController {

    @Reference
    DubboProviderService dubboProviderService;

    @GetMapping(value = "/hello")
    @ResponseBody
    public String index(@RequestParam("name") String name) {
        return dubboProviderService.hello(name);
    }

    @GetMapping(value = "/testMapList")
    @ResponseBody
    public List<Map<String, Object>> testMapList() {
        Map<String, Object> map = new HashMap<>();
        map.put("hello", "nacos-dubbo");
        return dubboProviderService.testMapList(map);
    }


}
