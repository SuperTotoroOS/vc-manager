package com.vcg.security.core.properties;

/**
 * @author yangyunqi
 */
public class ImageCodeProperties extends SmsCodeProperties {

	/**
	 * 图形验证码的长度，默认4
	 */
	public ImageCodeProperties() {
		setLength(4);
	}

	/**
	 * 图形验证码图片的宽度，默认67
	 */
	private int width = 67;

	/**
	 * 图形验证码图片的高度，默认23
	 */
	private int height = 23;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
