/*
 * Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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

import com.formdev.flatlaf.extras.FlatUIDefaultsInspector;
import com.google.inject.ProvisionException;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TrayIcon;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JPanel;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import net.runelite.client.Notifier;
import net.runelite.client.account.SessionManager;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.infobox.Counter;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.ImageUtil;

@Slf4j
class DevToolsPanel extends PluginPanel
{
	private final Client client;
	private final ClientThread clientThread;
	private final Notifier notifier;
	private final DevToolsPlugin plugin;

	private final WidgetInspector widgetInspector;
	private final VarInspector varInspector;
	private final ScriptInspector scriptInspector;
	private final InventoryInspector inventoryInspector;
	private final InfoBoxManager infoBoxManager;
	private final ScheduledExecutorService scheduledExecutorService;
	private final PluginManager pluginManager;

	@Inject
	private DevToolsPanel(
			Client client,
			ClientThread clientThread,
			DevToolsPlugin plugin,
			WidgetInspector widgetInspector,
			VarInspector varInspector,
			ScriptInspector scriptInspector,
			InventoryInspector inventoryInspector,
			Notifier notifier,
			InfoBoxManager infoBoxManager,
			ScheduledExecutorService scheduledExecutorService,
			PluginManager pluginManager)
	{
		super();
		this.client = client;
		this.clientThread = clientThread;
		this.plugin = plugin;
		this.widgetInspector = widgetInspector;
		this.varInspector = varInspector;
		this.inventoryInspector = inventoryInspector;
		this.scriptInspector = scriptInspector;
		this.notifier = notifier;
		this.infoBoxManager = infoBoxManager;
		this.scheduledExecutorService = scheduledExecutorService;
		this.pluginManager = pluginManager;

		setBackground(ColorScheme.DARK_GRAY_COLOR);

		add(createOptionsPanel());
	}

	@SuppressWarnings("PMD.DoubleBraceInitialization")
	private JPanel createOptionsPanel()
	{
		final JPanel container = new JPanel();
		container.setBackground(ColorScheme.DARK_GRAY_COLOR);
		container.setLayout(new GridLayout(0, 2, 3, 3));

		container.add(plugin.getPlayers());
		container.add(plugin.getNpcs());

		container.add(plugin.getGroundItems());
		container.add(plugin.getGroundObjects());
		container.add(plugin.getGameObjects());
		container.add(plugin.getGraphicsObjects());
		container.add(plugin.getWalls());
		container.add(plugin.getDecorations());

		container.add(plugin.getProjectiles());

		container.add(plugin.getLocation());
		container.add(plugin.getWorldMapLocation());
		container.add(plugin.getTileLocation());
		container.add(plugin.getCameraPosition());

		container.add(plugin.getChunkBorders());
		container.add(plugin.getMapSquares());
		container.add(plugin.getLoadingLines());

		container.add(plugin.getLineOfSight());
		container.add(plugin.getValidMovement());
		container.add(plugin.getMovementFlags());
		container.add(plugin.getInteracting());
		container.add(plugin.getExamine());

		container.add(plugin.getDetachedCamera());
		plugin.getDetachedCamera().addActionListener((ev) ->
		{
			client.setOculusOrbState(!plugin.getDetachedCamera().isActive() ? 1 : 0);
			client.setOculusOrbNormalSpeed(!plugin.getDetachedCamera().isActive() ? 36 : 12);
		});

		container.add(plugin.getWidgetInspector());
		plugin.getWidgetInspector().addFrame(widgetInspector);

		container.add(plugin.getVarInspector());
		plugin.getVarInspector().addFrame(varInspector);

		container.add(plugin.getSoundEffects());

		final JButton notificationBtn = new JButton("Notification");
		notificationBtn.addActionListener(e ->
		{
			scheduledExecutorService.schedule(() -> notifier.notify("Wow!", TrayIcon.MessageType.ERROR), 3, TimeUnit.SECONDS);
		});
		container.add(notificationBtn);

		container.add(plugin.getScriptInspector());
		plugin.getScriptInspector().addFrame(scriptInspector);

		final JButton newInfoboxBtn = new JButton("Infobox");
		newInfoboxBtn.addActionListener(e ->
		{
			Counter counter = new Counter(ImageUtil.loadImageResource(getClass(), "devtools_icon.png"), plugin, 42)
			{
				@Override
				public String getName()
				{
					// Give the infobox a unique name to test infobox splitting
					return "devtools-" + hashCode();
				}
			};
			counter.getMenuEntries().add(new OverlayMenuEntry(MenuAction.RUNELITE_INFOBOX, "Test", "DevTools"));
			infoBoxManager.addInfoBox(counter);
		});
		container.add(newInfoboxBtn);

		final JButton clearInfoboxBtn = new JButton("Clear Infobox");
		clearInfoboxBtn.addActionListener(e -> infoBoxManager.removeIf(i -> true));
		container.add(clearInfoboxBtn);

		container.add(plugin.getInventoryInspector());
		plugin.getInventoryInspector().addFrame(inventoryInspector);

		final JButton disconnectBtn = new JButton("Disconnect");
		disconnectBtn.addActionListener(e -> clientThread.invoke(() -> client.setGameState(GameState.CONNECTION_LOST)));
		container.add(disconnectBtn);

		container.add(plugin.getRoofs());

		final JButton sidePluginsBtn = new JButton("Refresh Side Plugins");
		sidePluginsBtn.addActionListener(e ->
			clientThread.invoke(pluginManager::loadSideLoadPlugins));
		container.add(sidePluginsBtn);

		try
		{
			ShellFrame sf = plugin.getInjector().getInstance(ShellFrame.class);
			container.add(plugin.getShell());
			plugin.getShell().addFrame(sf);
		}
		catch (LinkageError | ProvisionException e)
		{
			log.debug("Shell is not supported", e);
		}
		catch (Exception e)
		{
			log.info("Shell couldn't be loaded", e);
		}

		container.add(plugin.getMenus());

		try
		{
			FlatUIDefaultsInspector.class.getName();

			DevToolsButton uiDefaultsBtn = plugin.getUiDefaultsInspector();
			uiDefaultsBtn.addFrame(new DevToolsFrame()
			{
				{
					getContentPane().add(FlatUIDefaultsInspector.createInspectorPanel(), BorderLayout.CENTER);
					pack();
				}
			});
			container.add(uiDefaultsBtn);
		}
		catch (LinkageError e)
		{
		}

		return container;
	}
}
