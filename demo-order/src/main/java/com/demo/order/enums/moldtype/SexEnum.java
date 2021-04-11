package com.demo.order.enums.moldtype;

import com.demo.order.enums.config.BaseEnum;
import lombok.Getter;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 17:25 2021/2/25
 */
@Getter
public enum SexEnum implements BaseEnum  {
		MAN(0, "男"),
		WOMAN(1, "女");
		private Integer code;
		private String codeName;
		SexEnum(Integer code, String codeName) {
				this.code = code;
				this.codeName = codeName;
		}
}
