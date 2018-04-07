/*
 * Copyright (c) 2017, Evan Walden <etwalden@edu.uwaterloo.ca>
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
package net.runelite.client.plugins.winemaking;

import com.google.common.eventbus.Subscribe;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import static net.runelite.api.ItemID.UNFERMENTED_WINE;
import static net.runelite.api.ItemID.UNFERMENTED_WINE_1996;
import static net.runelite.api.ItemID.ZAMORAKS_UNFERMENTED_WINE;
import net.runelite.api.events.GameTick;
import net.runelite.api.queries.InventoryItemQuery;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Wine Making"
)
@PluginDependency(XpTrackerPlugin.class)
public class WineMakingPlugin extends Plugin
{
	private static final InventoryItemQuery UNFERMENTED_WINE_QUERY = new InventoryItemQuery(InventoryID.INVENTORY).idEquals(
		UNFERMENTED_WINE,
		UNFERMENTED_WINE_1996,
		ZAMORAKS_UNFERMENTED_WINE
	);

	@Inject
	private Client client;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	private int prevWineCount;

	@Override
	protected void shutDown() throws Exception
	{
		infoBoxManager.removeIf(t -> t instanceof FermentationTimer);
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		Item[] wines = UNFERMENTED_WINE_QUERY.result(client);

		if (wines.length == prevWineCount + 1)
		{
			infoBoxManager.removeIf(t -> t instanceof FermentationTimer);

			BufferedImage wineImage = itemManager.getImage(UNFERMENTED_WINE);
			FermentationTimer timer = new FermentationTimer(wineImage, this);
			infoBoxManager.addInfoBox(timer);
		}

		prevWineCount = wines.length;
	}
}