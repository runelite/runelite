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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import net.runelite.api.events.ProjectileSpawned;
import net.runelite.api.events.SpotAnimationChanged;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.api.util.Text;

@PluginDescriptor(
	name = "CoX Helper",
	description = "All-in-one plugin for Chambers of Xeric",
	tags = {"CoX", "chamber", "xeric", "helper"},
	type = PluginType.PVM,
	enabledByDefault = false
)

@Slf4j
@Singleton
@Getter(AccessLevel.PACKAGE)
public class CoxPlugin extends Plugin
{
	private static final int ANIMATION_ID_G1 = 430;
	private static final Pattern TP_REGEX = Pattern.compile("You have been paired with <col=ff0000>(.*)</col>! The magical power will enact soon...");
	@Inject
	@Getter(AccessLevel.NONE)
	private Client client;
	@Inject
	@Getter(AccessLevel.NONE)
	private ChatMessageManager chatMessageManager;
	@Inject
	@Getter(AccessLevel.NONE)
	private CoxOverlay coxOverlay;
	@Inject
	@Getter(AccessLevel.NONE)
	private CoxInfoBox coxInfoBox;
	@Inject
	@Getter(AccessLevel.NONE)
	private CoxConfig config;
	@Inject
	@Getter(AccessLevel.NONE)
	private OverlayManager overlayManager;
	@Inject
	@Getter(AccessLevel.NONE)
	private EventBus eventBus;
	private boolean handCripple;
	private boolean runOlm;
	private int vanguards;
	private boolean tektonActive;
	private NPC hand;
	private NPC Olm_NPC;
	private List<WorldPoint> Olm_Heal = new ArrayList<>();
	private List<WorldPoint> Olm_TP = new ArrayList<>();
	private Set<Victim> victims = new HashSet<>();
	private Actor acidTarget;
	private int crippleTimer = 45;
	private int teleportTicks = 10;
	private int tektonAttackTicks;
	private int OlmPhase = 0;
	private int Olm_TicksUntilAction = -1;
	private int Olm_ActionCycle = -1; //4:0 = auto 3:0 = null 2:0 = auto 1:0 = spec + actioncycle =4
	private int Olm_NextSpec = -1; // 1= crystals 2=lightnig 3=portals 4= heal hand if p4
	private Map<NPC, NPCContainer> npcContainer = new HashMap<>();
	@Setter(AccessLevel.PACKAGE)
	private PrayAgainst prayAgainstOlm;
	private long lastPrayTime;
	private int sleepcount = 0;
	private boolean muttadile;
	private boolean tekton;
	private boolean tektonTickCounter;
	private boolean guardians;
	private boolean guardinTickCounter;
	private boolean vangHighlight;
	private boolean vangHealth;
	private boolean configPrayAgainstOlm;
	private boolean timers;
	private boolean tpOverlay;
	private boolean olmTick;
	private int prayAgainstSize;
	private Color muttaColor;
	private Color guardColor;
	private Color tektonColor;
	private Color burnColor;
	private Color acidColor;
	private Color tpColor;
	private CoxConfig.FontStyle fontStyle;
	private int textSize;
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
		handCripple = false;
		hand = null;
		Olm_TP.clear();
		prayAgainstOlm = null;
		victims.clear();
		crippleTimer = 45;
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
		eventBus.subscribe(ProjectileSpawned.class, this, this::onProjectileSpawned);
		eventBus.subscribe(SpotAnimationChanged.class, this, this::onSpotAnimationChanged);
		eventBus.subscribe(NpcSpawned.class, this, this::onNpcSpawned);
		eventBus.subscribe(NpcDespawned.class, this, this::onNpcDespawned);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("Cox"))
		{
			updateConfig();
		}
	}

	private void onChatMessage(ChatMessage event)
	{
		if (!inRaid())
		{
			return;
		}

		if (event.getType() == ChatMessageType.GAMEMESSAGE)
		{
			final Matcher tpMatcher = TP_REGEX.matcher(event.getMessage());

			if (tpMatcher.matches())
			{
				for (Player player : client.getPlayers())
				{
					final String rawPlayerName = player.getName();

					if (rawPlayerName != null)
					{
						final String fixedPlayerName = Text.sanitize(rawPlayerName);

						if (fixedPlayerName.equals(tpMatcher.group(1)))
						{
							victims.add(new Victim(player, Victim.Type.TELEPORT));
						}
					}
				}
			}

			switch (Text.standardize(event.getMessageNode().getValue()))
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
					crippleTimer = 45;
					Olm_NextSpec = -1;
					break;
				case "the great olm fires a sphere of aggression your way. your prayers have been sapped.":
				case "the great olm fires a sphere of aggression your way.":
					prayAgainstOlm = PrayAgainst.MELEE;
					lastPrayTime = System.currentTimeMillis();
					break;
				case "the great olm fires a sphere of magical power your way. your prayers have been sapped.":
				case "the great olm fires a sphere of magical power your way.":
					prayAgainstOlm = PrayAgainst.MAGIC;
					lastPrayTime = System.currentTimeMillis();
					break;
				case "the great olm fires a sphere of accuracy and dexterity your way. your prayers have been sapped.":
				case "the great olm fires a sphere of accuracy and dexterity your way.":
					prayAgainstOlm = PrayAgainst.RANGED;
					lastPrayTime = System.currentTimeMillis();
					break;
				case "the great olm's left claw clenches to protect itself temporarily.":
					handCripple = true;

			}
		}
	}

	private void onProjectileSpawned(ProjectileSpawned event)
	{
		if (!inRaid())
		{
			return;
		}

		final Projectile projectile = event.getProjectile();

		switch (projectile.getId())
		{
			case ProjectileID.OLM_MAGE_ATTACK:
				prayAgainstOlm = PrayAgainst.MAGIC;
				lastPrayTime = System.currentTimeMillis();
				break;
			case ProjectileID.OLM_RANGE_ATTACK:
				prayAgainstOlm = PrayAgainst.RANGED;
				lastPrayTime = System.currentTimeMillis();
				break;
			case ProjectileID.OLM_ACID_TRAIL:
				acidTarget = projectile.getInteracting();
				break;
		}
	}

	private void onSpotAnimationChanged(SpotAnimationChanged event)
	{
		if (!inRaid())
		{
			return;
		}

		if (!(event.getActor() instanceof Player))
		{
			return;
		}

		final Player player = (Player) event.getActor();

		if (player.getSpotAnimation() == GraphicID.OLM_BURN)
		{
			int add = 0;

			for (Victim victim : victims)
			{
				if (victim.getPlayer().getName().equals(player.getName()))
				{
					add++;
				}
			}

			if (add == 0)
			{
				victims.add(new Victim(player, Victim.Type.BURN));
			}
		}
	}

	private void onNpcSpawned(NpcSpawned event)
	{
		if (!inRaid())
		{
			return;
		}

		final NPC npc = event.getNpc();

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
			case NpcID.GREAT_OLM:
				Olm_NPC = npc;
		}
	}

	private void onNpcDespawned(NpcDespawned event)
	{
		if (!inRaid())
		{
			return;
		}

		final NPC npc = event.getNpc();

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
				handCripple = false;
				break;
		}
	}

	private void onGameTick(GameTick event)
	{
		if (!inRaid())
		{
			OlmPhase = 0;
			sleepcount = 0;
			Olm_Heal.clear();
			npcContainer.clear();
			victims.clear();
			Olm_NPC = null;
			hand = null;
			prayAgainstOlm = null;
			runOlm = false;
			return;
		}

		handleNpcs();
		handleVictims();

		if (handCripple)
		{
			crippleTimer--;
			if (crippleTimer <= 0)
			{
				handCripple = false;
				crippleTimer = 45;
			}
		}

		if (runOlm)
		{
			handleOlm();
		}
	}

	private void handleVictims()
	{
		if (victims.size() > 0)
		{
			victims.forEach(Victim::updateTicks);
			victims.removeIf(victim -> victim.getTicks() <= 0);
		}
	}

	private void handleNpcs()
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

	private void handleOlm()
	{
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
		this.prayAgainstSize = config.prayAgainstOlmSize();
	}
}
