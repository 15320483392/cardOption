package com.card.option.pay.server.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.card.option.pay.domain.dao.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.card.option.pay.domain.entity.User;
import com.card.option.pay.server.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangtao
 * @since 2020-09-14
 */
@Slf4j
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
