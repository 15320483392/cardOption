package com.card.option.pay.server.impl;

import com.card.option.pay.domain.dao.RoleMapper;
import com.card.option.pay.domain.entity.Role;
import com.card.option.pay.server.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
