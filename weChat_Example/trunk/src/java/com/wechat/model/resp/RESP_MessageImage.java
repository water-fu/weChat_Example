package com.wechat.model.resp;

import com.wechat.model.base.RESP_Base;
import com.wechat.model.resp.sub.RESP_Image;

/**
 * 响应图片消息
 * Created by fusj on 15/12/24.
 */
public class RESP_MessageImage extends RESP_Base {
    /**
     * 图片
     */
    private RESP_Image image;

    public RESP_Image getImage() {
        return image;
    }

    public void setImage(RESP_Image image) {
        this.image = image;
    }
}
