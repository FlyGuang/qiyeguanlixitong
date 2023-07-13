package com.hs.service.impl;

import com.hs.dao.MessageDao;
import com.hs.po.Message;
import com.hs.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author awei
 * 咨询用户信息业务逻辑实现类
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageDao messageDao;

    @Override
    public List<Message> findAll() {
        return messageDao.findAll();
    }

    @Override
    public Message findById(int id) {
        return messageDao.findById(id);
    }

    @Override
    public Message findByTel(String tel) {
        return messageDao.findByTel(tel);
    }

    @Override
    public boolean add(Message message) {
        message.setSubmittime(new Timestamp(System.currentTimeMillis()));
        message.setFeedback("未反馈");
        return messageDao.add(message)>0?true:false;
    }

    @Override
    public boolean update(Message message) {
        return messageDao.update(message)>0?true:false;
    }
}
