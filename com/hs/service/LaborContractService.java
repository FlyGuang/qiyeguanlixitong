package com.hs.service;

import com.hs.po.LaborContract;
import com.hs.vo.LaborContractVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author awei
 * 劳动合同业务逻辑接口
 */

public interface LaborContractService{
    /**
     * @param eid 员工编号
     * @return 劳动合同对象
     */
    public List<LaborContract> findByEid(int eid);

    /**
     * @param lcsid 劳动合同状态编号
     * @return 劳动合同对象
     */
    public List<LaborContractVO> findVOByLcsid(int lcsid);
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
    public boolean add(LaborContract laborContract);

    /**
     * 更新合同
     * @param laborContract 劳动合同对象
     * @return 受影响的行数
     */
    public boolean update(LaborContract laborContract);

    public List<LaborContractVO> findVOByEid(int eid);
}
