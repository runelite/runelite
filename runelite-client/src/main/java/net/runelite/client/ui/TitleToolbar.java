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

import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.LayoutManager2;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLiteProperties;
import org.pushingpixels.substance.internal.SubstanceSynapse;

@Slf4j
public class TitleToolbar extends JPanel
{
	private static final int TITLEBAR_SIZE = 23;
	private static final int ITEM_PADDING = 4;
	private static final int ICON_SIZE = TITLEBAR_SIZE - 6;

	private static BufferedImage sideBarIcon;
	private static BufferedImage invertedIcon;

	@Getter
	private JButton sideBarButton;

	public TitleToolbar(RuneLiteProperties properties)
	{

		// The only other layout manager that would manage it's preferred size without padding
		// was the GroupLayout manager, which doesn't work with dynamic layouts like this one.
		// Primarily, it would not remove components unless it was immediately repainted.
		setLayout(new LayoutManager2()
		{
			@Override
			public void addLayoutComponent(String name, Component comp)
			{
			}

			@Override
			public void addLayoutComponent(Component comp, Object constraints)
			{
			}

			@Override
			public void removeLayoutComponent(Component comp)
			{
			}

			@Override
			public Dimension preferredLayoutSize(Container parent)
			{
				int width = parent.getComponentCount() * (TITLEBAR_SIZE + ITEM_PADDING);
				return new Dimension(width, TITLEBAR_SIZE);
			}

			@Override
			public Dimension minimumLayoutSize(Container parent)
			{
				return preferredLayoutSize(parent);
			}

			@Override
			public Dimension maximumLayoutSize(Container parent)
			{
				return preferredLayoutSize(parent);
			}

			@Override
			public float getLayoutAlignmentX(Container target)
			{
				return 0;
			}

			@Override
			public float getLayoutAlignmentY(Container target)
			{
				return 0;
			}

			@Override
			public void invalidateLayout(Container target)
			{
			}

			@Override
			public void layoutContainer(Container parent)
			{
				int x = 0;
				//place the icons from right to left
				for (int i = parent.getComponents().length - 1; i >= 0; i--)
				{
					Component c = parent.getComponents()[i];
					x += ITEM_PADDING;
					int height = c.getPreferredSize().height;
					if (height > TITLEBAR_SIZE)
					{
						height = TITLEBAR_SIZE;
					}
					c.setBounds(x, (TITLEBAR_SIZE - height) / 2, TITLEBAR_SIZE, height);
					x += TITLEBAR_SIZE;
				}
			}
		});

		try
		{
			sideBarIcon = ImageIO.read(ClientUI.class.getResourceAsStream("arrow.png"));
			invertedIcon = ImageIO.read(ClientUI.class.getResourceAsStream("arrow_inverted.png"));

			sideBarButton = new JButton();
			sideBarButton.setName("sideBarButton");
			sideBarButton.setToolTipText("Hide SideBar");

			addButton(sideBarButton, sideBarIcon, invertedIcon);
		}
		catch (IOException ex)
		{
			log.warn("unable to load sideBar button", ex);
		}

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

		add(button);
		revalidate();
	}

	@Override
	public void remove(Component c)
	{
		super.remove(c);
		revalidate();
	}

	public static BufferedImage horizontalFlipImage(BufferedImage image)
	{
		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-image.getWidth(null), 0);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		image = op.filter(image, null);
		return image;
	}

	void flipArrowIcon()
	{
		SwingUtilities.invokeLater(() ->
		{
			sideBarIcon = horizontalFlipImage(sideBarIcon);
			invertedIcon = horizontalFlipImage(invertedIcon);
			sideBarButton.setIcon(new ImageIcon(sideBarIcon.getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH)));
			sideBarButton.setRolloverIcon(new ImageIcon(invertedIcon.getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH)));
		});
	}
}
