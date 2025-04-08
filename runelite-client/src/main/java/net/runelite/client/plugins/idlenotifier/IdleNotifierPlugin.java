/*
 * Copyright (c) 2016-2017, Abel Briggs
 * Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
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
package net.runelite.client.plugins.idlenotifier;

import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameState;
import net.runelite.api.Hitsplat;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GraphicChanged;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.NpcChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.gameval.AnimationID;
import net.runelite.api.gameval.SpotanimID;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.Notification;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Idle Notifier",
	description = "Send a notification when going idle, or when HP/Prayer reaches a threshold",
	tags = {"health", "hitpoints", "notifications", "prayer"},
	enabledByDefault = false
)
public class IdleNotifierPlugin extends Plugin
{
	private static final int IDLE_LOGOUT_WARNING_BUFFER = 20_000 / Constants.CLIENT_TICK_LENGTH;
	private static final int COMBAT_WARNING_MILLIS = 19 * 60 * 1000; // 19 minutes
	private static final int COMBAT_WARNING_CLIENT_TICKS = COMBAT_WARNING_MILLIS / Constants.CLIENT_TICK_LENGTH;

	private static final int HIGHEST_MONSTER_ATTACK_SPEED = 8; // Except Scarab Mage, but they are with other monsters
	private static final Duration SIX_HOUR_LOGOUT_WARNING_AFTER_DURATION = Duration.ofMinutes(340);

	private static final String FISHING_SPOT = "Fishing spot";

	@Inject
	private Notifier notifier;

	@Inject
	private Client client;

	@Inject
	private IdleNotifierConfig config;

	@Inject
	private ConfigManager configManager;

	private Instant lastAnimating;
	private int lastAnimation = -1;
	private Instant lastInteracting;
	private Actor lastInteract;
	private Instant lastMoving;
	private WorldPoint lastPosition;
	private boolean notifyPosition = false;
	private boolean notifyHitpoints = true;
	private boolean notifyPrayer = true;
	private boolean shouldNotifyLowEnergy = false;
	private boolean shouldNotifyHighEnergy = false;
	private boolean notifyOxygen = true;
	private boolean notifyIdleLogout = true;
	private boolean notify6HourLogout = true;
	private int lastSpecEnergy = 1000;
	private int lastCombatCountdown = 0;
	private Instant sixHourWarningTime;
	private boolean ready;
	private boolean lastInteractWasCombat;
	private static final int BUFF_BAR_NOT_DISPLAYED = -1;

	@Provides
	IdleNotifierConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(IdleNotifierConfig.class);
	}

	@Override
	protected void startUp()
	{
		// can't tell when 6hr will be if enabled while already logged in
		sixHourWarningTime = null;
		migrateConfig();
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		Player localPlayer = client.getLocalPlayer();
		if (localPlayer != event.getActor())
		{
			return;
		}

		int graphic = localPlayer.getGraphic();
		int animation = localPlayer.getAnimation();
		switch (animation)
		{
			/* Woodcutting */
			case AnimationID.HUMAN_WOODCUTTING_BRONZE_AXE:
			case AnimationID.HUMAN_WOODCUTTING_IRON_AXE:
			case AnimationID.HUMAN_WOODCUTTING_STEEL_AXE:
			case AnimationID.HUMAN_WOODCUTTING_BLACK_AXE:
			case AnimationID.HUMAN_WOODCUTTING_MITHRIL_AXE:
			case AnimationID.HUMAN_WOODCUTTING_ADAMANT_AXE:
			case AnimationID.HUMAN_WOODCUTTING_RUNE_AXE:
			case AnimationID.HUMAN_WOODCUTTING_GILDED_AXE:
			case AnimationID.HUMAN_WOODCUTTING_DRAGON_AXE:
			case AnimationID.HUMAN_WOODCUTTING_TRAILBLAZER_AXE_NO_INFERNAL:
			case AnimationID.HUMAN_WOODCUTTING_INFERNAL_AXE:
			case AnimationID.HUMAN_WOODCUTTING_3A_AXE:
			case AnimationID.HUMAN_WOODCUTTING_CRYSTAL_AXE:
			case AnimationID.HUMAN_OPENHEAVYCHEST:
			case AnimationID.FORESTRY_2H_AXE_CHOPPING_BRONZE:
			case AnimationID.FORESTRY_2H_AXE_CHOPPING_IRON:
			case AnimationID.FORESTRY_2H_AXE_CHOPPING_STEEL:
			case AnimationID.FORESTRY_2H_AXE_CHOPPING_BLACK:
			case AnimationID.FORESTRY_2H_AXE_CHOPPING_MITHRIL:
			case AnimationID.FORESTRY_2H_AXE_CHOPPING_ADAMANT:
			case AnimationID.FORESTRY_2H_AXE_CHOPPING_RUNE:
			case AnimationID.FORESTRY_2H_AXE_CHOPPING_DRAGON:
			case AnimationID.FORESTRY_2H_AXE_CHOPPING_CRYSTAL:
			case AnimationID.FORESTRY_2H_AXE_CHOPPING_CRYSTAL_INACTIVE:
			case AnimationID.FORESTRY_2H_AXE_CHOPPING_3A:
			/* Woodcutting: Ents & Canoes */
			case AnimationID.HUMAN_CANOEING_CARVE_BRONZE_AXE:
			case AnimationID.HUMAN_CANOEING_CARVE_IRON_AXE:
			case AnimationID.HUMAN_CANOEING_CARVE_STEEL_AXE:
			case AnimationID.HUMAN_CANOEING_CARVE_BLACK_AXE:
			case AnimationID.HUMAN_CANOEING_CARVE_MITHRIL_AXE:
			case AnimationID.HUMAN_CANOEING_CARVE_ADAMANT_AXE:
			case AnimationID.HUMAN_CANOEING_CARVE_RUNE_AXE:
			case AnimationID.BRUT_HUMAN_CANOEING_CARVE_GILDED_AXE:
			case AnimationID.HUMAN_CANOEING_CARVE_DRAGON_AXE:
			case AnimationID.HUMAN_CANOEING_CARVE_TRAILBLAZER_AXE_NO_INFERNAL:
			case AnimationID.HUMAN_CANOEING_CARVE_INFERNAL_AXE:
			case AnimationID.HUMAN_CANOEING_CARVE_LEAGUE_TRAILBLAZER_AXE:
			case AnimationID.BRUT_HUMAN_CANOEING_CARVE_3A_AXE:
			case AnimationID.HUMAN_CANOEING_CARVE_CRYSTAL_AXE:
			case AnimationID.BRUT_HUMAN_CANOEING_CARVE_CRYSTAL_AXE:
			case AnimationID.BRUT_HUMAN_CANOEING_CARVE_LEAGUE_TRAILBLAZER_AXE:
			case AnimationID.HUMAN_CANOEING_CARVE_BRONZE_2H_AXE:
			case AnimationID.HUMAN_CANOEING_CARVE_IRON_2H_AXE:
			case AnimationID.HUMAN_CANOEING_CARVE_STEEL_2H_AXE:
			case AnimationID.HUMAN_CANOEING_CARVE_BLACK_2H_AXE:
			case AnimationID.HUMAN_CANOEING_CARVE_MITHRIL_2H_AXE:
			case AnimationID.HUMAN_CANOEING_CARVE_ADAMANT_2H_AXE:
			case AnimationID.HUMAN_CANOEING_CARVE_RUNE_2H_AXE:
			case AnimationID.HUMAN_CANOEING_CARVE_DRAGON_2H_AXE:
			case AnimationID.HUMAN_CANOEING_CARVE_CRYSTAL_2H_AXE:
			case AnimationID.HUMAN_CANOEING_CARVE_CRYSTAL_2H_AXE_INACTIVE:
			case AnimationID.HUMAN_CANOEING_CARVE_3A_2H_AXE:
			case AnimationID.TBW_CLEANUP_PLAYER_SURPRISE_STEPBACK:
			/* Firemaking */
			case AnimationID.FORESTRY_CAMPFIRE_BURNING_ARCTIC_PINE_LOG:
			case AnimationID.FORESTRY_CAMPFIRE_BURNING_BLISTERWOOD_LOGS:
			case AnimationID.FORESTRY_CAMPFIRE_BURNING_LOGS:
			case AnimationID.FORESTRY_CAMPFIRE_BURNING_MAGIC_LOGS:
			case AnimationID.FORESTRY_CAMPFIRE_BURNING_MAHOGANY_LOGS:
			case AnimationID.FORESTRY_CAMPFIRE_BURNING_MAPLE_LOGS:
			case AnimationID.FORESTRY_CAMPFIRE_BURNING_OAK_LOGS:
			case AnimationID.FORESTRY_CAMPFIRE_BURNING_REDWOOD_LOGS:
			case AnimationID.FORESTRY_CAMPFIRE_BURNING_TEAK_LOGS:
			case AnimationID.FORESTRY_CAMPFIRE_BURNING_WILLOW_LOGS:
			case AnimationID.FORESTRY_CAMPFIRE_BURNING_YEW_LOGS:
			/* Cooking(Fire, Range) */
			case AnimationID.HUMAN_FIRECOOKING:
			case AnimationID.HUMAN_COOKING:
			case AnimationID.HUMAN_MAKE_WINE:
			/* Crafting(Gem Cutting, Glassblowing, Spinning, Weaving, Battlestaves, Pottery) */
			case AnimationID.HUMAN_OPALCUTTING:
			case AnimationID.HUMAN_JADECUTTING:
			case AnimationID.HUMAN_REDTOPAZCUTTING:
			case AnimationID.HUMAN_SAPPHIRECUTTING:
			case AnimationID.HUMAN_EMERALDCUTTING:
			case AnimationID.HUMAN_RUBYCUTTING:
			case AnimationID.HUMAN_DIAMONDCUTTING:
			case AnimationID.HUMAN_AMETHYSTCUTTING:
			case AnimationID.HUMAN_GLASSBLOWING:
			case AnimationID.HUMAN_SPINNINGWHEEL:
			case AnimationID.FARMING_USELOOM:
			case AnimationID.HUMAN_BATTLESTAFF_CRAFTING:
			case AnimationID.HUMAN_LEATHER_CRAFTING:
			case AnimationID.HUMAN_POTTERYWHEEL:
			case AnimationID.HUMAN_CUTTING_RESTART:
			/* Fletching(Cutting, Stringing, Adding feathers and heads) */
			case AnimationID.HUMAN_FLETCHING:
			case AnimationID.XBOWS_FLETCHING_WOOD_BRONZE:
			case AnimationID.XBOWS_FLETCHING_OAK_BLURITE:
			case AnimationID.XBOWS_FLETCHING_WILLOW_IRON:
			case AnimationID.XBOWS_FLETCHING_TEAK_STEEL:
			case AnimationID.XBOWS_FLETCHING_MAPLE_MITHRIL:
			case AnimationID.XBOWS_FLETCHING_MAHOGANY_ADAMANTITE:
			case AnimationID.XBOWS_FLETCHING_YEW_RUNITE:
			case AnimationID.XBOWS_FLETCHING_YEW_DRAGON:
			case AnimationID.STRINGING_SHORTBOW:
			case AnimationID.STRINGING_OAK_SHORTBOW:
			case AnimationID.STRINGING_WILLOW_SHORTBOW:
			case AnimationID.STRINGING_MAPLE_SHORTBOW:
			case AnimationID.STRINGING_YEW_SHORTBOW:
			case AnimationID.STRINGING_MAGIC_SHORTBOW:
			case AnimationID.STRINGING_LONGBOW:
			case AnimationID.STRINGING_OAK_LONGBOW:
			case AnimationID.STRINGING_WILLOW_LONGBOW:
			case AnimationID.STRINGING_MAPLE_LONGBOW:
			case AnimationID.STRINGING_YEW_LONGBOW:
			case AnimationID.STRINGING_MAGIC_LONGBOW:
			case AnimationID.HUMAN_FLETCHING_ADD_FEATHER:
			case AnimationID.HUMAN_FLETCHING_ADD_ARROW_TIPS:
			case AnimationID.HUMAN_FLETCHING_ADD_BOLT_TIPS_BRONZE:
			case AnimationID.HUMAN_FLETCHING_ADD_BOLT_TIPS_IRON:
			case AnimationID.HUMAN_FLETCHING_ADD_BOLT_TIPS_BLURITE:
			case AnimationID.HUMAN_FLETCHING_ADD_BOLT_TIPS_STEEL:
			case AnimationID.HUMAN_FLETCHING_ADD_BOLT_TIPS_MITHRIL:
			case AnimationID.HUMAN_FLETCHING_ADD_BOLT_TIPS_ADAMANT:
			case AnimationID.HUMAN_FLETCHING_ADD_BOLT_TIPS_RUNE:
			case AnimationID.HUMAN_FLETCHING_ADD_BOLT_TIPS_DRAGON:
			/* Smithing(Anvil, Furnace, Cannonballs */
			case AnimationID.HUMAN_SMITHING:
			case AnimationID.HUMAN_SMITHING_IMCANDO_HAMMER:
			case AnimationID.HUMAN_FURNACE:
			case AnimationID.HUMAN_PICKUPFLOOR:
			/* Fishing */
			case AnimationID.INFERNALEEL_BREAK:
			case AnimationID.INFERNALEEL_BREAK_IMCANDO:
			case AnimationID.SNAKEBOSS_SLICEEEL:
			case AnimationID.HUMAN_LARGENET:
			case AnimationID.HUMAN_SMALLNET:
			case AnimationID.HUMAN_FISH_ONSPOT:
			case AnimationID.HUMAN_LOBSTER:
			case AnimationID.HUMAN_HARPOON:
			case AnimationID.HUMAN_HARPOON_BARBED:
			case AnimationID.HUMAN_HARPOON_DRAGON:
			case AnimationID.HUMAN_HARPOON_TRAILBLAZER_NO_INFERNAL:
			case AnimationID.HUMAN_HARPOON_INFERNAL:
			case AnimationID.HUMAN_HARPOON_CRYSTAL:
			case AnimationID.HUMAN_HARPOON_LEAGUE_TRAILBLAZER:
			case AnimationID.HUMAN_FISHING_CASTING:
			case AnimationID.HUMAN_OCTOPUS_POT:
			case AnimationID.BRUT_PLAYER_HAND_FISHING_END_BLANK:
			case AnimationID.HUMAN_FISHING_CASTING_PEARL:
			case AnimationID.HUMAN_FISHING_CASTING_PEARL_FLY:
			case AnimationID.HUMAN_FISHING_CASTING_PEARL_BRUT:
			case AnimationID.HUMAN_FISH_ONSPOT_PEARL:
			case AnimationID.HUMAN_FISH_ONSPOT_PEARL_FLY:
			case AnimationID.HUMAN_FISH_ONSPOT_PEARL_BRUT:
			case AnimationID.HUMAN_FISHING_CASTING_PEARL_OILY:
			case AnimationID.HUMAN_FISHING_ONSPOT_BRUT:
			/* Mining(Normal) */
			case AnimationID.HUMAN_MINING_BRONZE_PICKAXE:
			case AnimationID.HUMAN_MINING_IRON_PICKAXE:
			case AnimationID.HUMAN_MINING_STEEL_PICKAXE:
			case AnimationID.HUMAN_MINING_BLACK_PICKAXE:
			case AnimationID.HUMAN_MINING_MITHRIL_PICKAXE:
			case AnimationID.HUMAN_MINING_ADAMANT_PICKAXE:
			case AnimationID.HUMAN_MINING_RUNE_PICKAXE:
			case AnimationID.HUMAN_MINING_GILDED_PICKAXE:
			case AnimationID.HUMAN_MINING_DRAGON_PICKAXE:
			case AnimationID.HUMAN_MINING_DRAGON_PICKAXE_PRETTY:
			case AnimationID.HUMAN_MINING_ZALCANO_PICKAXE:
			case AnimationID.HUMAN_MINING_TRAILBLAZER_PICKAXE_NO_INFERNAL:
			case AnimationID.HUMAN_MINING_INFERNAL_PICKAXE:
			case AnimationID.HUMAN_MINING_3A_PICKAXE:
			case AnimationID.HUMAN_MINING_CRYSTAL_PICKAXE:
			case AnimationID.HUMAN_MINING_LEAGUE_TRAILBLAZER_PICKAXE:
			case AnimationID.HUMAN_MINING_LEAGUE_TRAILBLAZER_PICKAXE_NOREACHFORWARD:
			case AnimationID.HUMAN_MINING_ZALCANO_LEAGUE_TRAILBLAZER_PICKAXE:
			case AnimationID.ARCEUUS_CHISEL_ESSENCE:
			case AnimationID.ARCEUUS_CHISEL_ESSENCEBLOCK:
			/* Mining(Motherlode) */
			case AnimationID.HUMAN_MINING_BRONZE_PICKAXE_WALL:
			case AnimationID.HUMAN_MINING_IRON_PICKAXE_WALL:
			case AnimationID.HUMAN_MINING_STEEL_PICKAXE_WALL:
			case AnimationID.HUMAN_MINING_BLACK_PICKAXE_WALL:
			case AnimationID.HUMAN_MINING_MITHRIL_PICKAXE_WALL:
			case AnimationID.HUMAN_MINING_ADAMANT_PICKAXE_WALL:
			case AnimationID.HUMAN_MINING_RUNE_PICKAXE_WALL:
			case AnimationID.HUMAN_MINING_GILDED_PICKAXE_WALL:
			case AnimationID.HUMAN_MINING_DRAGON_PICKAXE_WALL:
			case AnimationID.HUMAN_MINING_DRAGON_PICKAXE_PRETTY_WALL:
			case AnimationID.HUMAN_MINING_ZALCANO_PICKAXE_WALL:
			case AnimationID.HUMAN_MINING_TRAILBLAZER_PICKAXE_NO_INFERNAL_WALL:
			case AnimationID.HUMAN_MINING_INFERNAL_PICKAXE_WALL:
			case AnimationID.HUMAN_MINING_3A_PICKAXE_WALL:
			case AnimationID.HUMAN_MINING_CRYSTAL_PICKAXE_WALL:
			case AnimationID.HUMAN_MINING_LEAGUE_TRAILBLAZER_PICKAXE_WALL:
			/* Mining(Crashed Star) */
			case AnimationID.HUMAN_MINING_BRONZE_PICKAXE_NOREACHFORWARD:
			case AnimationID.HUMAN_MINING_IRON_PICKAXE_NOREACHFORWARD:
			case AnimationID.HUMAN_MINING_STEEL_PICKAXE_NOREACHFORWARD:
			case AnimationID.HUMAN_MINING_BLACK_PICKAXE_NOREACHFORWARD:
			case AnimationID.HUMAN_MINING_MITHRIL_PICKAXE_NOREACHFORWARD:
			case AnimationID.HUMAN_MINING_ADAMANT_PICKAXE_NOREACHFORWARD:
			case AnimationID.HUMAN_MINING_RUNE_PICKAXE_NOREACHFORWARD:
			case AnimationID.HUMAN_MINING_GILDED_PICKAXE_NOREACHFORWARD:
			case AnimationID.HUMAN_MINING_DRAGON_PICKAXE_NOREACHFORWARD:
			case AnimationID.HUMAN_MINING_DRAGON_PICKAXE_PRETTY_NOREACHFORWARD:
			case AnimationID.HUMAN_MINING_ZALCANO_PICKAXE_NOREACHFORWARD:
			case AnimationID.HUMAN_MINING_TRAILBLAZER_PICKAXE_NO_INFERNAL_NOREACHFORWARD:
			case AnimationID.HUMAN_MINING_INFERNAL_PICKAXE_NOREACHFORWARD:
			case AnimationID.HUMAN_MINING_3A_PICKAXE_NOREACHFORWARD:
			case AnimationID.HUMAN_MINING_CRYSTAL_PICKAXE_NOREACHFORWARD:
			/* Herblore */
			case AnimationID.HUMAN_HERBING_GRIND:
			case AnimationID.HUMAN_HERBING_VIAL:
			case AnimationID.HUMAN_SALAMANDER_TAR_GRIND:
			case AnimationID.HUMAN_MACHINERY_ALCHEMY01_RETORT01_INTERACT01:
			case AnimationID.HUMAN_MACHINERY_ALCHEMY01_ALEMBIC01_INTERACT01:
			case AnimationID.HUMAN_MACHINERY_ALCHEMY01_AGITATOR01_INTERACT01:
			case AnimationID.HUMAN_ALCHEMY01_MILL01_INTERACT01:
			/* Magic */
			case AnimationID.HUMAN_CASTCHARGEORB:
			case AnimationID.DREAM_PLAYER_MAKE_PLANK_SPELL:
			case AnimationID.LUNAR_HUMAN_MAGIC_SUMMON1:
			case AnimationID.POH_CREATE_MAGIC_TABLET_WITHSTAFF:
			case AnimationID.HUMAN_CAST_ENCHANTRING:
			case AnimationID.HUMAN_ENCHANTAMULETLVL1:
			case AnimationID.HUMAN_ENCHANTAMULETLVL2:
			case AnimationID.HUMAN_ENCHANTAMULETLVL3:
			case AnimationID.HUMAN_XBOW_ENCHANT_ARROWTIP:
			/* Prayer */
			case AnimationID.HUMAN_BONE_SACRIFICE:
			case AnimationID.QUEST_AHOY_HUMAN_FILLING_BUCKET:
			case AnimationID.AHOY_BONE_DUMP:
			case AnimationID.AHOY_BONE_GRIND:
			case AnimationID.AHOY_FILLBUCKET_BONEDUST:
			/* Farming */
			case AnimationID.ULTRACOMPOST_MAKE:
			case AnimationID.PICKING_MID:
			case AnimationID.PICKING_LOW:
			case AnimationID.PICKING_HIGH:
			case AnimationID.FARMING_PICK_MUSHROOM:
			case AnimationID.HUMAN_DIG:
			/* Misc */
			case AnimationID.PISC_REPAIR_HAMMER:
			case AnimationID.POH_CREATE_MAGIC_TABLET:
			case AnimationID.HUMAN_FILLBUCKET_SANDPIT:
			case AnimationID.MILKIT:
			case AnimationID.PLAYER_CHURNS_MILK_SHORT:
			case AnimationID.PLAYER_CHURNS_MILK_MEDIUM:
			case AnimationID.PLAYER_CHURNS_MILK_LONG:
			case AnimationID.VM_PLAYER_USE_SPECIMEN_BRUSH:
			case AnimationID.VM_PLAYER_USE_ROCKPICK:
			case AnimationID.HUMAN_PICKUPTABLE:
			case AnimationID.HUMAN_PRAY_BLESSED_BONE_SHARDS_01:
			case AnimationID.HUMAN_HERBING_GRIND_RESTART:
			case AnimationID.VARLAMORE_THIEVING_SEARCH:
				resetTimers();
				lastAnimation = animation;
				lastAnimating = Instant.now();
				break;
			case AnimationID.LUNAR_HUMAN_MAGIC_SUMMON2:
				if (graphic == SpotanimID.QUEST_LUNAR_BAKEPIE_SPOTANIM)
				{
					resetTimers();
					lastAnimation = animation;
					lastAnimating = Instant.now();
					break;
				}
			case -1:
				lastAnimating = Instant.now();
				break;
			default:
				// On unknown animation simply assume the animation is invalid and dont throw notification
				lastAnimation = -1;
				lastAnimating = null;
		}
	}

	@Subscribe
	public void onInteractingChanged(InteractingChanged event)
	{
		final Actor source = event.getSource();
		if (source != client.getLocalPlayer())
		{
			return;
		}

		final Actor target = event.getTarget();

		// Reset last interact
		if (target != null)
		{
			lastInteract = null;
		}
		else
		{
			lastInteracting = Instant.now();
		}

		// If this is not NPC, do not process as we are not interested in other entities
		if (!(target instanceof NPC))
		{
			return;
		}

		checkNpcInteraction((NPC) target);
	}

	// this event is needed to handle some rare npcs where "Attack" is not used to initiate combat
	// for example, kraken starts the fight with "Disturb" then changes into another form with "Attack"
	@Subscribe
	public void onNpcChanged(NpcChanged event)
	{
		NPC npc = event.getNpc();
		if (client.getLocalPlayer().getInteracting() != npc)
		{
			return;
		}

		checkNpcInteraction(npc);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		lastInteracting = null;

		GameState state = gameStateChanged.getGameState();

		switch (state)
		{
			case LOGIN_SCREEN:
				resetTimers();
				break;
			case LOGGING_IN:
			case HOPPING:
			case CONNECTION_LOST:
				ready = true;
				break;
			case LOGGED_IN:
				if (ready)
				{
					sixHourWarningTime = Instant.now().plus(SIX_HOUR_LOGOUT_WARNING_AFTER_DURATION);
					ready = false;
					resetTimers();
				}

				break;
		}
	}

	@Subscribe
	public void onHitsplatApplied(HitsplatApplied event)
	{
		if (event.getActor() != client.getLocalPlayer())
		{
			return;
		}

		final Hitsplat hitsplat = event.getHitsplat();
		if (hitsplat.isMine())
		{
			lastCombatCountdown = HIGHEST_MONSTER_ATTACK_SPEED;
		}
	}

	@Subscribe
	public void onGraphicChanged(GraphicChanged event)
	{
		Actor actor = event.getActor();

		if (actor != client.getLocalPlayer())
		{
			return;
		}

		if (actor.getGraphic() == SpotanimID.FAILEDSPELL_IMPACT)
		{
			lastCombatCountdown = HIGHEST_MONSTER_ATTACK_SPEED;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		final Player local = client.getLocalPlayer();
		final Duration waitDuration = Duration.ofMillis(config.getIdleNotificationDelay());
		lastCombatCountdown = Math.max(lastCombatCountdown - 1, 0);

		if (local == null
			// If user has clicked in the last second then they're not idle so don't send idle notification
			|| System.currentTimeMillis() - client.getMouseLastPressedMillis() < 1000
			|| client.getKeyboardIdleTicks() < 10)
		{
			resetTimers();
			return;
		}

		if (checkIdleLogout())
		{
			notifier.notify(config.logoutIdle(), "You are about to log out from idling too long!");
		}

		if (check6hrLogout())
		{
			notifier.notify(config.sixHourLogout(), "You are about to log out from being online for 6 hours!");
		}

		if (checkAnimationIdle(waitDuration, local))
		{
			notifier.notify(config.animationIdle(), "You are now idle!");
		}

		if (checkMovementIdle(waitDuration, local))
		{
			notifier.notify(config.movementIdle(), "You have stopped moving!");
		}

		if (checkInteractionIdle(waitDuration, local))
		{
			if (lastInteractWasCombat)
			{
				notifier.notify(config.interactionIdle(), "You are now out of combat!");
			}
			else
			{
				notifier.notify(config.interactionIdle(), "You are now idle!");
			}
		}

		if (checkLowHitpoints())
		{
			notifier.notify(config.getHitpointsNotification(), "You have low hitpoints!");
		}

		if (checkLowPrayer())
		{
			notifier.notify(config.getPrayerNotification(), "You have low prayer!");
		}

		if (checkLowEnergy())
		{
			notifier.notify(config.getLowEnergyNotification(), "You have low run energy!");
		}

		if (checkHighEnergy())
		{
			notifier.notify(config.getHighEnergyNotification(), "You have restored run energy!");
		}

		if (checkLowOxygen())
		{
			notifier.notify(config.getOxygenNotification(), "You have low oxygen!");
		}

		if (checkFullSpecEnergy())
		{
			notifier.notify(config.getSpecNotification(), "You have restored spec energy!");
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (event.getVarpId() == VarPlayerID.GROUP_GATHERING_ACTIVE_BUFF && event.getValue() == BUFF_BAR_NOT_DISPLAYED)
		{
			resetTimers();
			lastAnimation = AnimationID.HUMAN_WOODCUTTING_RUNE_AXE;
			lastAnimating = Instant.now();
		}
	}

	private void migrateConfig()
	{
		String migrated = configManager.getConfiguration(IdleNotifierConfig.GROUP, "migrated");
		if ("1".equals(migrated))
		{
			return;
		}

		int hitpointsThreshold = configManager.getConfiguration(IdleNotifierConfig.GROUP, "hitpoints", int.class);
		if (hitpointsThreshold == 0)
		{
			configManager.setConfiguration(IdleNotifierConfig.GROUP, "hitpoints", 1);
			configManager.setConfiguration(IdleNotifierConfig.GROUP, "hitpointsNotification", Notification.OFF);
		}
		else
		{
			configManager.setConfiguration(IdleNotifierConfig.GROUP, "hitpointsNotification", Notification.ON);
		}

		int prayerThreshold = configManager.getConfiguration(IdleNotifierConfig.GROUP, "prayer", int.class);
		if (prayerThreshold == 0)
		{
			configManager.setConfiguration(IdleNotifierConfig.GROUP, "prayer", 1);
			configManager.setConfiguration(IdleNotifierConfig.GROUP, "prayerNotification", Notification.OFF);
		}
		else
		{
			configManager.setConfiguration(IdleNotifierConfig.GROUP, "prayerNotification", Notification.ON);
		}

		int lowEnergyThreshold = configManager.getConfiguration(IdleNotifierConfig.GROUP, "lowEnergy", int.class);
		if (lowEnergyThreshold == 100)
		{
			configManager.setConfiguration(IdleNotifierConfig.GROUP, "lowEnergy", 0);
			configManager.setConfiguration(IdleNotifierConfig.GROUP, "lowEnergyNotification", Notification.OFF);
		}
		else
		{
			configManager.setConfiguration(IdleNotifierConfig.GROUP, "lowEnergyNotification", Notification.ON);
		}

		int highEnergyThreshold = configManager.getConfiguration(IdleNotifierConfig.GROUP, "highEnergy", int.class);
		if (highEnergyThreshold == 0)
		{
			configManager.setConfiguration(IdleNotifierConfig.GROUP, "highEnergy", 100);
			configManager.setConfiguration(IdleNotifierConfig.GROUP, "highEnergyNotification", Notification.OFF);
		}
		else
		{
			configManager.setConfiguration(IdleNotifierConfig.GROUP, "highEnergyNotification", Notification.ON);
		}

		int oxygenThreshold = configManager.getConfiguration(IdleNotifierConfig.GROUP, "oxygen", int.class);
		if (oxygenThreshold == 0)
		{
			configManager.setConfiguration(IdleNotifierConfig.GROUP, "oxygen", 1);
			configManager.setConfiguration(IdleNotifierConfig.GROUP, "oxygenNotification", Notification.OFF);
		}
		else
		{
			configManager.setConfiguration(IdleNotifierConfig.GROUP, "oxygenNotification", Notification.ON);
		}

		int specThreshold = configManager.getConfiguration(IdleNotifierConfig.GROUP, "spec", int.class);
		if (specThreshold == 0)
		{
			configManager.setConfiguration(IdleNotifierConfig.GROUP, "spec", 1);
			configManager.setConfiguration(IdleNotifierConfig.GROUP, "specNotification", Notification.OFF);
		}
		else
		{
			configManager.setConfiguration(IdleNotifierConfig.GROUP, "specNotification", Notification.ON);
		}

		configManager.setConfiguration(IdleNotifierConfig.GROUP, "migrated", 1);
	}

	private void checkNpcInteraction(final NPC target)
	{
		final NPCComposition npcComposition = target.getComposition();
		final List<String> npcMenuActions = Arrays.asList(npcComposition.getActions());

		if (npcMenuActions.contains("Attack"))
		{
			// Player is most likely in combat with attack-able NPC
			resetTimers();
			lastInteract = target;
			lastInteracting = Instant.now();
			lastInteractWasCombat = true;
		}
		else if (target.getName() != null && target.getName().contains(FISHING_SPOT))
		{
			// Player is fishing
			resetTimers();
			lastInteract = target;
			lastInteracting = Instant.now();
			lastInteractWasCombat = false;
		}
	}

	private boolean checkFullSpecEnergy()
	{
		int currentSpecEnergy = client.getVarpValue(VarPlayerID.SA_ENERGY);

		int threshold = config.getSpecEnergyThreshold() * 10;
		if (threshold == 0)
		{
			lastSpecEnergy = currentSpecEnergy;
			return false;
		}

		// Check if we have regenerated over the threshold, and that the
		// regen was small enough.
		boolean notify = lastSpecEnergy < threshold && currentSpecEnergy >= threshold
			&& currentSpecEnergy - lastSpecEnergy <= 100;
		lastSpecEnergy = currentSpecEnergy;
		return notify;
	}

	private boolean checkLowOxygen()
	{
		if (config.getOxygenThreshold() == 0)
		{
			return false;
		}
		if (config.getOxygenThreshold() >= client.getVarbitValue(VarbitID.FOSSIL_UNDERWATER_OXYGEN) * 0.1)
		{
			if (!notifyOxygen)
			{
				notifyOxygen = true;
				return true;
			}
		}
		else
		{
			notifyOxygen = false;
		}
		return false;
	}

	private boolean checkLowHitpoints()
	{
		if (config.getHitpointsThreshold() == 0)
		{
			return false;
		}
		if (client.getRealSkillLevel(Skill.HITPOINTS) > config.getHitpointsThreshold())
		{
			if (client.getBoostedSkillLevel(Skill.HITPOINTS) + client.getVarbitValue(VarbitID.NZONE_ABSORB_POTION_EFFECTS) <= config.getHitpointsThreshold())
			{
				if (!notifyHitpoints)
				{
					notifyHitpoints = true;
					return true;
				}
			}
			else
			{
				notifyHitpoints = false;
			}
		}

		return false;
	}

	private boolean checkLowPrayer()
	{
		if (config.getPrayerThreshold() == 0)
		{
			return false;
		}
		if (client.getRealSkillLevel(Skill.PRAYER) > config.getPrayerThreshold())
		{
			if (client.getBoostedSkillLevel(Skill.PRAYER) <= config.getPrayerThreshold())
			{
				if (!notifyPrayer)
				{
					notifyPrayer = true;
					return true;
				}
			}
			else
			{
				notifyPrayer = false;
			}
		}

		return false;
	}

	private boolean checkLowEnergy()
	{
		if (config.getLowEnergyThreshold() >= 100)
		{
			return false;
		}

		if (client.getEnergy() / 100 <= config.getLowEnergyThreshold())
		{
			if (shouldNotifyLowEnergy)
			{
				shouldNotifyLowEnergy = false;
				return true;
			}
		}
		else
		{
			shouldNotifyLowEnergy = true;
		}

		return false;
	}

	private boolean checkHighEnergy()
	{
		if (config.getHighEnergyThreshold() == 0)
		{
			return false;
		}

		if (client.getEnergy() / 100 >= config.getHighEnergyThreshold())
		{
			if (shouldNotifyHighEnergy)
			{
				shouldNotifyHighEnergy = false;
				return true;
			}
		}
		else
		{
			shouldNotifyHighEnergy = true;
		}

		return false;
	}

	private boolean checkInteractionIdle(Duration waitDuration, Player local)
	{
		if (lastInteract == null)
		{
			return false;
		}

		final Actor interact = local.getInteracting();

		if (interact == null)
		{
			if (lastInteracting != null
				&& Instant.now().compareTo(lastInteracting.plus(waitDuration)) >= 0
				&& lastCombatCountdown == 0)
			{
				lastInteract = null;
				lastInteracting = null;

				// prevent animation notifications from firing too
				lastAnimation = -1;
				lastAnimating = null;

				return true;
			}
		}
		else
		{
			lastInteracting = Instant.now();
		}

		return false;
	}

	private boolean checkIdleLogout()
	{
		// Check clientside AFK first, because this is required for the server to disconnect you for being first
		final int idleClientTicks = Math.min(client.getKeyboardIdleTicks(), client.getMouseIdleTicks());

		if (idleClientTicks < client.getIdleTimeout() - IDLE_LOGOUT_WARNING_BUFFER)
		{
			notifyIdleLogout = true;
			return false;
		}

		// If we are not receiving hitsplats then we can be afk kicked
		if (lastCombatCountdown <= 0)
		{
			boolean warn = notifyIdleLogout;
			notifyIdleLogout = false;
			return warn;
		}

		// We are in combat, so now we have to check for the timer that knocks you out of combat
		// I think there are other conditions that I don't know about, because during testing I just didn't
		// get removed from combat sometimes.
		final long lastInteractionAgo = System.currentTimeMillis() - client.getMouseLastPressedMillis();
		if (lastInteractionAgo < COMBAT_WARNING_MILLIS || client.getKeyboardIdleTicks() < COMBAT_WARNING_CLIENT_TICKS)
		{
			notifyIdleLogout = true;
			return false;
		}

		boolean warn = notifyIdleLogout;
		notifyIdleLogout = false;
		return warn;
	}

	private boolean check6hrLogout()
	{
		if (sixHourWarningTime == null)
		{
			return false;
		}

		if (Instant.now().compareTo(sixHourWarningTime) >= 0)
		{
			if (notify6HourLogout)
			{
				notify6HourLogout = false;
				return true;
			}
		}
		else
		{
			notify6HourLogout = true;
		}

		return false;
	}

	private boolean checkAnimationIdle(Duration waitDuration, Player local)
	{
		if (lastAnimation == -1)
		{
			return false;
		}

		final int animation = local.getAnimation();

		if (animation == -1)
		{
			if (lastAnimating != null && Instant.now().compareTo(lastAnimating.plus(waitDuration)) >= 0)
			{
				lastAnimation = -1;
				lastAnimating = null;

				// prevent interaction notifications from firing too
				lastInteract = null;
				lastInteracting = null;

				return true;
			}
		}
		else
		{
			lastAnimating = Instant.now();
		}

		return false;
	}

	private boolean checkMovementIdle(Duration waitDuration, Player local)
	{
		if (lastPosition == null)
		{
			lastPosition = local.getWorldLocation();
			return false;
		}

		WorldPoint position = local.getWorldLocation();

		if (lastPosition.equals(position))
		{
			if (notifyPosition
				&& local.getAnimation() == -1
				&& Instant.now().compareTo(lastMoving.plus(waitDuration)) >= 0)
			{
				notifyPosition = false;
				// Return true only if we weren't just breaking out of an animation
				return lastAnimation == -1;
			}
		}
		else
		{
			notifyPosition = true;
			lastPosition = position;
			lastMoving = Instant.now();
		}

		return false;
	}

	private void resetTimers()
	{
		final Player local = client.getLocalPlayer();

		// Reset animation idle timer
		lastAnimating = null;
		var gameState = client.getGameState();
		if (gameState == GameState.LOGIN_SCREEN || local == null || local.getAnimation() != lastAnimation)
		{
			lastAnimation = -1;
		}

		// Reset interaction idle timer
		lastInteracting = null;
		if (gameState == GameState.LOGIN_SCREEN || local == null || local.getInteracting() != lastInteract)
		{
			lastInteract = null;
		}
	}
}
