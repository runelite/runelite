package net.runelite.client.plugins.screenmarkers;

import java.awt.Color;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class WidgetScreenMarker extends ScreenMarker
{
	private int widgetId;

	public WidgetScreenMarker(long id, String name, int borderThickness, Color color, Color fill, boolean visible,
							  int widgetId)
	{
		super(id, name, borderThickness, color, fill, visible);
		this.widgetId = widgetId;
	}
}
