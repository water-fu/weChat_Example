package com.wechat.action.impl;

import com.wechat.action.BaseAction;
import com.wechat.constant.MessageTypeConstant;
import com.wechat.model.req.REQ_MessageVideo;
import com.wechat.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 语音消息处理
 * Created by fusj on 15/12/24.
 */
@Service(MessageTypeConstant.MESSAGE_VIDEO)
public class MessageVideoAction extends BaseAction<REQ_MessageVideo> {

    private static Logger logger = LoggerFactory.getLogger(MessageVideoAction.class);

    @Override
    protected String doAction(REQ_MessageVideo request) throws Exception {

        String message = ResponseUtil.initText(request.getFromUserName(), request.getToUserName(), request.getThumbMediaId());
        return message;
    }
}
