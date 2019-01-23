package com.test.myself.common.mybatis.handle;

import com.test.myself.common.mybatis.enums.CityEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 类名称：CityTypeHandler<br>
 * 类描述：<br>
 * 创建时间：2018年10月15日<br>
 *
 * @author maopanpan
 * @version 1.0.0
 */
public class CityTypeHandler extends BaseTypeHandler<CityEnum> {
    @Override
    public CityEnum getNullableResult(ResultSet rSet, String columnName)
            throws SQLException {
        return CityEnum.get(rSet.getString(columnName));
    }

    @Override
    public CityEnum getNullableResult(ResultSet rSet, int columnIndex)
            throws SQLException {
        return CityEnum.get(rSet.getString(columnIndex));
    }

    @Override
    public CityEnum getNullableResult(CallableStatement cStatement, int columnIndex)
            throws SQLException {
        return CityEnum.get(cStatement.getNString(columnIndex));
    }

    @Override
    public void setNonNullParameter(PreparedStatement pStatement, int index,
                                    CityEnum cityEnum, JdbcType jdbcType) throws SQLException {
        pStatement.setString(index, cityEnum.getValue());
    }
}
