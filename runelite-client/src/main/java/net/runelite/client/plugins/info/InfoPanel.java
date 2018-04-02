/*
 * Copyright (c) 2018 Abex
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
import java.awt.Font;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.inject.Singleton;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.event.HyperlinkEvent;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.SessionClose;
import net.runelite.api.events.SessionOpen;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.account.SessionManager;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.RunnableExceptionLogger;

@Slf4j
@Singleton
public class InfoPanel extends PluginPanel
{
	private static final String RUNELITE_LOGIN = "https://runelite_login/";

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

		String engineVer = "Unknown";
		if (client != null)
		{
			engineVer = String.format("Rev %s", runeLiteProperties.getRunescapeVersion());
		}
		final JLabel runescapeVersion = new JLabel(engineVer);

		usernameHeader.setFont(smallFont);
		username.enableAutoLinkHandler(false);
		username.addHyperlinkListener(e ->
		{
			if (HyperlinkEvent.EventType.ACTIVATED.equals(e.getEventType()) && e.getURL() != null)
			{
				if (e.getURL().toString().equals(RUNELITE_LOGIN))
				{
					executor.execute(RunnableExceptionLogger.wrap(sessionManager::login));
				}
			}
		});

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

		eventBus.register(this);
	}

	private void updateLoggedIn()
	{
		final String name = sessionManager.getAccountSession() != null
			? sessionManager.getAccountSession().getUsername()
			: null;

		if (name != null)
		{
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
