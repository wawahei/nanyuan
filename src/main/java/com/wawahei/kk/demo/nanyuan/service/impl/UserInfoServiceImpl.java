package com.wawahei.kk.demo.nanyuan.service.impl;

import com.wawahei.kk.demo.nanyuan.pojo.entity.UserInfo;
import com.wawahei.kk.demo.nanyuan.mapper.UserInfoMapper;
import com.wawahei.kk.demo.nanyuan.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户基本信息 服务实现类
 * </p>
 *
 * @author wawahei
 * @since 2021-05-21
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
