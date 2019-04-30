package net.runelite.client.plugins.spellbook;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
class Spell
{
	private int widget;
	private int x;
	private int y;
	private String name;
}
