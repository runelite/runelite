package net.runelite.client.plugins.tickcounter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

import javax.inject.Inject;

import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class TickCounterOverlay extends Overlay
{

	private TickCounterPlugin plugin;
	private PanelComponent panelComponent = new PanelComponent();

	@Inject
	public TickCounterOverlay(TickCounterPlugin plugin)
	{
		super(plugin);
		setPosition(OverlayPosition.DYNAMIC);
		setPosition(OverlayPosition.DETACHED);
		setPosition(OverlayPosition.BOTTOM_RIGHT);
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D g)
	{
		List<LayoutableRenderableEntity> elems = panelComponent.getChildren();
		elems.clear();
		elems.add(TitleComponent.builder().text("Combat counter").color(Color.WHITE).build());
		List<Entry<String, Integer>> list = new ArrayList<>(plugin.activity.entrySet());
		list.sort(new Comparator<Entry<String, Integer>>()
		{
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2)
			{
				int value = -Integer.compare(o1.getValue(), o2.getValue());
				if (value == 0)
					value = o1.getKey().compareTo(o2.getKey());
				return value;
			}
		});
		for (Entry<String, Integer> e : list)
		{
			elems.add(LineComponent.builder().left(e.getKey()).right(e.getValue().toString()).build());
		}
		return this.panelComponent.render(g);
	}

}
