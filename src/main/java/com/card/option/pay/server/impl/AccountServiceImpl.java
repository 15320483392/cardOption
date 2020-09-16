package com.card.option.pay.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.card.option.pay.domain.dao.AccountMapper;
import com.card.option.pay.domain.entity.Account;
import com.card.option.pay.server.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author WTar
 * @date 2020/9/16 16:48
 */
@Slf4j
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
