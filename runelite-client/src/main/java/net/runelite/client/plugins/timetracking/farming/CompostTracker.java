/*
 * Copyright (c) 2022 LlemonDuck
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.timetracking.farming;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.ItemID;
import net.runelite.api.ObjectComposition;
import net.runelite.api.Tile;
import net.runelite.api.annotations.Varbit;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.timetracking.TimeTrackingConfig;

@Singleton
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class CompostTracker
{

	@Value
	@VisibleForTesting
	static class PendingCompost
	{
		Instant timeout;
		WorldPoint patchLocation;
		FarmingPatch farmingPatch;
	}

	private static final Duration COMPOST_ACTION_TIMEOUT = Duration.ofSeconds(30);

	private static final Pattern COMPOST_USED_ON_PATCH = Pattern.compile(
		"You treat the .+ with (?<compostType>ultra|super|)compost\\.");
	private static final Pattern FERTILE_SOIL_CAST = Pattern.compile(
		"^The .+ has been treated with (?<compostType>ultra|super|)compost");
	private static final Pattern ALREADY_TREATED = Pattern.compile(
		"This .+ has already been (treated|fertilised) with (?<compostType>ultra|super|)compost(?: - the spell can't make it any more fertile)?\\.");
	private static final Pattern INSPECT_PATCH = Pattern.compile(
		"This is an? .+\\. The soil has been treated with (?<compostType>ultra|super|)compost\\..*");

	private static final ImmutableSet<Integer> COMPOST_ITEMS = ImmutableSet.of(
		ItemID.COMPOST,
		ItemID.SUPERCOMPOST,
		ItemID.ULTRACOMPOST,
		ItemID.BOTTOMLESS_COMPOST_BUCKET_22997
	);

	private final Client client;
	private final FarmingWorld farmingWorld;
	private final ConfigManager configManager;

	@VisibleForTesting
	final Map<FarmingPatch, PendingCompost> pendingCompostActions = new HashMap<>();

	private static String configKey(FarmingPatch fp)
	{
		return fp.configKey() + "." + TimeTrackingConfig.COMPOST;
	}

	public void setCompostState(FarmingPatch fp, CompostState state)
	{
		log.debug("Storing compost state [{}] for patch [{}]", state, fp);
		if (state == null)
		{
			configManager.unsetRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, configKey(fp));
		}
		else
		{
			configManager.setRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, configKey(fp), state);
		}
	}

	public CompostState getCompostState(FarmingPatch fp)
	{
		return configManager.getRSProfileConfiguration(
			TimeTrackingConfig.CONFIG_GROUP,
			configKey(fp),
			CompostState.class
		);
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked e)
	{
		if (!isCompostAction(e))
		{
			return;
		}

		ObjectComposition patchDef = client.getObjectDefinition(e.getId());
		WorldPoint actionLocation = WorldPoint.fromScene(client, e.getParam0(), e.getParam1(), client.getPlane());
		FarmingPatch targetPatch = farmingWorld.getRegionsForLocation(actionLocation)
			.stream()
			.flatMap(fr -> Arrays.stream(fr.getPatches()))
			.filter(fp -> fp.getVarbit() == patchDef.getVarbitId())
			.filter(fp -> fp.getImplementation() != PatchImplementation.COMPOST && fp.getImplementation() != PatchImplementation.GIANT_COMPOST)
			.findFirst()
			.orElse(null);
		if (targetPatch == null)
		{
			return;
		}

		log.debug("Storing pending compost action for patch [{}]", targetPatch);
		PendingCompost pc = new PendingCompost(
			Instant.now().plus(COMPOST_ACTION_TIMEOUT),
			actionLocation,
			targetPatch
		);
		pendingCompostActions.put(targetPatch, pc);
	}

	private boolean isCompostAction(MenuOptionClicked e)
	{
		switch (e.getMenuAction())
		{
			case WIDGET_TARGET_ON_GAME_OBJECT:
				Widget w = client.getSelectedWidget();
				assert w != null;
				return COMPOST_ITEMS.contains(w.getItemId()) || w.getId() == WidgetInfo.SPELL_LUNAR_FERTILE_SOIL.getPackedId();

			case GAME_OBJECT_FIRST_OPTION:
			case GAME_OBJECT_SECOND_OPTION:
			case GAME_OBJECT_THIRD_OPTION:
			case GAME_OBJECT_FOURTH_OPTION:
			case GAME_OBJECT_FIFTH_OPTION:
				return "Inspect".equals(e.getMenuOption());

			default:
				return false;
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage e)
	{
		if (e.getType() != ChatMessageType.GAMEMESSAGE && e.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		CompostState compostUsed = determineCompostUsed(e.getMessage());
		if (compostUsed == null)
		{
			return;
		}

		this.expirePendingActions();

		pendingCompostActions.values()
			.stream()
			.filter(this::playerIsBesidePatch)
			.findFirst()
			.ifPresent(pc ->
			{
				setCompostState(pc.getFarmingPatch(), compostUsed);
				pendingCompostActions.remove(pc.getFarmingPatch());
			});
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged e)
	{
		switch (e.getGameState())
		{
			case LOGGED_IN:
			case LOADING:
				return;

			default:
				pendingCompostActions.clear();
		}
	}

	private boolean playerIsBesidePatch(PendingCompost pendingCompost)
	{
		// find gameobject instance in scene
		// it is possible that the scene has reloaded between use and action occurring so we use worldpoint
		// instead of storing scene coords in the menuoptionclicked event
		LocalPoint localPatchLocation = LocalPoint.fromWorld(client, pendingCompost.getPatchLocation());
		if (localPatchLocation == null)
		{
			return false;
		}

		@Varbit int patchVarb = pendingCompost.getFarmingPatch().getVarbit();
		Tile patchTile = client.getScene()
			.getTiles()[client.getPlane()][localPatchLocation.getSceneX()][localPatchLocation.getSceneY()];
		GameObject patchObject = null;
		for (GameObject go : patchTile.getGameObjects())
		{
			if (go != null && client.getObjectDefinition(go.getId()).getVarbitId() == patchVarb)
			{
				patchObject = go;
				break;
			}
		}
		assert patchObject != null;

		// player coords
		final WorldPoint playerPos = client.getLocalPlayer().getWorldLocation();
		final int playerX = playerPos.getX();
		final int playerY = playerPos.getY();

		// patch coords
		final WorldPoint patchBase = pendingCompost.getPatchLocation();
		final int minX = patchBase.getX();
		final int minY = patchBase.getY();
		final int maxX = minX + patchObject.sizeX() - 1;
		final int maxY = minY + patchObject.sizeY() - 1;

		// player should be within one tile of these coords
		return playerX >= (minX - 1) && playerX <= (maxX + 1) && playerY >= (minY - 1) && playerY <= (maxY + 1);
	}

	private void expirePendingActions()
	{
		pendingCompostActions.values().removeIf(e -> Instant.now().isAfter(e.getTimeout()));
	}

	@VisibleForTesting
	static CompostState determineCompostUsed(String chatMessage)
	{
		if (!chatMessage.contains("compost"))
		{
			return null;
		}

		Matcher matcher;
		if ((matcher = COMPOST_USED_ON_PATCH.matcher(chatMessage)).matches() ||
			(matcher = FERTILE_SOIL_CAST.matcher(chatMessage)).find() ||
			(matcher = ALREADY_TREATED.matcher(chatMessage)).matches() ||
			(matcher = INSPECT_PATCH.matcher(chatMessage)).matches())
		{
			String compostGroup = matcher.group("compostType");
			switch (compostGroup)
			{
				case "ultra":
					return CompostState.ULTRACOMPOST;
				case "super":
					return CompostState.SUPERCOMPOST;
				default:
					return CompostState.COMPOST;
			}
		}

		return null;
	}

}