package com.wechat.config;

import com.wechat.po.QrCode;
import com.wechat.service.IQrCodeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * 公众号二维码
 * Created by fusj on 15/12/22.
 */
public class QrCodeSetting {

    @Autowired
    private IQrCodeService qrCodeService;

    @Autowired
    private AccessTokenSetting accessTokenSetting;

    @Autowired
    private WeChatSetting weChatSetting;

    private QrCode qrCode;

    public QrCode getQrCode() {
        return qrCode;
    }

    public void setQrCode(QrCode qrCode) {
        this.qrCode = qrCode;
    }

    @PostConstruct
    public void initQrCode() throws Exception {
        this.setQrCode(qrCodeService.queryQrCode(accessTokenSetting.getAccessToken().getToken(), weChatSetting.getSceneStr()));

        System.out.println(this.getQrCode().getUrl());
    }
}
