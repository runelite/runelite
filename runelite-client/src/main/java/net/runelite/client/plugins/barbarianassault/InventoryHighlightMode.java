package net.runelite.client.plugins.barbarianassault;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InventoryHighlightMode
{
	OVERLAY("Overlay"),
	OUTLINE("Outline");

	private final String name;

	@Override
	public String toString()
	{
		return name;
	}
}
