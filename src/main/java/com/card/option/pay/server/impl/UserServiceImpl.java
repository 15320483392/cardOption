package com.card.option.pay.server.impl;

import com.card.option.pay.entity.User;
import com.card.option.pay.dao.UserMapper;
import com.card.option.pay.server.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
