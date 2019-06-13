/*
 * Copyright (c) 2018, Eadgars Ruse <https://github.com/Eadgars-Ruse>
 * Copyright (c) 2019, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.cluescrolls.clues;

import com.google.common.collect.Lists;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.Getter;
import net.runelite.api.NPC;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.IMAGE_Z_OFFSET;
import net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea;
import net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdLocation;
import net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdTemperature;
import net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdTemperatureChange;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Getter
public class HotColdClue extends ClueScroll implements LocationClueScroll, LocationsClueScroll, TextClueScroll, NpcClueScroll
{
	private static final HotColdClue CLUE =
		new HotColdClue("Buried beneath the ground, who knows where it's found. Lucky for you, A man called Jorral may have a clue.",
			"Jorral",
			"Speak to Jorral to receive a strange device.");

	// list of potential places to dig
	private List<HotColdLocation> digLocations = new ArrayList<>();
	private final String text;
	private final String npc;
	private final String solution;
	private WorldPoint location;
	private WorldPoint lastWorldPoint;

	public static HotColdClue forText(String text)
	{
		if (CLUE.text.equalsIgnoreCase(text))
		{
			return CLUE;
		}

		return null;
	}

	private HotColdClue(String text, String npc, String solution)
	{
		this.text = text;
		this.npc = npc;
		this.solution = solution;
		setRequiresSpade(true);
	}

	@Override
	public WorldPoint[] getLocations()
	{
		return Lists.transform(digLocations, HotColdLocation::getWorldPoint).toArray(new WorldPoint[0]);
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.getChildren().add(TitleComponent.builder()
			.text("Hot/Cold Clue")
			.build());
		panelComponent.setPreferredSize(new Dimension(200, 0));

		// strange device has not been tested yet, show how to get it
		if (lastWorldPoint == null && location == null)
		{
			if (getNpc() != null)
			{
				panelComponent.getChildren().add(LineComponent.builder()
					.left("NPC:")
					.build());
				panelComponent.getChildren().add(LineComponent.builder()
					.left(getNpc())
					.leftColor(TITLED_CONTENT_COLOR)
					.build());
			}

			panelComponent.getChildren().add(LineComponent.builder()
				.left("Solution:")
				.build());
			panelComponent.getChildren().add(LineComponent.builder()
				.left(getSolution())
				.leftColor(TITLED_CONTENT_COLOR)
				.build());
		}
		// strange device has been tested, show possible locations for final dig spot
		else
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Possible areas:")
				.build());
			Map<HotColdArea, Integer> locationCounts = new HashMap<>();

			for (HotColdLocation hotColdLocation : digLocations)
			{
				HotColdArea hotColdArea = hotColdLocation.getHotColdArea();

				if (locationCounts.containsKey(hotColdArea))
				{
					locationCounts.put(hotColdArea, locationCounts.get(hotColdArea) + 1);
				}
				else
				{
					locationCounts.put(hotColdArea, 1);
				}
			}

			if (digLocations.size() > 10)
			{
				for (HotColdArea area : locationCounts.keySet())
				{
					panelComponent.getChildren().add(LineComponent.builder()
						.left(area.getName())
						.right(Integer.toString(locationCounts.get(area)))
						.build());
				}
			}
			else
			{
				for (HotColdArea s : locationCounts.keySet())
				{
					panelComponent.getChildren().add(LineComponent.builder()
						.left(s.getName() + ":")
						.build());

					for (HotColdLocation hotColdLocation : digLocations)
					{
						if (hotColdLocation.getHotColdArea() == s)
						{
							Rectangle2D r = hotColdLocation.getRect();
							panelComponent.getChildren().add(LineComponent.builder()
								.left("- " + hotColdLocation.getArea())
								.leftColor(Color.LIGHT_GRAY)
								.build());
						}
					}
				}
			}
		}
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		// when final location has been found
		if (this.location != null)
		{
			LocalPoint localLocation = LocalPoint.fromWorld(plugin.getClient(), getLocation());

			if (localLocation != null)
			{
				OverlayUtil.renderTileOverlay(plugin.getClient(), graphics, localLocation, plugin.getSpadeImage(), Color.ORANGE);
			}

			return;
		}

		// when strange device hasn't been activated yet, show Jorral
		if (lastWorldPoint == null)
		{
			// Mark NPC
			if (plugin.getNpcsToMark() != null)
			{
				for (NPC npc : plugin.getNpcsToMark())
				{
					OverlayUtil.renderActorOverlayImage(graphics, npc, plugin.getClueScrollImage(), Color.ORANGE, IMAGE_Z_OFFSET);
				}
			}
		}

		// once the number of possible dig locations is below 10, show the dig spots
		if (digLocations.size() < 10)
		{
			// Mark potential dig locations
			for (HotColdLocation hotColdLocation : digLocations)
			{
				WorldPoint wp = hotColdLocation.getWorldPoint();
				LocalPoint localLocation = LocalPoint.fromWorld(plugin.getClient(), wp.getX(), wp.getY());

				if (localLocation == null)
				{
					return;
				}

				OverlayUtil.renderTileOverlay(plugin.getClient(), graphics, localLocation, plugin.getSpadeImage(), Color.ORANGE);
			}
		}
	}

	public boolean update(final String message, final ClueScrollPlugin plugin)
	{
		final HotColdTemperature temperature = HotColdTemperature.of(message);

		if (temperature == null)
		{
			return false;
		}

		final WorldPoint localWorld = plugin.getClient().getLocalPlayer().getWorldLocation();

		if (localWorld == null)
		{
			return false;
		}

		if (temperature == HotColdTemperature.VISIBLY_SHAKING)
		{
			markFinalSpot(localWorld);
		}
		else
		{
			final HotColdTemperatureChange temperatureChange = HotColdTemperatureChange.of(message);
			updatePossibleArea(localWorld, temperature, temperatureChange);
		}

		return true;
	}

	@Override
	public void reset()
	{
		this.lastWorldPoint = null;
		digLocations.clear();
	}

	private void updatePossibleArea(@Nonnull final WorldPoint worldPoint, @Nonnull final HotColdTemperature temperature, @Nullable final HotColdTemperatureChange temperatureChange)
	{
		this.location = null;

		if (digLocations.isEmpty())
		{
			digLocations.addAll(Arrays.asList(HotColdLocation.values()));
		}

		// when the strange device reads a temperature, that means that the center of the final dig location
		// is a range of squares away from the player's current location (Chebyshev AKA Chess-board distance)
		int maxSquaresAway = temperature.getMaxDistance();
		int minSquaresAway = temperature.getMinDistance();

		// rectangle r1 encompasses all of the points that are within the max possible distance from the player
		Point p1 = new Point(worldPoint.getX() - maxSquaresAway, worldPoint.getY() - maxSquaresAway);
		Rectangle r1 = new Rectangle((int) p1.getX(), (int) p1.getY(), 2 * maxSquaresAway + 1, 2 * maxSquaresAway + 1);
		// rectangle r2 encompasses all of the points that are within the min possible distance from the player
		Point p2 = new Point(worldPoint.getX() - minSquaresAway, worldPoint.getY() - minSquaresAway);
		Rectangle r2 = new Rectangle((int) p2.getX(), (int) p2.getY(), 2 * minSquaresAway + 1, 2 * minSquaresAway + 1);

		// eliminate from consideration dig spots that lie entirely within the min range or entirely outside of the max range
		digLocations.removeIf(entry -> r2.contains(entry.getRect()) || !r1.intersects(entry.getRect()));

		// if a previous world point has been recorded, we can consider the warmer/colder result from the strange device
		if (lastWorldPoint != null && temperatureChange != null)
		{
			switch (temperatureChange)
			{
				case COLDER:
					// eliminate spots that are absolutely warmer
					digLocations.removeIf(entry -> isFirstPointCloserRect(worldPoint, lastWorldPoint, entry.getRect()));
					break;
				case WARMER:
					// eliminate spots that are absolutely colder
					digLocations.removeIf(entry -> isFirstPointCloserRect(lastWorldPoint, worldPoint, entry.getRect()));
					break;
				case SAME:
					// I couldn't figure out a clean implementation for this case
					// not necessary for quickly determining final location
			}
		}

		lastWorldPoint = worldPoint;
	}

	private boolean isFirstPointCloserRect(WorldPoint firstWp, WorldPoint secondWp, Rectangle2D r)
	{
		WorldPoint p1 = new WorldPoint((int) r.getMaxX(), (int) r.getMaxY(), 0);

		if (!isFirstPointCloser(firstWp, secondWp, p1))
		{
			return false;
		}

		WorldPoint p2 = new WorldPoint((int) r.getMaxX(), (int) r.getMinY(), 0);

		if (!isFirstPointCloser(firstWp, secondWp, p2))
		{
			return false;
		}

		WorldPoint p3 = new WorldPoint((int) r.getMinX(), (int)r.getMaxY(), 0);

		if (!isFirstPointCloser(firstWp, secondWp, p3))
		{
			return false;
		}

		WorldPoint p4 = new WorldPoint((int) r.getMinX(), (int) r.getMinY(), 0);
		return (isFirstPointCloser(firstWp, secondWp, p4));
	}

	private boolean isFirstPointCloser(WorldPoint firstWp, WorldPoint secondWp, WorldPoint wp)
	{
		int firstDistance = firstWp.distanceTo2D(wp);
		int secondDistance = secondWp.distanceTo2D(wp);
		return (firstDistance < secondDistance);
	}

	private void markFinalSpot(WorldPoint wp)
	{
		this.location = wp;
		reset();
	}

	public String[] getNpcs()
	{
		return new String[] {npc};
	}
}