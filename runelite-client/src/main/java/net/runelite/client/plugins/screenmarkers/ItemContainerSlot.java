package net.runelite.client.plugins.screenmarkers;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.runelite.api.widgets.Widget;

@Data
@AllArgsConstructor
public class ItemContainerSlot
{
	private int slotIndex;
	private Widget container;
}
