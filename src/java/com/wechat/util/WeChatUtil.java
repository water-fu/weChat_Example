package com.wechat.util;

import com.wechat.constant.ButtonKeyConstants;
import com.wechat.constant.ButtonTypeConstant;
import com.wechat.po.menu.Button;
import com.wechat.po.menu.ClickButton;
import com.wechat.po.menu.Menu;
import com.wechat.po.menu.ViewButton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 微信工具类
 * Created by fusj on 15/12/23.
 */
public class WeChatUtil {

    private static Logger logger = LoggerFactory.getLogger(WeChatUtil.class);



    /**
     * 微信菜单
     * @return
     * @throws Exception
     */
    public static String initMenu() throws Exception {
        Menu menu = new Menu();

        // 菜单一
        Button button1 = new Button();
        button1.setName("巴黎春天");

        ViewButton viewButton11 = new ViewButton();
        viewButton11.setName("微官网");
        viewButton11.setType(ButtonTypeConstant.BUTTON_VIEW);
        viewButton11.setUrl("http://fad.ngrok.natapp.cn/home");

        ClickButton clickButton12 = new ClickButton();
        clickButton12.setName("二维码");
        clickButton12.setType(ButtonTypeConstant.BUTTON_CLICK);
        clickButton12.setKey(ButtonKeyConstants.V001_QR_CODE);

        button1.setSub_button(new Button[]{viewButton11, clickButton12});


        // 菜单二
        Button button2 = new Button();
        button2.setName("会员专区");

        ClickButton clickButton21 = new ClickButton();
        clickButton21.setName("会员专区");
        clickButton21.setType(ButtonTypeConstant.BUTTON_CLICK);
        clickButton21.setKey(ButtonKeyConstants.V001_MEMBER);

        ClickButton clickButton22 = new ClickButton();
        clickButton22.setName("在线客服");
        clickButton22.setType(ButtonTypeConstant.BUTTON_CLICK);
        clickButton22.setKey(ButtonKeyConstants.V001_CUSTOM_SERVICE);

        ClickButton clickButton23 = new ClickButton();
        clickButton23.setName("预约到店");
        clickButton23.setType(ButtonTypeConstant.BUTTON_CLICK);
        clickButton23.setKey(ButtonKeyConstants.V001_BOOK);

        button2.setSub_button(new Button[]{clickButton21, clickButton22, clickButton23});

        // 菜单三
        Button button3 = new Button();
        button3.setName("在线商城");

        ViewButton viewButton31 = new ViewButton();
        viewButton31.setName("在线商城");
        viewButton31.setType(ButtonTypeConstant.BUTTON_VIEW);
        viewButton31.setUrl("http://www.baidu.com");

        ViewButton viewButton32 = new ViewButton();
        viewButton32.setName("最新活动");
        viewButton32.setType(ButtonTypeConstant.BUTTON_VIEW);
        viewButton32.setUrl("http://www.baidu.com");

        button3.setSub_button(new Button[] {viewButton31, viewButton32});

        menu.setButton(new Button[]{button1, button2, button3});

        logger.info("创建菜单:" + JackonUtil.writeEntity2JSON(menu));
        return JackonUtil.writeEntity2JSON(menu);
    }
}
