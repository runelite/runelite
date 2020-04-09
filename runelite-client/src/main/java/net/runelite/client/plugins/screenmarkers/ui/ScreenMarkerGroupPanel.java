package net.runelite.client.plugins.screenmarkers.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import net.runelite.client.plugins.screenmarkers.ScreenMarkerGroup;
import net.runelite.client.plugins.screenmarkers.ScreenMarkerPlugin;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;

public class ScreenMarkerGroupPanel extends ContainerPanel
{

	private static final Border NAME_BOTTOM_BORDER = new CompoundBorder(
		BorderFactory.createMatteBorder(0, 0, 1, 0, ColorScheme.DARK_GRAY_COLOR),
		BorderFactory.createLineBorder(ColorScheme.DARKER_GRAY_COLOR));


	private final ScreenMarkerGroup group;

	ScreenMarkerGroupPanel(ScreenMarkerPlugin plugin, ScreenMarkerPluginPanel panel, ScreenMarkerGroup group)
	{
		super(plugin, group.getName(), true);

		this.group = group;

		JLabel view = new JLabel("View");
		view.setFont(FontManager.getRunescapeSmallFont());
		view.setForeground(ColorScheme.LIGHT_GRAY_COLOR.darker());
		view.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO: Show group panel over ScreenMarkerPluginPanel
				panel.displayGroup(new ScreenMarkerGroupPluginPanel(plugin, panel, group));
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				view.setForeground(ColorScheme.LIGHT_GRAY_COLOR.darker().darker());
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				view.setForeground(ColorScheme.LIGHT_GRAY_COLOR.darker().darker());
			}
		});

		leftActions.add(view);
	}

	protected void preview(boolean on)
	{
		if (visible)
		{
			return;
		}

		group.getMarkers().forEach(marker -> marker.getMarker().setVisible(on));
	}

	protected void toggle(boolean on)
	{
		visible = on;
		group.getMarkers().forEach(marker -> marker.getMarker().setVisible(visible));
		plugin.updateConfig();
		updateVisibility();
	}

	protected void save()
	{
		group.setName(nameInput.getText());
		plugin.updateConfig();

		nameInput.setEditable(false);
		updateNameActions(false);
		requestFocusInWindow();
	}

	protected void cancel()
	{
		nameInput.setEditable(false);
		nameInput.setText(group.getName());
		updateNameActions(false);
		requestFocusInWindow();
	}

	protected void delete()
	{
		group.getMarkers().forEach(plugin::deleteMarker);
		plugin.deleteGroup(group);
	}
}
