package net.runelite.client.plugins.alchemicalhydra;

import java.util.Arrays;
import java.util.HashSet;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NpcID;
import net.runelite.api.Projectile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Alchemical Hydra",
	description = "Show what to pray against hydra",
	tags = {"Hydra", "Lazy", "4 headed asshole"},
	type = PluginType.PVM
)
@Slf4j
public class HydraPlugin extends Plugin
{
	@Getter
	private HashSet<LocalPoint> poisonPoints = new HashSet<>();

	@Getter
	private Hydra hydra;

	private boolean inHydraInstance;
	private int lastAttackTick;
	private int lastPoisonTick;

	private static final int[] HYDRA_REGIONS = {
		5279, 5280,
		5535, 5536
	};

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private HydraOverlay overlay;

	@Inject
	private HydraPoisonOverlay poisonOverlay;

	@Override
	protected void startUp()
	{
		inHydraInstance = checkArea();
		lastAttackTick = -1;
		poisonPoints.clear();
	}

	@Override
	protected void shutDown()
	{
		inHydraInstance = false;
		hydra = null;
		poisonPoints.clear();
		removeOverlays();
		lastAttackTick = -1;
	}

	@Subscribe
	private void onGameStateChanged(GameStateChanged state)
	{
		if (state.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		inHydraInstance = checkArea();

		if (inHydraInstance)
		{
			hydra = new Hydra();
			log.debug("Entered hydra instance");
			addOverlays();
		}
		else if (hydra != null)
		{
			removeOverlays();
			hydra = null;
			log.debug("Left hydra instance");
		}
	}

	@Subscribe
	private void onNpcSpawned(NpcSpawned event)
	{
		if (!inHydraInstance || event.getNpc().getId() != NpcID.ALCHEMICAL_HYDRA)
		{
			return;
		}

		hydra = new Hydra();
		log.debug("Hydra spawned");
		addOverlays();
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged animationChanged)
	{
		Actor actor = animationChanged.getActor();

		if (!inHydraInstance || hydra == null || actor == client.getLocalPlayer())
		{
			return;
		}

		HydraPhase phase = hydra.getPhase();

		// Using the first animation sometimes fucks shit up, so just use 2
		if ( /* actor.getAnimation() == phase.getDeathAnim1() || */ actor.getAnimation() == phase.getDeathAnim2())
		{
			switch (phase)
			{
				case ONE:
					changePhase(HydraPhase.TWO);
					log.debug("Hydra phase 2");
					return;
				case TWO:
					changePhase(HydraPhase.THREE);
					log.debug("Hydra phase 3");
					return;
				case THREE:
					changePhase(HydraPhase.FOUR);
					log.debug("Hydra phase 4");
					return;
				case FOUR:
					hydra = null;
					poisonPoints.clear();
					log.debug("Hydra dead");
					removeOverlays();
					return;
				default:
					log.debug("Tried some weird shit");
					break;
			}

			if (actor.getAnimation() == phase.getDeathAnim1() && phase == HydraPhase.THREE)
			{
				changePhase(HydraPhase.FOUR);
			}
		}
		else if (actor.getAnimation() == phase.getSpecAnimationId() && phase.getSpecAnimationId() != 0)
		{
			hydra.setNextSpecial(hydra.getNextSpecial() + 9);
		}

		if (!poisonPoints.isEmpty() && lastPoisonTick + 10 < client.getTickCount())
		{
			poisonPoints.clear();
		}
	}

	@Subscribe
	public void onProjectileMoved(ProjectileMoved event)
	{
		if (!inHydraInstance || hydra == null
			|| client.getGameCycle() >= event.getProjectile().getStartMovementCycle())
		{
			return;
		}

		Projectile projectile = event.getProjectile();
		int id = projectile.getId();
		if (hydra.getPhase().getSpecProjectileId() != 0 && hydra.getPhase().getSpecProjectileId() == id)
		{
			poisonPoints.add(event.getPosition());
			hydra.setNextSpecial(hydra.getNextSpecial() + 9);
			lastPoisonTick = client.getTickCount();
		}
		else if (client.getTickCount() != lastAttackTick
			&& (id == Hydra.AttackStyle.MAGIC.getProjId() || id == Hydra.AttackStyle.RANGED.getProjId()))
		{
			handleAttack(id);
			lastAttackTick = client.getTickCount();
		}
	}

	private boolean checkArea()
	{
		return Arrays.equals(client.getMapRegions(), HYDRA_REGIONS) && client.isInInstancedRegion();
	}

	private void addOverlays()
	{
		overlayManager.add(overlay);
		overlayManager.add(poisonOverlay);
	}

	private void removeOverlays()
	{
		overlayManager.remove(overlay);
		overlayManager.remove(poisonOverlay);
	}

	private void changePhase(HydraPhase newPhase)
	{
		hydra.setPhase(newPhase);
		hydra.setNextSpecial(3);
		hydra.setAttackCount(0);
		if (newPhase == HydraPhase.FOUR)
		{
			switchStyles();
			hydra.setNextSwitch(newPhase.getAttacksPerSwitch());
		}
	}

	private void switchStyles()
	{
		hydra.setNextAttack(hydra.getLastAttack() == Hydra.AttackStyle.MAGIC
			? Hydra.AttackStyle.RANGED
			: Hydra.AttackStyle.MAGIC);
	}

	private void handleAttack(int id)
	{
		hydra.setNextSwitch(hydra.getNextSwitch() - 1);
		hydra.setAttackCount(hydra.getAttackCount() + 1);
		hydra.setLastAttack(hydra.getNextAttack());

		if (id != hydra.getNextAttack().getProjId())
		{
			switchStyles();
		}
		else if (hydra.getNextSwitch() <= 0)
		{
			switchStyles();
			hydra.setNextSwitch(hydra.getPhase().getAttacksPerSwitch());
		}
	}
}
