package net.runelite.api.events;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MouseAutomated
{
	private int x;
	private int y;
	private int button;
	private EventType eventType;

	public enum EventType
	{
		PRESS, MOVE, RELEASE, EXIT
	}
}
