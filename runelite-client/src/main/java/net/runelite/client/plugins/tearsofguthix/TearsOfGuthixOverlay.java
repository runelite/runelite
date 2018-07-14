package net.runelite.client.plugins.tearsofguthix;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import javax.inject.Inject;
import java.awt.*;

@Slf4j
public class TearsOfGuthixOverlay extends Overlay
{
	private final TearsOfGuthixPlugin plugin;

	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	TearsOfGuthixOverlay(TearsOfGuthixPlugin plugin)
	{
		setPosition(OverlayPosition.BOTTOM_LEFT);
		setPriority(OverlayPriority.LOW);
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.overlayActivated)
		{
			return null;
		}

		panelComponent.getChildren().clear();

		panelComponent.getChildren().add(LineComponent.builder().left(plugin.playerLowestSkill.getName())
				.right("Lvl - " + plugin.getClient().getRealSkillLevel(plugin.playerLowestSkill) + "").build());

		return panelComponent.render(graphics);
	}

}
