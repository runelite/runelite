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
import net.runelite.client.ui.ColorScheme;

public class SkillIconPanel extends JPanel
	{
		private final BufferedImage pause;
		private final BufferedImage skill;
		private final AlphaComposite opaque;
		private boolean paused;

		public SkillIconPanel(BufferedImage skill) throws IOException
		{
			this.setPreferredSize(new Dimension(35, 35));
			this.skill = skill;
			this.pause = ImageIO.read(XpTrackerPlugin.class.getResource("pause.png"));
			this.opaque = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
			this.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		}

		@Override
		public void paintComponent(Graphics g)
		{
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(skill, 5, 5, null);
			if (paused)
			{
				Composite old = g2d.getComposite();
				g2d.setComposite(opaque);
				g2d.drawImage(pause, 12, 12, null);
				g2d.setComposite(old);
			}
		}

		public void setPaused(boolean paused)
		{
			this.paused = paused;
		}

	}