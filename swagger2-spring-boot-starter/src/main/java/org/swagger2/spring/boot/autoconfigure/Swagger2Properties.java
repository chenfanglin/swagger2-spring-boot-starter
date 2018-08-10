package org.swagger2.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Swagger2 配置
 * 
 * @author monkeychen
 * @date: 2018年8月10日 下午2:22:54
 * @version v1.0.0
 */
@ConfigurationProperties(prefix = Swagger2Properties.SWAGGER2_PREFIX)
public class Swagger2Properties {

	public static final String SWAGGER2_PREFIX = "spring.swagger2";

	/**
	 * 是否开启swagger
	 */
	private Boolean enabled;

	/**
	 * 文档标题
	 */
	private String title;

	/**
	 * 文档描述
	 */
	private String description;

	/**
	 * 联系人名称
	 */
	private String name;

	/**
	 * 联系人个人站点
	 */
	private String url;

	/**
	 * 联系人邮箱
	 */
	private String email;

	/**
	 * 文档版本
	 */
	private String version;

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
