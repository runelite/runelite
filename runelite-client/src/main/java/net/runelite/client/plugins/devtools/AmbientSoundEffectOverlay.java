/*
 * Copyright (c) 2023, zom
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
package net.runelite.client.plugins.devtools;

import com.google.common.base.Strings;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.Value;
import net.runelite.api.AmbientSoundEffect;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AmbientSoundEffectCreated;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

class AmbientSoundEffectOverlay extends Overlay
{
	private static final int MAX_DRAW_DISTANCE = 32;

	private final Client client;
	private final DevToolsPlugin plugin;

	private final List<AmbientSoundTileMarker> ambientSoundTileMarkers = new ArrayList<>();

	private final List<AmbientSoundPoint> groundMarkerPoints = new ArrayList<>();


	@Inject
	AmbientSoundEffectOverlay(Client client, DevToolsPlugin plugin)
	{
		this.client = client;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.LOW);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Subscribe(priority = 1) // priority 1 to run before Music Plugin
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		GameState gameState = gameStateChanged.getGameState();
		if (gameState == GameState.LOGGED_IN)
		{
			addSounds();
		}
	}

	@Subscribe(priority = 1) // priority 1 to run before Music Plugin
	public void onAmbientSoundEffectCreated(AmbientSoundEffectCreated ambientSoundEffectCreated)
	{
		// single created sounds are added to client's AmbientSound deque
		addSounds();
	}

	private void addSounds()
	{
		ambientSoundTileMarkers.clear();
		groundMarkerPoints.clear();
		for (AmbientSoundEffect ambientSoundEffect : client.getAmbientSoundEffects())
		{
			markTile(ambientSoundEffect);
		}

		Collection<AmbientSoundTileMarker> colorTileMarkers = translateToColorTileMarker(groundMarkerPoints);
		ambientSoundTileMarkers.addAll(colorTileMarkers);
	}

	private void markTile(AmbientSoundEffect ambientSoundEffect)
	{
		if (ambientSoundEffect == null)
		{
			return;
		}

		int[] ambientSoundEffectBackgroundSoundEffectIds = ambientSoundEffect.getBackgroundSoundEffectIds();

		StringBuilder stringBuilder = new StringBuilder();
		if (ambientSoundEffectBackgroundSoundEffectIds == null)
		{
			stringBuilder.append(',');
		}
		else
		{
			for (int i : ambientSoundEffectBackgroundSoundEffectIds)
			{
				stringBuilder.append(',').append(i);
			}
		}

		markTile(ambientSoundEffect.getMinPosition(), ambientSoundEffect.getSoundEffectId() + " min position (" + stringBuilder.substring(1) + ")");
		markTile(ambientSoundEffect.getMaxPosition(), ambientSoundEffect.getSoundEffectId() + " max position (" + stringBuilder.substring(1) + ")");
	}

	private void markTile(LocalPoint localPoint, String label)
	{
		if (localPoint == null)
		{
			return;
		}

		WorldPoint worldPoint = WorldPoint.fromLocalInstance(client, localPoint);

		int regionId = worldPoint.getRegionID();
		AmbientSoundPoint point = new AmbientSoundPoint(regionId, worldPoint.getRegionX(), worldPoint.getRegionY(), worldPoint.getPlane(), Color.RED, label);

		groundMarkerPoints.add(point);
	}

	/**
	 * Translate a collection of ambient sound points to ambient sound tiles, accounting for instances
	 *
	 * @param points {@link AmbientSoundPoint}s to be converted to {@link AmbientSoundTileMarker}s
	 * @return A collection of ambient sound tiles, converted from the passed ambient sound points, accounting for local
	 * instance points. See {@link WorldPoint#toLocalInstance(Client, WorldPoint)}
	 */
	public Collection<AmbientSoundTileMarker> translateToColorTileMarker(Collection<AmbientSoundPoint> points)
	{
		if (points.isEmpty())
		{
			return Collections.emptyList();
		}

		return points.stream()
			.map(point -> new AmbientSoundTileMarker(
				WorldPoint.fromRegion(point.getRegionId(), point.getRegionX(), point.getRegionY(), point.getZ()),
				point.getColor(), point.getLabel()))
			.flatMap(colorTile ->
			{
				final Collection<WorldPoint> localWorldPoints = WorldPoint.toLocalInstance(client, colorTile.getWorldPoint());
				return localWorldPoints.stream().map(wp -> new AmbientSoundTileMarker(wp, colorTile.getColor(), colorTile.getLabel()));
			})
			.collect(Collectors.toList());
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.getSoundEffects().isActive())
		{
			return null;
		}

		final Collection<AmbientSoundTileMarker> points = ambientSoundTileMarkers;
		if (points.isEmpty())
		{
			return null;
		}

		Stroke stroke = new BasicStroke((float) 2);
		for (final AmbientSoundTileMarker point : points)
		{
			WorldPoint worldPoint = point.getWorldPoint();
			if (worldPoint.getPlane() != client.getPlane())
			{
				continue;
			}

			Color tileColor = point.getColor();
			if (tileColor == null)
			{
				// If this is an old tile which has no color, use marker color
				tileColor = Color.RED;
			}

			drawTile(graphics, worldPoint, tileColor, point.getLabel(), stroke);
		}

		return null;
	}

	private void drawTile(Graphics2D graphics, WorldPoint point, Color color, @Nullable String label, Stroke borderStroke)
	{
		WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();

		if (point.distanceTo(playerLocation) >= MAX_DRAW_DISTANCE)
		{
			return;
		}

		LocalPoint lp = LocalPoint.fromWorld(client, point);
		if (lp == null)
		{
			return;
		}

		Polygon poly = Perspective.getCanvasTilePoly(client, lp);
		if (poly != null)
		{
			OverlayUtil.renderPolygon(graphics, poly, color, new Color(0, 0, 0, 50), borderStroke);
		}

		if (!Strings.isNullOrEmpty(label))
		{
			Point canvasTextLocation = Perspective.getCanvasTextLocation(client, graphics, lp, label, 0);
			if (canvasTextLocation != null)
			{
				OverlayUtil.renderTextLocation(graphics, canvasTextLocation, label, color);
			}
		}
	}

	@Value
	static
	class AmbientSoundTileMarker
	{
		WorldPoint worldPoint;
		@Nullable
		Color color;
		@Nullable
		String label;
	}

	@Value
	static
	class AmbientSoundPoint
	{
		int regionId;
		int regionX;
		int regionY;
		int z;
		@Nullable
		Color color;
		@Nullable
		String label;
	}

}
