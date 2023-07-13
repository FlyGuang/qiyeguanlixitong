package com.hs.service;

import com.hs.po.Collect;
import com.hs.vo.CollectChartVo;
import com.hs.vo.CollectVO;

import java.util.List;
import java.util.Map;

/**
 * @author 陈晨
 * 收藏内容业务逻辑接口
 */
public interface CollectService {
    /**
     * 查找所有收藏内容
     * @return 收藏内容集合视图
     */
    public List<CollectVO> findVOAll();
    /**
     * 查找所有收藏内容
     * @return 收藏内容集合视图
     */
    public List<Collect> findAll();
    /**
     * 根据收藏内容编号查找收藏内容对象
     * @param cid 收藏内容编号
     * @return 收藏内容对象视图
     */
    public CollectVO findVOByCid(int cid);
    /**
     * 根据收藏内容编号查找收藏内容对象
     * @param cid 收藏内容编号
     * @return 收藏内容对象
     */
    public Collect findByCid(int cid);

    /**
     * 根据收藏夹编号查找收藏内容
     * @param bmid 收藏夹编号
     * @return 收藏内容集合视图
     */
    public List<CollectVO> findVOByBmid(int bmid);
    /**
     * 根据收藏夹编号查找收藏内容
     * @param bmid 收藏夹编号
     * @return 收藏内容集合视图
     */
    public List<Collect> findByBmid(int bmid);
    /**
     * 根据学习内容编号查找收藏内容
     * @param stuid 学习内容编号
     * @return 收藏内容对象视图
     */
    public CollectVO findVOByStuid(int stuid);
    /**
     * 根据学习内容编号查找收藏内容
     * @param stuid 学习内容编号
     * @return 收藏内容对象视图
     */
    public Collect findByStuid(int stuid);
    /**
     * 新增收藏内容
     * @param collect 收藏内容对象
     * @return 是否新增成功
     */
    public boolean add(Collect collect);

    /**
     * 更改收藏内容信息
     * @param collect 收藏内容对象
     * @return 是否更新成功
     */
    public boolean update(Collect collect);

    /**
     * 删除收藏的内容
     * @param array 收藏内容编号数组
     * @return 是否删除成功
     */
    public boolean delete(int[] array);
    /**
     * 饼状图
     * @return 收藏内容数据集合
     */
    public List<CollectChartVo> findStat();
    /**
     * 条形图
     * @return 收藏内容集合
     */
    public Map<String,List> findBar();
}
