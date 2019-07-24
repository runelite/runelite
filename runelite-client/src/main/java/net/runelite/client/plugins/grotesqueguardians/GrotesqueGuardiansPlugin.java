/*
 * Copyright (c) 2018, Damen <https://github.com/basicDamen>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.grotesqueguardians;

import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import java.util.ArrayList;
import net.runelite.api.events.GameTick;
import net.runelite.api.NPC;
import javax.annotation.Nullable;
import net.runelite.api.Client;

import static net.runelite.api.NpcID.DUSK_7888;


@PluginDescriptor(
	name = "Grotesque Guardians",
	description = "Show various helpful utitiles during the Grotesque Gaurdians (Gargoyles) fight",
	tags = { "bosses", "combat", "gargs", "overlay", "grotesque", "pve", "pvm" },
	type = PluginType.PVM,
	enabledByDefault = false
)
@Singleton
public class GrotesqueGuardiansPlugin extends Plugin
{
	private static final int GARGOYLES_REGION = 6727;
	@Inject
	private Client client;
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private GrotesqueGuardiansPrayerOverlay prayerOverlay;
	@Inject
	private EventBus eventBus;
	@Nullable
	private DuskAttack prayAgainst;
	@Nullable
	private NPC dusk;
	private boolean inGargs;
	private boolean needingToRun;

	public GrotesqueGuardiansPlugin()
	{
		inGargs = false;
		needingToRun = false;
	}

	@Inject
	private GrotesqueGuardiansOverlay overlay;

	@Override
	protected void startUp() throws Exception
	{
		eventBus.subscribe(GameTick.class, this, this::onGameTick);

		overlayManager.add(overlay);
		overlayManager.add(prayerOverlay);
		dusk = null;
		prayAgainst = null;
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
		overlayManager.remove(prayerOverlay);
		dusk = null;
		prayAgainst = null;
	}

	private void onGameTick(final GameTick event)
	{
		final ArrayList<Integer> regions = new ArrayList<>();
		for (final int intValue : client.getMapRegions())
		{
			regions.add(intValue);
		}
		if (regions.contains(GARGOYLES_REGION))
		{
			dusk = null;
			inGargs = true;
			for (final NPC npc : client.getNpcs())
			{
				if (npc.getName() != null && npc.getName().contains("Dusk") && !npc.isDead())
				{
					dusk = npc;
				}
			}
			if (inGargs && dusk != null)
			{
				if (dusk.getId() == DUSK_7888)
				{
					if (dusk.getAnimation() == DuskAttack.MELEE.getAnimation())
					{
						prayAgainst = DuskAttack.MELEE;
					}
					else if (dusk.getAnimation() == DuskAttack.RANGE.getAnimation())
					{
						prayAgainst = DuskAttack.RANGE;
					}
				}
				else
					{
					prayAgainst = null;
				}
				needingToRun = dusk.getAnimation() == 7802;
			}
		}
		else
			{
			inGargs = false;
			prayAgainst = null;
			dusk = null;
		}
	}

	@Nullable
	DuskAttack getPrayAgainst()
	{
		return prayAgainst;
	}

	@Nullable
	NPC getDusk()
	{
		return dusk;
	}

	boolean isInGargs()
	{
		return inGargs;
	}

	boolean isNeedingToRun()
	{
		return needingToRun;
	}

}
