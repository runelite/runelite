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
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.Skill;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.gameval.AnimationID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.ObjectID;
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
		add(ObjectID.OAK_TREE_SEEDLING).
		add(ObjectID.OAKTREE).
		add(ObjectID.OAK_TREE_FULLYGROWN_2).
		add(ObjectID.NEWBIEOAKTREE).

		add(ObjectID.YEWTREE).
		add(ObjectID.YEW_TREE_FULLYGROWN_2).

		add(ObjectID.TREE).
		add(ObjectID.LIGHTTREE).
		add(ObjectID.TREE2).
		add(ObjectID.TREE3).
		add(ObjectID.LIGHTTREE2).
		add(ObjectID.DEADTREE1).
		add(ObjectID.DEADTREE1_LARGE).
		add(ObjectID.DEADTREE4).
		add(ObjectID.LIGHTDEADTREE1).
		add(ObjectID.DEADTREE2).
		add(ObjectID.DEADTREE2_DARK).
		add(ObjectID.DEADTREE3).
		add(ObjectID.DEADTREE2_SNOWY).
		add(ObjectID.EVERGREEN_VSNOWY_LARGE).
		add(ObjectID.EVERGREEN_SNOWY_LARGE).
		add(ObjectID.SNOWTREE1).
		add(ObjectID.SNOWTREE2).
		add(ObjectID.SNOWTREE3).
		add(ObjectID.DEADTREE2_SWAMP).
		add(ObjectID.DEADTREE6).
		add(ObjectID.DEADTREE_BURNT).
		add(ObjectID.EVERGREEN).
		add(ObjectID.EVERGREEN_LARGE).
		add(ObjectID.LEPRECHAUNTREE).
		add(ObjectID.REGICIDE_TREE_LARGE).
		add(ObjectID.REGICIDE_TREE_LARGE2).
		add(ObjectID.REGICIDE_TREE_LARGE3).
		add(ObjectID.REGICIDE_TREE_SMALL).
		add(ObjectID.MDAUGHTER_IMPASSABLE_TREE).
		add(ObjectID.MDAUGHTER_IMPASSABLE_TREE2).
		add(ObjectID.MDAUGHTER_PASSABLE_TREE).
		add(ObjectID.NEWBIETREE).
		add(ObjectID.NEWBIETREE2).
		add(ObjectID.NEWBIEDEADTREE).
		add(ObjectID.NEWBIEDEADTREE2).
		add(ObjectID.WOM_TREE).
		add(ObjectID.PEST_TREE).
		add(ObjectID.PEST_TREE2).
		add(ObjectID.FAIRY2_PINE_TREE_MEDIUM).
		add(ObjectID.FAIRY2_PINE_TREE_LARGE).
		add(ObjectID.MAX_EVERGREEN).
		add(ObjectID.FOSSIL_DEADTREE_LARGE1).
		add(ObjectID.FOSSIL_DEADTREE_SMALL1).

		add(ObjectID.MATURE_JUNIPER_TREE).

		add(ObjectID.WILLOWTREE).
		add(ObjectID.WILLOW_TREE2).
		add(ObjectID.WILLOW_TREE3).
		add(ObjectID.WILLOW_TREE4).
		add(ObjectID.WILLOW_TREE_FULLYGROWN_2).
		add(ObjectID.BREW_SCRAPEY_TREE).
		add(ObjectID.BREW_JUNGLE_TREE_2).
		add(ObjectID.BREW_JUNGLE_TREE_3).
		add(ObjectID.BREW_JUNGLE_TREE_1).
		add(ObjectID.MAPLETREE).
		add(ObjectID.MISC_DUMMY_MAPLETREE).
		add(ObjectID.MAPLE_TREE_FULLYGROWN_2).
		add(ObjectID.PRIF_MAHOGANYTREE).
		add(ObjectID.MISC_DUMMY_TEAKTREE).
		add(ObjectID.MISC_DUMMY_TEAKTREE).
		add(ObjectID.MAGICTREE).
		add(ObjectID.MAGIC_TREE_FULLYGROWN_2).
		add(ObjectID.HOLLOW_TREE).
		add(ObjectID.HOLLOW_TREE_BIG).
		add(ObjectID.ACHEY_TREE).
		add(ObjectID.REDWOODTREE_L).
		add(ObjectID.REDWOODTREE_R).
		add(ObjectID.WINT_ROOTS).
		add(ObjectID.ARCTIC_PINE).
		add(ObjectID.FOSSIL_CEP_GROWN).
		build();

	private static final Map<Integer, Integer> AXE_ANIMS = new ImmutableMap.Builder<Integer, Integer>().
		put(AnimationID.HUMAN_WOODCUTTING_BRONZE_AXE, ItemID.BRONZE_AXE).
		put(AnimationID.HUMAN_WOODCUTTING_IRON_AXE, ItemID.IRON_AXE).
		put(AnimationID.HUMAN_WOODCUTTING_STEEL_AXE, ItemID.STEEL_AXE).
		put(AnimationID.HUMAN_WOODCUTTING_BLACK_AXE, ItemID.BLACK_AXE).
		put(AnimationID.HUMAN_WOODCUTTING_MITHRIL_AXE, ItemID.MITHRIL_AXE).
		put(AnimationID.HUMAN_WOODCUTTING_ADAMANT_AXE, ItemID.ADAMANT_AXE).
		put(AnimationID.HUMAN_WOODCUTTING_RUNE_AXE, ItemID.RUNE_AXE).
		put(AnimationID.HUMAN_WOODCUTTING_DRAGON_AXE, ItemID.DRAGON_AXE).
		put(AnimationID.HUMAN_WOODCUTTING_TRAILBLAZER_AXE_NO_INFERNAL, ItemID.TRAILBLAZER_AXE_NO_INFERNAL).
		put(AnimationID.HUMAN_WOODCUTTING_INFERNAL_AXE, ItemID.INFERNAL_AXE).
		put(AnimationID.HUMAN_WOODCUTTING_3A_AXE, ItemID._3A_AXE).
		put(AnimationID.HUMAN_WOODCUTTING_CRYSTAL_AXE, ItemID.CRYSTAL_AXE).
		put(AnimationID.HUMAN_OPENHEAVYCHEST, ItemID.TRAILBLAZER_AXE).build();

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
		add("You get some redwood logs.").
		add("You get some scrapey tree logs.").
		add("You get some bark.").
		add("You get a bruma root.").
		add("You get an arctic pine log").
		add("You get some juniper logs.").
		add("You get some mushrooms.").
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
			treeLocation = WorldPoint.fromScene(client, menuOptionClicked.getParam0(), menuOptionClicked.getParam1(), client.getPlane());
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
