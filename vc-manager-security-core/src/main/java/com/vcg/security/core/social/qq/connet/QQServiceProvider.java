package com.vcg.security.core.social.qq.connet;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

import com.vcg.security.core.social.qq.api.QQ;
import com.vcg.security.core.social.qq.api.QQImpl;

/**
 * @author yangyunqi
 * OAuth2流程处理器的提供器，供spring social的connect体系调用
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

	private String appId;

	/**
	 * 获取授权码的url
	 */
	private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";
	/**
	 * 获取accessToken的url
	 */
	private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";
	
	public QQServiceProvider(String appId, String appSecret) {
		super(new QQOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
		this.appId = appId;
	}
	
	@Override
	public QQ getApi(String accessToken) {
		return new QQImpl(accessToken, appId);
	}

}
