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
import com.formdev.flatlaf.extras.FlatInspector;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import com.google.inject.Provides;
import java.awt.AWTEvent;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import static java.lang.Math.min;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.RootPaneContainer;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.IndexedSprite;
import net.runelite.api.ItemID;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.VarbitComposition;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.StatChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.kit.KitType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
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
import net.runelite.client.util.HotkeyListener;
import net.runelite.client.util.ImageUtil;
import org.slf4j.LoggerFactory;

@Slf4j
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
	private CameraOverlay cameraOverlay;

	@Inject
	private WorldMapLocationOverlay worldMapLocationOverlay;

	@Inject
	private WorldMapRegionOverlay mapRegionOverlay;

	@Inject
	private SoundEffectOverlay soundEffectOverlay;

	@Inject
	private EventBus eventBus;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private DevToolsConfig config;

	private DevToolsButton players;
	private DevToolsButton npcs;
	private DevToolsButton groundItems;
	private DevToolsButton groundObjects;
	private DevToolsButton gameObjects;
	private DevToolsButton graphicsObjects;
	private DevToolsButton walls;
	private DevToolsButton decorations;
	private DevToolsButton projectiles;
	private DevToolsButton location;
	private DevToolsButton chunkBorders;
	private DevToolsButton mapSquares;
	private DevToolsButton loadingLines;
	private DevToolsButton validMovement;
	private DevToolsButton movementFlags;
	private DevToolsButton lineOfSight;
	private DevToolsButton cameraPosition;
	private DevToolsButton worldMapLocation;
	private DevToolsButton tileLocation;
	private DevToolsButton interacting;
	private DevToolsButton examine;
	private DevToolsButton detachedCamera;
	private DevToolsButton widgetInspector;
	private DevToolsButton varInspector;
	private DevToolsButton soundEffects;
	private DevToolsButton scriptInspector;
	private DevToolsButton inventoryInspector;
	private DevToolsButton roofs;
	private DevToolsButton shell;
	private DevToolsButton menus;
	private DevToolsButton uiDefaultsInspector;
	private NavigationButton navButton;

	private HotkeyListener swingInspectorHotkeyListener = new HotkeyListener(() -> config.swingInspectorHotkey())
	{
		Object inspector;

		@Override
		public void hotkeyPressed()
		{
			Window window = KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();
			try
			{
				if (inspector == null)
				{
					JRootPane rootPane = ((RootPaneContainer) window).getRootPane();
					FlatInspector fi = new FlatInspector(rootPane);
					fi.setEnabled(true);
					inspector = fi;
					fi.addPropertyChangeListener(ev ->
					{
						if ("enabled".equals(ev.getPropertyName()) && !fi.isEnabled() && inspector == ev.getSource())
						{
							inspector = null;
						}
					});
				}
				else
				{
					((FlatInspector) inspector).setEnabled(false);
				}
			}
			catch (LinkageError | Exception e)
			{
				log.warn("unable to open swing inspector", e);
				JOptionPane.showMessageDialog(window, "The swing inspector is not available.");
			}
		}
	};

	private AWTEventListener swingInspectorKeyListener = rawEv ->
	{
		if (rawEv instanceof KeyEvent)
		{
			KeyEvent kev = (KeyEvent) rawEv;
			if (kev.getID() == KeyEvent.KEY_PRESSED)
			{
				swingInspectorHotkeyListener.keyPressed(kev);
			}
			else if (kev.getID() == KeyEvent.KEY_RELEASED)
			{
				swingInspectorHotkeyListener.keyReleased(kev);
			}
		}
	};

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

		projectiles = new DevToolsButton("Projectiles");

		location = new DevToolsButton("Location");
		worldMapLocation = new DevToolsButton("World Map Location");
		tileLocation = new DevToolsButton("Tile Location");
		cameraPosition = new DevToolsButton("Camera Position");

		chunkBorders = new DevToolsButton("Chunk Borders");
		mapSquares = new DevToolsButton("Map Squares");
		loadingLines = new DevToolsButton("Loading Lines");

		lineOfSight = new DevToolsButton("Line Of Sight");
		validMovement = new DevToolsButton("Valid Movement");
		movementFlags = new DevToolsButton("Movement Flags");
		interacting = new DevToolsButton("Interacting");
		examine = new DevToolsButton("Examine");

		detachedCamera = new DevToolsButton("Detached Camera");
		widgetInspector = new DevToolsButton("Widget Inspector");
		varInspector = new DevToolsButton("Var Inspector");
		soundEffects = new DevToolsButton("Sound Effects");
		scriptInspector = new DevToolsButton("Script Inspector");
		inventoryInspector = new DevToolsButton("Inventory Inspector");
		roofs = new DevToolsButton("Roofs");
		shell = new DevToolsButton("Shell");
		menus = new DevToolsButton("Menus");

		uiDefaultsInspector = new DevToolsButton("Swing Defaults");

		overlayManager.add(overlay);
		overlayManager.add(locationOverlay);
		overlayManager.add(sceneOverlay);
		overlayManager.add(cameraOverlay);
		overlayManager.add(worldMapLocationOverlay);
		overlayManager.add(mapRegionOverlay);
		overlayManager.add(soundEffectOverlay);

		final DevToolsPanel panel = injector.getInstance(DevToolsPanel.class);

		final BufferedImage icon = ImageUtil.loadImageResource(getClass(), "devtools_icon.png");

		navButton = NavigationButton.builder()
			.tooltip("Developer Tools")
			.icon(icon)
			.priority(1)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);

		eventBus.register(soundEffectOverlay);

		Toolkit.getDefaultToolkit().addAWTEventListener(swingInspectorKeyListener, AWTEvent.KEY_EVENT_MASK);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(soundEffectOverlay);
		overlayManager.remove(overlay);
		overlayManager.remove(locationOverlay);
		overlayManager.remove(sceneOverlay);
		overlayManager.remove(cameraOverlay);
		overlayManager.remove(worldMapLocationOverlay);
		overlayManager.remove(mapRegionOverlay);
		overlayManager.remove(soundEffectOverlay);
		clientToolbar.removeNavigation(navButton);
		Toolkit.getDefaultToolkit().removeAWTEventListener(swingInspectorKeyListener);
	}

	@Subscribe
	public void onCommandExecuted(CommandExecuted commandExecuted)
	{
		String[] args = commandExecuted.getArguments();

		switch (commandExecuted.getCommand().toLowerCase())
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
				int[] varps = client.getVarps();
				int value = varps[varp];
				client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "VarPlayer " + varp + ": " + value, null);
				break;
			}
			case "setvarp":
			{
				int varp = Integer.parseInt(args[0]);
				int value = Integer.parseInt(args[1]);
				int[] varps = client.getVarps();
				varps[varp] = value;
				client.queueChangedVarp(varp);
				client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Set VarPlayer " + varp + " to " + value, null);
				VarbitChanged varbitChanged = new VarbitChanged();
				varbitChanged.setVarpId(varp);
				varbitChanged.setValue(value);
				eventBus.post(varbitChanged); // fake event
				break;
			}
			case "getvarb":
			{
				int varbit = Integer.parseInt(args[0]);
				int value = client.getVarbitValue(client.getVarps(), varbit);
				client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Varbit " + varbit + ": " + value, null);
				break;
			}
			case "setvarb":
			{
				int varbit = Integer.parseInt(args[0]);
				int value = Integer.parseInt(args[1]);
				client.setVarbitValue(client.getVarps(), varbit, value);
				VarbitComposition varbitComposition = client.getVarbit(varbit);
				client.queueChangedVarp(varbitComposition.getIndex());
				client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Set varbit " + varbit + " to " + value, null);
				VarbitChanged varbitChanged = new VarbitChanged();
				varbitChanged.setVarbitId(varbit);
				varbitChanged.setValue(value);
				eventBus.post(varbitChanged); // fake event
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

				StatChanged statChanged = new StatChanged(
					skill,
					totalXp,
					level,
					level
				);
				eventBus.post(statChanged);
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

				StatChanged statChanged = new StatChanged(
					skill,
					xp,
					level,
					level
				);
				eventBus.post(statChanged);
				break;
			}
			case "anim":
			{
				int id = Integer.parseInt(args[0]);
				Player localPlayer = client.getLocalPlayer();
				localPlayer.setAnimation(id);
				localPlayer.setAnimationFrame(0);
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
			case "wear":
			{
				int slot = Integer.parseInt(args[0]);
				int id = Integer.parseInt(args[1]);
				Player player = client.getLocalPlayer();
				player.getPlayerComposition().getEquipmentIds()[slot] = id + 512;
				player.getPlayerComposition().setHash();
				break;
			}
			case "tex":
			{
				Player player = client.getLocalPlayer();
				player.getPlayerComposition().getEquipmentIds()[KitType.CAPE.getIndex()] = ItemID.FIRE_CAPE + 512;
				player.getPlayerComposition().getEquipmentIds()[KitType.SHIELD.getIndex()] = ItemID.MIRROR_SHIELD + 512;
				player.getPlayerComposition().setHash();
				break;
			}
			case "alpha":
			{
				Player player = client.getLocalPlayer();
				player.getPlayerComposition().getEquipmentIds()[KitType.HEAD.getIndex()] = ItemID.GHOSTLY_HOOD + 512;
				player.getPlayerComposition().getEquipmentIds()[KitType.AMULET.getIndex()] = ItemID.AMULET_OF_TORTURE_OR + 512;
				player.getPlayerComposition().getEquipmentIds()[KitType.CAPE.getIndex()] = ItemID.GHOSTLY_CLOAK + 512;
				player.getPlayerComposition().getEquipmentIds()[KitType.TORSO.getIndex()] = ItemID.GHOSTLY_ROBE + 512;
				player.getPlayerComposition().getEquipmentIds()[KitType.SHIELD.getIndex()] = ItemID.ELYSIAN_SPIRIT_SHIELD + 512;
				player.getPlayerComposition().getEquipmentIds()[KitType.ARMS.getIndex()] = -1;
				player.getPlayerComposition().getEquipmentIds()[KitType.LEGS.getIndex()] = ItemID.GHOSTLY_ROBE_6108 + 512;
				player.getPlayerComposition().getEquipmentIds()[KitType.HAIR.getIndex()] = -1;
				player.getPlayerComposition().getEquipmentIds()[KitType.HANDS.getIndex()] = ItemID.GHOSTLY_GLOVES;
				player.getPlayerComposition().getEquipmentIds()[KitType.BOOTS.getIndex()] = ItemID.GHOSTLY_BOOTS;
				player.getPlayerComposition().setHash();
				break;
			}
			case "sound":
			{
				int id = Integer.parseInt(args[0]);
				client.playSoundEffect(id);
				break;
			}
			case "msg":
			{
				client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", String.join(" ", args), "");
				break;
			}
			case "setconf":
			{
				// setconf group.key name = value
				String group = args[0];
				String key = args[1], value = "";
				for (int i = 2; i < args.length; ++i)
				{
					if (args[i].equals("="))
					{
						value = String.join(" ", Arrays.copyOfRange(args, i + 1, args.length));
						break;
					}

					key += " " + args[i];
				}
				String current = configManager.getConfiguration(group, key);
				final String message;
				if (value.isEmpty())
				{
					configManager.unsetConfiguration(group, key);
					message = String.format("Unset configuration %s.%s (was: %s)", group, key, current);
				}
				else
				{
					configManager.setConfiguration(group, key, value);
					message = String.format("Set configuration %s.%s to %s (was: %s)", group, key, value, current);
				}
				chatMessageManager.queue(QueuedMessage.builder()
					.type(ChatMessageType.GAMEMESSAGE)
					.runeLiteFormattedMessage(new ChatMessageBuilder().append(message).build())
					.build());
				break;
			}
			case "getconf":
			{
				String group = args[0], key = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
				String value = configManager.getConfiguration(group, key);
				final String message = String.format("%s.%s = %s", group, key, value);
				chatMessageManager.queue(QueuedMessage.builder()
					.type(ChatMessageType.GAMEMESSAGE)
					.runeLiteFormattedMessage(new ChatMessageBuilder().append(message).build())
					.build());
				break;
			}
			case "modicons":
			{
				final ChatMessageBuilder builder = new ChatMessageBuilder();
				final IndexedSprite[] modIcons = client.getModIcons();
				for (int i = 0; i < modIcons.length; i++)
				{
					builder.append(i + "=").img(i);

					if (i != modIcons.length - 1)
					{
						builder.append(", ");
					}
				}
				chatMessageManager.queue(QueuedMessage.builder()
					.type(ChatMessageType.GAMEMESSAGE)
					.runeLiteFormattedMessage(builder.build())
					.build());
				break;
			}
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (!examine.isActive())
		{
			return;
		}

		MenuAction action = MenuAction.of(event.getType());

		if (EXAMINE_MENU_ACTIONS.contains(action))
		{
			MenuEntry entry = event.getMenuEntry();

			final int identifier = event.getIdentifier();
			String info = "ID: ";

			if (action == MenuAction.EXAMINE_NPC)
			{
				NPC npc = entry.getNpc();
				assert npc != null;
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
		}
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent ev)
	{
		if ("devtoolsEnabled".equals(ev.getEventName()))
		{
			client.getIntStack()[client.getIntStackSize() - 1] = 1;
		}
	}

	@Subscribe
	public void onClientTick(ClientTick clientTick)
	{
		if (menus.isActive() && !client.isMenuOpen())
		{
			for (int i = 0; i < 100; ++i)
			{
				final int i_ = i;
				if (i % 30 == 0)
				{
					MenuEntry parent = client.createMenuEntry(1)
						.setOption("pmenu" + i)
						.setTarget("devtools")
						.setType(MenuAction.RUNELITE_SUBMENU);

					for (int j = 0; j < 4; ++j)
					{
						final int j_ = j;
						client.createMenuEntry(1)
							.setOption("submenu" + j)
							.setTarget("devtools")
							.setType(MenuAction.RUNELITE)
							.setParent(parent)
							.onClick(c -> client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "menu " + i_ + " sub " + j_, null));
					}
					continue;
				}

				client.createMenuEntry(1)
					.setOption("menu" + i)
					.setTarget("devtools")
					.setType(MenuAction.RUNELITE)
					.onClick(c -> client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "menu " + i_, null));
			}
		}
	}
}
