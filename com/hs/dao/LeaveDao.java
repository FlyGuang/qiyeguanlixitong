package com.hs.dao;

import com.hs.po.Leave;
import com.hs.vo.LeaveVO;

import java.util.List;

/**
 * @author jpc
 * 请假数据访问接口
 */
public interface LeaveDao {
    /**
     * 新增请假
     *
     * @param leave
     * @return 受影响行数
     */
    public int add(Leave leave);

    /**
     * 根据请假编号查询请假对象
     * @param lid 请假编号
     * @return 请假对象
     */
    public Leave findById(int lid);
    /**
     * 根据请假编号查询请假视图对象
     * @param lid 请假编号
     * @return 请假视图对象
     */
    public LeaveVO findVOById(int lid);

    /**
     * 查询请假视图集合
     * @return 请假对象视图集合
     */
    public List<LeaveVO> findVOAll();
    /**
     * 查询请假集合
     * @return 请假对象集合
     */
    public List<Leave> findAll();

    /**
     * 根据请假状态编号查询
     * @param lstate 请假编号
     * @return 请假对象
     */
    public List<Leave> findByLstate(String lstate);
    /**
     * 根据请假状态编号查询
     * @param lstate 请假编号
     * @return 请假视图对象
     */
    public List<LeaveVO> findVOByLstate(String lstate);

    /**
     * 删除请假
     * @param lid
     * @return 受影响行数
     */
    public int delete(int lid);

    public int update(Leave leave);

    public List<LeaveVO> findVOByEid(int eid);

    public List<LeaveVO> findVOByAsid(int asid);
}
