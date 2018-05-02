package net.runelite.client.plugins.walkhere;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.awt.event.KeyEvent;

@Getter
@RequiredArgsConstructor
public enum WalkHereHotkey
{
	SHIFT("Shift", KeyEvent.VK_SHIFT),
	ALT("Alt", KeyEvent.VK_ALT),
	CONTROL("Control", KeyEvent.VK_CONTROL);

	private final String name;
	private final int hotkey;

	@Override
	public String toString()
	{
		return name;
	}
}
