/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
 * Copyright (c) 2018, Shaun Dreclin <shaundreclin@gmail.com>
 * Copyright (c) 2023, Macweese <https://github.com/Macweese>
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
package net.runelite.client.plugins.slayer;

import com.google.inject.Binder;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.inject.Inject;
import joptsimple.internal.Strings;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemID;
import net.runelite.api.MessageNode;
import net.runelite.api.NPC;
import net.runelite.api.Skill;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AccountHashChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.StatChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatClient;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatCommandManager;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ChatInput;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemVariationMapping;
import net.runelite.client.game.NpcUtil;
import net.runelite.client.game.npcoverlay.HighlightedNpc;
import net.runelite.client.game.npcoverlay.NpcOverlayService;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.plugins.npchighlight.NpcIndicatorService;
import net.runelite.client.plugins.npchighlight.NpcIndicatorsConfig;
import net.runelite.client.plugins.npchighlight.NpcIndicatorsPlugin;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Slayer",
	description = "Show additional slayer task related information",
	tags = {"combat", "notifications", "overlay", "tasks"}
)
@Slf4j
@PluginDependency(NpcIndicatorsPlugin.class)
public class SlayerPlugin extends Plugin
{
	//Chat messages
	private static final String CHAT_SUPERIOR_MESSAGE = "A superior foe has appeared...";
	private static final Pattern WILDERNESS_TASK_COMPLETED_MESSAGE = Pattern.compile("(You've completed \\d+ Wilderness task)");
	// Chat Command
	private static final String TASK_COMMAND_STRING = "!task";
	private static final int TASK_STRING_MAX_LENGTH = 50;

	@Inject
	private Client client;

	@Inject
	private SlayerConfig config;

	@Inject
	private ConfigManager configManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private SlayerOverlay overlay;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private Notifier notifier;

	@Inject
	private ClientThread clientThread;

	@Inject
	private TargetWeaknessOverlay targetWeaknessOverlay;

	@Inject
	private ChatCommandManager chatCommandManager;

	@Inject
	private ScheduledExecutorService executor;

	@Inject
	private ChatClient chatClient;

	@Inject
	private NpcUtil npcUtil;

	@Inject
	private NpcOverlayService npcOverlayService;

	@Inject
	private NpcIndicatorService npcIndicatorService;

	@Inject
	PluginManager pluginManager;

	@Getter(AccessLevel.PACKAGE)
	public static List<NPC> targets = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private static int initialAmount;

	@Getter
	@Setter(AccessLevel.PACKAGE)
	private static Task task;

	private TaskCounter counter;
	private Instant infoTimer;

	public int wildernessStreak;
	public int streak;
	public int points;

	private boolean loginFlag;
	private boolean completedPorcineOfInterest;
	private int slayerLevel;

	@Getter
	private final static Set<Integer> ALL_SLAYER_ITEMS = Stream.of(
			ItemVariationMapping.getVariations(ItemID.SLAYER_HELMET).stream(),
					ItemVariationMapping.getVariations(ItemID.SLAYER_RING_8).stream(),
					Stream.of(ItemID.ENCHANTED_GEM, ItemID.ETERNAL_GEM))
			.reduce(Stream::concat)
			.orElseGet(Stream::empty)
			.collect(Collectors.toSet());

	public final Function<NPC, HighlightedNpc> targetHighlighter = (npc) ->
	{
		if (config.highlightTaskNPCs() && isTaskTarget(npc))
		{

			return HighlightedNpc.builder()
					.npc(npc)
					.highlightColor(config.getTargetColor())
					.fillColor(config.getFillColor())
					.hull(npcIndicatorService.config().highlightHull())
					.tile(npcIndicatorService.config().highlightTile())
					.trueTile(npcIndicatorService.config().highlightTrueTile())
					.swTile(npcIndicatorService.config().highlightSouthWestTile())
					.swTrueTile(npcIndicatorService.config().highlightSouthWestTrueTile())
					.outline(npcIndicatorService.config().highlightOutline())
					.borderWidth((float) npcIndicatorService.config().borderWidth())
					.outlineFeather(npcIndicatorService.config().outlineFeather())
					.nameOnMinimap(npcIndicatorService.config().drawMinimapNames())
					.name(npcIndicatorService.config().drawNames())
					.build();
		}
		return null;
	};

	boolean isTaskTarget(NPC npc)
	{
		if (task == null || !task.isValid() || npc == null || npc.getTransformedComposition() == null)
		{
			return false;
		}

		boolean metLevelRequirement = true;

		if (task.getTaskNPC() == TaskNpc.SPIRITUAL_CREATURES)
		{
			if (Arrays.stream(SlayerNpcVariation.SPIRITUAL_MAGE.getIds()).anyMatch(id -> id == npc.getId()))
			{
				metLevelRequirement = slayerLevel < 83;
			}
			else if (Arrays.stream(SlayerNpcVariation.SPIRITUAL_WARRIOR.getIds()).anyMatch(id -> id == npc.getId()))
			{
				metLevelRequirement = slayerLevel < 68;
			}
		}

		boolean metLocationRequirement = task.getLocation() == Location.ANYWHERE
				|| (client.isInInstancedRegion()
				&& Arrays.stream(task.getLocation().getRegions()).anyMatch(instancedRegion ->
						instancedRegion == WorldPoint.fromLocalInstance(client, npc.getLocalLocation()).getRegionID()))
				|| Arrays.stream(task.getLocation().getRegions()).anyMatch(region -> region == npc.getWorldLocation().getRegionID())
				|| (client.getVarbitValue(Varbits.IN_WILDERNESS) == 1 && task.getMaster() == SlayerMaster.KRYSTILIA);

		return metLevelRequirement && metLocationRequirement
				&& Arrays.stream(task.getNpcIds()).anyMatch(id -> id == npc.getId())
				&& !(npcUtil.isDying(npc) && config.ignoreDead());
	}

	@Override
	public void configure(Binder binder)
	{
		binder.bind(SlayerPluginService.class).to(SlayerPluginServiceImpl.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		chatCommandManager.registerCommandAsync(TASK_COMMAND_STRING, this::taskLookup, this::taskSubmit);
		npcOverlayService.registerHighlighter(targetHighlighter, 0);

		overlayManager.add(overlay);
		overlayManager.add(targetWeaknessOverlay);

		if (client.getGameState() == GameState.LOGGED_IN)
		{
			clientThread.invoke(() ->
			{
				getVars();
				updateTask();
			});
			rebuildTargetList();
			slayerLevel = client.getBoostedSkillLevel(Skill.SLAYER);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		chatCommandManager.unregisterCommand(TASK_COMMAND_STRING);
		npcOverlayService.unregisterHighlighter(targetHighlighter);

		overlayManager.remove(overlay);
		overlayManager.remove(targetWeaknessOverlay);
		removeCounter();
		targets.clear();
		task = null;
	}

	@Provides
	SlayerConfig provideSlayerConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SlayerConfig.class);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (loginFlag && gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			clientThread.invoke(() ->
			{
				getVars();
				updateTask();
			});
			loginFlag = false;
		}
	}

	@Subscribe
	private void onAccountHashChanged(AccountHashChanged accountHashChanged)
	{
		loginFlag = true;
		migrateConfig();
		initialAmount = getIntProfileConfig(SlayerConfig.INIT_AMOUNT_KEY);
		wildernessStreak = getIntProfileConfig(SlayerConfig.WILDERNESS_STREAK_KEY);
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (event.getVarpId() == VarPlayer.SLAYER_TASK_SIZE.getId())
		{
			int oldAmount = task.getAmount();
			int newAmount = event.getValue();

			if (task != null)
			{
				task.setAmount(newAmount);
				if (initialAmount < newAmount || oldAmount < 1)
				{
					initialAmount = newAmount;
					setProfileConfig(SlayerConfig.INIT_AMOUNT_KEY, initialAmount);
				}
			}

			clientThread.invoke(this::updateTask);
		}

		if (event.getVarpId() == VarPlayer.SLAYER_TASK_CREATURE.getId()
				|| event.getVarpId() == VarPlayer.SLAYER_TASK_LOCATION.getId()
				|| event.getVarbitId() == Varbits.SLAYER_TASK_BOSS
				|| event.getVarbitId() == Varbits.SLAYER_MASTER)
		{
			clientThread.invoke(this::updateTask);
			updateCounter();
			setProfileConfig(SlayerConfig.INIT_AMOUNT_KEY, initialAmount);
		}

		if (event.getVarbitId() == Varbits.SLAYER_POINTS)
		{
			points = event.getValue();
			updateCounter();
		}

		if (event.getVarbitId() == Varbits.SLAYER_TASK_STREAK)
		{
			streak = event.getValue();
			updateCounter();
		}

		if (event.getVarbitId() == Varbits.QUEST_PORCINE_OF_INTEREST)
		{
			completedPorcineOfInterest = event.getValue() == 195;
		}
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		if (infoTimer != null && config.statTimeout() != 0)
		{
			Duration timeSinceInfobox = Duration.between(infoTimer, Instant.now());
			Duration statTimeout = Duration.ofMinutes(config.statTimeout());

			if (timeSinceInfobox.compareTo(statTimeout) >= 0)
			{
				removeCounter();
			}
		}
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals(SlayerConfig.GROUP_NAME))
		{
			// Changes to the highlight settings in NpcIndicators need to be reflected even when the plugin is disabled
			if (!pluginManager.isPluginEnabled(npcIndicatorService.plugin()) && event.getGroup().equals(NpcIndicatorsConfig.GROUP))
			{
				npcOverlayService.rebuild();
			}

			return;
		}

		if (event.getKey().equals("statTimeout"))
		{
			updateCounter();
			return;
		}
		if (event.getKey().equals("infobox"))
		{
			if (config.showInfobox())
			{
				addCounter();
			}
			else
			{
				removeCounter();
			}
		}
		else
		{
			npcOverlayService.rebuild();
		}
	}

	private void rebuildTargetList()
	{
		targets.clear();
		client.getNpcs().stream().filter(this::isTaskTarget).forEach(targets::add);
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned npcSpawned)
	{
		NPC npc = npcSpawned.getNpc();

		if (targets.contains(npc))
		{
			return;
		}

		if (isTaskTarget(npc))
		{
			targets.add(npc);
		}
	}

	@Subscribe
	public void onStatChanged(StatChanged statChanged)
	{
		if (statChanged.getSkill() != Skill.SLAYER && statChanged.getBoostedLevel() == slayerLevel)
		{
			return;
		}

		slayerLevel = statChanged.getBoostedLevel();
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE && event.getType() != ChatMessageType.SPAM)
		{
			return;
		}
		
		String chatMsg = Text.removeTags(event.getMessage());

		if (config.showSuperiorNotification() && chatMsg.equals(CHAT_SUPERIOR_MESSAGE))
		{
			notifier.notify(CHAT_SUPERIOR_MESSAGE);
		}

		if (WILDERNESS_TASK_COMPLETED_MESSAGE.matcher(chatMsg).find())
		{
			int indexEnd = chatMsg.indexOf("Wilderness");
			String subString = chatMsg.substring(0, indexEnd).replaceAll("\\D+", "");

			wildernessStreak = Integer.parseInt(subString);
			setProfileConfig(SlayerConfig.WILDERNESS_STREAK_KEY, wildernessStreak);
			updateCounter();
		}
	}

	@Subscribe
	private void onMenuOptionClicked(MenuOptionClicked menuOptionClicked)
	{
		Widget widget = menuOptionClicked.getWidget();

		if (menuOptionClicked.getMenuOption().equals("Check")
				&& (ALL_SLAYER_ITEMS.contains(menuOptionClicked.getItemId())
				|| (widget != null
				&& widget.getParent() != null
				&& widget.getParentId() == WidgetInfo.EQUIPMENT.getId()
				&& Arrays.stream(widget.getDynamicChildren()).anyMatch(w -> ALL_SLAYER_ITEMS.contains(w.getItemId())))))
		{
			updateCounter();
		}
	}

	@Subscribe
	private void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		if (widgetLoaded.getGroupId() == WidgetID.DIALOG_NPC_GROUP_ID)
		{
			final Widget npcWidget = client.getWidget(WidgetInfo.DIALOG_NPC_NAME);

			if (npcWidget == null || npcWidget.getText().isEmpty())
			{
				return;
			}

			if (Arrays.stream(SlayerMaster.values()).anyMatch(master ->
					Arrays.stream(master.getNames()).anyMatch(n -> npcWidget.getText().equals(n))))
			{
				// Don't update the task infobox if the player cannot have Spria as slayer master
				if (!completedPorcineOfInterest && npcWidget.getText().equals(SlayerMaster.TURAEL_SPRIA.getNames()[1]))
				{
					return;
				}

				updateCounter();
			}
		}
	}

	private void addCounter()
	{
		if (!config.showInfobox() || counter != null || task == null || !task.isValid())
		{
			return;
		}

		int itemSpriteId = ItemID.ENCHANTED_GEM;
		if (task.getTaskNPC() != null || task.getTaskNPC().getItemSpriteId() != -1)
		{
			itemSpriteId = task.getTaskNPC().getItemSpriteId();
		}

		BufferedImage taskImg = itemManager.getImage(itemSpriteId);

		counter = new TaskCounter(taskImg, this, task.getAmount());
		counter.setTooltip(task, initialAmount, points, streak, wildernessStreak);

		infoBoxManager.addInfoBox(counter);
	}

	private void removeCounter()
	{
		if (counter == null)
		{
			return;
		}

		infoBoxManager.removeInfoBox(counter);
		counter = null;
	}

	private void updateCounter()
	{
		if (!config.showInfobox() || task == null || !task.isValid())
		{
			if (task != null && task.getAmount() == 0)
			{
				removeCounter();
			}
			return;
		}

		infoTimer = Instant.now();

		if (counter == null)
		{
			addCounter();
			return;
		}

		int itemSpriteId = task.getTaskNPC() == null ? ItemID.ENCHANTED_GEM : task.getTaskNPC().getItemSpriteId();

		BufferedImage taskImg = itemManager.getImage(itemSpriteId);

		counter.setImage(taskImg);
		counter.setCount(task.amount);
		counter.setTooltip(task, initialAmount, points, streak, wildernessStreak);

		infoBoxManager.updateInfoBoxImage(counter);
	}

	void taskLookup(ChatMessage chatMessage, String message)
	{
		if (!config.taskCommand())
		{
			return;
		}

		String response;
		final MessageNode messageNode = chatMessage.getMessageNode();

		if (task != null && task.isValid())
		{
			ChatMessageType type = chatMessage.getType();

			final String player;
			if (type.equals(ChatMessageType.PRIVATECHATOUT))
			{
				player = client.getLocalPlayer().getName();
			}
			else
			{
				player = Text.removeTags(chatMessage.getName())
						.replace('\u00A0', ' ');
			}

			net.runelite.http.api.chat.Task task;
			try
			{
				task = chatClient.getTask(player);
			}
			catch (IOException ex)
			{
				log.debug("unable to lookup slayer task", ex);
				return;
			}

			if (Strings.isNullOrEmpty(task.getTask()))
			{
				return;
			}

			if (task.getLocation().length() > TASK_STRING_MAX_LENGTH
					|| Arrays.stream(TaskNpc.values()).noneMatch(taskNpc -> taskNpc.getName().equalsIgnoreCase(task.getTask()))
					|| Arrays.stream(Location.values()).noneMatch(location -> location.getName().equalsIgnoreCase(task.getLocation())))
			{
				log.debug("Validation failed for taskNpc or location: {}", task);
				return;
			}

			StringBuilder sb = new StringBuilder();
			sb.append(task.getTask());

			int killed = task.getInitialAmount() - task.getAmount();

			if (!Strings.isNullOrEmpty(task.getLocation()))
			{
				sb.append(" (").append(task.getLocation()).append(')');
			}
			sb.append(": ");
			if (killed < 0)
			{
				sb.append(task.getAmount()).append(" left");
			}
			else
			{
				sb.append(killed).append('/').append(task.getInitialAmount()).append(" killed");
			}

			response = new ChatMessageBuilder()
					.append(ChatColorType.NORMAL)
					.append("Slayer Task: ")
					.append(ChatColorType.HIGHLIGHT)
					.append(sb.toString())
					.build();

			updateCounter();
		}
		else
		{
			response = new ChatMessageBuilder()
					.append(ChatColorType.NORMAL)
					.append("Slayer Task: ")
					.append(ChatColorType.HIGHLIGHT)
					.append("none ")
					.append(ChatColorType.NORMAL)
					.append("Streak: ")
					.append(ChatColorType.HIGHLIGHT)
					.append(streak + " ")
					.append(ChatColorType.NORMAL)
					.append("Wilderness Streak: ")
					.append(ChatColorType.HIGHLIGHT)
					.append(wildernessStreak == -1 ? "unknown" : String.valueOf(wildernessStreak))
					.build();
		}

		messageNode.setRuneLiteFormatMessage(response);
		client.refreshChat();
	}

	private boolean taskSubmit(ChatInput chatInput, String value)
	{
		if (task == null || !task.isValid())
		{
			return false;
		}

		final String playerName = client.getLocalPlayer().getName();
		final String taskName = task.getName();
		final String taskLocation = task.getLocation().getName();
		final int amount = task.getAmount();

		executor.execute(() ->
		{
			try
			{
				chatClient.submitTask(playerName, capsString(taskName), amount, initialAmount, taskLocation);
			}
			catch (Exception ex)
			{
				log.warn("unable to submit slayer task", ex);
			}
			finally
			{
				chatInput.resume();
			}
		});

		return true;
	}

	private void updateTask()
	{
		if (task == null)
		{
			task = new Task();
		}
		else if (!task.isValid())
		{
			if (task.getAmount() < 1)
			{
				removeCounter();
				return;
			}
		}

		task.update(client);
		infoTimer = Instant.now();

		updateCounter();
		npcOverlayService.rebuild();
	}

	private void getVars()
	{
		points = client.getVarbitValue(Varbits.SLAYER_POINTS);
		streak = client.getVarbitValue(Varbits.SLAYER_TASK_STREAK);
	}

	//Utils
	private String capsString(String str)
	{
		return Strings.isNullOrEmpty(str) ? "" : str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	int getIntProfileConfig(String key)
	{
		Integer value = configManager.getRSProfileConfiguration(SlayerConfig.GROUP_NAME, key, int.class);
		return value == null ? -1 : value;
	}

	private void setProfileConfig(String key, Object value)
	{
		if (value != null)
		{
			configManager.setRSProfileConfiguration(SlayerConfig.GROUP_NAME, key, value);
		}
		else
		{
			configManager.unsetRSProfileConfiguration(SlayerConfig.GROUP_NAME, key);
		}
	}

	private void migrateConfig()
	{
		migrateConfigKey(SlayerConfig.INIT_AMOUNT_KEY);
		migrateConfigKey(SlayerConfig.WILDERNESS_STREAK_KEY);
	}

	private void migrateConfigKey(String key)
	{
		Object value = configManager.getConfiguration(SlayerConfig.GROUP_NAME, key);
		if (value != null)
		{
			configManager.unsetConfiguration(SlayerConfig.GROUP_NAME, key);
			configManager.setRSProfileConfiguration(SlayerConfig.GROUP_NAME, key, value);
		}
	}
}
