/*
 * Copyright (c) 2019, xzact <https://github.com/xzact>
 * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
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

package net.runelite.client.plugins.coxhelper;

import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GraphicID;
import net.runelite.api.GraphicsObject;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Player;
import net.runelite.api.Projectile;
import net.runelite.api.ProjectileID;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GraphicChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "CoX Helper",
	description = "All-in-one plugin for Chambers of Xeric",
	tags = {"CoX", "chamber", "xeric", "helper"},
	enabledByDefault = false,
	type = PluginType.PVM
)

@Slf4j
@Singleton
public class CoxPlugin extends Plugin
{
	private static final int GAMEOBJECT_ID_PSN = 30032;
	private static final int GRAPHICSOBJECT_ID_CRYSTAL = 1447;
	private static final int GRAPHICSOBJECT_ID_HEAL = 1363;
	private static final int ANIMATION_ID_G1 = 430;
	private static final String OLM_HAND_CRIPPLE = "The Great Olm\'s left claw clenches to protect itself temporarily.";
	private static final Pattern TP_REGEX = Pattern.compile("<col\\b[^>]*>(.*?)</col>");
	private int sleepcount = 0;
	private boolean needOlm = false;

	@Inject
	private Client client;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private CoxOverlay overlay;

	@Inject
	private TimersOverlay timersOverlay;

	@Inject
	private CoxConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private OlmCrippleTimerOverlay olmCrippleTimerOverlay;

	@Inject
	private OlmPrayAgainstOverlay prayAgainstOverlay;

	@Setter
	@Getter(AccessLevel.PACKAGE)
	protected PrayAgainst prayAgainstOlm;

	@Getter(AccessLevel.PACKAGE)
	private boolean runMutta;

	@Getter(AccessLevel.PACKAGE)
	private boolean runTekton;

	@Getter(AccessLevel.PACKAGE)
	private boolean runVanguards;

	@Getter(AccessLevel.PACKAGE)
	private boolean runGuard = false;

	@Getter(AccessLevel.PACKAGE)
	private boolean HandCripple;

	@Getter(AccessLevel.PACKAGE)
	private boolean runOlm;

	@Getter(AccessLevel.PACKAGE)
	private NPC Guard1_NPC;

	@Getter(AccessLevel.PACKAGE)
	private NPC Guard2_NPC;

	@Getter(AccessLevel.PACKAGE)
	private NPC Tekton_NPC;

	@Getter(AccessLevel.PACKAGE)
	private NPC hand;

	@Getter(AccessLevel.PACKAGE)
	private NPC Olm_NPC;

	@Getter(AccessLevel.PACKAGE)
	private NPC OlmMelee_NPC;

	@Getter(AccessLevel.PACKAGE)
	private NPC Mutta_NPC;

	@Getter(AccessLevel.PACKAGE)
	private NPC Momma_NPC;

	@Getter(AccessLevel.PACKAGE)
	private NPC meleeVanguard_NPC;

	@Getter(AccessLevel.PACKAGE)
	private NPC mageVanguard_NPC;

	@Getter(AccessLevel.PACKAGE)
	private NPC rangeVanguard_NPC;

	@Getter(AccessLevel.PACKAGE)
	private List<WorldPoint> Olm_Crystals = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	private List<WorldPoint> Olm_Heal = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	private List<WorldPoint> Olm_PSN = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	private List<Actor> burnTarget = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	private Actor teleportTarget;

	@Getter(AccessLevel.PACKAGE)
	private Actor acidTarget;

	@Getter(AccessLevel.PACKAGE)
	private int timer = 45;

	@Getter(AccessLevel.PACKAGE)
	private int burnTicks = 41;

	@Getter(AccessLevel.PACKAGE)
	private int acidTicks = 25;

	@Getter(AccessLevel.PACKAGE)
	private int teleportTicks = 10;

	@Getter(AccessLevel.PACKAGE)
	private int guardTick = -1;

	@Getter(AccessLevel.PACKAGE)
	private int OlmPhase = 0;

	@Getter(AccessLevel.PACKAGE)
	private int Olm_TicksUntilAction = -1;

	@Getter(AccessLevel.PACKAGE)
	private int Olm_ActionCycle = -1; //4:0 = auto 3:0 = null 2:0 = auto 1:0 = spec + actioncycle =4

	@Getter(AccessLevel.PACKAGE)
	private int Olm_NextSpec = -1; // 1= crystals 2=lightnig 3=portals 4= heal hand if p4

	@Getter(AccessLevel.PACKAGE)
	protected long lastPrayTime;

	@Provides
	CoxConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CoxConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
		overlayManager.add(olmCrippleTimerOverlay);
		overlayManager.add(prayAgainstOverlay);
		overlayManager.add(timersOverlay);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
		overlayManager.remove(olmCrippleTimerOverlay);
		overlayManager.remove(prayAgainstOverlay);
		overlayManager.remove(timersOverlay);
		HandCripple = false;
		acidTarget = null;
		teleportTarget = null;
		burnTarget.clear();
		timer = 45;
		burnTicks = 40;
		acidTicks = 25;
		hand = null;
	}


	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		final Matcher tpMatcher = TP_REGEX.matcher(chatMessage.getMessage());
		String msg = chatMessage.getMessageNode().getValue();
		if (chatMessage.getType() == ChatMessageType.GAMEMESSAGE)
		{
			if (msg.toLowerCase().contains("The Great Olm rises with the power of".toLowerCase()))
			{
				if (!runOlm)
				{
					Olm_ActionCycle = -1;
					Olm_TicksUntilAction = 4;
				}
				else
				{
					Olm_ActionCycle = -1;
					Olm_TicksUntilAction = 3;
				}
				OlmPhase = 0;
				runOlm = true;
				needOlm = true;
				Olm_NextSpec = -1;
			}

			if (msg.toLowerCase().contains("The Great Olm is giving its all. this is its final stand"))
			{
				if (!runOlm)
				{
					Olm_ActionCycle = -1;
					Olm_TicksUntilAction = 4;
				}
				else
				{
					Olm_ActionCycle = -1;
					Olm_TicksUntilAction = 3;
				}
				OlmPhase = 1;
				runOlm = true;
				needOlm = true;
				Olm_NextSpec = -1;
			}
			if (msg.startsWith(OLM_HAND_CRIPPLE))
			{
				HandCripple = true;
				timer = 45;
			}
			if (msg.toLowerCase().contains("aggression"))
			{
				prayAgainstOlm = PrayAgainst.MELEE;
				lastPrayTime = System.currentTimeMillis();
			}
			if (msg.toLowerCase().contains("of magical power"))
			{
				prayAgainstOlm = PrayAgainst.MAGIC;
				lastPrayTime = System.currentTimeMillis();
			}
			if (msg.toLowerCase().contains("accuracy and dexterity"))
			{
				prayAgainstOlm = PrayAgainst.RANGED;
				lastPrayTime = System.currentTimeMillis();
			}
			if (msg.toLowerCase().startsWith("You have been paired with"))
			{
				if (!tpMatcher.matches())
				{
					return;
				}
				for (Actor actor : client.getPlayers())
				{
					if (actor.getName().equals((tpMatcher.group(1))))
					{
						teleportTarget = actor;
					}
				}
			}
		}
	}

	@Subscribe
	public void onProjectileMoved(ProjectileMoved event)
	{
		Projectile projectile = event.getProjectile();
		if (projectile.getId() == ProjectileID.OLM_MAGE_ATTACK)
		{
			prayAgainstOlm = PrayAgainst.MAGIC;
			lastPrayTime = System.currentTimeMillis();
		}
		if (projectile.getId() == ProjectileID.OLM_RANGE_ATTACK)
		{
			prayAgainstOlm = PrayAgainst.RANGED;
			lastPrayTime = System.currentTimeMillis();
		}
		if (projectile.getId() == ProjectileID.OLM_ACID_TRAIL)
		{
			/*acidTarget = projectile.getInteracting();*/
		}
	}

	@Subscribe
	public void onGraphicChanged(GraphicChanged graphicChanged)
	{
		Actor actor = graphicChanged.getActor();

		if (actor.getGraphic() == GraphicID.OLM_BURN)
		{
			burnTarget.add(actor);
		}
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned npcSpawned)
	{
		NPC npc = npcSpawned.getNpc();
		switch (npc.getId())
		{
			case NpcID.TEKTON:
			case NpcID.TEKTON_7541:
			case NpcID.TEKTON_7542:
			case NpcID.TEKTON_7545:
			case NpcID.TEKTON_ENRAGED:
			case NpcID.TEKTON_ENRAGED_7544:
				runTekton = true;
				Tekton_NPC = npc;
				break;
			case NpcID.MUTTADILE:
				Momma_NPC = npc;
				break;
			case NpcID.MUTTADILE_7562:
				runMutta = true;
				Mutta_NPC = npc;
				break;
			case NpcID.MUTTADILE_7563:
				runMutta = true;
				Momma_NPC = npc;
				break;
			case NpcID.GUARDIAN:
				Guard1_NPC = npc;
				guardTick = -1;
				runGuard = true;
				break;
			case NpcID.GUARDIAN_7570:
				Guard2_NPC = npc;
				guardTick = -1;
				runGuard = true;
				break;
			case NpcID.GREAT_OLM_RIGHT_CLAW_7553:
			case NpcID.GREAT_OLM_LEFT_CLAW:
				hand = npc;
				break;
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		NPC npc = npcDespawned.getNpc();
		switch (npc.getId())
		{
			case NpcID.TEKTON:
			case NpcID.TEKTON_7541:
			case NpcID.TEKTON_7542:
			case NpcID.TEKTON_7545:
			case NpcID.TEKTON_ENRAGED:
			case NpcID.TEKTON_ENRAGED_7544:
				runTekton = false;
				Tekton_NPC = null;
				break;
			case NpcID.MUTTADILE:
				Momma_NPC = null;
				break;
			case NpcID.MUTTADILE_7562:
				Mutta_NPC = null;
				break;
			case NpcID.MUTTADILE_7563:
				runMutta = false;
				Momma_NPC = null;
				break;
			case NpcID.GUARDIAN:
				Guard1_NPC = null;
				runGuard = false;
				Guard2_NPC = null;
				break;
			case NpcID.GUARDIAN_7570:
				Guard2_NPC = null;
				Guard1_NPC = null;
				runGuard = false;
				break;
			case NpcID.GUARDIAN_7571:
			case NpcID.GUARDIAN_7572:
				Guard1_NPC = null;
				Guard2_NPC = null;
				runGuard = false;
				break;
			case NpcID.GREAT_OLM_RIGHT_CLAW_7553:
			case NpcID.GREAT_OLM_LEFT_CLAW:
				HandCripple = false;
				break;
		}

	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (acidTarget != null)
		{
			acidTicks--;
			if (acidTicks <= 0)
			{
				acidTarget = null;
				acidTicks = 25;
			}
		}
		if (teleportTarget != null)
		{
			Player target = (Player) teleportTarget;
			client.setHintArrow(target);
			teleportTicks--;
			if (teleportTicks <= 0)
			{
				client.clearHintArrow();
				teleportTarget = null;
				teleportTicks = 10;
			}
		}
		if (burnTarget.size() > 0)
		{
			burnTicks--;
			if (burnTicks <= 0)
			{
				burnTarget.clear();
				burnTicks = 41;
			}
		}

		if (client.getVar(Varbits.IN_RAID) == 0)
		{
			runOlm = false;
			runGuard = false;
			runMutta = false;
			runTekton = false;
			needOlm = false;
			OlmPhase = 0;
			sleepcount = 0;
			Olm_Heal.clear();
		}

		if (HandCripple)
		{
			timer--;
			if (timer <= 0)
			{
				HandCripple = false;
				timer = 45;
			}
		}
		if (needOlm = true)
		{
			for (NPC monster : client.getNpcs())
			{
				if (monster.getId() == NpcID.GREAT_OLM)
				{
					needOlm = false;
					Olm_NPC = monster;
					break;
				}
			}
		}


		if (runGuard)
		{
			if (guardTick == -1)
			{
				if (Guard1_NPC != null)
				{
					if (Guard1_NPC.getAnimation() == ANIMATION_ID_G1)
					{
						guardTick = 5;
					}
				}
				if (Guard2_NPC != null)
				{
					if (Guard2_NPC.getAnimation() == ANIMATION_ID_G1)
					{
						guardTick = 5;
					}
				}

			}
			else
			{
				guardTick--;
			}
			if (guardTick == 0)
			{
				guardTick = 5;
			}

		}
		if (runOlm)
		{
			Olm_Crystals.clear();
			Olm_Heal.clear();

			sleepcount--;

			if (Olm_TicksUntilAction == 1)
			{
				if (Olm_ActionCycle == 1)
				{
					Olm_ActionCycle = 4;
					Olm_TicksUntilAction = 4;
					if (Olm_NextSpec == 1)
					{
						if (OlmPhase == 1)
						{
							Olm_NextSpec = 4; // 4 = heal 3= cry 2 = lightn 1 = swap
						}
						else
						{
							Olm_NextSpec = 3;
						}

					}
					else
					{
						Olm_NextSpec--;
					}


				}
				else
				{
					if (Olm_ActionCycle != -1)
					{
						Olm_ActionCycle--;
					}
					Olm_TicksUntilAction = 4;
				}

			}
			else
			{
				Olm_TicksUntilAction--;
			}

			for (GraphicsObject o : client.getGraphicsObjects())
			{
				if (o.getId() == GRAPHICSOBJECT_ID_CRYSTAL)
				{
					WorldPoint newloc;
					for (int x = -1; x <= 1; x++)
					{
						for (int y = -1; y <= 1; y++)
						{
							newloc = WorldPoint.fromLocal(client, o.getLocation());
							newloc = newloc.dx(x);
							newloc = newloc.dy(y);
							Olm_Crystals.add(newloc);
						}
					}
				}
				if (sleepcount <= 0)
				{
					if (o.getId() == 1338)
					{
						Olm_TicksUntilAction = 1;
						Olm_NextSpec = 2;
						Olm_ActionCycle = 4; //spec=1 null=3
						sleepcount = 5;
					}
					if (o.getId() == 1356)
					{
						Olm_TicksUntilAction = 4;
						Olm_NextSpec = 1;
						Olm_ActionCycle = 4; //spec=1 null=3
						sleepcount = 50;
					}
				}


				if (o.getId() == GRAPHICSOBJECT_ID_HEAL)
				{
					Olm_Heal.add(WorldPoint.fromLocal(client, o.getLocation()));
				}
			}
		}
	}
}
