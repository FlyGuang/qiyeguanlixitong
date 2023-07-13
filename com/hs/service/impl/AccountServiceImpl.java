package com.hs.service.impl;

import com.hs.dao.AccountDao;
import com.hs.po.Account;
import com.hs.service.AccountService;
import com.hs.vo.AccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bilie
 * 账号业务逻辑接口
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public List<AccountVO> findVOAll() {
        return accountDao.findVOAll();
    }

    @Override
    public Account findByAid(int aid) {
        return accountDao.findByAid(aid);
    }

    @Override
    public AccountVO findVOByAid(int aid) {
        return accountDao.findVOByAid(aid);
    }

    @Override
    public AccountVO findByAidAndPass(int aid, String pass) {
        return accountDao.findByAidAndPass(aid,pass);
    }

    @Override
    public AccountVO findByEid(int eid) {
        return accountDao.findByEid(eid);
    }

    @Override
    public boolean add(Account account) {
        account.setAstate("已启用");
        return accountDao.add(account)>0?true:false;
    }

    @Override
    public boolean update(Account account) {
        return accountDao.update(account)>0?true:false;
    }
}
