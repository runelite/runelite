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
package net.runelite.client.plugins.aoewarnings;

import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.Projectile;
import net.runelite.client.events.ProjectileMoved;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.HashMap;
import java.util.Map;

public class AoeWarningOverlay extends Overlay
{
	private final Client client;
	private final AoeWarningConfig config;

	private final Map<Projectile, AoeProjectile> projectiles = new HashMap<>();

	private final int FILL_START_ALPHA = 25;
	private final int OUTLINE_START_ALPHA = 255;

	@Inject
	public AoeWarningOverlay(@Nullable Client client, AoeWarningConfig config)
	{
		super(OverlayPosition.DYNAMIC);
		this.client = client;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.getGameState() != GameState.LOGGED_IN || !config.enabled())
		{
			return null;
		}

		for (Map.Entry<Projectile, AoeProjectile> pair : projectiles.entrySet())
		{
			Projectile projectile = pair.getKey();
			AoeProjectile aoeProjectile = pair.getValue();

			if (projectile != null)
			{

				Polygon tilePoly = getTilePolygonFromPosition(aoeProjectile.getTargetPoint(), aoeProjectile.getAoeProjectileInfo().getAoeSize());
				if (tilePoly == null)
					continue;


				double progress = (System.currentTimeMillis() - aoeProjectile.getStartTime()) / (double) aoeProjectile.getAoeProjectileInfo().getLifeTimeMillis();
				//how far through the projectiles lifetime between 0-1.

				int fillAlpha = (int) ((1 - progress) * FILL_START_ALPHA);//alpha drop off over lifetime
				int outlineAlpha = (int) ((1 - progress) * OUTLINE_START_ALPHA);

				if (fillAlpha < 0)
					fillAlpha = 0;
				if (outlineAlpha < 0)
					outlineAlpha = 0;

				if (fillAlpha > 255)
					fillAlpha = 255;
				if (outlineAlpha > 255)
					outlineAlpha = 255;//Make sure we don't pass in an invalid alpha


				graphics.setColor(new Color(255, 0, 0, outlineAlpha));
				graphics.drawPolygon(tilePoly);

				graphics.setColor(new Color(255, 0, 0, fillAlpha));
				graphics.fillPolygon(tilePoly);
			}
		}

		//Remove if this projectile warning has passed it's lifetime
		projectiles.entrySet().removeIf(e ->
				(System.currentTimeMillis() - e.getValue().getStartTime()) > e.getValue().getAoeProjectileInfo().getLifeTimeMillis());

		return null;
	}

	/**
	 * Called when a projectile is set to move towards a point. For projectiles that target the ground, like AoE projectiles from Lizardman Shamans, this is only called once
	 *
	 * @param event Projectile moved event
	 */
	public void onProjectileMoved(ProjectileMoved event)
	{
		if (event.getProjectile().getInteracting() == 0)//Get interacting will not be 0 if it's targeting a player. AoE projectiles do not target any players.
		{
			System.out.println(event.getProjectile().getId());
			AoeProjectileInfo aoeProjectileInfo = AoeProjectileInfo.getById(event.getProjectile().getId());
			if (aoeProjectileInfo != null)
			{
				Projectile projectile = event.getProjectile();
				Point targetPoint = new Point(event.getTargetX(), event.getTargetY());
				AoeProjectile aoeProjectile = new AoeProjectile(System.currentTimeMillis(), targetPoint, aoeProjectileInfo);
				projectiles.put(projectile, aoeProjectile);
			}
		}
	}


	/**
	 * Returns a polgyon representing the tiles that the AoE will hit when it reaches it's target
	 *
	 * @param localLocation Center location of the AoE
	 * @param size          splash size of the AoE. Ex. Lizardman Shaman AoE is a 3x3, so size = 3
	 * @return a polgyon representing the tiles that the AoE will hit when it reaches it's target
	 */
	private Polygon getTilePolygonFromPosition(Point localLocation, int size)
	{
		if (localLocation == null)
			return null;
		int plane = client.getPlane();
		int fullTile = Perspective.LOCAL_TILE_SIZE;
		int halfTile = fullTile / 2;

		int aoeSize = size - 2;//If an aoe is a 3x3 then we need to move it 1 tile away from the center tile
		if (aoeSize < 0)
			aoeSize = 0;//If the size is 1, then we need to make sure it doesn't become -1


		Point p1 = Perspective.worldToCanvas(client, localLocation.getX() - halfTile - (fullTile * aoeSize), localLocation.getY() - halfTile - (fullTile * aoeSize), plane);
		Point p2 = Perspective.worldToCanvas(client, localLocation.getX() - halfTile - (fullTile * aoeSize), localLocation.getY() + halfTile + (fullTile * aoeSize), plane);
		Point p3 = Perspective.worldToCanvas(client, localLocation.getX() + halfTile + (fullTile * aoeSize), localLocation.getY() + halfTile + (fullTile * aoeSize), plane);
		Point p4 = Perspective.worldToCanvas(client, localLocation.getX() + halfTile + (fullTile * aoeSize), localLocation.getY() - halfTile - (fullTile * aoeSize), plane);


		if (p1 == null || p2 == null || p3 == null)
		{
			return null;
		}

		Polygon poly = new Polygon();
		poly.addPoint(p1.getX(), p1.getY());
		poly.addPoint(p2.getX(), p2.getY());
		poly.addPoint(p3.getX(), p3.getY());
		poly.addPoint(p4.getX(), p4.getY());

		return poly;
	}
}
