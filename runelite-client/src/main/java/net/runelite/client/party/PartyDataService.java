/*
 * Copyright (c) 2026, Adam <Adam@sigterm.info>
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
package net.runelite.client.party;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;
import net.runelite.api.Client;
import net.runelite.api.EnumComposition;
import net.runelite.api.EnumID;
import net.runelite.api.GameState;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.Player;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.StatChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.party.messages.PartyData;
import net.runelite.client.party.messages.UserSync;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.task.Scheduler;
import net.runelite.client.util.Text;

@Singleton
public class PartyDataService
{
	private static final int DIRTY_INV = 0x1;
	private static final int DIRTY_WORN = 0x2;
	private static final int DIRTY_RUNEPOUCH = 0x04;
	private static final int DIRTY_QUIVER = 0x08;
	private static final int DIRTY_VENGEANCE = 0x10;

	private static class Subscription
	{
		Plugin p;
		int types;
		int skills;
	}

	private final Client client;
	private final ClientThread clientThread;
	private final PartyService partyService;

	private final List<Subscription> subscriptions = new ArrayList<>(2);
	private int subscriptionMask;
	private int statMask;

	private String lastCharacterName;
	private int lastRunEnergy;
	private int lastSpecEnergy;
	private int lastPrayer0, lastPrayerAllActiveAlternate0, lastPrayerRuinous0;
	private final int[] lastStat = new int[Skill.values().length];
	private final int[] lastStatBoost = new int[Skill.values().length];
	private WorldPoint lastLocation;

	private int updateTicks;
	private int dirtyMask;
	private int statDirty, statBoostDirty;

	@Inject
	private PartyDataService(Client client, ClientThread clientThread, PartyService partyService, WSClient wsClient, EventBus eventBus, Scheduler scheduler)
	{
		this.client = client;
		this.clientThread = clientThread;
		this.partyService = partyService;
		eventBus.register(this);
		scheduler.register(this);
		wsClient.registerMessage(PartyData.class);
	}

	private Subscription getOrCreateSubscription(Plugin plugin)
	{
		var opt = subscriptions.stream().filter(s -> s.p == plugin).findFirst();
		if (opt.isPresent())
		{
			return opt.get();
		}
		Subscription sub = new Subscription();
		sub.p = plugin;
		subscriptions.add(sub);
		return sub;
	}

	public synchronized void subscribe(Plugin plugin, PartyDataType... types)
	{
		Subscription sub = getOrCreateSubscription(plugin);
		sub.types |= enumMask(types);
		recomputeMasks();
	}

	public synchronized void subscribe(Plugin plugin, Skill... skills)
	{
		Subscription sub = getOrCreateSubscription(plugin);
		sub.skills |= enumMask(skills);
		recomputeMasks();
	}

	public synchronized void unsubscribe(Plugin plugin, PartyDataType... types)
	{
		unsubscribe(plugin, sub -> sub.types &= ~enumMask(types));
	}

	public synchronized void unsubscribe(Plugin plugin, Skill... skills)
	{
		unsubscribe(plugin, sub -> sub.skills &= ~enumMask(skills));
	}

	private void unsubscribe(Plugin plugin, Consumer<Subscription> c)
	{
		var opt = subscriptions.stream().filter(s -> s.p == plugin).findFirst();
		if (opt.isPresent())
		{
			Subscription sub = opt.get();
			c.accept(sub);
			if (sub.types == 0 && sub.skills == 0)
			{
				subscriptions.remove(sub);
			}
			recomputeMasks();
		}
	}

	private boolean isSubscribed(PartyDataType type)
	{
		return (subscriptionMask & (1 << type.ordinal())) != 0;
	}

	private static <E extends Enum<E>> int enumMask(E[] types)
	{
		int mask = 0;
		for (var type : types)
		{
			mask |= 1 << type.ordinal();
		}
		return mask;
	}

	private void recomputeMasks()
	{
		subscriptionMask = 0;
		statMask = 0;
		for (Subscription sub : subscriptions)
		{
			subscriptionMask |= sub.types;
			statMask |= sub.skills;
		}
	}

	@Subscribe
	private void onGameTick(final GameTick event)
	{
		checkStateChanged(false);
	}

	@Subscribe
	private void onUserSync(final UserSync event)
	{
		clientThread.invokeLater(() -> checkStateChanged(true));
	}

	@Subscribe
	private void onItemContainerChanged(ItemContainerChanged event)
	{
		switch (event.getContainerId())
		{
			case InventoryID.INV:
				dirtyMask |= DIRTY_INV;
				break;
			case InventoryID.WORN:
				dirtyMask |= DIRTY_WORN;
				break;
		}
	}

	@Subscribe
	private void onVarbitChanged(VarbitChanged event)
	{
		switch (event.getVarpId())
		{
			case VarPlayerID.DIZANAS_QUIVER_TEMP_AMMO:
			case VarPlayerID.DIZANAS_QUIVER_TEMP_AMMO_AMOUNT:
				dirtyMask |= DIRTY_QUIVER;
				break;
		}
		switch (event.getVarbitId())
		{
			case VarbitID.RUNE_POUCH_QUANTITY_1:
			case VarbitID.RUNE_POUCH_QUANTITY_2:
			case VarbitID.RUNE_POUCH_QUANTITY_3:
			case VarbitID.RUNE_POUCH_QUANTITY_4:
			case VarbitID.RUNE_POUCH_QUANTITY_5:
			case VarbitID.RUNE_POUCH_QUANTITY_6:
			case VarbitID.RUNE_POUCH_TYPE_1:
			case VarbitID.RUNE_POUCH_TYPE_2:
			case VarbitID.RUNE_POUCH_TYPE_3:
			case VarbitID.RUNE_POUCH_TYPE_4:
			case VarbitID.RUNE_POUCH_TYPE_5:
			case VarbitID.RUNE_POUCH_TYPE_6:
				dirtyMask |= DIRTY_RUNEPOUCH;
				break;
			case VarbitID.VENGEANCE_REBOUND:
				dirtyMask |= DIRTY_VENGEANCE;
				break;
		}
	}

	@Subscribe
	private void onStatChanged(StatChanged event)
	{
		Skill skill = event.getSkill();
		int idx = skill.ordinal();
		if (lastStat[idx] != event.getLevel())
		{
			statDirty |= 1 << skill.ordinal();
			lastStat[idx] = event.getLevel();
		}
		if (lastStatBoost[idx] != event.getBoostedLevel())
		{
			statBoostDirty |= 1 << skill.ordinal();
			lastStatBoost[idx] = event.getBoostedLevel();
		}
	}

	private void checkStateChanged(boolean forceSend)
	{
		if (!partyService.isInParty())
		{
			return;
		}

		++updateTicks;

		final int runEnergy = (int) Math.ceil(client.getEnergy() / 1000.0) * 10; // flatten to reduce network load
		final int specEnergy = client.getVarpValue(VarPlayerID.SA_ENERGY) / 10;
		final int prayer0 = client.getVarpValue(VarPlayerID.PRAYER0),
			prayerAllActiveAlternate0 = client.getVarpValue(VarPlayerID.PRAYER_ALLACTIVE_ALTERNATE_0),
			prayerRuinous0 = client.getVarpValue(VarPlayerID.PRAYER_RUINOUS_0);

		final Player localPlayer = client.getLocalPlayer();
		final String characterName = Strings.nullToEmpty(localPlayer != null && client.getGameState().getState() >= GameState.LOADING.getState() ? localPlayer.getName() : null);
		final WorldPoint location = localPlayer == null ? null : localPlayer.getWorldLocation();

		final PartyData update = new PartyData();
		boolean hasChange = false;
		boolean canDelay = !forceSend;

		if (isSubscribed(PartyDataType.CHARACTER_NAME) && (forceSend || !characterName.equals(lastCharacterName)))
		{
			hasChange = true;
			update.setCharacterName(characterName);
		}
		if (isSubscribed(PartyDataType.COORD) && lastLocation != null && (forceSend || !lastLocation.equals(location)))
		{
			hasChange |= updateTicks > 16;
			update.setCoord(serializeCoord(lastLocation));
		}
		if (isSubscribed(PartyDataType.ENERGY) && (forceSend || runEnergy != lastRunEnergy))
		{
			hasChange = true;
			update.setRunEnergy(runEnergy);
		}
		if (isSubscribed(PartyDataType.SPEC) && (forceSend || specEnergy != lastSpecEnergy))
		{
			hasChange = true;
			canDelay = !forceSend && specEnergy - lastSpecEnergy == 10; // delay regen
			update.setSpecEnergy(specEnergy);
		}
		if (isSubscribed(PartyDataType.VENGEANCE) && (forceSend || (dirtyMask & DIRTY_VENGEANCE) != 0))
		{
			hasChange = true;
			final boolean vengActive = client.getVarbitValue(VarbitID.VENGEANCE_REBOUND) == 1;
			update.setVengeanceActive(vengActive);
		}
		if (isSubscribed(PartyDataType.INV) && (forceSend || (dirtyMask & DIRTY_INV) != 0))
		{
			hasChange = true;
			update.setInv(serializeInv(client.getItemContainer(InventoryID.INV)));
		}
		if (isSubscribed(PartyDataType.WORN) && (forceSend || (dirtyMask & DIRTY_WORN) != 0))
		{
			hasChange = true;
			update.setWorn(serializeInv(client.getItemContainer(InventoryID.WORN)));
		}
		if (isSubscribed(PartyDataType.ACTIVE_PRAYERS) && (forceSend || prayer0 != lastPrayer0 || prayerAllActiveAlternate0 != lastPrayerAllActiveAlternate0 || prayerRuinous0 != lastPrayerRuinous0))
		{
			hasChange = true;
			update.setPrayers(serializePrayers());
		}
		if (statMask != 0 && (forceSend || (statMask & statDirty) != 0))
		{
			hasChange = true;
			update.setStatBase(serializeStats(client::getRealSkillLevel));
		}
		if (statMask != 0 && (forceSend || (statMask & statBoostDirty) != 0))
		{
			hasChange = true;
			update.setStatBoost(serializeStats(client::getBoostedSkillLevel));
		}
		if (isSubscribed(PartyDataType.RUNE_POUCH) && (dirtyMask & DIRTY_RUNEPOUCH) != 0)
		{
			hasChange = true;
			update.setRunePouch(serializeRunepouch());
		}
		if (isSubscribed(PartyDataType.QUIVER) && (dirtyMask & DIRTY_QUIVER) != 0)
		{
			hasChange = true;
			update.setQuiver(serializeQuiver());
		}

		if (canDelay && client.getTickCount() % messageFreq(partyService.getMembers().size()) != 0)
		{
			return;
		}

		if (hasChange)
		{
			lastCharacterName = characterName;
			lastRunEnergy = runEnergy;
			lastSpecEnergy = specEnergy;
			lastPrayer0 = prayer0;
			lastPrayerAllActiveAlternate0 = prayerAllActiveAlternate0;
			lastPrayerRuinous0 = prayerRuinous0;
			updateTicks = 0;
			dirtyMask = 0;
			statDirty = statBoostDirty = 0;
			lastLocation = location;

			partyService.send(update);
		}
	}

	@Subscribe(priority = 1)
	private void onPartyData(PartyData event)
	{
		PartyMember member = partyService.getMemberById(event.getMemberId());
		if (member == null)
		{
			return;
		}

		if (event.getCharacterName() != null)
		{
			final String name = Text.removeTags(Text.toJagexName(event.getCharacterName()));
			if (!name.isEmpty())
			{
				member.displayName = name;
				member.loggedIn = true;
			}
			else
			{
				member.loggedIn = false;
			}
		}
		if (event.getCoord() != null)
		{
			member.coord = WorldPoint.fromCoord(event.getCoord());
		}
		if (event.getRunEnergy() != null)
		{
			member.runEnergy = event.getRunEnergy();
		}
		if (event.getSpecEnergy() != null)
		{
			member.specEnergy = event.getSpecEnergy();
		}
		if (event.getVengeanceActive() != null)
		{
			member.vengeanceActive = event.getVengeanceActive();
		}
		if (event.getInv() != null)
		{
			member.inv = deserializeInv(event.getInv());
		}
		if (event.getWorn() != null)
		{
			member.worn = deserializeInv(event.getWorn());
		}
		if (event.getPrayers() != null)
		{
			member.prayers = deserializePrayers(event.getPrayers());
		}
		if (event.getStatBase() != null)
		{
			System.arraycopy(event.getStatBase(), 0, member.statBase, 0, event.getStatBase().length);
		}
		if (event.getStatBoost() != null)
		{
			System.arraycopy(event.getStatBoost(), 0, member.statBoost, 0, event.getStatBoost().length);
		}
		if (event.getRunePouch() != null)
		{
			member.runepouch = deserializeInv(event.getRunePouch());
		}
		if (event.getQuiver() != null)
		{
			var items = deserializeInv(event.getQuiver());
			member.quiver = items.length > 0 ? items[0] : null;
		}
	}

	private static int messageFreq(int partySize)
	{
		// introduce a tick delay for each member >6
		return Math.max(1, partySize - 6);
	}

	private static int[] serializeInv(ItemContainer inv)
	{
		if (inv == null)
		{
			return null;
		}

		int size = inv.size();
		int[] s = new int[size << 1];
		for (int i = 0; i < size; ++i)
		{
			Item item = inv.getItem(i);
			if (item == null)
			{
				s[i << 1] = -1;
			}
			else
			{
				s[i << 1] = item.getId();
				s[(i << 1) | 1] = item.getQuantity();
			}
		}
		return s;
	}

	private static Item[] deserializeInv(int[] s)
	{
		Item[] items = new Item[s.length >> 1];
		for (int i = 0; i < items.length; ++i)
		{
			int itemId = s[i << 1];
			int quantity = s[(i << 1) | 1];
			if (itemId > -1 && quantity > 0)
			{
				items[i] = new Item(itemId, quantity);
			}
		}
		return items;
	}

	private long serializePrayers()
	{
		long s = 0;
		for (Prayer p : Prayer.values())
		{
			if (client.getVarbitValue(p.getVarbit()) == 1)
			{
				s |= 1L << p.ordinal();
			}
		}
		return s;
	}

	private static Set<Prayer> deserializePrayers(long s)
	{
		EnumSet<Prayer> prayers = EnumSet.noneOf(Prayer.class);
		for (Prayer p : Prayer.values())
		{
			if ((s & (1L << p.ordinal())) != 0)
			{
				prayers.add(p);
			}
		}
		return prayers;
	}

	private int[] serializeStats(ToIntFunction<Skill> f)
	{
		int sz = 32 - Integer.numberOfLeadingZeros(statMask);
		if (sz == 0)
		{
			return null;
		}
		int[] s = new int[sz];
		for (int i = 0; i < sz; ++i)
		{
			if ((statMask & (1 << i)) != 0)
			{
				Skill skill = Skill.values()[i];
				s[i] = f.applyAsInt(skill);
			}
		}
		return s;
	}

	private int[] serializeRunepouch()
	{
		int[] s = new int[12];
		final EnumComposition runepouchEnum = client.getEnum(EnumID.RUNEPOUCH_RUNE);
		int[] runepouchTypes = {VarbitID.RUNE_POUCH_TYPE_1, VarbitID.RUNE_POUCH_TYPE_2, VarbitID.RUNE_POUCH_TYPE_3, VarbitID.RUNE_POUCH_TYPE_4, VarbitID.RUNE_POUCH_TYPE_5, VarbitID.RUNE_POUCH_TYPE_6};
		int[] runepouchQuantity = {VarbitID.RUNE_POUCH_QUANTITY_1, VarbitID.RUNE_POUCH_QUANTITY_2, VarbitID.RUNE_POUCH_QUANTITY_3, VarbitID.RUNE_POUCH_QUANTITY_4, VarbitID.RUNE_POUCH_QUANTITY_5, VarbitID.RUNE_POUCH_QUANTITY_6};
		for (int i = 0; i < runepouchTypes.length; ++i)
		{
			int type = client.getVarbitValue(runepouchTypes[i]);
			int quantity = client.getVarbitValue(runepouchQuantity[i]);
			int itemId = runepouchEnum.getIntValue(type);
			s[i << 1] = itemId;
			s[(i << 1) + 1] = quantity;
		}
		return s;
	}

	private int[] serializeQuiver()
	{
		final int quiverAmmoId = client.getVarpValue(VarPlayerID.DIZANAS_QUIVER_TEMP_AMMO);
		final int quiverAmmoCount = client.getVarpValue(VarPlayerID.DIZANAS_QUIVER_TEMP_AMMO_AMOUNT);
		if (quiverAmmoId == -1 || quiverAmmoCount == 0)
		{
			return new int[0];
		}

		return new int[]{quiverAmmoId, quiverAmmoCount};
	}

	private static int serializeCoord(WorldPoint point)
	{
		return (point.getPlane() << 28) | (point.getX() << 14) | (point.getY());
	}
}
