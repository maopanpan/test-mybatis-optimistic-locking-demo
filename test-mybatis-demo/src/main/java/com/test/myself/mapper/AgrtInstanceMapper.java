package com.test.myself.mapper;

import com.test.myself.common.resultmap.AgrtInstMap;
import com.test.myself.domain.AgrtInstance;
import com.test.myself.domain.AgrtInstanceInfo;

import java.util.List;

public interface AgrtInstanceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agrt_instance
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agrt_instance
     *
     * @mbg.generated
     */
    int insert(AgrtInstance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agrt_instance
     *
     * @mbg.generated
     */
    AgrtInstance selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agrt_instance
     *
     * @mbg.generated
     */
    List<AgrtInstance> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agrt_instance
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(AgrtInstance record);

    AgrtInstMap selectAgrtInstById(Long id);

    AgrtInstanceInfo selectAgrtInstInfoById(Long id);
}