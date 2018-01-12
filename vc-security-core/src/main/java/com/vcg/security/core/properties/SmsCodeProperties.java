package com.vcg.security.core.properties;

/**
 * @author yangyunqi
 */
public class SmsCodeProperties {

	/**
	 * 验证码长度，默认6位
	 */
	private int length = 6;

	/**
	 * 验证码过期时间，默认60秒
	 */
	private int expireIn = 60;

	/**
	 * 需要验证码拦截的URL
	 */
	private String url;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getExpireIn() {
		return expireIn;
	}

	public void setExpireIn(int expireIn) {
		this.expireIn = expireIn;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
