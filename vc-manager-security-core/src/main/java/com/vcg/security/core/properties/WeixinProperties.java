package com.vcg.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author yangyunqi
 */
public class WeixinProperties extends SocialProperties {

	private String providerId = "weixin";

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

}
