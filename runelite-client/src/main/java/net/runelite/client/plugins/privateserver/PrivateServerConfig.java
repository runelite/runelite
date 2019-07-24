package net.runelite.client.plugins.privateserver;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("privateserver")

public interface PrivateServerConfig extends Config
{

	@ConfigItem(
		keyName = "codebase",
		name = "URL (codebase)",
		description = "IP address or URL of RSPS you wish to connect to.",
		position = 0
	)
	default String codebase()
	{
		return "http://oldschool17.runescape.com/";
	}

	@ConfigItem(
		keyName = "modulus",
		name = "Key (modulus)",
		description = "RSA key used by the RSPS you wish to connect to.",
		position = 1
	)
	default String modulus()
	{
		return "83ff79a3e258b99ead1a70e1049883e78e513c4cdec538d8da9483879a9f81689c0c7d146d7b82b52d05cf26132b1cda5930eeef894e4ccf3d41eebc3aabe54598c4ca48eb5a31d736bfeea17875a35558b9e3fcd4aebe2a9cc970312a477771b36e173dc2ece6001ab895c553e2770de40073ea278026f36961c94428d8d7db";
	}

}