package net.runelite.client.plugins.theatre.rooms.xarpus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.client.plugins.theatre.TheatreConfig;
import net.runelite.client.plugins.theatre.TheatrePlugin;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.table.TableComponent;

public class XarpusCounter extends Overlay
{

	private final Client client;
	private final TheatrePlugin plugin;
	private final TheatreConfig config;

	private XarpusHandler xarpusHandler;

	PanelComponent panelComponent = new PanelComponent();

	public XarpusCounter(Client client, TheatrePlugin plugin, TheatreConfig config, XarpusHandler xarpushandler)
	{
		super(plugin);
		this.client = client;
		this.xarpusHandler = xarpushandler;
		this.plugin = plugin;
		this.config = config;

		setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Theatre xarpus overlay"));

	}

	@Override
	public Dimension render(Graphics2D graphics)
	{

		if (xarpusHandler.getNpc().getId() == 8339)
		{
			panelComponent.getChildren().clear();
			String overlayTitle = "Exhume Counter";

			// Build overlay title
			panelComponent.getChildren().add(TitleComponent.builder()
					.text(overlayTitle)
					.color(Color.GREEN)
					.build());

			//Set the size of overlay
			panelComponent.setPreferredSize(new Dimension(
					graphics.getFontMetrics().stringWidth(overlayTitle) + 30, 0
			));

			TableComponent tableComponent = new TableComponent();
			tableComponent.addRow("Exhumes", String.valueOf(xarpusHandler.getExhumesCount()));

			panelComponent.getChildren().add(tableComponent);

			return panelComponent.render(graphics);
		}

		return null;
	}
}