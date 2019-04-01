/*
 * Copyright (c) 2018, Infinitay <https://github.com/Infinitay>
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
package net.runelite.client.plugins.kingdomofmiscellania;

import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import static net.runelite.api.ItemID.TEAK_CHEST;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Kingdom of Miscellania",
	description = "Show amount of favor when inside Miscellania",
	tags = {"favor", "favour", "managing", "overlay"},
	enabledByDefault = false
)
@Slf4j
public class KingdomPlugin extends Plugin
{
	private static final ImmutableSet<Integer> KINGDOM_REGION = ImmutableSet.of(10044, 10300);

	@Inject
	private Client client;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Getter
	private int favor = 0, coffer = 0;

	private KingdomCounter counter;

	@Override
	protected void shutDown() throws Exception
	{
		removeKingdomInfobox();
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		favor = client.getVar(Varbits.KINGDOM_FAVOR);
		coffer = client.getVar(Varbits.KINGDOM_COFFER);
		processInfobox();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			processInfobox();
		}
	}

	private void processInfobox()
	{
		if (client.getGameState() == GameState.LOGGED_IN && hasCompletedQuest() && isInKingdom())
		{
			addKingdomInfobox();
		}
		else
		{
			removeKingdomInfobox();
		}

	}

	private void addKingdomInfobox()
	{
		if (counter == null)
		{
			counter = new KingdomCounter(itemManager.getImage(TEAK_CHEST), this);
			infoBoxManager.addInfoBox(counter);
			log.debug("Added Kingdom Infobox");
		}
	}

	private void removeKingdomInfobox()
	{
		if (counter != null)
		{
			infoBoxManager.removeInfoBox(counter);
			counter = null;
			log.debug("Removed Kingdom Infobox");
		}
	}

	private boolean isInKingdom()
	{
		return client.getLocalPlayer() != null
			&& KINGDOM_REGION.contains(client.getLocalPlayer().getWorldLocation().getRegionID());
	}

	private boolean hasCompletedQuest()
	{
		return client.getVar(VarPlayer.THRONE_OF_MISCELLANIA) > 0;
	}

	static int getFavorPercent(int favor)
	{
		return (favor * 100) / 127;
	}

}
