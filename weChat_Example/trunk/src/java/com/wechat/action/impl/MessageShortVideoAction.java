package com.wechat.action.impl;

import com.wechat.action.BaseAction;
import com.wechat.constant.MessageTypeConstant;
import com.wechat.model.req.REQ_MessageShortVideo;
import com.wechat.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 短消息处理
 * Created by fusj on 15/12/24.
 */
@Service(MessageTypeConstant.MESSAGE_SHORTVIDEO)
public class MessageShortVideoAction extends BaseAction<REQ_MessageShortVideo> {

    private static Logger logger = LoggerFactory.getLogger(MessageShortVideoAction.class);

    @Override
    protected String doAction(REQ_MessageShortVideo request) throws Exception {

        String message = ResponseUtil.initText(request.getFromUserName(), request.getFromUserName(), request.getThumbMediaId());

        return message;
    }
}
