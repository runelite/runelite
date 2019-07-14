/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2019, Brandon White <bmwqg@live.com>
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
package net.runelite.client.plugins.blastfurnace;

import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import static net.runelite.api.NullObjectID.NULL_9092;
import static net.runelite.api.ObjectID.CONVEYOR_BELT;
import net.runelite.api.Skill;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Blast Furnace",
	description = "Show helpful information for the Blast Furnace minigame",
	tags = {"minigame", "overlay", "skilling", "smithing"}
)
@Singleton
public class BlastFurnacePlugin extends Plugin
{
	private static final int BAR_DISPENSER = NULL_9092;
	private static final String FOREMAN_PERMISSION_TEXT = "Okay, you can use the furnace for ten minutes. Remember, you only need half as much coal as with a regular furnace.";

	@Getter(AccessLevel.PACKAGE)
	private GameObject conveyorBelt;

	@Getter(AccessLevel.PACKAGE)
	private GameObject barDispenser;

	private ForemanTimer foremanTimer;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private BlastFurnaceOverlay overlay;

	@Inject
	private BlastFurnaceCofferOverlay cofferOverlay;

	@Inject
	private BlastFurnaceClickBoxOverlay clickBoxOverlay;

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private BlastFurnaceConfig config;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private boolean showConveyorBelt;
	@Getter(AccessLevel.PACKAGE)
	private boolean showBarDispenser;

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		overlayManager.add(overlay);
		overlayManager.add(cofferOverlay);
		overlayManager.add(clickBoxOverlay);
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);

		infoBoxManager.removeIf(ForemanTimer.class::isInstance);
		overlayManager.remove(overlay);
		overlayManager.remove(cofferOverlay);
		overlayManager.remove(clickBoxOverlay);
		conveyorBelt = null;
		barDispenser = null;
		foremanTimer = null;
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameObjectSpawned.class, this, this::onGameObjectSpawned);
		eventBus.subscribe(GameObjectDespawned.class, this, this::onGameObjectDespawned);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
	}

	@Provides
	BlastFurnaceConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BlastFurnaceConfig.class);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("blastfurnace"))
		{
			updateConfig();
		}
	}

	private void onGameObjectSpawned(GameObjectSpawned event)
	{
		GameObject gameObject = event.getGameObject();

		switch (gameObject.getId())
		{
			case CONVEYOR_BELT:
				conveyorBelt = gameObject;
				break;

			case BAR_DISPENSER:
				barDispenser = gameObject;
				break;
		}
	}

	private void onGameObjectDespawned(GameObjectDespawned event)
	{
		GameObject gameObject = event.getGameObject();

		switch (gameObject.getId())
		{
			case CONVEYOR_BELT:
				conveyorBelt = null;
				break;

			case BAR_DISPENSER:
				barDispenser = null;
				break;
		}
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			conveyorBelt = null;
			barDispenser = null;
		}
	}

	private void onGameTick(GameTick event)
	{
		Widget npcDialog = client.getWidget(WidgetInfo.DIALOG_NPC_TEXT);
		if (npcDialog == null)
		{
			return;
		}

		// blocking dialog check until 5 minutes needed to avoid re-adding while dialog message still displayed
		boolean shouldCheckForemanFee = client.getRealSkillLevel(Skill.SMITHING) < 60
			&& (foremanTimer == null || Duration.between(Instant.now(), foremanTimer.getEndTime()).toMinutes() <= 5);

		if (shouldCheckForemanFee)
		{
			String npcText = Text.sanitizeMultilineText(npcDialog.getText());

			if (npcText.equals(FOREMAN_PERMISSION_TEXT))
			{
				infoBoxManager.removeIf(ForemanTimer.class::isInstance);

				foremanTimer = new ForemanTimer(this, itemManager);
				infoBoxManager.addInfoBox(foremanTimer);
			}
		}
	}

	private void updateConfig()
	{
		this.showBarDispenser = config.showBarDispenser();
		this.showConveyorBelt = config.showConveyorBelt();
	}
}
