package com.order.system.customerService.service.impl;

import com.alibaba.fastjson.JSON;
import com.order.system.customerService.client.CacheHystrixService;
import com.order.system.customerService.common.query.UserRegRequest;
import com.order.system.customerService.common.vo.UserInfoVO;
import com.order.system.customerService.dao.UserInfoMapper;
import com.order.system.customerService.model.UserInfo;
import com.order.system.customerService.service.IUserInfoService;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.order.system.common.core.AbstractService;
import com.order.system.common.result.ServiceResult;
import com.order.system.common.utils.BeanUtils;
import com.order.system.common.utils.MD5Utils;
import com.order.system.common.utils.StringUtil;
import com.order.system.common.utils.UUIDUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

/**
 * @author: zhonghao
 * @date: 2019/01/23 11:36:32
 * @description: UserInfo服务实现
 */
@Service
//@Transactional
public class UserInfoServiceImpl extends AbstractService<UserInfo> implements IUserInfoService {
    @Resource
    private UserInfoMapper tUserInfoMapper;

    @Autowired
    CacheHystrixService cacheHystrixService;

    /**
     * 登录超时时间，单位为分
     */
    @Value("${loginExpireTime:60}")
    private Long loginExpireTime;

    @Override
    public boolean register(UserRegRequest userInfoQuery) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoQuery, userInfo, "password"); // 除去password字段，其他的字段复制到UserInfo
        String salt = StringUtil.getRandomString(10); // random salt
        String passwordMD5 = MD5Utils.md5Hex(userInfoQuery.getPassword(), salt); // md5
        // password
        userInfo.setPassword(passwordMD5);
        userInfo.setSalt(salt);
        return tUserInfoMapper.insert(userInfo) > 0;

    }

    @Override
    public ServiceResult loginByPhoneORAccount(String phone, String account, String password) {
        UserInfo userInfoParam = new UserInfo();
        if (StringUtil.isNotBlank(phone)) {
            userInfoParam.setUserPhone(phone);
        }
        if (StringUtil.isNotBlank(account)) {
            userInfoParam.setAccount(account);
        }
        List<UserInfo> userInfoGroup = tUserInfoMapper.select(userInfoParam);
        if (CollectionUtils.isEmpty(userInfoGroup)) {
            return ServiceResult.error(StringUtil.isNotBlank(phone) ? "手机号码不存在！" : "账号不存在！");
        }

        UserInfo userInfo = userInfoGroup.get(0);
        String passwordMD5 = MD5Utils.md5Hex(password, userInfo.getSalt());

        // valid password
        if (!Objects.equals(userInfo.getPassword(), passwordMD5)) {
            return ServiceResult.error("密码不正确");
        }

        UserInfoVO userInfoVO = UserInfoVO.bulidUserInfoVO(userInfo);

        // uuid 作为登陆密钥
        String loginSecret = UUIDUtils.generateShortUuid();

        CacheLoginfoToRedis(loginSecret, userInfoVO);

        return ServiceResult.success(Maps.newHashMap().put("loginSecret", loginSecret));
    }

    // 将登陆信息写入到redis
    private void CacheLoginfoToRedis(String loginSecret, UserInfoVO userInfoVO) {
        System.out.println(JSON.toJSONString(userInfoVO));

        ServiceResult cacheResult = cacheHystrixService.cacheLoginInfo(loginSecret, userInfoVO, loginExpireTime);
        //Preconditions.checkArgument(cacheResult.getCode() == 200, "登陆信息写入到redis 异常");
    }
}
