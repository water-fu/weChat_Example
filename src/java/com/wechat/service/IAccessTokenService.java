package com.wechat.service;

import com.wechat.po.AccessToken;

/**
 * AccessToken接口
 * Created by fusj on 15/12/21.
 */
public interface IAccessTokenService {
    AccessToken getAccessToken() throws Exception;
}
