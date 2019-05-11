package net.runelite.client.plugins.dpscounter;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.util.Map;
import javax.inject.Inject;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ws.PartyService;

public class DpsOverlay extends Overlay
{
	private static final DecimalFormat DPS_FORMAT = new DecimalFormat("#0.0");

	private final DpsCounterPlugin dpsCounterPlugin;
	private final DpsConfig dpsConfig;
	private final PartyService partyService;

	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	DpsOverlay(DpsCounterPlugin dpsCounterPlugin, DpsConfig dpsConfig, PartyService partyService)
	{
		super(dpsCounterPlugin);
		this.dpsCounterPlugin = dpsCounterPlugin;
		this.dpsConfig = dpsConfig;
		this.partyService = partyService;
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, "Reset", "DPS counter"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Map<String, DpsMember> dpsMembers = dpsCounterPlugin.getMembers();
		if (dpsMembers.isEmpty())
		{
			return null;
		}

		boolean inParty = !partyService.getMembers().isEmpty();
		boolean showDamage = dpsConfig.showDamage();

		panelComponent.getChildren().clear();

		panelComponent.getChildren().add(
			TitleComponent.builder()
				.text(inParty ? "Party DPS" : "DPS")
				.build());

		for (DpsMember dpsMember : dpsMembers.values())
		{
			panelComponent.getChildren().add(
				LineComponent.builder()
					.left(dpsMember.getName())
					.right(showDamage ? Integer.toString(dpsMember.getDamage()) : DPS_FORMAT.format(dpsMember.getDps()))
					.build());
		}

		return panelComponent.render(graphics);
	}
}
