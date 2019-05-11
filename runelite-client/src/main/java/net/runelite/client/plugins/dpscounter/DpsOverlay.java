package net.runelite.client.plugins.dpscounter;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ws.PartyService;

public class DpsOverlay extends Overlay
{
	private final DpsCounterPlugin dpsCounterPlugin;
	private final PartyService partyService;

	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	DpsOverlay(DpsCounterPlugin dpsCounterPlugin, PartyService partyService)
	{
		super(dpsCounterPlugin);
		this.dpsCounterPlugin = dpsCounterPlugin;
		this.partyService = partyService;
		//setPosition(OverlayPosition.TOP_LEFT);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Map<String, DpsMember> dpsMembers = dpsCounterPlugin.getMembers();

		panelComponent.getChildren().clear();
		panelComponent.getChildren().add(
			TitleComponent.builder()
				.text("DPS")
				//olor(HIGHLIGHT_COLOR)
				.build());

//		panelComponent.getChildren().add(
//			LineComponent.builder()
//				.left("Player")
//			//	.leftColor(HIGHLIGHT_COLOR)
//				.right("DPS")
//			//	.rightColor(HIGHLIGHT_COLOR)
//				.build());

		for (DpsMember dpsMember : dpsMembers.values()) {
			panelComponent.getChildren().add(
				LineComponent.builder()
					.left(dpsMember.getName())
					.right(Integer.toString(dpsMember.getDps()))
					//.right(Integer.toString(playerSkillLevel) + "/" + Integer.toString(opponentSkillLevel))
					//.rightColor(comparisonStatColor(playerSkillLevel, opponentSkillLevel))
					.build());
		}

		//partyService.getMemberByName()
//		for (PartyMember member : partyService.getMembers()) {
//			DpsMember dpsMember = dpsMembers.get(member.getName());
//			if (dpsMember == null) continue;
//			panelComponent.getChildren().add(
//				LineComponent.builder()
//					.left(member.getName())
//					.right(Integer.toString(dpsMember.getDps()))
//					//.right(Integer.toString(playerSkillLevel) + "/" + Integer.toString(opponentSkillLevel))
//					//.rightColor(comparisonStatColor(playerSkillLevel, opponentSkillLevel))
//					.build());
//		}
		return panelComponent.render(graphics);
	}
}
