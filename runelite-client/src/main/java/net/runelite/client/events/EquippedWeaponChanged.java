package net.runelite.client.events;

import lombok.Value;
import net.runelite.client.game.attackstyles.WeaponType;

@Value
public class EquippedWeaponChanged
{
	private final WeaponType equippedWeaponType;
}
