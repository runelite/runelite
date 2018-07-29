package net.runelite.client.plugins.mining;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.QueryRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@PluginDescriptor(
		name = "Mining",
		description = "Shows you mining spots and the type of ore with respawn times.",
		tags = {"mining"}
)

public class miningPlugin extends Plugin {

	@Inject
	private Client client;

	private QueryRunner queryRunner;

	@Inject
	private miningPlugin plugin;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private net.runelite.client.plugins.mining.miningRockOverlay miningRockOverlay;

	@Inject
	private net.runelite.client.plugins.mining.miningOverlay miningOverlay;

	private Boolean isMining = false;

	private Long timeLastMined = 0L;

	private int displaySinceLastMined = 30;

	private int oresMined = 0;

	public static boolean menuInt = false;

	private int miningAnimations[] =
			{
					AnimationID.MINING_BRONZE_PICKAXE,
	AnimationID.MINING_IRON_PICKAXE,
	AnimationID.MINING_STEEL_PICKAXE,
	AnimationID.MINING_BLACK_PICKAXE,
	AnimationID.MINING_MITHRIL_PICKAXE,
	AnimationID.MINING_ADAMANT_PICKAXE,
	AnimationID.MINING_RUNE_PICKAXE,
	AnimationID.MINING_DRAGON_PICKAXE,
	AnimationID.MINING_DRAGON_PICKAXE_ORN,
	AnimationID.MINING_3A_PICKAXE,
					AnimationID.MINING_INFERNAL_PICKAXE
			};

   // @Getter(AccessLevel.PACKAGE)
	private List<GameObject> rockObjects = new ArrayList<>();

  //  @Getter(AccessLevel.PACKAGE)
	private List<GameObject> despawnedrockObjects = new ArrayList<>();
	private HashMap<Point,Long> despawnedrockObjectsTimers = new HashMap<>();




	@Override
	protected void startUp() {
		overlayManager.add(miningRockOverlay);
		overlayManager.add(miningOverlay);

	}

	@Override
	protected void shutDown() {
		overlayManager.remove(miningRockOverlay);
		overlayManager.remove(miningOverlay);
		rockObjects.clear();
		despawnedrockObjects.clear();
		getDespawnedRockObjectsTimers();

	}


	public List<GameObject> getRockObjects() {
		return rockObjects;
	}

	public List<GameObject> getDespawnedRockObjects() {
		return despawnedrockObjects;
	}

	public HashMap<Point, Long> getDespawnedRockObjectsTimers() {
		return despawnedrockObjectsTimers;
	}

	public Boolean isMining() {
		return isMining;
	}

	public void setMining(Boolean bool) {
		isMining = bool;
		setTimeLastMined(System.currentTimeMillis());
	}

	public Long getTimeLastMined() {
		return timeLastMined;
	}

	public void setTimeLastMined(Long l) {
		timeLastMined = l;
	}

	public int getDisplaySinceLastMined() {
		return displaySinceLastMined;
	}

	public void addOreMined() {
		oresMined++;
	}

	public int getOresMined() {
		return oresMined;
	}



	@Subscribe
	public void onAnimationChanged(final AnimationChanged event) {
		if (event != null) {
			if (event.getActor() == client.getLocalPlayer()) {
				int animation = event.getActor().getAnimation();
				boolean im = false;
				for (int id : miningAnimations) {
					if (animation == id) {
						setMining(true);
						menuInt = true;
						im = true;
						break;
					}
				}
				if (!im) {
					setMining(false);
				}
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage) {
		if (chatMessage != null) {
			if (chatMessage.getMessage() != null) {
				if (chatMessage.getType() == ChatMessageType.FILTERED) {
					if (chatMessage.getMessage().contains("You manage to mine some")) {
						addOreMined();
					}
				}
			}
		}
	}


	@Subscribe
	public void onGameObjectSpawned(final GameObjectSpawned event) {
		if (event != null) {
			GameObject gameObject = event.getGameObject();
			if (gameObject != null) {
				if (Rock.isRock(gameObject.getId())) {
					boolean found = false;
					for (GameObject go : rockObjects) {
						if (go.getWorldLocation().getX() == gameObject.getWorldLocation().getX() && go.getWorldLocation().getY() == gameObject.getWorldLocation().getY()) {
							found = true;
							break;
						}
					}
					if (!found) {
						if (gameObject.getWorldLocation() != null) {
							rockObjects.add(gameObject);
						}
					}

					for (GameObject gameObject1 : despawnedrockObjects) {
						if (despawnedrockObjects != null) {
							if (gameObject.getWorldLocation().equals(gameObject1.getWorldLocation())) {
								despawnedrockObjects.remove(gameObject1);
								break;
							}
						}

					}


			}


			}

		}
	}
	@Subscribe
	public void onGameObjectDespawned(final GameObjectDespawned event) {
		if (event != null) {
			GameObject gameObject = event.getGameObject();
			if (gameObject != null) {
				if (Rock.isRock(gameObject.getId())) {
					rockObjects.remove(gameObject);
						despawnedrockObjects.add(gameObject);
						despawnedrockObjectsTimers.put(new Point(gameObject.getWorldLocation().getX(), gameObject.getWorldLocation().getY()),System.currentTimeMillis());
				}
			}

		}
	}



	@Subscribe
	public void onGameStateChange(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN || event.getGameState() == GameState.HOPPING || event.getGameState() == GameState.LOADING)
		{
			rockObjects.clear();
		  despawnedrockObjects.clear();
			despawnedrockObjectsTimers.clear();
		}
	}




}
