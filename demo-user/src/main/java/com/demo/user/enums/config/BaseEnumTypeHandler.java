package com.demo.user.enums.config;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BaseEnumTypeHandler<E extends BaseEnum> extends BaseTypeHandler<BaseEnum> {
		private Class<E> enumType;
		private Map<Integer, E> enumMap = new HashMap<>();

		public BaseEnumTypeHandler() {
		}

		public BaseEnumTypeHandler(Class<E> type) {
				if (type == null) {
						throw new IllegalArgumentException("Type argument cannot be null");
				}
				this.enumType = type;
				/*E[] enums = enumType.getEnumConstants();
				if (enums == null) {
						throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
				}
				for (E e : enums) {
						enumMap.put(e.getCode(), e);
				}*/
		}

		/**
		 * 设置非空的参数
		 *
		 * @param preparedStatement
		 * @param i
		 * @param baseEnum
		 * @param jdbcType
		 * @throws SQLException
		 */
		@Override
		public void setNonNullParameter(PreparedStatement preparedStatement, int i, BaseEnum baseEnum, JdbcType jdbcType) throws SQLException {
				preparedStatement.setInt(i, baseEnum.getCode());
		}

		/**
		 * 通过列名读取
		 *
		 * @param rs
		 * @param columnName
		 * @return
		 * @throws SQLException
		 */
		@Override
		public BaseEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
				return convert(rs.getInt(columnName));
		}

		/**
		 * 根据列索引，获取可以为空的结果
		 *
		 * @param rs
		 * @param columnIndex
		 * @return
		 * @throws SQLException
		 */
		@Override
		public BaseEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
				return convert(rs.getInt(columnIndex));
		}

		@Override
		public BaseEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
				return convert(cs.getInt(columnIndex));
		}


		private BaseEnum convert(int code) {
				BaseEnum[] objs = enumType.getEnumConstants();
				for (BaseEnum em : objs) {
						if (em.getCode() == code) {
								return em;
						}
				}
				throw new IllegalArgumentException("未知的枚举类型：" + code + ",请核对" + enumType.getSimpleName());
		}

}