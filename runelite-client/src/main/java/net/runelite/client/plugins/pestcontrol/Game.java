/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.pestcontrol.Portal.BLUE;
import static net.runelite.client.plugins.pestcontrol.Portal.PURPLE;
import static net.runelite.client.plugins.pestcontrol.Portal.RED;
import static net.runelite.client.plugins.pestcontrol.Portal.YELLOW;

@Slf4j
class Game
{
	// Game starts with all possible rotations
	private Rotation[] possibleRotations = Rotation.values();
	// Number of shields dropped
	private int shieldsDropped;

	@Getter
	private boolean portalLocationsSet = false;

	@Getter
	private PortalContext purple = new PortalContext(PURPLE);
	@Getter
	private PortalContext blue = new PortalContext(BLUE);
	@Getter
	private PortalContext yellow = new PortalContext(YELLOW);
	@Getter
	private PortalContext red = new PortalContext(RED);

	private Client client;

	public Game(Client client)
	{
		this.client = client;
		loadPortalLocations();
	}

	public void updatePortalNpcs()
	{
		boolean searchPurple = !purple.isDead() && purple.getNpc() == null;
		boolean searchBlue = !blue.isDead() && blue.getNpc() == null;
		boolean searchYellow = !yellow.isDead() && yellow.getNpc() == null;
		boolean searchRed = !red.isDead() && red.getNpc() == null;

		if(!searchPurple && !searchBlue && !searchYellow && !searchRed){
			return;
		}

		for(NPC npc : client.getNpcs())
		{
			if(searchPurple && PestControlPlugin.isPurplePortal(npc.getId()))
			{
				purple.setNpc(npc);
				searchPurple = false;
				handlePortalHintArrow(purple, npc);
			}
			if(searchBlue && PestControlPlugin.isBluePortal(npc.getId()))
			{
				blue.setNpc(npc);
				searchBlue = false;
				handlePortalHintArrow(blue, npc);
			}
			if(searchYellow && PestControlPlugin.isYellowPortal(npc.getId()))
			{
				yellow.setNpc(npc);
				searchYellow = false;
				handlePortalHintArrow(yellow, npc);
			}
			if(searchRed && PestControlPlugin.isRedPortal(npc.getId()))
			{
				red.setNpc(npc);
				searchRed = false;
				handlePortalHintArrow(red, npc);
			}
		}
	}

	private void handlePortalHintArrow(PortalContext portal, NPC npc)
	{
		if(!client.hasHintArrow())
		{
			return;
		}

		WorldPoint worldPoint = client.getHintArrowPoint();

		if(worldPoint != null)
		{
			if(worldPoint.equals(npc.getWorldLocation()))
			{
				client.setHintArrow(npc);
			}
		}
	}

	public boolean loadPortalLocations()
	{
		NPC voidKnight = null;

		for(NPC npc : client.getNpcs())
		{
			if(PestControlPlugin.isIngameVoidKnight(npc.getId()))
			{
				voidKnight = npc;
				break;
			}
		}

		if(voidKnight != null)
		{
			log.debug("Ingame Void Knight found: {}", voidKnight);
			setPortalLocations(voidKnight.getWorldLocation());

			return true;
		}

		return false;
	}

	private void setPortalLocations(WorldPoint voidKnightLocation)
	{
		int x = voidKnightLocation.getX();
		int y = voidKnightLocation.getY();

		purple.setLocation(new WorldPoint(x - 27, y, 0));
		blue.setLocation(new WorldPoint(x + 25, y - 3, 0));
		yellow.setLocation(new WorldPoint(x +14, y - 21, 0));
		red.setLocation(new WorldPoint(x - 10, y - 22, 0));

		portalLocationsSet = true;
	}

	public void fall(String color)
	{
		switch (color.toLowerCase())
		{
			case "purple":
				fall(purple);
				break;
			case "red":
				fall(red);
				break;
			case "yellow":
				fall(yellow);
				break;
			case "blue":
				fall(blue);
				break;
		}
	}

	private void fall(PortalContext portal)
	{
		if (!portal.isShielded())
		{
			return;
		}

		log.debug("Shield dropped for {}", portal.getPortal());

		portal.setNpc(null);
		portal.setShielded(false);

		int shieldDrop = shieldsDropped++;

		// Remove impossible rotations
		List<Rotation> rotations = new ArrayList<>();

		for (Rotation rotation : possibleRotations)
		{
			if (rotation.getPortal(shieldDrop) == portal.getPortal())
			{
				rotations.add(rotation);
			}
		}

		possibleRotations = rotations.toArray(new Rotation[rotations.size()]);
	}

	public void die(PortalContext portal)
	{
		if (portal.isDead())
		{
			return;
		}

		log.debug("Portal {} died", portal.getPortal());

		portal.setNpc(null);
		portal.setDead(true);
	}

	public Collection<Portal> getNextPortals()
	{
		List<Portal> portals = new ArrayList<>();

		for (Rotation rotation : possibleRotations)
		{
			Portal portal = rotation.getPortal(shieldsDropped);

			if (portal != null && !portals.contains(portal))
			{
				portals.add(portal);
			}
		}

		return portals;
	}
}
