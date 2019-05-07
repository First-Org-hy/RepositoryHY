package com.hy.controller;

import com.alibaba.fastjson.JSONObject;
import com.hy.model.AppDomain;
import com.hy.service.AppService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Created by yaohou on 20:36 2019/5/5. description: */
@RestController
@RequestMapping("/wx")
public class WxCheckController {

  @Value("${auth.wechat.appId}")
  private String appId;

  @Value("${auth.wechat.secret}")
  private String secret;

  @Value("${auth.wechat.sessionHost}")
  private String url;

  @Value("${auth.wechat.grantType}")
  private String grantType;

  @Autowired private AppService appService;

  @RequestMapping("/toLogin")
  public Map<String, Object> doLogin(HttpServletResponse resp, HttpServletRequest req) {
    resp.setHeader("Access-Control-Allow-Origin", "*");
    resp.setContentType("text/html;charset=UTF-8");
    String code = req.getParameter("code");
    String nickName = req.getParameter("name");
    String avatarUrl = req.getParameter("url");
    String param =
        "appid=" + appId + "&secret=" + secret + "&js_code=" + code + "&grant_type=" + grantType;
    url = url + "?" + param;
    int error = 0;
    String loginResult = "";
    Map<String, Object> result = new HashMap<String, Object>();
    try {
      System.out.println("请求URL:" + url);
      String ret = doGet(url);
      JSONObject obj = JSONObject.parseObject(ret);
      String openid = obj.getString("openid");
      String session_key = obj.getString("session_key");
      result.put("openid", openid);
      System.out.println("session_key:" + session_key);
      AppDomain app = new AppDomain(nickName, openid, "", nickName);
      List<AppDomain> appDomains = appService.queryById(app);
      if (openid != null && appDomains.size() != 0) {
        loginResult = "success";
      } else {
        loginResult = "faild";
      }
    } catch (Exception e) {
      error = -1;
    }
    result.put("code", error);
    result.put("loginResult", loginResult);
    return result;
  }

  /**
   * 发送GET请求（HTTP），K-V形式
   *
   * @param url
   * @author Charlie.chen；
   * @return
   */
  public static String doGet(String url) throws Exception {

    URI uri = null;
    // 创建默认的HttpClient实例.
    try (CloseableHttpClient httpclient = HttpClients.createDefault(); ) {

      uri = new URI(url);
      // 定义一个get请求方法
      HttpGet httpget = new HttpGet(uri);

      // 执行get请求，返回response服务器响应对象, 其中包含了状态信息和服务器返回的数据
      CloseableHttpResponse httpResponse = httpclient.execute(httpget);

      // 使用响应对象, 获得状态码, 处理内容
      int statusCode = httpResponse.getStatusLine().getStatusCode();
      //      logger.info("Send a http get request and the response code is :"+statusCode);
      if (statusCode == HttpStatus.SC_OK) {
        // 使用响应对象获取响应实体
        HttpEntity entity = httpResponse.getEntity();
        // 将响应实体转为字符串
        String response = EntityUtils.toString(entity, "utf-8");
        return response;
      }
    } catch (Exception e) {
      //      logger.info("Send a http get request occurred exception",e);
      throw e;
    }
    return null;
  }
}
