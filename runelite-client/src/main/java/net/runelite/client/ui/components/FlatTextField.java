/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 *  Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.ui.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Document;
import lombok.Getter;
import net.runelite.client.ui.ColorScheme;

/**
 * This component is a JTextField with a flat design look.
 */
public class FlatTextField extends JPanel
{
	@Getter
	private final JTextField textField;

	//the default background color, this needs to be stored for hover effects
	@Getter
	private Color backgroundColor = ColorScheme.DARKER_GRAY_COLOR;

	//the default hover background color, this needs to be stored for hover effects
	@Getter
	private Color hoverBackgroundColor;

	// the input can be blocked (no clicking, no editing, no hover effects)
	@Getter
	private boolean blocked;

	public FlatTextField()
	{
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(0, 10, 0, 0));

		this.textField = new JTextField();
		this.textField.setBorder(null);
		this.textField.setOpaque(false);
		this.textField.setSelectedTextColor(Color.WHITE);
		this.textField.setSelectionColor(ColorScheme.BRAND_ORANGE_TRANSPARENT);

		add(textField, BorderLayout.CENTER);

		textField.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				if (blocked)
				{
					return;
				}

				if (hoverBackgroundColor != null)
				{
					setBackground(hoverBackgroundColor, false);
				}
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				setBackground(backgroundColor);
			}
		});
	}

	public void addActionListener(ActionListener actionListener)
	{
		textField.addActionListener(actionListener);
	}

	public String getText()
	{
		return textField.getText();
	}

	public void setText(String text)
	{
		textField.setText(text);
	}

	@Override
	public void addKeyListener(KeyListener keyListener)
	{
		textField.addKeyListener(keyListener);
	}

	@Override
	public void removeKeyListener(KeyListener keyListener)
	{
		textField.removeKeyListener(keyListener);
	}

	@Override
	public void setBackground(Color color)
	{
		setBackground(color, true);
	}

	public void setBackground(Color color, boolean saveColor)
	{
		if (color == null)
		{
			return;
		}

		super.setBackground(color);

		if (saveColor)
		{
			this.backgroundColor = color;
		}
	}

	public void setHoverBackgroundColor(Color color)
	{
		if (color == null)
		{
			return;
		}

		this.hoverBackgroundColor = color;
	}

	public void setEditable(boolean editable)
	{
		this.blocked = !editable;
		textField.setEditable(editable);
		textField.setFocusable(editable);
		if (!editable)
		{
			super.setBackground(backgroundColor);
		}
	}

	public Document getDocument()
	{
		return textField.getDocument();
	}

}