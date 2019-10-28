package net.runelite.client.game;

import lombok.Data;
import net.runelite.api.Skill;
import net.runelite.api.events.Event;

@Data
public class XpDropEvent implements Event
{
	private Skill skill;
	private int exp;
}
