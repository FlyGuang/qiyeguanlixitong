package com.hs.dao;

import com.hs.po.PProgress;
import com.hs.vo.Progress;

import java.util.List;

/**
 * @author bilie
 * 项目进度数据访问接口
 */
public interface PProgressDao {

    /**
     * 查询所有方案进度
     * @return 方案进度集合
     */
    public List<PProgress> findall();

    /**
     * 查询进度,用来制作统计图
     * @return 项目进度纸盒
     */
    public List<Progress> findNum();

    /**
     * 根据方案进度编号查询方案对象
     * @param ppid 方案进度编号
     * @return 方案进度对象
     */
    public PProgress findByPpid(int ppid);

    /**
     * 新增项目进度
     * @param pProgress 项目进度对象
     * @return 受影响的行数
     */
    public int add(PProgress pProgress);

    /**
     * 修改项目进度
     * @param pProgress 项目进度对象
     * @return 受影响的行数
     */
    public int update(PProgress pProgress);

}
