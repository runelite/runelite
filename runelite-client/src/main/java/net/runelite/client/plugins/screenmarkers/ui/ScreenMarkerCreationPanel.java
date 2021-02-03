/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
package net.runelite.client.plugins.screenmarkers.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.runelite.client.plugins.screenmarkers.ScreenMarkerPlugin;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;
import net.runelite.client.util.ImageUtil;

public class ScreenMarkerCreationPanel extends JPanel
{
	private static final ImageIcon CONFIRM_ICON;
	private static final ImageIcon CONFIRM_HOVER_ICON;
	private static final ImageIcon CONFIRM_LOCKED_ICON;
	private static final ImageIcon CANCEL_ICON;
	private static final ImageIcon CANCEL_HOVER_ICON;

	private final JShadowedLabel instructionsLabel = new JShadowedLabel();
	private final JLabel confirmLabel = new JLabel();
	private boolean lockedConfirm = true;

	static
	{
		CONFIRM_ICON = new ImageIcon(ImageUtil.loadImageResource(ScreenMarkerPlugin.class, "confirm_icon.png"));
		CANCEL_ICON = new ImageIcon(ImageUtil.loadImageResource(ScreenMarkerPlugin.class, "cancel_icon.png"));

		final BufferedImage confirmIcon = ImageUtil.bufferedImageFromImage(CONFIRM_ICON.getImage());
		CONFIRM_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(confirmIcon, 0.54f));
		CONFIRM_LOCKED_ICON = new ImageIcon(ImageUtil.grayscaleImage(confirmIcon));
		CANCEL_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(ImageUtil.bufferedImageFromImage(CANCEL_ICON.getImage()), 0.6f));
	}

	ScreenMarkerCreationPanel(ScreenMarkerPlugin plugin)
	{
		setBackground(ColorScheme.DARKER_GRAY_COLOR);
		setBorder(new EmptyBorder(8, 8, 8, 8));
		setLayout(new BorderLayout());

		instructionsLabel.setFont(FontManager.getRunescapeSmallFont());
		instructionsLabel.setForeground(Color.WHITE);

		JPanel actionsContainer = new JPanel(new GridLayout(1, 2, 8, 0));
		actionsContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		confirmLabel.setIcon(CONFIRM_LOCKED_ICON);
		confirmLabel.setToolTipText("Confirm and save");
		confirmLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				/* If the confirm button is not locked */
				if (!lockedConfirm)
				{
					plugin.finishCreation(false);
				}
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				confirmLabel.setIcon(lockedConfirm ? CONFIRM_LOCKED_ICON : CONFIRM_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				confirmLabel.setIcon(lockedConfirm ? CONFIRM_LOCKED_ICON : CONFIRM_ICON);
			}
		});

		JLabel cancelLabel = new JLabel(CANCEL_ICON);
		cancelLabel.setToolTipText("Cancel");
		cancelLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				plugin.finishCreation(true);
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				cancelLabel.setIcon(CANCEL_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				cancelLabel.setIcon(CANCEL_ICON);
			}
		});

		actionsContainer.add(confirmLabel);
		actionsContainer.add(cancelLabel);

		add(instructionsLabel, BorderLayout.CENTER);
		add(actionsContainer, BorderLayout.EAST);
	}

	/* Unlocks the confirm button */
	public void unlockConfirm()
	{
		this.confirmLabel.setIcon(CONFIRM_ICON);
		this.lockedConfirm = false;
		instructionsLabel.setText("Confirm or cancel to finish.");
	}

	/* Locks the confirm button */
	public void lockConfirm()
	{
		this.confirmLabel.setIcon(CONFIRM_LOCKED_ICON);
		this.lockedConfirm = true;
		instructionsLabel.setText("Drag in-game to draw");
	}
}
