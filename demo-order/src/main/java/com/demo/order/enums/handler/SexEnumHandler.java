package com.demo.order.enums.handler;

import com.demo.order.enums.config.BaseEnumTypeHandler;
import com.demo.order.enums.moldtype.SexEnum;
import org.apache.ibatis.type.*;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 17:24 2021/2/25
 */
@MappedJdbcTypes(value=JdbcType.INTEGER,includeNullJdbcType = true)
@MappedTypes({SexEnum.class})
public class SexEnumHandler extends BaseEnumTypeHandler<SexEnum> {
		public SexEnumHandler(Class<SexEnum> type) {
				super(type);
		}
}
