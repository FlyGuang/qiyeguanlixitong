package com.hs.dao;

import com.hs.po.Scheme;
import com.hs.vo.SchemeVO;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

/**
 * @author bilie
 * 项目方案数据接口
 */
public interface SchemeDao {

    /**
     * 查询所有的项目方案
     * @return 项目方案的集合
     */
    public List<Scheme> findAll();

    /**
     * 查询所有项目方案的视图
     * @return 方案视图的集合
     */
    public List<SchemeVO> findVOAll();

    /**
     * 根据项目编号查询项目方案
     * @param pid 项目编号
     * @return 项目方案的集合
     */
    public List<Scheme> findByPid(int pid);

    /**
     * 根据项目方案编号查询方案
     * @param scid 方案编号
     * @return 项目方案对象
     */
    public Scheme findByScid(int scid);

    /**
     * @param scid 方案编号
     * @return 项目方案VO对象
     */
    public SchemeVO findByScidVO(int scid);
    /**
     * 修改项目方案状态及内容
     * @param scheme 项目方案对象
     * @return 受影响的行数
     */
    public int update(Scheme scheme);

    /**
     * 添加项目方案
     * @param scheme 项目方案对象
     * @return 受影响的行数
     */
    public int add(Scheme scheme);



}
