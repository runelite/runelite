/*
 * Copyright (c) 2018, https://runelitepl.us
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
package net.runelite.client.plugins.vorkath;

import java.awt.image.BufferedImage;
import javax.inject.Inject;
import lombok.Getter;
import api.AnimationID;
import api.Client;
import api.GameState;
import api.NPC;
import api.NpcID;
import api.events.GameStateChanged;
import api.events.GameTick;
import api.events.NpcDespawned;
import api.events.NpcSpawned;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Vorkath Helper",
	description = "Count vorkath attacks, and which phase is coming next",
	tags = {"combat", "overlay", "pve", "pvm"},
	type = PluginType.PVM
)
public class VorkathPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private VorkathOverlay overlay;

	@Inject
	private ZombifiedSpawnOverlay SpawnOverlay;

	@Inject
	private ClientThread clientThread;

	@Getter
	private Vorkath vorkath;

	@Getter
	private ZombifiedSpawn spawn;

	static final BufferedImage ACID;
	static final BufferedImage ICE;
	static final BufferedImage MAGERANGE;

	static
	{
		ACID = ImageUtil.getResourceStreamFromClass(VorkathPlugin.class, "acid.png");
		ICE = ImageUtil.getResourceStreamFromClass(VorkathPlugin.class, "ice.png");
		MAGERANGE = ImageUtil.getResourceStreamFromClass(VorkathPlugin.class, "magerange.png");
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
		overlayManager.add(SpawnOverlay);
		clientThread.invoke(this::reset);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
		overlayManager.remove(SpawnOverlay);
	}

	private void reset()
	{
		this.vorkath = null;
		for (NPC npc : client.getNpcs())
		{
			if (isNpcVorkath(npc.getId()))
			{
				this.vorkath = new Vorkath(npc);
			}
			else if (isNpcZombifiedSpawn(npc.getId()))
			{
				this.spawn = new ZombifiedSpawn(npc);
			}
		}
	}

	private static boolean isNpcVorkath(int npcId)
	{
		return npcId == NpcID.VORKATH ||
			npcId == NpcID.VORKATH_8058 ||
			npcId == NpcID.VORKATH_8059 ||
			npcId == NpcID.VORKATH_8060 ||
			npcId == NpcID.VORKATH_8061;
	}

	private static boolean isNpcZombifiedSpawn(int id)
	{
		return id == NpcID.ZOMBIFIED_SPAWN ||
			id == NpcID.ZOMBIFIED_SPAWN_8063;
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		NPC npc = event.getNpc();
		if (isNpcVorkath(npc.getId()))
		{
			this.vorkath = new Vorkath(npc);
		}
		else if (isNpcZombifiedSpawn(npc.getId()))
		{
			this.spawn = new ZombifiedSpawn(npc);
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		final NPC npc = npcDespawned.getNpc();
		if (this.vorkath != null)
		{
			if (npc.getId() == this.vorkath.getNpc().getId())
			{
				this.vorkath = null;
				reset();
			}
		}

		if (this.spawn != null)
		{
			if (npc.getId() == this.spawn.getNpc().getId())
			{
				this.spawn = null;
			}
		}
	}


	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		GameState gs = event.getGameState();
		if (gs == GameState.LOGGING_IN ||
			gs == GameState.CONNECTION_LOST ||
			gs == GameState.HOPPING)
		{
			reset();
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (vorkath != null)
		{
			int animationId = vorkath.getNpc().getAnimation();

			if (animationId != vorkath.getLastTickAnimation())
			{
				if (animationId == AnimationID.VORKATH_ACID_ATTACK)
				{
					vorkath.setPhase(2);
					vorkath.setAttacksUntilSwitch(Vorkath.ATTACKS_PER_SWITCH);
				}
				else if (animationId == AnimationID.VORKATH_ATTACK && vorkath.getAttacksUntilSwitch() == 0)
				{
					vorkath.setPhase(1);
					vorkath.setAttacksUntilSwitch(Vorkath.ATTACKS_PER_SWITCH);
					//Vorkath does a bomb animation after the ice dragon breathe, we need to account for it
					vorkath.setIcePhaseAttack(true);
				}
				else if (animationId == AnimationID.VORKATH_ATTACK || animationId == AnimationID.VORKATH_FIRE_BOMB_ATTACK)
				{
					if (vorkath.isIcePhaseAttack())
					{
						vorkath.setIcePhaseAttack(false);
					}
					else
					{
						vorkath.setAttacksUntilSwitch(vorkath.getAttacksUntilSwitch() - 1);
					}
				}
			}

			vorkath.setLastTickAnimation(animationId);
		}
	}
}
