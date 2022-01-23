package net.runelite.client.plugins.grounditems;

import java.awt.Point;
import javax.swing.SwingUtilities;
import net.runelite.client.input.MouseAdapter;

import javax.inject.Inject;
import java.awt.event.MouseEvent;

public class GroundItemMouseAdapter extends MouseAdapter
{
	@Inject
	private GroundItemsPlugin plugin;

	@Override
	public MouseEvent mousePressed(MouseEvent e)
	{
		final Point mousePos = e.getPoint();

		if (plugin.isHotKeyPressed())
		{
			if (SwingUtilities.isLeftMouseButton(e))
			{
				// Process both click boxes for hidden and highlighted items
				if (plugin.getHiddenBoxBounds() != null && plugin.getHiddenBoxBounds().getKey().contains(mousePos))
				{
					plugin.updateList(plugin.getHiddenBoxBounds().getValue().getName(), true);
					e.consume();
					return e;
				}

				if (plugin.getHighlightBoxBounds() != null && plugin.getHighlightBoxBounds().getKey().contains(mousePos))
				{
					plugin.updateList(plugin.getHighlightBoxBounds().getValue().getName(), false);
					e.consume();
					return e;
				}

				// There is one name click box for left click and one for right click
				if (plugin.getTextBoxBounds() != null && plugin.getTextBoxBounds().getKey().contains(mousePos))
				{
					plugin.updateList(plugin.getTextBoxBounds().getValue().getName(), false);
					e.consume();
					return e;
				}
			}
			else if (SwingUtilities.isRightMouseButton(e))
			{
				if (plugin.getTextBoxBounds() != null && plugin.getTextBoxBounds().getKey().contains(mousePos))
				{
					plugin.updateList(plugin.getTextBoxBounds().getValue().getName(), true);
					e.consume();
					return e;
				}
			}
		}

		return e;
	}
}
