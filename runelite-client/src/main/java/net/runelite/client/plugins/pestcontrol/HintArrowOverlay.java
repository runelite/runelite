/*
 * Copyright (c) 2019, Yani <yani@xenokore.com>
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
package net.runelite.client.plugins.pestcontrol;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

@Singleton
public class HintArrowOverlay extends Overlay
{
	private final PestControlPlugin plugin;
	private final Client client;

	@Inject
	HintArrowOverlay(final PestControlPlugin plugin, final Client client)
	{
		this.plugin = plugin;
		this.client = client;

		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.getGame() == null)
		{
			return null;
		}

		List<NPC> visibleActivePortals = new ArrayList<>();

		for (NPC npc : client.getNpcs())
		{
			if (PestControlNpc.isActivePortalId(npc.getId()))
			{
				visibleActivePortals.add(npc);
			}
		}

		if (!visibleActivePortals.isEmpty())
		{
			NPC closestPortalNpc = getClosestNpc(visibleActivePortals);

			if (closestPortalNpc != null)
			{
				NPC currentHintArrowTarget = client.getHintArrowNpc();

				if (currentHintArrowTarget == null || currentHintArrowTarget != closestPortalNpc)
				{
					client.setHintArrow(closestPortalNpc);
				}
			}

			return null;
		}

		Portal closestActivePortal = getClosestPortal(PortalState.ACTIVE);

		if (closestActivePortal != null)
		{
			WorldPoint currentHintArrowLocation = client.getHintArrowPoint();
			WorldPoint closestActivePortalLocation = closestActivePortal.getLocation();

			if (currentHintArrowLocation == null || currentHintArrowLocation != closestActivePortalLocation)
			{
				client.setHintArrow(closestActivePortalLocation);
			}

			return null;
		}

		Collection<Portal> nextPortalList = plugin.getGame().getNextPortals();

		if (nextPortalList.size() == 1)
		{
			client.setHintArrow(nextPortalList.iterator().next().getLocation());

			return null;
		}

		return null;
	}

	private NPC getClosestNpc(List<NPC> npcList)
	{
		WorldPoint currentLocation = client.getLocalPlayer().getWorldLocation();

		NPC closestNpc = null;
		int currentShortestDistance = 1337;
		int distanceToNpc;

		for (NPC npc : npcList)
		{
			if (closestNpc != null)
			{
				distanceToNpc = npc.getWorldLocation().distanceTo(currentLocation);

				if (distanceToNpc < currentShortestDistance)
				{
					closestNpc = npc;
					currentShortestDistance = distanceToNpc;
				}
			}
			else
			{
				closestNpc = npc;
			}
		}

		return closestNpc;
	}

	private Portal getClosestPortal(PortalState portalState)
	{
		WorldPoint currentLocation = client.getLocalPlayer().getWorldLocation();

		Portal closestPortal = null;
		int currentShortestDistance = 1337;
		int distanceToWorldPoint;

		for (Portal portal : plugin.getGame().getPortals())
		{
			if (portal.getPortalState() != portalState)
			{
				continue;
			}

			distanceToWorldPoint = portal.getLocation().distanceTo(currentLocation);

			if (distanceToWorldPoint < currentShortestDistance)
			{
				closestPortal = portal;
				currentShortestDistance = distanceToWorldPoint;
			}
		}

		return closestPortal;
	}
}
