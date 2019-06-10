/*
 * Copyright (c) 2019, Jacky <liangj97@gmail.com>
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
package net.runelite.client.plugins.inferno;

import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.HeadIcon;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Inferno",
	description = "Inferno helper",
	tags = {"combat", "overlay", "pve", "pvm"},
	type = PluginType.PVM
)
public class InfernoPlugin extends Plugin
{

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private InfernoOverlay infernoOverlay;

	@Inject
	private InfernoInfobox infernoInfobox;

	@Inject
	private InfernoNibblerOverlay nibblerOverlay;

	@Inject
	private InfernoConfig config;

	@Getter
	private Map<NPC, InfernoNPC> monsters;

	@Getter
	private Map<Integer, ArrayList<InfernoNPC>> monsterCurrentAttackMap;

	@Getter
	private List<NPC> nibblers;

	@Getter
	private InfernoNPC[] priorityNPC;

	@Provides
	InfernoConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(InfernoConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(infernoOverlay);
		overlayManager.add(infernoInfobox);
		overlayManager.add(nibblerOverlay);
		monsters = new HashMap<>();
		monsterCurrentAttackMap = new HashMap<>(6);
		for (int i = 1; i <= 6; i++)
		{
			monsterCurrentAttackMap.put(i, new ArrayList<>());
		}
		nibblers = new ArrayList<>();
		priorityNPC = new InfernoNPC[4];
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(infernoInfobox);
		overlayManager.remove(infernoOverlay);
		overlayManager.remove(nibblerOverlay);
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		if (client.getMapRegions()[0] != 9043) return;

		NPC npc = event.getNpc();
		if (isValidInfernoMob(npc))
		{
			monsters.put(npc, new InfernoNPC(npc));
			System.out.println(monsters.size());
		}
		if (npc.getId() == NpcID.JALNIB)
		{
			nibblers.add(npc);
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		if (client.getMapRegions()[0] != 9043) return;

		NPC npc = event.getNpc();
		if (monsters.containsKey(npc))
		{
			monsters.remove(npc);
			System.out.println(monsters.size());
		}

		if (npc.getId() == NpcID.JALNIB)
		{
			nibblers.remove(npc);
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (client.getMapRegions()[0] != 9043) return;

		clearMapAndPriority();

		for (InfernoNPC monster : monsters.values())
		{
			calculateDistanceToPlayer(monster);

			NPC npc = monster.getNpc();

			// if they are not attacking but are still attacking
			if (monster.isAttacking())
			{
				monster.setTicksTillAttack(monster.getTicksTillAttack() - 1);

				// sets the blobs attack style
				if (monster.getName().equals("blob") && monster.getTicksTillAttack() == 3 && monster.getDistanceToPlayer() <= 15)
				{
					if (client.getLocalPlayer().getOverheadIcon() == null)
					{
						monster.setAttackstyle(InfernoNPC.Attackstyle.RANDOM);
					}
					else if (client.getLocalPlayer().getOverheadIcon().equals(HeadIcon.MAGIC))
					{
						monster.setAttackstyle(InfernoNPC.Attackstyle.RANGE);
					}
					else if (client.getLocalPlayer().getOverheadIcon().equals(HeadIcon.RANGED))
					{
						monster.setAttackstyle(InfernoNPC.Attackstyle.MAGE);
					}
				}

				// we know the monster is not attacking because it should have attacked and is idling
				if (monster.getTicksTillAttack() == 0)
				{
					if (npc.getAnimation() == -1)
					{
						monster.setAttacking(false);
					}
					else
					{
						// want to reset the monsters attack back to attacking
						monster.attacked();
					}
				}
			}
			else
			{
				// they've just attacked
				if (npc.getAnimation() == monster.getAttackAnimation() || npc.getAnimation() == 7581) // special case for blob
				{
					monster.attacked();
				}
			}

			if (monster.getTicksTillAttack() >= 1)
			{
				monsterCurrentAttackMap.get(monster.getTicksTillAttack()).add(monster);
			}
		}

		calculatePriorityNPC();
	}

	private void calculatePriorityNPC()
	{
		for (int i = 0; i < priorityNPC.length; i++)
		{
			ArrayList<InfernoNPC> monsters = monsterCurrentAttackMap.get(i + 1);

			if ( monsters.size() == 0) continue;

			int priority = monsters.get(0).getPriority();

			InfernoNPC infernoNPC = monsters.get(0);

			for (InfernoNPC npc : monsters)
			{
				if (npc.getPriority() < priority)
				{
					priority = npc.getPriority();
					infernoNPC = npc;
				}
			}
			priorityNPC[i] = infernoNPC;
			System.out.println("i: " + i + " " + infernoNPC.getName());
		}
	}

	// TODO: blob calculator
	private void calculateDistanceToPlayer(InfernoNPC monster)
	{
		monster.setDistanceToPlayer(client.getLocalPlayer().getWorldLocation().distanceTo(monster.getNpc().getWorldArea()));
	}

	private void clearMapAndPriority()
	{
		for (List<InfernoNPC> l : monsterCurrentAttackMap.values())
		{
			l.clear();
		}

		for (int i = 0; i < priorityNPC.length; i++)
		{
			priorityNPC[i] = null;
		}
	}

	public boolean isValidInfernoMob(NPC npc)
	{
		// we only want the bat, blob, melee, ranger and mager
		if (npc.getId() == NpcID.JALMEJRAH ||
			npc.getId() == NpcID.JALAK ||
			npc.getId() == NpcID.JALIMKOT ||
			npc.getId() == NpcID.JALXIL ||
			npc.getId() == NpcID.JALZEK) return true;

		return false;
	}

}
