package com.demo.user.enums.handler;

import com.demo.user.enums.config.BaseEnumTypeHandler;
import com.demo.user.enums.moldtype.SexEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

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
