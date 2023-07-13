package com.hs.service;

import com.hs.po.Study;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author awei
 * 学习内容业务逻辑接口
 */
public interface StudyService {
    /**
     * 学习内容展示
     * @return 学习内容集合
     */
    public List<Study> findAll();

    /**
     * @param stuid 学习内容编号
     * @return 学习内容对象
     */
    public Study findByStuid(int stuid);

    /**
     * 学习内容新增
     * @return 受影响的行数
     */
    public boolean addStudy(Study study);

    /**
     * 学习内容更新（修改链接）
     * @return 受影响的行数
     */
    public boolean update(Study study);

    /**
     * 删除学习内容
     * @return 受影响的行数
     */
    public boolean delete(int stuid);
}
