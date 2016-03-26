package com.wechat.service.impl;

import com.wechat.annotation.Token;
import com.wechat.config.AccessTokenSetting;
import com.wechat.constant.UrlConstant;
import com.wechat.service.IMenuService;
import com.wechat.util.HttpClientUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 微信菜单接口实现类
 * Created by fusj on 15/12/21.
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private AccessTokenSetting accessTokenSetting;

    /**
     * 获取Token
     * @return
     */
    private String getToken() {
        return this.accessTokenSetting.getAccessToken().getToken();
    }

    /**
     * 查询菜单
     * @return
     */
    @Token
    public String queryMenu() throws Exception {
        String url = UrlConstant.QUERY_MENU_URL.replace("ACCESS_TOKEN", getToken());
        JSONObject jsonObject = HttpClientUtil.doGetStr(url);

        return jsonObject.toString();
    }

    /**
     * 创建菜单
     * @param menu
     * @return
     * @throws Exception
     */
    @Token
    public int createMenu(String menu) throws Exception {
        int result = 0;

        String url = UrlConstant.CREATE_MENU_URL.replace("ACCESS_TOKEN", getToken());

        JSONObject jsonObject = HttpClientUtil.doPostStr(url, menu);
        if(jsonObject != null){
            result = jsonObject.getInt("errcode");
        }
        return result;
    }

    /**
     * 删除菜单
     * @return
     * @throws Exception
     */
    @Token
    public int deleteMenu() throws Exception {
        String url = UrlConstant.DELETE_MENU_URL.replace("ACCESS_TOKEN", getToken());

        JSONObject jsonObject = HttpClientUtil.doGetStr(url);

        int result = 0;
        if(jsonObject != null){
            result = jsonObject.getInt("errcode");
        }

        return result;
    }
}
