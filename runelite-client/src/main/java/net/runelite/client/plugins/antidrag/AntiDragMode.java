package net.runelite.client.plugins.antidrag;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AntiDragMode
{
	SHIFT("Shift"),
	ALT("Alt"),
	CONTROL("Control");

	private final String button;

	@Override
	public String toString()
	{
		return button;
	}

}
