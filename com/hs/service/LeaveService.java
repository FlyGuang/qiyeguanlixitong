package com.hs.service;
import com.hs.po.Leave;
import com.hs.vo.LeaveVO;

import java.util.List;

/**
 * @author km
 * 请假业务逻辑接口
 */

public interface LeaveService {
    /**
     * 新增请假
     *
     * @param leave
     * @return 是否删除成功
     */
    public boolean add(Leave leave);

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
     * @return 是否删除成功
     */
    public boolean delete(int lid);

    public boolean update(Leave leave);

    public List<LeaveVO> findVOByEid(int eid);

    public List<LeaveVO> findVOByAsid(int asid);
}