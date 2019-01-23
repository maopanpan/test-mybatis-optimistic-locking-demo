package com.test.myself.domain;

import lombok.Data;

/**
 * 类名称：AgrtOffsetTaskInfo<br>
 * 类描述：<br>
 * 创建时间：2018年10月19日<br>
 *
 * @author maopanpan
 * @version 1.0.0
 */
@Data
public class AgrtOffsetTaskInfo {
    private Long taskId;
    private String token;
    private String orderSn;
    private AgrtInstanceInfo agrtInstanceInfo;
}
