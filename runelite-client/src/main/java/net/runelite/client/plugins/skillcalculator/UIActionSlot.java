/*
 * Copyright (c) 2018, Kruithne <kruithne@gmail.com>
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

package net.runelite.client.plugins.skillcalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.client.plugins.skillcalculator.beans.SkillDataEntry;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;

class UIActionSlot extends JPanel
{
	private static final Border GREEN_BORDER = new CompoundBorder(
		BorderFactory.createMatteBorder(0, 4, 0, 0, (ColorScheme.PROGRESS_COMPLETE_COLOR).darker()),
		BorderFactory.createEmptyBorder(7, 12, 7, 7));

	private static final Border RED_BORDER = new CompoundBorder(
		BorderFactory.createMatteBorder(0, 4, 0, 0, (ColorScheme.PROGRESS_ERROR_COLOR).darker()),
		BorderFactory.createEmptyBorder(7, 12, 7, 7));

	private static final Border ORANGE_BORDER = new CompoundBorder(
		BorderFactory.createMatteBorder(0, 4, 0, 0, (ColorScheme.PROGRESS_INPROGRESS_COLOR).darker()),
		BorderFactory.createEmptyBorder(7, 12, 7, 7));

	private static final Dimension ICON_SIZE = new Dimension(32, 32);

	@Getter(AccessLevel.PACKAGE)
	private final SkillDataEntry action;
	private final JShadowedLabel uiLabelActions;

	private final JPanel uiInfo;

	@Getter(AccessLevel.PACKAGE)
	private boolean isAvailable;

	@Getter(AccessLevel.PACKAGE)
	private boolean isSelected;

	@Getter(AccessLevel.PACKAGE)
	private boolean isOverlapping;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private double value = 0;

	UIActionSlot(SkillDataEntry action, JLabel uiIcon)
	{
		this.action = action;

		setLayout(new BorderLayout());
		setBorder(RED_BORDER);
		setBackground(ColorScheme.DARKER_GRAY_COLOR);

		MouseListener hoverListener = new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				if (!isSelected)
				{
					setBackground(ColorScheme.DARKER_GRAY_HOVER_COLOR);
				}
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				if (!isSelected)
				{
					updateBackground();
				}
			}
		};

		addMouseListener(hoverListener);
		uiIcon.setMinimumSize(ICON_SIZE);
		uiIcon.setMaximumSize(ICON_SIZE);
		uiIcon.setPreferredSize(ICON_SIZE);
		uiIcon.setHorizontalAlignment(JLabel.CENTER);

		uiInfo = new JPanel(new GridLayout(2, 1));
		uiInfo.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		uiInfo.setBorder(new EmptyBorder(0, 5, 0, 0));

		JShadowedLabel uiLabelName = new JShadowedLabel(action.getName());
		uiLabelName.setForeground(Color.WHITE);

		uiLabelActions = new JShadowedLabel("Unknown");
		uiLabelActions.setFont(FontManager.getRunescapeSmallFont());
		uiLabelActions.setForeground(ColorScheme.LIGHT_GRAY_COLOR);

		uiInfo.add(uiLabelName);
		uiInfo.add(uiLabelActions);

		add(uiIcon, BorderLayout.LINE_START);
		add(uiInfo, BorderLayout.CENTER);
	}

	void setSelected(boolean selected)
	{
		isSelected = selected;
		this.updateBackground();
	}

	void setAvailable(boolean available)
	{
		isAvailable = available;
		this.updateBackground();
	}

	void setOverlapping(boolean overlapping)
	{
		isOverlapping = overlapping;
		this.updateBackground();
	}

	void setText(String text)
	{
		uiLabelActions.setText(text);
	}

	private void updateBackground()
	{
		if (isAvailable)
		{
			this.setBorder(GREEN_BORDER);
		}
		else if (isOverlapping)
		{
			this.setBorder(ORANGE_BORDER);
		}
		else
		{
			this.setBorder(RED_BORDER);
		}

		setBackground(this.isSelected() ? ColorScheme.DARKER_GRAY_HOVER_COLOR.brighter() : ColorScheme.DARKER_GRAY_COLOR);
	}

	@Override
	public void setBackground(Color color)
	{
		super.setBackground(color);
		if (uiInfo != null)
		{
			uiInfo.setBackground(color);
		}
	}
}