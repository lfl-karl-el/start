package com.example.user.dao.ext;

import com.example.user.entity.StartUserFeeInfo;

import java.util.List;

public interface StartUserExtMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table start_user_fee_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table start_user_fee_info
     *
     * @mbggenerated
     */
    int insert(StartUserFeeInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table start_user_fee_info
     *
     * @mbggenerated
     */
    StartUserFeeInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table start_user_fee_info
     *
     * @mbggenerated
     */
    List<StartUserFeeInfo> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table start_user_fee_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(StartUserFeeInfo record);
}