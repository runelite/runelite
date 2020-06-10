/*
 * Copyright (c) 2018, Kamiel
 * Copyright (c) 2020, Truth Forger <https://github.com/Blackberry0Pie>
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
package net.runelite.client.plugins.raids;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.ClanMemberManager;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;

import net.runelite.api.SpriteID;
import net.runelite.api.Varbits;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.game.WorldService;
import net.runelite.client.plugins.raids.solver.Room;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.util.ImageUtil;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldRegion;
import net.runelite.http.api.worlds.WorldResult;

public class RaidsOverlay extends OverlayPanel
{
	private static final int OLM_PLANE = 0;
	static final String BROADCAST_ACTION = "Broadcast layout";
	static final String SCREENSHOT_ACTION = "Screenshot";
	private static final int BORDER_OFFSET = 2;
	private static final int ICON_SIZE = 32;
	private static final int SMALL_ICON_SIZE = 21;
	//might need to edit these if they are not standard
	private static final int TITLE_COMPONENT_HEIGHT = 20;
	private static final int LINE_COMPONENT_HEIGHT = 16;

	private Client client;
	private RaidsPlugin plugin;
	private RaidsConfig config;

	private final ItemManager itemManager;
	private final SpriteManager spriteManager;
	private final PanelComponent panelImages = new PanelComponent();

	@Getter
	private boolean scoutOverlayShown = false;

	@Getter
	private int width;

	@Getter
	private int height;

	@Inject
	private WorldService worldService;

	@Inject
	private RaidsOverlay(Client client, RaidsPlugin plugin, RaidsConfig config, ItemManager itemManager, SpriteManager spriteManager)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.LOW);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.itemManager = itemManager;
		this.spriteManager = spriteManager;
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Raids overlay"));
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY, BROADCAST_ACTION, "Raids overlay"));
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY, SCREENSHOT_ACTION, "Raids overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		scoutOverlayShown = shouldShowOverlay();
		if (!scoutOverlayShown)
		{
			return null;
		}

		Color color = Color.WHITE;
		String layout = plugin.getRaid().getLayout().toCodeString();

		if (config.enableLayoutWhitelist() && !plugin.getLayoutWhitelist().contains(layout.toLowerCase()))
		{
			color = Color.RED;
		}

		panelComponent.getChildren().add(TitleComponent.builder()
			.text(layout)
			.color(color)
			.build());

		if (config.ccDisplay())
		{
			color = Color.RED;
			ClanMemberManager clanMemberManager = client.getClanMemberManager();
			FontMetrics metrics = graphics.getFontMetrics();

			String worldString = "W" + client.getWorld();
			WorldResult worldResult = worldService.getWorlds();
			if (worldResult != null)
			{
				World world = worldResult.findWorld(client.getWorld());
				WorldRegion region = world.getRegion();
				if (region != null)
				{
					String countryCode = region.getAlpha2();
					worldString += " (" + countryCode + ")";
				}
			}

			String clanOwner = "Join a CC";
			if (clanMemberManager != null)
			{
				clanOwner = clanMemberManager.getClanOwner();
				color = Color.ORANGE;
			}

			panelComponent.setPreferredSize(new Dimension(Math.max(ComponentConstants.STANDARD_WIDTH, metrics.stringWidth(worldString) + metrics.stringWidth(clanOwner) + 14), 0));
			panelComponent.getChildren().add(LineComponent.builder()
				.left(worldString)
				.right(clanOwner)
				.leftColor(Color.ORANGE)
				.rightColor(color)
				.build());
		}

		Set<Integer> imageIds = new HashSet<>();
		FontMetrics metrics = graphics.getFontMetrics();
		int roomWidth = 0;
		int temp = 0;

		for (Room layoutRoom : plugin.getRaid().getLayout().getRooms())
		{
			int position = layoutRoom.getPosition();
			RaidRoom room = plugin.getRaid().getRoom(position);

			if (room == null)
			{
				continue;
			}

			temp = metrics.stringWidth(room.getName());
			if (temp > roomWidth)
			{
				roomWidth = temp;
			}

			color = Color.WHITE;

			switch (room.getType())
			{
				case COMBAT:
					if (plugin.getRoomWhitelist().contains(room.getName().toLowerCase()))
					{
						color = Color.GREEN;
					}
					else if (plugin.getRoomBlacklist().contains(room.getName().toLowerCase())
							|| config.enableRotationWhitelist() && !plugin.getRotationMatches())
					{
						color = Color.RED;
					}

					String bossName = room.getName();
					String bossNameLC = bossName.toLowerCase();
					if (config.showRecommendedItems())
					{
						if (plugin.getRecommendedItemsList().get(bossNameLC) != null)
							imageIds.addAll(plugin.getRecommendedItemsList().get(bossNameLC));
					}

					panelComponent.getChildren().add(LineComponent.builder()
						.left(config.showRecommendedItems() ? "" : room.getType().getName())
						.right(bossName)
						.rightColor(color)
						.build());

					break;

				case PUZZLE:
					String puzzleName = room.getName();
					String puzzleNameLC = puzzleName.toLowerCase();
					if (plugin.getRecommendedItemsList().get(puzzleNameLC) != null)
						imageIds.addAll(plugin.getRecommendedItemsList().get(puzzleNameLC));
					if (plugin.getRoomWhitelist().contains(puzzleNameLC))
					{
						color = Color.GREEN;
					}
					else if (plugin.getRoomBlacklist().contains(puzzleNameLC))
					{
						color = Color.RED;
					}

					String name = room == RaidRoom.UNKNOWN_PUZZLE ? "Unknown" : puzzleName;

					panelComponent.getChildren().add(LineComponent.builder()
						.left(config.showRecommendedItems() ? "" : room.getType().getName())
						.right(name)
						.rightColor(color)
						.build());
					break;
			}
		}

		//add recommended items
		Dimension panelDims = super.render(graphics);
		width = (int) panelDims.getWidth();
		height = (int) panelDims.getHeight();
		if (config.showRecommendedItems() && imageIds.size() > 0)
		{
			panelImages.getChildren().clear();
			Integer[] idArray = imageIds.toArray(new Integer[0]);
			int imagesVerticalOffset = TITLE_COMPONENT_HEIGHT + (config.ccDisplay() ? LINE_COMPONENT_HEIGHT : 0) - BORDER_OFFSET;
			int imagesMaxHeight = height - BORDER_OFFSET - imagesVerticalOffset;
			boolean smallImages = false;

			panelImages.setPreferredLocation(new Point(0, imagesVerticalOffset));
			panelImages.setBackgroundColor(null);
			panelImages.setWrap(true);
			panelImages.setPreferredSize(new Dimension(2 * ICON_SIZE, 0));
			if (2 * imagesMaxHeight / ICON_SIZE < idArray.length)
			{
				smallImages = true;
				panelImages.setPreferredSize(new Dimension(3 * SMALL_ICON_SIZE, 0));
			}

			panelImages.setOrientation(ComponentOrientation.HORIZONTAL);
			for (Integer e : idArray)
			{
				final BufferedImage image = getImage(e, smallImages);
				if (image != null)
				{
					panelImages.getChildren().add(new ImageComponent(image));
				}
			}

			panelImages.render(graphics);
		}
		return panelDims;
	}

	private boolean shouldShowOverlay()
	{
		if (plugin.getRaid() == null
			|| plugin.getRaid().getLayout() == null
			|| !config.scoutOverlay())
		{
			return false;
		}

		if (plugin.isInRaidChambers())
		{
			// If the raid has started
			if (client.getVar(Varbits.RAID_STATE) > 0)
			{
				if (client.getPlane() == OLM_PLANE)
				{
					return false;
				}

				return config.scoutOverlayInRaid();
			}
			else
			{
				return true;
			}
		}

		return plugin.getRaidPartyID() != -1 && config.scoutOverlayAtBank();
	}

	private BufferedImage getImage(int id, boolean small)
	{
		BufferedImage bim;
		if (id != SpriteID.SPELL_ICE_BARRAGE)
			bim = itemManager.getImage(id);
		else
			bim = spriteManager.getSprite(id, 0);
		if (bim == null)
			return null;
		if (!small)
			return ImageUtil.resizeCanvas(bim, ICON_SIZE, ICON_SIZE);
		if (id != SpriteID.SPELL_ICE_BARRAGE)
			return ImageUtil.resizeImage(bim, SMALL_ICON_SIZE, SMALL_ICON_SIZE);
		return ImageUtil.resizeCanvas(bim, SMALL_ICON_SIZE, SMALL_ICON_SIZE);
	}
}
