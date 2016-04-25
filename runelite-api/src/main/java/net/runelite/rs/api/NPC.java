package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface NPC extends Actor
{
	@Import("composition")
	NPCComposition getComposition();
}
