/*
 * Copyright (c) 2018, Kamiel, <https://github.com/Kamielvf>
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * Copyright (c) 2024, Pine <https://github.com/tylerwgrass>
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
package net.runelite.client.plugins.groundmarkers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.util.ImageUtil;

public class GroundMarkerGroupPanel extends JPanel
{
	private static final ImageIcon VISIBLE_ICON;
	private static final ImageIcon VISIBLE_HOVER_ICON;
	private static final ImageIcon INVISIBLE_ICON;
	private static final ImageIcon INVISIBLE_HOVER_ICON;
	private static final ImageIcon DELETE_ICON;
	private static final ImageIcon DELETE_HOVER_ICON;
	private static final ImageIcon EXPORT_ICON;
	private static final ImageIcon EXPORT_HOVER_ICON;

	static
	{
		final BufferedImage visibleImg = ImageUtil.loadImageResource(GroundMarkerPlugin.class, "visible_icon.png");
		VISIBLE_ICON = new ImageIcon(visibleImg);
		VISIBLE_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(visibleImg, -100));

		final BufferedImage invisibleImg = ImageUtil.loadImageResource(GroundMarkerPlugin.class, "invisible_icon.png");
		INVISIBLE_ICON = new ImageIcon(invisibleImg);
		INVISIBLE_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(invisibleImg, -100));

		final BufferedImage deleteImg = ImageUtil.loadImageResource(GroundMarkerPlugin.class, "delete_icon.png");
		DELETE_ICON = new ImageIcon(deleteImg);
		DELETE_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(deleteImg, -100));

		final BufferedImage exportImg = ImageUtil.loadImageResource(GroundMarkerPlugin.class, "export_icon.png");
		EXPORT_ICON = new ImageIcon(exportImg);
		EXPORT_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(exportImg, -100));
	}

	private final GroundMarkerPlugin plugin;
	private final String groupName;

	private boolean isVisible;

	GroundMarkerGroupPanel(GroundMarkerPlugin plugin, GroundMarkerGroup group)
	{
		this.plugin = plugin;
		this.groupName = group.getName();
		this.isVisible = group.isVisible();

		setLayout(new BorderLayout(5, 5));
		setBackground(ColorScheme.DARKER_GRAY_COLOR);

		JPanel container = new JPanel(new BorderLayout(5, 5));
		container.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		JPanel nameWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameWrapper.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		JLabel nameLabel = new JLabel(group.getName());
		nameLabel.setForeground(Color.WHITE);
		nameWrapper.add(nameLabel);

		JPanel actionsWrapper = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		actionsWrapper.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		actionsWrapper.add(buildVisibilityLabel());
		actionsWrapper.add(buildExportLabel());
		actionsWrapper.add(buildDeleteLabel());

		container.add(nameWrapper, BorderLayout.WEST);
		container.add(actionsWrapper, BorderLayout.EAST);
		add(container);
	}

	JLabel buildVisibilityLabel()
	{
		JLabel visibilityLabel = new JLabel();
		visibilityLabel.setIcon(isVisible ? VISIBLE_ICON : INVISIBLE_ICON);
		visibilityLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				isVisible = !isVisible;
				visibilityLabel.setToolTipText(isVisible ? "Hide group" : "Show group");
				visibilityLabel.setIcon(isVisible ? VISIBLE_HOVER_ICON : INVISIBLE_HOVER_ICON);
				plugin.setGroupVisibility(groupName, isVisible);
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				visibilityLabel.setIcon(isVisible ? VISIBLE_HOVER_ICON : INVISIBLE_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				visibilityLabel.setIcon(isVisible ? VISIBLE_ICON : INVISIBLE_ICON);
			}
		});

		return visibilityLabel;
	}

	JLabel buildExportLabel()
	{
		JLabel exportLabel = new JLabel();
		exportLabel.setIcon(EXPORT_ICON);
		exportLabel.setToolTipText("Export group");
		exportLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				plugin.exportGroup(groupName);
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				exportLabel.setIcon(EXPORT_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				exportLabel.setIcon(EXPORT_ICON);
			}
		});

		return exportLabel;
	}

	JLabel buildDeleteLabel()
	{
		JLabel deleteLabel = new JLabel();
		deleteLabel.setIcon(DELETE_ICON);
		deleteLabel.setToolTipText("Delete group");
		deleteLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				int confirm = JOptionPane.showConfirmDialog(GroundMarkerGroupPanel.this,
					"Are you sure you want to permanently delete this marker group?",
					"Warning", JOptionPane.OK_CANCEL_OPTION);

				if (confirm == 0)
				{
					plugin.deleteGroup(groupName);
				}
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				deleteLabel.setIcon(DELETE_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				deleteLabel.setIcon(DELETE_ICON);
			}
		});

		return deleteLabel;
	}
}
