/*
 * Copyright (c) 2018, GeChallengeM <https://github.com/GeChallengeM>
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
package net.runelite.client.plugins.npcstatus;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

@Singleton
public class NpcStatusOverlay extends Overlay
{
	private final Client client;
	private final NpcStatusPlugin plugin;

	@Inject
	NpcStatusOverlay(final Client client, final NpcStatusPlugin plugin)
	{
		this.client = client;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		for (MemorizedNPC npc : plugin.getMemorizedNPCs())
		{
			if (npc.getNpc().getInteracting() == client.getLocalPlayer() || client.getLocalPlayer().getInteracting() == npc.getNpc())
			{
				switch (npc.getStatus())
				{
					case FLINCHING:
						npc.setTimeLeft(Math.max(0, npc.getFlinchTimerEnd() - client.getTickCount()));
						break;
					case IN_COMBAT_DELAY:
						npc.setTimeLeft(Math.max(0, npc.getCombatTimerEnd() - client.getTickCount() - 7));
						break;
					case IN_COMBAT:
						npc.setTimeLeft(Math.max(0, npc.getCombatTimerEnd() - client.getTickCount()));
						break;
					case OUT_OF_COMBAT:
					default:
						npc.setTimeLeft(0);
						break;
				}

				Point textLocation = npc.getNpc().getCanvasTextLocation(graphics, Integer.toString(npc.getTimeLeft()), npc.getNpc().getLogicalHeight() + 40);

				if (textLocation != null)
				{
					OverlayUtil.renderTextLocation(graphics, textLocation, Integer.toString(npc.getTimeLeft()), npc.getStatus().getColor());
				}
			}
		}
		return null;
	}
}