package com.demo.order.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: sunYF
 * @Description:
 * 该接口不能被扫描到，否则会出错
 * 继承通用mapper的增上改查，进行扩张
 * @Date: Create in 11:19 2020/8/27
 */
public interface MySqlBaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
