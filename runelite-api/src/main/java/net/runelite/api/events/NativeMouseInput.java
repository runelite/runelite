package net.runelite.api.events;

import lombok.Value;

@Value
public class NativeMouseInput
{
	int x;
	int y;
	int button;
	Type type;

	public enum Type
	{
		MOVEMENT, CLICK, PRESS, RELEASE, SCROLL
	}

	public boolean isButton()
	{
		return type == Type.CLICK || type == Type.PRESS || type == Type.RELEASE;
	}
}
