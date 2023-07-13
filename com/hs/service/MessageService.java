package com.hs.service;

import com.hs.po.Message;

import java.util.List;

/**
 * @author awei
 * 咨询用户信息业务逻辑接口
 */
public interface MessageService {
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
    public boolean  add(Message message);

    /**
     * 修改咨询用户的状态
     * @param message 咨询用户对象
     * @return 是否修改成功
     */
    public boolean update(Message message);
}
