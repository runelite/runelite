package net.runelite.client.plugins.boosts;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import static net.runelite.api.MenuOpcode.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Skill;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;

@Singleton
class CombatIconsOverlay extends Overlay
{
	private final Client client;
	private final PanelComponent panelComponent = new PanelComponent();
	private final SkillIconManager iconManager;
	private final BoostsPlugin plugin;

	@Inject
	private CombatIconsOverlay(final Client client, final BoostsPlugin plugin, final SkillIconManager iconManager)
	{
		super(plugin);
		this.plugin = plugin;
		this.client = client;
		this.iconManager = iconManager;
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.MED);
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Boosts overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.isDisplayInfoboxes() || !plugin.isDisplayIcons())
		{
			return null;
		}

		if (plugin.isBoldIconFont())
		{
			graphics.setFont(FontManager.getRunescapeBoldFont());
		}

		panelComponent.getChildren().clear();
		panelComponent.setPreferredSize(new Dimension(28, 0));
		panelComponent.setWrapping(2);
		panelComponent.setBackgroundColor(null);
		panelComponent.setBorder(new Rectangle());

		if (plugin.canShowBoosts())
		{
			for (Skill skill : plugin.getShownSkills())
			{
				final int boosted = client.getBoostedSkillLevel(skill);
				final int base = client.getRealSkillLevel(skill);

				if (boosted == base)
				{
					continue;
				}

				final int boost = boosted - base;
				final Color strColor = getTextColor(boost);
				String str;

				if (plugin.isUseRelativeBoost())
				{
					str = String.valueOf(boost);
					if (boost > 0)
					{
						str = "+" + str;
					}
				}
				else
				{
					str = ColorUtil.prependColorTag(Integer.toString(boosted), strColor);
				}

				BufferedImage skillImage = iconManager.getSkillImage(skill, true);
				panelComponent.setOrientation(ComponentOrientation.HORIZONTAL);
				panelComponent.getChildren().add(new ImageComponent(skillImage));
				panelComponent.getChildren().add(LineComponent.builder()
					.left("")
					.right(str)
					.rightColor(strColor)
					.build());
			}
		}

		int nextChange = plugin.getChangeDownTicks();

		if (nextChange != -1)
		{
			BufferedImage buffImage = ImageUtil.getResourceStreamFromClass(getClass(), "buffedSmall.png");
			panelComponent.getChildren().add(new ImageComponent(buffImage));
			panelComponent.getChildren().add(LineComponent.builder()
				.left("")
				.right(String.valueOf(plugin.getChangeTime(nextChange)))
				.build());
		}

		nextChange = plugin.getChangeUpTicks();

		if (nextChange != -1)
		{
			BufferedImage debuffImage = ImageUtil.getResourceStreamFromClass(getClass(), "debuffedSmall.png");
			panelComponent.getChildren().add(new ImageComponent(debuffImage));
			panelComponent.getChildren().add(LineComponent.builder()
				.left("")
				.right(String.valueOf(plugin.getChangeTime(nextChange)))
				.build());
		}

		return panelComponent.render(graphics);
	}

	private Color getTextColor(int boost)
	{
		if (boost < 0)
		{
			return new Color(238, 51, 51);
		}

		return boost <= plugin.getBoostThreshold() ? Color.YELLOW : Color.GREEN;

	}
}
