package com.test.myself.common.resultmap;

import com.test.myself.domain.AgrtInstanceSignature;
import lombok.Data;

import java.util.List;

/**
 * 类名称：AgrtInstMap<br>
 * 类描述：<br>
 * 创建时间：2018年10月17日<br>
 *
 * @author maopanpan
 * @version 1.0.0
 */
@Data
public class AgrtInstMap {
    private Long id;
    private String instanceName;
    List<AgrtInstanceSignature> agrtInstanceSignatures;
}
