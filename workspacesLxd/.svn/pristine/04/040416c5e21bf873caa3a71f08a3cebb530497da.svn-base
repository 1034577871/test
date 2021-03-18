package com.ruoyi.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取项目相关配置
 *
 * @author danny
 */
@Component
@ConfigurationProperties(prefix = "nginx")
public class NginxConfig {
	private static boolean enabled;
	private static String path;
	private static String url;

	public static boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		NginxConfig.enabled = enabled;
	}

	public void setPath(String path) {
		NginxConfig.path = path;
	}

	public void setUrl(String url) {
		NginxConfig.url = url;
	}

	public static String getPath() {
		return path;
	}

	public static String getUrl() {
		return url;
	}
}
