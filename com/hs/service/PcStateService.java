package com.hs.service;

import com.hs.po.PContract;
import com.hs.po.PcState;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bilie
 * 项目合同状态业务逻辑接口
 */

public interface PcStateService {

    /**
     * 通过项目合同状态编号查询项目合同对象
     * @param pcsid 项目合同编号
     * @return 项目合同的对象集合
     */
    public PcState findByPcsid(int pcsid);

    /**
     * 查询所有的项目合同状态
     * @return 项目合同状态的集合
     */
    public List<PcState> findAll();

}
