package com.wechat.action.impl;

import com.wechat.action.BaseAction;
import com.wechat.constant.EventTypeConstants;
import com.wechat.constant.MessageTypeConstant;
import com.wechat.model.req.REQ_EventUnSubscribe;
import com.wechat.service.IUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 取消关注事件处理
 * Created by fusj on 15/12/24.
 */
@Service(MessageTypeConstant.MESSAGE_EVNET + "_" + EventTypeConstants.EVENT_UNSUBSCRIBE)
public class EventUnSubscribeAction extends BaseAction<REQ_EventUnSubscribe> {

    private static Logger logger = LoggerFactory.getLogger(EventUnSubscribeAction.class);

    @Autowired
    private IUserInfoService userInfoService;

    @Override
    protected String doAction(REQ_EventUnSubscribe request) throws Exception {

        return "";
    }
}
