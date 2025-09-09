/*
 * Copyright (c) 2021, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.groundmarkers;

import com.google.common.base.Strings;
import com.google.common.util.concurrent.Runnables;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.menus.WidgetMenuOption;

@Slf4j
class GroundMarkerSharingManager
{
	private static final WidgetMenuOption EXPORT_MARKERS_OPTION = new WidgetMenuOption("Export", "Ground Markers", InterfaceID.Orbs.WORLDMAP);
	private static final WidgetMenuOption IMPORT_MARKERS_OPTION = new WidgetMenuOption("Import", "Ground Markers", InterfaceID.Orbs.WORLDMAP);
	private static final WidgetMenuOption CLEAR_MARKERS_OPTION = new WidgetMenuOption("Clear", "Ground Markers", InterfaceID.Orbs.WORLDMAP);

	private final GroundMarkerPlugin plugin;
	private final Client client;
	private final MenuManager menuManager;
	private final ChatMessageManager chatMessageManager;
	private final ChatboxPanelManager chatboxPanelManager;
	private final Gson gson;

	@Inject
	private GroundMarkerSharingManager(GroundMarkerPlugin plugin, Client client, MenuManager menuManager,
		ChatMessageManager chatMessageManager, ChatboxPanelManager chatboxPanelManager, Gson gson)
	{
		this.plugin = plugin;
		this.client = client;
		this.menuManager = menuManager;
		this.chatMessageManager = chatMessageManager;
		this.chatboxPanelManager = chatboxPanelManager;
		this.gson = gson;
	}

	void addImportExportMenuOptions()
	{
		menuManager.addManagedCustomMenu(EXPORT_MARKERS_OPTION, this::exportGroundMarkers);
		menuManager.addManagedCustomMenu(IMPORT_MARKERS_OPTION, this::promptForImport);
	}

	void addClearMenuOption()
	{
		menuManager.addManagedCustomMenu(CLEAR_MARKERS_OPTION, this::promptForClear);
	}

	void removeMenuOptions()
	{
		menuManager.removeManagedCustomMenu(EXPORT_MARKERS_OPTION);
		menuManager.removeManagedCustomMenu(IMPORT_MARKERS_OPTION);
		menuManager.removeManagedCustomMenu(CLEAR_MARKERS_OPTION);
	}

	private void exportGroundMarkers(MenuEntry menuEntry)
	{
		int[] regions = client.getMapRegions();
		if (regions == null)
		{
			return;
		}

		List<GroundMarkerPoint> activePoints = Arrays.stream(regions)
			.mapToObj(regionId -> plugin.getPoints(regionId).stream())
			.flatMap(Function.identity())
			.collect(Collectors.toList());

		if (activePoints.isEmpty())
		{
			sendChatMessage("You have no ground markers to export.");
			return;
		}

		final String exportDump = gson.toJson(activePoints);

		log.debug("Exported ground markers: {}", exportDump);

		Toolkit.getDefaultToolkit()
			.getSystemClipboard()
			.setContents(new StringSelection(exportDump), null);
		sendChatMessage(activePoints.size() + " ground markers were copied to your clipboard.");
	}

	private void promptForImport(MenuEntry menuEntry)
	{
		final String clipboardText;
		try
		{
			clipboardText = Toolkit.getDefaultToolkit()
				.getSystemClipboard()
				.getData(DataFlavor.stringFlavor)
				.toString();
		}
		catch (IOException | UnsupportedFlavorException ex)
		{
			sendChatMessage("Unable to read system clipboard.");
			log.warn("error reading clipboard", ex);
			return;
		}

		log.debug("Clipboard contents: {}", clipboardText);
		if (Strings.isNullOrEmpty(clipboardText))
		{
			sendChatMessage("You do not have any ground markers copied in your clipboard.");
			return;
		}

		List<GroundMarkerPoint> importPoints;
		try
		{
			// CHECKSTYLE:OFF
			importPoints = gson.fromJson(clipboardText, new TypeToken<List<GroundMarkerPoint>>(){}.getType());
			// CHECKSTYLE:ON
		}
		catch (JsonSyntaxException e)
		{
			log.debug("Malformed JSON for clipboard import", e);
			sendChatMessage("You do not have any ground markers copied in your clipboard.");
			return;
		}

		if (importPoints.isEmpty())
		{
			sendChatMessage("You do not have any ground markers copied in your clipboard.");
			return;
		}

		chatboxPanelManager.openTextMenuInput("Are you sure you want to import " + importPoints.size() + " ground markers?")
			.option("Yes", () -> importGroundMarkers(importPoints))
			.option("No", Runnables.doNothing())
			.build();
	}

	private void importGroundMarkers(Collection<GroundMarkerPoint> importPoints)
	{
		// regions being imported may not be loaded on client,
		// so need to import each bunch directly into the config
		// first, collate the list of unique region ids in the import
		Map<Integer, List<GroundMarkerPoint>> regionGroupedPoints = importPoints.stream()
			.collect(Collectors.groupingBy(GroundMarkerPoint::getRegionId));

		// now import each region into the config
		regionGroupedPoints.forEach((regionId, groupedPoints) ->
		{
			// combine imported points with existing region points
			log.debug("Importing {} points to region {}", groupedPoints.size(), regionId);
			Collection<GroundMarkerPoint> regionPoints = plugin.getPoints(regionId);

			List<GroundMarkerPoint> mergedList = new ArrayList<>(regionPoints.size() + groupedPoints.size());
			// add existing points
			mergedList.addAll(regionPoints);

			// add new points
			for (GroundMarkerPoint point : groupedPoints)
			{
				// filter out duplicates
				if (!mergedList.contains(point))
				{
					mergedList.add(point);
				}
			}

			plugin.savePoints(regionId, mergedList);
		});

		// reload points from config
		log.debug("Reloading points after import");
		plugin.loadPoints();
		sendChatMessage(importPoints.size() + " ground markers were imported from the clipboard.");
	}

	private void promptForClear(MenuEntry entry)
	{
		int[] regions = client.getMapRegions();
		if (regions == null)
		{
			return;
		}

		long numActivePoints = Arrays.stream(regions)
			.mapToLong(regionId -> plugin.getPoints(regionId).size())
			.sum();

		if (numActivePoints == 0)
		{
			sendChatMessage("You have no ground markers to clear.");
			return;
		}

		chatboxPanelManager.openTextMenuInput("Are you sure you want to clear the<br>" + numActivePoints + " currently loaded ground markers?")
			.option("Yes", () ->
			{
				for (int regionId : regions)
				{
					plugin.savePoints(regionId, null);
				}

				plugin.loadPoints();
				sendChatMessage(numActivePoints + " ground marker"
					+ (numActivePoints == 1 ? " was cleared." : "s were cleared."));

			})
			.option("No", Runnables.doNothing())
			.build();
	}

	private void sendChatMessage(final String message)
	{
		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.CONSOLE)
			.runeLiteFormattedMessage(message)
			.build());
	}
}
