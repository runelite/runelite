package net.runelite.client.game;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.ItemDefinition;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.PlayerAppearanceChanged;
import net.runelite.api.events.PlayerDespawned;
import net.runelite.api.events.PlayerSpawned;
import net.runelite.api.kit.KitType;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.AttackStyleChanged;
import net.runelite.client.util.PvPUtil;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.item.ItemEquipmentStats;
import net.runelite.http.api.item.ItemStats;

@Singleton
@Slf4j
@SuppressWarnings("unused")
public class PlayerManager
{
	private static final HiscoreClient HISCORE_CLIENT = new HiscoreClient();
	private final Client client;
	private final ItemManager itemManager;
	private final EventBus eventBus;
	private final Map<String, PlayerContainer> playerMap = new ConcurrentHashMap<>();
	private final Map<String, HiscoreResult> resultCache = new ConcurrentHashMap<>();
	private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

	@Inject
	PlayerManager(
		final Client client,
		final EventBus eventBus,
		final ItemManager itemManager
	)
	{
		this.client = client;
		this.itemManager = itemManager;
		this.eventBus = eventBus;
		eventBus.subscribe(PlayerDespawned.class, this, this::onPlayerDespawned);
		eventBus.subscribe(PlayerSpawned.class, this, this::onPlayerSpawned);
		eventBus.subscribe(AnimationChanged.class, this, this::onAnimationChanged);
		eventBus.subscribe(PlayerAppearanceChanged.class, this, this::onAppearenceChanged);
	}

	/**
	 * @return Collection of {@link PlayerContainer} that are attacking you, this can be empty.
	 */
	public Set<PlayerContainer> getAllAttackers()
	{
		final Set<PlayerContainer> set = new HashSet<>();
		for (PlayerContainer p : playerMap.values())
		{
			if (p.isAttacking())
			{
				set.add(p);
			}
		}
		return set;
	}

	/**
	 * @return Collection of {@link PlayerContainer}, this can be empty.
	 */
	public Collection<PlayerContainer> getPlayerContainers()
	{
		return playerMap.values();
	}

	/**
	 * @param name Players name.
	 * @return {@link PlayerContainer} if provided with proper name, else null.
	 */
	@Nullable
	public PlayerContainer getPlayer(String name)
	{
		return playerMap.get(name);
	}

	/**
	 * @param player Player object.
	 * @return {@link PlayerContainer} if provided with proper name, else null.
	 */
	@Nullable
	public PlayerContainer getPlayer(Player player)
	{
		if (player == null)
		{
			return null;
		}

		return playerMap.get(player.getName());
	}

	/**
	 * This will keep submitting an http request until it successfully updates.
	 *
	 * @param name The player name you wish to update.
	 */
	public void updateStats(String name)
	{
		final PlayerContainer p = playerMap.get(name);

		if (p == null)
		{
			return;
		}

		updateStats(p.getPlayer());
	}

	/**
	 * This will keep submitting an http request until it successfully updates.
	 *
	 * @param requestedPlayer The player object you wish to update.
	 */
	public void updateStats(Player requestedPlayer)
	{
		if (requestedPlayer == null)
		{
			return;
		}

		final PlayerContainer player = playerMap.get(requestedPlayer.getName());

		if (player == null)
		{
			return;
		}

		if (resultCache.containsKey(player.getName()))
		{
			player.setSkills(resultCache.get(player.getName()));
			player.setPrayerLevel(player.getSkills().getPrayer().getLevel());
			player.setHpLevel(player.getSkills().getHitpoints().getLevel());
			return;
		}

		executorService.submit(() ->
		{
			player.setHttpRetry(true);
			int timeout = 0;
			HiscoreResult result;
			do
			{
				try
				{
					result = HISCORE_CLIENT.lookup(player.getName());
				}
				catch (IOException ex)
				{
					if (timeout == 10)
					{
						log.error("HiScore Lookup timed out on: {}", player.getName());
						return;
					}
					result = null;
					timeout++;
					try
					{
						Thread.sleep(1000);
					}
					catch (InterruptedException ignored)
					{
					}
				}
			}
			while (result == null);

			resultCache.put(player.getName(), result);
			player.setSkills(result);
			player.setPrayerLevel(player.getSkills().getPrayer().getLevel());
			player.setHpLevel(player.getSkills().getHitpoints().getLevel());
			player.setHttpRetry(false);
		});
	}

	private void onAppearenceChanged(PlayerAppearanceChanged event)
	{
		final PlayerContainer player = playerMap.get(event.getPlayer().getName());

		if (player == null)
		{
			return;
		}

		update(player);
		player.reset();
		player.setFriend(client.isFriended(player.getName(), false));
		player.setClan(client.isClanMember(player.getName()));
	}

	private void onPlayerDespawned(PlayerDespawned event)
	{
		final Player player = event.getPlayer();
		playerMap.remove(player.getName());
	}

	private void onPlayerSpawned(PlayerSpawned event)
	{
		final Player player = event.getPlayer();
		playerMap.put(player.getName(), new PlayerContainer(player));
	}

	private void onAnimationChanged(AnimationChanged event)
	{
		final Actor actor = event.getActor();

		if (actor.getInteracting() != client.getLocalPlayer() || !(actor instanceof Player) || actor.getAnimation() == -1)
		{
			return;
		}

		final PlayerContainer player = playerMap.getOrDefault(actor.getName(), null);

		if (player == null)
		{
			return;
		}

		if (player.getPlayer().getInteracting() != null &&
			player.getPlayer().getInteracting() == client.getLocalPlayer())
		{
			if (player.getSkills() == null)
			{
				updateStats(player.getPlayer());
			}

			player.setAttacking(true);
			player.setTimer(8);
		}
	}

	private void update(PlayerContainer player)
	{
		player.setRisk(0);
		updatePlayerGear(player);
		updateAttackStyle(player);
		updateWeakness(player);
		player.setLocation(WorldLocation.location(player.getPlayer().getWorldLocation()));
		player.setWildyLevel(PvPUtil.getWildernessLevelFrom(player.getPlayer().getWorldLocation()));
		player.setTargetString(targetStringBuilder(player));
	}

	private void updatePlayerGear(PlayerContainer player)
	{
		final Map<Integer, Integer> prices = new HashMap<>();

		if (player.getPlayer().getPlayerAppearance() == null)
		{
			return;
		}

		int magicAttack = 0,
			magicDefence = 0,
			magicStr = 0,
			meleeAtkCrush = 0,
			meleeAtkStab = 0,
			meleeAtkSlash = 0,
			meleeDefCrush = 0,
			meleeDefStab = 0,
			meleeDefSlash = 0,
			meleeStr = 0,
			rangeAttack = 0,
			rangeDefence = 0,
			rangeStr = 0,
			speed = 0;

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

				switch (id)
				{
					case ItemID.HEAVY_BALLISTA:
					case ItemID.HEAVY_BALLISTA_23630:
					case ItemID.LIGHT_BALLISTA:
						rangeStr += 150;
						break;
					case ItemID.MAPLE_LONGBOW:
					case ItemID.MAPLE_SHORTBOW:
						rangeStr += 31;
						break;
					case ItemID.MAGIC_SHORTBOW:
					case ItemID.MAGIC_SHORTBOW_20558:
					case ItemID.MAGIC_SHORTBOW_I:
						rangeStr += +55;
						break;
					case ItemID.DARK_BOW:
					case ItemID.DARK_BOW_12765:
					case ItemID.DARK_BOW_12766:
					case ItemID.DARK_BOW_12767:
					case ItemID.DARK_BOW_12768:
					case ItemID.DARK_BOW_20408:
						rangeStr += +60;
						break;
					case ItemID.RUNE_CROSSBOW:
					case ItemID.RUNE_CROSSBOW_23601:
						rangeStr += +117;
						break;
					case ItemID.DRAGON_CROSSBOW:
					case ItemID.ARMADYL_CROSSBOW:
					case ItemID.ARMADYL_CROSSBOW_23611:
						rangeStr += +122;
						break;
				}
			}

			final ItemStats item = itemManager.getItemStats(id, false);
			final ItemDefinition itemDefinition = itemManager.getItemDefinition(id);

			if (item == null)
			{
				log.debug("Item is null: {}", id);
				continue;
			}

			final ItemEquipmentStats stats = item.getEquipment();

			speed += stats.getAspeed();
			meleeAtkCrush += stats.getAcrush();
			meleeAtkStab += stats.getAstab();
			meleeAtkSlash += stats.getAslash();
			meleeDefCrush += stats.getDcrush();
			meleeDefStab += stats.getDstab();
			meleeDefSlash += stats.getDslash();
			magicAttack += stats.getAmagic();
			rangeAttack += stats.getArange();
			magicDefence += stats.getDmagic();
			rangeDefence += stats.getDrange();
			rangeStr += stats.getRstr();
			meleeStr += stats.getStr();
			magicStr += stats.getMdmg();

			if (ItemReclaimCost.breaksOnDeath(id))
			{
				prices.put(id, itemManager.getRepairValue(id));
				log.debug("Item has a broken value: Id {}, Value {}", id, itemManager.getRepairValue(id));
				continue;
			}

			if (!itemDefinition.isTradeable() && !ItemMapping.isMapped(id))
			{
				prices.put(id, itemDefinition.getPrice());
			}
			else if (itemDefinition.isTradeable())
			{
				prices.put(id, itemManager.getItemPrice(id, false));
			}
		}

		player.setCombatStats(new CombatStats(
			magicAttack,
			magicDefence,
			magicStr,
			meleeAtkCrush,
			meleeAtkSlash,
			meleeAtkStab,
			(meleeAtkCrush + meleeAtkSlash + meleeAtkStab) / 3,
			meleeDefCrush,
			(meleeDefCrush + meleeDefSlash + meleeDefStab) / 3,
			meleeDefSlash,
			meleeDefStab,
			meleeStr,
			rangeAttack,
			rangeDefence,
			rangeStr,
			speed
		));
		updateGear(player, prices);
		updateMeleeStyle(player);
	}

	private void updateGear(PlayerContainer player, Map<Integer, Integer> prices)
	{
		player.setGear(prices.entrySet()
			.stream()
			.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new))
		);

		player.setRiskedGear(prices.entrySet()
			.stream()
			.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new))
		);

		if (player.getPlayer().getSkullIcon() == null)
		{
			removeEntries(player.getRiskedGear(), player.getPrayerLevel() <= 25 ? 3 : 4);
		}
		else
		{
			removeEntries(player.getRiskedGear(), player.getPrayerLevel() <= 25 ? 0 : 1);
		}

		player.getRiskedGear().values().forEach(price -> player.setRisk(player.getRisk() + price));
		prices.clear();
	}

	private void updateMeleeStyle(PlayerContainer player)
	{
		final CombatStats stats = player.getCombatStats();

		if (stats.getMeleeAtkCrush() >= stats.getMeleeAtkSlash() && stats.getMeleeAtkCrush() >= stats.getMeleeAtkStab())
		{
			player.setMeleeStyle(PlayerContainer.MeleeStyle.CRUSH);
		}
		else if (stats.getMeleeAtkSlash() >= stats.getMeleeAtkCrush() && stats.getMeleeAtkSlash() >= stats.getMeleeAtkStab())
		{
			player.setMeleeStyle(PlayerContainer.MeleeStyle.SLASH);
		}
		else
		{
			player.setMeleeStyle(PlayerContainer.MeleeStyle.STAB);
		}
	}

	private void updateAttackStyle(PlayerContainer player)
	{
		final AttackStyle oldStyle = player.getAttackStyle();
		boolean staff = false;

		for (int id : player.getGear().keySet())
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
			if (oldStyle != player.getAttackStyle())
			{
				eventBus.post(AttackStyleChanged.class, new AttackStyleChanged(
					player.getPlayer(), oldStyle, player.getAttackStyle())
				);
			}
			return;
		}

		final CombatStats stats = player.getCombatStats();

		if (stats.getMagicStr() >= stats.getRangeStr() && stats.getMagicStr() >= stats.getMeleeStr())
		{
			player.setAttackStyle(AttackStyle.MAGE);
		}
		else if (stats.getRangeStr() >= stats.getMagicStr() && stats.getRangeStr() >= stats.getMeleeStr())
		{
			player.setAttackStyle(AttackStyle.RANGE);
		}
		else
		{
			player.setAttackStyle(AttackStyle.MELEE);
		}

		if (oldStyle != player.getAttackStyle())
		{
			eventBus.post(AttackStyleChanged.class, new AttackStyleChanged(
				player.getPlayer(), oldStyle, player.getAttackStyle())
			);
		}
	}

	private void updateWeakness(PlayerContainer player)
	{
		final CombatStats stats = player.getCombatStats();

		if (stats.getMagicDefence() <= stats.getRangeDefence() && stats.getMagicDefence() <= stats.getMeleeDefence())
		{
			player.setWeakness(AttackStyle.MAGE);
		}
		else if (stats.getRangeDefence() <= stats.getMagicDefence() && stats.getRangeDefence() <= stats.getMeleeDefence())
		{
			player.setWeakness(AttackStyle.RANGE);
		}
		else
		{
			player.setWeakness(AttackStyle.MELEE);
		}
	}

	private static void removeEntries(LinkedHashMap<Integer, Integer> map, int quantity)
	{
		for (int i = 0; i < quantity; i++)
		{
			if (!map.entrySet().iterator().hasNext())
			{
				return;
			}
			map.entrySet().remove(map.entrySet().iterator().next());
		}
	}

	private String targetStringBuilder(PlayerContainer player)
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
}