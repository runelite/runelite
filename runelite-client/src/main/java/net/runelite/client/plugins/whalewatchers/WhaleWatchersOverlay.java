package net.runelite.client.plugins.whalewatchers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class WhaleWatchersOverlay extends Overlay
{
	private Client client;
	private final WhaleWatchersConfig config;
	private WhaleWatchersPlugin plugin;
	private PanelComponent panelComponent;
	private String lastOpponent = "-";

	@Inject
	public WhaleWatchersOverlay(WhaleWatchersConfig config, Client client, WhaleWatchersPlugin plugin)
	{
		this.client = client;
		this.config = config;
		this.plugin = plugin;
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGH);
		setPosition(OverlayPosition.DETACHED);
		panelComponent = new PanelComponent();
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		panelComponent.getChildren().clear();

		if (plugin.inCombat && config.showDamageCounter())
		{
			panelComponent.setBackgroundColor(config.damageBackgroundColor());
			String opp = client.getLocalPlayer().getInteracting() != null ?
				client.getLocalPlayer().getInteracting().getName() : lastOpponent;
			if (client.getLocalPlayer().getInteracting() != null)
			{
				lastOpponent = client.getLocalPlayer().getInteracting().getName();
			}
			final String opponent = "Fight vs " + opp;
			String damageTaken = "Damage Taken: " + plugin.damageTaken;
			String damageDealt = "Damage Dealt: " + plugin.damageDone;

			panelComponent.getChildren().add(TitleComponent.builder()
				.text(opponent)
				.color(Color.BLACK)
				.build());

			panelComponent.getChildren().add(TitleComponent.builder()
				.text(damageDealt)
				.color(Color.BLACK)
				.build());

			panelComponent.getChildren().add(TitleComponent.builder()
				.text(damageTaken)
				.color(Color.BLACK)
				.build());

			panelComponent.setPreferredSize(new Dimension(
				graphics.getFontMetrics().stringWidth(damageDealt) +
					+ graphics.getFontMetrics().stringWidth(opponent) + 10,0));

		}
		else
		{
			panelComponent.getChildren().clear();
		}
		return panelComponent.render(graphics);
	}
}
