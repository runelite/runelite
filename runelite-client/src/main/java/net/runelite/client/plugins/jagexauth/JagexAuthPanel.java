/*
 * Copyright (c) 2026, Adam <Adam@sigterm.info>
 * Copyright (c) 2026, LlemonDuck <napkinorton@gmail.com>
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
package net.runelite.client.plugins.jagexauth;

import com.google.common.base.MoreObjects;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.rs.auth.Account;
import net.runelite.client.rs.auth.JagexAuthService;
import net.runelite.client.rs.auth.Session;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.SwingUtil;

@Slf4j
class JagexAuthPanel extends PluginPanel
{
	static final String DEFAULT_ACCOUNT_KEY = "defaultJagexAccount";

	private static final ImageIcon DELETE_ICON = new ImageIcon(ImageUtil.loadImageResource(
		JagexAuthPanel.class, "/net/runelite/client/plugins/config/mdi_delete.png"));
	private static final ImageIcon JAGEX_ACCOUNT_ICON = new ImageIcon(ImageUtil.resizeImage(
		ImageUtil.loadImageResource(JagexAuthPanel.class, "icon.png"), 16, 16));
	private static final ImageIcon ON_STAR;
	private static final ImageIcon OFF_STAR;

	static
	{
		BufferedImage onStar = ImageUtil.loadImageResource(
			JagexAuthPanel.class, "/net/runelite/client/plugins/config/star_on.png");
		ON_STAR = new ImageIcon(onStar);

		BufferedImage offStar = ImageUtil.luminanceScale(
			ImageUtil.grayscaleImage(onStar),
			0.77f
		);
		OFF_STAR = new ImageIcon(offStar);
	}

	private final JagexAuthService jagexAuthService;
	private final ConfigManager configManager;

	private final JPanel sessionList = new JPanel(new DynamicGridLayout(0, 1, 0, 8));
	private final JPanel actions = new JPanel(new GridLayout(0, 1, 0, 4));
	private final JButton addAccountButton = new JButton("Add Jagex Account");
	private final JLabel infoLabel = new JLabel();
	private final Map<String, JToggleButton> defaultAccountButtons = new HashMap<>();

	@Inject
	private JagexAuthPanel(JagexAuthService jagexAuthService, ConfigManager configManager)
	{
		this.jagexAuthService = jagexAuthService;
		this.configManager = configManager;

		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new DynamicGridLayout(0, 1, 0, 10));

		sessionList.setOpaque(false);

		addAccountButton.setToolTipText("Log in to a Jagex account");
		addAccountButton.addActionListener(e -> addAccount());

		JButton legacyAccountButton = new JButton("Use Legacy Account");
		legacyAccountButton.setToolTipText("Log in with a non-Jagex account");
		legacyAccountButton.addActionListener(e -> jagexAuthService.switchJagexAccount(null, null, null));

		actions.setOpaque(false);
		actions.add(addAccountButton);
		actions.add(legacyAccountButton);
	}

	void rebuild()
	{
		List<Session> sessions = jagexAuthService.getSessions();

		removeAll();
		sessionList.removeAll();
		defaultAccountButtons.clear();

		for (Session session : sessions)
		{
			sessionList.add(createSessionCard(session));
		}

		infoLabel.setText(sessions.isEmpty()
			? "<html>You can create a Jagex account with the Jagex Launcher.</html>"
			: "<html>Click a character to switch to it. New characters can be created with the Jagex Launcher.</html>");

		if (!sessions.isEmpty())
		{
			add(sessionList);
		}
		add(actions);
		add(infoLabel);

		revalidate();
		repaint();
	}

	private void addAccount()
	{
		addAccountButton.setEnabled(false);
		new Thread(() ->
		{
			try
			{
				jagexAuthService.performJagexAuthFlow();
			}
			catch (Exception ex)
			{
				log.error("Unable to add Jagex account", ex);
			}
			finally
			{
				SwingUtilities.invokeLater(() ->
				{
					addAccountButton.setEnabled(true);
					rebuild();
				});
			}
		}, "JagexAuth").start();
	}

	private void removeSession(Session session)
	{
		String defaultAccountId = getDefaultAccountId();
		Account[] accounts = jagexAuthService.getAccounts(session.getSessionId());
		if (defaultAccountId != null && accounts != null)
		{
			for (Account account : accounts)
			{
				if (defaultAccountId.equals(Long.toString(account.getAccountId())))
				{
					setDefaultAccountId(null);
					break;
				}
			}
		}

		jagexAuthService.removeSession(session);
		rebuild();
	}

	private JPanel createSessionCard(Session session)
	{
		JLabel title = new JLabel(session.getNickname(), JAGEX_ACCOUNT_ICON, SwingConstants.LEADING);
		title.setIconTextGap(6);
		title.setFont(FontManager.getRunescapeBoldFont());
		title.setForeground(ColorScheme.BRAND_ORANGE);

		JButton removeButton = new JButton(DELETE_ICON);
		SwingUtil.removeButtonDecorations(removeButton);
		removeButton.setToolTipText("Remove account");
		removeButton.addActionListener(e -> removeSession(session));

		JPanel header = new JPanel(new BorderLayout(4, 0));
		header.setOpaque(false);
		header.setBorder(new CompoundBorder(
			new MatteBorder(0, 0, 1, 0, ColorScheme.DARK_GRAY_COLOR),
			new EmptyBorder(2, 10, 2, 0)));
		header.add(title, BorderLayout.CENTER);
		header.add(removeButton, BorderLayout.EAST);

		JPanel characters = new JPanel(new DynamicGridLayout(0, 1));
		characters.setOpaque(false);
		characters.setBorder(new EmptyBorder(2, 0, 2, 0));

		Account[] accounts = jagexAuthService.getAccounts(session.getSessionId());
		if (accounts == null || accounts.length == 0)
		{
			JLabel empty = new JLabel("No characters");
			empty.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
			empty.setBorder(new EmptyBorder(6, 10, 6, 10));
			characters.add(empty);
		}
		else
		{
			String defaultAccountId = getDefaultAccountId();
			for (Account account : accounts)
			{
				String accountId = Long.toString(account.getAccountId());
				String displayName = account.getDisplayName();

				JToggleButton defaultAccountButton = new JToggleButton(OFF_STAR);
				defaultAccountButton.setSelectedIcon(ON_STAR);
				SwingUtil.removeButtonDecorations(defaultAccountButton);
				SwingUtil.addModalTooltip(defaultAccountButton, "Unset as default account", "Set as default account");
				defaultAccountButton.setPreferredSize(new Dimension(21, 0));
				defaultAccountButton.setSelected(accountId.equals(defaultAccountId));
				defaultAccountButton.addActionListener(e -> toggleDefaultAccount(accountId));
				defaultAccountButtons.put(accountId, defaultAccountButton);

				JButton button = createCharacterButton(MoreObjects.firstNonNull(displayName, "<New Character>"));
				button.addActionListener(e -> jagexAuthService.switchJagexAccount(
					session.getSessionId(), accountId, displayName));

				JPanel row = new JPanel(new BorderLayout(3, 0));
				row.setOpaque(false);
				row.setBorder(new EmptyBorder(0, 6, 0, 0));
				row.add(defaultAccountButton, BorderLayout.LINE_START);
				row.add(button, BorderLayout.CENTER);

				characters.add(row);
			}
		}

		JPanel card = new JPanel(new BorderLayout());
		card.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		card.add(header, BorderLayout.NORTH);
		card.add(characters, BorderLayout.CENTER);
		return card;
	}

	private void toggleDefaultAccount(String accountId)
	{
		String nextDefault = accountId.equals(getDefaultAccountId()) ? null : accountId;
		setDefaultAccountId(nextDefault);
		defaultAccountButtons.forEach((id, btn) -> btn.setSelected(id.equals(nextDefault)));
	}

	private String getDefaultAccountId()
	{
		return configManager.getConfiguration(RuneLiteConfig.GROUP_NAME, DEFAULT_ACCOUNT_KEY);
	}

	private void setDefaultAccountId(String accountId)
	{
		if (accountId == null)
		{
			configManager.unsetConfiguration(RuneLiteConfig.GROUP_NAME, DEFAULT_ACCOUNT_KEY);
		}
		else
		{
			configManager.setConfiguration(RuneLiteConfig.GROUP_NAME, DEFAULT_ACCOUNT_KEY, accountId);
		}
	}

	private static JButton createCharacterButton(String text)
	{
		JButton button = new JButton(text);
		button.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		button.setBorder(new EmptyBorder(6, 4, 6, 10));
		button.setHorizontalAlignment(SwingConstants.LEADING);
		return button;
	}
}
