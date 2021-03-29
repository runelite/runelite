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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.MouseDragEventForwarder;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.SwingUtil;
import net.runelite.discord.DiscordRPC;

class PartyRequestBox extends JPanel
{
	private static final ImageIcon CONFIRM_ICON = new ImageIcon(ImageUtil.loadImageResource(PartyPlugin.class, "confirm_icon.png"));
	private static final ImageIcon CONFIRM_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(ImageUtil.bufferedImageFromImage(CONFIRM_ICON.getImage()), 0.54f));
	private static final ImageIcon CANCEL_ICON = new ImageIcon(ImageUtil.loadImageResource(PartyPlugin.class, "cancel_icon.png"));
	private static final ImageIcon CANCEL_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(ImageUtil.bufferedImageFromImage(CANCEL_ICON.getImage()), 0.6f));

	PartyRequestBox(final PartyPlugin plugin, final JComponent panel, String userId, String userName)
	{
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(5, 0, 0, 0));

		/* The box's wrapping container */
		final JPanel container = new JPanel();
		container.setLayout(new BorderLayout());
		container.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		container.setBorder(new EmptyBorder(5, 5, 5, 5));

		JPanel namesPanel = new JPanel();
		namesPanel.setLayout(new DynamicGridLayout(2, 1));
		namesPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		namesPanel.setBorder(new EmptyBorder(2, 5, 2, 5));

		JShadowedLabel nameLabel = new JShadowedLabel();
		nameLabel.setFont(FontManager.getRunescapeSmallFont());
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setText(userName);

		JShadowedLabel messageLabel = new JShadowedLabel();
		messageLabel.setFont(FontManager.getRunescapeSmallFont());
		messageLabel.setForeground(Color.WHITE);
		messageLabel.setText("Wants to join your party!");

		namesPanel.add(nameLabel);
		namesPanel.add(messageLabel);

		JPanel actionsContainer = new JPanel(new GridLayout(1, 2, 8, 0));
		actionsContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		JButton confirmButton = new JButton(CONFIRM_ICON);
		SwingUtil.removeButtonDecorations(confirmButton);
		confirmButton.setToolTipText("Invite");
		confirmButton.setRolloverIcon(CONFIRM_HOVER_ICON);
		confirmButton.addActionListener(e -> plugin.replyToRequest(userId, DiscordRPC.DISCORD_REPLY_YES));
		confirmButton.setPreferredSize(new Dimension(18, 18));

		JButton cancelButton = new JButton(CANCEL_ICON);
		SwingUtil.removeButtonDecorations(cancelButton);
		cancelButton.setToolTipText("Reject");
		cancelButton.setRolloverIcon(CANCEL_HOVER_ICON);
		cancelButton.addActionListener(e -> plugin.replyToRequest(userId, DiscordRPC.DISCORD_REPLY_NO));
		cancelButton.setPreferredSize(new Dimension(18, 18));

		actionsContainer.add(confirmButton);
		actionsContainer.add(cancelButton);

		container.add(namesPanel, BorderLayout.WEST);
		container.add(actionsContainer, BorderLayout.EAST);

		// forward mouse drag events to parent panel for drag and drop reordering
		MouseDragEventForwarder mouseDragEventForwarder = new MouseDragEventForwarder(panel);
		container.addMouseListener(mouseDragEventForwarder);
		container.addMouseMotionListener(mouseDragEventForwarder);

		add(container, BorderLayout.NORTH);
	}
}
