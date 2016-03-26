package com.wechat.service.impl;

import com.wechat.annotation.Token;
import com.wechat.config.AccessTokenSetting;
import com.wechat.constant.UrlConstant;
import com.wechat.po.UserInfo;
import com.wechat.service.IUserInfoService;
import com.wechat.util.HttpClientUtil;
import com.wechat.util.JackonUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户基本信息接口实现
 * Created by fusj on 15/12/22.
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private AccessTokenSetting accessTokenSetting;

    /**
     * 根据openId查询用户信息
     * @param openId
     * @return
     */
    @Token
    public UserInfo queryUserInfo(String openId) throws Exception {
        String token = accessTokenSetting.getAccessToken().getToken();
        String url = UrlConstant.QUERY_USER_INFO.replace("ACCESS_TOKEN", token).replace("OPENID", openId);

        UserInfo userInfo = new UserInfo();
        JSONObject jsonObject = HttpClientUtil.doPostStr(url, "");

        if(jsonObject!=null){
            userInfo = JackonUtil.readJson2Entity(jsonObject.toString(), UserInfo.class);
        }

        return userInfo;
    }
}
