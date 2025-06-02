package com.sangui.bank.mapper;

import com.sangui.bank.pojo.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper {
    int deleteByPrimaryKey(String actno);

    int insert(Account record);

    int insertSelective(Account record);

    /**
     * 根据 账号 去查询 账户信息
     * @param actno 账号
     * @return 账户信息
     */
    Account selectByPrimaryKey(String actno);

    int updateByPrimaryKeySelective(Account record);

    /**
     * 更新账户信息
     * @param record 账户信息
     * @return 数据库更新条数
     */
    int updateByPrimaryKey(Account record);

    List<Account> selectAll();
}