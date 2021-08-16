package net.runelite.http.api.chat;

import lombok.Data;

@Data
public class Roles
{
	private int attacker;
	private int defender;
	private int collector;
	private int healer;
}
