package net.runelite.client.plugins.itemstats;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ItemStatDisplayType
{
	ALWAYS(),
	ON_KEYBIND(),
	NEVER();
}