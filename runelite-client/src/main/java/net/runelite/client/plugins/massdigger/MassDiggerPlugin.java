package net.runelite.client.plugins.massdigger;

import com.google.common.io.CharStreams;
import com.google.gson.Gson;
import com.google.inject.Provides;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.geometry.Geometry;
import net.runelite.client.RuneLite;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Mass digger",
	description = "Tracks mass digging",
	tags = {"mass", "digger", "spade"},
	enabledByDefault = false
)
@Slf4j
public class MassDiggerPlugin extends Plugin
{
	private static final File DIG_FOLDER = new File(RuneLite.RUNELITE_DIR, "mass-digger");
	private static final File DUG_LOCATIONS_FILE = new File(DIG_FOLDER, "dug-locations.json");
	private static final int DIG_ANIMATION = 830;
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static final Gson gson = new Gson();
	private static final int DIG_RADIUS = 1;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MassDiggerOverlay overlay;

	private Map<DigGroup, DugLocations> digGroups;
	private DigGroup currentDigGroup;
	private boolean wasLoggedIn;
	private Area dugArea;
	@Getter
	private GeneralPath dugPath;
	private WorldPointMarker[] digMarkers;
	@Getter
	private Set<WorldPointMarker> sceneDigMarkers;

	@Provides
	MassDiggerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MassDiggerConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		digGroups = new HashMap<>();
		dugArea = new Area();
		loadFiles();
		updateDugArea();
		overlayManager.add(overlay);

		clientThread.invokeLater(() ->
		{
			updateDigGroup(client.getItemContainer(InventoryID.INVENTORY));
			updateDugArea();
		});
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		saveFiles();
		digMarkers = null;
		digGroups = null;
		dugArea = null;
		currentDigGroup = null;
	}

	private void loadFiles()
	{
		try
		{
			String json = CharStreams.toString(new InputStreamReader(getClass().getResourceAsStream("dig-sections.json")));
			this.digMarkers = gson.fromJson(json, WorldPointMarker[].class);

			if (DUG_LOCATIONS_FILE.isFile())
			{
				DugLocations[] dugLocations = gson.fromJson(new FileReader(DUG_LOCATIONS_FILE), DugLocations[].class);
				this.digGroups = new HashMap<>();
				for (DugLocations dl : dugLocations)
				{
					this.digGroups.put(dl.getGroup(), dl);
				}
			}
		}
		catch (IOException ex)
		{
			log.error("Failed to load mass-digger files", ex);
		}
	}

	private void saveFiles()
	{
		try
		{
			DIG_FOLDER.mkdirs();

			FileWriter fw;

			fw = new FileWriter(DUG_LOCATIONS_FILE, false);
			gson.toJson(digGroups.values(), fw);
			fw.close();
		}
		catch (IOException ex)
		{
			log.error("Failed to save mass-digger files", ex);
		}
	}

	private void updateDigGroup(ItemContainer inventory)
	{
		if (inventory == null)
		{
			return;
		}

		currentDigGroup = new DigGroup(Arrays.stream(inventory.getItems()).filter(x -> x != null &&
			!client.getItemDefinition(x.getId()).isMembers() &&
			x.getId() != ItemID.VIAL && x.getId() != -1 && x.getQuantity() != 0)
			.sorted((i1, i2) -> i1.getId() - i2.getId())
			.map(x -> new InventoryItem(x.getId(), x.getQuantity()))
			.toArray(InventoryItem[]::new));
	}

	private boolean isInScene(int x, int y)
	{
		int x1 = client.getBaseX();
		int y1 = client.getBaseY();
		int x2 = x1 + Constants.SCENE_SIZE;
		int y2 = y1 + Constants.SCENE_SIZE;
		return x >= x1 && x < x2 && y >= y1 && y < y2;
	}

	private void updateSceneDigLocations()
	{
		sceneDigMarkers = new HashSet<>();
		for (WorldPointMarker wpm : digMarkers)
		{
			if (isInScene(wpm.getX(), wpm.getY()))
			{
				sceneDigMarkers.add(wpm);
			}
		}
		DugLocations dl = this.digGroups.get(currentDigGroup);
		if (dl != null)
		{
			for (WorldPoint wp : dl.getLocations())
			{
				sceneDigMarkers.remove(new WorldPointMarker(wp.getX(), wp.getY(), wp.getPlane(), 0));
			}
		}
	}

	private void updateDugArea()
	{
		updateSceneDigLocations();

		dugArea = new Area();

		DugLocations dugLocations = digGroups.get(currentDigGroup);
		if (dugLocations == null)
		{
			return;
		}

		for (WorldPoint wp : dugLocations.getLocations())
		{
			if (wp.getPlane() != client.getPlane())
			{
				continue;
			}

			if (isInScene(wp.getX(), wp.getY()))
			{
				dugArea.add(new Area(new Rectangle(
					wp.getX() - DIG_RADIUS,
					wp.getY() - DIG_RADIUS,
					DIG_RADIUS * 2 + 1,
					DIG_RADIUS * 2 + 1)));
			}
		}

		Rectangle viewArea = new Rectangle(
			client.getBaseX(),
			client.getBaseY(),
			Constants.SCENE_SIZE,
			Constants.SCENE_SIZE);
		dugPath = new GeneralPath(dugArea);

		dugPath = Geometry.clipPath(dugPath, viewArea);
	}

	@Subscribe
	public void onCommandExecuted(CommandExecuted event)
	{
		if (!event.getCommand().toLowerCase().equals("digger"))
		{
			return;
		}

		if (event.getArguments().length >= 1 && event.getArguments()[0].toLowerCase().equals("save"))
		{
			saveFiles();
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer() == client.getItemContainer(InventoryID.INVENTORY))
		{
			updateDigGroup(event.getItemContainer());
			updateDugArea();
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN)
		{
			if (wasLoggedIn)
			{
				saveFiles();
			}

			wasLoggedIn = false;
		}

		if (event.getGameState() == GameState.LOGGED_IN)
		{
			wasLoggedIn = true;
			updateDugArea();
		}
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		Player player = client.getLocalPlayer();
		if (event.getActor() != player)
		{
			return;
		}

		if (!client.isInInstancedRegion() && player.getAnimation() == DIG_ANIMATION)
		{
			DugLocations jsonGroup = digGroups.get(currentDigGroup);
			if (jsonGroup == null)
			{
				jsonGroup = new DugLocations();
				jsonGroup.setGroup(currentDigGroup);
				jsonGroup.setLocations(new HashSet<>());
				digGroups.put(currentDigGroup, jsonGroup);
			}
			jsonGroup.getLocations().add(player.getWorldLocation());

			updateDugArea();
		}
	}
}
