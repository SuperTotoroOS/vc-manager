package com.vcg.security.core.properties;

/**
 * @author yangyunqi
 */
public class BrowserProperties {
	
	private SessionProperties session = new SessionProperties();

	/**
	 * 用户配置注册页，默认 /signUp.html
	 */
	private String signUpUrl = "/signUp.html";

	/**
	 * 用户配置登录页面，默认 /signIn.html
	 */
	private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;

	/**
	 * 认证成功跳转方式 REDIRECT 跳转到认证前的页面 JSON 返回认证信息，默认JSON
	 */
	private LoginResponseType loginType = LoginResponseType.JSON;

	/**
	 * "记住我"时间，默认一小时
	 */
	private int rememberMeSeconds = 3600;

	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

	public LoginResponseType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginResponseType loginType) {
		this.loginType = loginType;
	}

	public int getRememberMeSeconds() {
		return rememberMeSeconds;
	}

	public void setRememberMeSeconds(int rememberMeSeconds) {
		this.rememberMeSeconds = rememberMeSeconds;
	}

	public String getSignUpUrl() {
		return signUpUrl;
	}

	public void setSignUpUrl(String signUpUrl) {
		this.signUpUrl = signUpUrl;
	}

	public SessionProperties getSession() {
		return session;
	}

	public void setSession(SessionProperties session) {
		this.session = session;
	}
	
}
