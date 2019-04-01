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
package net.runelite.client.game.chatbox;

import com.google.inject.Inject;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.FontID;
import net.runelite.api.widgets.WidgetType;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetPositionMode;
import net.runelite.api.widgets.WidgetSizeMode;
import net.runelite.api.widgets.WidgetTextAlignment;
import net.runelite.client.input.KeyListener;

@Slf4j
public class ChatboxTextMenuInput extends ChatboxInput implements KeyListener
{
	@Data
	@AllArgsConstructor
	private static final class Entry
	{
		private String text;
		private Runnable callback;
	}

	private final ChatboxPanelManager chatboxPanelManager;

	@Getter
	private String title;

	@Getter
	private List<Entry> options = new ArrayList<>();

	@Getter
	private Runnable onClose;

	@Inject
	protected ChatboxTextMenuInput(ChatboxPanelManager chatboxPanelManager)
	{
		this.chatboxPanelManager = chatboxPanelManager;
	}

	public ChatboxTextMenuInput title(String title)
	{
		this.title = title;
		return this;
	}

	public ChatboxTextMenuInput option(String text, Runnable callback)
	{
		options.add(new Entry(text, callback));
		return this;
	}

	public ChatboxTextMenuInput onClose(Runnable onClose)
	{
		this.onClose = onClose;
		return this;
	}

	public ChatboxTextMenuInput build()
	{
		if (title == null)
		{
			throw new IllegalStateException("Title must be set");
		}

		if (options.size() < 1)
		{
			throw new IllegalStateException("You must have atleast 1 option");
		}

		chatboxPanelManager.openInput(this);
		return this;
	}

	@Override
	protected void open()
	{
		Widget container = chatboxPanelManager.getContainerWidget();

		Widget prompt = container.createChild(-1, WidgetType.TEXT);
		prompt.setText(title);
		prompt.setTextColor(0x800000);
		prompt.setFontId(FontID.QUILL_8);
		prompt.setXPositionMode(WidgetPositionMode.ABSOLUTE_CENTER);
		prompt.setOriginalX(0);
		prompt.setYPositionMode(WidgetPositionMode.ABSOLUTE_TOP);
		prompt.setOriginalY(8);
		prompt.setOriginalHeight(24);
		prompt.setXTextAlignment(WidgetTextAlignment.CENTER);
		prompt.setYTextAlignment(WidgetTextAlignment.CENTER);
		prompt.setWidthMode(WidgetSizeMode.MINUS);
		prompt.revalidate();

		int y = prompt.getRelativeX() + prompt.getHeight() + 6;
		int height = container.getHeight() - y - 8;
		int step = height / options.size();
		int maxStep = options.size() >= 3 ? 25 : 30;
		if (step > maxStep)
		{
			int ds = step - maxStep;
			step = maxStep;
			y += (ds * options.size()) / 2;
		}

		for (Entry option : options)
		{
			Widget optWidget = container.createChild(-1, WidgetType.TEXT);
			optWidget.setText(option.text);
			optWidget.setFontId(FontID.QUILL_8);
			optWidget.setXPositionMode(WidgetPositionMode.ABSOLUTE_CENTER);
			optWidget.setOriginalX(0);
			optWidget.setYPositionMode(WidgetPositionMode.ABSOLUTE_TOP);
			optWidget.setOriginalY(y);
			optWidget.setOriginalHeight(24);
			optWidget.setXTextAlignment(WidgetTextAlignment.CENTER);
			optWidget.setYTextAlignment(WidgetTextAlignment.CENTER);
			optWidget.setWidthMode(WidgetSizeMode.MINUS);
			optWidget.setAction(0, "Continue");
			optWidget.setOnOpListener((JavaScriptCallback) ev -> callback(option));
			optWidget.setOnMouseOverListener((JavaScriptCallback) ev -> optWidget.setTextColor(0xFFFFFF));
			optWidget.setOnMouseLeaveListener((JavaScriptCallback) ev -> optWidget.setTextColor(0));
			optWidget.setHasListener(true);
			optWidget.revalidate();

			y += step;
		}
	}

	private void callback(Entry entry)
	{
		Widget container = chatboxPanelManager.getContainerWidget();
		container.setOnKeyListener((Object[]) null);

		chatboxPanelManager.close();

		entry.callback.run();
	}

	@Override
	protected void close()
	{
		if (onClose != null)
		{
			onClose.run();
		}
	}


	@Override
	public void keyTyped(KeyEvent e)
	{
		char c = e.getKeyChar();

		if (c == '\033')
		{
			chatboxPanelManager.close();
			e.consume();
			return;
		}

		int n = c - '1';
		if (n >= 0 && n < options.size())
		{
			callback(options.get(n));
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			e.consume();
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}
}
