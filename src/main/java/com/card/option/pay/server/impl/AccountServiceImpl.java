package com.card.option.pay.server.impl;

import com.card.option.pay.entity.Account;
import com.card.option.pay.dao.AccountMapper;
import com.card.option.pay.server.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangtao
 * @since 2020-09-14
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
