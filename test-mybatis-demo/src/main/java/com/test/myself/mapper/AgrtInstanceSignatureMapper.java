package com.test.myself.mapper;

import com.test.myself.domain.AgrtInstanceSignature;

import java.util.List;

public interface AgrtInstanceSignatureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agrt_instance_signature
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agrt_instance_signature
     *
     * @mbg.generated
     */
    int insert(AgrtInstanceSignature record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agrt_instance_signature
     *
     * @mbg.generated
     */
    AgrtInstanceSignature selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agrt_instance_signature
     *
     * @mbg.generated
     */
    List<AgrtInstanceSignature> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agrt_instance_signature
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(AgrtInstanceSignature record);
}