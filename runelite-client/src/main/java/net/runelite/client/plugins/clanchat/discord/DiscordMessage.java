package net.runelite.client.plugins.clanchat.discord;

import lombok.Data;

@Data
public class DiscordMessage
{
	private String username;
	private String content;
	private String avatar_url;
}

