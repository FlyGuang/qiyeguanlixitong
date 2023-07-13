package com.hs.po;

import java.sql.Timestamp;

/**
 * @author awei
 * 咨询用户信息实体类
 */
public class Message {

    /**
     * 咨询用户编号
     */
    private int id;
    /**
     * 咨询用户名称
     */
    private String name;
    /**
     * 咨询用户电话
     */
    private String tel;
    /**
     * 咨询用户邮箱
     */
    private String email;
    /**
     * 用户咨询主题
     */
    private String subject;
    /**
     * 用户咨询内容
     */
    private String message;

    /**
     * 咨询用户提交信息时间
     */
    private Timestamp submittime;
    /**
     * 信息反馈
     */
    private String feedback;

    public Message() {
    }

    public Message(int id, String name, String tel, String email, String subject, String message, Timestamp submittime, String feedback) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.submittime = submittime;
        this.feedback = feedback;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Timestamp submittime) {
        this.submittime = submittime;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
