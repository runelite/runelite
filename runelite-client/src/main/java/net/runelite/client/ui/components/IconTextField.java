/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Psikoi <Adam@sigterm.info>
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
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Document;
import net.runelite.client.ui.ColorScheme;

/**
 * This component is a JTextField with an icon on its left side.
 */
public class IconTextField extends JPanel
{
	private final JTextField textField;

	//to support gifs, the icon needs to be wrapped in a JLabel
	private final JLabel iconWrapperLabel;

	//the default background color, this needs to be stored for hover effects
	private Color backgroundColor = ColorScheme.DARKER_GRAY_COLOR;
	//the default hover background color, this needs to be stored for hover effects
	private Color hoverBackgroundColor;

	// the input can be blocked (no clicking, no editing, no hover effects)
	private boolean blocked;

	public IconTextField()
	{
		setLayout(new BorderLayout());

		this.iconWrapperLabel = new JLabel();
		this.iconWrapperLabel.setPreferredSize(new Dimension(30, 0));
		this.iconWrapperLabel.setVerticalAlignment(JLabel.CENTER);
		this.iconWrapperLabel.setHorizontalAlignment(JLabel.CENTER);

		this.textField = new JTextField();
		this.textField.setBorder(null);
		this.textField.setOpaque(false);

		add(iconWrapperLabel, BorderLayout.WEST);
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
					IconTextField.super.setBackground(hoverBackgroundColor);
				}
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				IconTextField.super.setBackground(backgroundColor);
			}
		});
	}

	public void addActionListener(ActionListener actionListener)
	{
		textField.addActionListener(actionListener);
	}

	public void setIcon(ImageIcon icon)
	{
		iconWrapperLabel.setIcon(icon);
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
	public void setBackground(Color color)
	{
		if (color == null)
		{
			return;
		}
		super.setBackground(color);
		this.backgroundColor = color;
	}

	public void addInputKeyListener(KeyListener l)
	{
		textField.addKeyListener(l);
	}

	public void removeInputKeyListener(KeyListener l)
	{
		textField.removeKeyListener(l);
	}

	public void setHoverBackgroundColor(Color hoverBackgroundColor)
	{
		if (hoverBackgroundColor == null)
		{
			return;
		}
		this.hoverBackgroundColor = hoverBackgroundColor;
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

	@Override
	public boolean requestFocusInWindow()
	{
		super.requestFocusInWindow();
		return textField.requestFocusInWindow(); 
	}

	public Document getDocument()
	{
		return textField.getDocument();
	}

}