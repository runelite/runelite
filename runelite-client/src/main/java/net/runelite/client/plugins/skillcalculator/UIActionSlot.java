/*
 * Copyright (c) 2018, Kruithne <kruithne@gmail.com>
<<<<<<< HEAD
=======
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
>>>>>>> upstream/master
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
<<<<<<< HEAD
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.runelite.client.plugins.skillcalculator.beans.SkillDataEntry;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.JShadowedLabel;

class UIActionSlot extends JPanel
{
	SkillDataEntry action;
	private JShadowedLabel uiLabelActions;
	private static final Dimension ICON_SIZE = new Dimension(32, 32);

	boolean isAvailable = false;
	boolean isSelected = false;

	double value = 0;
=======
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
<<<<<<< HEAD
	private int value = 0;
>>>>>>> upstream/master
=======
	private double value = 0;
>>>>>>> upstream/master

	UIActionSlot(SkillDataEntry action, JLabel uiIcon)
	{
		this.action = action;

<<<<<<< HEAD
		BorderLayout layout = new BorderLayout();
		layout.setHgap(8);
		setLayout(layout);

		setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

		JLabel uiIcon = new JLabel();

		if (action.icon != null)
			SkillCalculator.itemManager.getImage(action.icon).addTo(uiIcon);
		else if (action.sprite != null)
			SkillCalculator.spriteManager.addSpriteTo(uiIcon, action.sprite, 0);
=======
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
<<<<<<< HEAD

		JLabel uiIcon = new JLabel();

		if (action.getIcon() != null)
			SkillCalculator.itemManager.getImage(action.getIcon()).addTo(uiIcon);
		else if (action.getSprite() != null)
			SkillCalculator.spriteManager.addSpriteTo(uiIcon, action.getSprite(), 0);
>>>>>>> upstream/master

=======
>>>>>>> upstream/master
		uiIcon.setMinimumSize(ICON_SIZE);
		uiIcon.setMaximumSize(ICON_SIZE);
		uiIcon.setPreferredSize(ICON_SIZE);
		uiIcon.setHorizontalAlignment(JLabel.CENTER);
<<<<<<< HEAD
		add(uiIcon, BorderLayout.LINE_START);

		JPanel uiInfo = new JPanel(new GridLayout(2, 1));
		uiInfo.setOpaque(false);

		JShadowedLabel uiLabelName = new JShadowedLabel(action.name);
		uiInfo.add(uiLabelName);

		uiLabelActions = new JShadowedLabel("Unknown");
		uiLabelActions.setFont(FontManager.getRunescapeSmallFont());
		uiInfo.add(uiLabelActions);

=======

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
>>>>>>> upstream/master
		add(uiInfo, BorderLayout.CENTER);
	}

	void setSelected(boolean selected)
	{
		isSelected = selected;
<<<<<<< HEAD
		updateBackground();
=======
		this.updateBackground();
>>>>>>> upstream/master
	}

	void setAvailable(boolean available)
	{
		isAvailable = available;
<<<<<<< HEAD
		updateBackground();
=======
		this.updateBackground();
	}

	void setOverlapping(boolean overlapping)
	{
		isOverlapping = overlapping;
		this.updateBackground();
>>>>>>> upstream/master
	}

	void setText(String text)
	{
		uiLabelActions.setText(text);
	}

	private void updateBackground()
	{
<<<<<<< HEAD
		if (isSelected)
			this.setBackground(isAvailable ? Color.GREEN : Color.RED);
		else
			this.setBackground(isAvailable ? Color.GREEN.darker() : Color.RED.darker());
=======
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
>>>>>>> upstream/master
	}
}