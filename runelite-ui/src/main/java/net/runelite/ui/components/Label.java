/*
 * Copyright (c) 2017, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.ui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import lombok.extern.slf4j.Slf4j;
import net.runelite.ui.util.FontManager;

@Slf4j
public class Label extends Component {
	private Color color = Color.WHITE;
	private Font font;
	private final Dimension prefSize = new Dimension();
	private final StringBuilder text = new StringBuilder();
	private boolean prefSizeInvalid = true;

	public Label(CharSequence text)
	{
		this(text, Color.WHITE);
	}

	public Label (CharSequence text, Font font) {
		this(text, font, Color.WHITE);
	}

	public Label (CharSequence text, Color color) {
		this(text, FontManager.getDefaultFont(), color);
	}

	public Label (CharSequence text, Font font, Color color) {
		setFont(font);
		this.color = color;
		if (text != null) this.text.append(text);
		if (text != null && text.length() > 0)
		{
			setWidth(getPrefWidth());
			setHeight(getPrefHeight());
		}
	}

	public void setFont (Font font) {
		this.font = font;
		invalidateHierarchy();
	}

	public void setText (CharSequence newText) {
		if (newText == null) newText = "";
		if (newText instanceof StringBuilder)
		{
			if (text.toString().equals(newText)) return;
			text.setLength(0);
			text.append(newText);
		}
		else
		{
			if (textEquals(newText)) return;
			text.setLength(0);
			text.append(newText);
		}

		invalidateHierarchy();
	}

	public boolean textEquals (CharSequence other) {
		int length = text.length();
		int[] chars = text.chars().toArray();
		if (length != other.length()) return false;
		for (int i = 0; i < length; i++)
			if (chars[i] != other.charAt(i)) return false;
		return true;
	}

	public StringBuilder getText () {
		return text;
	}

	@Override
	public void invalidate () {
		super.invalidate();
		prefSizeInvalid = true;
	}

	private void computePrefSize () {
		prefSizeInvalid = false;
		Dimension textDimension = FontManager.getTextDimension(font, text.toString());
		prefSize.setSize(textDimension.width, textDimension.height);
	}

	@Override
	public void draw (Graphics2D graphics) {
		super.draw(graphics);
		final String text = this.text.toString();
		final Color oldColor = graphics.getColor();
		final Font oldFont = graphics.getFont();

		graphics.setFont(font);

		// Draw shadow
		graphics.setColor(Color.BLACK);
		graphics.drawString(text, getX() + 1, getY() + 1);

		// Draw actual text
		graphics.setColor(color);
		graphics.drawString(text, getX(), getY());

		graphics.setColor(oldColor);
		graphics.setFont(oldFont);
	}

	@Override
	public int getPrefWidth () {
		if (prefSizeInvalid) computePrefSize();
		return prefSize.width;
	}

	@Override
	public int getPrefHeight () {
		if (prefSizeInvalid) computePrefSize();
		return prefSize.height;
	}

	@Override
	public String toString () {
		return super.toString() + ": " + text;
	}
}
