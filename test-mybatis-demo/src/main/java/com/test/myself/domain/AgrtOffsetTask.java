package com.test.myself.domain;

import lombok.Data;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table agrt_offset_task
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
public class AgrtOffsetTask {
    /**
     * Database Column Remarks:
     *   任务ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column agrt_offset_task.task_id
     *
     * @mbg.generated
     */
    private Long taskId;

    /**
     * Database Column Remarks:
     *   中台token
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column agrt_offset_task.token
     *
     * @mbg.generated
     */
    private String token;

    /**
     * Database Column Remarks:
     *   订单编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column agrt_offset_task.order_sn
     *
     * @mbg.generated
     */
    private String orderSn;

    /**
     * Database Column Remarks:
     *   合同ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column agrt_offset_task.agrt_inst_id
     *
     * @mbg.generated
     */
//    private Long agrtInstId;

    /**
     * Database Column Remarks:
     *   补偿次数
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column agrt_offset_task.offset_num
     *
     * @mbg.generated
     */
    private Integer offsetNum;

    /**
     * Database Column Remarks:
     *   0：初始化；1：完成；2：失败
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column agrt_offset_task.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column agrt_offset_task.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   更新时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column agrt_offset_task.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   操作人ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column agrt_offset_task.opt_id
     *
     * @mbg.generated
     */
    private Long optId;

    private AgrtInstance agrtInstance;
}