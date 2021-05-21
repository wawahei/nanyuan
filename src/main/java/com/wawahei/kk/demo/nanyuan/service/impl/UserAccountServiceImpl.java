package com.wawahei.kk.demo.nanyuan.service.impl;

import com.wawahei.kk.demo.nanyuan.entity.UserAccount;
import com.wawahei.kk.demo.nanyuan.mapper.UserAccountMapper;
import com.wawahei.kk.demo.nanyuan.service.IUserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账户 服务实现类
 * </p>
 *
 * @author wawahei
 * @since 2021-05-21
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements IUserAccountService {

}
