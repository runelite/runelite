/*
 * Copyright (c) 2018, https://runelitepl.us
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
package net.runelite.client.plugins.hydra;

import net.runelite.api.events.*;
import net.runelite.client.eventbus.Subscribe;
import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

import java.util.HashMap;
import java.util.Map;

@PluginDescriptor(
	name = "Hydra Helper",
	description = "Hydra Helper",
	tags = {"Hydra", "Helper"},
	type = PluginType.PVM
)
public class HydraPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private HydraConfig config;

	@Inject
	private HydraOverlay HydraOverlay;

	@Inject
	private HydraPrayOverlay HydraPrayOverlay;

	@Inject
	private HydraIndicatorOverlay HydraIndicatorOverlay;

	@Inject
	private Client client;

	@Inject
	private SpriteManager spriteManager;

	@Provides
	HydraConfig provideConfig(ConfigManager configManager) {
		return configManager.getConfig(HydraConfig.class);
	}

	Map<Integer, Integer> hydras = new HashMap<>();
	Map<Integer, Integer> hydraattacks = new HashMap<>();
	NPC Hydra;

	@Override
	protected void startUp() throws Exception {
		overlayManager.add(HydraOverlay);
		overlayManager.add(HydraPrayOverlay);
		overlayManager.add(HydraIndicatorOverlay);
	}

	@Override
	protected void shutDown() throws Exception {
		overlayManager.remove(HydraOverlay);
		overlayManager.remove(HydraPrayOverlay);
		overlayManager.remove(HydraIndicatorOverlay);
		hydras.clear();
		hydraattacks.clear();
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event) {
		if (!config.EnableHydra()) {
			return;
		}
		NPC hydra = event.getNpc();
		if (hydra.getCombatLevel() != 0 && hydra.getName() != null) {
			if (hydra.getName().equalsIgnoreCase("Hydra")) {
				if (!hydras.containsKey(hydra.getIndex())) {
					hydras.put(hydra.getIndex(), 3);
				}
			}
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event) {
		if (!config.EnableHydra()) {
			return;
		}
		NPC hydra = event.getNpc();
		if (hydra.getCombatLevel() != 0 && hydra.getName() != null) {
			if (hydra.getName().equalsIgnoreCase("Hydra")) {
				if (hydras.containsKey(hydra.getIndex())) {
					hydras.remove(hydra.getIndex());
				}
				if (hydraattacks.containsKey(hydra.getIndex())) {
					hydraattacks.remove(hydra.getIndex());
				}
			}
		}
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event) {
		Actor monster = event.getActor();
		Actor local = client.getLocalPlayer();
		if (monster instanceof NPC) {
			NPC hydra = (NPC) monster;
			if (hydra.getCombatLevel() != 0 && hydra.getName() != null) {
				if (hydra.getName().equalsIgnoreCase("Hydra")) {
					if (hydras.containsKey(hydra.getIndex())) {
						if (hydra.getAnimation() == 8261 || hydra.getAnimation() == 8262) {
							if (hydra.getInteracting().equals(local)) {
								Hydra = hydra;
							}
							if (hydraattacks.containsKey(hydra.getIndex())) {
								int lastattack = hydraattacks.get(hydra.getIndex());
								hydraattacks.replace(hydra.getIndex(), hydra.getAnimation());

								if (lastattack != hydra.getAnimation()) {
									hydras.replace(hydra.getIndex(), 2);
								} else {
									int currval = hydras.get(hydra.getIndex());
									if (currval == 1) {
										hydras.replace(hydra.getIndex(), 3);
									} else {
										hydras.replace(hydra.getIndex(), currval - 1);
									}
								}
							} else {
								hydraattacks.put(hydra.getIndex(), hydra.getAnimation());
								int currval = hydras.get(hydra.getIndex());
								if (currval == 1) {
									hydras.replace(hydra.getIndex(), 3);
								} else {
									hydras.replace(hydra.getIndex(), currval - 1);
								}
							}
						}
					}
				}
			}
		}
	}
}
