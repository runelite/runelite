/*
 * Copyright (c) 2021, Jonathan Rousseau <https://github.com/JoRouss>
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
package net.runelite.client.plugins.party;

import com.google.inject.Inject;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.party.PartyService;
import net.runelite.client.plugins.party.data.PartyData;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.DragAndDropReorderPane;
import net.runelite.client.ui.components.PluginErrorPanel;

class PartyPanel extends PluginPanel
{
	private static final String BTN_CREATE_TEXT = "Create party";
	private static final String BTN_LEAVE_TEXT = "Leave";

	private final PartyPlugin plugin;
	private final PartyService party;
	private final PartyConfig config;

	private final Map<Long, PartyMemberBox> memberBoxes = new HashMap<>();

	private final JButton startButton = new JButton();
	private final JButton joinPartyButton = new JButton();
	private final JButton rejoinPartyButton = new JButton();
	private final JButton copyPartyIdButton = new JButton();

	private final PluginErrorPanel noPartyPanel = new PluginErrorPanel();
	private final PluginErrorPanel partyEmptyPanel = new PluginErrorPanel();
	private final JComponent memberBoxPanel = new DragAndDropReorderPane();

	@Inject
	PartyPanel(final ClientThread clientThread, final PartyPlugin plugin, final PartyConfig config, final PartyService party)
	{
		this.plugin = plugin;
		this.party = party;
		this.config = config;

		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setLayout(new BorderLayout());

		final JPanel layoutPanel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(layoutPanel, BoxLayout.Y_AXIS);
		layoutPanel.setLayout(boxLayout);
		add(layoutPanel, BorderLayout.NORTH);

		final JPanel topPanel = new JPanel();

		topPanel.setBorder(new EmptyBorder(0, 0, 4, 0));
		topPanel.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 2, 4, 2);

		c.gridx = 0;
		c.gridy = 0;
		topPanel.add(startButton, c);

		c.gridx = 1;
		c.gridy = 0;
		topPanel.add(joinPartyButton, c);

		c.gridx = 1;
		c.gridy = 0;
		topPanel.add(copyPartyIdButton, c);

		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		topPanel.add(rejoinPartyButton, c);

		layoutPanel.add(topPanel);
		layoutPanel.add(memberBoxPanel);

		startButton.setText(party.isInParty() ? BTN_LEAVE_TEXT : BTN_CREATE_TEXT);
		startButton.setFocusable(false);

		joinPartyButton.setText("Join party");
		joinPartyButton.setFocusable(false);

		rejoinPartyButton.setText("Join previous party");
		rejoinPartyButton.setFocusable(false);

		copyPartyIdButton.setText("Copy passphrase");
		copyPartyIdButton.setFocusable(false);

		startButton.addActionListener(e ->
		{
			if (party.isInParty())
			{
				// Leave party
				final int result = JOptionPane.showOptionDialog(startButton,
					"Are you sure you want to leave the party?",
					"Leave party?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
					null, new String[]{"Yes", "No"}, "No");

				if (result == JOptionPane.YES_OPTION)
				{
					plugin.leaveParty();
				}
			}
			else
			{
				// Create party
				clientThread.invokeLater(() -> party.changeParty(party.generatePassphrase()));
			}
		});

		joinPartyButton.addActionListener(e ->
		{
			if (!party.isInParty())
			{
				String s = (String) JOptionPane.showInputDialog(
					joinPartyButton,
					"Please enter the party passphrase:",
					"Party Passphrase",
					JOptionPane.PLAIN_MESSAGE,
					null,
					null,
					"");

				if (s == null)
				{
					return;
				}

				s = s.toLowerCase(Locale.US);

				for (int i = 0; i < s.length(); ++i)
				{
					char ch = s.charAt(i);
					if (!Character.isLetter(ch) && !Character.isDigit(ch) && ch != '-')
					{
						JOptionPane.showMessageDialog(joinPartyButton,
							"Party passphrase must be a combination of alphanumeric or hyphen characters.",
							"Invalid party passphrase",
							JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

				party.changeParty(s);
			}
		});

		rejoinPartyButton.addActionListener(e ->
		{
			if (!party.isInParty())
			{
				party.changeParty(config.previousPartyId());
			}
		});

		copyPartyIdButton.addActionListener(e ->
		{
			if (party.isInParty())
			{
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(new StringSelection(party.getPartyPassphrase()), null);
			}
		});

		noPartyPanel.setContent("Not in a party", "Create a party to begin.");

		updateParty();
	}

	void updateParty()
	{
		remove(noPartyPanel);
		remove(partyEmptyPanel);

		startButton.setText(party.isInParty() ? BTN_LEAVE_TEXT : BTN_CREATE_TEXT);
		joinPartyButton.setVisible(!party.isInParty());
		rejoinPartyButton.setVisible(!party.isInParty());
		copyPartyIdButton.setVisible(party.isInParty());

		if (!party.isInParty())
		{
			add(noPartyPanel);
		}
		else if (plugin.getPartyDataMap().size() <= 1)
		{
			partyEmptyPanel.setContent("Party created", "You can now invite friends!<br/>" +
					"Your party passphrase is: " + party.getPartyPassphrase() + ".");
			add(partyEmptyPanel);
		}
	}

	void addMember(PartyData partyData)
	{
		if (!memberBoxes.containsKey(partyData.getMemberId()))
		{
			PartyMemberBox partyMemberBox = new PartyMemberBox(config, memberBoxPanel, partyData, party);
			memberBoxes.put(partyData.getMemberId(), partyMemberBox);
			memberBoxPanel.add(partyMemberBox);
			memberBoxPanel.revalidate();
		}
		updateParty();
	}

	void removeAllMembers()
	{
		memberBoxes.forEach((key, value) -> memberBoxPanel.remove(value));
		memberBoxPanel.revalidate();
		memberBoxes.clear();
		updateParty();
	}

	void removeMember(long memberId)
	{
		final PartyMemberBox memberBox = memberBoxes.remove(memberId);

		if (memberBox != null)
		{
			memberBoxPanel.remove(memberBox);
			memberBoxPanel.revalidate();
		}

		updateParty();
	}

	void updateMember(long userId)
	{
		final PartyMemberBox memberBox = memberBoxes.get(userId);

		if (memberBox != null)
		{
			memberBox.update();
		}
	}

	void updateAll()
	{
		memberBoxes.forEach((key, value) -> value.update());
	}
}
