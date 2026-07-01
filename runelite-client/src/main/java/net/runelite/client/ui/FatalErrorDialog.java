/*
 * Copyright (c) 2019 Abex
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
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.util.VerificationException;

@Slf4j
public class FatalErrorDialog extends JDialog
{
	private static final AtomicBoolean alreadyOpen = new AtomicBoolean(false);

	private final JPanel rightColumn = new JPanel();
	private final Font font = new Font(Font.DIALOG, Font.PLAIN, 12);
	private final JLabel title;

	public FatalErrorDialog(String message)
	{
		if (alreadyOpen.getAndSet(true))
		{
			throw new IllegalStateException("Fatal error during fatal error: " + message);
		}

		try
		{
			setIconImages(Arrays.asList(ClientUI.ICON_128, ClientUI.ICON_16));

			BufferedImage logo = ImageUtil.loadImageResource(FatalErrorDialog.class, "runelite_splash.png");
			JLabel runelite = new JLabel();
			runelite.setIcon(new ImageIcon(logo));
			runelite.setAlignmentX(Component.CENTER_ALIGNMENT);
			runelite.setBackground(ColorScheme.DARK_GRAY_COLOR);
			runelite.setOpaque(true);
			rightColumn.add(runelite);
		}
		catch (RuntimeException e)
		{
		}

		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.exit(-1);
			}
		});

		setTitle("Fatal error starting RuneLite");
		setLayout(new BorderLayout());

		JPanel pane = (JPanel) getContentPane();
		pane.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		JPanel leftPane = new JPanel();
		leftPane.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		leftPane.setLayout(new BorderLayout());

		title = new JLabel("There was a fatal error starting RuneLite");
		title.setForeground(Color.WHITE);
		title.setFont(font.deriveFont(16.f));
		title.setBorder(new EmptyBorder(10, 10, 10, 10));
		leftPane.add(title, BorderLayout.NORTH);

		leftPane.setPreferredSize(new Dimension(400, 200));
		JTextArea textArea = new JTextArea(message);
		textArea.setFont(font);
		textArea.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		textArea.setForeground(Color.LIGHT_GRAY);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBorder(new EmptyBorder(10, 10, 10, 10));
		textArea.setEditable(false);
		textArea.setOpaque(false);
		leftPane.add(textArea, BorderLayout.CENTER);

		pane.add(leftPane, BorderLayout.CENTER);

		rightColumn.setLayout(new BoxLayout(rightColumn, BoxLayout.Y_AXIS));
		rightColumn.setBackground(ColorScheme.DARK_GRAY_COLOR);
		rightColumn.setMaximumSize(new Dimension(200, Integer.MAX_VALUE));

		pane.add(rightColumn, BorderLayout.EAST);
	}

	public void open()
	{
		addButton("Exit", () -> System.exit(-1));

		pack();
		setLocationRelativeTo(null);
		SplashScreen.stop();
		setVisible(true);
	}

	public FatalErrorDialog addButton(String message, Runnable action)
	{
		JButton button = new JButton(message);
		button.addActionListener(e -> action.run());
		button.setFont(font);
		button.setBackground(ColorScheme.DARK_GRAY_COLOR);
		button.setForeground(Color.LIGHT_GRAY);
		button.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createMatteBorder(1, 0, 0, 0, ColorScheme.DARK_GRAY_COLOR.brighter()),
			new EmptyBorder(4, 4, 4, 4)
		));
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
		button.setFocusPainted(false);
		button.addChangeListener(ev ->
		{
			if (button.getModel().isPressed())
			{
				button.setBackground(ColorScheme.DARKER_GRAY_COLOR);
			}
			else if (button.getModel().isRollover())
			{
				button.setBackground(ColorScheme.DARK_GRAY_HOVER_COLOR);
			}
			else
			{
				button.setBackground(ColorScheme.DARK_GRAY_COLOR);
			}
		});

		rightColumn.add(button);
		rightColumn.revalidate();

		return this;
	}

	public FatalErrorDialog setTitle(String windowTitle, String header)
	{
		super.setTitle(windowTitle);
		title.setText(header);
		return this;
	}

	public FatalErrorDialog addHelpButtons()
	{
		return addButton("Open logs folder", () -> LinkBrowser.open(RuneLite.LOGS_DIR.toString()))
			.addButton("Get help on Discord", () -> LinkBrowser.browse(RuneLiteProperties.getDiscordInvite()))
			.addButton("Troubleshooting steps", () -> LinkBrowser.browse(RuneLiteProperties.getTroubleshootingLink()));
	}

	public FatalErrorDialog addBuildingGuide()
	{
		return addButton("Building guide", () -> LinkBrowser.browse(RuneLiteProperties.getBuildingLink()));
	}

	public static void showNetErrorWindow(String action, Throwable err)
	{
		if (err instanceof VerificationException || err instanceof GeneralSecurityException)
		{
			new FatalErrorDialog("RuneLite was unable to verify the security of its connection to the internet while " +
				action + ". You may have a misbehaving antivirus, internet service provider, a proxy, or an incomplete" +
				" java installation.")
				.addHelpButtons()
				.open();
			return;
		}

		if (err instanceof ConnectException)
		{
			new FatalErrorDialog("RuneLite is unable to connect to a required server while " + action + ". " +
				"Please check your internet connection")
				.addHelpButtons()
				.open();
			return;
		}

		if (err instanceof UnknownHostException)
		{
			new FatalErrorDialog("RuneLite is unable to resolve the address of a required server while " + action + ". " +
				"Your DNS resolver may be misconfigured, pointing to an inaccurate resolver, or your internet connection may " +
				"be down. ")
				.addHelpButtons()
				.addButton("Change your DNS resolver", () -> LinkBrowser.browse(RuneLiteProperties.getDNSChangeLink()))
				.open();
			return;
		}

		new FatalErrorDialog("RuneLite encountered a fatal error while " + action + ".")
			.addHelpButtons()
			.open();
	}
}
