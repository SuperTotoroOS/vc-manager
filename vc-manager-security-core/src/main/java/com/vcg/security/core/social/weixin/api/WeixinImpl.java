package com.vcg.security.core.social.weixin.api;

import java.nio.charset.Charset;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author yangyunqi
 */
@Slf4j
public class WeixinImpl extends AbstractOAuth2ApiBinding implements Weixin {

	/**
	 * 微信获取用户信息地址
	 */
	private static final String URL_GET_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?openid=";

	private ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 默认会将accessToken放入请求头中，但是QQ要求放到查询参数里，所以要设置 TokenStrategy.ACCESS_TOKEN_PARAMETER
	 */
	public WeixinImpl(String accessToken) {
		super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
	}

	/**
	 * 获取用户信息
	 * @return WeixinUserInfo
	 */
	@Override
	public WeixinUserInfo getUserInfo(String openId) {
		String url = URL_GET_USER_INFO + openId;
		String result = getRestTemplate().getForObject(url, String.class);

		if(StringUtils.contains(result, "errcode")) {
			return null;
		}

		WeixinUserInfo profile = null;
		try {
			profile = objectMapper.readValue(result, WeixinUserInfo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profile;
	}

	/**
	 * 默认注册的StringHttpMessageConverter字符集为ISO-8859-1，而微信返回的是UTF-8的，所以覆盖了原来的方法。
	 */
	@Override
	protected List<HttpMessageConverter<?>> getMessageConverters() {
		List<HttpMessageConverter<?>> messageConverters = super.getMessageConverters();
		messageConverters.remove(0);
		messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
		return messageConverters;
	}

}
