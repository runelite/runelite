package net.runelite.api.events;

import lombok.Data;
import net.runelite.api.events.Event;

@Data
public class ConfigButtonClicked implements Event
{
	private String group, key;
}
