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
package net.runelite.client.ui;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLiteProperties;
import org.pushingpixels.substance.internal.SubstanceSynapse;

@Slf4j
public class TitleToolbar extends JPanel
{
	private static final int TITLEBAR_SIZE = 23;
	private static final int ICON_SIZE = TITLEBAR_SIZE - 6;

	private final JPanel buttonPanel = new JPanel();

	TitleToolbar(BufferedImage icon, RuneLiteProperties properties)
	{
		setLayout(new BorderLayout(6, 0));
		buttonPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 1, 0));
		final JLabel iconLabel = new JLabel(new ImageIcon(icon.getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH)));
		final JLabel titleLabel = new JLabel(properties.getTitle());
		titleLabel.setFont(FontManager.getRunescapeFont().deriveFont(Font.BOLD, 16));

		add(iconLabel, BorderLayout.WEST);
		add(titleLabel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.EAST);

		try
		{
			BufferedImage discordIcon = ImageIO.read(ClientUI.class.getResourceAsStream("discord.png"));
			BufferedImage invertedIcon = ImageIO.read(ClientUI.class.getResourceAsStream("discord_inverted.png"));

			JButton discordButton = new JButton();
			discordButton.setToolTipText("Join Discord");
			discordButton.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					super.mouseClicked(e);
					try
					{
						Desktop.getDesktop().browse(new URL(properties.getDiscordInvite()).toURI());
					}
					catch (IOException | URISyntaxException ex)
					{
						log.warn("error opening browser", ex);
					}
				}
			});

			addButton(discordButton, discordIcon, invertedIcon);
		}
		catch (IOException ex)
		{
			log.warn("unable to load discord button", ex);
		}
	}

	public void addButton(JButton button, Image iconImage, Image invertedIconImage)
	{
		ImageIcon icon = new ImageIcon(iconImage.getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH));
		ImageIcon invertedIcon = new ImageIcon(invertedIconImage.getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH));

		button.setIcon(icon);
		button.setRolloverIcon(invertedIcon);
		button.putClientProperty(SubstanceSynapse.FLAT_LOOK, Boolean.TRUE);
		button.setFocusable(false);
		buttonPanel.add(button);
		buttonPanel.revalidate();
	}

	public void removeButton(JButton button)
	{
		buttonPanel.remove(button);
		buttonPanel.revalidate();
	}
}
