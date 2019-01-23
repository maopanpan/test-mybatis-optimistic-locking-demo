package com.test.myself.mapper;

import com.test.myself.BaseTestCase;
import com.test.myself.domain.AgrtOffsetTask;
import com.test.myself.domain.AgrtOffsetTaskInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类名称：AgrtOffsetTaskTest<br>
 * 类描述：<br>
 * 创建时间：2018年10月19日<br>
 *
 * @author maopanpan
 * @version 1.0.0
 */
public class AgrtOffsetTaskTest extends BaseTestCase {

    @Autowired
    private AgrtOffsetTaskMapper agrtOffsetTaskMapper;

    @Test
    public void select() {
        AgrtOffsetTask agrtOffsetTask = agrtOffsetTaskMapper.selectByPrimaryKey(507L);
        Assert.assertNotNull(agrtOffsetTask);
    }

    @Test
    public void selectAgrtOffsetTaskInfoById() {
        AgrtOffsetTaskInfo agrtOffsetTaskInfo = agrtOffsetTaskMapper.selectAgrtOffsetTaskInfoById(507L);
        Assert.assertNotNull(agrtOffsetTaskInfo);
    }
}
