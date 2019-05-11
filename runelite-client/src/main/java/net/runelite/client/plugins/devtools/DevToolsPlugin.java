/*
 * Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
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

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import static java.lang.Math.min;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.BoostedLevelChanged;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.kit.KitType;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.JagexColors;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;
import org.slf4j.LoggerFactory;

@PluginDescriptor(
	name = "Developer Tools",
	tags = {"panel"},
	developerPlugin = true
)
@Getter
public class DevToolsPlugin extends Plugin
{
	private static final List<MenuAction> EXAMINE_MENU_ACTIONS = ImmutableList.of(MenuAction.EXAMINE_ITEM,
			MenuAction.EXAMINE_ITEM_GROUND, MenuAction.EXAMINE_NPC, MenuAction.EXAMINE_OBJECT);

	@Inject
	private Client client;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private DevToolsOverlay overlay;

	@Inject
	private LocationOverlay locationOverlay;

	@Inject
	private SceneOverlay sceneOverlay;

	@Inject
<<<<<<< HEAD
=======
	private CameraOverlay cameraOverlay;

	@Inject
	private WorldMapLocationOverlay worldMapLocationOverlay;

	@Inject
<<<<<<< HEAD
>>>>>>> upstream/master
	private EventBus eventBus;

	private boolean togglePlayers;
	private boolean toggleNpcs;
	private boolean toggleGroundItems;
	private boolean toggleGroundObjects;
	private boolean toggleGameObjects;
	private boolean toggleWalls;
	private boolean toggleDecor;
	private boolean toggleInventory;
	private boolean toggleProjectiles;
	private boolean toggleLocation;
	private boolean toggleChunkBorders;
	private boolean toggleMapSquares;
	private boolean toggleValidMovement;
	private boolean toggleLineOfSight;
	private boolean toggleGraphicsObjects;
<<<<<<< HEAD
=======
	private boolean toggleCamera;
	private boolean toggleWorldMapLocation;
	private boolean toggleTileLocation;
>>>>>>> upstream/master

	Widget currentWidget;
	int itemIndex = -1;

	private Font font;
=======
	private WorldMapRegionOverlay mapRegionOverlay;

	@Inject
	private EventBus eventBus;

	private DevToolsButton players;
	private DevToolsButton npcs;
	private DevToolsButton groundItems;
	private DevToolsButton groundObjects;
	private DevToolsButton gameObjects;
	private DevToolsButton graphicsObjects;
	private DevToolsButton walls;
	private DevToolsButton decorations;
	private DevToolsButton inventory;
	private DevToolsButton projectiles;
	private DevToolsButton location;
	private DevToolsButton chunkBorders;
	private DevToolsButton mapSquares;
	private DevToolsButton validMovement;
	private DevToolsButton lineOfSight;
	private DevToolsButton cameraPosition;
	private DevToolsButton worldMapLocation ;
	private DevToolsButton tileLocation;
	private DevToolsButton interacting;
	private DevToolsButton examine;
	private DevToolsButton detachedCamera;
	private DevToolsButton widgetInspector;
	private DevToolsButton varInspector;
>>>>>>> upstream/master
	private NavigationButton navButton;

	@Provides
	DevToolsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DevToolsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		players = new DevToolsButton("Players");
		npcs = new DevToolsButton("NPCs");

		groundItems = new DevToolsButton("Ground Items");
		groundObjects = new DevToolsButton("Ground Objects");
		gameObjects = new DevToolsButton("Game Objects");
		graphicsObjects = new DevToolsButton("Graphics Objects");
		walls = new DevToolsButton("Walls");
		decorations = new DevToolsButton("Decorations");

		inventory = new DevToolsButton("Inventory");
		projectiles = new DevToolsButton("Projectiles");

		location = new DevToolsButton("Location");
		worldMapLocation = new DevToolsButton("World Map Location");
		tileLocation = new DevToolsButton("Tile Location");
		cameraPosition = new DevToolsButton("Camera Position");

		chunkBorders = new DevToolsButton("Chunk Borders");
		mapSquares = new DevToolsButton("Map Squares");

		lineOfSight = new DevToolsButton("Line Of Sight");
		validMovement = new DevToolsButton("Valid Movement");
		interacting = new DevToolsButton("Interacting");
		examine = new DevToolsButton("Examine");

		detachedCamera = new DevToolsButton("Detached Camera");
		widgetInspector = new DevToolsButton("Widget Inspector");
		varInspector = new DevToolsButton("Var Inspector");

		overlayManager.add(overlay);
		overlayManager.add(locationOverlay);
		overlayManager.add(sceneOverlay);
		overlayManager.add(cameraOverlay);
		overlayManager.add(worldMapLocationOverlay);
		overlayManager.add(mapRegionOverlay);

		final DevToolsPanel panel = injector.getInstance(DevToolsPanel.class);

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "devtools_icon.png");

		navButton = NavigationButton.builder()
<<<<<<< HEAD
			.name("Developer Tools")
			.icon(icon)
=======
			.tooltip("Developer Tools")
			.icon(icon)
			.priority(1)
>>>>>>> upstream/master
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown() throws Exception
	{
<<<<<<< HEAD
		pluginToolbar.removeNavigation(navButton);
	}

	@Override
	public Collection<Overlay> getOverlays()
	{
<<<<<<< HEAD
		return Arrays.asList(overlay, locationOverlay, sceneOverlay);
=======
		return Arrays.asList(overlay, locationOverlay, sceneOverlay, cameraOverlay, worldMapLocationOverlay);
>>>>>>> upstream/master
=======
		overlayManager.remove(overlay);
		overlayManager.remove(locationOverlay);
		overlayManager.remove(sceneOverlay);
		overlayManager.remove(cameraOverlay);
		overlayManager.remove(worldMapLocationOverlay);
		overlayManager.remove(mapRegionOverlay);
		clientToolbar.removeNavigation(navButton);
>>>>>>> upstream/master
	}

	@Subscribe
	public void onCommandExecuted(CommandExecuted commandExecuted)
	{
		String[] args = commandExecuted.getArguments();

		switch (commandExecuted.getCommand())
		{
			case "logger":
			{
				final Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
				String message;
				Level currentLoggerLevel = logger.getLevel();

				if (args.length < 1)
				{
					message = "Logger level is currently set to " + currentLoggerLevel;
				}
				else
				{
					Level newLoggerLevel = Level.toLevel(args[0], currentLoggerLevel);
					logger.setLevel(newLoggerLevel);
					message = "Logger level has been set to " + newLoggerLevel;
				}

				client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", message, null);
				break;
			}
			case "getvarp":
			{
				int varp = Integer.parseInt(args[0]);
				int value = client.getVarpValue(client.getVarps(), varp);
				client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "VarPlayer " + varp + ": " + value, null);
				break;
			}
			case "setvarp":
			{
				int varp = Integer.parseInt(args[0]);
				int value = Integer.parseInt(args[1]);
				client.setVarpValue(client.getVarps(), varp, value);
				client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Set VarPlayer " + varp + " to " + value, null);
				VarbitChanged varbitChanged = new VarbitChanged();
				varbitChanged.setIndex(varp);
				eventBus.post(varbitChanged); // fake event
				break;
			}
			case "getvarb":
			{
				int varbit = Integer.parseInt(args[0]);
<<<<<<< HEAD
				int value = client.getVarbitValue(varbit);
=======
				int value = client.getVarbitValue(client.getVarps(), varbit);
<<<<<<< HEAD
>>>>>>> upstream/master
				client.addChatMessage(ChatMessageType.SERVER, "", "Varbit " + varbit + ": " + value, null);
=======
				client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Varbit " + varbit + ": " + value, null);
>>>>>>> upstream/master
				break;
			}
			case "setvarb":
			{
				int varbit = Integer.parseInt(args[0]);
				int value = Integer.parseInt(args[1]);
<<<<<<< HEAD
				client.setVarbitValue(varbit, value);
=======
				client.setVarbitValue(client.getVarps(), varbit, value);
<<<<<<< HEAD
>>>>>>> upstream/master
				client.addChatMessage(ChatMessageType.SERVER, "", "Set varbit " + varbit + " to " + value, null);
=======
				client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Set varbit " + varbit + " to " + value, null);
>>>>>>> upstream/master
				eventBus.post(new VarbitChanged()); // fake event
				break;
			}
			case "addxp":
			{
				Skill skill = Skill.valueOf(args[0].toUpperCase());
				int xp = Integer.parseInt(args[1]);

				int totalXp = client.getSkillExperience(skill) + xp;
				int level = min(Experience.getLevelForXp(totalXp), 99);

				client.getBoostedSkillLevels()[skill.ordinal()] = level;
				client.getRealSkillLevels()[skill.ordinal()] = level;
				client.getSkillExperiences()[skill.ordinal()] = totalXp;

				client.queueChangedSkill(skill);

				ExperienceChanged experienceChanged = new ExperienceChanged();
				experienceChanged.setSkill(skill);
				eventBus.post(experienceChanged);
				break;
			}
			case "setstat":
			{
				Skill skill = Skill.valueOf(args[0].toUpperCase());
				int level = Integer.parseInt(args[1]);

				level = Ints.constrainToRange(level, 1, Experience.MAX_REAL_LEVEL);
				int xp = Experience.getXpForLevel(level);

				client.getBoostedSkillLevels()[skill.ordinal()] = level;
				client.getRealSkillLevels()[skill.ordinal()] = level;
				client.getSkillExperiences()[skill.ordinal()] = xp;

				client.queueChangedSkill(skill);

				ExperienceChanged experienceChanged = new ExperienceChanged();
				experienceChanged.setSkill(skill);
				eventBus.post(experienceChanged);

				BoostedLevelChanged boostedLevelChanged = new BoostedLevelChanged();
				boostedLevelChanged.setSkill(skill);
				eventBus.post(boostedLevelChanged);
				break;
			}
			case "anim":
			{
				int id = Integer.parseInt(args[0]);
				Player localPlayer = client.getLocalPlayer();
				localPlayer.setAnimation(id);
				localPlayer.setActionFrame(0);
				break;
			}
			case "gfx":
			{
				int id = Integer.parseInt(args[0]);
				Player localPlayer = client.getLocalPlayer();
				localPlayer.setGraphic(id);
				localPlayer.setSpotAnimFrame(0);
				break;
			}
			case "transform":
			{
				int id = Integer.parseInt(args[0]);
				Player player = client.getLocalPlayer();
				player.getPlayerComposition().setTransformedNpcId(id);
				player.setIdlePoseAnimation(-1);
				player.setPoseAnimation(-1);
				break;
			}
			case "cape":
			{
				int id = Integer.parseInt(args[0]);
				Player player = client.getLocalPlayer();
				player.getPlayerComposition().getEquipmentIds()[KitType.CAPE.getIndex()] = id + 512;
				player.getPlayerComposition().setHash();
				break;
			}
		}
	}

<<<<<<< HEAD
	Font getFont()
	{
		return font;
	}

	void togglePlayers()
	{
		togglePlayers = !togglePlayers;
	}

	void toggleNpcs()
	{
		toggleNpcs = !toggleNpcs;
	}

	void toggleGroundItems()
	{
		toggleGroundItems = !toggleGroundItems;
	}

	void toggleGroundObjects()
	{
		toggleGroundObjects = !toggleGroundObjects;
	}

	void toggleGameObjects()
	{
		toggleGameObjects = !toggleGameObjects;
	}

	void toggleWalls()
	{
		toggleWalls = !toggleWalls;
	}

	void toggleDecor()
	{
		toggleDecor = !toggleDecor;
	}

	void toggleInventory()
	{
		toggleInventory = !toggleInventory;
	}

	void toggleProjectiles()
	{
		toggleProjectiles = !toggleProjectiles;
	}

	void toggleLocation()
	{
		toggleLocation = !toggleLocation;
	}

	void toggleChunkBorders()
	{
		toggleChunkBorders = !toggleChunkBorders;
	}

	void toggleMapSquares()
	{
		toggleMapSquares = !toggleMapSquares;
	}

	void toggleValidMovement()
	{
		toggleValidMovement = !toggleValidMovement;
	}

	void toggleLineOfSight()
	{
		toggleLineOfSight = !toggleLineOfSight;
	}

	void toggleGraphicsObjects()
	{
		toggleGraphicsObjects = !toggleGraphicsObjects;
	}

<<<<<<< HEAD
=======
	void toggleCamera()
	{
		toggleCamera = !toggleCamera;
	}

	void toggleWorldMapLocation()
	{
		toggleWorldMapLocation = !toggleWorldMapLocation;
	}

	void toggleTileLocation()
	{
		toggleTileLocation = !toggleTileLocation;
	}

>>>>>>> upstream/master
	boolean isTogglePlayers()
	{
		return togglePlayers;
	}

	boolean isToggleNpcs()
	{
		return toggleNpcs;
	}

	boolean isToggleGroundItems()
	{
		return toggleGroundItems;
	}

	boolean isToggleGroundObjects()
	{
		return toggleGroundObjects;
	}

	boolean isToggleGameObjects()
	{
		return toggleGameObjects;
	}

	boolean isToggleWalls()
	{
		return toggleWalls;
	}

	boolean isToggleDecor()
	{
		return toggleDecor;
	}

	boolean isToggleInventory()
	{
		return toggleInventory;
	}

	boolean isToggleProjectiles()
	{
		return toggleProjectiles;
	}

	boolean isToggleLocation()
	{
		return toggleLocation;
	}

	boolean isToggleChunkBorders()
	{
		return toggleChunkBorders;
	}

	boolean isToggleMapSquares()
=======
	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
>>>>>>> upstream/master
	{
		if (!examine.isActive())
		{
			return;
		}

		MenuAction action = MenuAction.of(event.getType());

		if (EXAMINE_MENU_ACTIONS.contains(action))
		{
			MenuEntry[] entries = client.getMenuEntries();
			MenuEntry entry = entries[entries.length - 1];

<<<<<<< HEAD
	boolean isToggleGraphicsObjects()
	{
		return toggleGraphicsObjects;
	}
<<<<<<< HEAD
=======
=======
			final int identifier = event.getIdentifier();
			String info = "ID: ";
>>>>>>> upstream/master

			if (action == MenuAction.EXAMINE_NPC)
			{
				NPC npc = client.getCachedNPCs()[identifier];
				info += npc.getId();
			}
			else
			{
				info += identifier;

				if (action == MenuAction.EXAMINE_OBJECT)
				{
					WorldPoint point = WorldPoint.fromScene(client, entry.getParam0(), entry.getParam1(), client.getPlane());
					info += " X: " + point.getX() + " Y: " + point.getY();
				}
			}

			entry.setTarget(entry.getTarget() + " " + ColorUtil.prependColorTag("(" + info + ")", JagexColors.MENU_TARGET));
			client.setMenuEntries(entries);
		}
	}
>>>>>>> upstream/master
}
