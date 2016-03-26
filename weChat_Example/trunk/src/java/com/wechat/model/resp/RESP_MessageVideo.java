package com.wechat.model.resp;

import com.wechat.model.base.RESP_Base;
import com.wechat.model.resp.sub.RESP_Video;

/**
 * 响应视频消息
 * Created by fusj on 15/12/24.
 */
public class RESP_MessageVideo extends RESP_Base {
    /**
     * 视频
     */
    private RESP_Video video;

    public RESP_Video getVideo() {
        return video;
    }

    public void setVideo(RESP_Video video) {
        this.video = video;
    }
}
