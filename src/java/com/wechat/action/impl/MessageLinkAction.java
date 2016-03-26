package com.wechat.action.impl;

import com.wechat.action.BaseAction;
import com.wechat.constant.MessageTypeConstant;
import com.wechat.model.req.REQ_MessageLink;
import com.wechat.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 链接消息处理
 * Created by fusj on 15/12/24.
 */
@Service(MessageTypeConstant.MESSAGE_LINK)
public class MessageLinkAction extends BaseAction<REQ_MessageLink> {

    private Logger logger = LoggerFactory.getLogger(MessageLinkAction.class);

    @Override
    protected String doAction(REQ_MessageLink request) throws Exception {
        String message = ResponseUtil.initText(request.getFromUserName(), request.getToUserName(), request.getUrl());

        return message;
    }
}
