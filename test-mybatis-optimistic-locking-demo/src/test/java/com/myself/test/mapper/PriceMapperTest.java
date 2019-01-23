package com.myself.test.mapper;

import com.myself.test.BaseTestCase;
import com.myself.test.domain.Price;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类名称：PriceMapperTest<br>
 * 类描述：<br>
 * 创建时间：2019年01月22日<br>
 *
 * @author maopanpan
 * @version 1.0.0
 */
public class PriceMapperTest extends BaseTestCase {
    @Autowired
    private PriceMapper priceMapper;

    @Test
    public void queryTest() {
        Price price = priceMapper.selectByPrimaryKey(1);
        price.setStatus(2);
        priceMapper.updateByPrimaryKey(price);
        Assert.assertNotNull(price);
    }
}
