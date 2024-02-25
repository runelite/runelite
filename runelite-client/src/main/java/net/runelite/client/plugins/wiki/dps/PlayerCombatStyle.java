package net.runelite.client.plugins.wiki.dps;

import lombok.Value;
import lombok.With;

@Value
@With // to change stance for defensive autocasting
class PlayerCombatStyle
{

	transient int varpValue;

	String name;

	String type;

	String stance;

}
