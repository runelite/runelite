/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
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
package net.runelite.client.plugins.fightcave;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import javax.inject.Inject;

import com.google.common.eventbus.Subscribe;
import net.runelite.api.*;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.queries.NPCQuery;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.QueryRunner;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Fight Cave"
)
public class FightCavePlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private QueryRunner queryRunner;

	@Inject
	private FightCaveOverlay overlay;

	private JadAttack attack;

	private static final ArrayList<Integer> FIGHT_CAVE_REGIONS = new ArrayList<Integer>(Arrays.asList(9294, 9295, 9296, 9550, 9551, 9552, 9806, 9807, 9808));

	private static final int[][] WAVE_ENEMIES = {//I could have just written a function, but this is faster to write :shrug:
			{22},
			{22, 22},
			{45},
			{45, 22},
			{45, 22, 22},
			{45, 45},
			{90},
			{90, 22},
			{90, 22, 22},
			{90, 45},
			{90, 45, 22},
			{90, 45, 22, 22},
			{90, 45, 45},
			{90, 90},
			{180},
			{180, 22},
			{180, 22, 22},
			{180, 45},
			{180, 45, 22},
			{180, 45, 22, 22},
			{180, 45, 45},
			{180, 90},
			{180, 90, 22},
			{180, 90, 22, 22},
			{180, 90, 45},
			{180, 90, 45, 22},
			{180, 90, 45, 22, 22},
			{180, 90, 45, 45},
			{180, 90, 90},
			{180, 180},
			{360},
			{360, 22},
			{360, 22, 22},
			{360, 45},
			{360, 45, 22},
			{360, 45, 22, 22},
			{360, 45 ,45},
			{360, 90},
			{360, 90, 22},
			{360, 90, 22, 22},
			{360, 90, 45},
			{360, 90, 45, 22},
			{360, 90, 45, 22, 22},
			{360, 90, 45, 45},
			{360, 90, 90},
			{360, 180},
			{360, 180, 22},
			{360, 180, 22, 22},
			{360, 180, 45},
			{360, 180, 45, 22},
			{360, 180, 45, 22, 22},
			{360, 180, 45, 45},
			{360, 180, 90},
			{360, 180, 90, 22},
			{360, 180, 90, 22, 22},
			{360, 180, 90, 45},
			{360, 180, 90, 45 ,22},
			{360, 180, 90, 45, 22, 22},
			{360, 180, 90, 45, 45},
			{360, 180, 90, 90},
			{360, 180, 180},
			{360, 360}
	};

	private int wave = 0;
	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Schedule(
		period = 600,
		unit = ChronoUnit.MILLIS
	)
	public void update()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		NPC jad = findJad();
		if (jad != null)
		{
			if (jad.getAnimation() == JadAttack.MAGIC.getAnimation())
			{
				attack = JadAttack.MAGIC;
			}
			else if (jad.getAnimation() == JadAttack.RANGE.getAnimation())
			{
				attack = JadAttack.RANGE;
			}
		}
		else
		{
			attack = null;
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() == ChatMessageType.SERVER && isInFightCaves())
		{
			String msg = Text.removeTags(event.getMessage());//.substring(6);
			if(msg.contains("Wave:"))
			{
				this.wave = Integer.parseInt(msg.substring(6));
				return;
			}
		}
	}

	private boolean isInFightCaves()
	{//more like is in city or fight caves, but close enough
		int[] regions = client.getMapRegions();
		for(int i=0; i<regions.length; i++)
		{
			if(FIGHT_CAVE_REGIONS.contains(regions[i]))
			{
				return true;
			}
		}
		return false;
	}

	private NPC findJad()
	{
		Query query = new NPCQuery().nameContains("TzTok-Jad");
		NPC[] result = queryRunner.runQuery(query);
		return result.length >= 1 ? result[0] : null;
	}

	public int[] getEnemies(int wave)
	{
		int index = wave-1;
		if(index >= 0 && index <= 61)
		{
			return WAVE_ENEMIES[index];
		}
		return new int[]{};
	}

	public int getWave()
	{
		if(!isInFightCaves()){
			this.wave = 0;
		}
		return this.wave;
	}

	JadAttack getAttack()
	{
		return attack;
	}
}
