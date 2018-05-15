/*
 * Copyright (c) 2018, Kruithne <kruithne@gmail.com>
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

package net.runelite.client.plugins.skillcalculator;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;

@PluginDescriptor(name = "Skill Calculator")
public class SkillCalculatorPlugin extends Plugin
{
	@Inject
	private ClientUI ui;

	@Inject
	private Client client;

	@Inject
	private SkillIconManager skillIconManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private PluginToolbar pluginToolbar;

	private NavigationButton uiNavigationButton;
	private SkillCalculatorPanel uiPanel;

	@Override
	protected void startUp() throws Exception
	{
		BufferedImage icon;
		synchronized (ImageIO.class)
		{
			icon = ImageIO.read(getClass().getResourceAsStream("calc.png"));
		}

		SkillCalculator.spriteManager = spriteManager;
		SkillCalculator.itemManager = itemManager;

		uiPanel = new SkillCalculatorPanel(skillIconManager, client);
		uiNavigationButton = NavigationButton.builder().name("Skill Calculator").icon(icon).panel(uiPanel).build();
		pluginToolbar.addNavigation(uiNavigationButton);
	}

	@Override
	protected void shutDown() throws Exception
	{
		pluginToolbar.removeNavigation(uiNavigationButton);
	}
}