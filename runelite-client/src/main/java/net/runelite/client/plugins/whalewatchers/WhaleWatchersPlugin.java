/*******************************************************************************
 * Copyright (c) 2019. PKLite
 *  Redistributions and modifications of this software are permitted as long as this notice remains in its original unmodified state at the top of this file.
 *  If there are any questions comments, or feedback about this software, please direct all inquiries directly to the following authors:
 *
 *   PKLite discord: https://discord.gg/Dp3HuFM
 *   Written by PKLite(ST0NEWALL, others) <stonewall@stonewall@pklite.xyz>, 2019
 *
 ******************************************************************************/

package net.runelite.client.plugins.whalewatchers;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemID;
import net.runelite.api.MenuAction;
import net.runelite.api.Skill;
import net.runelite.api.SkullIcon;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import static net.runelite.api.WorldType.HIGH_RISK;
import static net.runelite.api.WorldType.PVP;
import static net.runelite.api.WorldType.isPvpWorld;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.kit.KitType;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.OverlayMenuClicked;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import org.apache.commons.lang3.ObjectUtils;

@PluginDescriptor(
	name = "Whale Watchers",
	description = "A Plugin to save help whales in the wild",
	tags = {"whale watchers", "whale", "protect item", "warning", "pklite"},
	type = PluginType.PVP,
	enabledByDefault = false
)

public class WhaleWatchersPlugin extends Plugin
{

	public boolean enableOverlay = false;
	public int damageDone = 0;
	public int damageTaken = 0;
	public boolean inCombat = false;
	@Inject
	private Client client;
	@Inject
	private WhaleWatchersConfig config;
	@Inject
	private WhaleWatchersOverlay overlay;
	@Inject
	private WhaleWatchersProtOverlay whaleWatchersProtOverlay;
	@Inject
	private WhaleWatchersSmiteableOverlay whaleWatchersSmiteableOverlay;
	@Inject
	private WhaleWatchersGloryOverlay whaleWatchersGloryOverlay;
	@Inject
	private OverlayManager overlayManager;
	private int tickCountdown = 0;
	@Getter
	private boolean displaySmiteOverlay;
	@Getter
	private boolean displayGloryOverlay;

	@Provides
	WhaleWatchersConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WhaleWatchersConfig.class);
	}

	@Subscribe
	public void onOverlayMenuClicked(OverlayMenuClicked event)
	{
		if (!event.getOverlay().equals(overlay))
		{
			return;
		}
		else
		{
			if (event.getEntry().getOption().equals("Reset"))
			{
				resetDamageCounter();
			}
		}
	}

	@Override
	protected void startUp() throws Exception
	{

		overlayManager.add(overlay);
		overlayManager.add(whaleWatchersProtOverlay);
		overlayManager.add(whaleWatchersSmiteableOverlay);
		overlayManager.add(whaleWatchersGloryOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		overlayManager.remove(whaleWatchersProtOverlay);
		overlayManager.remove(whaleWatchersSmiteableOverlay);
		overlayManager.remove(whaleWatchersGloryOverlay);
		resetDamageCounter();
	}


	@Subscribe
	public void onHitsplatApplied(HitsplatApplied event)
	{
		if (config.showDamageCounter())
		{
			if (!(event.getActor() == client.getLocalPlayer() ||
				event.getActor() == client.getLocalPlayer().getInteracting()))
			{
				return;
			}
			if (isAttackingPlayer() || inCombat)
			{
				inCombat = true;
				if (event.getActor() == client.getLocalPlayer())
				{
					damageTaken += event.getHitsplat().getAmount();
				}
				if (event.getActor() == client.getLocalPlayer().getInteracting())
				{
					damageDone += event.getHitsplat().getAmount();
				}
			}
		}
	}


	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (config.gloryWarning() && event.getItemContainer() == client.getItemContainer(InventoryID.EQUIPMENT))
		{
			final int amuletID = ObjectUtils.defaultIfNull(client.getLocalPlayer()
				.getPlayerAppearance().getEquipmentId(KitType.AMULET), 0);
			displayGloryOverlay = amuletID == ItemID.AMULET_OF_GLORY;
		}
		else
		{
			displayGloryOverlay = false;
		}
	}


	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (config.showDamageCounter() && event.getMenuAction().equals(MenuAction.SPELL_CAST_ON_PLAYER))
		{
			inCombat = true;
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (config.showDamageCounter())
		{
			if (client.getVar(VarPlayer.ATTACKING_PLAYER) == -1)
			{
				if (inCombat)
				{
					tickCountdown = 10;
				}
			}
		}

		if (config.protectItemWarning())
		{
			try
			{
				if (client.getLocalPlayer().getSkullIcon() == (SkullIcon.SKULL))
				{
					if (client.getVar(Varbits.PRAYER_PROTECT_ITEM) == 0 && client.getVar(Varbits.IN_WILDERNESS) == 1 ||
						client.getWorldType().contains(PVP))
					{
						enableOverlay = true;
					}
					if (client.getVar(Varbits.PRAYER_PROTECT_ITEM) == 1 || client.getVar(Varbits.IN_WILDERNESS) == 0 ||
						client.getWorldType().contains(HIGH_RISK) || client.getWorld() == 365)
					{
						enableOverlay = false;
					}
				}
				else
				{
					enableOverlay = false;
				}
			}
			catch (NullPointerException e)
			{

			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (config.showDamageCounter())
		{
			if (tickCountdown > 0 && tickCountdown < 11)
			{
				tickCountdown--;
				if (tickCountdown == 1)
				{
					inCombat = false;
					resetDamageCounter();
					return;
				}
			}
		}
		if (config.smiteableWarning() && (client.getVar(Varbits.IN_WILDERNESS) == 1 || isPvpWorld(client.getWorldType())))
		{
			if (client.getLocalPlayer().getSkullIcon() != null && client.getLocalPlayer().getSkullIcon().equals(SkullIcon.SKULL))
			{
				final int currentHealth = client.getLocalPlayer().getHealth();
				final int currentPrayer = client.getBoostedSkillLevel(Skill.PRAYER);
				displaySmiteOverlay = currentPrayer <= (Math.ceil(currentHealth / 4));
			}
			else
			{
				displaySmiteOverlay = false;
			}
		}
		else
		{
			displaySmiteOverlay = false;
		}
	}

	/**
	 * Checks to see if client is attacking another player
	 *
	 * @return returns true if they are, false otherwise
	 */
	private boolean isAttackingPlayer()
	{
		if (client.getVar(Varbits.IN_WILDERNESS) == 1 && client.getLocalPlayer().getInteracting() != null)
		{
			return true;
		}
		int varp = client.getVar(VarPlayer.ATTACKING_PLAYER);
		return varp != -1;
	}

	private void resetDamageCounter()
	{
		damageTaken = 0;
		damageDone = 0;
	}

}
