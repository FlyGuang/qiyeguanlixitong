package com.hs.dao;

import com.hs.po.PContract;
import com.hs.vo.PContractVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author bilie
 * @author km
 * 项目合同数据访问接口
 */
public interface PContractDao {

    /**
     * 查询所有的项目合同
     * @return 项目合同的结合
     */
    public List<PContract> findAll();
    /**
     * 查询所有的项目合同视图
     * @return 项目合同视图的集合
     */
    public List<PContractVO> findVOAll();
    /**
     * 根据主键查询
     * @param id 主键
     * @return 项目合同对象
     */
    public PContract findById(int id);
    /**
     * 根据项主键查询视图
     * @param id 主键
     * @return 项目合同视图对象
     */
    public PContractVO findVOById(int id);
    /**
     * 根据项目合同编号查询
     * @param pcid 项目合同编号
     * @return 项目合同对象
     */
    public PContract findByPcid(String pcid);
    /**
     * 根据项目合同编号查询视图
     * @param pcid 项目合同编号
     * @return 项目合同视图对象
     */
    public PContractVO findVOByPcid(String pcid);

    /**
     * 根据合作伙伴查询项目集合
     * @param partner 合作伙伴
     * @return 项目合同的集合
     */
    public List<PContract> findByPartner(@Param("partner") String partner);
    /**
     * 根据合作伙伴查询项目视图集合
     * @param partner 合作伙伴
     * @return 项目合同视图的集合
     */
    public List<PContractVO> findVOByPartner(@Param("partner")String partner);

    /**
     * 新建项目合同
     * @param pContract 项目合同对象
     * @return 受影响的行数
     */
    public int add(PContract pContract);

    /**
     * 修改项目合同状态
     * @param pContract 项目合同对象
     * @return 受影响的行数
     */
    public int update(PContract pContract);

    /**
     * 根据项目编号查询项目合同
     * @param pid 项目编号
     * @return 项目合同对象
     */
    public List<PContract> findByPid(int pid);
    /**
     * 根据项目编号查询项目合同视图
     * @param pid 项目编号
     * @return 项目合同视图对象
     */
    public List<PContractVO> findVOByPid(int pid);

}
