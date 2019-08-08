/*
 * Copyright (c) 2019, Slay to Stay, <https://github.com/slaytostay>
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
package net.runelite.client.plugins.goaltracker;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.Provides;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.goaltracker.ui.GoalTrackerPanel;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@PluginDescriptor(
		name = "Goal Tracker",
		description = "Add goals to chunks",
		tags = {"chunk", "backlog", "log"},
		enabledByDefault = false
)
public class GoalTrackerPlugin extends Plugin
{
	private static final String PLUGIN_NAME = "Goal Tracker";
	private static final String CONFIG_GROUP = "goaltracker";
	private static final String CONFIG_KEY = "goals";
	private static final String ICON_FILE = "panel_icon.png";

	@Getter
	private final List<Goal> goals = new ArrayList<>();

	@Getter
	@Setter
	private boolean hotkeyPressed = false;

	@Inject
	private Client client;

	@Inject
	private GoalTrackerConfig config;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ClientUI clientUi;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private GoalTrackerOverlay overlay;

	@Inject
	private KeyManager keyManager;

	@Inject
	private GoalTrackerInput inputListener;

	private GoalTrackerPanel pluginPanel;
	private NavigationButton navigationButton;
	private NavigationButton titleBarButton;

	@Provides
	GoalTrackerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GoalTrackerConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		loadConfig(configManager.getConfiguration(CONFIG_GROUP, CONFIG_KEY)).forEach(goals::add);

		pluginPanel = injector.getInstance(GoalTrackerPanel.class);
		pluginPanel.rebuild();

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), ICON_FILE);

		navigationButton = NavigationButton.builder()
				.tooltip(PLUGIN_NAME)
				.icon(icon)
				.priority(1)
				.panel(pluginPanel)
				.build();

		clientToolbar.addNavigation(titleBarButton);
		clientToolbar.addNavigation(navigationButton);

		keyManager.registerKeyListener(inputListener);

		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		overlayManager.removeIf(GoalTrackerOverlay.class::isInstance);
		goals.clear();
		clientToolbar.removeNavigation(navigationButton);
		keyManager.unregisterKeyListener(inputListener);
	}

	public void updateConfig()
	{
		if (goals.isEmpty())
		{
			configManager.unsetConfiguration(CONFIG_GROUP, CONFIG_KEY);
			return;
		}

		final Gson gson = new Gson();
		final String json = gson.toJson(goals);
		configManager.setConfiguration(CONFIG_GROUP, CONFIG_KEY, json);
	}

	public Stream<Goal> loadConfig(String json)
	{
		if (Strings.isNullOrEmpty(json))
		{
			return Stream.empty();
		}

		final Gson gson = new Gson();
		final List<Goal> goalData = gson.fromJson(json, new TypeToken<ArrayList<Goal>>()
		{
		}.getType());

		return goalData.stream();
	}

	public void addGoal()
	{
		Goal goal = new Goal(
				"Goal " + (goals.size() + 1),
				12850,
				new ArrayList<>(),
				false
		);

		goals.add(0, goal);
		updateGoals();
		updateConfig();
	}

	public void deleteGoal(final Goal goal)
	{
		goals.remove(goal);
		updateGoals();
		updateConfig();
	}

	public void updateGoals()
	{
		pluginPanel.updateGoals();
	}
}
