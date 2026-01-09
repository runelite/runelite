/*
 * Copyright (c) 2024, Car_role
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
package net.runelite.client.plugins.customuianchors;

import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.customuianchors.CustomUIAnchorInputListener;
import net.runelite.client.ui.overlay.customuianchors.CustomUIAnchorManager;
import net.runelite.client.ui.overlay.customuianchors.CustomUIAnchorOverlay;
import net.runelite.client.ui.overlay.customuianchors.CustomUIAnchorPanel;
import net.runelite.client.util.ImageUtil;

@Slf4j
@PluginDescriptor(
	name = "Custom UI Anchors",
	description = "Create custom UI anchors to position and organize overlays. Hold Alt to see anchors and drag overlays into them.",
	tags = {"overlay", "anchor", "position", "customization", "ui", "layout"}
)
public class CustomUIAnchorsPlugin extends Plugin
{
	@Inject
	private CustomUIAnchorManager customUIAnchorManager;

	@Inject
	private CustomUIAnchorOverlay customUIAnchorOverlay;

	@Inject
	private CustomUIAnchorInputListener inputListener;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MouseManager mouseManager;

	@Inject
	private ClientToolbar clientToolbar;

	private CustomUIAnchorPanel panel;
	private NavigationButton navButton;

	@Override
	protected void startUp() throws Exception
	{
		customUIAnchorManager.startUp();

		panel = new CustomUIAnchorPanel(customUIAnchorManager);

		// Set panel reference so manager/overlay can check if panel is visible
		customUIAnchorManager.setPanel(panel);
		customUIAnchorOverlay.setPanel(panel);

		inputListener.setSelectionCallback(anchor ->
			SwingUtilities.invokeLater(() -> panel.setSelectedAnchor(anchor)));

		BufferedImage icon = null;
		try
		{
			icon = ImageUtil.loadImageResource(getClass(), "icon.png");
		}
		catch (Exception e)
		{
			log.warn("Could not load custom UI anchors icon, using fallback", e);
		}

		if (icon == null)
		{
			icon = createFallbackIcon();
		}

		navButton = NavigationButton.builder()
			.tooltip("Custom UI Anchors")
			.icon(icon)
			.priority(5)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);
		overlayManager.add(customUIAnchorOverlay);
		mouseManager.registerMouseListener(inputListener);

		log.info("Custom UI Anchors plugin started");
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(customUIAnchorOverlay);
		mouseManager.unregisterMouseListener(inputListener);
		clientToolbar.removeNavigation(navButton);
		customUIAnchorManager.shutDown();

		log.info("Custom UI Anchors plugin stopped");
	}

	private BufferedImage createFallbackIcon()
	{
		BufferedImage image = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		java.awt.Graphics2D g = image.createGraphics();

		g.setColor(java.awt.Color.CYAN);
		g.drawRect(2, 2, 11, 11);

		g.setColor(new java.awt.Color(0, 255, 255, 100));
		g.fillRect(3, 3, 10, 10);

		g.setColor(java.awt.Color.WHITE);
		g.fillRect(6, 6, 4, 4);

		g.dispose();
		return image;
	}
}
