/*
 * Copyright (c) 2016-2017, Jeremy Plsek <github.com/jplsek>
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
package net.runelite.client.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.inject.Singleton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicProgressBarUI;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.util.SwingUtil;
import org.pushingpixels.substance.internal.SubstanceSynapse;

/**
 * This is a custom Splash Screen and does not use Java's SplashScreen class. This has helper methods to update the
 * status while loading RuneLite. All public methods run non-blocking passed to the swing thread.
 */
@Slf4j
@Singleton
public class RuneLiteSplashScreen
{
	private RuneLiteProperties runeLiteProperties = new RuneLiteProperties();

	public JFrame frame;
	public JPanel panel = new JPanel();
	public JLabel messageLabel;
	public JLabel subMessageLabel;
	public JProgressBar progressBar = new JProgressBar();

	private int currentStep;

	/**
	 * This is not done in the constructor in order to avoid processing in case the user chooses to not load
	 * the splash screen.
	 *
	 * @param estimatedSteps steps until completion, used for the progress bar
	 */
	private void initLayout(final int estimatedSteps)
	{
		SwingUtil.setupRuneLiteLookAndFeel();

		// init fields with updated swing look and feel
		frame = new JFrame("RuneLitePlus Loading");
		messageLabel = new JLabel("Loading...");
		subMessageLabel = new JLabel();
		progressBar.setUI(new BasicProgressBarUI());
		progressBar.setMinimum(0);
		progressBar.setMaximum(estimatedSteps);

		// frame setup
		frame.setSize(220, 290);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);

		// main panel setup
		// To reduce substance's colorization (tinting)
		panel.putClientProperty(SubstanceSynapse.COLORIZATION_FACTOR, 1.0);
		panel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		final GridBagLayout layout = new GridBagLayout();
		layout.columnWeights = new double[]{1};
		layout.rowWeights = new double[]{1, 0, 0, 1, 0, 1};
		panel.setLayout(layout);

		// logo
		synchronized (ImageIO.class)
		{
			try
			{
				final BufferedImage logo = ImageIO.read(RuneLiteSplashScreen.class.getResourceAsStream("/runeliteplus.png"));
				frame.setIconImage(logo);

				final BufferedImage logoTransparent = ImageIO.read(RuneLiteSplashScreen.class.getResourceAsStream("/runeliteplus_transparent.png"));
				final GridBagConstraints logoConstraints = new GridBagConstraints();
				logoConstraints.anchor = GridBagConstraints.SOUTH;
				panel.add(new JLabel(new ImageIcon(logoTransparent.getScaledInstance(96, 96, Image.SCALE_SMOOTH))), logoConstraints);
			}
			catch (IOException e)
			{
				log.warn("Error loading logo", e);
			}
		}

		// runelite title
		final JLabel title = new JLabel("RuneLitePlus");
		final GridBagConstraints titleConstraints = new GridBagConstraints();
		titleConstraints.gridy = 1;
		panel.add(title, titleConstraints);

		// version
		final JLabel version = new JLabel("RuneLite Version : " + runeLiteProperties.getVersion());
		version.setForeground(Color.GREEN);
		version.setFont(FontManager.getRunescapeSmallFont());
		version.setForeground(version.getForeground().darker());
		final GridBagConstraints versionConstraints = new GridBagConstraints();
		versionConstraints.gridy = 2;
		panel.add(version, versionConstraints);

		// version
		final JLabel litVersion = new JLabel("Plus Version : " + RuneLite.RUNELIT_VERSION);
		litVersion.setForeground(Color.GREEN);
		litVersion.setFont(FontManager.getRunescapeSmallFont());
		litVersion.setForeground(litVersion.getForeground().darker());
		final GridBagConstraints litVersionConstraints = new GridBagConstraints();
		litVersionConstraints.gridy = 3;
		litVersionConstraints.weightx = 4;
		panel.add(litVersion, litVersionConstraints);


		// progressbar
		final GridBagConstraints progressConstraints = new GridBagConstraints();
		progressConstraints.fill = GridBagConstraints.HORIZONTAL;
		progressConstraints.anchor = GridBagConstraints.SOUTH;
		progressConstraints.gridy = 4;
		panel.add(progressBar, progressConstraints);

		// main message
		messageLabel.setFont(FontManager.getRunescapeSmallFont());
		final GridBagConstraints messageConstraints = new GridBagConstraints();
		messageConstraints.gridy = 5;
		panel.add(messageLabel, messageConstraints);

		// alternate message
		final GridBagConstraints subMessageConstraints = new GridBagConstraints();
		subMessageLabel.setForeground(subMessageLabel.getForeground().darker());
		subMessageLabel.setFont(FontManager.getRunescapeSmallFont());
		subMessageConstraints.gridy = 6;
		panel.add(subMessageLabel, subMessageConstraints);

		frame.setContentPane(panel);
	}

	private boolean notActive()
	{
		return frame == null || !frame.isDisplayable();
	}

	/**
	 * Close/dispose of the splash screen
	 */
	public void close()
	{
		SwingUtilities.invokeLater(() ->
		{
			if (notActive())
			{
				return;
			}

			frame.dispose();
		});
	}

	/**
	 * Set the splash screen to be visible.
	 *
	 * @param estimatedSteps steps until completion, used for the progress bar
	 */
	public void open(final int estimatedSteps)
	{
		SwingUtilities.invokeLater(() ->
		{
			initLayout(estimatedSteps);
			frame.setVisible(true);
		});
	}

	public void setMessage(final String message)
	{
		SwingUtilities.invokeLater(() ->
		{
			if (notActive())
			{
				return;
			}
			messageLabel.setText(message);
		});
	}

	public void setSubMessage(final String subMessage)
	{
		SwingUtilities.invokeLater(() ->
		{
			if (notActive())
			{
				return;
			}
			subMessageLabel.setText(subMessage);
		});
	}

	public void setProgress(int currentProgress, int progressGoal)
	{
		SwingUtilities.invokeLater(() ->
		{
			if (notActive())
			{
				return;
			}
			if (progressGoal != progressBar.getMaximum())
			{
				panel.remove(progressBar);
				panel.validate();
				final GridBagConstraints progressConstraints = new GridBagConstraints();
				progressConstraints.fill = GridBagConstraints.HORIZONTAL;
				progressConstraints.anchor = GridBagConstraints.SOUTH;
				progressConstraints.gridy = 4;
				panel.add(progressBar, progressConstraints);
				panel.validate();
			}
			progressBar.setMaximum(progressGoal);
			progressBar.setValue(currentProgress);
		});
	}
}
