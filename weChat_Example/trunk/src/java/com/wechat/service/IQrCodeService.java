package com.wechat.service;

import com.wechat.po.QrCode;

/**
 * 二维码接口
 * Created by fusj on 15/12/22.
 */
public interface IQrCodeService {

    /**
     * 申请永久二维码
     * @param token
     * @param sceneStr
     * @return
     */
    QrCode queryQrCode(String token, String sceneStr) throws Exception;
}
