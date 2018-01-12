package com.vcg.security.core.social.weixin.connect;

import com.vcg.security.core.social.weixin.api.Weixin;
import com.vcg.security.core.social.weixin.api.WeixinUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @author yangyunqi
 *
 * 微信授权适配器
 */
public class WeixinAdapter implements ApiAdapter<Weixin> {
	
	private String openId;
	
	public WeixinAdapter() {}
	
	public WeixinAdapter(String openId){
		this.openId = openId;
	}

	@Override
	public boolean test(Weixin api) {
		return true;
	}


	@Override
	public void setConnectionValues(Weixin api, ConnectionValues values) {
		WeixinUserInfo userInfo = api.getUserInfo(openId);
		values.setProviderUserId(userInfo.getOpenid());
		values.setDisplayName(userInfo.getNickname());
		values.setImageUrl(userInfo.getHeadimgurl());
		values.setProfileUrl(null);
	}

	@Override
	public UserProfile fetchUserProfile(Weixin api) {
		return null;
	}

	@Override
	public void updateStatus(Weixin api, String message) {

	}


}
