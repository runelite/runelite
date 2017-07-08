/*
 * Copyright (c) 2017, Cameron <moberg@tuta.io>
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
package net.runelite.client.plugins.xptracker;

import com.google.common.eventbus.Subscribe;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.RuneLite;
import net.runelite.client.events.ExperienceChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.RunnableExceptionLogger;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class XPTracker extends Plugin
{
	private static final int NUMBER_OF_SKILLS = Skill.values().length - 1; //ignore overall

	private final RuneLite runeLite = RuneLite.getRunelite();
	private final ClientUI ui = runeLite.getGui();
	private Client client = RuneLite.getClient();
	private ScheduledFuture<?> future;

	private final NavigationButton navButton = new NavigationButton("XP Tracker");
	private final XPPanel xpPanel = new XPPanel(runeLite, this);
	private SkillXPInfo[] xpInfos = new SkillXPInfo[NUMBER_OF_SKILLS];

	@Subscribe
	public void onXpChanged(ExperienceChanged event)
	{
		Skill skill = event.getSkill();
		int skillIdx = skill.ordinal();

		//To catch login ExperienceChanged event.
		if (xpInfos[skillIdx] != null)
		{
			xpInfos[skillIdx].update();
		} else
		{
			xpInfos[skillIdx] = new SkillXPInfo(client.getSkillExperience(skill), skill);
		}
	}

	private void setPluginPanel(ActionEvent e)
	{
		ui.expand(xpPanel);
	}

	@Override
	protected void startUp() throws Exception
	{
		navButton.getButton().addActionListener(this::setPluginPanel);

		navButton.getButton().setText("XP");
		ui.getNavigationPanel().addNavigation(navButton);

		ScheduledExecutorService executor = RuneLite.getRunelite().getExecutor();
		future = executor.scheduleAtFixedRate(RunnableExceptionLogger.wrap(
				xpPanel::updateAllSkillXpHr), 0, 600, TimeUnit.MILLISECONDS);

		Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/runescape.ttf"));
		font = font.deriveFont(Font.BOLD, 16);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(font);
	}

	@Override
	protected void shutDown() throws Exception
	{
		future.cancel(true);
	}

	public SkillXPInfo[] getXpInfos()
	{
		return xpInfos;
	}

}
