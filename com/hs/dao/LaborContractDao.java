package com.hs.dao;

import com.hs.po.LaborContract;
import com.hs.vo.LaborContractVO;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

/**
 * @author awei
 * 劳动合同数据访问接口
 */
public interface LaborContractDao {

    /**
     * @param eid 员工编号
     * @return 劳动合同对象
     */
    public List<LaborContract> findByEid(int eid);

    /**
     * @param lcid 劳动合同编号
     * @return 劳动合同视图对象
     */
    public LaborContractVO findVOByLcid(String lcid);

    /**
     * @param lcid 劳动合同编号
     * @return 劳动合同对象
     */
    public LaborContract findByLcid(String lcid);

    /**
     * @param lcsid 劳动合同状态编号
     * @return 劳动合同对象
     */
    public List<LaborContractVO> findVOByLcsid(int lcsid);

    /**
     * 查询所有劳动合同
     * @return 劳动合同集合
     */
    public List<LaborContract> findAll();

    /**
     * 查询所有劳动合同VO
     * @return 劳动合同集合
     */
    public List<LaborContractVO> findAllVO();
    /**
     * 添加劳动合同
     * @return 受影响的行数
     */
    public int add(LaborContract laborContract);

    /**
     * 更新合同
     * @param laborContract 劳动合同对象
     * @return 受影响的行数
     */
    public int update(LaborContract laborContract);

    public List<LaborContractVO> findVOByEid(int eid);
}
