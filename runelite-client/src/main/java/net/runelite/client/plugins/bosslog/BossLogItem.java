package net.runelite.client.plugins.bosslog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class BossLogItem
{
	@Getter
	private final int id;
	@Getter
	@Setter
	private int quantity;
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private int price;
}
