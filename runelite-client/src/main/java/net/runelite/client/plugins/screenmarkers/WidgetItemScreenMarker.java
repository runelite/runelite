package net.runelite.client.plugins.screenmarkers;

import java.awt.Color;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class WidgetItemScreenMarker extends ScreenMarker
{
	private ItemContainerSlot slot;

	public WidgetItemScreenMarker(long id, String name, int borderThickness, Color color, Color fill, boolean visible,
								  ItemContainerSlot slot)
	{
		super(id, name, borderThickness, color, fill, visible);
		this.slot = slot;
	}
}
