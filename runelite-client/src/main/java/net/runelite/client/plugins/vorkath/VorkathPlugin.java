package net.runelite.client.plugins.vorkath;

import com.google.common.eventbus.Subscribe;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MapRegionChanged;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Arrays;
import java.util.Collection;

@PluginDescriptor(name = "Vorkath")
@Singleton
public class VorkathPlugin extends Plugin
{

	private static final int POISON_PHASE = 1;
	private static final int SPIDER_PHASE = 2;
	@Inject
	private Client client;
	@Inject
	private VorkathOverlay vorkathOverlay;
	@Getter
	private Player player;
	@Getter(AccessLevel.PACKAGE)
	private Projectile currentProjectile;

	@Getter(AccessLevel.PACKAGE)
	private int attacksInARow = 0;

	@Getter(AccessLevel.PACKAGE)
	private int nextPhase = -1;

	@Getter(AccessLevel.PACKAGE)
	private boolean atVorkath = false;

	@Subscribe
	public void onGameTick(GameTick event)
	{

		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}
	}

	@Subscribe
	public void onRegionChanged(MapRegionChanged event)
	{
		if (atVorkath)
			onLeaveInstance();
	}

	/**
	 * Process the incoming attacks from Vorkath
	 * @param event
	 */
	@Subscribe
	public void onProjectile(ProjectileMoved event)
	{
		if (!atVorkath)
			return;

		// Process the projectile only if aimed at the attacking player
		if (event.getProjectile().getInteracting() != null)
			if (event.getProjectile().getInteracting() != client.getLocalPlayer())
				return;

		currentProjectile = event.getProjectile();

		/**
		 * Resets the attack counter if we encounter a special phase
		 * Increments the counter only if vorkath uses a normal attack
		 */
		if (currentProjectile.getId() == ProjectileID.VORKATH_FREEZE)
		{
			attacksInARow = 0;
			nextPhase = POISON_PHASE;
		}
		else if (currentProjectile.getId() == ProjectileID.VORKATH_POISON_POOL_AOE)
		{
			attacksInARow = 0;
			nextPhase = SPIDER_PHASE;
		}
		else if (currentProjectile.getId() == ProjectileID.VORKATH_TICK_FIRE_AOE || currentProjectile.getId() == ProjectileID.VORKATH_SPAWN_AOE)
		{

		}
		else
		{
			if (client.getGameCycle() == currentProjectile.getStartMovementCycle())
				++attacksInARow;
		}
	}

	/**
	 * Initialises a new plugin only if we enter the lair
	 * or if vorkath is dead and we're still in the lair.
	 * Otherwise, shutdown the plugin.
	 * @param event
	 */
	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		NPC npc = event.getNpc();
		if (npc.getId() == NpcID.VORKATH_8059)
		{
			init();
		}
		else if (npc.getId() == NpcID.VORKATH_8058)
		{
			onLeaveInstance();
		}
	}

	// When you enter the lair or when vorkath dies
	private void init()
	{
		atVorkath = true;
		attacksInARow = 0;
		nextPhase = -1;
	}

	private void shutdown()
	{
		atVorkath = false;
		attacksInARow = 0;
		nextPhase = -1;
	}

	private void onLeaveInstance()
	{
		shutdown();
	}

	@Override
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(vorkathOverlay);
	}
}
