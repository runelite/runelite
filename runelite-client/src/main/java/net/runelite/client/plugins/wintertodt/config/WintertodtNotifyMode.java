package net.runelite.client.plugins.wintertodt.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WintertodtNotifyMode
{
	WHEN_DAMAGED("Damage Taken"),
	ONLY_WHEN_INTERRUPTED("Action Interrupted"),
	EITHER("Either");

	private final String name;

	@Override
	public String toString()
	{
		return name;
	}
}
