
/*
 * ******************************************************************************
 *  * Copyright (c) 2019 openosrs
 *  *  Redistributions and modifications of this software are permitted as long as this notice remains in its original unmodified state at the top of this file.
 *  *  If there are any questions comments, or feedback about this software, please direct all inquiries directly to the file authors:
 *  *  ST0NEWALL#9112
 *  *   openosrs Discord: https://discord.gg/Q7wFtCe
 *  *   openosrs website: https://openosrs.com
 *  *****************************************************************************
 */

package net.runelite.client.plugins.whalewatchers;

import com.google.inject.Provides;
import java.util.EnumSet;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemID;
import net.runelite.api.MenuOpcode;
import net.runelite.api.Skill;
import net.runelite.api.SkullIcon;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.WorldType;
import static net.runelite.api.WorldType.isPvpWorld;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.kit.KitType;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.OverlayMenuClicked;
import net.runelite.client.game.Sound;
import net.runelite.client.game.SoundManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import org.apache.commons.lang3.ObjectUtils;

@PluginDescriptor(
	name = "Whale Watchers",
	description = "A Plugin to save help whales in the wild",
	tags = {"whale watchers", "whale", "protect item", "warning", "pklite", "pneck"},
	type = PluginType.PVP,
	enabledByDefault = false
)

@Singleton
public class WhaleWatchersPlugin extends Plugin
{
	boolean protectItemOverlay = false;
	int damageDone = 0;
	int damageTaken = 0;
	boolean inCombat = false;
	private static final String BROKEN_PNECK_MESSAGE = "Your phoenix necklace heals you, but is destroyed in the process.";
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
	@Inject
	private SoundManager soundManager;
	@Inject
	private EventBus eventBus;
	private int tickCountdown = 0;
	@Getter(AccessLevel.PACKAGE)
	private boolean displaySmiteOverlay;
	@Getter(AccessLevel.PACKAGE)
	private boolean displayGloryOverlay;
	@Getter(AccessLevel.PACKAGE)
	private boolean protectItemWarning;
	@Getter(AccessLevel.PACKAGE)
	private boolean lessObnoxiousProtWarning;
	@Getter(AccessLevel.PACKAGE)
	private boolean showDamageCounter;
	private boolean smiteableWarning;
	private boolean gloryWarning;
	private boolean pneckBreak;

	@Provides
	WhaleWatchersConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WhaleWatchersConfig.class);
	}

	private void onOverlayMenuClicked(OverlayMenuClicked event)
	{
		if (event.getOverlay().equals(overlay) && event.getEntry().getOption().equals("Reset"))
		{
			resetDamageCounter();
		}
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		overlayManager.add(overlay);
		overlayManager.add(whaleWatchersProtOverlay);
		overlayManager.add(whaleWatchersSmiteableOverlay);
		overlayManager.add(whaleWatchersGloryOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);
		overlayManager.remove(overlay);
		overlayManager.remove(whaleWatchersProtOverlay);
		overlayManager.remove(whaleWatchersSmiteableOverlay);
		overlayManager.remove(whaleWatchersGloryOverlay);
		resetDamageCounter();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(OverlayMenuClicked.class, this, this::onOverlayMenuClicked);
		eventBus.subscribe(HitsplatApplied.class, this, this::onHitsplatApplied);
		eventBus.subscribe(ItemContainerChanged.class, this, this::onItemContainerChanged);
		eventBus.subscribe(MenuOptionClicked.class, this, this::onMenuOptionClicked);
		eventBus.subscribe(VarbitChanged.class, this, this::onVarbitChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("WhaleWatchers"))
		{
			return;
		}

		updateConfig();

		if (!this.protectItemWarning)
		{
			protectItemOverlay = false;
		}
		if (!this.gloryWarning)
		{
			displayGloryOverlay = false;
		}
		if (!this.smiteableWarning)
		{
			displaySmiteOverlay = false;
		}
	}

	private void onChatMessage(ChatMessage event)
	{
		if (this.pneckBreak && event.getType() == ChatMessageType.GAMEMESSAGE && event.getMessage().equals(BROKEN_PNECK_MESSAGE))
		{
			soundManager.playSound(Sound.BREAK);
		}
	}

	private void onHitsplatApplied(HitsplatApplied event)
	{
		if (this.showDamageCounter)
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

	private void onItemContainerChanged(ItemContainerChanged event)
	{
		if (this.gloryWarning && event.getItemContainer() == client.getItemContainer(InventoryID.EQUIPMENT))
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

	private void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (this.showDamageCounter && event.getMenuOpcode().equals(MenuOpcode.SPELL_CAST_ON_PLAYER))
		{
			inCombat = true;
		}
	}

	private void onVarbitChanged(VarbitChanged event)
	{
		if (this.showDamageCounter && client.getVar(VarPlayer.ATTACKING_PLAYER) == -1 && inCombat)
			{
				tickCountdown = 10;
			}

		if (this.protectItemWarning)
		{
			try
			{
				final SkullIcon skullIcon = Objects.requireNonNull(client.getLocalPlayer().getSkullIcon());
				final EnumSet<WorldType> worldTypes = client.getWorldType();
				if (WorldType.isHighRiskWorld(worldTypes))
				{
					protectItemOverlay = false;
					return;
				}
				if (skullIcon.equals(SkullIcon.SKULL))
				{
					if (WorldType.isPvpWorld(worldTypes) || WorldType.isDeadmanWorld(worldTypes) ||
						client.getVar(Varbits.IN_WILDERNESS) == 1)
					{
						protectItemOverlay = client.getRealSkillLevel(Skill.PRAYER) > 25 &&
							client.getVar(Varbits.PRAYER_PROTECT_ITEM) == 0;
					}
					else
					{
						protectItemOverlay = false;
					}
				}
			}
			catch (NullPointerException e)
			{
				// local player isn't skulled
			}

		}
	}

	private void onGameTick(GameTick event)
	{
		if (this.showDamageCounter && tickCountdown > 0 && tickCountdown < 11)
		{
			tickCountdown--;
			if (tickCountdown == 1)
			{
				inCombat = false;
				resetDamageCounter();
				return;
			}
		}
		if (this.smiteableWarning && (client.getVar(Varbits.IN_WILDERNESS) == 1 || isPvpWorld(client.getWorldType())))
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
	
	private void updateConfig()
	{
		this.protectItemWarning = config.protectItemWarning();
		this.lessObnoxiousProtWarning = config.lessObnoxiousProtWarning();
		this.showDamageCounter = config.showDamageCounter();
		this.smiteableWarning = config.smiteableWarning();
		this.gloryWarning = config.gloryWarning();
		this.pneckBreak = config.pneckBreak();
	}
}