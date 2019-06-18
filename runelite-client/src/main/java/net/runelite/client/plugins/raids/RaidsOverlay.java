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

import com.google.common.collect.ImmutableList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
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
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;

public class RaidsOverlay extends Overlay
{
	private static final int OLM_PLANE = 0;
	private static final int BORDER_OFFSET = 2;
	private static final int ICON_SIZE = 32;
	private static final int SMALL_ICON_SIZE = 21;
	private static final int TITLE_COMPONENT_HEIGHT = 20;
	private static final int LINE_COMPONENT_HEIGHT = 16;
	private static final Pattern FIRST_HALF = Pattern.compile("Start, (.*), End,");
	private static final Pattern SECOND_HALF = Pattern.compile(", Start, (.*), End");
	private static final ImmutableList<String> goodCrabsFirst = ImmutableList.of(
		"FSCCP.PCSCF - #WNWSWN#ESEENW",
		"SCFCP.CSCFS - #ENEESW#ENWWSW",
		"SCFPC.CSPCF - #WSWWNE#WSEENE",
		"SCPFC.CCPSF - #NWWWSE#WNEESE",
		"SCPFC.CSPCF - #NEEESW#WWNEEE",
		"SCSPF.CCSPF - #ESWWNW#ESENES",
		"SPCFC.CSPCF - #WWNEEE#WSWNWS",
		"SCPFC.PCSCF - #WNEEES#NWSWNW", //rare crabs first bad crabs second
		"SFCCPC.PCSCPF - #WSEENES#WWWNEEE", //good crabs first rare crabs second rare crabs third
		"SCPFC.CCSSF - #NEESEN#WSWWNE" //good crabs
	);
	private static final ImmutableList<String> goodCrabsSecond = ImmutableList.of(
		"FSCCP.PCSCF - #WNWSWN#ESEENW",
		"FSCCS.PCPSF - #WSEEEN#WSWNWS",
		"FSCPC.CSCPF - #WNWWSE#EENWWW",
		"SCFCP.CCSPF - #ESEENW#ESWWNW",
		"SCFCP.CSCFS - #ENEESW#ENWWSW",
		"SCFPC.CSPCF - #WSWWNE#WSEENE",
		"SCFPC.PCCSF - #WSEENE#WWWSEE",
		"SCFPC.SCPCF - #NESENE#WSWWNE",
		"SCPFC.CCPSF - #NWWWSE#WNEESE",
		"SCPFC.CSPCF - #NEEESW#WWNEEE",
		"SCPFC.CSPSF - #WWSEEE#NWSWWN",
		"SCSPF.CCSPF - #ESWWNW#ESENES",
		"SFCCP.CSCPF - #WNEESE#NWSWWN",
		"SFCCS.PCPSF - #ENWWSW#ENESEN",
		"SPCFC.CSPCF - #WWNEEE#WSWNWS",
		"SPCFC.SCCPF - #ESENES#WWWNEE",
		"SPSFP.CCCSF - #NWSWWN#ESEENW", //bad crabs first good crabs second
		"SFCCPC.PCSCPF - #WSEENES#WWWNEEE", //good crabs first rare crabs second rare crabs third
		"FSCCP.PCSCF - #ENWWWS#NEESEN", //bad crabs first good crabs second
		"SCPFC.CCSSF - #NEESEN#WSWWNE" //good crabs
	);
	private final PanelComponent panelComponent = new PanelComponent();
	private final ItemManager itemManager;
	private final SpriteManager spriteManager;
	private final PanelComponent panelImages = new PanelComponent();
	private Client client;
	private RaidsPlugin plugin;
	private RaidsConfig config;
	@Setter
	private boolean sharable = false;

	@Getter
	@Setter
	private boolean scoutOverlayShown = false;

	@Getter
	private boolean scouterActive = false;

	@Getter
	private int width;

	@Getter
	private int height;

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
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.scoutOverlay() || !scoutOverlayShown || plugin.isInRaidChambers() && client.getPlane() == OLM_PLANE)
		{
			return null;
		}

		scouterActive = false;
		panelComponent.getChildren().clear();

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
		if (config.displayFloorBreak())
		{
			displayLayout = plugin.getRaid().getLayout().toCode();
			displayLayout = displayLayout.substring(0, displayLayout.length() - 1).replaceAll("#", "").replaceFirst("¤", " | ");
		}
		else
		{
			displayLayout = layout;
		}

		if (config.enableLayoutWhitelist() && !plugin.getLayoutWhitelist().contains(layout.toLowerCase()))
		{
			color = Color.RED;
		}

		Matcher firstMatcher = FIRST_HALF.matcher(plugin.getRaid().getFullRotationString());
		Matcher secondMatcher = SECOND_HALF.matcher(plugin.getRaid().getFullRotationString());
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
		String roomName = "";
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
					switch (RaidRoom.Boss.fromString(roomName))
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
					switch (RaidRoom.Puzzle.fromString(roomName))
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

		if ((config.hideVanguards() && vanguards) || (config.hideRopeless() && !tightrope) || (config.hideUnknownCombat() && unknownCombat))
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("Bad Raid!")
				.color(Color.RED)
				.build());

			return panelComponent.render(graphics);
		}

		scouterActive = true;
		displayLayout = (config.enhanceScouterTitle() ? "" + combatCount + "c " + puzzles + " " : "") + displayLayout;

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
		if (!recordRaid())
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text(displayLayout)
				.color(color)
				.build());
		}
		else
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("Record Raid")
				.color(Color.GREEN)
				.build());
			panelComponent.setBackgroundColor(new Color(0, 255, 0, 10));
		}

		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

		color = Color.ORANGE;
		if (sharable || config.alwaysShowWorldAndCC())
		{
			String clanOwner = Text.removeTags(client.getWidget(WidgetInfo.CLAN_CHAT_OWNER).getText());
			if (clanOwner.equals("None"))
			{
				clanOwner = "Open CC tab...";
				color = Color.RED;
			}

			tableComponent.addRow(ColorUtil.prependColorTag("W" + client.getWorld(), Color.ORANGE), ColorUtil.prependColorTag("" + clanOwner, color));
		}

		int bossMatches = 0;
		int bossCount = 0;
		roomCount = 0;

		if (config.enableRotationWhitelist())
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
						|| config.enableRotationWhitelist() && bossCount > bossMatches)
					{
						color = Color.RED;
					}

					String bossName = room.getBoss().getName();
					String bossNameLC = bossName.toLowerCase();
					if (config.showRecommendedItems())
					{
						if (plugin.getRecommendedItemsList().get(bossNameLC) != null)
						{
							imageIds.addAll(plugin.getRecommendedItemsList().get(bossNameLC));
						}
					}

					tableComponent.addRow(config.showRecommendedItems() ? "" : room.getType().getName(), ColorUtil.prependColorTag(bossName, color));

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
					if (config.colorTightrope() && puzzleNameLC.equals("tightrope"))
					{
						color = config.tightropeColor();
					}
					if (config.crabHandler() && puzzleNameLC.equals("crabs"))
					{
						if (firstMatcher.find() && secondMatcher.find())
						{
							if (crabHandler(firstMatcher.group(1), secondMatcher.group(1)))
							{
								color = config.crabColor();
							}
							else
							{
								color = Color.RED;
							}
						}
					}

					tableComponent.addRow(config.showRecommendedItems() ? "" : room.getType().getName(), ColorUtil.prependColorTag(puzzleName, color));
					break;
				case FARMING:
					if (config.showScavsFarms())
					{
						tableComponent.addRow("", ColorUtil.prependColorTag(room.getType().getName(), new Color(181, 230, 29)));
					}
					break;
				case SCAVENGERS:
					if (config.scavsBeforeOlm() && roomCount == lastScavs)
					{
						tableComponent.addRow(config.showRecommendedItems() ? "" : "OlmPrep", ColorUtil.prependColorTag("Scavs", config.scavPrepColor()));
					}
					else if (config.scavsBeforeIce() && scavsBeforeIceRooms.contains(roomCount))
					{
						tableComponent.addRow(config.showRecommendedItems() ? "" : "IcePrep", ColorUtil.prependColorTag("Scavs", config.scavPrepColor()));
					}
					else if (config.showScavsFarms())
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
		if (config.showRecommendedItems() && imageIds.size() > 0)
		{
			panelImages.getChildren().clear();
			Integer[] idArray = imageIds.toArray(new Integer[0]);
			int imagesVerticalOffset = TITLE_COMPONENT_HEIGHT + (sharable || config.alwaysShowWorldAndCC() ? LINE_COMPONENT_HEIGHT : 0) - BORDER_OFFSET;
			int imagesMaxHeight = height - 2 * BORDER_OFFSET - TITLE_COMPONENT_HEIGHT - (sharable || config.alwaysShowWorldAndCC() ? LINE_COMPONENT_HEIGHT : 0);
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

	private boolean crabHandler(String firstHalf, String secondHalf)
	{
		return (firstHalf.contains("Crabs") && goodCrabsFirst.contains(plugin.getLayoutFullCode()))
			|| (secondHalf.contains("Crabs") && goodCrabsSecond.contains(plugin.getLayoutFullCode()));
	}

	boolean recordRaid()
	{
		Matcher firstMatcher = FIRST_HALF.matcher(plugin.getRaid().getFullRotationString());
		Matcher secondMatcher = SECOND_HALF.matcher(plugin.getRaid().getFullRotationString());
		if (plugin.getRaid().getRotationString().toLowerCase().equals("vasa,tekton,vespula")
			&& plugin.getRaid().getFullRotationString().toLowerCase().contains("crabs")
			&& plugin.getRaid().getFullRotationString().toLowerCase().contains("tightrope"))
		{
			if (firstMatcher.find() && secondMatcher.find())
			{
				return (crabHandler(firstMatcher.group(1), secondMatcher.group(1)));
			}
		}
		return false;
	}
}
