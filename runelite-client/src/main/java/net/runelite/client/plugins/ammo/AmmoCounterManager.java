/*
 * Copyright (c) 2018, Arthur Tyukayev <https://github.com/arthurtyukayev>
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
package net.runelite.client.plugins.ammo;

import lombok.Getter;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import java.awt.image.BufferedImage;

public class AmmoCounterManager
{
	private AmmoPlugin plugin;
	private AmmoConfig config;
	private InfoBoxManager infoBoxManager;
	private ItemManager itemManager;

	@Getter
	private AmmoCounter counter;
	private int activeCounterImageItemId;

	public AmmoCounterManager(AmmoPlugin plugin, AmmoConfig config, ItemManager itemManager, InfoBoxManager infoBoxManager)
	{
		this.plugin = plugin;
		this.config = config;
		this.infoBoxManager = infoBoxManager;
		this.itemManager = itemManager;
	}

	public boolean isCounterVisible()
	{
		return counter != null && !infoBoxManager.getInfoBoxes().contains(counter);
	}

	public void createCounter(int imageItemId, String tooltipText)
	{
		if (counter != null)
		{
			return;
		}

		int itemSpriteId = (imageItemId > 0) ? imageItemId : ItemID.RUNE_ARROW;
		BufferedImage taskImg = itemManager.getImage(itemSpriteId, 50, false);
		counter = new AmmoCounter(taskImg, this.plugin, 0);
		counter.setTooltip(tooltipText);
	}

	public void displayCounter()
	{
		if (!isCounterVisible())
		{
			infoBoxManager.addInfoBox(counter);
		}
	}

	public void hideCounter()
	{
		if (isCounterVisible())
		{
			infoBoxManager.removeInfoBox(counter);
		}
	}

	public void removeCounter()
	{
		if (counter != null)
		{
			infoBoxManager.removeInfoBox(counter);
		}
		counter = null;
	}


	public void updateCounter(int itemId)
	{
		if (activeCounterImageItemId == itemId)
		{
			return;
		}

		ItemComposition item = itemManager.getItemComposition(itemId);

		removeCounter();
		activeCounterImageItemId = itemId;
		createCounter(item.getId(), item.getName());
	}
}
