/*
 *
 *  * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
 *  * All rights reserved.
 *  *
 *  * Redistribution and use in source and binary forms, with or without
 *  * modification, are permitted provided that the following conditions are met:
 *  *
 *  * 1. Redistributions of source code must retain the above copyright notice, this
 *  *    list of conditions and the following disclaimer.
 *  * 2. Redistributions in binary form must reproduce the above copyright notice,
 *  *    this list of conditions and the following disclaimer in the documentation
 *  *    and/or other materials provided with the distribution.
 *  * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package net.runelite.client.plugins.zalcano;

import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.AnimationID;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.kit.KitType;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Zalcano",
	description = "Highlights Zalcano AOEs and useful stuff",
	tags = {"zalcano", "aoe", "prifddinas", "elf", "boss"},
	type = PluginType.PVM
)
@Slf4j
public class ZalcanoPlugin extends Plugin
{

	@Inject
	private Client client;

	@Inject
	private ZalcanoConfig config;

	@Inject
	private ZalcanoUtil util;

	@Inject
	private ZalcanoOverlay overlay;

	@Inject
	private ZalcanoStepsOverlay stepsOverlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private EventBus eventBus;

	@Setter(AccessLevel.PACKAGE)
	@Getter(AccessLevel.PACKAGE)
	private NPC zalcano;

	@Getter(AccessLevel.PACKAGE)
	private NPC golem;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private Step step;

	private int ores = 0;

	@Provides
	ZalcanoConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ZalcanoConfig.class);
	}

	@Override
	protected void startUp()
	{
		eventBus.subscribe(GameTick.class, "regionchecker", this::onGameTickCheckRegion);
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);
		eventBus.unregister("regionchecker");
		overlayManager.remove(overlay);
		overlayManager.remove(stepsOverlay);
	}

	@Override
	public void configure(Binder binder)
	{
	}

	private void onGameTickCheckRegion(GameTick gameTick)
	{
		if (util.isInZalcanoRegion())
		{
			log.debug("region check complete loading other events");
			eventBus.subscribe(NpcSpawned.class, this, this::onNpcSpawned);
			eventBus.subscribe(NpcDespawned.class, this, this::onNpcDespawned);
			eventBus.subscribe(GameTick.class, this, this::gameTickStepMachine);
			eventBus.subscribe(GameTick.class, this, this::gameTickOreListener);

			util.manuallyFindZalcano(); //this is here because the new subscribed npcspawn doesn't catch a pre existing zalcano

			overlayManager.add(overlay);
			overlayManager.add(stepsOverlay);

			eventBus.unregister("regionchecker");
		}
	}

	private void onNpcSpawned(NpcSpawned npcSpawned)
	{
		switch (npcSpawned.getNpc().getId())
		{
			case NpcID.ZALCANO:
				log.debug("zalcano spawned");
				zalcano = npcSpawned.getNpc();
				break;
			case NpcID.GOLEM_9051:
				log.debug("golem spawned");
				golem = npcSpawned.getNpc();
				break;
		}
	}

	private void onNpcDespawned(NpcDespawned npcDespawned)
	{
		switch (npcDespawned.getNpc().getId())
		{
			case NpcID.ZALCANO:
				zalcano = null;
				break;
			case NpcID.GOLEM_9051:
				golem = null;
				break;
		}
	}

	//23905 //ore
	//23906 //smelted
	//23907 //runecrafted ore

	/**
	 * This event switches steps based on different conditions (inaccurate)
	 * TODO: improve this. until then its option is disabled in the config
	 *
	 * @param gameTick
	 */
	private void gameTickStepMachine(GameTick gameTick)
	{
		if (!config.showSteps())
		{
			return;
		}

		if (getZalcano() != null)
		{
			if (getZalcano().getAnimation() == AnimationID.ZALCANO_KNOCKED_DOWN) //zalcano got knocked down
			{
				setStep(Step.MINE_ZALCANO);
				return;
			}
		}
		if (util.countItemInInventory(ItemID.TEPHRA) < 3 && util.countItemInInventory(ItemID.REFINED_TEPHRA) < 3 && util.countStackInInventory(ItemID.IMBUED_TEPHRA) < 3)
		{
			if (client.getLocalPlayer().getPlayerAppearance().getEquipmentId(KitType.WEAPON) == ItemID.IMBUED_TEPHRA)
			{
				setStep(Step.THROW);
				return;
			}
			if (getZalcano() != null && util.countItemInInventory(ItemID.REFINED_TEPHRA) == 0 && util.countItemInInventory(ItemID.IMBUED_TEPHRA) == 0)
			{
				setStep(Step.MINE);
				return;
			}
		}
		if (util.countItemInInventory(ItemID.TEPHRA) >= 3)
		{
			setStep(Step.SMELT);
			return;
		}
		if (util.countItemInInventory(ItemID.REFINED_TEPHRA) >= 3 && ores == 0)
		{
			setStep(Step.RUNECRAFT);
			return;
		}
		if (util.countStackInInventory(ItemID.IMBUED_TEPHRA) >= 3)
		{
			setStep(Step.THROW);
			return;
		}
		setStep(Step.IDLE);
	}

	private void gameTickOreListener(GameTick gameTick)
	{
		if (!config.showSteps())
		{
			return;
		}
		ores = util.countItemInInventory(ItemID.TEPHRA);
	}

}
