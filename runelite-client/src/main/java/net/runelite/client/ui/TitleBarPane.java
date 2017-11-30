/*
 * Copyright (c) 2017. l2-
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
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
package net.runelite.client.ui;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import lombok.extern.slf4j.Slf4j;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.internal.ui.SubstanceRootPaneUI;
import org.pushingpixels.substance.internal.utils.SubstanceTitlePane;

@Slf4j
public class TitleBarPane extends SubstanceTitlePane
{
	private static final String DISCORD_INVITE = "https://discord.gg/R4BQ8tU";

	private BufferedImage discordIcon;
	private BufferedImage invertedIcon;

	public TitleBarPane(JRootPane root, SubstanceRootPaneUI ui)
	{
		super(root, ui);

		try
		{
			discordIcon = ImageIO.read(ClientUI.class.getResourceAsStream("discord.png"));
			invertedIcon = ImageIO.read(ClientUI.class.getResourceAsStream("discord_inverted.png"));
		}
		catch (IOException ex)
		{
			log.warn("unable to load discord icons", ex);
		}
	}

	public void editTitleBar(JFrame frame)
	{
		if (discordIcon == null || invertedIcon == null)
		{
			return;
		}

		JComponent titleBar = SubstanceLookAndFeel.getTitlePaneComponent(frame);

		JButton discordButton = new JButton();
		int heigth = titleBar.getHeight() - 3;
		int width = heigth;
		int x = titleBar.getWidth() - 100;
		int y = 1;
		ImageIcon icon = new ImageIcon(discordIcon.getScaledInstance(width - 3, heigth - 3, Image.SCALE_SMOOTH));
		ImageIcon invIcon = new ImageIcon(invertedIcon.getScaledInstance(width - 3, heigth - 3, Image.SCALE_SMOOTH));

		discordButton.setIcon(icon);
		discordButton.setRolloverIcon(invIcon);
		discordButton.putClientProperty("substancelaf.componentFlat", Boolean.TRUE);
		discordButton.putClientProperty("substancelaf.internal.titlePane.extraComponentKind", ExtraComponentKind.TRAILING);
		discordButton.setFocusable(false);
		discordButton.setBounds(x, y, icon.getIconWidth() + 4, icon.getIconHeight() + 2);
		discordButton.setToolTipText("Join Discord");

		discordButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				super.mouseClicked(e);
				try
				{
					Desktop.getDesktop().browse(new URL(DISCORD_INVITE).toURI());
				}
				catch (IOException | URISyntaxException ex)
				{
					log.warn("error opening browser", ex);
				}
			}
		});

		titleBar.addComponentListener(new ComponentAdapter()
		{
			@Override
			public void componentResized(ComponentEvent e)
			{
				super.componentResized(e);
				discordButton.setBounds(titleBar.getWidth() - 100, y, discordButton.getWidth(), discordButton.getHeight());
			}
		});

		titleBar.add(discordButton);
	}
}
