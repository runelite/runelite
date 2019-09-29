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
package net.runelite.client.plugins.dynamicmaxhit;

import com.google.common.collect.ImmutableList;
import com.google.inject.Provides;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemDefinition;
import net.runelite.api.ItemID;
import net.runelite.api.Player;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.PlayerDespawned;
import net.runelite.api.events.PlayerMenuOptionClicked;
import net.runelite.api.events.PlayerSpawned;
import net.runelite.api.events.SpotAnimationChanged;
import net.runelite.api.kit.KitType;
import net.runelite.api.util.Text;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import static net.runelite.client.plugins.dynamicmaxhit.Utils.getTrueHp;
import static net.runelite.client.plugins.dynamicmaxhit.Utils.predictOffensivePrayer;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.item.ItemEquipmentStats;
import net.runelite.http.api.item.ItemStats;

@PluginDescriptor(
	name = "Dynamic Max Hit",
	description = "Dynamic Max Hit Calculations",
	tags = {"broken", "op", "shit"},
	type = PluginType.PVP,
	enabledByDefault = false
)
@Slf4j
public class DynamicMaxHit extends Plugin
{
	private static final String CALC = "Max Hit";
	private static final double SPEC_PER_TICK = 0.2;
	private static final HiscoreClient HISCORE_CLIENT = new HiscoreClient();
	private static final List<Integer> NORMAL_VOID = ImmutableList.of(ItemID.VOID_KNIGHT_TOP, ItemID.VOID_KNIGHT_ROBE, ItemID.VOID_KNIGHT_GLOVES);
	private static final List<Integer> ELITE_VOID = ImmutableList.of(ItemID.ELITE_VOID_TOP, ItemID.ELITE_VOID_ROBE, ItemID.VOID_KNIGHT_GLOVES);
	private static final List<Integer> DHAROK = ImmutableList.of(
		ItemID.DHAROKS_GREATAXE, ItemID.DHAROKS_GREATAXE_25, ItemID.DHAROKS_GREATAXE_50, ItemID.DHAROKS_GREATAXE_75, ItemID.DHAROKS_GREATAXE_100,
		ItemID.DHAROKS_HELM, ItemID.DHAROKS_HELM_25, ItemID.DHAROKS_HELM_50, ItemID.DHAROKS_HELM_75, ItemID.DHAROKS_HELM_100,
		ItemID.DHAROKS_PLATEBODY, ItemID.DHAROKS_PLATEBODY_25, ItemID.DHAROKS_PLATEBODY_50, ItemID.DHAROKS_PLATEBODY_75, ItemID.DHAROKS_PLATEBODY_100,
		ItemID.DHAROKS_PLATELEGS, ItemID.DHAROKS_PLATELEGS_25, ItemID.DHAROKS_PLATELEGS_50, ItemID.DHAROKS_PLATELEGS_75, ItemID.DHAROKS_PLATELEGS_100
	);
	private static final String ANTIFIRE_DRINK_MESSAGE = "You drink some of your antifire potion.";
	private static final String ANTIFIRE_EXPIRED_MESSAGE = "<col=7f007f>Your antifire potion has expired.</col>";
	private static final String EXTENDED_ANTIFIRE_DRINK_MESSAGE = "You drink some of your extended antifire potion.";
	private static final String EXTENDED_SUPER_ANTIFIRE_DRINK_MESSAGE = "You drink some of your extended super antifire potion.";
	private static final String SUPER_ANTIFIRE_DRINK_MESSAGE = "You drink some of your super antifire potion";
	private static final String SUPER_ANTIFIRE_EXPIRED_MESSAGE = "<col=7f007f>Your super antifire potion has expired.</col>";
	@Inject
	private Client client;
	@Inject
	private EventBus eventBus;
	@Inject
	private ItemManager itemManager;
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private AttackerOverlay attackerOverlay;
	@Inject
	private MenuManager menuManager;
	@Inject
	private DynamicMaxHitConfig config;
	@Getter(AccessLevel.PACKAGE)
	private Map<String, Victim> victims = new HashMap<>();
	private boolean antiFireActive;
	private ExecutorService httpExecutor = Executors.newFixedThreadPool(100);
	private Map<String, HiscoreResult> resultCache = new HashMap<>();
	private boolean enablePrayer;
	private boolean enablePotions;

	@Provides
	DynamicMaxHitConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DynamicMaxHitConfig.class);
	}

	@Override
	protected void startUp()
	{
		addSubscriptions();
		victims.clear();
		overlayManager.add(attackerOverlay);
		menuManager.addPlayerMenuItem(CALC);
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			client.getPlayers().forEach(player ->
			{
				if (client.getLocalPlayer() == player)
				{
					return;
				}
				final Victim victim = new Victim(player);
				victims.put(victim.getName(), victim);
			});
		}
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);
		overlayManager.remove(attackerOverlay);
		menuManager.removePlayerMenuItem(CALC);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(PlayerSpawned.class, this, this::onPlayerSpawned);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(PlayerDespawned.class, this, this::onPlayerDespawned);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(AnimationChanged.class, this, this::onAnimationChanged);
		eventBus.subscribe(SpotAnimationChanged.class, this, this::onSpotAnimationChanged);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
		eventBus.subscribe(PlayerMenuOptionClicked.class, this, this::onPlayerMenuOptionClicked);
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("dynamicMaxHit"))
		{
			return;
		}

		this.enablePotions = config.enablePotions();
		this.enablePrayer = config.enablePrayer();
	}

	private void onPlayerMenuOptionClicked(PlayerMenuOptionClicked event)
	{
		if (event.getMenuOption().equals(CALC))
		{
			final Victim victim = victims.getOrDefault(Text.standardize(event.getMenuTarget()), null);
			if (victim == null)
			{
				return;
			}
			updateStats(victim);
			victim.setManual(true);
		}
	}

	private void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SPAM && event.getType() != ChatMessageType.GAMEMESSAGE)
		{
			return;
		}

		final String msg = event.getMessage();

		switch (msg)
		{
			case ANTIFIRE_DRINK_MESSAGE:
			case EXTENDED_ANTIFIRE_DRINK_MESSAGE:
			case SUPER_ANTIFIRE_DRINK_MESSAGE:
			case EXTENDED_SUPER_ANTIFIRE_DRINK_MESSAGE:
				antiFireActive = true;
				break;
			case ANTIFIRE_EXPIRED_MESSAGE:
			case SUPER_ANTIFIRE_EXPIRED_MESSAGE:
				antiFireActive = false;
				break;
		}
	}

	private void onSpotAnimationChanged(SpotAnimationChanged event)
	{
		final Actor actor = event.getActor();

		if (victims.isEmpty())
		{
			return;
		}

		if (actor.getSpotAnimation() == 111)
		{
			final Victim victim = victims.getOrDefault(actor.getName(), null);

			if (victim == null)
			{
				return;
			}

			victim.setCharged(true);
		}
	}

	private void onAnimationChanged(AnimationChanged event)
	{
		final Actor actor = event.getActor();

		if (actor.getInteracting() != client.getLocalPlayer() || !(actor instanceof Player) || actor.getAnimation() == -1)
		{
			return;
		}

		final Victim victim = victims.get(actor.getName());

		if (victim == null)
		{
			return;
		}

		if (victim.getPlayer().getInteracting() != null && victim.getPlayer().getInteracting() == client.getLocalPlayer())
		{
			if (victim.getSkills() == null)
			{
				updateStats(victim);
			}

			victim.setAttacking(true);
			victim.setTimer(16);
		}
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			return;
		}

		victims.clear();
	}

	private void onPlayerSpawned(PlayerSpawned event)
	{
		final Player player = event.getPlayer();

		if (client.getLocalPlayer() == player)
		{
			return;
		}

		final Victim victim = new Victim(player);
		victims.put(victim.getName(), victim);
	}

	private void onPlayerDespawned(PlayerDespawned event)
	{
		final Player player = event.getPlayer();
		victims.remove(Text.standardize(player.getName()));
	}

	private void onGameTick(GameTick event)
	{
		if (victims.isEmpty() || client.getLocalPlayer() == null)
		{
			return;
		}

		victims.values().forEach((v) ->
		{
			if (!v.isAttacking() && !v.isManual())
			{
				return;
			}

			update(v);
		});
	}

	private void update(Victim player)
	{
		reset(player);

		if (player.getSkills() == null)
		{
			return;
		}

		updateSpec(player);
		updatePlayerGear(player);
		updateTimers(player);
		updateAttackStyle(player);
		updateWeakness(player);
		updatePredictedMagic(player);
		player.setPredictedPrayer(predictOffensivePrayer(player.getPrayerLevel(), player.getAttackStyle()));
		player.setPotionBoost(updatePotFormula(player));
		updateMaxHitMelee(player);
		updateMaxHitMagic(player);
		updateSpecMaxHit(player);
		if (client.isPrayerActive(player.getAttackStyle().getPrayer()))
		{
			player.setMaxHit(Math.floor(player.getMaxHit() * 0.6));
			player.setSpecMaxHit(Math.floor(player.getSpecMaxHit() * 0.6));
		}
	}

	private void reset(Victim player)
	{
		player.reset();
	}

	private void updateSpec(Victim player)
	{
		if (player.getSpec() < 100)
		{
			player.setSpec(player.getSpec() + SPEC_PER_TICK);
		}
		else if (player.getSpec() > 100)
		{
			player.setSpec(100);
		}
	}

	private void updateStats(Victim player)
	{
		if (resultCache.containsKey(player.getName()))
		{
			player.setSkills(resultCache.get(player.getName()));
			player.setPrayerLevel(player.getSkills().getPrayer().getLevel());
			player.setHpLevel(player.getSkills().getHitpoints().getLevel());
			return;
		}

		httpExecutor.submit(() ->
		{
			HiscoreResult result;
			do
			{
				try
				{
					result = HISCORE_CLIENT.lookup(player.getName());
				}
				catch (IOException ex)
				{
					result = null;
					try
					{
						Thread.sleep(1000);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
			while (result == null);

			resultCache.put(player.getName(), result);
			player.setSkills(result);
			player.setPrayerLevel(player.getSkills().getPrayer().getLevel());
			player.setHpLevel(player.getSkills().getHitpoints().getLevel());
		});
	}

	private void updateTimers(Victim player)
	{
		if (player.getTimer() > 0)
		{
			player.setTimer(player.getTimer() - 1);
		}
		else
		{
			player.setAttacking(false);
		}
	}

	private void updatePlayerGear(Victim player)
	{
		if (player.getPlayer().getPlayerAppearance() == null)
		{
			return;
		}

		final List<Integer> items = new ArrayList<>();

		for (KitType kitType : KitType.values())
		{
			if (kitType == KitType.RING || kitType == KitType.AMMUNITION)
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

				switch (id)
				{
					case ItemID.HEAVY_BALLISTA:
					case ItemID.HEAVY_BALLISTA_23630:
					case ItemID.LIGHT_BALLISTA:
						player.setRangeStr(player.getRangeStr() + 150);
						break;
					case ItemID.MAPLE_LONGBOW:
					case ItemID.MAPLE_SHORTBOW:
						player.setRangeStr(player.getRangeStr() + 31);
						break;
					case ItemID.MAGIC_SHORTBOW:
					case ItemID.MAGIC_SHORTBOW_20558:
					case ItemID.MAGIC_SHORTBOW_I:
						player.setRangeStr(player.getRangeStr() + 55);
						break;
					case ItemID.DARK_BOW:
					case ItemID.DARK_BOW_12765:
					case ItemID.DARK_BOW_12766:
					case ItemID.DARK_BOW_12767:
					case ItemID.DARK_BOW_12768:
					case ItemID.DARK_BOW_20408:
						player.setRangeStr(player.getRangeStr() + 60);
						break;
					case ItemID.RUNE_CROSSBOW:
					case ItemID.RUNE_CROSSBOW_23601:
						player.setRangeStr(player.getRangeStr() + 117);
						break;
					case ItemID.DRAGON_CROSSBOW:
					case ItemID.ARMADYL_CROSSBOW:
					case ItemID.ARMADYL_CROSSBOW_23611:
						player.setRangeStr(player.getRangeStr() + 122);
						break;
				}
			}

			if (kitType.equals(KitType.SHIELD))
			{
				player.setShield(id);
			}

			final ItemStats item = itemManager.getItemStats(id, false);

			if (item == null)
			{
				log.debug("Item is null: {}", id);
				continue;
			}

			ItemEquipmentStats stats = item.getEquipment();

			if (stats == null)
			{
				log.debug("Stats are null: {}", item);
				continue;
			}

			items.add(id);

			player.setSpeed(player.getSpeed() + stats.getAspeed());
			player.setMeleeAtkCrush(player.getMeleeAtkCrush() + stats.getAcrush());
			player.setMeleeAtkStab(player.getMeleeAtkStab() + stats.getAstab());
			player.setMeleeAtkSlash(player.getMeleeAtkSlash() + stats.getAslash());
			player.setMeleeAttack(player.getMeleeAttack() + ((stats.getAcrush() + stats.getAslash() + stats.getAstab()) / 3));
			player.setMeleeDefCrush(player.getMeleeDefCrush() + stats.getDcrush());
			player.setMeleeDefStab(player.getMeleeDefStab() + stats.getDstab());
			player.setMeleeDefSlash(player.getMeleeDefSlash() + stats.getDslash());
			player.setMeleeDefence(player.getMeleeDefence() + ((stats.getDcrush() + stats.getDslash() + stats.getDstab()) / 3));
			player.setMagicAttack(player.getMagicAttack() + stats.getAmagic());
			player.setRangeAttack(player.getRangeAttack() + stats.getArange());
			player.setMagicDefence(player.getMagicDefence() + stats.getDmagic());
			player.setRangeDefence(player.getRangeDefence() + stats.getDrange());
			player.setRangeStr(player.getRangeStr() + stats.getRstr());
			player.setMeleeStr(player.getMeleeStr() + stats.getStr());
			player.setMagicStr(player.getMagicStr() + stats.getMdmg());
		}
		player.setGear(items);
		updateMeleeStyle(player);
	}

	private void updateMeleeStyle(Victim player)
	{
		if (player.getMeleeAtkCrush() >= player.getMeleeAtkSlash() && player.getMeleeAtkCrush() >= player.getMeleeAtkStab())
		{
			player.setMeleeStyle(Victim.MeleeStyle.CRUSH);
		}
		else if (player.getMeleeAtkSlash() >= player.getMeleeAtkCrush() && player.getMeleeAtkSlash() >= player.getMeleeAtkStab())
		{
			player.setMeleeStyle(Victim.MeleeStyle.SLASH);
		}
		else if (player.getMeleeAtkStab() >= player.getMeleeAtkSlash() && player.getMeleeAtkStab() >= player.getMeleeAtkCrush())
		{
			player.setMeleeStyle(Victim.MeleeStyle.STAB);
		}
	}

	private void updateAttackStyle(Victim player)
	{
		boolean staff = false;

		for (int id : player.getGear())
		{
			ItemDefinition def = itemManager.getItemDefinition(id);
			if (def.getName().toLowerCase().contains("staff"))
			{
				player.setAttackStyle(AttackStyle.MAGE);
				staff = true;
				break;
			}
		}

		if (staff)
		{
			return;
		}

		if (player.getMagicStr() >= player.getRangeStr() && player.getMagicStr() >= player.getMeleeStr())
		{
			player.setAttackStyle(AttackStyle.MAGE);
		}
		else if (player.getRangeStr() >= player.getMagicStr() && player.getRangeStr() >= player.getMeleeStr())
		{
			player.setAttackStyle(AttackStyle.RANGE);
		}
		else if (player.getMeleeStr() >= player.getMagicStr() && player.getMeleeStr() >= player.getRangeStr())
		{
			player.setAttackStyle(AttackStyle.MELEE);
		}
	}

	private void updateWeakness(Victim player)
	{
		if (player.getMagicDefence() <= player.getRangeDefence() && player.getMagicDefence() <= player.getMeleeDefence())
		{
			player.setWeakness(AttackStyle.MAGE);
		}
		else if (player.getRangeDefence() <= player.getMagicDefence() && player.getRangeDefence() <= player.getMeleeDefence())
		{
			player.setWeakness(AttackStyle.RANGE);
		}
		else if (player.getMeleeDefence() <= player.getRangeDefence() && player.getMeleeDefence() <= player.getMagicDefence())
		{
			player.setWeakness(AttackStyle.MELEE);
		}
	}

	private void updatePredictedMagic(Victim player)
	{
		final int magicLevel = player.getSkills() != null ? player.getSkills().getMagic().getLevel() : 0;

		if (magicLevel >= 70 && magicLevel <= 81)
		{
			player.setPredictedSpell(Spells.ICE_BURST);
		}
		else if (magicLevel >= 82 && magicLevel <= 93)
		{
			player.setPredictedSpell(Spells.ICE_BLITZ);
		}
		else if (magicLevel >= 94)
		{
			player.setPredictedSpell(Spells.ICE_BARRAGE);
		}

		if (player.getShield() != ItemID.TOME_OF_FIRE)
		{
			return;
		}

		if (magicLevel >= 59 && magicLevel <= 74)
		{
			player.setPredictedSpell(Spells.FIRE_BLAST);
		}
		else if (magicLevel >= 75 && magicLevel <= 94)
		{
			player.setPredictedSpell(Spells.FIRE_WAVE);
		}
		else if (magicLevel >= 95)
		{
			player.setPredictedSpell(Spells.FIRE_SURGE);
		}

		if (!player.isCharged())
		{
			return;
		}

		if (magicLevel >= 60)
		{
			player.setPredictedSpell(Spells.FLAMES_ZAMORAK);
		}
	}

	private int updatePotFormula(Victim player)
	{
		final Potions pot;
		switch (player.getAttackStyle())
		{
			case RANGE:
				pot = Potions.RANGING_POTION;
				return (int) Math.floor(pot.getA() + pot.getB() * player.getSkills().getSkill(pot.getSkill()).getLevel());
			case MELEE:
				pot = Potions.SUPER_COMBAT;
				return (int) Math.floor(pot.getA() + pot.getB() * player.getSkills().getSkill(pot.getSkill()).getLevel());
			default:
				return 0;
		}
	}

	private void updateMaxHitMelee(Victim player)
	{
		if (player.getPredictedPrayer() == null)
		{
			return;
		}

		double prayerBonus = 1;

		if (this.enablePrayer)
		{
			switch (player.getPredictedPrayer())
			{
				case SHARP_EYE:
				case BURST_OF_STRENGTH:
					prayerBonus = 1.05;
					break;
				case HAWK_EYE:
				case SUPERHUMAN_STRENGTH:
					prayerBonus = 1.1;
					break;
				case EAGLE_EYE:
				case ULTIMATE_STRENGTH:
					prayerBonus = 1.15;
					break;
				case CHIVALRY:
					prayerBonus = 1.18;
					break;
				case PIETY:
				case RIGOUR:
					prayerBonus = 1.23;
					break;
			}
		}

		double skillPower = 0;
		double estimatedStyle = 8;

		switch (player.getAttackStyle())
		{
			case RANGE:
				skillPower = player.getSkills() != null ? player.getSkills().getRanged().getLevel() : 0;
				break;
			case MELEE:
				skillPower = player.getSkills() != null ? player.getSkills().getStrength().getLevel() : 0;
				estimatedStyle = 11;
				break;
		}

		if (this.enablePotions)
		{
			skillPower += player.getPotionBoost();
		}

		double estimatedLevel = skillPower * prayerBonus;
		estimatedLevel = Math.floor(estimatedLevel);
		estimatedLevel += estimatedStyle;

		if (player.getGear().containsAll(NORMAL_VOID))
		{
			estimatedLevel *= 1.10;
		}
		else if (player.getGear().containsAll(ELITE_VOID))
		{
			estimatedLevel *= 1.10;
			if (player.getAttackStyle() == AttackStyle.RANGE)
			{
				estimatedLevel *= 1.125;
			}
		}

		double maxHit = 0;

		switch (player.getAttackStyle())
		{
			case MELEE:
				maxHit = 0.5 + estimatedLevel * (player.getMeleeStr() + 64) / 640;
				break;
			case RANGE:
				maxHit = 0.5 + estimatedLevel * (player.getRangeStr() + 64) / 640;
				break;
		}

		maxHit = Math.floor(maxHit);

		int dharokPieces = 0;
		dharokPieces += player.getGear().stream().filter(DHAROK::contains).count();

		if (dharokPieces == 4)
		{
			final double var1 = player.getHpLevel();
			final double var2 = getTrueHp(player.getPlayer(), player.getHpLevel());
			final double var3 = (var1 - var2) / 100;
			final double var4 = (var1 / 100);
			maxHit *= 1 + (var3 * var4);
		}
		if ((player.getGear().contains(ItemID.TZHAARKETOM) || player.getGear().contains(ItemID.TZHAARKETOM_T))
			&& (player.getGear().contains(ItemID.BERSERKER_NECKLACE) || player.getGear().contains(ItemID.BERSERKER_NECKLACE_OR)))
		{
			maxHit *= 1.2;
		}

		maxHit = Math.floor(maxHit);

		player.setMaxHit(maxHit);
	}

	private void updateSpecMaxHit(Victim player)
	{
		double maxHit = player.getMaxHit();

		switch (player.getWeapon())
		{
			case ItemID.ARMADYL_GODSWORD:
			case ItemID.ARMADYL_GODSWORD_20593:
			case ItemID.ARMADYL_GODSWORD_22665:
			case ItemID.ARMADYL_GODSWORD_OR:
				maxHit *= 1.10;
				maxHit = Math.floor(maxHit);
				maxHit *= 1.25;
				break;
			case ItemID.BANDOS_GODSWORD:
			case ItemID.BANDOS_GODSWORD_20782:
			case ItemID.BANDOS_GODSWORD_21060:
			case ItemID.BANDOS_GODSWORD_OR:
				maxHit *= 1.10;
				maxHit = Math.floor(maxHit);
				maxHit *= 1.10;
				break;
			case ItemID.BARRELCHEST_ANCHOR:
			case ItemID.BARRELCHEST_ANCHOR_10888:
			case ItemID.DRAGON_HALBERD:
			case ItemID.SARADOMIN_GODSWORD:
			case ItemID.SARADOMIN_GODSWORD_OR:
			case ItemID.ZAMORAK_GODSWORD:
			case ItemID.ZAMORAK_GODSWORD_OR:
			case ItemID.SARADOMIN_SWORD:
				maxHit *= 1.10;
				break;
			case ItemID.DRAGON_CROSSBOW:
			case ItemID.ARMADYL_CROSSBOW:
			case ItemID.ARMADYL_CROSSBOW_23611:
			case ItemID.RUNE_CLAWS:
				maxHit *= 1.15;
				break;
			case ItemID.DRAGON_LONGSWORD:
			case ItemID.DRAGON_SWORD:
			case ItemID.DRAGON_SWORD_21206:
			case ItemID.LIGHT_BALLISTA:
			case ItemID.HEAVY_BALLISTA:
			case ItemID.HEAVY_BALLISTA_23630:
			case ItemID.SARADOMINS_BLESSED_SWORD:
				maxHit *= 1.25;
				break;
			case ItemID.DARK_BOW:
			case ItemID.DARK_BOW_12765:
			case ItemID.DARK_BOW_12766:
			case ItemID.DARK_BOW_12767:
			case ItemID.DARK_BOW_12768:
			case ItemID.DARK_BOW_20408:
				maxHit *= 1.30;
				break;
			case ItemID.TOXIC_BLOWPIPE:
			case ItemID.DRAGON_MACE:
				maxHit *= 1.50;
			case ItemID.DRAGON_KNIFE:
			case ItemID.DRAGON_KNIFE_22812:
			case ItemID.DRAGON_KNIFE_22814:
			case ItemID.DRAGON_KNIFEP_22808:
			case ItemID.DRAGON_KNIFEP_22810:
			case ItemID.GRANITE_MAUL:
			case ItemID.GRANITE_MAUL_12848:
			case ItemID.GRANITE_MAUL_20557:
			case ItemID.GRANITE_MAUL_24225:
			case ItemID.GRANITE_MAUL_24227:
			case ItemID.DRAGON_CLAWS:
			case ItemID.DRAGON_CLAWS_20784:
			case ItemID.DRAGON_DAGGER:
			case ItemID.DRAGON_DAGGER_20407:
			case ItemID.DRAGON_DAGGERP:
			case ItemID.DRAGON_DAGGERP_5680:
			case ItemID.DRAGON_DAGGERP_5698:
				maxHit *= 2.0;
				break;
		}

		maxHit = Math.floor(maxHit);

		switch (player.getWeapon())
		{
			case ItemID.RUNE_CROSSBOW:
			case ItemID.RUNE_CROSSBOW_23601:
				if (!antiFireActive)
				{
					double rangeLevel = player.getSkills() != null ? player.getSkills().getRanged().getLevel() : 0;
					maxHit += rangeLevel * 0.2;
				}
				break;
		}

		maxHit = Math.floor(maxHit);

		player.setSpecMaxHit(maxHit);
	}

	private void updateMaxHitMagic(Victim player)
	{
		if (player.getAttackStyle() != AttackStyle.MAGE || player.getGear().isEmpty())
		{
			return;
		}

		double maxHit = player.getPredictedSpell().getMaxHit();

		maxHit *= (1 + (float) player.getMagicStr() / 100);
		maxHit = Math.floor(maxHit);

		if (player.getShield() == ItemID.TOME_OF_FIRE)
		{
			maxHit *= 1.5;
		}

		maxHit = Math.floor(maxHit);

		player.setMaxHit(maxHit);
	}
}
