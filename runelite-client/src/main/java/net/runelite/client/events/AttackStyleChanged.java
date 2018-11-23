package net.runelite.client.events;

import lombok.Value;
import net.runelite.client.game.attackstyles.AttackStyle;

@Value
public class AttackStyleChanged
{
	private final AttackStyle attackStyle;
}
