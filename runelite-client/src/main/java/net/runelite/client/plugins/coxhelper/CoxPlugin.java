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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.api.util.Text;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import org.apache.commons.lang3.ArrayUtils;


@PluginDescriptor(
	name = "CoX Helper",
	enabledByDefault = false,
	description = "All-in-one plugin for Chambers of Xeric",
	tags = {"CoX", "chamber", "xeric", "helper"}
)
@Slf4j
@Getter(AccessLevel.PACKAGE)
public class CoxPlugin extends Plugin
{
	private static final int ANIMATION_ID_G1 = 430;
	private static final Pattern TP_REGEX = Pattern.compile("You have been paired with <col=ff0000>(.*)</col>! The magical power will enact soon...");
	private final Map<NPC, NPCContainer> npcContainers = new HashMap<>();
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
	private CoxDebugBox coxDebugBox;
	@Inject
	@Getter(AccessLevel.NONE)
	private CoxConfig config;
	@Inject
	@Getter(AccessLevel.NONE)
	private OverlayManager overlayManager;
	@Inject
	@Getter(AccessLevel.NONE)
	private EventBus eventBus;
	@Inject
	private Olm olm;
	//other
	private int vanguards;
	private boolean tektonActive;
	private int tektonAttackTicks;

	@Provides
	CoxConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CoxConfig.class);
	}

	@Override
	protected void startUp()
	{
		this.overlayManager.add(this.coxOverlay);
		this.overlayManager.add(this.coxInfoBox);
		this.overlayManager.add(this.coxDebugBox);
		this.olm.hardRest();
	}

	@Override
	protected void shutDown()
	{
		this.overlayManager.remove(this.coxOverlay);
		this.overlayManager.remove(this.coxInfoBox);
		this.overlayManager.remove(this.coxDebugBox);
	}

	@Subscribe
	private void onChatMessage(ChatMessage event)
	{
		if (!this.inRaid())
		{
			return;
		}

		if (event.getType() == ChatMessageType.GAMEMESSAGE)
		{
			final Matcher tpMatcher = TP_REGEX.matcher(event.getMessage());

			if (tpMatcher.matches())
			{
				for (Player player : this.client.getPlayers())
				{
					final String rawPlayerName = player.getName();

					if (rawPlayerName != null)
					{
						final String fixedPlayerName = Text.sanitize(rawPlayerName);

						if (fixedPlayerName.equals(Text.sanitize(tpMatcher.group(1))))
						{
							this.olm.getVictims().add(new Victim(player, Victim.Type.TELEPORT));
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
					//TODO: detect olm phase
					break;
				case "the great olm fires a sphere of aggression your way. your prayers have been sapped.":
				case "the great olm fires a sphere of aggression your way.":
					this.olm.setPrayer(PrayAgainst.MELEE);
					break;
				case "the great olm fires a sphere of magical power your way. your prayers have been sapped.":
				case "the great olm fires a sphere of magical power your way.":
					this.olm.setPrayer(PrayAgainst.MAGIC);
					break;
				case "the great olm fires a sphere of accuracy and dexterity your way. your prayers have been sapped.":
				case "the great olm fires a sphere of accuracy and dexterity your way.":
					this.olm.setPrayer(PrayAgainst.RANGED);
					break;
			}
		}
	}

	@Subscribe
	private void onProjectileSpawned(ProjectileSpawned event)
	{
		if (!this.inRaid())
		{
			return;
		}

		final Projectile projectile = event.getProjectile();

		switch (projectile.getId())
		{
			case ProjectileID.OLM_MAGE_ATTACK:
				this.olm.setPrayer(PrayAgainst.MAGIC);
				break;
			case ProjectileID.OLM_RANGE_ATTACK:
				this.olm.setPrayer(PrayAgainst.RANGED);
				break;
			case ProjectileID.OLM_ACID_TRAIL:
				this.olm.setAcidTarget(projectile.getInteracting());
				break;
		}
	}

	@Subscribe
	private void onSpotAnimationChanged(SpotAnimationChanged event)
	{
		if (!this.inRaid())
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

			for (Victim victim : this.olm.getVictims())
			{
				if (victim.getPlayer().getName().equals(player.getName()))
				{
					add++;
				}
			}

			if (add == 0)
			{
				this.olm.getVictims().add(new Victim(player, Victim.Type.BURN));
			}
		}
	}


//	private void handleOlm(GameTick event) {
//		if(event != null) {
//			NPC event = event.getTransformedDefinition();
//			switch (event.getId()) {
//				case NpcID.GREAT_OLM_7554:
//				case NpcID.GREAT_OLM:
//					switch (event.getAnimation()) {
//						case OlmID.OLM_RISING_1:
//						case OlmID.OLM_RISING_2:
//						case OlmID.OLM_MIDDLE: {
//							this.olm.setHead(event);
////							this.olm.setHead(npcs.getNpc().getAnimation());
//						}
//					}
//				case NpcID.GREAT_OLM_LEFT_CLAW:
//				case NpcID.GREAT_OLM_LEFT_CLAW_7555:
//					log.warn("LEft animations:" + event.getAnimation());
//					switch (event.getAnimation()) {
////						case OlmID.Ol:
////						case OlmID.OLM_RISING_2:
////						case OlmID.OLM_MIDDLE: {
////							this.olm.setHead(npcs.getNpc().getAnimation());
////						}
//					}
//			}
//		}
//	}

	@Subscribe
	private void onNpcSpawned(NpcSpawned event)
	{
		if (!this.inRaid())
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
				this.npcContainers.put(npc, new NPCContainer(npc));
				this.tektonAttackTicks = 27;
				break;
			case NpcID.MUTTADILE:
			case NpcID.MUTTADILE_7562:
			case NpcID.MUTTADILE_7563:
			case NpcID.GUARDIAN:
			case NpcID.GUARDIAN_7570:
				this.npcContainers.put(npc, new NPCContainer(npc));
				break;
			case NpcID.VANGUARD:
			case NpcID.VANGUARD_7526:
			case NpcID.VANGUARD_7527:
			case NpcID.VANGUARD_7528:
			case NpcID.VANGUARD_7529:
				this.vanguards++;
				this.npcContainers.put(npc, new NPCContainer(npc));
				break;
		}
	}

	@Subscribe
	private void onNpcDespawned(NpcDespawned event)
	{
		if (!this.inRaid())
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
				if (this.npcContainers.remove(event.getNpc()) != null && !this.npcContainers.isEmpty())
				{
					this.npcContainers.remove(event.getNpc());
				}
				break;
			case NpcID.VANGUARD:
			case NpcID.VANGUARD_7526:
			case NpcID.VANGUARD_7527:
			case NpcID.VANGUARD_7528:
			case NpcID.VANGUARD_7529:
				if (this.npcContainers.remove(event.getNpc()) != null && !this.npcContainers.isEmpty())
				{
					this.npcContainers.remove(event.getNpc());
				}
				this.vanguards--;
				break;
		}
	}

	@Subscribe
	private void onGameTick(GameTick event)
	{
		if (!this.inRaid())
		{
			this.olm.hardRest();
			return;
		}

		this.handleNpcs();
		this.doOlm();
		if (this.olm.isActive())
		{
			this.olm.update();
		}
	}

	private void handleNpcs()
	{
		for (NPCContainer npcs : this.getNpcContainers().values())
		{
//			log.warn("NPC: "+ npcs.getNpc().getName());
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
							this.tektonActive = true;
							if (npcs.getTicksUntilAttack() < 1)
							{
								npcs.setTicksUntilAttack(4);
							}
							break;
						case AnimationID.TEKTON_FAST_AUTO1:
						case AnimationID.TEKTON_FAST_AUTO2:
							this.tektonActive = true;
							if (npcs.getTicksUntilAttack() < 1)
							{
								npcs.setTicksUntilAttack(3);
							}
							break;
						case AnimationID.TEKTON_ANVIL:
							this.tektonActive = false;
							this.tektonAttackTicks = 47;
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
		if (this.tektonActive && this.tektonAttackTicks > 0)
		{
			this.tektonAttackTicks--;
		}
	}

	boolean inRaid()
	{
		return this.client.getVar(Varbits.IN_RAID) == 1;
	}

	private void doOlm()
	{
		List<NPC> npcs = client.getNpcs();
		for (NPC npc : npcs)
		{
			log.warn("NPC: "+ npc.getName());
//			NPCDefinition composition = npc.getDefinition();
		{
//			log.warn("NPC: "+ composition);
//		if (composition == null)
//		{
//			return;
//		}

		int id = npc.getId();

		switch (id)
		{
			case NpcID.GREAT_OLM_7554:
			case NpcID.GREAT_OLM:
				if (this.olm.getHead() == null)
				{
					this.olm.startPhase();
				}
				this.olm.setHead(npc);
				break;
			case NpcID.GREAT_OLM_LEFT_CLAW:
			case NpcID.GREAT_OLM_LEFT_CLAW_7555:
				this.olm.setHand(npc);
				break;
		}
//		ObjectComposition npc = client.getObjectDefinition(OlmID.OLM_HEAD_GAMEOBJECT_READY);
//		for (ObjectComposition npc : npcs)
//		{
//		log.warn("NPC: "+ npc.getName());
//		switch ((npc.getId())) {
//			case NpcID.GREAT_OLM_7554:
//			case NpcID.GREAT_OLM:
////				switch (npc.getAnimation()) {
////					case OlmID.OLM_RISING_1:
////					case OlmID.OLM_RISING_2:
////					case OlmID.OLM_MIDDLE: {
//						this.olm.setHead(npc);
//						log.warn("NPC: "+ npc.getId());
//							this.olm.setHead(npcs.getNpc().getAnimation());
//					}
//				}
//			case NpcID.GREAT_OLM_LEFT_CLAW:
//			case NpcID.GREAT_OLM_LEFT_CLAW_7555:
////				log.warn("LEft animations:" + npc.getAnimation());
//				switch (npc.getAnimation()) {
////						case OlmID.Ol:
////						case OlmID.OLM_RISING_2:
////						case OlmID.OLM_MIDDLE: {
////							this.olm.setHead(npcs.getNpc().getAnimation());
////						}
//				}
		}
		}
	}



	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("Cox"))
		{
			return;
		}

		if (event.getKey().equals("mirrorMode"))
		{
			this.coxOverlay.determineLayer();
			this.coxInfoBox.determineLayer();
			this.coxDebugBox.determineLayer();
			this.overlayManager.remove(this.coxOverlay);
			this.overlayManager.remove(this.coxInfoBox);
			this.overlayManager.remove(this.coxDebugBox);
			this.overlayManager.add(this.coxOverlay);
			this.overlayManager.add(this.coxInfoBox);
			this.overlayManager.add(this.coxDebugBox);
		}
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		if (event.getGameObject() == null)
		{
			return;
		}

		int id = event.getGameObject().getId();

//		switch (id)
//		{
//			case OlmID.OLM_HEAD_GAMEOBJECT_RISING:
//			case OlmID.OLM_HEAD_GAMEOBJECT_READY:
//				if (this.olm.getHead() == null)
//				{
//					this.olm.startPhase();
//				}
//				this.olm.setHead(event.getNpcDefinition());
//				break;
//			case OlmID.OLM_LEFT_HAND_GAMEOBJECT_RISING:
//			case OlmID.OLM_LEFT_HAND_GAMEOBJECT_READY:
//				this.olm.setHand(event.getNpcDefinition());
//				break;
//		}
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		if (event.getGameObject() == null)
		{
			return;
		}

		int id = event.getGameObject().getId();
		if (id == OlmID.OLM_HEAD_GAMEOBJECT_READY)
		{
			this.olm.setHead(null);
		}
	}
}