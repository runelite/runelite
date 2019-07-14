/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.combatcounter;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import static net.runelite.api.AnimationID.BARRAGE_ANIMATION;
import static net.runelite.api.AnimationID.BLOWPIPE_ATTACK;
import static net.runelite.api.AnimationID.CHIN_ANIMATION;
import net.runelite.api.Client;
import net.runelite.api.Hitsplat;
import net.runelite.api.NPC;
import net.runelite.api.NPCDefinition;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.kit.KitType;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
		name = "Tick Counter",
		description = "Count the amount of perfect combat ticks performed by each player.",
		tags = {"combat", "counter", "tick"},
		type = PluginType.UTILITY,
		enabledByDefault = false
)
@Singleton
@Slf4j
public class CombatCounter extends Plugin 
{

	@Inject
	private Client client;

	@Inject
	private CombatOverlay tickOverlay;

	@Inject
	private DamageOverlay damageOverlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private CombatCounterConfig config;

	@Inject
	private EventBus eventBus;

	private boolean instanced = false;
	@Setter(AccessLevel.PACKAGE)
	@Getter(AccessLevel.PACKAGE)
	private Map<String, Long> counter = new HashMap<>();

	private final Map<String, Long> blowpipe = new HashMap<>();

	private final Map<NPC, NPCDamageCounter> npcDamageMap = new HashMap<>();
	Map<String, Double> playerDamage = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private boolean showTickCounter;
	@Getter(AccessLevel.PACKAGE)
	private boolean showDamageCounter;
	private boolean resetOnNewInstance;
	@Getter(AccessLevel.PACKAGE)
	private Color selfColor;
	@Getter(AccessLevel.PACKAGE)
	private Color totalColor;
	@Getter(AccessLevel.PACKAGE)
	private Color otherColor;
	@Getter(AccessLevel.PACKAGE)
	private Color bgColor;
	@Getter(AccessLevel.PACKAGE)
	private Color titleColor;

	@Provides
	CombatCounterConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CombatCounterConfig.class);
	}

	private static final Map<Integer, Integer> VARIABLES = ImmutableMap.<Integer, Integer>builder()
		.put(422, 4) // Unarmed Punch, Block
		.put(423, 4) // Unarmed Kick

		.put(8145, 4) // Rapier Stab, Lunge, Block
		.put(390, 4) // Rapier Slash

		.put(7552, 5) // Armadyl Crossbow Accurate, Rapid, Longrange, Special

		.put(1167, 4) // Trident Accurate, Accurate, Longrange

		.put(401, 6) // Dragon Warhammer Pound, Pummel, Block
		.put(1378, 6) // Dragon Warhammer Special

		.put(393, 4) // Dragon Claws Chop, Slash, Block
		.put(1067, 4) // Dragon Claws Lunge
		.put(7514, 4) // Dragon Claws Special

		.put(8288, 4) // Dragon Hunter Lance Lunge, Block
		.put(8289, 4) // Dragon Hunter Lance Swipe
		.put(8290, 4) // Dragon Hunter Lance Pound

		.put(7516, 6) // Elder maul Pound, Pummel, Block

		.put(8056, 5) // Scythe of Vitur Reap, Chop, Jab, Block

		.put(7045, 6) // Bandos Godsword Chop, Slash
		.put(7054, 6) // Bandos Godsword Smash
		.put(7055, 6) // Bandos Godsword Block
		.put(7642, 6) // Bandos Godsword Special
		.put(7643, 6) // Bandos Godsword Special (Ornamate)

		.put(426, 5) // Twisted Bow Accurate, Rapid, Longrange

		.put(414, 5) // Kodai Bash, Pound, Focus

		// .put(428, 4) // Staff of Light Jab
		.put(440, 4) // Staff of Light Swipe
		//.put(419, 4) // Staff of Light Fend
		.put(7967, 4) // Staff of Light Special

		.put(428, 7) // Crystal Halberd Jab, Fend
		.put(419, 7) // Crystal Halberd Swipe
		.put(1203, 7) // Crystal Halberd Special

		.put(5061, 2) // Toxic Blowpipe Accurate, Rapid, Longrange, Special

		.put(1979, 5) // Ancient Magicks Barrage
		.put(1978, 5) // Ancient Magicks Blitz

		.put(7618, 3) // Chinchompa Short, Medium, Long Fuse
		.put(1658, 4) // Whip Flick, Lash, Deflect

		.put(7555, 6) // Ballista Accurate, Rapid, Longrange
		.build();


	private static final Set<Integer> MELEE_ANIMATIONS = ImmutableSet.<Integer>builder()
		.add(422) // Unarmed Punch, Block
		.add(423) // Unarmed Kick

		.add(8145) // Rapier Stab, Lunge, Block
		.add(390) // Rapier Slash

		.add(401) // Dragon Warhammer Pound, Pummel, Block
		.add(1378) // Dragon Warhammer Special

		.add(393) // Dragon Claws Chop, Slash, Block
		.add(1067) // Dragon Claws Lunge
		.add(7514) // Dragon Claws Special

		.add(8288) // Dragon Hunter Lance Lunge, Block
		.add(8289) // Dragon Hunter Lance Swipe
		.add(8290) // Dragon Hunter Lance Pound

		.add(7516) // Elder maul Pound, Pummel, Block

		.add(8056) // Scythe of Vitur Reap, Chop, Jab, Block

		.add(7045) // Bandos Godsword Chop, Slash
		.add(7054) // Bandos Godsword Smash
		.add(7055) // Bandos Godsword Block
		.add(7642) // Bandos Godsword Special
		.add(7643) // Bandos Godsword Special (Ornamate)

		.add(414) // Kodai Bash, Pound, Focus

		.add(428) // Staff of Light Jab
		.add(440) // Staff of Light Swipe
		.add(419) // Staff of Light Fend

		.add(428) // Crystal Halberd Jab, Fend
		.add(419) // Crystal Halberd Swipe
		.add(1203) // Crystal Halberd Special

		.add(1658) // Whip Flick, Lash, Deflect
		.build();

	private static final Set<Integer> RANGE_ANIMATIONS = ImmutableSet.of(
		7552, // Armadyl Crossbow Accurate, Rapid, Longrange, Special
		426, // Twisted Bow Accurate, Rapid, Longrange
		7618, // Chinchompa Short, Medium, Long Fuse
		7555 // Ballista Accurate, Rapid, Longrange
	);

	private static final Set<Integer> MAGE_ANIMATIONS = ImmutableSet.of(
		1167, // Trident Accurate, Accurate, Longrange
		1978, // Ancient Magicks Blitz
		1979 // Ancient Magicks Barrage
	);

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		overlayManager.add(tickOverlay);
		overlayManager.add(damageOverlay);

		this.counter.clear();
		this.blowpipe.clear();
		this.npcDamageMap.clear();
		this.playerDamage.clear();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(tickOverlay);
		overlayManager.remove(damageOverlay);

		this.counter.clear();
		this.blowpipe.clear();
		this.npcDamageMap.clear();
		this.playerDamage.clear();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(AnimationChanged.class, this, this::onAnimationChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(HitsplatApplied.class, this, this::onHitsplatApplied);
	}

	private void onAnimationChanged(AnimationChanged event)
	{
		Actor actor = event.getActor();

		if (actor instanceof Player)
		{
			Player p = (Player) actor;
			String name = actor.getName();
			if (name != null)
			{
				int animation = p.getAnimation();
				if (animation != -1)
				{
					if (VARIABLES.containsKey(animation))
					{
						/*
						 * This part handles the Tick Counter.
						 */
						long ticks = VARIABLES.get(animation);
						if (((Player) actor).getPlayerAppearance().getEquipmentId(KitType.WEAPON) == 23360)
						{
							ticks = 3;
						}
						if (counter.containsKey(name))
						{
							ticks += counter.get(name);
						}
						counter.put(name, ticks);
						counter = sortByValue(counter);

						if (animation == BLOWPIPE_ATTACK)
						{
							this.blowpipe.put(name, -4L);
						}

						/*
						 * This part handles the Damage Counter.
						 */
						Actor interacting = actor.getInteracting();
						if (interacting instanceof NPC)
						{
							NPC npc = (NPC) interacting;

							List<NPC> actives = new ArrayList<>();
							actives.add(npc);

							if (BARRAGE_ANIMATION == 1979 || CHIN_ANIMATION == 7618)
							{ // Barrage or chin.
								for (NPC nearby : this.client.getNpcs())
								{
									int distance = npc.getWorldLocation().distanceTo(nearby.getWorldLocation());
									if (distance <= 1 && npc != nearby)
									{
										actives.add(nearby);
									}
								}
							}

							int distance = calculateDistance(p, npc);

							int delay = -1;
							boolean canFarcast = false;

							if (animation == 7618)
							{
								delay = this.calculateChinDelay(distance);
								canFarcast = true;
							}
							else if (animation == 5061)
							{
								delay = this.calculateBPDelay(distance);
								canFarcast = true;
							}
							else if (RANGE_ANIMATIONS.contains(animation))
							{
								delay = this.calculateRangedDelay(distance);
								canFarcast = true;
							}
							else if (MELEE_ANIMATIONS.contains(animation))
							{
								delay = 1;
							}
							else if (MAGE_ANIMATIONS.contains(animation))
							{
								delay = this.calculateMageDelay(distance);
								canFarcast = true;
							}
							else
							{
								log.debug("Unclassified Animation: {}", animation);
							}

							if (delay != -1)
							{
								List<Integer> ticksToAdd = new ArrayList<>();
								ticksToAdd.add(delay);

								if (canFarcast && delay > 2)
								{
									ticksToAdd.add(delay - 1);
								}

								/*
								 * Dragon Claw Specials are 2 ticks long.
								 */
								if (animation == 7514)
								{
									ticksToAdd.add(delay + 1);
								}

								for (NPC target : actives)
								{
									NPCDamageCounter dc = new NPCDamageCounter();
									if (this.npcDamageMap.containsKey(target))
									{
										dc = this.npcDamageMap.get(target);
									}

									for (Integer tick : ticksToAdd)
									{
										List<String> attackers = new ArrayList<>();
										if (dc.attackers.containsKey(tick))
										{
											attackers = dc.attackers.get(tick);
										}

										attackers.add(name);
										dc.attackers.put(tick, attackers);
									}

									this.npcDamageMap.put(target, dc);
								}
							}
						}
					}
				}
				else
				{
					this.blowpipe.remove(name);
				}
			}
		}
	}

	private void onGameTick(GameTick event)
	{
		if (this.resetOnNewInstance)
		{
			boolean prevInstance = instanced;
			instanced = client.isInInstancedRegion();
			if (!prevInstance && instanced) 
			{
				this.counter.clear();
				this.blowpipe.clear();
				this.npcDamageMap.clear();
				this.playerDamage.clear();
			}
		}

		Map<String, Player> visible = new HashMap<>();
		for (Player p : this.client.getPlayers())
		{
			if (p.getName() != null)
			{
				visible.put(p.getName(), p);
			}
		}

		for (NPC npc : new ArrayList<>(this.npcDamageMap.keySet()))
		{
			NPCDamageCounter counter = this.npcDamageMap.get(npc);

			Map<Integer, List<String>> attackers = counter.attackers;
			for (Integer i : new ArrayList<>(attackers.keySet()))
			{
				List<String> p = attackers.get(i);
				attackers.put(i - 1, p);
				attackers.remove(i);
			}

			double totalDamage = 0d;
			for (Integer damage : counter.damage)
			{
				totalDamage += damage;
			}

			if (attackers.containsKey(-1))
			{
				List<String> players = attackers.get(-1);
				double totalPlayers = players.size();

				double damagePerPlayer = totalDamage / totalPlayers;
				for (String name : players)
				{
					double count = 0d;
					if (this.playerDamage.containsKey(name))
					{
						count = this.playerDamage.get(name);
					}

					count += damagePerPlayer;
					this.playerDamage.put(name, count);
				}

				counter.damage.clear();
			}
//			else if (totalDamage > 0){
//				counter.damage.clear();
//
//				String name = "[Unknown]";
//				double count = 0d;
//				if (this.playerDamage.containsKey(name))
//					count = this.playerDamage.get(name);
//
//				count += totalDamage;
//				this.playerDamage.put(name, count);
//			}

			for (Integer i : new ArrayList<>(attackers.keySet()))
			{
				if (i <= -1)
				{
					attackers.remove(i);
				}
			}

			if (attackers.isEmpty())
			{
				this.npcDamageMap.remove(npc);
			}
		}

		this.playerDamage = sortByValue(this.playerDamage);

		for (String user : new ArrayList<>(blowpipe.keySet()))
		{
			if (visible.containsKey(user))
			{
				long count = blowpipe.get(user);
				count++;
				blowpipe.replace(user, count);

				if (count % 2 == 0 && count >= 0 && counter.containsKey(user))
				{
					long ticks = counter.get(user);
					counter.replace(user, ticks + 2);
					counter = sortByValue(counter);

					Player p = visible.get(user);
					Actor interacting = p.getInteracting();
					if (interacting instanceof NPC)
					{
						NPC npc = (NPC) interacting;

						int distance = calculateDistance(p, npc);

						NPCDamageCounter dc = new NPCDamageCounter();
						if (this.npcDamageMap.containsKey(npc))
						{
							dc = this.npcDamageMap.get(npc);
						}

						int delay = this.calculateBPDelay(distance);

						List<Integer> counts = new ArrayList<>();
						counts.add(delay);
						if (delay > 2)
						{
							counts.add(delay - 1);
						}

						for (int tick : counts)
						{
							List<String> attackers = new ArrayList<>();
							if (dc.attackers.containsKey(tick))
							{
								attackers = dc.attackers.get(tick);
							}

							attackers.add(user);
							dc.attackers.put(tick, attackers);
						}

						this.npcDamageMap.put(npc, dc);
					}
				}
			}
			else
			{
				blowpipe.remove(user);
			}
		}
	}

	private void onHitsplatApplied(HitsplatApplied event)
	{
		Actor actor = event.getActor();

		if (!(actor instanceof NPC))
		{
			return;
		}

		NPC npc = (NPC) actor;

		if (!this.npcDamageMap.containsKey(npc))
		{
			return;
		}

		Hitsplat splat = event.getHitsplat();
		NPCDamageCounter dc = this.npcDamageMap.get(npc);

		dc.damage.add(splat.getAmount());
	}

	private <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map)
	{
		List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
		list.sort(Map.Entry.comparingByValue());

		Map<K, V> result = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : list)
		{
			result.put(entry.getKey(), entry.getValue());
		}

		return result;
	}

	private int calculateDistance(Player p, NPC npc)
	{
		int size = 1;
		NPCDefinition comp = npc.getTransformedDefinition();
		if (comp != null)
		{
			size = comp.getSize();
		}

		WorldPoint wpPlayer = p.getWorldLocation();
		WorldPoint wpNPC = npc.getWorldLocation();
		int distance = wpNPC.distanceTo(wpPlayer);

		if (size > 1)
		{
			for (int x = 0; x < size; x++)
			{
				for (int y = 0; y < size; y++)
				{
					WorldPoint wpNPCB = WorldPoint.fromRegion(wpNPC.getRegionID(), wpNPC.getRegionX() + x, wpNPC.getRegionY() + y, wpNPC.getPlane());
					int distB = wpNPCB.distanceTo(wpPlayer);
					if (distB >= 1 && distB < distance)
					{
						distance = distB;
					}
				}
			}
		}

		return distance;
	}

	private int calculateBPDelay(double distance)
	{
		return 2 + (int) Math.floor(distance / 6d);
	}

	private int calculateChinDelay(double distance)
	{
		return 2 + (int) Math.floor(distance / 6d);
	}

	private int calculateMageDelay(double distance)
	{
		return 2 + (int) Math.floor((1d + distance) / 3d);
	}

	private int calculateRangedDelay(double distance)
	{
		return 2 + (int) Math.floor((3d + distance) / 6d);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("combatcounter"))
		{
			updateConfig();
		}
	}

	private void updateConfig()
	{
		this.showTickCounter = config.showTickCounter();
		this.showDamageCounter = config.showDamageCounter();
		this.resetOnNewInstance = config.resetOnNewInstance();
		this.selfColor = config.selfColor();
		this.totalColor = config.totalColor();
		this.otherColor = config.otherColor();
		this.bgColor = config.bgColor();
		this.titleColor = config.titleColor();
	}
}