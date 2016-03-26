package com.wechat.action.impl;

import com.wechat.action.BaseAction;
import com.wechat.constant.EventTypeConstants;
import com.wechat.constant.MessageTypeConstant;
import com.wechat.model.req.REQ_EventSubscribe;
import com.wechat.po.UserInfo;
import com.wechat.service.IUserInfoService;
import com.wechat.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 关注事件处理
 * Created by fusj on 15/12/24.
 */
@Service(MessageTypeConstant.MESSAGE_EVNET + "_" + EventTypeConstants.EVENT_SUBSCRIBE)
public class EventSubscribeAction extends BaseAction<REQ_EventSubscribe> {

    private static Logger logger = LoggerFactory.getLogger(EventSubscribeAction.class);

    @Autowired
    private IUserInfoService userInfoService;

    @Override
    protected String doAction(REQ_EventSubscribe request) throws Exception {
        UserInfo userInfo = userInfoService.queryUserInfo(request.getFromUserName());

        String message = ResponseUtil.initText(request.getFromUserName(), request.getToUserName(), userInfo.getNickname() + ",欢迎您!");

        return message;
    }
}
