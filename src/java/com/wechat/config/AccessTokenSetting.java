package com.wechat.config;

import com.wechat.po.AccessToken;
import com.wechat.service.IAccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * 获取AccessToken
 * Created by fusj on 15/12/21.
 */
public class AccessTokenSetting {

    @Autowired
    private IAccessTokenService accessTokenService;

    // 微信令牌
    private AccessToken accessToken;

    /**
     * 加载时间
     */
    private Long loadTime;

    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public Long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(Long loadTime) {
        this.loadTime = loadTime;
    }

    @PostConstruct
    public void initAccessToken() throws Exception {
        this.setAccessToken(accessTokenService.getAccessToken());

        // 加载时间
        this.loadTime = new Date().getTime();

        System.out.println(this.accessToken.getToken());
        System.out.println(this.accessToken.getExpiresIn());
    }
}
