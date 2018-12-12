/*
 * Copyright (c) 2018, Ron Young <https://github.com/raiyni>
 * All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
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

package net.runelite.client.plugins.config;

import com.google.common.base.Strings;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.ui.components.IconButton;
import net.runelite.client.util.ImageUtil;

class ProfilePanel extends JPanel
{
	private static final ImageIcon ADD_ICON;
	private static final ImageIcon REMOVE_ICON;

	private final IconButton addButton = new IconButton(ADD_ICON);
	private final IconButton removeButton = new IconButton(REMOVE_ICON);
	private final ConfigManager configManager;

	// Sort options alphabetically with default at top
	private final JComboBox profileBox = new JComboBox()
	{
		@Override
		public void addItem(Object obj)
		{
			int count = getItemCount();
			String toAdd = ((String) obj).toLowerCase();

			List<String> items = new ArrayList<String>();
			for (int i = 0; i < count; i++)
			{
				items.add((String) getItemAt(i));
			}

			if (items.size() == 0)
			{
				super.addItem(toAdd);
				return;
			}

			if (toAdd.compareTo(items.get(0)) <= 0)
			{
				insertItemAt(toAdd, 0);
				return;
			}

			int lastIndexOfHigherNum = 0;
			for (int i = 0; i < count; i++)
			{
				if (toAdd.compareTo(items.get(i)) > 0)
				{
					lastIndexOfHigherNum = i;
				}
			}
			insertItemAt(toAdd, lastIndexOfHigherNum + 1);
		}
	};

	private boolean shouldUpdate = true;

	static
	{
		BufferedImage addIcon = ImageUtil.getResourceStreamFromClass(ConfigPanel.class, "add_profile.png");
		BufferedImage removeIcon = ImageUtil.getResourceStreamFromClass(ConfigPanel.class, "remove_profile.png");
		ADD_ICON = new ImageIcon(addIcon);
		REMOVE_ICON = new ImageIcon(removeIcon);
	}

	ProfilePanel(final ConfigManager configManager)
	{
		this.configManager = configManager;

		JLabel label = new JLabel("Profile:");

		profileBox.setFocusable(false);
		profileBox.addItem("");
		profileBox.addActionListener((event) ->
		{
			if (profileBox.getSelectedItem() != null && shouldUpdate)
			{
				this.configManager.setProfile((String) profileBox.getSelectedItem());
			}
		});

		profileBox.setPrototypeDisplayValue("XXXXXXXX");

		addButton.setPreferredSize(new Dimension(18, 18));
		addButton.setToolTipText("New Profile");
		addButton.addActionListener((event) ->
		{
			String text = (String) JOptionPane.showInputDialog(this, "Profile name",
				"New profile", JOptionPane.PLAIN_MESSAGE, null, null, "");

			if (!Strings.isNullOrEmpty(text))
			{
				String profile = text.toLowerCase().replaceAll("[/,]", "");
				int maxLength = Math.min(profile.length(), 64);
				shouldUpdate = false;
				configManager.addProfile(profile.substring(0, maxLength));
				shouldUpdate = true;

			}
		});

		removeButton.setPreferredSize(new Dimension(18, 18));
		removeButton.setToolTipText("Remove Profile");
		removeButton.addActionListener((event) ->
		{
			String profile = configManager.getProfile();
			if (!Strings.isNullOrEmpty(profile))
			{
				int yes = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the profile: \n " + profile, "Confirm", JOptionPane.YES_NO_OPTION);
				if (yes == JOptionPane.YES_OPTION)
				{
					shouldUpdate = false;
					this.configManager.removeProfile(profile);
					refreshProfiles();
					shouldUpdate = true;
					profileBox.setSelectedIndex(0);
				}
			}
		});

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0, 4, 0, 4);

		c.gridx = 0;
		add(removeButton, c);

		c.gridx++;
		add(addButton, c);

		c.gridx++;
		c.insets = new Insets(0, 4, 0, 0);
		add(label, c);

		c.gridx++;
		c.weightx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;

		add(profileBox, c);

		for (String profile : configManager.getProfiles())
		{
			profileBox.addItem(profile);
			if (profile.equals(configManager.getProfile()))
			{
				profileBox.setSelectedItem(profile);
			}
		}
	}

	void refreshProfiles()
	{
		shouldUpdate = false;

		String currentProfile = (String) profileBox.getSelectedItem();
		if (currentProfile == null)
		{
			currentProfile = "";
		}

		profileBox.setSelectedIndex(0);
		profileBox.removeAllItems();
		profileBox.addItem("");

		for (String profile : configManager.getProfiles())
		{
			profileBox.addItem(profile);
		}

		int idx = 0;
		for (int i = 0; i < profileBox.getItemCount(); i++)
		{
			if (currentProfile.equals(profileBox.getItemAt(i)))
			{
				idx = i;
				break;
			}
		}

		profileBox.setSelectedIndex(idx);
		shouldUpdate = true;
	}
}
