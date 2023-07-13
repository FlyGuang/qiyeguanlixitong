package com.hs.service;

import com.hs.po.LaborContract;
import com.hs.po.LcState;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author awei
 * 劳动合同状态业务逻辑接口
 */

public interface LcStateService {
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
