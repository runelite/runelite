/*
 * Copyright (c) 2018, Kamiel
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import static net.runelite.api.MenuOpcode.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.SpriteID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.raids.solver.Room;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;
import net.runelite.api.util.Text;

@Singleton
public class RaidsOverlay extends Overlay
{
	private static final int OLM_PLANE = 0;
	private static final int BORDER_OFFSET = 2;
	private static final int ICON_SIZE = 32;
	private static final int SMALL_ICON_SIZE = 21;
	private static final int TITLE_COMPONENT_HEIGHT = 20;
	private static final int LINE_COMPONENT_HEIGHT = 16;
	private final PanelComponent panelComponent = new PanelComponent();
	private final ItemManager itemManager;
	private final SpriteManager spriteManager;
	private final PanelComponent panelImages = new PanelComponent();
	private final Client client;
	private final RaidsPlugin plugin;
	@Setter(AccessLevel.PACKAGE)
	private boolean sharable = false;
	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean scoutOverlayShown = false;
	@Getter(AccessLevel.PACKAGE)
	private boolean scouterActive = false;
	@Getter(AccessLevel.PACKAGE)
	private int width;
	@Getter(AccessLevel.PACKAGE)
	private int height;

	@Inject
	private RaidsOverlay(final Client client, final RaidsPlugin plugin, final ItemManager itemManager, final SpriteManager spriteManager)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.LOW);
		this.client = client;
		this.plugin = plugin;
		this.itemManager = itemManager;
		this.spriteManager = spriteManager;
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Raids overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isScoutOverlay() || !scoutOverlayShown || plugin.isInRaidChambers() && client.getPlane() == OLM_PLANE)
		{
			return null;
		}

		scouterActive = false;
		panelComponent.getChildren().clear();

		if (plugin.isHideBackground())
		{
			panelComponent.setBackgroundColor(null);
		}
		else
		{
			panelComponent.setBackgroundColor(ComponentConstants.STANDARD_BACKGROUND_COLOR);
		}

		if (plugin.getRaid() == null || plugin.getRaid().getLayout() == null)
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("Unable to scout this raid!")
				.color(Color.RED)
				.build());

			return panelComponent.render(graphics);
		}

		Color color = Color.WHITE;
		String layout = plugin.getRaid().getLayout().toCodeString();
		String displayLayout;
		if (plugin.isDisplayFloorBreak())
		{
			displayLayout = plugin.getRaid().getLayout().toCode();
			displayLayout = displayLayout.substring(0, displayLayout.length() - 1).replaceAll("#", "").replaceFirst("¤", " | ");
		}
		else
		{
			displayLayout = layout;
		}

		if (plugin.isEnableLayoutWhitelist() && !plugin.getLayoutWhitelist().contains(layout.toLowerCase()))
		{
			color = Color.RED;
		}
		int combatCount = 0;
		int roomCount = 0;
		List<Integer> iceRooms = new ArrayList<>();
		List<Integer> scavRooms = new ArrayList<>();
		List<Integer> scavsBeforeIceRooms = new ArrayList<>();
		boolean crabs = false;
		boolean iceDemon = false;
		boolean tightrope = false;
		boolean thieving = false;
		boolean vanguards = false;
		boolean unknownCombat = false;
		String puzzles = "";
		String roomName;
		for (Room layoutRoom : plugin.getRaid().getLayout().getRooms())
		{
			int position = layoutRoom.getPosition();
			RaidRoom room = plugin.getRaid().getRoom(position);

			if (room == null)
			{
				continue;
			}

			switch (room.getType())
			{
				case COMBAT:
					combatCount++;
					roomName = room.getBoss().getName();
					switch (Objects.requireNonNull(RaidRoom.Boss.fromString(roomName)))
					{
						case VANGUARDS:
							vanguards = true;
							break;
						case UNKNOWN:
							unknownCombat = true;
							break;
					}
					break;
				case PUZZLE:
					roomName = room.getPuzzle().getName();
					switch (Objects.requireNonNull(RaidRoom.Puzzle.fromString(roomName)))
					{
						case CRABS:
							crabs = true;
							break;
						case ICE_DEMON:
							iceDemon = true;
							iceRooms.add(roomCount);
							break;
						case THIEVING:
							thieving = true;
							break;
						case TIGHTROPE:
							tightrope = true;
							break;
					}
					break;
				case SCAVENGERS:
					scavRooms.add(roomCount);
					break;
			}
			roomCount++;
		}
		if (tightrope)
		{
			puzzles = crabs ? "cr" : iceDemon ? "ri" : thieving ? "tr" : "?r";
		}

		if ((plugin.isHideVanguards() && vanguards) || (plugin.isHideRopeless() && !tightrope) || (plugin.isHideUnknownCombat() && unknownCombat))
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("Bad Raid!")
				.color(Color.RED)
				.build());

			return panelComponent.render(graphics);
		}

		scouterActive = true;
		displayLayout = (plugin.isEnhanceScouterTitle() ? "" + combatCount + "c " + puzzles + " " : "") + displayLayout;

		for (Integer i : iceRooms)
		{
			int prev = 0;
			for (Integer s : scavRooms)
			{
				if (s > i)
				{
					break;
				}
				prev = s;
			}
			scavsBeforeIceRooms.add(prev);
		}
		int lastScavs = scavRooms.get(scavRooms.size() - 1);

		panelComponent.getChildren().add(TitleComponent.builder()
			.text(displayLayout)
			.color(color)
			.build());

		if (plugin.recordRaid() != null)
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("Record Raid")
				.color(Color.GREEN)
				.build());
			panelComponent.setBackgroundColor(new Color(0, 255, 0, 10));
		}
		else
		{
			if (plugin.isHideBackground())
			{
				panelComponent.setBackgroundColor(null);
			}
			else
			{
				panelComponent.setBackgroundColor(ComponentConstants.STANDARD_BACKGROUND_COLOR);
			}
		}

		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

		color = Color.ORANGE;
		if (sharable || plugin.isAlwaysShowWorldAndCC())
		{
			String clanOwner = Text.removeTags(client.getWidget(WidgetInfo.CLAN_CHAT_OWNER).getText());
			if (clanOwner.equals("None"))
			{
				clanOwner = "Open CC Tab";
				color = Color.RED;
			}

			tableComponent.addRow(ColorUtil.prependColorTag("W" + client.getWorld(), Color.ORANGE), ColorUtil.prependColorTag("" + clanOwner, color));
		}

		int bossMatches = 0;
		int bossCount = 0;
		roomCount = 0;

		if (plugin.isEnableRotationWhitelist())
		{
			bossMatches = plugin.getRotationMatches();
		}

		Set<Integer> imageIds = new HashSet<>();
		for (Room layoutRoom : plugin.getRaid().getLayout().getRooms())
		{
			int position = layoutRoom.getPosition();
			RaidRoom room = plugin.getRaid().getRoom(position);

			if (room == null)
			{
				continue;
			}

			color = Color.WHITE;

			switch (room.getType())
			{
				case COMBAT:
					bossCount++;
					if (plugin.getRoomWhitelist().contains(room.getBoss().getName().toLowerCase()))
					{
						color = Color.GREEN;
					}
					else if (plugin.getRoomBlacklist().contains(room.getBoss().getName().toLowerCase())
						|| plugin.isEnableRotationWhitelist() && bossCount > bossMatches)
					{
						color = Color.RED;
					}

					String bossName = room.getBoss().getName();
					String bossNameLC = bossName.toLowerCase();
					if (plugin.isShowRecommendedItems() && plugin.getRecommendedItemsList().get(bossNameLC) != null)
					{
						imageIds.addAll(plugin.getRecommendedItemsList().get(bossNameLC));
					}

					tableComponent.addRow(plugin.isShowRecommendedItems() ? "" : room.getType().getName(), ColorUtil.prependColorTag(bossName, color));

					break;

				case PUZZLE:
					String puzzleName = room.getPuzzle().getName();
					String puzzleNameLC = puzzleName.toLowerCase();
					if (plugin.getRecommendedItemsList().get(puzzleNameLC) != null)
					{
						imageIds.addAll(plugin.getRecommendedItemsList().get(puzzleNameLC));
					}
					if (plugin.getRoomWhitelist().contains(puzzleNameLC))
					{
						color = Color.GREEN;
					}
					else if (plugin.getRoomBlacklist().contains(puzzleNameLC))
					{
						color = Color.RED;
					}
					if (plugin.isColorTightrope() && puzzleNameLC.equals("tightrope"))
					{
						color = plugin.getTightropeColor();
					}
					if (plugin.isCrabHandler() && puzzleNameLC.equals("crabs"))
					{
						if (plugin.getGoodCrabs() == null)
						{
							color = Color.RED;
						}
						else
						{
							switch (plugin.getGoodCrabs())
							{
								case "Good Crabs":
									color = plugin.getGoodCrabColor();
									break;
								case "Rare Crabs":
									color = plugin.getRareCrabColor();
									break;
							}
						}
					}

					tableComponent.addRow(plugin.isShowRecommendedItems() ? "" : room.getType().getName(), ColorUtil.prependColorTag(puzzleName, color));
					break;
				case FARMING:
					if (plugin.isShowScavsFarms())
					{
						tableComponent.addRow("", ColorUtil.prependColorTag(room.getType().getName(), new Color(181, 230, 29)));
					}
					break;
				case SCAVENGERS:
					if (plugin.isScavsBeforeOlm() && roomCount == lastScavs)
					{
						tableComponent.addRow(plugin.isShowRecommendedItems() ? "" : "OlmPrep", ColorUtil.prependColorTag("Scavs", plugin.getScavPrepColor()));
					}
					else if (plugin.isScavsBeforeIce() && scavsBeforeIceRooms.contains(roomCount))
					{
						tableComponent.addRow(plugin.isShowRecommendedItems() ? "" : "IcePrep", ColorUtil.prependColorTag("Scavs", plugin.getScavPrepColor()));
					}
					else if (plugin.isShowScavsFarms())
					{
						tableComponent.addRow("", ColorUtil.prependColorTag("Scavs", new Color(181, 230, 29)));
					}
					break;
			}
			roomCount++;
		}

		panelComponent.getChildren().add(tableComponent);

		Dimension panelDims = panelComponent.render(graphics);
		width = (int) panelDims.getWidth();
		height = (int) panelDims.getHeight();

		//add recommended items
		if (plugin.isShowRecommendedItems() && imageIds.size() > 0)
		{
			panelImages.getChildren().clear();
			Integer[] idArray = imageIds.toArray(new Integer[0]);
			int imagesVerticalOffset = TITLE_COMPONENT_HEIGHT + (sharable || plugin.isAlwaysShowWorldAndCC() ? LINE_COMPONENT_HEIGHT : 0) - BORDER_OFFSET;
			int imagesMaxHeight = height - 2 * BORDER_OFFSET - TITLE_COMPONENT_HEIGHT - (sharable || plugin.isAlwaysShowWorldAndCC() ? LINE_COMPONENT_HEIGHT : 0);
			boolean smallImages = false;

			panelImages.setPreferredLocation(new Point(0, imagesVerticalOffset));
			panelImages.setBackgroundColor(null);
			if (2 * (imagesMaxHeight / ICON_SIZE) >= idArray.length)
			{
				panelImages.setWrapping(2);
			}
			else
			{
				panelImages.setWrapping(3);
				smallImages = true;
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

	private BufferedImage getImage(int id, boolean small)
	{
		BufferedImage bim;
		if (id != SpriteID.SPELL_ICE_BARRAGE)
		{
			bim = itemManager.getImage(id);
		}
		else
		{
			bim = spriteManager.getSprite(id, 0);
		}
		if (bim == null)
		{
			return null;
		}
		if (!small)
		{
			return ImageUtil.resizeCanvas(bim, ICON_SIZE, ICON_SIZE);
		}
		if (id != SpriteID.SPELL_ICE_BARRAGE)
		{
			return ImageUtil.resizeImage(bim, SMALL_ICON_SIZE, SMALL_ICON_SIZE);
		}
		return ImageUtil.resizeCanvas(bim, SMALL_ICON_SIZE, SMALL_ICON_SIZE);
	}
}
