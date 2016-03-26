package com.wechat.service.impl;

import com.wechat.config.WeChatSetting;
import com.wechat.constant.UrlConstant;
import com.wechat.po.AccessToken;
import com.wechat.service.IAccessTokenService;
import com.wechat.util.HttpClientUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AccessToken接口实现类
 * Created by fusj on 15/12/21.
 */
@Service
public class AccessTokenServiceImpl implements IAccessTokenService {

    @Autowired
    private WeChatSetting weChatSetting;

    /**
     * 获取AccessToken
     * @return
     */
    public AccessToken getAccessToken() throws Exception {
        AccessToken token = new AccessToken();

        String url = UrlConstant.ACCESS_TOKEN_URL.replace("APPID", weChatSetting.getAppId()).replace("APPSECRET", weChatSetting.getAppSecret());
        JSONObject jsonObject = HttpClientUtil.doGetStr(url);

        if(jsonObject!=null){
            token.setToken(jsonObject.getString("access_token"));
            token.setExpiresIn(jsonObject.getInt("expires_in"));
        }

        return token;
    }
}
