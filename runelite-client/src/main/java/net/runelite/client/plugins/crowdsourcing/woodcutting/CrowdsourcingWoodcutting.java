/*
 * Copyright (c) 2019, Weird Gloop <admin@weirdgloop.org>
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

package net.runelite.client.plugins.crowdsourcing.woodcutting;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import net.runelite.api.AnimationID;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.MenuAction;
import net.runelite.api.ObjectID;
import net.runelite.api.Skill;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.crowdsourcing.CrowdsourcingManager;
import net.runelite.client.plugins.crowdsourcing.skilling.SkillingEndReason;
import net.runelite.client.plugins.crowdsourcing.skilling.SkillingState;

public class CrowdsourcingWoodcutting
{
	private static final String CHOPPING_MESSAGE = "You swing your axe at the tree.";
	private static final String INVENTORY_FULL_MESSAGE = "Your inventory is too full to hold any more logs.";
	private static final String NEST_MESSAGE = "A bird's nest falls out of the tree";
	private static final Set<Integer> TREE_OBJECTS = new ImmutableSet.Builder<Integer>().
		add(ObjectID.OAK_10820).
		add(ObjectID.YEW).
		add(ObjectID.TREE).
		add(ObjectID.TREE_1278).
		add(ObjectID.WILLOW).
		add(ObjectID.WILLOW_10829).
		add(ObjectID.WILLOW_10831).
		add(ObjectID.WILLOW_10833).
		add(ObjectID.SCRAPEY_TREE).
		add(ObjectID.JUNGLE_TREE_15951).
		add(ObjectID.JUNGLE_TREE_15954).
		add(ObjectID.JUNGLE_TREE_15948).
		add(ObjectID.MAPLE_TREE_10832).
		add(ObjectID.MAHOGANY).
		add(ObjectID.TEAK).
		add(ObjectID.MAGIC_TREE_10834).
		add(ObjectID.HOLLOW_TREE_10821).
		add(ObjectID.HOLLOW_TREE_10830).
		add(ObjectID.ACHEY_TREE).
		build();

	private static final Map<Integer, Integer> AXE_ANIMS = new ImmutableMap.Builder<Integer, Integer>().
		put(AnimationID.WOODCUTTING_BRONZE, ItemID.BRONZE_AXE).
		put(AnimationID.WOODCUTTING_IRON, ItemID.IRON_AXE).
		put(AnimationID.WOODCUTTING_STEEL, ItemID.STEEL_AXE).
		put(AnimationID.WOODCUTTING_BLACK, ItemID.BLACK_AXE).
		put(AnimationID.WOODCUTTING_MITHRIL, ItemID.MITHRIL_AXE).
		put(AnimationID.WOODCUTTING_ADAMANT, ItemID.ADAMANT_AXE).
		put(AnimationID.WOODCUTTING_RUNE, ItemID.RUNE_AXE).
		put(AnimationID.WOODCUTTING_DRAGON, ItemID.DRAGON_AXE).
		put(AnimationID.WOODCUTTING_INFERNAL, ItemID.INFERNAL_AXE).
		put(AnimationID.WOODCUTTING_3A_AXE, ItemID._3RD_AGE_AXE).
		put(AnimationID.WOODCUTTING_CRYSTAL, ItemID.CRYSTAL_AXE).
		put(AnimationID.WOODCUTTING_TRAILBLAZER, ItemID.INFERNAL_AXE_OR).build();

	private static final Set<String> SUCCESS_MESSAGES = new ImmutableSet.Builder<String>().
		add("You get some logs.").
		add("You get some oak logs.").
		add("You get some willow logs.").
		add("You get some teak logs.").
		add("You get some teak logs and give them to Carpenter Kjallak.").
		add("You get some maple logs.").
		add("You get some maple logs and give them to Lumberjack Leif.").
		add("You get some mahogany logs.").
		add("You get some mahogany logs and give them to Carpenter Kjallak.").
		add("You get some yew logs.").
		add("You get some magic logs.").
		add("You get some scrapey tree logs.").
		add("You get some bark.").
		build();

	@Inject
	private CrowdsourcingManager manager;

	@Inject
	private Client client;

	private SkillingState state = SkillingState.RECOVERING;
	private int lastExperimentEnd = 0;
	private WorldPoint treeLocation;
	private int treeId;
	private int startTick;
	private int axe;
	private List<Integer> chopTicks = new ArrayList<>();
	private List<Integer> nestTicks = new ArrayList<>();

	private void endExperiment(SkillingEndReason reason)
	{
		if (state == SkillingState.CUTTING)
		{
			int endTick = client.getTickCount();
			int woodcuttingLevel = client.getBoostedSkillLevel(Skill.WOODCUTTING);
			WoodcuttingData data = new WoodcuttingData(
				woodcuttingLevel,
				startTick,
				endTick,
				chopTicks,
				nestTicks,
				axe,
				treeId,
				treeLocation,
				reason
			);
			manager.storeEvent(data);

			chopTicks = new ArrayList<>();
			nestTicks = new ArrayList<>();
		}
		state = SkillingState.RECOVERING;
		lastExperimentEnd = client.getTickCount();
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		final String message = event.getMessage();
		final ChatMessageType type = event.getType();
		if (state == SkillingState.CLICKED && type == ChatMessageType.SPAM && message.equals(CHOPPING_MESSAGE))
		{
			startTick = client.getTickCount();
			state = SkillingState.CUTTING;
		}
		else if (state == SkillingState.CUTTING && type == ChatMessageType.SPAM && SUCCESS_MESSAGES.contains(message))
		{
			chopTicks.add(client.getTickCount());
		}
		else if (state == SkillingState.CUTTING && type == ChatMessageType.GAMEMESSAGE && message.equals(INVENTORY_FULL_MESSAGE))
		{
			endExperiment(SkillingEndReason.INVENTORY_FULL);
		}
		else if (state == SkillingState.CUTTING && type == ChatMessageType.GAMEMESSAGE && message.contains(NEST_MESSAGE))
		{
			nestTicks.add(client.getTickCount());
		}
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		int animId = client.getLocalPlayer().getAnimation();
		if (state == SkillingState.CUTTING)
		{
			if (AXE_ANIMS.containsKey(animId))
			{
				axe = AXE_ANIMS.get(animId);
			}
			else
			{
				endExperiment(SkillingEndReason.INTERRUPTED);
			}
		}
		else if (animId != -1)
		{
			endExperiment(SkillingEndReason.INTERRUPTED);
		}
		else if (state == SkillingState.RECOVERING && client.getTickCount() - lastExperimentEnd >= 4)
		{
			state = SkillingState.READY;
		}
		else if (state == SkillingState.CLICKED && client.getTickCount() - lastExperimentEnd >= 20)
		{
			state = SkillingState.READY;
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked menuOptionClicked)
	{
		MenuAction menuAction = menuOptionClicked.getMenuAction();
		int id = menuOptionClicked.getId();
		if (state == SkillingState.READY && menuAction == MenuAction.GAME_OBJECT_FIRST_OPTION && TREE_OBJECTS.contains(id))
		{
			state = SkillingState.CLICKED;
			lastExperimentEnd = client.getTickCount();
			treeId = id;
			treeLocation = WorldPoint.fromScene(client, menuOptionClicked.getActionParam(), menuOptionClicked.getWidgetId(), client.getPlane());
		}
		else
		{
			endExperiment(SkillingEndReason.INTERRUPTED);
		}
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		if (state != SkillingState.CUTTING)
		{
			return;
		}
		if (treeId == event.getGameObject().getId() && treeLocation.equals(event.getTile().getWorldLocation()))
		{
			endExperiment(SkillingEndReason.DEPLETED);
		}
	}
}
