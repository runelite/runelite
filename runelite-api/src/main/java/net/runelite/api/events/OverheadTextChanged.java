package net.runelite.api.events;

import net.runelite.api.Actor;
import lombok.Value;

@Value
public class OverheadTextChanged implements Event
{
	private final Actor actor;

	private final String overheadText;
}