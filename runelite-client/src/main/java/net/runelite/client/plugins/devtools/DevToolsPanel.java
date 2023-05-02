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

import com.google.inject.ProvisionException;
import java.awt.GridLayout;
import java.awt.TrayIcon;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
import net.runelite.client.callback.ClientThread;
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
		ScheduledExecutorService scheduledExecutorService)
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

		setBackground(ColorScheme.DARK_GRAY_COLOR);

		add(createOptionsPanel());
	}

	private JPanel createOptionsPanel()
	{
		List<JButton> buttons = new ArrayList<>();

		final JPanel container = new JPanel();
		container.setBackground(ColorScheme.DARK_GRAY_COLOR);
		container.setLayout(new GridLayout(0, 2, 3, 3));

		buttons.add(plugin.getPlayers());
		buttons.add(plugin.getNpcs());

		buttons.add(plugin.getGroundItems());
		buttons.add(plugin.getGroundObjects());
		buttons.add(plugin.getGameObjects());
		buttons.add(plugin.getGraphicsObjects());
		buttons.add(plugin.getWalls());
		buttons.add(plugin.getDecorations());

		buttons.add(plugin.getProjectiles());

		buttons.add(plugin.getLocation());
		buttons.add(plugin.getWorldMapLocation());
		buttons.add(plugin.getTileLocation());
		buttons.add(plugin.getCameraPosition());

		buttons.add(plugin.getChunkBorders());
		buttons.add(plugin.getMapSquares());

		buttons.add(plugin.getLineOfSight());
		buttons.add(plugin.getValidMovement());
		buttons.add(plugin.getMovementFlags());
		buttons.add(plugin.getInteracting());
		buttons.add(plugin.getExamine());

		buttons.add(plugin.getDetachedCamera());
		plugin.getDetachedCamera().addActionListener((ev) ->
		{
			client.setOculusOrbState(!plugin.getDetachedCamera().isActive() ? 1 : 0);
			client.setOculusOrbNormalSpeed(!plugin.getDetachedCamera().isActive() ? 36 : 12);
		});

		buttons.add(plugin.getWidgetInspector());
		plugin.getWidgetInspector().addFrame(widgetInspector);

		buttons.add(plugin.getVarInspector());
		plugin.getVarInspector().addFrame(varInspector);

		buttons.add(plugin.getSoundEffects());

		final JButton notificationBtn = new JButton("Notification");
		notificationBtn.addActionListener(e ->
		{
			scheduledExecutorService.schedule(() -> notifier.notify("Wow!", TrayIcon.MessageType.ERROR), 3, TimeUnit.SECONDS);
		});
		buttons.add(notificationBtn);

		buttons.add(plugin.getScriptInspector());
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
		buttons.add(newInfoboxBtn);

		final JButton clearInfoboxBtn = new JButton("Clear Infobox");
		clearInfoboxBtn.addActionListener(e -> infoBoxManager.removeIf(i -> true));
		buttons.add(clearInfoboxBtn);

		buttons.add(plugin.getInventoryInspector());
		plugin.getInventoryInspector().addFrame(inventoryInspector);

		final JButton disconnectBtn = new JButton("Disconnect");
		disconnectBtn.addActionListener(e -> clientThread.invoke(() -> client.setGameState(GameState.CONNECTION_LOST)));
		buttons.add(disconnectBtn);

		buttons.add(plugin.getRoofs());

		try
		{
			ShellFrame sf = plugin.getInjector().getInstance(ShellFrame.class);
			buttons.add(plugin.getShell());
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

		buttons.stream()
			.sorted(Comparator.comparing(JButton::getText))
			.forEach(container::add);

		return container;
	}
}
