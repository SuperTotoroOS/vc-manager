package com.vcg.security.core.social.weixin.api;

/**
 * @author yangyunqi
 *
 * 微信API
 */
public interface Weixin {

	WeixinUserInfo getUserInfo(String openId);
	
}
