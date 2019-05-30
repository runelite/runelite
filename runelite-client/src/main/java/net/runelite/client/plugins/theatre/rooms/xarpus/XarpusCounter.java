package net.runelite.client.plugins.theatre.rooms.xarpus;

import net.runelite.api.Client;
import net.runelite.client.plugins.theatre.TheatreConfig;
import net.runelite.client.plugins.theatre.TheatrePlugin;
import net.runelite.client.ui.overlay.*;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import java.awt.*;

import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;

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

			panelComponent.getChildren().add(LineComponent.builder()
					.left("Exhumes: ")
					.right(String.valueOf(xarpusHandler.getExhumesCount()))
					.build());

			return panelComponent.render(graphics);
		}

		return null;
	}
}