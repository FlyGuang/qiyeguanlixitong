package com.hs.dao;

import com.hs.po.Account;
import com.hs.vo.AccountVO;

import java.util.List;

/**
 * @author bilie
 * 账号数据访问接口
 */
public interface AccountDao {

    public List<Account> findAll();

    public List<AccountVO> findVOAll();

    public Account findByAid(int aid);

    public AccountVO findVOByAid(int aid);

    public AccountVO findByAidAndPass(int aid, String pass);

    public AccountVO findByEid(int eid);

    public int add(Account account);

    public int update(Account account);

}
