/*
 * Copyright (c) 2017, Robin <robin.weymans@gmail.com>
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
package net.runelite.client.plugins.implings;

import com.google.common.primitives.Ints;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Point;
import net.runelite.api.queries.NPCQuery;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

/**
 *
 * @author robin
 */
public class ImplingsOverlay extends Overlay
{

	// Impling spawns in PuroPuro. Not in NpcID.
	private static final int STATIC_SPAWN = 1618;
	private static final int DYNAMIC_SPAWN = 1633;

	private final RuneLite runelite;
	private final Client client;
	private final ImplingsConfig config;
	private final List<Integer> ids = new LinkedList<>();

	@Inject
	public ImplingsOverlay(RuneLite runelite, @Nullable Client client, ImplingsConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		this.runelite = runelite;
		this.client = client;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics, java.awt.Point parent)
	{
		NPCQuery implingQuery = new NPCQuery().idEquals(Ints.toArray(ids));
		NPC[] implings = runelite.runQuery(implingQuery);
		for (NPC imp : implings)
		{
			//Spawns have the name "null", so they get changed to "Spawn"
			String text = imp.getName().equals("null") ? "Spawn" : imp.getName();
			drawImp(graphics, imp, text, Color.WHITE);
		}

		return null;
	}

	// I am aware this is ugly. As always, feedback is welcome
	public void updateConfig()
	{
		ids.clear();
		if (config.showBaby())
		{
			ids.add(NpcID.BABY_IMPLING);
			ids.add(NpcID.BABY_IMPLING_1645);
		}
		if (config.showYoung())
		{
			ids.add(NpcID.YOUNG_IMPLING);
			ids.add(NpcID.YOUNG_IMPLING_1646);
		}
		if (config.showGourmet())
		{
			ids.add(NpcID.GOURMET_IMPLING);
			ids.add(NpcID.GOURMET_IMPLING_1647);
		}
		if (config.showEarth())
		{
			ids.add(NpcID.EARTH_IMPLING);
			ids.add(NpcID.EARTH_IMPLING_1648);
		}
		if (config.showEssence())
		{
			ids.add(NpcID.ESSENCE_IMPLING);
			ids.add(NpcID.ESSENCE_IMPLING_1649);
		}
		if (config.showEclectic())
		{
			ids.add(NpcID.ECLECTIC_IMPLING);
			ids.add(NpcID.ECLECTIC_IMPLING_1650);
		}
		if (config.showNature())
		{
			ids.add(NpcID.NATURE_IMPLING);
			ids.add(NpcID.NATURE_IMPLING_1651);
		}
		if (config.showMagpie())
		{
			ids.add(NpcID.MAGPIE_IMPLING);
			ids.add(NpcID.MAGPIE_IMPLING_1652);
		}
		if (config.showNinja())
		{
			ids.add(NpcID.NINJA_IMPLING);
			ids.add(NpcID.NINJA_IMPLING_1653);
		}
		if (config.showDragon())
		{
			ids.add(NpcID.DRAGON_IMPLING);
			ids.add(NpcID.DRAGON_IMPLING_1654);
		}
		if (config.showLucky())
		{
			ids.add(NpcID.LUCKY_IMPLING);
			ids.add(NpcID.LUCKY_IMPLING_7302);
		}
		if (config.showSpawn())
		{
			ids.add(STATIC_SPAWN);
			ids.add(DYNAMIC_SPAWN);
		}
	}

	private void drawImp(Graphics2D graphics, Actor actor, String text, Color color)
	{
		Polygon poly = actor.getCanvasTilePoly();
		if (poly != null)
		{
			graphics.setColor(color);
			graphics.setStroke(new BasicStroke(2));
			graphics.drawPolygon(poly);
			graphics.setColor(new Color(0, 0, 0, 50));
			graphics.fillPolygon(poly);
		}

		Point minimapLocation = actor.getMinimapLocation();
		if (minimapLocation != null)
		{
			graphics.setColor(color);
			graphics.fillOval(minimapLocation.getX(), minimapLocation.getY(), 5, 5);
			graphics.setColor(Color.WHITE);
			graphics.setStroke(new BasicStroke(1));
			graphics.drawOval(minimapLocation.getX(), minimapLocation.getY(), 5, 5);
		}

		Point textLocation = actor.getCanvasTextLocation(graphics, text, actor.getModelHeight());
		if (textLocation != null)
		{
			int x = textLocation.getX();
			int y = textLocation.getY();

			graphics.setColor(Color.BLACK);
			graphics.drawString(text, x + 1, y + 1);

			graphics.setColor(color);
			graphics.drawString(text, x, y);
		}
	}

}
