/*
 * Copyright (c) 2018 Abex
<<<<<<< HEAD
=======
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
>>>>>>> upstream/master
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
package net.runelite.client.plugins.info;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
<<<<<<< HEAD
import java.awt.Font;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.inject.Singleton;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
=======
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import javax.inject.Singleton;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
>>>>>>> upstream/master
import javax.swing.event.HyperlinkEvent;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.SessionClose;
import net.runelite.api.events.SessionOpen;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.account.SessionManager;
<<<<<<< HEAD
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
=======
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.LinkBrowser;
>>>>>>> upstream/master
import net.runelite.client.util.RunnableExceptionLogger;

@Slf4j
@Singleton
public class InfoPanel extends PluginPanel
{
	private static final String RUNELITE_LOGIN = "https://runelite_login/";

<<<<<<< HEAD
=======
	private static final ImageIcon ARROW_RIGHT_ICON;
	private static final ImageIcon GITHUB_ICON;
	private static final ImageIcon DISCORD_ICON;
	private static final ImageIcon PATREON_ICON;

	private final JLabel loggedLabel = new JLabel();
	private final JRichTextPane emailLabel = new JRichTextPane();

>>>>>>> upstream/master
	@Inject
	@Nullable
	private Client client;

	@Inject
	private RuneLiteProperties runeLiteProperties;

	@Inject
	private EventBus eventBus;

	@Inject
	private SessionManager sessionManager;

	@Inject
	private ScheduledExecutorService executor;

<<<<<<< HEAD
	private final GroupLayout layout = new GroupLayout(this);
	private final JLabel usernameHeader = new JLabel();
	private final JRichTextPane username = new JRichTextPane();

	void init()
	{
		setLayout(layout);

		final Font smallFont = FontManager.getRunescapeSmallFont();

		final JLabel runeliteVersionHeader = new JLabel("RuneLite version");
		runeliteVersionHeader.setFont(smallFont);
		final JLabel runeliteVersion = new JLabel(runeLiteProperties.getVersion());

		final JLabel runescapeVersionHeader = new JLabel("OldSchool Engine");
		runescapeVersionHeader.setFont(smallFont);
=======
	static
	{
		try
		{
			synchronized (ImageIO.class)
			{
				ARROW_RIGHT_ICON = new ImageIcon(ImageIO.read(InfoPanel.class.getResourceAsStream("arrow_right.png")));
				GITHUB_ICON = new ImageIcon(ImageIO.read(InfoPanel.class.getResourceAsStream("github_icon.png")));
				DISCORD_ICON = new ImageIcon(ImageIO.read(InfoPanel.class.getResourceAsStream("discord_icon.png")));
				PATREON_ICON = new ImageIcon(ImageIO.read(InfoPanel.class.getResourceAsStream("patreon_icon.png")));
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	void init()
	{
		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setBorder(new EmptyBorder(10, 10, 10, 10));

		JPanel versionPanel = new JPanel();
		versionPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		versionPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		versionPanel.setLayout(new GridLayout(0, 1));

		final Font smallFont = FontManager.getRunescapeSmallFont();

		JLabel version = new JLabel(htmlLabel("RuneLite version: ", runeLiteProperties.getVersion()));
		version.setFont(smallFont);

		JLabel revision = new JLabel();
		revision.setFont(smallFont);
>>>>>>> upstream/master

		String engineVer = "Unknown";
		if (client != null)
		{
			engineVer = String.format("Rev %s", runeLiteProperties.getRunescapeVersion());
		}
<<<<<<< HEAD
		final JLabel runescapeVersion = new JLabel(engineVer);

		usernameHeader.setFont(smallFont);
		username.enableAutoLinkHandler(false);
		username.addHyperlinkListener(e ->
=======

		revision.setText(htmlLabel("Oldschool revision: ", engineVer));

		loggedLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		loggedLabel.setFont(smallFont);

		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(smallFont);
		emailLabel.enableAutoLinkHandler(false);
		emailLabel.addHyperlinkListener(e ->
>>>>>>> upstream/master
		{
			if (HyperlinkEvent.EventType.ACTIVATED.equals(e.getEventType()) && e.getURL() != null)
			{
				if (e.getURL().toString().equals(RUNELITE_LOGIN))
				{
					executor.execute(RunnableExceptionLogger.wrap(sessionManager::login));
				}
			}
		});

<<<<<<< HEAD
		updateLoggedIn();

		final JRichTextPane issueLink = new JRichTextPane("text/html",
			"RuneLite is open source!<br>"
			+ "Found an issue? Want a feature?<br>"
			+ "<a href=\"https://github.com/runelite/runelite/issues\">"
			+ "Open an issue on GitHub!"
			+ "</a>"
		);

		setBorder(BorderFactory.createEmptyBorder(2, 6, 6, 6));

		layout.setVerticalGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup()
				.addComponent(runeliteVersionHeader)
				.addComponent(runescapeVersionHeader)
			).addGroup(layout.createParallelGroup()
				.addComponent(runeliteVersion)
				.addComponent(runescapeVersion)
			).addGap(6)
			.addComponent(usernameHeader)
			.addGroup(layout.createParallelGroup()
				.addComponent(username)
			)
			.addGap(12)
			.addComponent(issueLink)
		);

		layout.setHorizontalGroup(layout.createParallelGroup()
			.addGroup(layout.createSequentialGroup()
				.addComponent(runeliteVersionHeader)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
				.addComponent(runescapeVersionHeader))
			.addGroup(layout.createSequentialGroup()
				.addComponent(runeliteVersion)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
				.addComponent(runescapeVersion))
			.addComponent(usernameHeader)
			.addComponent(username)
			.addComponent(issueLink)
		);
=======
		versionPanel.add(version);
		versionPanel.add(revision);
		versionPanel.add(Box.createGlue());
		versionPanel.add(loggedLabel);
		versionPanel.add(emailLabel);

		updateLoggedIn();

		JPanel actionsContainer = new JPanel();
		actionsContainer.setBorder(new EmptyBorder(10, 0, 0, 0));
		actionsContainer.setLayout(new GridLayout(3, 1, 0, 10));

		actionsContainer.add(buildLinkPanel(GITHUB_ICON, "Report an issue or", "make a suggestion", runeLiteProperties.getGithubLink()));
		actionsContainer.add(buildLinkPanel(DISCORD_ICON, "Talk to us on our", "discord server", runeLiteProperties.getDiscordInvite()));
		actionsContainer.add(buildLinkPanel(PATREON_ICON, "Become a patron to", "help support RuneLite", runeLiteProperties.getPatreonLink()));

		add(versionPanel, BorderLayout.NORTH);
		add(actionsContainer, BorderLayout.CENTER);
>>>>>>> upstream/master

		eventBus.register(this);
	}

<<<<<<< HEAD
=======
	/**
	 * Builds a link panel with a given icon, text and url to redirect to.
	 */
	private static JPanel buildLinkPanel(ImageIcon icon, String topText, String bottomText, String url)
	{
		JPanel container = new JPanel();
		container.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		container.setLayout(new BorderLayout());
		container.setBorder(new EmptyBorder(10, 10, 10, 10));

		final Color hoverColor = ColorScheme.DARKER_GRAY_HOVER_COLOR;
		final Color pressedColor = ColorScheme.DARKER_GRAY_COLOR.brighter();

		JLabel iconLabel = new JLabel(icon);
		container.add(iconLabel, BorderLayout.WEST);

		JPanel textContainer = new JPanel();
		textContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		textContainer.setLayout(new GridLayout(2, 1));
		textContainer.setBorder(new EmptyBorder(5, 10, 5, 10));

		container.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				LinkBrowser.browse(url);
				container.setBackground(pressedColor);
				textContainer.setBackground(pressedColor);
			}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				container.setBackground(hoverColor);
				textContainer.setBackground(hoverColor);
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				container.setBackground(hoverColor);
				textContainer.setBackground(hoverColor);
				container.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				container.setBackground(ColorScheme.DARKER_GRAY_COLOR);
				textContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
				container.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		JLabel topLine = new JLabel(topText);
		topLine.setForeground(Color.WHITE);
		topLine.setFont(FontManager.getRunescapeSmallFont());

		JLabel bottomLine = new JLabel(bottomText);
		bottomLine.setForeground(Color.WHITE);
		bottomLine.setFont(FontManager.getRunescapeSmallFont());

		textContainer.add(topLine);
		textContainer.add(bottomLine);

		container.add(textContainer, BorderLayout.CENTER);

		JLabel arrowLabel = new JLabel(ARROW_RIGHT_ICON);
		container.add(arrowLabel, BorderLayout.EAST);

		return container;
	}

>>>>>>> upstream/master
	private void updateLoggedIn()
	{
		final String name = sessionManager.getAccountSession() != null
			? sessionManager.getAccountSession().getUsername()
			: null;

		if (name != null)
		{
<<<<<<< HEAD
			username.setContentType("text/plain");
			username.setText(name);
			usernameHeader.setText("Logged in as");
		}
		else
		{
			username.setContentType("text/html");
			username.setText("<a href=\"" + RUNELITE_LOGIN + "\">Login</a> to sync settings to the cloud.");
			usernameHeader.setText("Not logged in");
		}
	}

=======
			emailLabel.setContentType("text/plain");
			emailLabel.setText(name);
			loggedLabel.setText("Logged in as");
		}
		else
		{
			emailLabel.setContentType("text/html");
			emailLabel.setText("<a href=\"" + RUNELITE_LOGIN + "\">Login</a> to sync settings to the cloud.");
			loggedLabel.setText("Not logged in");
		}
	}

	private static String htmlLabel(String key, String value)
	{
		return "<html><body style = 'color:#a5a5a5'>" + key + "<span style = 'color:white'>" + value + "</span></body></html>";
	}

>>>>>>> upstream/master
	@Subscribe
	public void onSessionOpen(SessionOpen sessionOpen)
	{
		updateLoggedIn();
	}

	@Subscribe
	public void onSessionClose(SessionClose e)
	{
		updateLoggedIn();
	}
}
