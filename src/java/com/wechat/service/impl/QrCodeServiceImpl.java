package com.wechat.service.impl;

import com.wechat.annotation.Token;
import com.wechat.constant.UrlConstant;
import com.wechat.po.QrCode;
import com.wechat.service.IQrCodeService;
import com.wechat.util.HttpClientUtil;
import com.wechat.util.JackonUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * 二维码接口实现
 * Created by fusj on 15/12/22.
 */
@Service
public class QrCodeServiceImpl implements IQrCodeService {
    /**
     * 获取永久二维码
     * @param token
     * @param sceneStr
     * @return
     */
    @Token
    public QrCode queryQrCode(String token, String sceneStr) throws Exception{
        String url = UrlConstant.QUERY_QR_CODE.replace("ACCESS_TOKEN", token);

        QrCode qrCode = new QrCode();

        String data = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"" + sceneStr + "\"}}}";
        JSONObject jsonObject = HttpClientUtil.doPostStr(url, data);
        if(null != jsonObject) {
            qrCode = JackonUtil.readJson2Entity(jsonObject.toString(), QrCode.class);
        }

        return qrCode;
    }
}
