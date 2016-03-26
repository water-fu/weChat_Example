package com.wechat.action.impl;

import com.wechat.action.BaseAction;
import com.wechat.constant.MessageTypeConstant;
import com.wechat.constant.SystemOrderConstants;
import com.wechat.model.req.REQ_MessageText;
import com.wechat.service.IMenuService;
import com.wechat.util.ResponseUtil;
import com.wechat.util.WeChatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文本消息处理
 * Created by fusj on 15/12/23.
 */
@Service(MessageTypeConstant.MESSAGE_TEXT)
public class MessageTextAction extends BaseAction<REQ_MessageText> {

    private static Logger logger = LoggerFactory.getLogger(MessageTextAction.class);

    @Autowired
    private IMenuService menuService;

    @Override
    protected String doAction(REQ_MessageText request) throws Exception {
        String content = request.getContent();

        String fromUserName = request.getFromUserName();
        String toUserName = request.getToUserName();

        String message = "";


        if(SystemOrderConstants.TANK_CREATE_MENU.equals(content)) {
            int code = menuService.createMenu(WeChatUtil.initMenu());
            if(code == 0) {
                message = ResponseUtil.initText(fromUserName, toUserName, "菜单创建成功");
            } else {
                logger.error("菜单创建失败:" + code);
                message = ResponseUtil.initText(fromUserName, toUserName, "菜单创建失败");
            }
        }
        else if(SystemOrderConstants.TANK_DELETE_MENU.equals(content)) {
            int code = menuService.deleteMenu();
            if(code == 0) {
                message = ResponseUtil.initText(fromUserName, toUserName, "菜单删除成功");
            } else {
                logger.error("菜单删除失败:" + code);
                message = ResponseUtil.initText(fromUserName, toUserName, "菜单创建失败");
            }
        }
        else {
            message = ResponseUtil.initText(fromUserName, toUserName, content);
        }

        return message;
    }

}
