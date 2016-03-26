package com.wechat.action.impl;

import com.wechat.action.BaseAction;
import com.wechat.constant.EventTypeConstants;
import com.wechat.constant.MessageTypeConstant;
import com.wechat.model.req.REQ_EventClick;
import com.wechat.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 自定义click菜单处理
 * Created by fusj on 15/12/24.
 */
@Service(MessageTypeConstant.MESSAGE_EVNET + "_" + EventTypeConstants.EVENT_CLICK)
public class EventClickAction extends BaseAction<REQ_EventClick> {

    private static Logger logger = LoggerFactory.getLogger(EventClickAction.class);

    @Override
    protected String doAction(REQ_EventClick request) throws Exception {
        String message = ResponseUtil.initText(request.getFromUserName(), request.getToUserName(), request.getEventKey());

        return message;
    }
}
