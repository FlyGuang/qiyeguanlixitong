package com.hs.dao;


import com.hs.po.PContract;
import com.hs.po.PcState;

import java.util.List;

/**
 * @author awei
 * 项目合同状态数据访问接口
 */
public interface PcStateDao {

    /**
     * 通过项目合同状态编号查询项目合同状态对象
     * @param pcsid 项目合同状态编号
     * @return 项目合同集合
     */
    public PcState findByPcsid(int pcsid);

    /**
     * 查询所有项目合同状态
     * @return 项目状态集合
     */
    public List<PcState> findAll();
}
