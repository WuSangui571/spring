package com.sangui.bank.service;


import com.sangui.bank.pojo.Account;

import java.util.List;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-02
 * @Description: 业务接口
 * @Version: 1.0
 */
public interface AccountService {
    /**
     * 转账业务方法
     * @param fromActno 从这个账户扣钱
     * @param toActno 从这个账户加钱
     * @param money 钱的大小
     */
    void transfer(String fromActno, String toActno,Double money);

    /**
     * 添加账户
     * @param account 账户对象
     * @return 数据库改变条数
     */
    int save(Account account);

    /**
     * 通过账户名称删除账户
     * @param actno 账户名称
     * @return 数据库改变条数
     */
    int deleteByActno(String actno);

    /**
     * 修改账户
     * @param account 修改后的账户对象
     * @return 数据库改变条数
     */
    int modify(Account account);

    /**
     * 通过账户号查询账户信息
     * @param actno 账户号
     * @return 账户对象
     */
    Account selectByActno(String actno);

    /**
     * 查询所有账户
     * @return 账户List
     */
    List<Account> selectAll();
}
