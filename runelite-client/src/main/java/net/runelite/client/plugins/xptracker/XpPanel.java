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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.ui.PluginPanel;

@Slf4j
public class XpPanel extends PluginPanel
{
	private Map<Skill, JPanel> labelMap = new HashMap<>();
	private final XpTrackerPlugin xpTracker;

	@Inject
	Client client;

	@Inject
	ScheduledExecutorService executor;

	@Inject
	public XpPanel(XpTrackerPlugin xpTracker)
	{
		super();
		this.xpTracker = xpTracker;

		try
		{
			for (Skill skill : Skill.values())
			{
				if (skill == Skill.OVERALL)
				{
					break;
				}

				JLabel skillLabel = new JLabel();
				labelMap.put(skill, makeSkillPanel(skill, skillLabel));
			}
		}
		catch (IOException e)
		{
			log.warn(null, e);
		}

		JButton resetButton = new JButton("Reset All");
		resetButton.addActionListener((e) -> executor.execute(this::resetAllSkillXpHr));
		resetButton.setPreferredSize(new Dimension(0, 32));
		add(resetButton);
	}

	private JButton makeSkillResetButton(Skill skill) throws IOException
	{
		ImageIcon resetIcon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("reset.png")));
		JButton resetButton = new JButton(resetIcon);
		resetButton.setPreferredSize(new Dimension(32, 32));
		resetButton.addActionListener(actionEvent -> resetSkillXpHr(skill));
		return resetButton;
	}

	private JPanel makeSkillPanel(Skill skill, JLabel levelLabel) throws IOException
	{
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setHgap(12);
		JPanel iconLevel = new JPanel(borderLayout);
		iconLevel.setPreferredSize(new Dimension(0, 32));

		String skillIcon = "/skill_icons/" + skill.getName().toLowerCase() + ".png";
		log.debug("Loading skill icon from {}", skillIcon);
		JLabel icon = new JLabel(new ImageIcon(ImageIO.read(XpPanel.class.getResourceAsStream(skillIcon))));
		iconLevel.add(icon, BorderLayout.LINE_START);
		iconLevel.add(levelLabel, BorderLayout.CENTER);
		iconLevel.add(makeSkillResetButton(skill), BorderLayout.LINE_END);

		return iconLevel;
	}

	public void resetSkillXpHr(Skill skill)
	{
		int skillIdx = skill.ordinal();
		xpTracker.getXpInfos()[skillIdx].reset(client.getSkillExperience(skill));
		remove(labelMap.get(skill));
		revalidate();
	}

	public void resetAllSkillXpHr()
	{
		for (SkillXPInfo skillInfo : xpTracker.getXpInfos())
		{
			if (skillInfo != null && skillInfo.getSkillTimeStart() != null)
			{
				resetSkillXpHr(skillInfo.getSkill());
			}
		}
	}

	public void updateAllSkillXpHr()
	{
		for (SkillXPInfo skillInfo : xpTracker.getXpInfos())
		{
			if (skillInfo != null && skillInfo.getSkillTimeStart() != null
				&& skillInfo.getXpGained() != 0)
			{
				updateSkillXpHr(skillInfo);
			}
		}
	}

	public void updateSkillXpHr(SkillXPInfo skillXPInfo)
	{
		JPanel skillPanel = labelMap.get(skillXPInfo.getSkill());
		JLabel xpHr = (JLabel) skillPanel.getComponent(1);
		xpHr.setText(NumberFormat.getInstance().format(skillXPInfo.getXpHr()) + " xp/hr");

		if (skillPanel.getParent() != this)
		{
			add(skillPanel);
			revalidate();
		}
	}
}
