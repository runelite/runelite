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
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.kit.KitType;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
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

public class TMorph extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private TMorphConfig config;

	@Provides
	TMorphConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TMorphConfig.class);
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		if (config.animationTarget() <= 0 && config.animationSwap() <= 0 && config.globalAnimSwap() > 0)
		{
			if (event.getActor().getAnimation() != -1)
			{
				event.getActor().setAnimation(config.globalAnimSwap());
			}
		}
		if (config.animationTarget() > 0 && config.animationSwap() > 0)
		{
			if (event.getActor().getAnimation() == config.animationTarget())
			{
				event.getActor().setAnimation(config.animationSwap());
			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
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

		if (config.mageSwap())
		{
			if (config.MainhandMage() > 0)
			{
				if (config.targetMainhandMage() > 0)
				{
					if (mainhandID == config.targetMainhandMage())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.WEAPON.getIndex()] = config.MainhandMage() + 512;
					}
				}
			}
			if (config.OffhandMage() > 0)
			{
				if (config.targetOffhandMage() > 0)
				{
					if (offhandID == config.targetOffhandMage())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.SHIELD.getIndex()] = config.OffhandMage() + 512;
					}
				}
			}
			if (config.HelmetMage() > 0)
			{
				if (config.targetHelmetMage() > 0)
				{
					if (helmetID == config.targetHelmetMage())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.HELMET.getIndex()] = config.HelmetMage() + 512;
					}
				}
			}
			if (config.CapeMage() > 0)
			{
				if (config.targetCapeMage() > 0)
				{
					if (capeID == config.targetCapeMage())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.CAPE.getIndex()] = config.CapeMage() + 512;
					}
				}
			}
			if (config.NeckMage() > 0)
			{
				if (config.targetNeckMage() > 0)
				{
					if (neckID == config.targetNeckMage())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.AMULET.getIndex()] = config.NeckMage() + 512;
					}
				}
			}
			if (config.BodyMage() > 0)
			{
				if (config.targetBodyMage() > 0)
				{
					if (bodyID == config.targetBodyMage())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.TORSO.getIndex()] = config.BodyMage() + 512;
					}
				}
			}
			if (config.LegsMage() > 0)
			{
				if (config.targetLegsMage() > 0)
				{
					if (legsID == config.targetLegsMage())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.LEGS.getIndex()] = config.LegsMage() + 512;
					}
				}
			}
			if (config.BootsMage() > 0)
			{
				if (config.targetBootsMage() > 0)
				{
					if (bootsID == config.targetBootsMage())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.BOOTS.getIndex()] = config.BootsMage() + 512;
					}
				}
			}
			if (config.GlovesMage() > 0)
			{
				if (config.targetGlovesMage() > 0)
				{
					if (glovesID == config.targetGlovesMage())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.HANDS.getIndex()] = config.GlovesMage() + 512;
					}
				}
			}
		}
		if (config.rangeSwap())
		{
			if (config.MainhandRange() > 0)
			{
				if (config.targetMainhandRange() > 0)
				{
					if (mainhandID == config.targetMainhandRange())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.WEAPON.getIndex()] = config.MainhandRange() + 512;
					}
				}
			}
			if (config.OffhandRange() > 0)
			{
				if (config.targetOffhandRange() > 0)
				{
					if (offhandID == config.targetOffhandRange())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.SHIELD.getIndex()] = config.OffhandRange() + 512;
					}
				}
			}
			if (config.HelmetRange() > 0)
			{
				if (config.targetHelmetRange() > 0)
				{
					if (helmetID == config.targetHelmetRange())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.HELMET.getIndex()] = config.HelmetRange() + 512;
					}
				}
			}
			if (config.CapeRange() > 0)
			{
				if (config.targetCapeRange() > 0)
				{
					if (capeID == config.targetCapeRange())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.CAPE.getIndex()] = config.CapeRange() + 512;
					}
				}
			}
			if (config.NeckRange() > 0)
			{
				if (config.targetNeckRange() > 0)
				{
					if (neckID == config.targetNeckRange())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.AMULET.getIndex()] = config.NeckRange() + 512;
					}
				}
			}
			if (config.BodyRange() > 0)
			{
				if (config.targetBodyRange() > 0)
				{
					if (bodyID == config.targetBodyRange())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.TORSO.getIndex()] = config.BodyRange() + 512;
					}
				}
			}
			if (config.LegsRange() > 0)
			{
				if (config.targetLegsRange() > 0)
				{
					if (legsID == config.targetLegsRange())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.LEGS.getIndex()] = config.LegsRange() + 512;
					}
				}
			}
			if (config.BootsRange() > 0)
			{
				if (config.targetBootsRange() > 0)
				{
					if (bootsID == config.targetBootsRange())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.BOOTS.getIndex()] = config.BootsRange() + 512;
					}
				}
			}
			if (config.GlovesRange() > 0)
			{
				if (config.targetGlovesRange() > 0)
				{
					if (glovesID == config.targetGlovesRange())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.HANDS.getIndex()] = config.GlovesRange() + 512;
					}
				}
			}
		}
		if (config.meleeSwap())
		{
			if (config.MainhandMelee() > 0)
			{
				if (config.targetMainhandMelee() > 0)
				{
					if (mainhandID == config.targetMainhandMelee())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.WEAPON.getIndex()] = config.MainhandMelee() + 512;
					}
				}
			}
			if (config.OffhandMelee() > 0)
			{
				if (config.targetOffhandMelee() > 0)
				{
					if (offhandID == config.targetOffhandMelee())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.SHIELD.getIndex()] = config.OffhandMelee() + 512;
					}
				}
			}
			if (config.HelmetMelee() > 0)
			{
				if (config.targetHelmetMelee() > 0)
				{
					if (helmetID == config.targetHelmetMelee())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.HELMET.getIndex()] = config.HelmetMelee() + 512;
					}
				}
			}
			if (config.CapeMelee() > 0)
			{
				if (config.targetCapeMelee() > 0)
				{
					if (capeID == config.targetCapeMelee())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.CAPE.getIndex()] = config.CapeMelee() + 512;
					}
				}
			}
			if (config.NeckMelee() > 0)
			{
				if (config.targetNeckMelee() > 0)
				{
					if (neckID == config.targetNeckMelee())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.AMULET.getIndex()] = config.NeckMelee() + 512;
					}
				}
			}
			if (config.BodyMelee() > 0)
			{
				if (config.targetBodyMelee() > 0)
				{
					if (bodyID == config.targetBodyMelee())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.TORSO.getIndex()] = config.BodyMelee() + 512;
					}
				}
			}
			if (config.LegsMelee() > 0)
			{
				if (config.targetLegsMelee() > 0)
				{
					if (legsID == config.targetLegsMelee())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.LEGS.getIndex()] = config.LegsMelee() + 512;
					}
				}
			}
			if (config.BootsMelee() > 0)
			{
				if (config.targetBootsMelee() > 0)
				{
					if (bootsID == config.targetBootsMelee())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.BOOTS.getIndex()] = config.BootsMelee() + 512;
					}
				}
			}
			if (config.GlovesMelee() > 0)
			{
				if (config.targetGlovesMelee() > 0)
				{
					if (glovesID == config.targetGlovesMelee())
					{
						player.getPlayerAppearance().getEquipmentIds()[KitType.HANDS.getIndex()] = config.GlovesMelee() + 512;
					}
				}
			}
		}
		player.getPlayerAppearance().setHash();
	}
}
