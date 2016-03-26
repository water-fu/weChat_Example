package com.wechat.controller;

import com.wechat.action.IAction;
import com.wechat.config.QrCodeSetting;
import com.wechat.config.WeChatSetting;
import com.wechat.model.base.REQ_Base;
import com.wechat.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 微信公众号请求接受
 * Created by fusj on 15/12/21.
 */
@Controller
@RequestMapping("/weChat")
public class WeChatController {

    private static Logger logger = LoggerFactory.getLogger(WeChatController.class);

    @Autowired
    private WeChatSetting weChatSetting;

    @Autowired
    private QrCodeSetting qrCodeSetting;

    /**
     * 微信公众号GET请求
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public String doGet(HttpServletRequest request) throws Exception{
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        if(CheckUtil.checkSignature(signature, timestamp, nonce, weChatSetting.getToken())){
            return echostr;
        }

        return "";
    }

    /**
     * 微信公众号POST请求
     * @param request
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String doPost(HttpServletRequest request) throws Exception {
        try {
            request.setCharacterEncoding("UTF-8");

            // 解析请求的内容
            Map<String, String> map = SAXReaderUtil.xmlToMap(request);

            logger.info(String.format("请求参数:[%s]", JackonUtil.writeEntity2JSON(map)));

            // 消息类型
            String msgType = map.get("MsgType");
            // 事件类型
            String eventType = map.get("Event");

            // 业务action的Bean名称
            StringBuffer actionBean = new StringBuffer(msgType);

            if(!StringUtils.isEmpty(eventType)) {
                actionBean.append("_").append(eventType);
            }

            IAction messageAction = null;
            try {
                messageAction = (IAction) ApplicationContextFactory.getBean(actionBean.toString());
            } catch (Exception ex) {
                logger.error("Spring Bean Error:" + ex.getMessage());
            }
            if(null == messageAction) {
                return "success";
            }

            String message = messageAction.execute(map);

            return message;
        } catch (Exception ex) {
            logger.error("微信公众号请求失败:" + ex.getMessage(), ex);
            return "success";
        }
//        if(MessageTypeConstant.MESSAGE_EVNET.equals(msgType)) {
//            // 事件类型
//            String eventType = map.get("Event");
//
//            // 关注
//            if(MessageTypeConstant.MESSAGE_SUBSCRIBE.equals(eventType)) {
//                UserInfo userInfo = userInfoService.queryUserInfo(accessToken, fromUserName);
//
//                message = this.initText(toUserName, fromUserName, userInfo.getNickname() + ",欢迎您!");
//            }
//            // 单击
//            if(MessageTypeConstant.MESSAGE_CLICK.equals(eventType)) {
//                String key = map.get("EventKey");
//
//                // 二维码
//                if (key.equals(ButtonKeyConstants.V001_QR_CODE)) {
//                    News news = new News();
//
//                    news.setTitle("二维码");
//                    news.setDescription("企业二维码");
//                    news.setPicUrl("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + URLEncoder.encode(qrCodeSetting.getQrCode().getTicket()));
//                    news.setUrl(news.getPicUrl());
//
//                    List<News> list = new ArrayList<News>();
//                    list.add(news);
//
//                    message = WeChatUtil.initNews(toUserName, fromUserName, list);
//                }
//                // 会员专区
//                else if(key.equals(ButtonKeyConstants.V001_MEMBER)) {
//                    News news = new News();
//
//                    news.setTitle("会员专区");
//                    news.setDescription("会员专区");
//                    news.setPicUrl("http://121.43.116.27/attach/R2015121711072350395.jpg");
//                    news.setUrl("http://121.43.116.27/attach/R2015121711072350395.jpg");
//
//                    List<News> list = new ArrayList<News>();
//                    list.add(news);
//
//                    message = this.initNews(toUserName, fromUserName, list);
//                }
//                // 在线克服
//                else if(key.equals(ButtonKeyConstants.V001_CUSTOM_SERVICE)) {
//                    News news = new News();
//
//                    news.setTitle("在线客服");
//                    news.setDescription("在线客服");
//                    news.setPicUrl("http://121.43.116.27/attach/R2015121711072350395.jpg");
//                    news.setUrl("http://121.43.116.27/attach/R2015121711072350395.jpg");
//
//                    List<News> list = new ArrayList<News>();
//                    list.add(news);
//
//                    message = this.initNews(toUserName, fromUserName, list);
//                }
//                // 预约到店
//                else if(key.equals(ButtonKeyConstants.V001_BOOK)) {
//                    News news = new News();
//
//                    news.setTitle("预约到店");
//                    news.setDescription("预约到店");
//                    news.setPicUrl("http://121.43.116.27/attach/R2015121711072350395.jpg");
//                    news.setUrl("http://121.43.116.27/attach/R2015121711072350395.jpg");
//
//                    List<News> list = new ArrayList<News>();
//                    list.add(news);
//
//                    message = this.initNews(toUserName, fromUserName, list);
//                }
//            }
//            // 视图
//            else if(MessageTypeConstant.MESSAGE_VIEW.equals(eventType)) {
//                String url = map.get("EventKey").toString();
//                message = this.initText(toUserName, fromUserName, url);
//            }
//            // 扫码
//            else if(MessageTypeConstant.MESSAGE_SCANCODE.equals(eventType)) {
//                String key = map.get("EventKey").toString();
//                message = this.initText(toUserName, fromUserName, key);
//            }
//        }
//        // 地图
//        else if(MessageTypeConstant.MESSAGE_LOCATION.equals(msgType)){
//            String label = map.get("Label").toString();
//            message = this.initText(toUserName, fromUserName, label);
//        }
////        System.out.println(message);
//
//        return message;
    }

    private REQ_Base initRequest(Map<String, String> map) {
        REQ_Base request = new REQ_Base();

        request.setFromUserName(map.get("FromUserName"));
        request.setToUserName(map.get("ToUserName"));
        request.setMsgType(map.get("MsgType"));
//        request.setContent(map.get("Content"));
//        request.setEvent(map.get("Event"));
//        request.setEventKey(map.get("EventKey"));
//        request.setLabel(map.get("Label"));

        return request;
    }
}
