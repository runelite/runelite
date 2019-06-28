package net.runelite.api.events;

import net.runelite.api.Actor;
import lombok.Data;

@Data
public class OverheadTextChanged
{
	public static final OverheadTextChanged INSTANCE = new OverheadTextChanged();

	private OverheadTextChanged()
	{
		// noop
	}

	private Actor actor;

	private String overheadText;
}