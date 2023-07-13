package com.hs.dao;

import com.hs.po.Message;

import java.util.List;

/**
 * @author awei
 * 咨询用户信息数据访问接口
 */
public interface MessageDao {

    /**
     * 查找所有咨询用户信息
     * @return 咨询用户信息集合
     */
    public List<Message> findAll();

    /**
     * 通过编号查询咨询用户信息
     * @param id 咨询用户编号
     * @return 咨询用户信息
     */
    public Message findById(int id);

    /**
     * 通过电话查询咨询用户信息
     * @param tel 咨询用户电话
     * @return 咨询用户信息
     */
    public Message findByTel(String tel);

    /**
     * @param message 咨询用户信息
     * @return 受影响的行数
     */
    public int  add(Message message);

    /**
     * 修改用户反馈状态
     * @param message 用户对象
     * @return 受影响的行数
     */
    public int update(Message message);
}
