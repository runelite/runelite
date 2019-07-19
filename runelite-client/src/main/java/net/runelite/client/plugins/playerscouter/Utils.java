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
package net.runelite.client.plugins.playerscouter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.ItemDefinition;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Prayer;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.kit.KitType;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.PvPValueBrokenItem;
import net.runelite.client.util.StackFormatter;
import net.runelite.http.api.discord.DiscordClient;
import net.runelite.http.api.discord.DiscordEmbed;
import net.runelite.http.api.discord.DiscordMessage;
import net.runelite.http.api.discord.embed.AuthorEmbed;
import net.runelite.http.api.discord.embed.FieldEmbed;
import net.runelite.http.api.discord.embed.FooterEmbed;
import net.runelite.http.api.discord.embed.ThumbnailEmbed;
import net.runelite.http.api.item.ItemEquipmentStats;
import net.runelite.http.api.item.ItemStats;
import okhttp3.HttpUrl;

/*
This class is pretty useless, its not called anywhere else,
but I mainly have it so its pretty obvious whats happening
in the main class. Pretty much stuffing the ugly in here.
 */

@Slf4j
class Utils
{
	private static final double INCREASE = 0.60;
	private static final String ICONBASEURL = "https://www.osrsbox.com/osrsbox-db/items-icons/"; // Add item id + ".png"
	private static final SimpleDateFormat SDF = new SimpleDateFormat("MMM dd h:mm a z");

	static void reset(PlayerContainer player)
	{
		player.setMeleeAttack(0);
		player.setMagicAttack(0);
		player.setRangeAttack(0);
		player.setMeleeDefence(0);
		player.setMagicDefence(0);
		player.setRangeDefence(0);
		player.setRisk(0);
		player.setPrayerBonus(0);
		player.setDrainRate(0);
		player.setOverhead(Utils.iconToPrayer(player.getPlayer()));
		player.setAttackStyle(AttackStyle.UNKNOWN);
	}

	static void update(PlayerContainer player, ItemManager itemManager, int restores, Map<WorldArea, String> map)
	{
		updatePlayerGear(player, itemManager);
		updateAttackStyle(player);
		updateWeakness(player);
		player.setPredictedPrayer(predictOffensivePrayer(player.getPrayer().getLevel(), player.getAttackStyle()));
		updatePrayerDrainRate(player);
		updateEstimatedPrayer(player, restores);
		player.setLocation(location(player, map));
		player.setWildyLevel(getWildernessLevelFrom(player.getPlayer().getWorldLocation()));
		player.setTargetString(targetStringBuilder(player));
		if (player.isScouted())
		{
			player.setScoutTimer(player.getScoutTimer() - 1);

			if (player.getScoutTimer() <= 0)
			{
				player.setScouted(false);
				player.setScoutTimer(500);
			}
		}
		log.debug(player.toString());
	}

	//pvputil is private, so atm i can't grab from it.
	private static int getWildernessLevelFrom(WorldPoint point)
	{
		int y = point.getY();

		int underLevel = ((y - 9920) / 8) + 1;
		int upperLevel = ((y - 3520) / 8) + 1;

		return y > 6400 ? underLevel : upperLevel;
	}

	private static void updatePlayerGear(PlayerContainer player, ItemManager itemManager)
	{
		Map<Integer, Integer> prices = new HashMap<>();

		if (player.getPlayer().getPlayerAppearance() != null)
		{
			for (KitType kitType : KitType.values())
			{
				if (kitType.equals(KitType.RING) || kitType.equals(KitType.AMMUNITION))
				{
					continue;
				}

				final int id = player.getPlayer().getPlayerAppearance().getEquipmentId(kitType);

				if (id == -1)
				{
					continue;
				}

				if (kitType.equals(KitType.WEAPON))
				{
					player.setWeapon(id);
				}

				final ItemStats item = itemManager.getItemStats(id, false);
				final ItemDefinition itemDefinition = itemManager.getItemDefinition(id);

				if (item == null)
				{
					log.debug("Item is null: {}", id);
					continue;
				}

				if (itemDefinition == null)
				{
					log.debug("Item Def is null: {}", id);
					continue;
				}

				if (PvPValueBrokenItem.breaksOnDeath(id))
				{
					prices.put(id, itemManager.getBrokenValue(id));
					log.debug("Item has a broken value: Id {}, Value {}", id, itemManager.getBrokenValue(id));
				}

				if (!itemDefinition.isTradeable() && !PvPValueBrokenItem.breaksOnDeath(id))
				{
					prices.put(id, itemDefinition.getPrice());
				}
				else if (itemDefinition.isTradeable())
				{
					prices.put(id, itemManager.getItemPrice(id, false));
				}

				ItemEquipmentStats stats = item.getEquipment();

				if (stats == null)
				{
					log.debug("Stats are null: {}", item);
					continue;
				}

				player.setMeleeAttack(player.getMeleeAttack() + ((stats.getAcrush() + stats.getAslash() + stats.getAstab()) / 3));
				player.setMagicAttack(player.getMagicAttack() + stats.getAmagic());
				player.setRangeAttack(player.getRangeAttack() + stats.getArange());
				player.setMeleeDefence(player.getMeleeDefence() + ((stats.getDcrush() + stats.getDslash() + stats.getDstab()) / 3));
				player.setMagicDefence(player.getMagicDefence() + stats.getDmagic());
				player.setRangeDefence(player.getRangeDefence() + stats.getDrange());
				player.setPrayerBonus(player.getPrayerBonus() + stats.getPrayer());
			}
			updateGear(player, prices);
		}
	}

	static void updateTarget(PlayerContainer player)
	{
		if (player.isTarget())
		{
			if (player.getTimer() > 0)
			{
				player.setTimer(player.getTimer() - 1);
			}
			else if (player.getTimer() == 0)
			{
				player.setTarget(false);
			}
		}
	}

	static void updateDefence(PlayerContainer player)
	{
		if (player.getOverhead() != null)
		{
			//yeah i know this is a shit way to do it :shrug:
			switch (player.getOverhead())
			{
				case PROTECT_FROM_MELEE:
					player.setMeleeDefence((int) (player.getMeleeDefence() / INCREASE));
					log.debug("Melee Overhead, Defence Increased");
					break;
				case PROTECT_FROM_MAGIC:
					player.setMagicDefence((int) (player.getMagicDefence() / INCREASE));
					log.debug("Magic Overhead, Defence Increased");
					break;
				case PROTECT_FROM_MISSILES:
					player.setRangeDefence((int) (player.getRangeDefence() / INCREASE));
					log.debug("Range Overhead, Defence Increased");
					break;
			}
		}
	}

	private static void updateGear(PlayerContainer player, Map<Integer, Integer> prices)
	{
		player.setGear(prices.entrySet()
			.stream()
			.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new)));

		player.setRiskedGear(prices.entrySet()
			.stream()
			.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new)));

		if (player.getPlayer().getSkullIcon() == null)
		{
			removeEntries(player.getRiskedGear(), player.getPrayer().getLevel() <= 25 ? 3 : 4);
		}
		else
		{
			removeEntries(player.getRiskedGear(), player.getPrayer().getLevel() <= 25 ? 0 : 1);
		}

		player.getRiskedGear().values().forEach(price -> player.setRisk(player.getRisk() + price));
		prices.clear();
	}

	private static void updateAttackStyle(PlayerContainer player)
	{
		if (player.getMagicAttack() >= player.getRangeAttack() && player.getMagicAttack() >= player.getMeleeAttack())
		{
			player.setAttackStyle(AttackStyle.MAGE);
		}
		else if (player.getRangeAttack() >= player.getMagicAttack() && player.getRangeAttack() >= player.getMeleeAttack())
		{
			player.setAttackStyle(AttackStyle.RANGE);
		}
		else if (player.getMeleeAttack() >= player.getMagicAttack() && player.getMeleeAttack() >= player.getRangeAttack())
		{
			player.setAttackStyle(AttackStyle.MELEE);
		}
	}

	private static void updateWeakness(PlayerContainer player)
	{
		if (player.getMagicDefence() <= player.getRangeDefence() && player.getMagicDefence() <= player.getMeleeDefence())
		{
			player.setWeakness(AttackStyle.MAGE);
		}
		else if (player.getRangeDefence() <= player.getMagicDefence() && player.getRangeDefence() <= player.getMeleeDefence())
		{
			player.setWeakness(AttackStyle.RANGE);
		}
		else if (player.getMeleeAttack() <= player.getRangeDefence() && player.getMeleeAttack() <= player.getMagicDefence())
		{
			player.setWeakness(AttackStyle.MELEE);
		}
	}

	private static void updateEstimatedPrayer(PlayerContainer player, int restores)
	{
		player.setEstimatedPrayerString(getEstimatedPrayerRemaining(player, restores));

		if (player.getOverhead() == null)
		{
			return;
		}

		if (player.getEstimatedPrayer() >= 0)
		{
			player.setEstimatedPrayer(player.getEstimatedPrayer() - player.getDrainRate());
		}
	}

	private static void updatePrayerDrainRate(PlayerContainer player)
	{
		double drainRate = 0.0;

		if (player.getOverhead() != null)
		{
			drainRate += player.getOverhead().getDrainRate();
		}
		if (player.getPredictedPrayer() != null)
		{
			drainRate += player.getPredictedPrayer().getDrainRate();
		}
		if (player.getPrayer().getLevel() >= 25)
		{
			drainRate += Prayer.PROTECT_ITEM.getDrainRate();
		}
		drainRate = (((drainRate / 100)) / (1.0 + (player.getPrayerBonus() / 30.0)));

		player.setDrainRate(drainRate);
	}

	private static String getEstimatedPrayerRemaining(PlayerContainer player, int restores)
	{
		final double drainRate = player.getDrainRate();

		if (drainRate == 0)
		{
			return "N/A";
		}

		log.debug("Drain Rate: " + drainRate);

		final int prayerLevel = player.getPrayer().getLevel();
		final int restoreValue = (int) (4 * (prayerLevel * 0.25) + 8);
		final double estimatedTotalPrayer = prayerLevel + (restoreValue * restores);
		final double estimatedPrayer = player.getEstimatedPrayer();
		final int restoreValueLeft = (int) Math.round(estimatedPrayer - player.getPrayer().getLevel());

		if (player.getEstimatedPrayer() == 0)
		{
			player.setEstimatedPrayer(estimatedTotalPrayer);
		}

		if (restoreValueLeft > 0)
		{
			return player.getPrayer().getLevel() + "(" + restoreValueLeft + ")";
		}

		return Integer.toString((int) Math.round(estimatedPrayer));
	}

	private static void removeEntries(LinkedHashMap<Integer, Integer> map, int quantity)
	{
		if (map.size() < quantity)
		{
			log.debug("Size is lower than removal quantity.");
		}
		for (int i = 0; i < quantity; i++)
		{
			if (!map.entrySet().iterator().hasNext())
			{
				log.debug("Attempted to remove entries, but there was not enough to remove.");
				return;
			}
			log.debug("Entry Removed: " + map.entrySet().iterator().next());
			map.entrySet().remove(map.entrySet().iterator().next());
		}
	}

	private static Map.Entry getEntry(LinkedHashMap<Integer, Integer> map)
	{
		if (!map.isEmpty())
		{
			Iterator<Map.Entry<Integer, Integer>> entry = map.entrySet().iterator();

			for (int i = 0; i < 1; i++)
			{
				entry.next();
			}

			return entry.next();
		}
		return null;
	}

	private static Prayer iconToPrayer(Player player)
	{
		if (player.getOverheadIcon() != null)
		{
			switch (player.getOverheadIcon())
			{
				case RANGED:
					return Prayer.PROTECT_FROM_MISSILES;
				case MAGIC:
					return Prayer.PROTECT_FROM_MAGIC;
				case MELEE:
					return Prayer.PROTECT_FROM_MELEE;
				case SMITE:
					return Prayer.SMITE;
				case REDEMPTION:
					return Prayer.REDEMPTION;
				case RETRIBUTION:
					return Prayer.RETRIBUTION;
				default:
					return null;
			}
		}
		return null;
	}

	private static Prayer predictOffensivePrayer(int prayerLevel, AttackStyle attackStyle)
	{
		switch (attackStyle)
		{
			case MELEE:
				if (prayerLevel <= 12 && prayerLevel >= 1)
				{
					return Prayer.BURST_OF_STRENGTH;
				}
				else if (prayerLevel <= 30 && prayerLevel >= 13)
				{
					return Prayer.SUPERHUMAN_STRENGTH;
				}
				else if (prayerLevel <= 59 && prayerLevel >= 31)
				{
					return Prayer.ULTIMATE_STRENGTH;
				}
				else if (prayerLevel <= 69 && prayerLevel >= 60)
				{
					return Prayer.CHIVALRY;
				}
				else if (prayerLevel >= 70)
				{
					return Prayer.PIETY;
				}
			case RANGE:
				if (prayerLevel <= 8 && prayerLevel >= 1)
				{
					return Prayer.SHARP_EYE;
				}
				else if (prayerLevel <= 43 && prayerLevel >= 26)
				{
					return Prayer.HAWK_EYE;
				}
				else if (prayerLevel <= 73 && prayerLevel >= 44)
				{
					return Prayer.EAGLE_EYE;
				}
				else if (prayerLevel >= 74)
				{
					return Prayer.RIGOUR;
				}
			case MAGE:
				if (prayerLevel <= 26 && prayerLevel >= 9)
				{
					return Prayer.MYSTIC_WILL;
				}
				else if (prayerLevel <= 44 && prayerLevel >= 27)
				{
					return Prayer.MYSTIC_LORE;
				}
				else if (prayerLevel <= 76 && prayerLevel >= 45)
				{
					return Prayer.MYSTIC_MIGHT;
				}
				else if (prayerLevel >= 77)
				{
					return Prayer.AUGURY;
				}
			default:
				return Prayer.PROTECT_ITEM;
		}
	}

	private static String targetStringBuilder(PlayerContainer player)
	{
		if (player.getPlayer().getInteracting() != null)
		{
			Actor actor = player.getPlayer().getInteracting();
			if (actor instanceof Player)
			{
				return "(Player) " + actor.getName();
			}
			else if (actor instanceof NPC)
			{
				return "(NPC) " + actor.getName();
			}
		}
		return "No Target Detected";
	}

	static void scoutPlayer(PlayerContainer player, HttpUrl url, DiscordClient discordClient, ItemManager itemManager, Client client, int minimumValue, boolean outputItems)
	{
		if (player.isScouted())
		{
			return;
		}

		List<FieldEmbed> fieldList = new ArrayList<>();
		//green
		String color = "8388352";

		if (player.getRisk() < 1000000 && player.getRisk() > 150000)
		{
			//blue
			color = "32767";
		}
		else if (player.getRisk() > 1000000)
		{
			//orange
			color = "16744448";
		}

		ThumbnailEmbed image = ThumbnailEmbed.builder()
			.url("https://oldschool.runescape.wiki/images/a/a1/Skull_(status)_icon.png")
			.height(50)
			.width(50)
			.build();

		if (player.getPlayer().getSkullIcon() == null)
		{
			image = ThumbnailEmbed.builder()
				.url(ICONBASEURL + player.getWeapon() + ".png")
				.height(100)
				.width(100)
				.build();
		}

		fieldList.add(FieldEmbed.builder()
			.name("Risk")
			.value(StackFormatter.quantityToRSDecimalStack(player.getRisk()))
			.inline(true)
			.build());

		fieldList.add(FieldEmbed.builder()
			.name("World")
			.value(Integer.toString(client.getWorld()))
			.inline(true)
			.build());

		fieldList.add(FieldEmbed.builder()
			.name("Combat Level")
			.value(Integer.toString(player.getPlayer().getCombatLevel()))
			.inline(true)
			.build());

		fieldList.add(FieldEmbed.builder()
			.name("Wildy Level")
			.value(Integer.toString(player.getWildyLevel()))
			.inline(true)
			.build());

		fieldList.add(FieldEmbed.builder()
			.name("Location")
			.value(player.getLocation())
			.inline(true)
			.build());

		fieldList.add(FieldEmbed.builder()
			.name("Target")
			.value(player.getTargetString())
			.inline(true)
			.build());

		if (outputItems)
		{
			fieldList.add(FieldEmbed.builder()
				.name("Risked Items Sorted by Value")
				.value("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
				.build());

			final int[] items = {0};

			player.getRiskedGear().forEach((gear, value) ->
			{
				if (value <= 0 || value <= minimumValue)
				{
					items[0]++;
					return;
				}

				ItemStats item = itemManager.getItemStats(gear, false);

				if (item == null)
				{
					log.error("Item is Null: {}", gear);
					return;
				}

				fieldList.add(FieldEmbed.builder()
					.name(item.getName())
					.value("Value: " + StackFormatter.quantityToRSDecimalStack(value))
					.inline(true)
					.build());
			});

			if (items[0] > 0)
			{
				fieldList.add(FieldEmbed.builder()
					.name("Items below value: " + minimumValue)
					.value(Integer.toString(items[0]))
					.inline(true)
					.build());
			}
		}

		message(player.getPlayer().getName(), " ", ICONBASEURL + Objects.requireNonNull(getEntry(player.getGear())).getKey() + ".png", image, fieldList, url, discordClient, color);
		player.setScouted(true);
		fieldList.clear();
	}

	private static void message(String name, String description, String iconUrl, ThumbnailEmbed thumbnail, List<FieldEmbed> fields, HttpUrl url, DiscordClient discordClient, String color)
	{
		log.debug("Message Contents: {}, {}, {}, {}, {}", name, description, thumbnail, Arrays.toString(fields.toArray()), url);
		log.debug("Fields: {}", fields);

		if (name.isEmpty() || fields.isEmpty())
		{
			log.error("Discord message will fail with a missing name/description/field");
			return;
		}

		final Date currentTime = new Date(System.currentTimeMillis());

		DiscordEmbed discordEmbed = DiscordEmbed.builder()
			.author(AuthorEmbed.builder()
				.icon_url(iconUrl) // Icon of npc / player
				.name(name)
				.build())
			.thumbnail(thumbnail)
			.description(description)
			.fields(fields)
			.footer(FooterEmbed.builder()
				.icon_url("https://raw.githubusercontent.com/runelite/runelite/master/runelite-client/src/main/resources/net/runelite/client/plugins/hiscore/ultimate_ironman.png")
				.text("Gabon Scouter | Time: " + SDF.format(currentTime))
				.build())
			.color(color)
			.build();

		DiscordMessage discordMessage = new DiscordMessage("Gabon Scouter", "", "https://i.imgur.com/2A6dr7q.png");
		discordMessage.getEmbeds().add(discordEmbed);
		discordClient.message(url, discordMessage);
		fields.clear();
	}

	private static String location(PlayerContainer player, Map<WorldArea, String> map)
	{
		final WorldPoint wl = player.getPlayer().getWorldLocation();
		int dist = 10000;
		String s = "";
		WorldArea closestArea = null;
		for (Map.Entry<WorldArea, String> entry : map.entrySet())
		{
			WorldArea worldArea = entry.getKey();

			if (worldArea.toWorldPointList().contains(wl))
			{
				s = entry.getValue();
				return s;
			}
			int distTo = worldArea.distanceTo(wl);
			if (distTo < dist)
			{
				dist = distTo;
				closestArea = worldArea;
			}
		}
		if (wl.getY() > (Objects.requireNonNull(closestArea).toWorldPoint().getY() + closestArea.getHeight()))
		{
			s = s + "N";
		}
		if (wl.getY() < closestArea.toWorldPoint().getY())
		{
			s = s + "S";
		}
		if (wl.getX() < closestArea.toWorldPoint().getX())
		{
			s = s + "W";
		}
		if (wl.getX() > (closestArea.toWorldPoint().getX() + closestArea.getWidth()))
		{
			s = s + "E";
		}
		s = s + " of ";
		s = s + map.get(closestArea);
		if (s.startsWith(" of "))
		{
			s = s.substring(3);
		}
		return s;
	}
}
