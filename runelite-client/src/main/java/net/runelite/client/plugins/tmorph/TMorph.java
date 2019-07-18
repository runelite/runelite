/*
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
package net.runelite.client.plugins.tmorph;

import com.google.inject.Provides;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.kit.KitType;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import org.apache.commons.lang3.ObjectUtils;

@PluginDescriptor(
	name = "TMorph",
	description = "Want to wear a infernal cape? well now you can!",
	tags = {"transform", "model", "item", "morph"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)
@Singleton
public class TMorph extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private TMorphConfig config;

	@Inject
	private EventBus eventBus;

	private boolean mageSwap;
	private boolean rangeSwap;
	private boolean meleeSwap;
	private int globalAnimSwap;
	private int animationSwap;
	private int animationTarget;
	private int MainhandMage;
	private int targetMainhandMage;
	private int OffhandMage;
	private int targetOffhandMage;
	private int HelmetMage;
	private int targetHelmetMage;
	private int CapeMage;
	private int targetCapeMage;
	private int NeckMage;
	private int targetNeckMage;
	private int BodyMage;
	private int targetBodyMage;
	private int LegsMage;
	private int targetLegsMage;
	private int BootsMage;
	private int targetBootsMage;
	private int GlovesMage;
	private int targetGlovesMage;
	private int MainhandRange;
	private int targetMainhandRange;
	private int OffhandRange;
	private int targetOffhandRange;
	private int HelmetRange;
	private int targetHelmetRange;
	private int CapeRange;
	private int targetCapeRange;
	private int NeckRange;
	private int targetNeckRange;
	private int BodyRange;
	private int targetBodyRange;
	private int LegsRange;
	private int targetLegsRange;
	private int BootsRange;
	private int targetBootsRange;
	private int GlovesRange;
	private int targetGlovesRange;
	private int MainhandMelee;
	private int targetMainhandMelee;
	private int OffhandMelee;
	private int targetOffhandMelee;
	private int HelmetMelee;
	private int targetHelmetMelee;
	private int CapeMelee;
	private int targetCapeMelee;
	private int NeckMelee;
	private int targetNeckMelee;
	private int BodyMelee;
	private int targetBodyMelee;
	private int LegsMelee;
	private int targetLegsMelee;
	private int BootsMelee;
	private int targetBootsMelee;
	private int GlovesMelee;
	private int targetGlovesMelee;

	@Provides
	TMorphConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TMorphConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(AnimationChanged.class, this, this::onAnimationChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("TMorph"))
		{
			updateConfig();
		}
	}

	private void onAnimationChanged(AnimationChanged event)
	{
		if (this.animationTarget <= 0 && this.animationSwap <= 0 && this.globalAnimSwap > 0)
		{
			if (event.getActor().getAnimation() != -1)
			{
				event.getActor().setAnimation(this.globalAnimSwap);
			}
		}
		if (this.animationTarget > 0 && this.animationSwap > 0)
		{
			if (event.getActor().getAnimation() == this.animationTarget)
			{
				event.getActor().setAnimation(this.animationSwap);
			}
		}
	}

	private void onGameTick(GameTick event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}
		updateEquip();
	}

	private void updateEquip()
	{
		Player player = client.getLocalPlayer();

		if (player == null
			|| player.getPlayerAppearance() == null
			|| client.getWidget(WidgetInfo.LOGIN_CLICK_TO_PLAY_SCREEN) != null
			|| client.getViewportWidget() == null)
		{
			return;
		}

		final int mainhandID = ObjectUtils.defaultIfNull(player.getPlayerAppearance().
			getEquipmentId(KitType.WEAPON), 0);
		final int offhandID = ObjectUtils.defaultIfNull(player.getPlayerAppearance().
			getEquipmentId(KitType.SHIELD), 0);
		final int helmetID = ObjectUtils.defaultIfNull(player.getPlayerAppearance().
			getEquipmentId(KitType.HELMET), 0);
		final int capeID = ObjectUtils.defaultIfNull(player.getPlayerAppearance().
			getEquipmentId(KitType.CAPE), 0);
		final int neckID = ObjectUtils.defaultIfNull(player.getPlayerAppearance().
			getEquipmentId(KitType.AMULET), 0);
		final int bodyID = ObjectUtils.defaultIfNull(player.getPlayerAppearance().
			getEquipmentId(KitType.TORSO), 0);
		final int legsID = ObjectUtils.defaultIfNull(player.getPlayerAppearance().
			getEquipmentId(KitType.LEGS), 0);
		final int bootsID = ObjectUtils.defaultIfNull(player.getPlayerAppearance().
			getEquipmentId(KitType.BOOTS), 0);
		final int glovesID = ObjectUtils.defaultIfNull(player.getPlayerAppearance().
			getEquipmentId(KitType.HANDS), 0);

		if (this.mageSwap)
		{
			if (this.MainhandMage > 0)
			{
				if (this.targetMainhandMage > 0)
				{
					if (mainhandID == this.targetMainhandMage)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.WEAPON.getIndex()] = this.MainhandMage + 512;
					}
				}
			}
			if (this.OffhandMage > 0)
			{
				if (this.targetOffhandMage > 0)
				{
					if (offhandID == this.targetOffhandMage)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.SHIELD.getIndex()] = this.OffhandMage + 512;
					}
				}
			}
			if (this.HelmetMage > 0)
			{
				if (this.targetHelmetMage > 0)
				{
					if (helmetID == this.targetHelmetMage)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.HELMET.getIndex()] = this.HelmetMage + 512;
					}
				}
			}
			if (this.CapeMage > 0)
			{
				if (this.targetCapeMage > 0)
				{
					if (capeID == this.targetCapeMage)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.CAPE.getIndex()] = this.CapeMage + 512;
					}
				}
			}
			if (this.NeckMage > 0)
			{
				if (this.targetNeckMage > 0)
				{
					if (neckID == this.targetNeckMage)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.AMULET.getIndex()] = this.NeckMage + 512;
					}
				}
			}
			if (this.BodyMage > 0)
			{
				if (this.targetBodyMage > 0)
				{
					if (bodyID == this.targetBodyMage)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.TORSO.getIndex()] = this.BodyMage + 512;
					}
				}
			}
			if (this.LegsMage > 0)
			{
				if (this.targetLegsMage > 0)
				{
					if (legsID == this.targetLegsMage)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.LEGS.getIndex()] = this.LegsMage + 512;
					}
				}
			}
			if (this.BootsMage > 0)
			{
				if (this.targetBootsMage > 0)
				{
					if (bootsID == this.targetBootsMage)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.BOOTS.getIndex()] = this.BootsMage + 512;
					}
				}
			}
			if (this.GlovesMage > 0)
			{
				if (this.targetGlovesMage > 0)
				{
					if (glovesID == this.targetGlovesMage)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.HANDS.getIndex()] = this.GlovesMage + 512;
					}
				}
			}
		}
		if (this.rangeSwap)
		{
			if (this.MainhandRange > 0)
			{
				if (this.targetMainhandRange > 0)
				{
					if (mainhandID == this.targetMainhandRange)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.WEAPON.getIndex()] = this.MainhandRange + 512;
					}
				}
			}
			if (this.OffhandRange > 0)
			{
				if (this.targetOffhandRange > 0)
				{
					if (offhandID == this.targetOffhandRange)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.SHIELD.getIndex()] = this.OffhandRange + 512;
					}
				}
			}
			if (this.HelmetRange > 0)
			{
				if (this.targetHelmetRange > 0)
				{
					if (helmetID == this.targetHelmetRange)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.HELMET.getIndex()] = this.HelmetRange + 512;
					}
				}
			}
			if (this.CapeRange > 0)
			{
				if (this.targetCapeRange > 0)
				{
					if (capeID == this.targetCapeRange)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.CAPE.getIndex()] = this.CapeRange + 512;
					}
				}
			}
			if (this.NeckRange > 0)
			{
				if (this.targetNeckRange > 0)
				{
					if (neckID == this.targetNeckRange)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.AMULET.getIndex()] = this.NeckRange + 512;
					}
				}
			}
			if (this.BodyRange > 0)
			{
				if (this.targetBodyRange > 0)
				{
					if (bodyID == this.targetBodyRange)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.TORSO.getIndex()] = this.BodyRange + 512;
					}
				}
			}
			if (this.LegsRange > 0)
			{
				if (this.targetLegsRange > 0)
				{
					if (legsID == this.targetLegsRange)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.LEGS.getIndex()] = this.LegsRange + 512;
					}
				}
			}
			if (this.BootsRange > 0)
			{
				if (this.targetBootsRange > 0)
				{
					if (bootsID == this.targetBootsRange)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.BOOTS.getIndex()] = this.BootsRange + 512;
					}
				}
			}
			if (this.GlovesRange > 0)
			{
				if (this.targetGlovesRange > 0)
				{
					if (glovesID == this.targetGlovesRange)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.HANDS.getIndex()] = this.GlovesRange + 512;
					}
				}
			}
		}
		if (this.meleeSwap)
		{
			if (this.MainhandMelee > 0)
			{
				if (this.targetMainhandMelee > 0)
				{
					if (mainhandID == this.targetMainhandMelee)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.WEAPON.getIndex()] = this.MainhandMelee + 512;
					}
				}
			}
			if (this.OffhandMelee > 0)
			{
				if (this.targetOffhandMelee > 0)
				{
					if (offhandID == this.targetOffhandMelee)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.SHIELD.getIndex()] = this.OffhandMelee + 512;
					}
				}
			}
			if (this.HelmetMelee > 0)
			{
				if (this.targetHelmetMelee > 0)
				{
					if (helmetID == this.targetHelmetMelee)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.HELMET.getIndex()] = this.HelmetMelee + 512;
					}
				}
			}
			if (this.CapeMelee > 0)
			{
				if (this.targetCapeMelee > 0)
				{
					if (capeID == this.targetCapeMelee)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.CAPE.getIndex()] = this.CapeMelee + 512;
					}
				}
			}
			if (this.NeckMelee > 0)
			{
				if (this.targetNeckMelee > 0)
				{
					if (neckID == this.targetNeckMelee)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.AMULET.getIndex()] = this.NeckMelee + 512;
					}
				}
			}
			if (this.BodyMelee > 0)
			{
				if (this.targetBodyMelee > 0)
				{
					if (bodyID == this.targetBodyMelee)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.TORSO.getIndex()] = this.BodyMelee + 512;
					}
				}
			}
			if (this.LegsMelee > 0)
			{
				if (this.targetLegsMelee > 0)
				{
					if (legsID == this.targetLegsMelee)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.LEGS.getIndex()] = this.LegsMelee + 512;
					}
				}
			}
			if (this.BootsMelee > 0)
			{
				if (this.targetBootsMelee > 0)
				{
					if (bootsID == this.targetBootsMelee)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.BOOTS.getIndex()] = this.BootsMelee + 512;
					}
				}
			}
			if (this.GlovesMelee > 0)
			{
				if (this.targetGlovesMelee > 0)
				{
					if (glovesID == this.targetGlovesMelee)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.HANDS.getIndex()] = this.GlovesMelee + 512;
					}
				}
			}
		}
		player.getPlayerAppearance().setHash();
	}

	private void updateConfig()
	{
		this.mageSwap = config.mageSwap();
		this.rangeSwap = config.rangeSwap();
		this.meleeSwap = config.meleeSwap();
		this.globalAnimSwap = config.globalAnimSwap();
		this.animationSwap = config.animationSwap();
		this.animationTarget = config.animationTarget();
		this.MainhandMage = config.MainhandMage();
		this.targetMainhandMage = config.targetMainhandMage();
		this.OffhandMage = config.OffhandMage();
		this.targetOffhandMage = config.targetOffhandMage();
		this.HelmetMage = config.HelmetMage();
		this.targetHelmetMage = config.targetHelmetMage();
		this.CapeMage = config.CapeMage();
		this.targetCapeMage = config.targetCapeMage();
		this.NeckMage = config.NeckMage();
		this.targetNeckMage = config.targetNeckMage();
		this.BodyMage = config.BodyMage();
		this.targetBodyMage = config.targetBodyMage();
		this.LegsMage = config.LegsMage();
		this.targetLegsMage = config.targetLegsMage();
		this.BootsMage = config.BootsMage();
		this.targetBootsMage = config.targetBootsMage();
		this.GlovesMage = config.GlovesMage();
		this.targetGlovesMage = config.targetGlovesMage();
		this.MainhandRange = config.MainhandRange();
		this.targetMainhandRange = config.targetMainhandRange();
		this.OffhandRange = config.OffhandRange();
		this.targetOffhandRange = config.targetOffhandRange();
		this.HelmetRange = config.HelmetRange();
		this.targetHelmetRange = config.targetHelmetRange();
		this.CapeRange = config.CapeRange();
		this.targetCapeRange = config.targetCapeRange();
		this.NeckRange = config.NeckRange();
		this.targetNeckRange = config.targetNeckRange();
		this.BodyRange = config.BodyRange();
		this.targetBodyRange = config.targetBodyRange();
		this.LegsRange = config.LegsRange();
		this.targetLegsRange = config.targetLegsRange();
		this.BootsRange = config.BootsRange();
		this.targetBootsRange = config.targetBootsRange();
		this.GlovesRange = config.GlovesRange();
		this.targetGlovesRange = config.targetGlovesRange();
		this.MainhandMelee = config.MainhandMelee();
		this.targetMainhandMelee = config.targetMainhandMelee();
		this.OffhandMelee = config.OffhandMelee();
		this.targetOffhandMelee = config.targetOffhandMelee();
		this.HelmetMelee = config.HelmetMelee();
		this.targetHelmetMelee = config.targetHelmetMelee();
		this.CapeMelee = config.CapeMelee();
		this.targetCapeMelee = config.targetCapeMelee();
		this.NeckMelee = config.NeckMelee();
		this.targetNeckMelee = config.targetNeckMelee();
		this.BodyMelee = config.BodyMelee();
		this.targetBodyMelee = config.targetBodyMelee();
		this.LegsMelee = config.LegsMelee();
		this.targetLegsMelee = config.targetLegsMelee();
		this.BootsMelee = config.BootsMelee();
		this.targetBootsMelee = config.targetBootsMelee();
		this.GlovesMelee = config.GlovesMelee();
		this.targetGlovesMelee = config.targetGlovesMelee();
	}
}
