package com.demo.order.service.impl.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import dubbo.DubboProviderService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 14:02 2020/11/30
 */
@Service
public class DubboProviderServiceImpl implements DubboProviderService {
		@Override
		public String hello(String name) {
				return "testOrderModel";
		}

		@Override
		public List<Map<String, Object>> testMapList(Map<String, Object> map) {
				List<Map<String, Object>> list = new ArrayList<>();
				Map<String , Object> map1=new HashMap<>();
				map1.put("test1","test1");
				map1.put("test2","test2");
				map1.put("test3","test3");
				list.add(map1);
				return list;
		}
}
