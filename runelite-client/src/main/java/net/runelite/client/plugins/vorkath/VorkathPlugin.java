package net.runelite.client.plugins.vorkath;

import com.google.common.eventbus.Subscribe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Projectile;
import net.runelite.api.ProjectileID;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.LocalPlayerDeath;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@PluginDescriptor(
		name = "Vorkath"
)

@Slf4j
public class VorkathPlugin extends Plugin
{
	private static final int ANIMATION_VORKATH_WAKE_UP = 7950;
	private static final int ANIMATION_VORKATH_DEATH = 7949;
	private static final int ANIMATION_SPAWN_DEATH = 7891;

	private static final String NPC_NAME_VORKATH = "Vorkath";
	private static final String NPC_NAME_SPAWN = "Zombified Spawn";
	private static final int ATTACKS_AMOUNT_BETWEEN_SPECIAL_ATTACK = 6;
	private static final int AMOUNT_OF_POISON_BOLTS = 25;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private VorkathAttacksOverlay vorkathAttacksOverlay;

	@Inject
	private VorkathSceneOverlay vorkathSceneOverlay;

	@Getter
	private int normalAttackCounter;

	@Getter
	private int poisonBoltsCounter = 0;

	@Getter
	private boolean isInVorkathArea;

	@Getter
	private VorkathState vorkathState;

	private VorkathState nextSpecialAttack;

	@Getter
	private LocalPoint fireBombHitLocation;

	@Getter
	private NPC spawnNpc;

	boolean isZombieSpawnAlive = false;


	VorkathState getNextSpecialAttack()
	{
		if (nextSpecialAttack == null)
		{
			return VorkathState.IDLE;
		}
		return nextSpecialAttack;
	}

	int getAttacksAmountUntilSpecialAttack(){
		return ATTACKS_AMOUNT_BETWEEN_SPECIAL_ATTACK - normalAttackCounter;
	}

	int getAmountOfPoisonBoltsLeft(){
		return AMOUNT_OF_POISON_BOLTS - poisonBoltsCounter;
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(vorkathAttacksOverlay);
		overlayManager.add(vorkathSceneOverlay);
		reset();
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(vorkathAttacksOverlay);
		overlayManager.remove(vorkathSceneOverlay);
	}

	private void reset()
	{
		normalAttackCounter = 0;
		poisonBoltsCounter = 0;
		vorkathState = VorkathState.IDLE;
		nextSpecialAttack = VorkathState.IDLE;
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		Actor actor = event.getActor();
		if (actor instanceof NPC)
		{
			NPC npc = (NPC) actor;

			if (npc.getName() != null && npc.getName().equals(NPC_NAME_VORKATH))
			{
				switch (npc.getAnimation())
				{
					case ANIMATION_VORKATH_WAKE_UP:
						onCombatStarted();
						break;

					case ANIMATION_VORKATH_DEATH:
						onCombatEnded();
						break;
					case ANIMATION_SPAWN_DEATH:
						isZombieSpawnAlive = false;
				}
			}

		}
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned npcSpawned)
	{
		final NPC npc = npcSpawned.getNpc();
		final String npcName = npc.getName();

		if (npcName != null){
			if (npcName.contains(NPC_NAME_VORKATH)){
				isInVorkathArea = true;
				reset();
			} else if (npcName.contains(NPC_NAME_SPAWN)){
				spawnNpc = npc;
				isZombieSpawnAlive = true;
			}
}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		final NPC npc = npcDespawned.getNpc();
		final String npcName = npc.getName();

		if (npcName != null)
		{
			if (npcName.contains(NPC_NAME_VORKATH))
			{
				isInVorkathArea = false;
				reset();
			} else if (npcName.contains(NPC_NAME_SPAWN)) {
				isZombieSpawnAlive = false;
			}
		}
	}

	@Subscribe
	public void onProjectileMoved(ProjectileMoved event)
	{
		Projectile projectile = event.getProjectile();

		if (projectile.getInteracting() != null &&
				client.getGameCycle() >= projectile.getStartMovementCycle())
		{
			return;
		}

		int projectileId = projectile.getId();

		switch (projectileId)
		{
			case VorkathProjectileID.VORKATH_DRAGONBREATH:
				onDragonBreathAttack();
				break;

			case VorkathProjectileID.VORKATH_RANGED:
				onRangeAttack();
				break;

			case VorkathProjectileID.VORKATH_MAGIC:
				onMagicAttack();
				break;

			case VorkathProjectileID.VORKATH_VENOM:
				onVenomAttack();
				break;

			case VorkathProjectileID.VORKATH_PRAYER_DISABLE:
				onPrayerDisableAttack();
				break;

			case VorkathProjectileID.VORKATH_BOMB_AOE:
				onFireBombAttack();
				break;

			case VorkathProjectileID.VORKATH_FREEZE:
				onFreezeAttack();
				break;

			case VorkathProjectileID.VORKATH_SPAWN_AOE:
				onMinionSpawn();
				break;

			case ProjectileID.VORKATH_TICK_FIRE_AOE:
				onPoisonFireAttack();
				break;
		}

	}

	@Subscribe
	public void onGameState(GameStateChanged event)
	{
		GameState gs = event.getGameState();
		if (gs == GameState.LOGGING_IN ||
				gs == GameState.CONNECTION_LOST ||
				gs == GameState.HOPPING)
		{
			reset();
		}
	}

	@Subscribe
	public void onLocalPlayerDeath(LocalPlayerDeath player)
	{
		reset();
	}

	private void onCombatStarted()
	{
		reset();
	}

	private void onCombatEnded()
	{
		reset();
	}

	private void onDragonBreathAttack()
	{
		normalAttackCounter++;
		vorkathState = VorkathState.DRAGON_BREATH_ATTACK;
	}

	private void onRangeAttack()
	{
		normalAttackCounter++;
		vorkathState = VorkathState.RANGED_ATTACK;
	}

	private void onMagicAttack()
	{
		normalAttackCounter++;
		vorkathState = VorkathState.MAGIC_ATTACK;
	}

	private void onVenomAttack()
	{
		normalAttackCounter++;
		System.out.println("venom");
		vorkathState = VorkathState.VENOM_ATTACK;
	}

	private void onFireBombAttack()
	{
		normalAttackCounter++;
		fireBombHitLocation = client.getLocalPlayer().getLocalLocation();
		vorkathState = VorkathState.FIRE_BOMB_ATTACK;
	}

	private void onPrayerDisableAttack()
	{
		normalAttackCounter++;
		System.out.println("prayer");
		vorkathState = VorkathState.PRAYER_DISABLE_ATTACK;
	}

	private void onFreezeAttack()
	{
		normalAttackCounter = 0;
		vorkathState = VorkathState.FREEZE_SPECIAL_ATTACK;
		nextSpecialAttack = VorkathState.POISON_FIRE_SPECIAL_ATTACK;
	}

	private void onPoisonFireAttack()
	{
		normalAttackCounter = 0;
		poisonBoltsCounter++;
		if (poisonBoltsCounter == AMOUNT_OF_POISON_BOLTS){
			System.out.println("done");
			poisonBoltsCounter = 0;
		}
		vorkathState = VorkathState.POISON_FIRE_SPECIAL_ATTACK;
		nextSpecialAttack = VorkathState.FREEZE_SPECIAL_ATTACK;
	}

	private void onMinionSpawn()
	{
		System.out.println("spawn");
	}

}