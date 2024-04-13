/*
 * Copyright (c) 2019, Jos <Malevolentdev@gmail.com>
 * Copyright (c) 2019, Rheon <https://github.com/Rheon-D>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.statusbars;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.EnumMap;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.MenuEntry;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.SpriteID;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.game.AlternateSprites;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.itemstats.Effect;
import net.runelite.client.plugins.itemstats.ItemStatChangesService;
import net.runelite.client.plugins.itemstats.StatChange;
import net.runelite.client.plugins.itemstats.stats.Stats;
import net.runelite.client.plugins.statusbars.config.BarMode;
import net.runelite.client.plugins.statusbars.config.BarPosition;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.util.ImageUtil;
import org.slf4j.LoggerFactory;

class StatusBarsOverlay extends Overlay
{
	private static final Color PRAYER_COLOR = new Color(50, 200, 200, 175);
	private static final Color ACTIVE_PRAYER_COLOR = new Color(57, 255, 186, 225);
	private static final Color HEALTH_COLOR = new Color(225, 35, 0, 125);
	private static final Color POISONED_COLOR = new Color(0, 145, 0, 150);
	private static final Color VENOMED_COLOR = new Color(0, 65, 0, 150);
	private static final Color HEAL_COLOR = new Color(255, 112, 6, 150);
	private static final Color PRAYER_HEAL_COLOR = new Color(57, 255, 186, 75);
	private static final Color ENERGY_HEAL_COLOR = new Color(199, 118, 0, 218);
	private static final Color RUN_STAMINA_COLOR = new Color(160, 124, 72, 255);
	private static final Color SPECIAL_ATTACK_COLOR = new Color(3, 153, 0, 195);
	private static final Color ENERGY_COLOR = new Color(199, 174, 0, 220);
	private static final Color DISEASE_COLOR = new Color(255, 193, 75, 181);
	private static final Color PARASITE_COLOR = new Color(196, 62, 109, 181);

	private static final int MAX_SPECIAL_ATTACK_VALUE = 100;
	private static final int MAX_RUN_ENERGY_VALUE = 100;

	private static final int MAX_ICON_SIZE = 24;

	private final Client client;
	private final StatusBarsPlugin plugin;
	private final StatusBarsConfig config;
	private final ItemStatChangesService itemStatService;
	private final SpriteManager spriteManager;

	private int currentBarWidth;
	private Image heartIcon;
	private Image specialIcon;
	private Image energyIcon;
	private Image prayerIcon;
	private Image heartDisease;
	private Image heartPoison;
	private Image heartVenom;

	private final BarGroupRenderer barGroupRenderer = new BarGroupRenderer();
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(StatusBarsOverlay.class);

	@Inject
	private StatusBarsOverlay(Client client, StatusBarsPlugin plugin, StatusBarsConfig config, SkillIconManager skillIconManager, ItemStatChangesService itemstatservice, SpriteManager spriteManager)
	{
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.itemStatService = itemstatservice;
		this.spriteManager = spriteManager;

		// Convert the plugin-specific position to an Overlay position
		switch (config.overlayPosition())
		{
			case ON_INTERFACE:
				setPosition(OverlayPosition.DYNAMIC);
				break;
			case FLOATING:
				// Actual value doesn't matter tons
				setPosition(OverlayPosition.BOTTOM_RIGHT);
				break;
		}

		setLayer(OverlayLayer.ABOVE_WIDGETS);

		initRenderers();
	}

	private void initRenderers()
	{
		Map<BarMode, BarRenderer> barRenderers = new EnumMap<>(BarMode.class);

		barRenderers.put(BarMode.DISABLED, null);
		barRenderers.put(BarMode.HITPOINTS, new BarRenderer(
			() -> inLms() ? Experience.MAX_REAL_LEVEL : client.getRealSkillLevel(Skill.HITPOINTS),
			() -> client.getBoostedSkillLevel(Skill.HITPOINTS),
			() -> getRestoreValue(Skill.HITPOINTS.getName()),
			() ->
			{
				final int poisonState = client.getVarpValue(VarPlayer.POISON);

				if (poisonState >= 1000000)
				{
					return VENOMED_COLOR;
				}

				if (poisonState > 0)
				{
					return POISONED_COLOR;
				}

				if (client.getVarpValue(VarPlayer.DISEASE_VALUE) > 0)
				{
					return DISEASE_COLOR;
				}

				if (client.getVarbitValue(Varbits.PARASITE) >= 1)
				{
					return PARASITE_COLOR;
				}

				return HEALTH_COLOR;
			},
			() -> HEAL_COLOR,
			() ->
			{
				final int poisonState = client.getVarpValue(VarPlayer.POISON);

				if (poisonState > 0 && poisonState < 50)
				{
					return heartPoison;
				}

				if (poisonState >= 1000000)
				{
					return heartVenom;
				}

				if (client.getVarpValue(VarPlayer.DISEASE_VALUE) > 0)
				{
					return heartDisease;
				}

				return heartIcon;
			}
		));
		barRenderers.put(BarMode.PRAYER, new BarRenderer(
			() -> inLms() ? Experience.MAX_REAL_LEVEL : client.getRealSkillLevel(Skill.PRAYER),
			() -> client.getBoostedSkillLevel(Skill.PRAYER),
			() -> getRestoreValue(Skill.PRAYER.getName()),
			() ->
			{
				Color prayerColor = PRAYER_COLOR;

				for (Prayer pray : Prayer.values())
				{
					if (client.isPrayerActive(pray))
					{
						prayerColor = ACTIVE_PRAYER_COLOR;
						break;
					}
				}

				return prayerColor;
			},
			() -> PRAYER_HEAL_COLOR,
			() -> prayerIcon
		));
		barRenderers.put(BarMode.RUN_ENERGY, new BarRenderer(
			() -> MAX_RUN_ENERGY_VALUE,
			() -> client.getEnergy() / 100,
			() -> getRestoreValue(Stats.RUN_ENERGY.getName()),
			() ->
			{
				if (client.getVarbitValue(Varbits.RUN_SLOWED_DEPLETION_ACTIVE) != 0)
				{
					return RUN_STAMINA_COLOR;
				}
				else
				{
					return ENERGY_COLOR;
				}
			},
			() -> ENERGY_HEAL_COLOR,
			() -> energyIcon
		));
		barRenderers.put(BarMode.SPECIAL_ATTACK, new BarRenderer(
			() -> MAX_SPECIAL_ATTACK_VALUE,
			() -> client.getVarpValue(VarPlayer.SPECIAL_ATTACK_PERCENT) / 10,
			() -> 0,
			() -> SPECIAL_ATTACK_COLOR,
			() -> SPECIAL_ATTACK_COLOR,
			() -> specialIcon
		));

		barGroupRenderer.attachRenderers(barRenderers);
	}

	@Override
	public Dimension render(Graphics2D g)
	{
		if (!plugin.isBarsDisplayed())
		{
			return null;
		}

		BarPosition barPosition = config.overlayPosition();

		PossibleViewports currentViewport = null;
		Widget currentWidget = null;

		if (barPosition == BarPosition.ON_INTERFACE)
		{
			for (PossibleViewports vp : PossibleViewports.values())
			{
				// Find one of our targeted widgets to attach to
				final Widget targetWidget = client.getWidget(vp.getTargetWidget());

				if (targetWidget != null && !targetWidget.isHidden())
				{
					currentViewport = vp;
					currentWidget = targetWidget;

					break;
				}
			}
		}

		if (currentViewport == null)
		{
			// Unable to find a matching Possible Viewport, so there's no place for us
			// to attach the bars to
			return null;
		}

		// Get the bar width here, since we may need to reload images due to the size of the bar
		int barWidth = currentViewport.getForcedBarWidth();
		if (barWidth <= -1)
		{
			// Indicates a "no force" value, so use the config value
			barWidth = config.barWidth();
		}

		// Ensure we have the images we need. Can't be done in the constructor as the sprites aren't
		// loaded when this plugin mounts
		ensureImagesAreLoaded(barWidth);

		barGroupRenderer.renderBars(config, g, currentBarWidth, currentWidget, currentViewport);

		return null;
	}

	/**
	 * For the given skill name, checks to see the potential amount to be restored by
	 * the user interacting with an item in their inventory.
	 *
	 * @param skill String identifier for the stat to check
	 * @return Points that would be restored if the item used
	 */
	private int getRestoreValue(String skill)
	{
		final MenuEntry[] menu = client.getMenuEntries();
		final int menuSize = menu.length;
		if (menuSize == 0)
		{
			// When no menus are present, there's no chance of restoring a stat
			return 0;
		}

		final MenuEntry entry = menu[menuSize - 1];
		final Widget widget = entry.getWidget();
		int restoreValue = 0;

		// Make sure we're interacting with something in the inventory widget
		if (widget != null && widget.getId() == ComponentID.INVENTORY_CONTAINER)
		{
			final Effect change = itemStatService.getItemStatChanges(widget.getItemId());

			if (change != null)
			{
				for (final StatChange c : change.calculate(client).getStatChanges())
				{
					final int value = c.getTheoretical();

					if (value != 0 && c.getStat().getName().equals(skill))
					{
						restoreValue = value;
					}
				}
			}
		}

		return restoreValue;
	}

	/**
	 * Loads necessary icons for all possible Status Bar types
	 */
	private void ensureImagesAreLoaded(int barWidth)
	{
		if (currentBarWidth != barWidth)
		{
			// Store this, so we only update when necessary
			currentBarWidth = barWidth;

			heartIcon = resizeIcon(loadSprite(SpriteID.MINIMAP_ORB_HITPOINTS_ICON));
			energyIcon = resizeIcon(loadSprite(SpriteID.MINIMAP_ORB_WALK_ICON));
			specialIcon = resizeIcon(loadSprite(SpriteID.MINIMAP_ORB_SPECIAL_ICON));
			prayerIcon = resizeIcon(loadSprite(SpriteID.MINIMAP_ORB_PRAYER_ICON));

			heartDisease = resizeIcon(loadAltSprite(AlternateSprites.DISEASE_HEART));
			heartPoison = resizeIcon(loadAltSprite(AlternateSprites.POISON_HEART));
			heartVenom = resizeIcon(loadAltSprite(AlternateSprites.VENOM_HEART));
		}
	}

	private BufferedImage resizeIcon(BufferedImage originalImage)
	{
		if (originalImage == null)
		{
			return null;
		}

		// Make sure the image won't be any larger or smaller than it needs to be
		int iconSize = Math.min(
			Math.max(
				currentBarWidth - (config.borderSize() * 2) - 4,
				0
			),
			// Don't let the icons get too big
			MAX_ICON_SIZE
		);

		// Double resizing is necessary so positioning/cropping is correct
		return ImageUtil.resizeCanvas(
			ImageUtil.resizeImage(originalImage,
				iconSize, iconSize
			),
			iconSize, iconSize
		);
	}

	private BufferedImage loadSprite(int spriteId)
	{
		return spriteManager.getSprite(spriteId, 0);
	}

	private BufferedImage loadAltSprite(String resourceName)
	{
		return ImageUtil.loadImageResource(AlternateSprites.class, resourceName);
	}

	/**
	 * Indicates if the user is currently in an LMS mini-game.
	 * Useful as stats are modified within.
	 */
	private boolean inLms()
	{
		return client.getWidget(ComponentID.LMS_INGAME_INFO) != null;
	}
}
