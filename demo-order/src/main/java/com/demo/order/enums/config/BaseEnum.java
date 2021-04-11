package com.demo.order.enums.config;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Field;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 19:51 2021/2/25
 */

//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public interface BaseEnum<E> {

		String DEFAULT_VALUE_NAME = "code";

		String DEFAULT_LABEL_NAME = "codeName";


		default Integer getCode() {
				Field field = ReflectionUtils.findField(this.getClass(), DEFAULT_VALUE_NAME);
				if (field == null) {
						return null;
				}
				try {
						field.setAccessible(true);
						return Integer.parseInt(field.get(this).toString());
				} catch (IllegalAccessException e) {
						throw new RuntimeException(e);
				}
		}

		@JsonValue
		default String getCodeName() {
				Field field = ReflectionUtils.findField(this.getClass(), DEFAULT_LABEL_NAME);
				if (field == null) {
						return null;
				}
				try {
						field.setAccessible(true);
						return field.get(this).toString();
				} catch (IllegalAccessException e) {
						throw new RuntimeException(e);
				}
		}

		static <T extends Enum<T>> T valueOfEnum(Class<T> enumClass, Integer value) {
				if (value == null) {
						throw new IllegalArgumentException("DisplayedEnum value should not be null");
				}
				if (enumClass.isAssignableFrom(BaseEnum.class)) {
						throw new IllegalArgumentException("illegal DisplayedEnum type");
				}
				T[] enums = enumClass.getEnumConstants();
				for (T t : enums) {
						BaseEnum baseEnum = (BaseEnum) t;
						if (baseEnum.getCode().equals(value)) {
								return (T) baseEnum;
						}

				}
				throw new IllegalArgumentException("cannot parse integer: " + value + " to " + enumClass.getName());
		}
}
