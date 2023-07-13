package com.hs.dao;

import com.hs.po.LaborContract;
import com.hs.po.LcState;

import java.util.List;

/**
 * @author awei
 * 劳动合同状态数据访问接口
 */
public interface LcStateDao {

    /**
     * 查询所有劳动合同状态
     * @return 劳动合同状态集合
     */
    public List<LcState> findAll();

    /**
     * 通过劳动合同状态查询劳动合同
     * @param lcsid 劳动合同状态编号
     * @return 劳动合同对象
     */
    public LcState findByLcsid(int lcsid);

}
