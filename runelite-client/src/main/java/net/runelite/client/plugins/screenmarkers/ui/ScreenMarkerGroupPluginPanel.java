package net.runelite.client.plugins.screenmarkers.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import lombok.Getter;
import net.runelite.client.plugins.screenmarkers.ScreenMarkerGroup;
import net.runelite.client.plugins.screenmarkers.ScreenMarkerPlugin;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.components.PluginErrorPanel;
import net.runelite.client.util.ImageUtil;

public class ScreenMarkerGroupPluginPanel extends JPanel
{
	private static final ImageIcon ADD_ICON;
	private static final ImageIcon ADD_HOVER_ICON;
	private static final ImageIcon BACK_ICON;
	private static final ImageIcon BACK_HOVER_ICON;

	private final JLabel addMarker = new JLabel(ADD_ICON);
	private final JLabel back = new JLabel(BACK_ICON);
	private final JLabel title = new JLabel();
	private final PluginErrorPanel noMarkersPanel = new PluginErrorPanel();

	@Getter
	private final JPanel northPanel = new JPanel(new BorderLayout());

	@Getter
	private final JPanel markerView = new JPanel(new GridBagLayout());

	@Getter
	private ScreenMarkerCreationPanel creationPanel;

	private final ScreenMarkerPlugin plugin;
	private final ScreenMarkerGroup group;

	static
	{
		final BufferedImage addIcon = ImageUtil.getResourceStreamFromClass(ScreenMarkerPlugin.class, "add_icon.png");
		ADD_ICON = new ImageIcon(addIcon);
		ADD_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(addIcon, 0.53f));

		final BufferedImage backIcon = ImageUtil.getResourceStreamFromClass(ScreenMarkerPlugin.class, "back_icon.png");
		BACK_ICON = new ImageIcon(backIcon);
		BACK_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(backIcon, 0.53f));
	}

	public ScreenMarkerGroupPluginPanel(ScreenMarkerPlugin plugin, ScreenMarkerPluginPanel panel, ScreenMarkerGroup group)
	{
		this.plugin = plugin;
		this.group = group;
		final ScreenMarkerGroupPluginPanel groupPanel = this;

		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 10, 10, 10));

		northPanel.setBorder(new EmptyBorder(1, 0, 10, 0));

		title.setText(group.getName());
		title.setForeground(Color.WHITE);

		northPanel.add(title, BorderLayout.WEST);
		northPanel.add(addMarker, BorderLayout.CENTER);
		northPanel.add(back, BorderLayout.EAST);

		addMarker.setToolTipText("Add new screen marker");
		addMarker.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				setCreation(true);
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				addMarker.setIcon(ADD_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				addMarker.setIcon(ADD_ICON);
			}
		});

		back.setToolTipText("Go back");
		addMarker.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				panel.hideActiveGroup(groupPanel);
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				back.setIcon(BACK_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				back.setIcon(BACK_ICON);
			}
		});

		markerView.setBackground(ColorScheme.DARK_GRAY_COLOR);

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1;
		constraints.gridx = 0;
		constraints.gridy = 0;

		noMarkersPanel.setContent("Screen Markers", "Highlight a region on your screen.");
		noMarkersPanel.setVisible(false);

		markerView.add(noMarkersPanel, constraints);
		constraints.gridy++;

		creationPanel = new ScreenMarkerCreationPanel(plugin);
		creationPanel.setVisible(false);

		markerView.add(creationPanel, constraints);
		constraints.gridy++;
	}

	public void setCreation(boolean on)
	{
		if (on)
		{
			noMarkersPanel.setVisible(false);
			title.setVisible(true);
		}
		else
		{
			boolean empty = group.getMarkers().isEmpty();
			noMarkersPanel.setVisible(empty);
			title.setVisible(!empty);
		}

		creationPanel.setVisible(on);
		addMarker.setVisible(!on);

		if (on)
		{
			creationPanel.lockConfirm();
			plugin.setMouseListenerEnabled(true);
		}
	}
}
