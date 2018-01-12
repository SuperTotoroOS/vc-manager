package com.vcg.security.core.social.qq.api;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author yangyunqi
 */
@Slf4j
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {

	/**
	 * QQ获取openId地址
	 */
	private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";

	/**
	 * QQ获取用户信息地址
	 */
	private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";
	
	private String appId;
	
	private String openId;
	
	private ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 默认会将accessToken放入请求头中，但是QQ要求放到查询参数里，所以要设置 TokenStrategy.ACCESS_TOKEN_PARAMETER
	 */
	public QQImpl(String accessToken, String appId) {
		super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);

		this.appId = appId;

		String url = String.format(URL_GET_OPENID, accessToken);
		String result = getRestTemplate().getForObject(url, String.class);
		this.openId = StringUtils.substringBetween(result, "\"openid\":\"", "\"}");
	}

	/**
	 * 获取用户信息
	 */
	@Override
	public QQUserInfo getUserInfo() {
		String url = String.format(URL_GET_USERINFO, appId, openId);
		String result = getRestTemplate().getForObject(url, String.class);
		
		QQUserInfo userInfo = null;
		try {
			userInfo = objectMapper.readValue(result, QQUserInfo.class);
			userInfo.setOpenId(openId);
			return userInfo;
		} catch (Exception e) {
			throw new RuntimeException("获取用户信息失败", e);
		}
	}

}
