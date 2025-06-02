package com.sangui.bank.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * t_act
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    /**
     * 账号
     */
    private String actno;

    /**
     * 余额
     */
    private Double balance;

    private static final long serialVersionUID = 1L;
}