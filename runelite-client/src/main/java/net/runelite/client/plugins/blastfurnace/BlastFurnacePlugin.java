/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import static net.runelite.api.NullObjectID.NULL_9092;
import static net.runelite.api.ObjectID.CONVEYOR_BELT;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Blast Furnace",
	description = "Show helpful information for the Blast Furnace minigame",
	tags = {"minigame", "overlay", "skilling", "smithing"}
)
public class BlastFurnacePlugin extends Plugin
{
	private static final int BAR_DISPENSER = NULL_9092;

	@Getter(AccessLevel.PACKAGE)
	private GameObject conveyorBelt;

	@Getter(AccessLevel.PACKAGE)
	private GameObject barDispenser;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private BlastFurnaceOverlay overlay;

	@Inject
	private BlastFurnaceCofferOverlay cofferOverlay;

	@Inject
	private BlastFurnaceClickBoxOverlay clickBoxOverlay;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		overlayManager.add(cofferOverlay);
		overlayManager.add(clickBoxOverlay);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
		overlayManager.remove(cofferOverlay);
		overlayManager.remove(clickBoxOverlay);
		conveyorBelt = null;
		barDispenser = null;
	}

	@Provides
	BlastFurnaceConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BlastFurnaceConfig.class);
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
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

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
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

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			conveyorBelt = null;
			barDispenser = null;
		}
	}
}
