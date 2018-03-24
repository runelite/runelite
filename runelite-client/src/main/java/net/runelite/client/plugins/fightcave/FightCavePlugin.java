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
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Query;
import net.runelite.api.queries.NPCQuery;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.QueryRunner;

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

	private NPC findJad()
	{
		Query query = new NPCQuery().nameContains("TzTok-Jad");
		NPC[] result = queryRunner.runQuery(query);
		return result.length >= 1 ? result[0] : null;
	}

	JadAttack getAttack()
	{
		return attack;
	}
}
