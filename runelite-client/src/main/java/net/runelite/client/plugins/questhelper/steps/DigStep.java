/*
 * Copyright (c) 2019, Trevor <https://github.com/Trevor159>
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
package net.runelite.client.plugins.questhelper.steps;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.questhelper.ItemRequirement;
import net.runelite.client.plugins.questhelper.QuestHelper;
import net.runelite.client.plugins.questhelper.QuestHelperPlugin;
import net.runelite.client.plugins.questhelper.QuestHelperWorldMapPoint;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;

public class DigStep extends QuestStep
{
	@Inject
	Client client;

	@Inject
	ItemManager itemManager;

	@Inject
	WorldMapPointManager worldMapPointManager;

	private final WorldPoint worldPoint;
	private final List<ItemRequirement> itemRequirements = new ArrayList<>();

	public DigStep(QuestHelper questHelper, WorldPoint worldPoint, String text, ItemRequirement... itemRequirements)
	{
		super(questHelper, text);
		this.worldPoint = worldPoint;
		this.itemRequirements.add(0, new ItemRequirement(ItemID.SPADE));
		Collections.addAll(this.itemRequirements, itemRequirements);
	}

	@Override
	public void startUp() throws Exception
	{
		worldMapPointManager.add(new QuestHelperWorldMapPoint(worldPoint, getQuestImage()));
	}

	@Override
	public void shutDown() throws Exception
	{
		worldMapPointManager.removeIf(QuestHelperWorldMapPoint.class::isInstance);
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, QuestHelperPlugin plugin)
	{
		super.makeOverlayHint(panelComponent, plugin);

		panelComponent.getChildren().add(LineComponent.builder().left("Required Items:").build());
		for (ItemRequirement itemRequirement : itemRequirements)
		{
			String text = itemRequirement.getQuantity() + " x " + itemManager.getItemComposition(itemRequirement.getId()).getName();
			Color color;
			if (itemRequirement.check(client))
			{
				color = Color.GREEN;
			}
			else
			{
				color = Color.RED;
			}
			panelComponent.getChildren().add(LineComponent.builder()
				.left(text)
				.leftColor(color)
				.build());
		}
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, QuestHelperPlugin plugin)
	{
		LocalPoint localLocation = LocalPoint.fromWorld(client, worldPoint);

		if (localLocation == null)
		{
			return;
		}

		OverlayUtil.renderTileOverlay(client, graphics, localLocation, getSpadeImage(), Color.ORANGE);
	}

	private BufferedImage getSpadeImage()
	{
		return itemManager.getImage(ItemID.SPADE);
	}
}
