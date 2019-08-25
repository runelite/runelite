/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameTick;

@Slf4j
public class Game
{
	private final Client client;

	private final PestControlPlugin plugin;

	@Getter(AccessLevel.PACKAGE)
	private Portal bluePortal = new Portal(PortalColor.BLUE, WidgetPortal.BLUE);

	@Getter(AccessLevel.PACKAGE)
	private Portal purplePortal = new Portal(PortalColor.PURPLE, WidgetPortal.PURPLE);

	@Getter(AccessLevel.PACKAGE)
	private Portal yellowPortal = new Portal(PortalColor.YELLOW, WidgetPortal.YELLOW);

	@Getter(AccessLevel.PACKAGE)
	private Portal redPortal = new Portal(PortalColor.RED, WidgetPortal.RED);

	@Getter(AccessLevel.PACKAGE)
	private int shieldsDropped = 0;

	// Game starts with all possible rotations
	private PortalRotation[] possibleRotations = PortalRotation.values();

	private boolean portalLocationsSet = false;


	private final Instant startTime = Instant.now();

	public Game(Client client, PestControlPlugin plugin)
	{
		this.client = client;
		this.plugin = plugin;
	}

	public void onGameTick(GameTick gameTickEvent)
	{
		if (!portalLocationsSet)
		{
			loadPortalLocations();
		}

		WidgetOverlay widgetOverlay = plugin.getWidgetOverlay();

		if (!purplePortal.isDead() && widgetOverlay.getPortalHitpoints(PortalColor.PURPLE) == 0)
		{
			killPortal(purplePortal);
		}

		if (!yellowPortal.isDead() && widgetOverlay.getPortalHitpoints(PortalColor.YELLOW) == 0)
		{
			killPortal(yellowPortal);
		}

		if (!redPortal.isDead() && widgetOverlay.getPortalHitpoints(PortalColor.RED) == 0)
		{
			killPortal(redPortal);
		}

		if (!bluePortal.isDead() && widgetOverlay.getPortalHitpoints(PortalColor.BLUE) == 0)
		{
			killPortal(bluePortal);
		}
	}

	void lowerPortalShield(String portalColor)
	{
		switch (portalColor.toLowerCase())
		{
			case "purple":
				lowerPortalShield(purplePortal);
				break;
			case "red":
				lowerPortalShield(redPortal);
				break;
			case "yellow":
				lowerPortalShield(yellowPortal);
				break;
			case "blue":
				lowerPortalShield(bluePortal);
				break;
		}
	}

	private void lowerPortalShield(Portal portal)
	{
		if (portal.isNotShielded())
		{
			return;
		}

		log.debug("Shield dropped for {}", portal.getColor());

		portal.setPortalState(PortalState.ACTIVE);

		int shieldDrop = shieldsDropped++;

		// Remove impossible rotations
		List<PortalRotation> rotations = new ArrayList<>();

		for (PortalRotation rotation : possibleRotations)
		{
			if (rotation.getPortal(this, shieldDrop) == portal)
			{
				rotations.add(rotation);
			}
		}

		possibleRotations = rotations.toArray(new PortalRotation[0]);
	}

	private void killPortal(Portal portal)
	{
		if (portal.isDead())
		{
			return;
		}

		log.debug("Portal {} died", portal.getColor());

		portal.setPortalState(PortalState.DEAD);
	}

	private void loadPortalLocations()
	{
		NPC squire = null;

		for (NPC npc : client.getNpcs())
		{
			if (PestControlNpc.isIngameSquireId(npc.getId()))
			{
				squire = npc;
				break;
			}
		}

		if (squire != null)
		{
			log.debug("In-game Squire found: {}", squire);
			setPortalLocations(squire.getWorldLocation());

		}

	}

	private void setPortalLocations(WorldPoint squireLocation)
	{
		int x = squireLocation.getX();
		int y = squireLocation.getY();

		purplePortal.setLocation(new WorldPoint(x - 26, y - 15, 0));
		bluePortal.setLocation(new WorldPoint(x + 26, y - 18, 0));
		yellowPortal.setLocation(new WorldPoint(x + 15, y - 36, 0));
		redPortal.setLocation(new WorldPoint(x - 9, y - 37, 0));

		portalLocationsSet = true;
	}

	List<Portal> getPortals()
	{
		List<Portal> portalList = new ArrayList<>();

		portalList.add(getPurplePortal());
		portalList.add(getBluePortal());
		portalList.add(getYellowPortal());
		portalList.add(getRedPortal());

		return portalList;
	}

	Portal getPortal(PortalColor portalColor)
	{
		if (bluePortal.getColor() == portalColor)
		{
			return bluePortal;
		}
		if (redPortal.getColor() == portalColor)
		{
			return redPortal;
		}
		if (purplePortal.getColor() == portalColor)
		{
			return purplePortal;
		}
		if (yellowPortal.getColor() == portalColor)
		{
			return yellowPortal;
		}

		return null;
	}

	Collection<Portal> getNextPortals()
	{
		List<Portal> portals = new ArrayList<>();

		for (PortalRotation rotation : possibleRotations)
		{
			Portal portal = rotation.getPortal(this, shieldsDropped);

			if (portal != null && !portals.contains(portal))
			{
				portals.add(portal);
			}
		}

		return portals;
	}

	Collection<Portal> getActivePortals()
	{
		List<Portal> portals = new ArrayList<>();

		for (Portal portal : getPortals())
		{
			if (portal.isActive())
			{
				portals.add(portal);
			}
		}

		return portals;
	}

	Duration getTimeTillNextPortal()
	{
		Instant nextShieldDrop;

		if (shieldsDropped == 4)
		{
			return null;
		}

		if (shieldsDropped == 0)
		{
			nextShieldDrop = Instant.ofEpochSecond(startTime.getEpochSecond() + 17);
		}
		else
		{
			nextShieldDrop = Instant.ofEpochSecond(startTime.getEpochSecond() + 17 + (30 * shieldsDropped));
		}

		return Duration.between(Instant.now(), nextShieldDrop);
	}
}
