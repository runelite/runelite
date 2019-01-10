/*
 * Copyright (c) 2019, Spedwards <https://github.com/Spedwards>
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
package net.runelite.client.plugins.profiles;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;

@Slf4j
class ProfilesPanel extends PluginPanel
{
	private static final String ACCOUNT_USERNAME = "Account Username";
	private static final String ACCOUNT_LABEL = "Account Label";
	private static final Dimension PREFERRED_SIZE = new Dimension(PluginPanel.PANEL_WIDTH - 20, 30);
	private static final Dimension MINIMUM_SIZE = new Dimension(0, 30);

	private final Client client;
	private static ProfilesConfig profilesConfig;

	private final JTextField txtAccountLabel = new JTextField(ACCOUNT_LABEL);
	private final JPasswordField txtAccountLogin = new JPasswordField(ACCOUNT_USERNAME);
	private final JPanel profilesPanel = new JPanel();
	private GridBagConstraints c;

	@Inject
	public ProfilesPanel(Client client, ProfilesConfig config)
	{
		super();
		this.client = client;
		profilesConfig = config;

		setBorder(new EmptyBorder(18, 10, 0, 10));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setLayout(new GridBagLayout());

		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 0;
		c.insets = new Insets(0, 0, 3, 0);

		txtAccountLabel.setPreferredSize(PREFERRED_SIZE);
		txtAccountLabel.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);
		txtAccountLabel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		txtAccountLabel.setMinimumSize(MINIMUM_SIZE);
		txtAccountLabel.addFocusListener(new FocusListener()
		{
			@Override
			public void focusGained(FocusEvent e)
			{
				if (txtAccountLabel.getText().equals(ACCOUNT_LABEL))
				{
					txtAccountLabel.setText("");
					txtAccountLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
				}
			}

			@Override
			public void focusLost(FocusEvent e)
			{
				if (txtAccountLabel.getText().isEmpty())
				{
					txtAccountLabel.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);
					txtAccountLabel.setText(ACCOUNT_LABEL);
				}
			}
		});

		add(txtAccountLabel, c);
		c.gridy++;

		// Do not hide username characters until they focus or if in streamer mode
		txtAccountLogin.setEchoChar((char) 0);
		txtAccountLogin.setPreferredSize(PREFERRED_SIZE);
		txtAccountLogin.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);
		txtAccountLogin.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		txtAccountLogin.setMinimumSize(MINIMUM_SIZE);
		txtAccountLogin.addFocusListener(new FocusListener()
		{
			@Override
			public void focusGained(FocusEvent e)
			{
				if (ACCOUNT_USERNAME.equals(String.valueOf(txtAccountLogin.getPassword())))
				{
					txtAccountLogin.setText("");
					if (config.isStreamerMode())
					{
						txtAccountLogin.setEchoChar('*');
					}
					txtAccountLogin.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
				}
			}

			@Override
			public void focusLost(FocusEvent e)
			{
				if (txtAccountLogin.getPassword().length == 0)
				{
					txtAccountLogin.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);
					txtAccountLogin.setText(ACCOUNT_USERNAME);
					txtAccountLogin.setEchoChar((char) 0);
				}
			}
		});

		add(txtAccountLogin, c);
		c.gridy++;
		c.insets = new Insets(0, 0, 15, 0);

		JButton btnAddAccount = new JButton("Add Account");
		btnAddAccount.setPreferredSize(PREFERRED_SIZE);
		btnAddAccount.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		btnAddAccount.setMinimumSize(MINIMUM_SIZE);
		btnAddAccount.addActionListener(e ->
		{
			String labelText = txtAccountLabel.getText();
			String loginText = String.valueOf(txtAccountLogin.getPassword());
			if (labelText.equals(ACCOUNT_LABEL) || loginText.equals(ACCOUNT_USERNAME))
			{
				return;
			}
			String data = labelText + ":" + loginText;
			log.info(data);
			this.addAccount(data);

			addProfile(data);

			txtAccountLabel.setText(ACCOUNT_LABEL);
			txtAccountLabel.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);

			txtAccountLogin.setText(ACCOUNT_USERNAME);
			txtAccountLogin.setEchoChar((char) 0);
			txtAccountLogin.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);
		});

		txtAccountLogin.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					btnAddAccount.doClick();
					btnAddAccount.requestFocus();
				}
			}
		});

		add(btnAddAccount, c);
		c.gridy++;

		profilesPanel.setLayout(new GridBagLayout());
		add(profilesPanel, c);
		c.gridy = 0;
		c.insets = new Insets(0, 0, 5, 0);

		addAccounts(config.profilesData());
	}

	void redrawProfiles()
	{
		profilesPanel.removeAll();
		c.gridy = 0;
		addAccounts(profilesConfig.profilesData());
	}

	private void addAccount(String data)
	{
		ProfilePanel profile = new ProfilePanel(client, data, profilesConfig);
		c.gridy++;
		profilesPanel.add(profile, c);

		revalidate();
		repaint();
	}

	void addAccounts(String data)
	{
		log.info("Data: " + data);
		data = data.trim();
		if (!data.contains(":"))
		{
			return;
		}
		Arrays.stream(data.split("\\n")).forEach(this::addAccount);
	}

	static void addProfile(String data)
	{
		profilesConfig.profilesData(
			profilesConfig.profilesData() + data + "\n");
	}

	static void removeProfile(String data)
	{
		profilesConfig.profilesData(
			profilesConfig.profilesData().replaceAll(data + "\n", ""));
	}
}
