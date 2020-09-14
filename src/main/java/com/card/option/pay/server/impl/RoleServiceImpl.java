package com.card.option.pay.server.impl;

import com.card.option.pay.entity.Role;
import com.card.option.pay.dao.RoleMapper;
import com.card.option.pay.server.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
