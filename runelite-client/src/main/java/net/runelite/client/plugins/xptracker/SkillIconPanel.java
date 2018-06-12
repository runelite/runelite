/*
 * Copyright (c) 2018, Jasper <Jasper0781@gmail.com>
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

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import lombok.Setter;
import net.runelite.client.ui.ColorScheme;

public class SkillIconPanel extends JPanel
{
	private static final int SKILL_ICON_PANEL_SIZE = 35;

	private final BufferedImage pause;
	private final BufferedImage skill;
	private final int skillX, skillY;
	private final int pauseX, pauseY;
	private final AlphaComposite opaque;
	@Setter
	private boolean paused;

	public SkillIconPanel(BufferedImage skill) throws IOException
	{
		this.setPreferredSize(new Dimension(SKILL_ICON_PANEL_SIZE, SKILL_ICON_PANEL_SIZE));
		this.skill = skill;
		this.skillX = (SKILL_ICON_PANEL_SIZE - skill.getWidth()) / 2;
		this.skillY = (SKILL_ICON_PANEL_SIZE - skill.getHeight()) / 2;
		this.pause = ImageIO.read(XpTrackerPlugin.class.getResource("pause.png"));
		this.pauseX = (SKILL_ICON_PANEL_SIZE - pause.getWidth()) / 2;
		this.pauseY = (SKILL_ICON_PANEL_SIZE - pause.getHeight()) / 2;
		this.opaque = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
		this.setBackground(ColorScheme.DARKER_GRAY_COLOR);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(skill, skillX, skillY, null);
		if (paused)
		{
			Composite old = g2d.getComposite();
			g2d.setComposite(opaque);
			g2d.drawImage(pause, pauseX, pauseY, null);
			g2d.setComposite(old);
		}
	}
}