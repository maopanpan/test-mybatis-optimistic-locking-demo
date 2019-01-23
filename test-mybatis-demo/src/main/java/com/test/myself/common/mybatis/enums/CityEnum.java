package com.test.myself.common.mybatis.enums;

/**
 * 类名称：CityEnum<br>
 * 类描述：<br>
 * 创建时间：2018年10月15日<br>
 *
 * @author maopanpan
 * @version 1.0.0
 */
public enum CityEnum {
    ChangSha("4301"),Zhuzhou("4302"),Xiangtan("4303");

    private String value;

    CityEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    /*方法Value2CityTest是为了typeHandler后加的*/
    public static CityEnum get(String value) {
        for (CityEnum cityEnum : CityEnum.class.getEnumConstants()) {
            if (cityEnum.value.equals(value)) {
                return cityEnum;
            }
        }
        throw new IllegalArgumentException("无效的value值: " + value + "!");
    }

}
