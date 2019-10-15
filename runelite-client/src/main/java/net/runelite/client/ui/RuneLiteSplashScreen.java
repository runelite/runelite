/*
 * Copyright (c) 2019, TheStonedTurtle <https://github.com/TheStonedTurtle>
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

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.components.InfoPanel;
import net.runelite.client.ui.components.MessagePanel;

@Slf4j
public class RuneLiteSplashScreen extends JFrame
{
	private static RuneLiteSplashScreen INSTANCE;
	public static final Dimension FRAME_SIZE = new Dimension(600, 350);

	@Getter
	private final MessagePanel messagePanel = new MessagePanel();

	private RuneLiteSplashScreen()
	{
		this.setTitle("OpenOSRS");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(FRAME_SIZE);
		this.setLayout(new BorderLayout());
		this.setUndecorated(true);
		this.setIconImage(ClientUI.ICON);

		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setPreferredSize(RuneLiteSplashScreen.FRAME_SIZE);

		panel.add(new InfoPanel(), BorderLayout.EAST);
		panel.add(messagePanel, BorderLayout.WEST);

		this.setContentPane(panel);
		pack();

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void setError(String title, String content)
	{
		if (INSTANCE != null)
		{
			INSTANCE.setErrorInstance(title, content);
		}
	}

	private void setErrorInstance(String title, String content)
	{
		messagePanel.setMessageContent(content);
		messagePanel.setMessageTitle("Error!");

		messagePanel.getBarLabel().setText(title);
		messagePanel.getBar().setBackground(ColorScheme.PROGRESS_ERROR_COLOR.darker());
		messagePanel.getBar().setForeground(ColorScheme.PROGRESS_ERROR_COLOR);

		this.getContentPane().revalidate();
		this.getContentPane().repaint();
	}

	private void setBarText(final String text)
	{
		final JProgressBar bar = messagePanel.getBar();
		bar.setString(text);
		bar.setStringPainted(text != null);
		bar.revalidate();
		bar.repaint();
	}

	private void setMessage(final String msg, final double value)
	{
		messagePanel.getBarLabel().setText(msg);
		messagePanel.getBar().setMaximum(1000);
		messagePanel.getBar().setValue((int) (value * 1000));
		setBarText(null);

		this.getContentPane().revalidate();
		this.getContentPane().repaint();
	}

	public static void init()
	{
		SwingUtilities.invokeLater(() ->
		{
			try
			{
				INSTANCE = new RuneLiteSplashScreen();
			}
			catch (Exception e)
			{
				log.warn("Unable to start splash screen", e);
			}
		});
	}

	public static void close()
	{
		SwingUtilities.invokeLater(() ->
		{
			if (INSTANCE == null)
			{
				return;
			}

			INSTANCE.setVisible(false);
			INSTANCE.dispose();
			INSTANCE = null;
		});
	}

	public static void stage(double startProgress, double endProgress, String progressText, int done, int total)
	{
		String progress = done + " / " + total;
		stage(startProgress + ((endProgress - startProgress) * done / total), progressText + " " + progress);
	}

	public static void stage(double overallProgress, String progressText)
	{
		if (INSTANCE != null)
		{
			INSTANCE.setMessage(progressText, overallProgress);
		}
	}
}