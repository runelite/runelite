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

import com.google.inject.Provides;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Hydra Helper",
	description = "Overlays for small hydras",
	tags = {"Hydra", "Helper", "you", "probably", "want", "the", "other", "one"},
	type = PluginType.PVM,
	enabledByDefault = false
)
@Singleton
public class BabyHydraPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private BabyHydraConfig config;

	@Inject
	private BabyHydraOverlay hydraOverlay;

	@Inject
	private BabyHydraPrayOverlay hydraPrayOverlay;

	@Inject
	private BabyHydraIndicatorOverlay hydraIndicatorOverlay;

	@Inject
	private Client client;

	@Inject
	private EventBus eventBus;

	@Provides
	BabyHydraConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BabyHydraConfig.class);
	}

	@Getter(AccessLevel.PACKAGE)
	private Map<Integer, Integer> hydras = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private Map<Integer, Integer> hydraattacks = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private NPC hydra;

	private boolean TextIndicator;
	@Getter(AccessLevel.PACKAGE)
	private boolean BoldText;
	private boolean PrayerHelper;

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		if (this.TextIndicator)
		{
			overlayManager.add(hydraOverlay);
		}
		if (this.PrayerHelper)
		{
			overlayManager.add(hydraPrayOverlay);
			overlayManager.add(hydraIndicatorOverlay);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(hydraOverlay);
		overlayManager.remove(hydraPrayOverlay);
		overlayManager.remove(hydraIndicatorOverlay);
		hydras.clear();
		hydraattacks.clear();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(NpcSpawned.class, this, this::onNpcSpawned);
		eventBus.subscribe(NpcDespawned.class, this, this::onNpcDespawned);
		eventBus.subscribe(AnimationChanged.class, this, this::onAnimationChanged);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("hydra"))
		{
			return;
		}

		updateConfig();

		if (event.getKey().equals("textindicators"))
		{
			if (Boolean.parseBoolean(event.getNewValue()))
			{
				overlayManager.add(hydraOverlay);
			}
			else
			{
				overlayManager.remove(hydraOverlay);
			}
		}
		else if (event.getKey().equals("prayerhelper"))
		{
			if (Boolean.parseBoolean(event.getNewValue()))
			{
				overlayManager.add(hydraPrayOverlay);
				overlayManager.add(hydraIndicatorOverlay);
			}
			else
			{
				overlayManager.remove(hydraPrayOverlay);
				overlayManager.remove(hydraIndicatorOverlay);
			}
		}
	}

	private void onNpcSpawned(NpcSpawned event)
	{
		NPC hydra = event.getNpc();
		if (hydra.getCombatLevel() != 0 && hydra.getName() != null && hydra.getName().equalsIgnoreCase("Hydra") && !hydras.containsKey(hydra.getIndex()))
		{
			hydras.put(hydra.getIndex(), 3);
		}
	}

	private void onNpcDespawned(NpcDespawned event)
	{
		NPC hydra = event.getNpc();
		if (hydra.getCombatLevel() != 0 && hydra.getName() != null && hydra.getName().equalsIgnoreCase("Hydra"))
		{
			hydras.remove(hydra.getIndex());
			hydraattacks.remove(hydra.getIndex());
		}
	}

	private void onAnimationChanged(AnimationChanged event)
	{
		Actor monster = event.getActor();
		Actor local = client.getLocalPlayer();
		if (!(monster instanceof NPC))
		{
			return;
		}
		NPC hydra = (NPC) monster;

		if (hydra.getCombatLevel() == 0 || hydra.getName() == null)
		{
			return;
		}

		if (!hydra.getName().equalsIgnoreCase("Hydra") || !hydras.containsKey(hydra.getIndex()))
		{
			return;
		}

		if (hydra.getAnimation() != 8261 && hydra.getAnimation() != 8262)
		{
			return;
		}

		if (hydra.getInteracting().equals(local))
		{
			this.hydra = hydra;
		}

		if (hydraattacks.containsKey(hydra.getIndex()))
		{
			int lastattack = hydraattacks.get(hydra.getIndex());
			hydraattacks.replace(hydra.getIndex(), hydra.getAnimation());

			if (lastattack != hydra.getAnimation())
			{
				hydras.replace(hydra.getIndex(), 2);
			}
			else
			{
				int currval = hydras.get(hydra.getIndex());
				if (currval == 1)
				{
					hydras.replace(hydra.getIndex(), 3);
				}
				else
				{
					hydras.replace(hydra.getIndex(), currval - 1);
				}
			}
		}
		else
		{
			hydraattacks.put(hydra.getIndex(), hydra.getAnimation());
			int currval = hydras.get(hydra.getIndex());
			if (currval == 1)
			{
				hydras.replace(hydra.getIndex(), 3);
			}
			else
			{
				hydras.replace(hydra.getIndex(), currval - 1);
			}
		}
	}

	private void updateConfig()
	{
		this.TextIndicator = config.TextIndicator();
		this.BoldText = config.BoldText();
		this.PrayerHelper = config.PrayerHelper();
	}
}
