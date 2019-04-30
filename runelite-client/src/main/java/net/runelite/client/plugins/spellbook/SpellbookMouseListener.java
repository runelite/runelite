package net.runelite.client.plugins.spellbook;

import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import net.runelite.client.input.MouseAdapter;

public class SpellbookMouseListener extends MouseAdapter
{
	private final SpellbookPlugin plugin;

	SpellbookMouseListener(SpellbookPlugin plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public MouseEvent mouseClicked(MouseEvent event)
	{
		if (SwingUtilities.isMiddleMouseButton(event) || !plugin.isOnSpellWidget(event.getPoint()))
		{
			return event;
		}

		event.consume();
		return event;
	}

	@Override
	public MouseEvent mousePressed(MouseEvent event)
	{
		if (!SwingUtilities.isLeftMouseButton(event) || !plugin.isOnSpellWidget(event.getPoint()) || plugin.isDragging())
		{
			return event;
		}

		plugin.startDragging(event.getPoint());

		event.consume();
		return event;
	}

	@Override
	public MouseEvent mouseReleased(MouseEvent event)
	{
		if (!SwingUtilities.isLeftMouseButton(event) || !plugin.isDragging())
		{
			return event;
		}

		plugin.completeDragging(event.getPoint());

		event.consume();
		return event;
	}
}
