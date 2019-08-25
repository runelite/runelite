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
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.SpotAnimationChanged;
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
	private boolean meleeSwap;
	private boolean rangeSwap;
	private int animation;
	private int bodyMage;
	private int bodyMelee;
	private int bodyRange;
	private int bootsMage;
	private int bootsMelee;
	private int bootsRange;
	private int capeMage;
	private int capeMelee;
	private int capeRange;
	private int globalAnimSwap;
	private int globalGraphicSwap;
	private int glovesMage;
	private int glovesMelee;
	private int glovesRange;
	private int graphic;
	private int helmetMage;
	private int helmetMelee;
	private int helmetRange;
	private int legsMage;
	private int legsMelee;
	private int legsRange;
	private int mainhandMage;
	private int mainhandMelee;
	private int mainhandRange;
	private int neckMage;
	private int neckMelee;
	private int neckRange;
	private int offhandMage;
	private int offhandMelee;
	private int offhandRange;
	private int targetAnimation;
	private int targetBodyMage;
	private int targetBodyMelee;
	private int targetBodyRange;
	private int targetBootsMage;
	private int targetBootsMelee;
	private int targetBootsRange;
	private int targetCapeMage;
	private int targetCapeMelee;
	private int targetCapeRange;
	private int targetGlovesMage;
	private int targetGlovesMelee;
	private int targetGlovesRange;
	private int targetGraphic;
	private int targetHelmetMage;
	private int targetHelmetMelee;
	private int targetHelmetRange;
	private int targetLegsMage;
	private int targetLegsMelee;
	private int targetLegsRange;
	private int targetMainhandMage;
	private int targetMainhandMelee;
	private int targetMainhandRange;
	private int targetNeckMage;
	private int targetNeckMelee;
	private int targetNeckRange;
	private int targetOffhandMage;
	private int targetOffhandMelee;
	private int targetOffhandRange;

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
		eventBus.subscribe(SpotAnimationChanged.class, this, this::onSpotAnimationChanged);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("TMorph"))
		{
			updateConfig();
		}
	}

	private void onSpotAnimationChanged(SpotAnimationChanged event)
	{
		final Actor actor = event.getActor();

		if (actor.getSpotAnimation() == -1)
		{
			return;
		}

		if (this.graphic <= 0 && this.targetGraphic <= 0 && this.globalGraphicSwap > 0)
		{
			actor.setSpotAnimation(this.globalGraphicSwap);
		}
		if (this.graphic > 0 && this.targetGraphic > 0)
		{
			if (actor.getSpotAnimation() == this.targetGraphic)
			{
				actor.setSpotAnimation(this.graphic);
			}
		}
	}

	private void onAnimationChanged(AnimationChanged event)
	{
		final Actor actor = event.getActor();

		if (actor.getAnimation() != -1)
		{
			return;
		}

		if (this.targetAnimation <= 0 && this.animation <= 0 && this.globalAnimSwap > 0)
		{
			actor.setAnimation(this.globalAnimSwap);
		}
		if (this.targetAnimation > 0 && this.animation > 0)
		{
			if (actor.getAnimation() == this.targetAnimation)
			{
				actor.setAnimation(this.animation);
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
			if (this.mainhandMage > 0)
			{
				if (this.targetMainhandMage > 0)
				{
					if (mainhandID == this.targetMainhandMage)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.WEAPON.getIndex()] = this.mainhandMage + 512;
					}
				}
			}
			if (this.offhandMage > 0)
			{
				if (this.targetOffhandMage > 0)
				{
					if (offhandID == this.targetOffhandMage)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.SHIELD.getIndex()] = this.offhandMage + 512;
					}
				}
			}
			if (this.helmetMage > 0)
			{
				if (this.targetHelmetMage > 0)
				{
					if (helmetID == this.targetHelmetMage)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.HELMET.getIndex()] = this.helmetMage + 512;
					}
				}
			}
			if (this.capeMage > 0)
			{
				if (this.targetCapeMage > 0)
				{
					if (capeID == this.targetCapeMage)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.CAPE.getIndex()] = this.capeMage + 512;
					}
				}
			}
			if (this.neckMage > 0)
			{
				if (this.targetNeckMage > 0)
				{
					if (neckID == this.targetNeckMage)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.AMULET.getIndex()] = this.neckMage + 512;
					}
				}
			}
			if (this.bodyMage > 0)
			{
				if (this.targetBodyMage > 0)
				{
					if (bodyID == this.targetBodyMage)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.TORSO.getIndex()] = this.bodyMage + 512;
					}
				}
			}
			if (this.legsMage > 0)
			{
				if (this.targetLegsMage > 0)
				{
					if (legsID == this.targetLegsMage)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.LEGS.getIndex()] = this.legsMage + 512;
					}
				}
			}
			if (this.bootsMage > 0)
			{
				if (this.targetBootsMage > 0)
				{
					if (bootsID == this.targetBootsMage)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.BOOTS.getIndex()] = this.bootsMage + 512;
					}
				}
			}
			if (this.glovesMage > 0)
			{
				if (this.targetGlovesMage > 0)
				{
					if (glovesID == this.targetGlovesMage)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.HANDS.getIndex()] = this.glovesMage + 512;
					}
				}
			}
		}
		if (this.rangeSwap)
		{
			if (this.mainhandRange > 0)
			{
				if (this.targetMainhandRange > 0)
				{
					if (mainhandID == this.targetMainhandRange)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.WEAPON.getIndex()] = this.mainhandRange + 512;
					}
				}
			}
			if (this.offhandRange > 0)
			{
				if (this.targetOffhandRange > 0)
				{
					if (offhandID == this.targetOffhandRange)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.SHIELD.getIndex()] = this.offhandRange + 512;
					}
				}
			}
			if (this.helmetRange > 0)
			{
				if (this.targetHelmetRange > 0)
				{
					if (helmetID == this.targetHelmetRange)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.HELMET.getIndex()] = this.helmetRange + 512;
					}
				}
			}
			if (this.capeRange > 0)
			{
				if (this.targetCapeRange > 0)
				{
					if (capeID == this.targetCapeRange)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.CAPE.getIndex()] = this.capeRange + 512;
					}
				}
			}
			if (this.neckRange > 0)
			{
				if (this.targetNeckRange > 0)
				{
					if (neckID == this.targetNeckRange)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.AMULET.getIndex()] = this.neckRange + 512;
					}
				}
			}
			if (this.bodyRange > 0)
			{
				if (this.targetBodyRange > 0)
				{
					if (bodyID == this.targetBodyRange)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.TORSO.getIndex()] = this.bodyRange + 512;
					}
				}
			}
			if (this.legsRange > 0)
			{
				if (this.targetLegsRange > 0)
				{
					if (legsID == this.targetLegsRange)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.LEGS.getIndex()] = this.legsRange + 512;
					}
				}
			}
			if (this.bootsRange > 0)
			{
				if (this.targetBootsRange > 0)
				{
					if (bootsID == this.targetBootsRange)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.BOOTS.getIndex()] = this.bootsRange + 512;
					}
				}
			}
			if (this.glovesRange > 0)
			{
				if (this.targetGlovesRange > 0)
				{
					if (glovesID == this.targetGlovesRange)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.HANDS.getIndex()] = this.glovesRange + 512;
					}
				}
			}
		}
		if (this.meleeSwap)
		{
			if (this.mainhandMelee > 0)
			{
				if (this.targetMainhandMelee > 0)
				{
					if (mainhandID == this.targetMainhandMelee)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.WEAPON.getIndex()] = this.mainhandMelee + 512;
					}
				}
			}
			if (this.offhandMelee > 0)
			{
				if (this.targetOffhandMelee > 0)
				{
					if (offhandID == this.targetOffhandMelee)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.SHIELD.getIndex()] = this.offhandMelee + 512;
					}
				}
			}
			if (this.helmetMelee > 0)
			{
				if (this.targetHelmetMelee > 0)
				{
					if (helmetID == this.targetHelmetMelee)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.HELMET.getIndex()] = this.helmetMelee + 512;
					}
				}
			}
			if (this.capeMelee > 0)
			{
				if (this.targetCapeMelee > 0)
				{
					if (capeID == this.targetCapeMelee)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.CAPE.getIndex()] = this.capeMelee + 512;
					}
				}
			}
			if (this.neckMelee > 0)
			{
				if (this.targetNeckMelee > 0)
				{
					if (neckID == this.targetNeckMelee)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.AMULET.getIndex()] = this.neckMelee + 512;
					}
				}
			}
			if (this.bodyMelee > 0)
			{
				if (this.targetBodyMelee > 0)
				{
					if (bodyID == this.targetBodyMelee)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.TORSO.getIndex()] = this.bodyMelee + 512;
					}
				}
			}
			if (this.legsMelee > 0)
			{
				if (this.targetLegsMelee > 0)
				{
					if (legsID == this.targetLegsMelee)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.LEGS.getIndex()] = this.legsMelee + 512;
					}
				}
			}
			if (this.bootsMelee > 0)
			{
				if (this.targetBootsMelee > 0)
				{
					if (bootsID == this.targetBootsMelee)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.BOOTS.getIndex()] = this.bootsMelee + 512;
					}
				}
			}
			if (this.glovesMelee > 0)
			{
				if (this.targetGlovesMelee > 0)
				{
					if (glovesID == this.targetGlovesMelee)
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.HANDS.getIndex()] = this.glovesMelee + 512;
					}
				}
			}
		}
		player.getPlayerAppearance().setHash();
	}

	private void updateConfig()
	{
		this.animation = config.animationSwap();
		this.bodyMage = config.BodyMage();
		this.bodyMelee = config.BodyMelee();
		this.bodyRange = config.BodyRange();
		this.bootsMage = config.BootsMage();
		this.bootsMelee = config.BootsMelee();
		this.bootsRange = config.BootsRange();
		this.capeMage = config.CapeMage();
		this.capeMelee = config.CapeMelee();
		this.capeRange = config.CapeRange();
		this.globalAnimSwap = config.globalAnimSwap();
		this.globalGraphicSwap = config.globalGraphicSwap();
		this.glovesMage = config.GlovesMage();
		this.glovesMelee = config.GlovesMelee();
		this.glovesRange = config.GlovesRange();
		this.graphic = config.graphicSwap();
		this.helmetMage = config.HelmetMage();
		this.helmetMelee = config.HelmetMelee();
		this.helmetRange = config.HelmetRange();
		this.legsMage = config.LegsMage();
		this.legsMelee = config.LegsMelee();
		this.legsRange = config.LegsRange();
		this.mageSwap = config.mageSwap();
		this.mainhandMage = config.MainhandMage();
		this.mainhandMelee = config.MainhandMelee();
		this.mainhandRange = config.MainhandRange();
		this.meleeSwap = config.meleeSwap();
		this.neckMage = config.NeckMage();
		this.neckMelee = config.NeckMelee();
		this.neckRange = config.NeckRange();
		this.offhandMage = config.OffhandMage();
		this.offhandMelee = config.OffhandMelee();
		this.offhandRange = config.OffhandRange();
		this.rangeSwap = config.rangeSwap();
		this.targetAnimation = config.animationTarget();
		this.targetBodyMage = config.targetBodyMage();
		this.targetBodyMelee = config.targetBodyMelee();
		this.targetBodyRange = config.targetBodyRange();
		this.targetBootsMage = config.targetBootsMage();
		this.targetBootsMelee = config.targetBootsMelee();
		this.targetBootsRange = config.targetBootsRange();
		this.targetCapeMage = config.targetCapeMage();
		this.targetCapeMelee = config.targetCapeMelee();
		this.targetCapeRange = config.targetCapeRange();
		this.targetGlovesMage = config.targetGlovesMage();
		this.targetGlovesMelee = config.targetGlovesMelee();
		this.targetGlovesRange = config.targetGlovesRange();
		this.targetGraphic = config.graphicTarget();
		this.targetHelmetMage = config.targetHelmetMage();
		this.targetHelmetMelee = config.targetHelmetMelee();
		this.targetHelmetRange = config.targetHelmetRange();
		this.targetLegsMage = config.targetLegsMage();
		this.targetLegsMelee = config.targetLegsMelee();
		this.targetLegsRange = config.targetLegsRange();
		this.targetMainhandMage = config.targetMainhandMage();
		this.targetMainhandMelee = config.targetMainhandMelee();
		this.targetMainhandRange = config.targetMainhandRange();
		this.targetNeckMage = config.targetNeckMage();
		this.targetNeckMelee = config.targetNeckMelee();
		this.targetNeckRange = config.targetNeckRange();
		this.targetOffhandMage = config.targetOffhandMage();
		this.targetOffhandMelee = config.targetOffhandMelee();
		this.targetOffhandRange = config.targetOffhandRange();
	}
}
