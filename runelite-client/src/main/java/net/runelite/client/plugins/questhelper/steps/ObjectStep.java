package net.runelite.client.plugins.questhelper.steps;

import com.google.common.primitives.Ints;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.ObjectComposition;
import net.runelite.api.Point;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.questhelper.QuestHelperPlugin;
import net.runelite.client.plugins.questhelper.QuestHelperWorldMapPoint;
import static net.runelite.client.plugins.questhelper.QuestHelperWorldOverlay.CLICKBOX_BORDER_COLOR;
import static net.runelite.client.plugins.questhelper.QuestHelperWorldOverlay.CLICKBOX_FILL_COLOR;
import static net.runelite.client.plugins.questhelper.QuestHelperWorldOverlay.CLICKBOX_HOVER_BORDER_COLOR;
import net.runelite.client.plugins.questhelper.questhelpers.QuestHelper;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;

public class ObjectStep extends QuestStep
{
	@Inject
	private Client client;

	@Inject
	private WorldMapPointManager worldMapPointManager;

	private int objectID;
	private WorldPoint worldPoint;
	private TileObject object;

	public ObjectStep(QuestHelper questHelper, int objectID, WorldPoint worldPoint, String text)
	{
		super(questHelper, text);
		this.objectID = objectID;
		this.worldPoint = worldPoint;
	}

	@Override
	public void startUp()
	{
		worldMapPointManager.add(new QuestHelperWorldMapPoint(worldPoint, getQuestImage()));

		LocalPoint localPoint = LocalPoint.fromWorld(client, worldPoint);
		if (localPoint == null)
		{
			return;
		}

		Tile tile = client.getScene().getTiles()[client.getPlane()][localPoint.getSceneX()][localPoint.getSceneY()];
		for (GameObject object : tile.getGameObjects())
		{
			handleObjects(object);
		}

		handleObjects(tile.getDecorativeObject());
	}

	@Override
	public void shutDown()
	{
		worldMapPointManager.removeIf(QuestHelperWorldMapPoint.class::isInstance);
		client.clearHintArrow();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			object = null;
		}
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		handleObjects(event.getGameObject());
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		if (event.getGameObject().equals(object))
		{
			object = null;
			client.clearHintArrow();
		}
	}

	@Subscribe
	public void onDecorativeObjectSpawned(DecorativeObjectSpawned event)
	{
		handleObjects(event.getDecorativeObject());
	}

	@Subscribe
	public void onDecorativeObjectDespawned(DecorativeObjectDespawned event)
	{
		if (event.getDecorativeObject().equals(object))
		{
			object = null;
			client.clearHintArrow();
		}
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, QuestHelperPlugin plugin)
	{
		if (object == null)
		{
			return;
		}

		Point mousePosition = client.getMouseCanvasPosition();
		OverlayUtil.renderHoverableArea(graphics, object.getClickbox(), mousePosition,
			CLICKBOX_FILL_COLOR, CLICKBOX_BORDER_COLOR, CLICKBOX_HOVER_BORDER_COLOR);
	}

	private void handleObjects(TileObject object)
	{
		if (this.object != null || object == null)
		{
			return;
		}

		if (object.getWorldLocation().equals(worldPoint))
		{
			if (object.getId() == objectID)
			{
				this.object = object;
				client.setHintArrow(worldPoint);
				return;
			}

			// Check impostors
			final ObjectComposition comp = client.getObjectDefinition(object.getId());
			final int[] impostorIds = comp.getImpostorIds();

			if (impostorIds != null && Ints.contains(comp.getImpostorIds(), objectID))
			{
				this.object = object;
				client.setHintArrow(worldPoint);	//TODO: better object arrows, probably hydrox's thing
			}
		}
	}
}
