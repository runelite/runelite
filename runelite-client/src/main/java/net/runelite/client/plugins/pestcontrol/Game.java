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
	private final PortalContext purple = new PortalContext(PURPLE);
	@Getter
	private final PortalContext blue = new PortalContext(BLUE);
	@Getter
	private final PortalContext yellow = new PortalContext(YELLOW);
	@Getter
	private final PortalContext red = new PortalContext(RED);

	void fall(String color)
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

	void die(PortalContext portal)
	{
		if (portal.isDead())
		{
			return;
		}

		log.debug("Portal {} died", portal.getPortal());

		portal.setDead(true);
	}

	Collection<Portal> getNextPortals()
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
