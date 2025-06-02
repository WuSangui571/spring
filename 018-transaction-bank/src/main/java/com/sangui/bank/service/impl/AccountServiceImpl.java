package com.sangui.bank.service.impl;


import com.sangui.bank.mapper.AccountMapper;
import com.sangui.bank.pojo.Account;
import com.sangui.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-02
 * @Description:
 * @Version: 1.0
 */
@Transactional
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    AccountMapper accountMapper;

    @Override
    public int save(Account account) {
        return accountMapper.insert(account);
    }

    @Override
    public int deleteByActno(String actno) {
        return accountMapper.deleteByPrimaryKey(actno);
    }

    @Override
    public int modify(Account account) {
        return modify(account);
    }

    @Override
    public Account selectByActno(String actno) {
        return selectByActno(actno);
    }

    @Override
    public List<Account> selectAll() {
        return accountMapper.selectAll();
    }

    @Override
    public void transfer(String fromActno, String toActno, Double money) {
        // 1.查询转出账户的余额够不够。
        Account fromAccount = accountMapper.selectByPrimaryKey(fromActno);
        Double fromActnoBalance = fromAccount.getBalance();
        if (fromActnoBalance < money) {
            throw new RuntimeException("余额不足！！");
        }
        // 2.程序到这个位置，说明余额充足，现在内存中加减金额
        fromAccount.setBalance(fromActnoBalance - money);
        Account toAccount = accountMapper.selectByPrimaryKey(toActno);
        Double toActnoBalance = toAccount.getBalance();
        toAccount.setBalance(toActnoBalance + money);

        // 3.进行转账业务操作
        int count1 = accountMapper.updateByPrimaryKey(fromAccount);
        int count2 = accountMapper.updateByPrimaryKey(toAccount);
        if ((count1 + count2) != 2){
            throw new RuntimeException("未知错误，转账中止！");
        }
    }
}
