package com.vcg.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author yangyunqi
 */
public class QQProperties extends SocialProperties {
	
	private String providerId = "qq";

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	
}
