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
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Point;
import net.runelite.api.queries.NPCQuery;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.util.QueryRunner;

/**
 *
 * @author robin
 */
public class ImplingsOverlay extends Overlay
{

	// Impling spawns in PuroPuro. Not in NpcID.
	private static final int STATIC_SPAWN = 1618;
	private static final int DYNAMIC_SPAWN = 1633;

	private final QueryRunner queryRunner;
	private final ImplingsConfig config;

	@Getter
	private final Map<Integer, Color> ids = new HashMap<>();

	@Inject
	public ImplingsOverlay(QueryRunner queryRunner, ImplingsConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.queryRunner = queryRunner;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics, java.awt.Point parent)
	{
		NPCQuery implingQuery = new NPCQuery().idEquals(Ints.toArray(ids.keySet()));
		NPC[] implings = queryRunner.runQuery(implingQuery);
		for (NPC imp : implings)
		{
			//Spawns have the name "null", so they get changed to "Spawn"
			String text = imp.getName().equals("null") ? "Spawn" : imp.getName();
			drawImp(graphics, imp, text, ids.get(imp.getId()));
		}

		return null;
	}

	// I am aware this is ugly. As always, feedback is welcome
	public void updateConfig()
	{
		ids.clear();
		if (config.showBaby())
		{
			ids.put(NpcID.BABY_IMPLING, config.getBabyColor());
			ids.put(NpcID.BABY_IMPLING_1645, config.getBabyColor());
		}
		if (config.showYoung())
		{
			ids.put(NpcID.YOUNG_IMPLING, config.getYoungColor());
			ids.put(NpcID.YOUNG_IMPLING_1646, config.getYoungColor());
		}
		if (config.showGourmet())
		{
			ids.put(NpcID.GOURMET_IMPLING, config.getGourmetColor());
			ids.put(NpcID.GOURMET_IMPLING_1647, config.getGourmetColor());
		}
		if (config.showEarth())
		{
			ids.put(NpcID.EARTH_IMPLING, config.getEarthColor());
			ids.put(NpcID.EARTH_IMPLING_1648, config.getEarthColor());
		}
		if (config.showEssence())
		{
			ids.put(NpcID.ESSENCE_IMPLING, config.getEssenceColor());
			ids.put(NpcID.ESSENCE_IMPLING_1649, config.getEssenceColor());
		}
		if (config.showEclectic())
		{
			ids.put(NpcID.ECLECTIC_IMPLING, config.getEclecticColor());
			ids.put(NpcID.ECLECTIC_IMPLING_1650, config.getEclecticColor());
		}
		if (config.showNature())
		{
			ids.put(NpcID.NATURE_IMPLING, config.getNatureColor());
			ids.put(NpcID.NATURE_IMPLING_1651, config.getNatureColor());
		}
		if (config.showMagpie())
		{
			ids.put(NpcID.MAGPIE_IMPLING, config.getMapgieColor());
			ids.put(NpcID.MAGPIE_IMPLING_1652, config.getMapgieColor());
		}
		if (config.showNinja())
		{
			ids.put(NpcID.NINJA_IMPLING, config.getNinjaColor());
			ids.put(NpcID.NINJA_IMPLING_1653, config.getNinjaColor());
		}
		if (config.showDragon())
		{
			ids.put(NpcID.DRAGON_IMPLING, config.getDragonColor());
			ids.put(NpcID.DRAGON_IMPLING_1654, config.getDragonColor());
		}
		if (config.showLucky())
		{
			ids.put(NpcID.LUCKY_IMPLING, config.getLuckyColor());
			ids.put(NpcID.LUCKY_IMPLING_7302, config.getLuckyColor());
		}
		if (config.showSpawn())
		{
			ids.put(STATIC_SPAWN, config.getSpawnColor());
			ids.put(DYNAMIC_SPAWN, config.getSpawnColor());
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

		Point textLocation = actor.getCanvasTextLocation(graphics, text, actor.getLogicalHeight());
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
