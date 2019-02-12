package net.runelite.client.events;

import lombok.Value;

@Value
public class SlayerAmountChanged
{
	private int oldAmount, newAmount;
}
