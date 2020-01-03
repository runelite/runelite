/*
 * Copyright (c) 2018, Seth <http://github.com/sethtroll>
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
package net.runelite.client.plugins.barrows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Dictionary;
import java.util.Hashtable;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Varbits;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
@Slf4j
public class BarrowsCryptKCOverlay extends Overlay
{
	private final Client client;
	private final BarrowsConfig config;
	private final PanelComponent panelComponent = new PanelComponent();
	private static final int CRYPT_REGION_ID = 14231;
	private static final int CRYPT_PLANE_ID = 0;
	private static Dictionary<String, Integer> monstersKilled = new Hashtable<String, Integer>();
	private int startingPotential = 0;

	@Inject
	private BarrowsCryptKCOverlay(BarrowsPlugin plugin, Client client, BarrowsConfig config)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.LOW);
		this.client = client;
		this.config = config;
		// Initialize the dictionary to have 0 kills for all monsters
		initializeKC();
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Barrows Crypt KC overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		// Do not display overlay if not in crypt
		if (!isInCrypt())
		{
			return null;
		}

		// If the config switch is set to false, do not display overlay
		if (!config.showCryptMonsterKills())
		{
			return null;
		}

		panelComponent.getChildren().clear();

		// Get new potential after a kill
		int newPotential = client.getVar(Varbits.BARROWS_REWARD_POTENTIAL);
		// Calculate the difference between the original potential and new potential (how much potential gained
		// from the kill)
		int potentialDifference = newPotential - this.startingPotential;
		// If the amount of potential goes down, a barrows trip has been completed and we want to reset the counters
		// Note - this only occurs when re-entering a crypt/maze after having completed, so if a player finishes a
		// barrows run, the kill count will still be present until they leave the crypt.  But on re-entry of a new
		// crypt, it will have reset.
		if (potentialDifference < 0)
		{
			initializeKC();
		}

		// Set the "original" potential to the new potential so future calculations are based on the correct value.
		startingPotential = newPotential;

		for (CryptMonsters monster : CryptMonsters.values())
		{
			// To figure out which monster was killed, just check the difference in reward potential and compare it
			// to the combat level of the monster.  This does mean, however, that if multiple unregistered kills occur
			// (such as if the tracker is toggled off mid-run, then back on after a few kills), they will not appear.
			if (monster.getCombatLevel() == potentialDifference)
			{
				String monsterSlain = monster.getName();
				int numKilled = monstersKilled.get(monsterSlain);
				monstersKilled.put(monsterSlain, numKilled + 1);
			}
			panelComponent.getChildren().add(LineComponent.builder()
					.left(monster.getName())
					.right(monstersKilled.get(monster.getName()).toString())
					.rightColor(Color.WHITE)
					.build());
		}
		return panelComponent.render(graphics);
	}

	private void initializeKC()
	{
		//Initialize monstersKilled dictionary to have 0 kills for each monster
		for (CryptMonsters monster : CryptMonsters.values())
		{
			monstersKilled.put(monster.getName(), 0);
		}
	}

	// Reusing BarrowsPlugin's isInCrypt to decide whether or not to show this overlay
	// Also added plane checking to limit tracker to only appearing the maze portion, not in each barrow.
	private boolean isInCrypt()
	{
		boolean cryptRegion = client.getLocalPlayer().getWorldLocation().getRegionID() == CRYPT_REGION_ID;
		boolean cryptPlane = client.getLocalPlayer().getWorldLocation().getPlane() == CRYPT_PLANE_ID;
		return cryptRegion && cryptPlane;
	}
}
