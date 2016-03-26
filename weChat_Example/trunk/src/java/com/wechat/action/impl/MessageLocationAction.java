package com.wechat.action.impl;

import com.wechat.action.BaseAction;
import com.wechat.constant.MessageTypeConstant;
import com.wechat.model.req.REQ_MessageLocation;
import com.wechat.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 地址信息处理
 * Created by fusj on 15/12/24.
 */
@Service(MessageTypeConstant.MESSAGE_LOCATION)
public class MessageLocationAction extends BaseAction<REQ_MessageLocation> {

    private static Logger logger = LoggerFactory.getLogger(MessageLocationAction.class);

    @Override
    protected String doAction(REQ_MessageLocation request) throws Exception {
        String message = ResponseUtil.initText(request.getFromUserName(), request.getToUserName(), request.getLabel());
        return message;
    }
}
