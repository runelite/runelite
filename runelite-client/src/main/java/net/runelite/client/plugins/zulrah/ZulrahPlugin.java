/*
 * Copyright (c) 2018, Devin French <https://github.com/devinfrench>
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
package net.runelite.client.plugins.zulrah;

import com.google.inject.Binder;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.queries.NPCQuery;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.zulrah.overlays.ZulrahRotationOverlay;
import net.runelite.client.plugins.zulrah.overlays.ZulrahTileOverlay;
import net.runelite.client.plugins.zulrah.phase.ZulrahPhase;
import net.runelite.client.plugins.zulrah.rotation.ZulrahRotation;
import net.runelite.client.plugins.zulrah.rotation.ZulrahRotationFour;
import net.runelite.client.plugins.zulrah.rotation.ZulrahRotationOne;
import net.runelite.client.plugins.zulrah.rotation.ZulrahRotationThree;
import net.runelite.client.plugins.zulrah.rotation.ZulrahRotationTwo;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.QueryRunner;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;

@PluginDescriptor(
  name = "Zulrah"
)
@Slf4j
public class ZulrahPlugin extends Plugin
{
	private ZulrahRotation[] rotations = new ZulrahRotation[]
	  {
		new ZulrahRotationOne(),
		new ZulrahRotationTwo(),
		new ZulrahRotationThree(),
		new ZulrahRotationFour()
	  };

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ZulrahTileOverlay tileOverlay;

	@Inject
	private ZulrahRotationOverlay rotationOverlay;

	@Inject
	private QueryRunner queryRunner;

	private ZulrahInstance instance;

	@Override
	public void configure(Binder binder)
	{
		binder.bind(ZulrahTileOverlay.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(tileOverlay);
		overlayManager.add(rotationOverlay);
	}

	@Schedule(
	  period = 600,
	  unit = ChronoUnit.MILLIS
	)
	public void update()
	{
		NPC zulrah = findZulrah();
		if (zulrah == null)
		{
			if (instance != null)
			{
				log.debug("Zulrah encounter has ended.");
				instance = null;
			}
			return;
		}

		if (instance == null)
		{
			instance = new ZulrahInstance(zulrah);
			log.debug("Zulrah encounter has started.");
		}

		ZulrahPhase phase = ZulrahPhase.valueOf(instance.getStartWorldPoint(), zulrah);
		if (instance.getPhase() == null)
		{
			instance.setPhase(phase);
		}
		else if (!instance.getPhase().equals(phase))
		{
			log.debug("Zulrah phase has moved from {} -> {}, Stage: {}", instance.getPhase(), phase, instance.getStage() + 1);
			instance.setPhase(phase);
			instance.nextStage();
		}

		ZulrahRotation rotation = instance.getRotation();
		if (rotation == null)
		{
			int potential = 0;
			for (ZulrahRotation r : rotations)
			{
				if (r.stageEquals(instance.getStage(), instance.getPhase()))
				{
					potential++;
					rotation = r;
				}
			}
			if (potential == 1)
			{
				log.debug("Zulrah rotation found: {}", rotation);
				instance.setRotation(rotation);
			}
		}
		else if (rotation.canReset(instance.getStage()))
		{
			instance.reset();
		}
	}

	private NPC findZulrah()
	{
		NPC[] result = queryRunner.runQuery(new NPCQuery().nameEquals("Zulrah"));
		return result.length == 1 ? result[0] : null;
	}

	public ZulrahInstance getInstance()
	{
		return instance;
	}
}
