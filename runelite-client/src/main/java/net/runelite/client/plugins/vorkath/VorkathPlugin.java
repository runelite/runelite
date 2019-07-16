/*
 * Copyright (c) 2018, https://runelitepl.us
 * Copyright (c) 2019, Infinitay <https://github.com/Infinitay>
 *
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
package net.runelite.client.plugins.vorkath;

import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.NPC;
import net.runelite.api.ObjectID;
import net.runelite.api.Projectile;
import net.runelite.api.ProjectileID;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.api.events.ProjectileSpawned;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "Vorkath Helper",
	description = "Count vorkath attacks, indicate next phase, wooxwalk timer, indicate path through acid",
	tags = {"combat", "overlay", "pve", "pvm"},
	type = PluginType.PVM,
	enabledByDefault = false
)
@Singleton
@Slf4j
public class VorkathPlugin extends Plugin
{
	private static final int VORKATH_REGION = 9023;

	@Inject
	private Client client;
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private VorkathOverlay overlay;
	@Inject
	private AcidPathOverlay acidPathOverlay;
	@Inject
	private VorkathConfig config;
	@Getter(AccessLevel.PACKAGE)
	private Vorkath vorkath;
	@Getter(AccessLevel.PACKAGE)
	private NPC zombifiedSpawn;
	@Getter(AccessLevel.PACKAGE)
	private List<WorldPoint> acidSpots = new ArrayList<>();
	@Getter(AccessLevel.PACKAGE)
	private List<WorldPoint> acidFreePath = new ArrayList<>();
	@Getter(AccessLevel.PACKAGE)
	private WorldPoint[] wooxWalkPath = new WorldPoint[2];
	@Getter(AccessLevel.PACKAGE)
	private long wooxWalkTimer = -1;
	@Getter(AccessLevel.PACKAGE)
	private Rectangle wooxWalkBar;
	private int lastAcidSpotsSize = 0;
	// Config values
	@Getter(AccessLevel.PACKAGE)
	private boolean indicateAcidPools;
	@Getter(AccessLevel.PACKAGE)
	private boolean indicateAcidFreePath;
	@Getter(AccessLevel.PACKAGE)
	private boolean indicateWooxWalkPath;
	@Getter(AccessLevel.PACKAGE)
	private boolean indicateWooxWalkTick;
	private int acidFreePathLength;

	@Provides
	VorkathConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(VorkathConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();
	}

	@Override
	protected void shutDown()
	{
		reset();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("vorkath"))
		{
			return;
		}

		updateConfig();
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		if (!isAtVorkath())
		{
			return;
		}

		final NPC npc = event.getNpc();

		if (npc.getName() == null)
		{
			return;
		}

		if (npc.getName().equals("Vorkath"))
		{
			vorkath = new Vorkath(npc);
			overlayManager.add(overlay);
		}
		else if (npc.getName().equals("Zombified Spawn"))
		{
			zombifiedSpawn = npc;
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		if (!isAtVorkath())
		{
			return;
		}

		final NPC npc = event.getNpc();

		if (npc.getName() == null)
		{
			return;
		}

		if (npc.getName().equals("Vorkath"))
		{
			reset();
		}
		else if (npc.getName().equals("Zombified Spawn"))
		{
			zombifiedSpawn = null;
		}
	}

	@Subscribe
	public void onProjectileSpawned(ProjectileSpawned event)
	{
		if (!isAtVorkath())
		{
			return;
		}

		final Projectile proj = event.getProjectile();
		final VorkathAttack vorkathAttack = VorkathAttack.getVorkathAttack(proj.getId());

		if (vorkathAttack != null)
		{
			if (VorkathAttack.isBasicAttack(vorkathAttack.getProjectileID()) && vorkath.getAttacksLeft() > 0)
			{
				vorkath.setAttacksLeft(vorkath.getAttacksLeft() - 1);
			}
			else if (vorkathAttack == VorkathAttack.ACID)
			{
				vorkath.updatePhase(Vorkath.Phase.ACID);
				vorkath.setAttacksLeft(0);
			}
			else if (vorkathAttack == VorkathAttack.FIRE_BALL)
			{
				vorkath.updatePhase(Vorkath.Phase.FIRE_BALL);
				vorkath.setAttacksLeft(vorkath.getAttacksLeft() - 1);
			}
			else if (vorkathAttack == VorkathAttack.FREEZE_BREATH || vorkathAttack == VorkathAttack.ZOMBIFIED_SPAWN)
			{
				vorkath.updatePhase(Vorkath.Phase.SPAWN);
				vorkath.setAttacksLeft(0);
			}
			else
			{
				vorkath.updatePhase(vorkath.getNextPhase());
				vorkath.setAttacksLeft(vorkath.getAttacksLeft() - 1);
			}

			log.debug("[Vorkath ({})] {}", vorkathAttack, vorkath);
			vorkath.setLastAttack(vorkathAttack);
		}
	}

	@Subscribe
	public void onProjectileMoved(ProjectileMoved event)
	{
		if (!isAtVorkath())
		{
			return;
		}

		final Projectile proj = event.getProjectile();
		final LocalPoint loc = event.getPosition();

		if (proj.getId() == ProjectileID.VORKATH_POISON_POOL_AOE)
		{
			addAcidSpot(WorldPoint.fromLocal(client, loc));
		}
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		if (!isAtVorkath())
		{
			return;
		}

		final GameObject obj = event.getGameObject();

		if (obj.getId() == ObjectID.ACID_POOL || obj.getId() == ObjectID.ACID_POOL_32000)
		{
			addAcidSpot(obj.getWorldLocation());
		}
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		if (!isAtVorkath())
		{
			return;
		}

		final GameObject obj = event.getGameObject();

		if (obj.getId() == ObjectID.ACID_POOL || obj.getId() == ObjectID.ACID_POOL_32000)
		{
			acidSpots.remove(obj.getWorldLocation());
		}
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		if (!isAtVorkath())
		{
			return;
		}

		final Actor actor = event.getActor();

		if (isAtVorkath() && vorkath != null && actor.equals(vorkath.getVorkath())
			&& actor.getAnimation() == VorkathAttack.SLASH_ATTACK.getVorkathAnimationID())
		{
			if (vorkath.getAttacksLeft() > 0)
			{
				vorkath.setAttacksLeft(vorkath.getAttacksLeft() - 1);
			}
			else
			{
				vorkath.updatePhase(vorkath.getNextPhase());
				vorkath.setAttacksLeft(vorkath.getAttacksLeft() - 1);
			}
			log.debug("[Vorkath (SLASH_ATTACK)] {}", vorkath);
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (!isAtVorkath())
		{
			return;
		}

		// Update the acid free path every tick to account for player movement
		if (this.indicateAcidFreePath && !acidSpots.isEmpty())
		{
			calculateAcidFreePath();
		}

		// Start the timer when the player walks into the WooxWalk zone
		if (this.indicateWooxWalkPath && this.indicateWooxWalkTick && wooxWalkPath[0] != null && wooxWalkPath[1] != null)
		{
			final WorldPoint playerLoc = client.getLocalPlayer().getWorldLocation();

			if (playerLoc.getX() == wooxWalkPath[0].getX() && playerLoc.getY() == wooxWalkPath[0].getY()
				&& playerLoc.getPlane() == wooxWalkPath[0].getPlane())
			{
				if (wooxWalkTimer == -1)
				{
					wooxWalkTimer = System.currentTimeMillis() - 400;
				}
			}
			else if (playerLoc.getX() == wooxWalkPath[1].getX() && playerLoc.getY() == wooxWalkPath[1].getY()
				&& playerLoc.getPlane() == wooxWalkPath[1].getPlane())
			{
				if (wooxWalkTimer == -1)
				{
					wooxWalkTimer = System.currentTimeMillis() - 1000;
				}
			}
			else if (wooxWalkTimer != -1)
			{
				wooxWalkTimer = -1;
			}
		}
	}

	@Subscribe
	private void onClientTick(ClientTick event)
	{
		if (acidSpots.size() != lastAcidSpotsSize)
		{
			if (acidSpots.size() == 0)
			{
				overlayManager.remove(acidPathOverlay);
				acidFreePath.clear();
				Arrays.fill(wooxWalkPath, null);
				wooxWalkTimer = -1;
			}
			else
			{
				if (this.indicateAcidFreePath)
				{
					calculateAcidFreePath();
				}
				if (this.indicateWooxWalkPath)
				{
					calculateWooxWalkPath();
				}

				overlayManager.add(acidPathOverlay);
			}

			lastAcidSpotsSize = acidSpots.size();
		}
	}

	/**
	 * @return true if the player is in the Vorkath region, false otherwise
	 */
	private boolean isAtVorkath()
	{
		return ArrayUtils.contains(client.getMapRegions(), VORKATH_REGION);
	}

	private void addAcidSpot(WorldPoint acidSpotLocation)
	{
		if (!acidSpots.contains(acidSpotLocation))
		{
			acidSpots.add(acidSpotLocation);
		}
	}

	private void calculateAcidFreePath()
	{
		acidFreePath.clear();

		final int[][][] directions = {
			{
				{0, 1}, {0, -1} // Positive and negative Y
			},
			{
				{1, 0}, {-1, 0} // Positive and negative X
			}
		};

		List<WorldPoint> bestPath = new ArrayList<>();
		double bestClicksRequired = 99;

		final WorldPoint playerLoc = client.getLocalPlayer().getWorldLocation();
		final WorldPoint vorkLoc = vorkath.getVorkath().getWorldLocation();
		final int maxX = vorkLoc.getX() + 14;
		final int minX = vorkLoc.getX() - 8;
		final int maxY = vorkLoc.getY() - 1;
		final int minY = vorkLoc.getY() - 8;

		// Attempt to search an acid free path, beginning at a location
		// adjacent to the player's location (including diagonals)
		for (int x = -1; x < 2; x++)
		{
			for (int y = -1; y < 2; y++)
			{
				final WorldPoint baseLocation = new WorldPoint(playerLoc.getX() + x,
					playerLoc.getY() + y, playerLoc.getPlane());

				if (acidSpots.contains(baseLocation) || baseLocation.getY() < minY || baseLocation.getY() > maxY)
				{
					continue;
				}

				// Search in X and Y direction
				for (int d = 0; d < directions.length; d++)
				{
					// Calculate the clicks required to start walking on the path
					double currentClicksRequired = Math.abs(x) + Math.abs(y);
					if (currentClicksRequired < 2)
					{
						currentClicksRequired += Math.abs(y * directions[d][0][0]) + Math.abs(x * directions[d][0][1]);
					}
					if (d == 0)
					{
						// Prioritize a path in the X direction (sideways)
						currentClicksRequired += 0.5;
					}

					List<WorldPoint> currentPath = new ArrayList<>();
					currentPath.add(baseLocation);

					// Positive X (first iteration) or positive Y (second iteration)
					for (int i = 1; i < 25; i++)
					{
						final WorldPoint testingLocation = new WorldPoint(baseLocation.getX() + i * directions[d][0][0],
							baseLocation.getY() + i * directions[d][0][1], baseLocation.getPlane());

						if (acidSpots.contains(testingLocation) || testingLocation.getY() < minY || testingLocation.getY() > maxY
							|| testingLocation.getX() < minX || testingLocation.getX() > maxX)
						{
							break;
						}

						currentPath.add(testingLocation);
					}

					// Negative X (first iteration) or positive Y (second iteration)
					for (int i = 1; i < 25; i++)
					{
						final WorldPoint testingLocation = new WorldPoint(baseLocation.getX() + i * directions[d][1][0],
							baseLocation.getY() + i * directions[d][1][1], baseLocation.getPlane());

						if (acidSpots.contains(testingLocation) || testingLocation.getY() < minY || testingLocation.getY() > maxY
							|| testingLocation.getX() < minX || testingLocation.getX() > maxX)
						{
							break;
						}

						currentPath.add(testingLocation);
					}

					if (currentPath.size() >= this.acidFreePathLength && currentClicksRequired < bestClicksRequired
						|| (currentClicksRequired == bestClicksRequired && currentPath.size() > bestPath.size()))
					{
						bestPath = currentPath;
						bestClicksRequired = currentClicksRequired;
					}
				}
			}
		}

		if (bestClicksRequired != 99)
		{
			acidFreePath = bestPath;
		}
	}

	private void calculateWooxWalkPath()
	{
		wooxWalkTimer = -1;

		updateWooxWalkBar();

		final WorldPoint playerLoc = client.getLocalPlayer().getWorldLocation();
		final WorldPoint vorkLoc = vorkath.getVorkath().getWorldLocation();
		final int maxX = vorkLoc.getX() + 14;
		final int minX = vorkLoc.getX() - 8;
		final int baseX = playerLoc.getX();
		final int baseY = vorkLoc.getY() - 5;
		final int middleX = vorkLoc.getX() + 3;

		// Loop through the arena tiles in the x-direction and
		// alternate between positive and negative x direction
		for (int i = 0; i < 50; i++)
		{
			// Make sure we always choose the spot closest to
			// the middle of the arena
			int directionRemainder = 0;
			if (playerLoc.getX() < middleX)
			{
				directionRemainder = 1;
			}

			int deviation = (int) Math.floor(i / 2.0);
			if (i % 2 == directionRemainder)
			{
				deviation = -deviation;
			}

			final WorldPoint attackLocation = new WorldPoint(baseX + deviation, baseY, playerLoc.getPlane());
			final WorldPoint outOfRangeLocation = new WorldPoint(baseX + deviation, baseY - 1, playerLoc.getPlane());

			if (acidSpots.contains(attackLocation) || acidSpots.contains(outOfRangeLocation)
				|| attackLocation.getX() < minX || attackLocation.getX() > maxX)
			{
				continue;
			}

			wooxWalkPath[0] = attackLocation;
			wooxWalkPath[1] = outOfRangeLocation;

			break;
		}
	}

	private void updateWooxWalkBar()
	{
		// Update the WooxWalk tick indicator's dimensions
		// based on the canvas dimensions
		final Widget exp = client.getWidget(WidgetInfo.EXPERIENCE_TRACKER);

		if (exp == null)
		{
			return;
		}

		final Rectangle screen = exp.getBounds();

		int width = (int) Math.floor(screen.getWidth() / 2.0);
		if (width % 2 == 1)
		{
			width++;
		}
		int height = (int) Math.floor(width / 20.0);
		if (height % 2 == 1)
		{
			height++;
		}
		final int x = (int) Math.floor(screen.getX() + width / 2.0);
		final int y = (int) Math.floor(screen.getY() + screen.getHeight() - 2 * height);
		wooxWalkBar = new Rectangle(x, y, width, height);
	}

	private void updateConfig()
	{
		this.indicateAcidPools = config.indicateAcidPools();
		this.indicateAcidFreePath = config.indicateAcidFreePath();
		this.indicateWooxWalkPath = config.indicateWooxWalkPath();
		this.indicateWooxWalkTick = config.indicateWooxWalkTick();
		this.acidFreePathLength = config.acidFreePathLength();
	}

	private void reset()
	{
		overlayManager.remove(overlay);
		overlayManager.remove(acidPathOverlay);
		vorkath = null;
		acidSpots.clear();
		acidFreePath.clear();
		Arrays.fill(wooxWalkPath, null);
		wooxWalkTimer = -1;
		zombifiedSpawn = null;
	}
}