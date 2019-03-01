package net.runelite.client.plugins.massdigger;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class InventoryItem
{
	private final int id;
	private final int quantity;
}
