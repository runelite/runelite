/*
 * Copyright (c) 2019, xzact <https://github.com/xzact>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
 * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
 * Copyright (c) 2019, lyzrds <https://discord.gg/5eb9Fe>
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
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.AnimationID;
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
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.api.events.SpotAnimationChanged;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "CoX Helper",
	description = "All-in-one plugin for Chambers of Xeric",
	tags = {"CoX", "chamber", "xeric", "helper"},
	type = PluginType.PVM,
	enabledByDefault = false
)

@Slf4j
@Singleton
public class CoxPlugin extends Plugin
{
	private static final int ANIMATION_ID_G1 = 430;
	private static final String OLM_HAND_CRIPPLE = "The Great Olm\'s left claw clenches to protect itself temporarily.";
	private static final Pattern TP_REGEX = Pattern.compile("You have been paired with <col=ff0000>(.*)</col>! The magical power will enact soon...");
	@Setter
	@Getter(AccessLevel.PACKAGE)
	protected PrayAgainst prayAgainstOlm;
	@Getter(AccessLevel.PACKAGE)
	protected long lastPrayTime;
	private int sleepcount = 0;
	private boolean needOlm = false;
	private GraphicsObject teleportObject;
	@Inject
	private Client client;
	@Inject
	private ChatMessageManager chatMessageManager;
	@Inject
	private CoxOverlay coxOverlay;
	@Inject
	private CoxInfoBox coxInfoBox;
	@Inject
	private CoxConfig config;
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private EventBus eventBus;
	@Getter(AccessLevel.PACKAGE)
	private boolean HandCripple;
	@Getter(AccessLevel.PACKAGE)
	private boolean runOlm;
	@Getter(AccessLevel.PACKAGE)
	private int vanguards;
	@Getter(AccessLevel.PACKAGE)
	private boolean tektonActive;
	@Getter(AccessLevel.PACKAGE)
	private NPC hand;
	@Getter(AccessLevel.PACKAGE)
	private NPC Olm_NPC;
	@Getter(AccessLevel.PACKAGE)
	private NPC OlmMelee_NPC;
	@Getter(AccessLevel.PACKAGE)
	private List<WorldPoint> Olm_Crystals = new ArrayList<>();
	@Getter(AccessLevel.PACKAGE)
	private List<WorldPoint> Olm_Heal = new ArrayList<>();
	@Getter(AccessLevel.PACKAGE)
	private List<WorldPoint> Olm_TP = new ArrayList<>();
	@Getter(AccessLevel.PACKAGE)
	private List<WorldPoint> Olm_PSN = new ArrayList<>();
	@Getter(AccessLevel.PACKAGE)
	private List<Actor> burnTarget = new ArrayList<>();
	@Getter(AccessLevel.PACKAGE)
	private Actor teleportTarget;
	@Getter(AccessLevel.PACKAGE)
	private Actor acidTarget;
	@Getter(AccessLevel.PACKAGE)
	private int crippleTimer = 45;
	@Getter(AccessLevel.PACKAGE)
	private int burnTicks = 41;
	@Getter(AccessLevel.PACKAGE)
	private int acidTicks = 25;
	@Getter(AccessLevel.PACKAGE)
	private int teleportTicks = 10;
	@Getter(AccessLevel.PACKAGE)
	private int tektonAttackTicks;
	@Getter(AccessLevel.PACKAGE)
	private int OlmPhase = 0;
	@Getter(AccessLevel.PACKAGE)
	private int Olm_TicksUntilAction = -1;
	@Getter(AccessLevel.PACKAGE)
	private int Olm_ActionCycle = -1; //4:0 = auto 3:0 = null 2:0 = auto 1:0 = spec + actioncycle =4
	@Getter(AccessLevel.PACKAGE)
	private int Olm_NextSpec = -1; // 1= crystals 2=lightnig 3=portals 4= heal hand if p4
	@Getter(AccessLevel.PACKAGE)
	private float percent;
	@Getter(AccessLevel.PACKAGE)
	private Map<NPC, NPCContainer> npcContainer = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private boolean muttadile;
	@Getter(AccessLevel.PACKAGE)
	private boolean tekton;
	@Getter(AccessLevel.PACKAGE)
	private boolean tektonTickCounter;
	@Getter(AccessLevel.PACKAGE)
	private boolean guardians;
	@Getter(AccessLevel.PACKAGE)
	private boolean guardinTickCounter;
	@Getter(AccessLevel.PACKAGE)
	private boolean vangHighlight;
	@Getter(AccessLevel.PACKAGE)
	private boolean vangHealth;
	@Getter(AccessLevel.PACKAGE)
	private boolean configPrayAgainstOlm;
	@Getter(AccessLevel.PACKAGE)
	private boolean timers;
	@Getter(AccessLevel.PACKAGE)
	private boolean tpOverlay;
	@Getter(AccessLevel.PACKAGE)
	private boolean olmTick;
	@Getter(AccessLevel.PACKAGE)
	private Color muttaColor;
	@Getter(AccessLevel.PACKAGE)
	private Color guardColor;
	@Getter(AccessLevel.PACKAGE)
	private Color tektonColor;
	@Getter(AccessLevel.PACKAGE)
	private Color burnColor;
	@Getter(AccessLevel.PACKAGE)
	private Color acidColor;
	@Getter(AccessLevel.PACKAGE)
	private Color tpColor;
	@Getter(AccessLevel.PACKAGE)
	private CoxConfig.FontStyle fontStyle;
	@Getter(AccessLevel.PACKAGE)
	private int textSize;
	@Getter(AccessLevel.PACKAGE)
	private boolean shadows;

	@Provides
	CoxConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CoxConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();
		addSubscriptions();

		overlayManager.add(coxOverlay);
		overlayManager.add(coxInfoBox);
		HandCripple = false;
		hand = null;
		acidTarget = null;
		teleportTarget = null;
		Olm_TP.clear();
		prayAgainstOlm = null;
		burnTarget.clear();
		crippleTimer = 45;
		burnTicks = 40;
		acidTicks = 25;
		teleportTicks = 10;
		vanguards = 0;
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);

		overlayManager.remove(coxOverlay);
		overlayManager.remove(coxInfoBox);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
		eventBus.subscribe(ProjectileMoved.class, this, this::onProjectileMoved);
		eventBus.subscribe(SpotAnimationChanged.class, this, this::onSpotAnimationChanged);
		eventBus.subscribe(NpcSpawned.class, this, this::onNpcSpawned);
		eventBus.subscribe(NpcDespawned.class, this, this::onNpcDespawned);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
	}

	private void onChatMessage(ChatMessage chatMessage)
	{
		if (inRaid())
		{
			if (chatMessage.getType() == ChatMessageType.GAMEMESSAGE)
			{
				Matcher tpMatcher = TP_REGEX.matcher(chatMessage.getMessage());
				if (tpMatcher.matches())
				{
					log.info("TP Matcher has found a match");
					for (Actor actor : client.getPlayers())
					{
						if (actor.getName().equals(tpMatcher.group(1)))
						{
							log.info("Teleport Target Assigned");
							teleportTarget = actor;
						}
					}
				}
				switch (Text.standardize(chatMessage.getMessageNode().getValue()))
				{
					case "the great olm rises with the power of acid.":
					case "the great olm rises with the power of crystal.":
					case "the great olm rises with the power of flame.":
					case "the great olm is giving its all. this is its final stand.":
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
						crippleTimer = 45;
						Olm_NextSpec = -1;
						break;
					case "the great olm fires a sphere of aggression your way. your prayers have been sapped.":
						prayAgainstOlm = PrayAgainst.MELEE;
						lastPrayTime = System.currentTimeMillis();
						break;
					case "the great olm fires a sphere of aggression your way.":
						prayAgainstOlm = PrayAgainst.MELEE;
						lastPrayTime = System.currentTimeMillis();
						break;
					case "the great olm fires a sphere of magical power your way. your prayers have been sapped.":
						prayAgainstOlm = PrayAgainst.MAGIC;
						lastPrayTime = System.currentTimeMillis();
						break;
					case "the great olm fires a sphere of magical power your way.":
						prayAgainstOlm = PrayAgainst.MAGIC;
						lastPrayTime = System.currentTimeMillis();
						break;
					case "the great olm fires a sphere of accuracy and dexterity your way. your prayers have been sapped.":
						prayAgainstOlm = PrayAgainst.RANGED;
						lastPrayTime = System.currentTimeMillis();
						break;
					case "the great olm fires a sphere of accuracy and dexterity your way.":
						prayAgainstOlm = PrayAgainst.RANGED;
						lastPrayTime = System.currentTimeMillis();
						break;
					case "the great olm's left claw clenches to protect itself temporarily.":
						HandCripple = true;

				}
			}
		}
	}

	private void onProjectileMoved(ProjectileMoved event)
	{
		if (inRaid())
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
				acidTarget = projectile.getInteracting();
			}
		}
	}

	private void onSpotAnimationChanged(SpotAnimationChanged graphicChanged)
	{
		if (inRaid())
		{
			Actor actor = graphicChanged.getActor();
			if (actor.getSpotAnimation() == GraphicID.OLM_BURN)
			{
				if (!burnTarget.contains(actor))
				{
					burnTarget.add(actor);
				}
			}
		}
	}

	private void onNpcSpawned(NpcSpawned npcSpawned)
	{
		if (inRaid())
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
					npcContainer.put(npc, new NPCContainer(npc));
					tektonAttackTicks = 27;
					break;
				case NpcID.MUTTADILE:
				case NpcID.MUTTADILE_7562:
				case NpcID.MUTTADILE_7563:
				case NpcID.GUARDIAN:
				case NpcID.GUARDIAN_7570:
					npcContainer.put(npc, new NPCContainer(npc));
					break;
				case NpcID.VANGUARD:
				case NpcID.VANGUARD_7526:
				case NpcID.VANGUARD_7527:
				case NpcID.VANGUARD_7528:
				case NpcID.VANGUARD_7529:
					vanguards++;
					npcContainer.put(npc, new NPCContainer(npc));
					break;
				case NpcID.GREAT_OLM_LEFT_CLAW:
				case NpcID.GREAT_OLM_LEFT_CLAW_7555:
					hand = npc;
					break;
			}
		}
	}

	private void onNpcDespawned(NpcDespawned event)
	{
		if (inRaid())
		{
			NPC npc = event.getNpc();
			switch (npc.getId())
			{
				case NpcID.TEKTON:
				case NpcID.TEKTON_7541:
				case NpcID.TEKTON_7542:
				case NpcID.TEKTON_7545:
				case NpcID.TEKTON_ENRAGED:
				case NpcID.TEKTON_ENRAGED_7544:
				case NpcID.MUTTADILE:
				case NpcID.MUTTADILE_7562:
				case NpcID.MUTTADILE_7563:
				case NpcID.GUARDIAN:
				case NpcID.GUARDIAN_7570:
				case NpcID.GUARDIAN_7571:
				case NpcID.GUARDIAN_7572:
					if (npcContainer.remove(event.getNpc()) != null && !npcContainer.isEmpty())
					{
						npcContainer.remove(event.getNpc());
					}
					break;
				case NpcID.VANGUARD:
				case NpcID.VANGUARD_7526:
				case NpcID.VANGUARD_7527:
				case NpcID.VANGUARD_7528:
				case NpcID.VANGUARD_7529:
					if (npcContainer.remove(event.getNpc()) != null && !npcContainer.isEmpty())
					{
						npcContainer.remove(event.getNpc());
					}
					vanguards--;
					break;
				case NpcID.GREAT_OLM_RIGHT_CLAW_7553:
				case NpcID.GREAT_OLM_RIGHT_CLAW:
					HandCripple = false;
					break;
			}
		}
	}

	private void onGameTick(GameTick event)
	{
		if (!inRaid())
		{
			needOlm = false;
			OlmPhase = 0;
			sleepcount = 0;
			Olm_Heal.clear();
			npcContainer.clear();
			burnTarget.clear();
			Olm_NPC = null;
			hand = null;
			prayAgainstOlm = null;
			runOlm = false;
			return;
		}

		npcHandler();

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

		if (teleportTarget != null)
		{
			log.info(teleportTarget.getName());
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

		if (acidTarget != null)
		{
			acidTicks--;
			if (acidTicks <= 0)
			{
				acidTarget = null;
				acidTicks = 25;
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

		if (HandCripple)
		{
			crippleTimer--;
			if (crippleTimer <= 0)
			{
				HandCripple = false;
				crippleTimer = 45;
			}
		}

		if (runOlm)
		{
			olmHandler();
		}
	}

	private void npcHandler()
	{
		for (NPCContainer npcs : getNpcContainer().values())
		{
			switch (npcs.getNpc().getId())
			{
				case NpcID.TEKTON:
				case NpcID.TEKTON_7541:
				case NpcID.TEKTON_7542:
				case NpcID.TEKTON_7545:
				case NpcID.TEKTON_ENRAGED:
				case NpcID.TEKTON_ENRAGED_7544:
					npcs.setTicksUntilAttack(npcs.getTicksUntilAttack() - 1);
					npcs.setAttackStyle(NPCContainer.Attackstyle.MELEE);
					switch (npcs.getNpc().getAnimation())
					{
						case AnimationID.TEKTON_AUTO1:
						case AnimationID.TEKTON_AUTO2:
						case AnimationID.TEKTON_AUTO3:
						case AnimationID.TEKTON_ENRAGE_AUTO1:
						case AnimationID.TEKTON_ENRAGE_AUTO2:
						case AnimationID.TEKTON_ENRAGE_AUTO3:
							tektonActive = true;
							if (npcs.getTicksUntilAttack() < 1)
							{
								npcs.setTicksUntilAttack(4);
							}
							break;
						case AnimationID.TEKTON_FAST_AUTO1:
						case AnimationID.TEKTON_FAST_AUTO2:
							tektonActive = true;
							if (npcs.getTicksUntilAttack() < 1)
							{
								npcs.setTicksUntilAttack(3);
							}
							break;
						case AnimationID.TEKTON_ANVIL:
							tektonActive = false;
							tektonAttackTicks = 47;
							if (npcs.getTicksUntilAttack() < 1)
							{
								npcs.setTicksUntilAttack(15);
							}
					}
					break;
				case NpcID.GUARDIAN:
				case NpcID.GUARDIAN_7570:
				case NpcID.GUARDIAN_7571:
				case NpcID.GUARDIAN_7572:
					npcs.setTicksUntilAttack(npcs.getTicksUntilAttack() - 1);
					npcs.setAttackStyle(NPCContainer.Attackstyle.MELEE);
					if (npcs.getNpc().getAnimation() == ANIMATION_ID_G1 &&
						npcs.getTicksUntilAttack() < 1)
					{
						npcs.setTicksUntilAttack(5);
					}
					break;
				case NpcID.VANGUARD_7529:
					if (npcs.getAttackStyle() == NPCContainer.Attackstyle.UNKNOWN)
					{
						npcs.setAttackStyle(NPCContainer.Attackstyle.MAGE);
					}
					break;
				case NpcID.VANGUARD_7528:
					if (npcs.getAttackStyle() == NPCContainer.Attackstyle.UNKNOWN)
					{
						npcs.setAttackStyle(NPCContainer.Attackstyle.RANGE);
					}
					break;
				case NpcID.VANGUARD_7527:
					if (npcs.getAttackStyle() == NPCContainer.Attackstyle.UNKNOWN)
					{
						npcs.setAttackStyle(NPCContainer.Attackstyle.MELEE);
					}
					break;
			}
		}
		if (tektonActive && tektonAttackTicks > 0)
		{
			tektonAttackTicks--;
		}
	}

	private void olmHandler()
	{
		Olm_Crystals.clear();
		Olm_Heal.clear();
		Olm_TP.clear();
		client.clearHintArrow();
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
			if (o.getId() == GraphicID.OLM_CRYSTAL)
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
			if (o.getId() == GraphicID.OLM_TELEPORT)
			{
				Olm_TP.add(WorldPoint.fromLocal(client, o.getLocation()));
			}
			if (o.getId() == GraphicID.OLM_HEAL)
			{
				Olm_Heal.add(WorldPoint.fromLocal(client, o.getLocation()));
			}
			if (!Olm_TP.isEmpty())
			{
				teleportTicks--;
				if (teleportTicks <= 0)
				{
					client.clearHintArrow();
					teleportTicks = 10;
				}
			}
		}
	}

	boolean inRaid()
	{
		return client.getVar(Varbits.IN_RAID) == 1;
	}

	private void onConfigChanged(ConfigChanged configChanged)
	{
		if (configChanged.getGroup().equals("Cox"))
		{
			updateConfig();
		}
	}

	private void updateConfig()
	{
		this.muttadile = config.muttadile();
		this.tekton = config.tekton();
		this.tektonTickCounter = config.tektonTickCounter();
		this.guardians = config.guardians();
		this.guardinTickCounter = config.guardinTickCounter();
		this.vangHighlight = config.vangHighlight();
		this.vangHealth = config.vangHealth();
		this.configPrayAgainstOlm = config.prayAgainstOlm();
		this.timers = config.timers();
		this.tpOverlay = config.tpOverlay();
		this.olmTick = config.olmTick();
		this.muttaColor = config.muttaColor();
		this.guardColor = config.guardColor();
		this.tektonColor = config.tektonColor();
		this.burnColor = config.burnColor();
		this.acidColor = config.acidColor();
		this.tpColor = config.tpColor();
		this.fontStyle = config.fontStyle();
		this.textSize = config.textSize();
		this.shadows = config.shadows();
	}
}
