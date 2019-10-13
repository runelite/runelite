/*
 * Copyright (c) 2019, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.skillcalculator.banked.components;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.BooleanSupplier;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.client.plugins.skillcalculator.banked.BankedCalculator;
import net.runelite.client.plugins.skillcalculator.banked.beans.Activity;
import net.runelite.client.plugins.skillcalculator.banked.beans.BankedItem;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.util.AsyncBufferedImage;

@Getter(AccessLevel.PUBLIC)
public class GridItem extends JLabel
{
	private final static String IGNORE = "Ignore Item";
	private final static String INCLUDE = "Include Item";

	private static final Color UNSELECTED_BACKGROUND = ColorScheme.DARKER_GRAY_COLOR;
	private static final Color UNSELECTED_HOVER_BACKGROUND = ColorScheme.DARKER_GRAY_HOVER_COLOR;

	private static final Color SELECTED_BACKGROUND = new Color(0, 70, 0);
	private static final Color SELECTED_HOVER_BACKGROUND = new Color(0, 100, 0);

	private static final Color IGNORED_BACKGROUND = new Color(90, 0, 0);
	private static final Color IGNORED_HOVER_BACKGROUND = new Color(120, 0, 0);

	/* To be executed when this element is clicked */
	@Setter(AccessLevel.PUBLIC)
	private BooleanSupplier onSelectEvent;

	/* To be executed when this element is ignored */
	@Setter(AccessLevel.PUBLIC)
	private BooleanSupplier onIgnoreEvent;

	private final SelectionGrid parent;
	private final BankedItem bankedItem;
	private int amount;

	private boolean selected = false;
	private boolean ignored = false;

	private final JMenuItem IGNORE_OPTION = new JMenuItem(IGNORE);

	GridItem(final SelectionGrid parent, final BankedItem item, final AsyncBufferedImage icon, final int amount)
	{
		super("");

		this.parent = parent;
		this.bankedItem = item;

		this.setOpaque(true);
		this.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		this.setBorder(BorderFactory.createEmptyBorder(5, 0, 2, 0));

		this.setVerticalAlignment(SwingConstants.CENTER);
		this.setHorizontalAlignment(SwingConstants.CENTER);

		updateIcon(icon, amount);
		updateToolTip();

		this.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				if (mouseEvent.getButton() == MouseEvent.BUTTON1)
				{
					select();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				final GridItem item = (GridItem) e.getSource();
				item.setBackground(getHoverBackgroundColor());
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				final GridItem item = (GridItem) e.getSource();
				item.setBackground(getBackgroundColor());
			}
		});

		IGNORE_OPTION.addActionListener(e ->
		{
			// Update ignored flag now so event knows new state
			this.ignored = !this.ignored;

			if (onIgnoreEvent != null && !onIgnoreEvent.getAsBoolean())
			{
				// Reset state
				this.ignored = !this.ignored;
				return;
			}

			IGNORE_OPTION.setText(this.ignored ? INCLUDE : IGNORE);
			this.setBackground(getBackgroundColor());
		});

		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		popupMenu.add(IGNORE_OPTION);

		this.setComponentPopupMenu(popupMenu);
	}

	private Color getBackgroundColor()
	{
		return ignored ? IGNORED_BACKGROUND : (selected ? SELECTED_BACKGROUND : UNSELECTED_BACKGROUND);
	}

	private Color getHoverBackgroundColor()
	{
		return ignored ? IGNORED_HOVER_BACKGROUND : (selected ? SELECTED_HOVER_BACKGROUND : UNSELECTED_HOVER_BACKGROUND);
	}

	public void select()
	{
		if (onSelectEvent != null && !onSelectEvent.getAsBoolean())
		{
			return;
		}

		selected = true;
		setBackground(getBackgroundColor());
	}

	void unselect()
	{
		selected = false;
		setBackground(getBackgroundColor());
	}

	public void updateIcon(final AsyncBufferedImage icon, final int amount)
	{
		icon.addTo(this);
		this.amount = amount;
	}

	public void updateToolTip()
	{
		this.setToolTipText(buildToolTip());
	}

	private String buildToolTip()
	{
		String tip = "<html>" + bankedItem.getItem().getItemInfo().getName();

		final Activity a = bankedItem.getItem().getSelectedActivity();
		if (a != null)
		{
			final double xp = parent.getCalc().getItemXpRate(bankedItem);
			tip += "<br/>Activity: " + a.getName();
			tip += "<br/>Xp/Action: " + BankedCalculator.XP_FORMAT_COMMA.format(xp);
			tip += "<br/>Total Xp: " + BankedCalculator.XP_FORMAT_COMMA.format(xp * amount);
		}
		else
		{
			tip += "<br/>Outputs: " + bankedItem.getItem().getItemInfo().getName();
		}

		return tip + "</html>";
	}
}