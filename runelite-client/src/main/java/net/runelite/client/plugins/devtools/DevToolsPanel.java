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

import java.awt.GridLayout;
import javax.inject.Inject;
import javax.swing.JPanel;
import net.runelite.api.Client;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;

class DevToolsPanel extends PluginPanel
{
	private final Client client;
	private final DevToolsPlugin plugin;

	private final WidgetInspector widgetInspector;
	private final VarInspector varInspector;
	private final ChatInspector chatInspector;

	@Inject
	public DevToolsPanel(Client client, DevToolsPlugin plugin, WidgetInspector widgetInspector, VarInspector varInspector, ChatInspector chatInspector)
	{
		super();
		this.client = client;
		this.plugin = plugin;
		this.widgetInspector = widgetInspector;
		this.varInspector = varInspector;
		this.chatInspector = chatInspector;

		setBackground(ColorScheme.DARK_GRAY_COLOR);

		add(createOptionsPanel());
	}

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

		container.add(plugin.getInventory());
		container.add(plugin.getProjectiles());

		container.add(plugin.getLocation());
		container.add(plugin.getWorldMapLocation());
		container.add(plugin.getTileLocation());
		container.add(plugin.getCameraPosition());

		container.add(plugin.getChunkBorders());
		container.add(plugin.getMapSquares());

		container.add(plugin.getLineOfSight());
		container.add(plugin.getValidMovement());
		container.add(plugin.getInteracting());
		container.add(plugin.getExamine());

		container.add(plugin.getDetachedCamera());
		plugin.getDetachedCamera().addActionListener((ev) ->
		{
			client.setOculusOrbState(!plugin.getDetachedCamera().isActive() ? 1 : 0);
			client.setOculusOrbNormalSpeed(!plugin.getDetachedCamera().isActive() ? 36 : 12);
		});

		container.add(plugin.getWidgetInspector());
		plugin.getWidgetInspector().addActionListener((ev) ->
		{
			if (plugin.getWidgetInspector().isActive())
			{
				widgetInspector.close();
			}
			else
			{
				widgetInspector.open();
			}
		});

		container.add(plugin.getVarInspector());
		plugin.getVarInspector().addActionListener((ev) ->
		{
			if (plugin.getVarInspector().isActive())
			{
				varInspector.close();
			}
			else
			{
				varInspector.open();
			}
		});

		final JButton renderLocationBtn = new JButton("Location");
		renderLocationBtn.addActionListener(e ->
		{
			highlightButton(renderLocationBtn);
			plugin.toggleLocation();
		});
		container.add(renderLocationBtn);

		final JButton widgetInspectorBtn = new JButton("Widget Tools");
		widgetInspectorBtn.addActionListener(e ->
		{
			widgetInspector.setVisible(true);
			widgetInspector.toFront();
			widgetInspector.repaint();
		});
		container.add(widgetInspectorBtn);

		final JButton varInspectorBtn = new JButton("Var Tools");
		varInspectorBtn.addActionListener(e ->
		{
			varInspector.open();
		});
		container.add(varInspectorBtn);

		final JButton chunkBordersBtn = new JButton("Chunk borders");
		chunkBordersBtn.addActionListener(e ->
		{
			highlightButton(chunkBordersBtn);
			plugin.toggleChunkBorders();
		});
		container.add(chunkBordersBtn);

		final JButton mapSquaresBtn = new JButton("Map squares");
		mapSquaresBtn.addActionListener(e ->
		{
			highlightButton(mapSquaresBtn);
			plugin.toggleMapSquares();
		});
		container.add(mapSquaresBtn);

		final JButton validMovementBtn = new JButton("Valid Moves");
		validMovementBtn.addActionListener(e ->
		{
			highlightButton(validMovementBtn);
			plugin.toggleValidMovement();
		});
		container.add(validMovementBtn);

		final JButton lineOfSightBtn = new JButton("Line of Sight");
		lineOfSightBtn.addActionListener(e ->
		{
			highlightButton(lineOfSightBtn);
			plugin.toggleLineOfSight();
		});
		container.add(lineOfSightBtn);

		final JButton graphicsObjectsBtn = new JButton("Graphics objects");
		graphicsObjectsBtn.addActionListener(e ->
		{
			highlightButton(graphicsObjectsBtn);
			plugin.toggleGraphicsObjects();
		});
		container.add(graphicsObjectsBtn);

		final JButton cameraPositionBtn = new JButton("Camera Position");
		cameraPositionBtn.addActionListener(e ->
		{
			highlightButton(cameraPositionBtn);
			plugin.toggleCamera();
		});
		container.add(cameraPositionBtn);

		final JButton worldMapBtn = new JButton("World Map Location");
		worldMapBtn.addActionListener(e ->
		{
			highlightButton(worldMapBtn);
			plugin.toggleWorldMapLocation();
		});
		container.add(worldMapBtn);

		final JButton tileLocationBtn = new JButton("Tile Location Tooltip");
		tileLocationBtn.addActionListener(e ->
		{
			highlightButton(tileLocationBtn);
			plugin.toggleTileLocation();
		});
		container.add(tileLocationBtn);

		final JButton oculusOrbBtn = new JButton("Detached camera");
		oculusOrbBtn.addActionListener(e ->
		{
			highlightButton(oculusOrbBtn);
			boolean enabled = oculusOrbBtn.getBackground().equals(Color.GREEN);
			client.setOculusOrbState(enabled ? 1 : 0);
			client.setOculusOrbNormalSpeed(enabled ? 36 : 12);
		});
		container.add(oculusOrbBtn);

		final JButton interactingBtn = new JButton("Interacting");
		interactingBtn.addActionListener(e ->
		{
			highlightButton(interactingBtn);
			plugin.toggleInteracting();
		});
		container.add(interactingBtn);

		final JButton examineInfoBtn = new JButton("Examine Info");
		examineInfoBtn.addActionListener(e ->
		{
			highlightButton(examineInfoBtn);
			plugin.toggleExamineInfo();
		});
		container.add(examineInfoBtn);

		final JButton chatInspectorBtn = new JButton("Chat Inspector");
		chatInspectorBtn.addActionListener(e ->
		{
			chatInspector.open();
		});
		container.add(chatInspectorBtn);

		return container;
	}
}
