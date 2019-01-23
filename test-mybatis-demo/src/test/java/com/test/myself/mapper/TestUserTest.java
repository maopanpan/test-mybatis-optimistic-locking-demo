package com.test.myself.mapper;

import com.test.myself.BaseTestCase;
import com.test.myself.common.mybatis.enums.CityEnum;
import com.test.myself.common.resultmap.AgrtInstMap;
import com.test.myself.domain.AgrtInstance;
import com.test.myself.domain.AgrtInstanceSignature;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 类名称：TestUserTest<br>
 * 类描述：<br>
 * 创建时间：2018年10月15日<br>
 *
 * @author maopanpan
 * @version 1.0.0
 */
public class TestUserTest extends BaseTestCase {

    @Autowired
    private AgrtInstanceMapper agrtInstanceMapper;

    @Test
    public void selectAgrtInstById() {
        AgrtInstance agrtInstance = agrtInstanceMapper.selectByPrimaryKey(2082L);
        List<AgrtInstanceSignature> agrtInstanceSignatures = agrtInstance.getAgrtInstanceSignatureList();
        for(AgrtInstanceSignature agrtInstanceSignature:agrtInstanceSignatures) {
            Long id = agrtInstanceSignature.getAgrtInstanceId();
            Assert.assertNotNull(agrtInstanceSignature);
        }
        Assert.assertNotNull(agrtInstance);
    }
    @Test
    public void selectAgrtInstById1() {
        AgrtInstMap agrtInstMap = agrtInstanceMapper.selectAgrtInstById(2082L);
        Assert.assertNotNull(agrtInstMap);
    }

}
