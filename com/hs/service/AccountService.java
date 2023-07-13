package com.hs.service;

import com.hs.po.Account;
import com.hs.vo.AccountVO;

import java.util.List;

/**
 * @author bilie
 * 账号业务逻辑接口
 */
public interface AccountService {

    public List<Account> findAll();

    public List<AccountVO> findVOAll();

    public Account findByAid(int aid);

    public AccountVO findVOByAid(int aid);

    public AccountVO findByAidAndPass(int aid, String pass);

    public AccountVO findByEid(int eid);

    public boolean add(Account account);

    public boolean update(Account account);

}
