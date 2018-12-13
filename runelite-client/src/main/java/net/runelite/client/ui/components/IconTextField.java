/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.function.Consumer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;

/**
 * This component is a FlatTextField with an icon on its left side, and a clear button (×) on its right side.
 */
public class IconTextField extends JPanel
{
	// To support gifs, the icon needs to be wrapped in a JLabel
	private final JLabel iconWrapperLabel;

	private final FlatTextField textField;

	private final JButton clearButton;

	public IconTextField()
	{
		setLayout(new BorderLayout());

		iconWrapperLabel = new JLabel();
		iconWrapperLabel.setPreferredSize(new Dimension(30, 0));
		iconWrapperLabel.setVerticalAlignment(JLabel.CENTER);
		iconWrapperLabel.setHorizontalAlignment(JLabel.CENTER);

		textField = new FlatTextField();
		textField.setBorder(null);

		final JTextField innerTxt = textField.getTextField();
		innerTxt.removeMouseListener(innerTxt.getMouseListeners()[innerTxt.getMouseListeners().length - 1]);

		final MouseListener hoverEffect = new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				if (textField.isBlocked())
				{
					return;
				}

				final Color hoverColor = textField.getHoverBackgroundColor();

				if (hoverColor != null)
				{
					IconTextField.super.setBackground(hoverColor);
					textField.setBackground(hoverColor, false);
				}

			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				setBackground(textField.getBackgroundColor());
			}
		};

		textField.addMouseListener(hoverEffect);
		innerTxt.addMouseListener(hoverEffect);

		clearButton = new JButton("×");
		clearButton.setPreferredSize(new Dimension(30, 0));
		clearButton.setFont(FontManager.getRunescapeBoldFont());
		clearButton.setForeground(ColorScheme.PROGRESS_ERROR_COLOR);
		clearButton.setBorder(null);
		clearButton.setBorderPainted(false);
		clearButton.setContentAreaFilled(false);
		clearButton.setVisible(false);

		// ActionListener for keyboard use (via Tab -> Space)
		clearButton.addActionListener(evt -> setText(null));

		// MouseListener for hover and click events
		clearButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				setText(null);
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				clearButton.setForeground(Color.PINK);
				textField.dispatchEvent(mouseEvent);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				clearButton.setForeground(ColorScheme.PROGRESS_ERROR_COLOR);
				textField.dispatchEvent(mouseEvent);
			}
		});

		// Show the clear button when text is present, and hide again when empty
		textField.getTextField().getDocument().addDocumentListener(new DocumentListener()
		{
			@Override
			public void insertUpdate(DocumentEvent e)
			{
				SwingUtilities.invokeLater(() -> clearButton.setVisible(true));
			}

			@Override
			public void removeUpdate(DocumentEvent e)
			{
				SwingUtilities.invokeLater(() -> clearButton.setVisible(!getText().isEmpty()));
			}

			@Override
			public void changedUpdate(DocumentEvent e)
			{
			}
		});

		add(iconWrapperLabel, BorderLayout.WEST);
		add(textField, BorderLayout.CENTER);
		add(clearButton, BorderLayout.EAST);
	}

	public void addActionListener(ActionListener actionListener)
	{
		textField.addActionListener(actionListener);
	}

	public void setIcon(Icon icon)
	{
		final ImageIcon imageIcon = new ImageIcon(this.getClass().getResource(icon.getFile()));
		iconWrapperLabel.setIcon(imageIcon);
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

		if (textField != null)
		{
			textField.setBackground(color);
		}
	}

	public void setHoverBackgroundColor(Color hoverBackgroundColor)
	{
		if (hoverBackgroundColor == null)
		{
			return;
		}

		this.textField.setHoverBackgroundColor(hoverBackgroundColor);
	}

	@Override
	public void addKeyListener(KeyListener keyListener)
	{
		textField.addKeyListener(keyListener);
	}

	public void addKeyListener(Consumer<KeyEvent> keyEventConsumer)
	{
		addKeyListener(new net.runelite.client.input.KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
				keyEventConsumer.accept(e);
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
				keyEventConsumer.accept(e);
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
				keyEventConsumer.accept(e);
			}
		});
	}

	@Override
	public void removeKeyListener(KeyListener keyListener)
	{
		textField.removeKeyListener(keyListener);
	}

	public void setEditable(boolean editable)
	{
		textField.setEditable(editable);
		if (!editable)
		{
			super.setBackground(textField.getBackgroundColor());
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

	@Getter
	@RequiredArgsConstructor
	public enum Icon
	{
		SEARCH("search.png"),
		LOADING("loading_spinner.gif"),
		LOADING_DARKER("loading_spinner_darker.gif"),
		ERROR("error.png");

		private final String file;
	}

}
