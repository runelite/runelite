package net.runelite.http.api.config;

import lombok.Data;

@Data
public class ConfigKey
{
	private String profile;
	private String account;
	private String groupName;
	private String key;

	public ConfigKey(String profile, String account, String groupName, String key)
	{
		this.profile = profile == null ? "" : profile;
		this.account = account == null ? "" : account;
		this.groupName = groupName == null ? "" : groupName;
		this.key = key == null ? "" : key;
	}
}
