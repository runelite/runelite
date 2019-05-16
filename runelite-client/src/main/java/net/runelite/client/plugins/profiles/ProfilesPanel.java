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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;

@Slf4j
class ProfilesPanel extends PluginPanel
{
	private static final int iterations = 100000;
	private static final String UNLOCK_PASSWORD = "Encryption Password";
	private static final String LOAD_ACCOUNTS = "Load Accounts";
	private static final String ACCOUNT_USERNAME = "Account Username";
	private static final String ACCOUNT_LABEL = "Account Label";
	private static final String PASSWORD_LABEL = "Account Password";
	private static final String HELP = "To add and load accounts, first enter a password into the Encryption Password " +
		"field then press Load Accounts. You can now add as many accounts as you would like. The next time you restart" +
		"Runelite, enter your encryption password and click load accounts to see the accounts you entered";
	private static final Dimension PREFERRED_SIZE = new Dimension(PluginPanel.PANEL_WIDTH - 20, 30);
	private static final Dimension HELP_PREFERRED_SIZE = new Dimension(PluginPanel.PANEL_WIDTH - 20, 130);

	private static final Dimension MINIMUM_SIZE = new Dimension(0, 30);

	private final Client client;
	private static ProfilesConfig profilesConfig;

	private final JPasswordField txtDecryptPassword = new JPasswordField(UNLOCK_PASSWORD);
	private final JTextField txtAccountLabel = new JTextField(ACCOUNT_LABEL);
	private final JPasswordField txtAccountLogin = new JPasswordField(ACCOUNT_USERNAME);
	private final JPasswordField txtPasswordLogin = new JPasswordField(PASSWORD_LABEL);
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
		c.insets = new Insets(0, 0, 4, 0);

		JPanel helpPanel = new JPanel(new BorderLayout());
		helpPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		JLabel helpLabel = new JLabel("<html> <p>" + HELP + "</p></html>");
		helpLabel.setFont(FontManager.getRunescapeSmallFont());
		helpPanel.setPreferredSize(HELP_PREFERRED_SIZE);
		// helpPanel.setSize(MINIMUM_SIZE);
		helpPanel.add(helpLabel, BorderLayout.NORTH);

		add(helpPanel);
		c.gridy = c.gridy + 3;
		c.gridy++;

		txtDecryptPassword.setEchoChar((char) 0);
		txtDecryptPassword.setPreferredSize(PREFERRED_SIZE);
		txtDecryptPassword.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);
		txtDecryptPassword.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		txtDecryptPassword.setMinimumSize(MINIMUM_SIZE);
		txtDecryptPassword.setToolTipText(UNLOCK_PASSWORD);
		txtDecryptPassword.addFocusListener(new FocusListener()
		{
			@Override
			public void focusGained(FocusEvent e)
			{
				txtDecryptPassword.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
				if (String.valueOf(txtDecryptPassword.getPassword()).equals(UNLOCK_PASSWORD))
				{
					txtDecryptPassword.setText("");
					txtDecryptPassword.setEchoChar('*');
				}
			}

			@Override
			public void focusLost(FocusEvent e)
			{
				txtDecryptPassword.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);
				if (txtDecryptPassword.getPassword().length == 0)
				{
					txtDecryptPassword.setText(UNLOCK_PASSWORD);
					txtDecryptPassword.setEchoChar((char) 0);
				}
			}
		});

		add(txtDecryptPassword, c);
		c.gridy++;

		JButton btnLoadAccounts = new JButton(LOAD_ACCOUNTS);
		btnLoadAccounts.setPreferredSize(PREFERRED_SIZE);
		btnLoadAccounts.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		btnLoadAccounts.setMinimumSize(MINIMUM_SIZE);
		btnLoadAccounts.setToolTipText(LOAD_ACCOUNTS);
		btnLoadAccounts.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{

			}

			@Override
			public void mousePressed(MouseEvent e)
			{

			}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				try
				{
					redrawProfiles();
				}
				catch (InvalidKeySpecException | NoSuchAlgorithmException ex)
				{
					showErrorMessage("Unable to load data", "Incorrect password!");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{

			}

			@Override
			public void mouseExited(MouseEvent e)
			{

			}
		});

		add(btnLoadAccounts, c);
		c.gridy++;

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

		txtPasswordLogin.setEchoChar((char) 0);
		txtPasswordLogin.setPreferredSize(PREFERRED_SIZE);
		txtPasswordLogin.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);
		txtPasswordLogin.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		txtPasswordLogin.setToolTipText(PASSWORD_LABEL);
		txtPasswordLogin.setMinimumSize(MINIMUM_SIZE);
		txtPasswordLogin.addFocusListener(new FocusListener()
		{
			@Override
			public void focusGained(FocusEvent e)
			{
				if (PASSWORD_LABEL.equals(String.valueOf(txtPasswordLogin.getPassword())))
				{
					txtPasswordLogin.setText("");
					txtPasswordLogin.setEchoChar('*');
					txtPasswordLogin.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
				}
			}

			@Override
			public void focusLost(FocusEvent e)
			{
				if (txtPasswordLogin.getPassword().length == 0)
				{
					txtPasswordLogin.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);
					txtPasswordLogin.setText(PASSWORD_LABEL);
					txtPasswordLogin.setEchoChar((char) 0);
				}
			}
		});


		if (config.rememberPassword())
		{
			add(txtPasswordLogin, c);
			c.gridy++;
		}
		c.insets = new Insets(0, 0, 15, 0);

		JButton btnAddAccount = new JButton("Add Account");
		btnAddAccount.setPreferredSize(PREFERRED_SIZE);
		btnAddAccount.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		btnAddAccount.setMinimumSize(MINIMUM_SIZE);
		btnAddAccount.addActionListener(e ->
		{
			String labelText = String.valueOf(txtAccountLabel.getText());
			String loginText = String.valueOf(txtAccountLogin.getPassword());
			String passwordText = String.valueOf(txtPasswordLogin.getPassword());

			if (labelText.equals(ACCOUNT_LABEL) || loginText.equals(ACCOUNT_USERNAME))
			{
				return;
			}
			String data;
			if (config.rememberPassword() && txtPasswordLogin.getPassword() != null)
			{
				data = labelText + ":" + loginText + ":" + passwordText;
			}
			else
			{
				data = labelText + ":" + loginText;
			}

			try
			{
				if (!addProfile(data))
				{
					return;
				}
			}
			catch (InvalidKeySpecException | NoSuchAlgorithmException ex)
			{
				ex.printStackTrace();
			}

			this.addAccount(data);

			txtAccountLabel.setText(ACCOUNT_LABEL);
			txtAccountLabel.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);

			txtAccountLogin.setText(ACCOUNT_USERNAME);
			txtAccountLogin.setEchoChar((char) 0);
			txtAccountLogin.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);

			txtPasswordLogin.setText(PASSWORD_LABEL);
			txtPasswordLogin.setEchoChar((char) 0);
			txtPasswordLogin.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);
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
		txtAccountLogin.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{


			}

			@Override
			public void mousePressed(MouseEvent e)
			{

			}

			@Override
			public void mouseReleased(MouseEvent e)
			{

			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
			}

			@Override
			public void mouseExited(MouseEvent e)
			{

			}
		});

		add(btnAddAccount, c);
		c.gridy++;

		profilesPanel.setLayout(new GridBagLayout());
		add(profilesPanel, c);
		c.gridy = 0;
		c.insets = new Insets(0, 0, 5, 0);

		// addAccounts(config.profilesData());
	}

	private void redrawProfiles() throws InvalidKeySpecException, NoSuchAlgorithmException
	{
		profilesPanel.removeAll();
		c.gridy = 0;
		addAccounts(getProfileData());

		revalidate();
		repaint();
	}

	private void addAccount(String data)
	{
		ProfilePanel profile = new ProfilePanel(client, data, profilesConfig, this);
		c.gridy++;
		profilesPanel.add(profile, c);

		revalidate();
		repaint();
	}

	private void addAccounts(String data)
	{
	// log.info("Data: " + data);
		data = data.trim();
		if (!data.contains(":"))
		{
			return;
		}
		Arrays.stream(data.split("\\n")).forEach(this::addAccount);
	}

	private boolean addProfile(String data) throws InvalidKeySpecException, NoSuchAlgorithmException
	{
		return setProfileData(
			getProfileData() + data + "\n");
	}

	void removeProfile(String data) throws InvalidKeySpecException, NoSuchAlgorithmException
	{
		setProfileData(
			getProfileData().replaceAll(data + "\\n", ""));
		revalidate();
		repaint();

	}

	private void setSalt(byte[] bytes)
	{
		profilesConfig.salt(base64Encode(bytes));
	}

	private byte[] getSalt()
	{
		if (profilesConfig.salt().length() == 0)
		{
			return new byte[0];
		}
		return base64Decode(profilesConfig.salt());
	}

	private SecretKey getAesKey() throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		if (getSalt().length == 0)
		{
			byte[] b = new byte[16];
			SecureRandom.getInstanceStrong().nextBytes(b);
			setSalt(b);
		}
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec spec = new PBEKeySpec(txtDecryptPassword.getPassword(), getSalt(), iterations, 128);
		return factory.generateSecret(spec);
	}

	private String getProfileData() throws InvalidKeySpecException, NoSuchAlgorithmException
	{
		String tmp = profilesConfig.profilesData();
		if (tmp.startsWith("¬"))
		{
			if (txtDecryptPassword.getPassword().length == 0 || String.valueOf(txtDecryptPassword.getPassword()).equals(UNLOCK_PASSWORD))
			{
				showErrorMessage("Unable to load data", "Please enter a password!");
				return tmp;
			}
			tmp = tmp.substring(1);
			return decryptText(base64Decode(tmp), getAesKey());
		}
		return tmp;
	}

	private boolean setProfileData(String data) throws InvalidKeySpecException, NoSuchAlgorithmException
	{
		if (txtDecryptPassword.getPassword().length == 0 || String.valueOf(txtDecryptPassword.getPassword()).equals(UNLOCK_PASSWORD))
		{
			showErrorMessage("Unable to save data", "Please enter a password!");
			return false;
		}
		byte[] enc = encryptText(data, getAesKey());
		if (enc.length == 0)
		{
			return false;
		}
		String s = "¬" + base64Encode(enc);
		profilesConfig.profilesData(s);
		return true;
	}

	private byte[] base64Decode(String data)
	{
		return Base64.getDecoder().decode(data);
	}

	private String base64Encode(byte[] data)
	{
		return Base64.getEncoder().encodeToString(data);
	}

	/**
	 * Encrypts login info
	 *
	 * @param text text to encrypt
	 * @return encrypted string
	 */
	private static byte[] encryptText(String text, SecretKey aesKey)
	{
		try
		{
			Cipher cipher = Cipher.getInstance("AES");
			SecretKeySpec newKey = new SecretKeySpec(aesKey.getEncoded(), "AES");
			cipher.init(Cipher.ENCRYPT_MODE, newKey);
			return cipher.doFinal(text.getBytes());
		}
		catch (NoSuchAlgorithmException | IllegalBlockSizeException | InvalidKeyException | BadPaddingException | NoSuchPaddingException e)
		{
			e.printStackTrace();
		}
		return new byte[0];
	}

	private static String decryptText(byte[] enc, SecretKey aesKey)
	{
		try
		{
			Cipher cipher = Cipher.getInstance("AES");
			SecretKeySpec newKey = new SecretKeySpec(aesKey.getEncoded(), "AES");
			cipher.init(Cipher.DECRYPT_MODE, newKey);
			return new String(cipher.doFinal(enc));
		}
		catch (NoSuchAlgorithmException | IllegalBlockSizeException | InvalidKeyException | BadPaddingException | NoSuchPaddingException e)
		{
			e.printStackTrace();
		}
		return "";
	}

	private static void showErrorMessage(String title, String text)
	{
		SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null,
			text,
			title,
			JOptionPane.ERROR_MESSAGE));
	}

}
