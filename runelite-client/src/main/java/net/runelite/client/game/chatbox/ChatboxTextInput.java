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
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import javax.swing.SwingUtilities;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.FontTypeFace;
import net.runelite.api.FontID;
import net.runelite.api.widgets.WidgetType;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetPositionMode;
import net.runelite.api.widgets.WidgetSizeMode;
import net.runelite.api.widgets.WidgetTextAlignment;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseListener;
import net.runelite.client.util.Text;

@Slf4j
public class ChatboxTextInput extends ChatboxInput implements KeyListener, MouseListener
{
	private static final int CURSOR_FLASH_RATE_MILLIS = 1000;

	private final ChatboxPanelManager chatboxPanelManager;
	private final ClientThread clientThread;

	private static IntPredicate getDefaultCharValidator()
	{
		return i -> i >= 32 && i < 127;
	}

	@Getter
	private String prompt;

	private StringBuffer value = new StringBuffer();

	@Getter
	private int cursor = 0;

	@Getter
	private int cursorEnd = 0;

	private int selectionStart = -1;
	private int selectionEnd = -1;

	@Getter
	private IntPredicate charValidator = getDefaultCharValidator();

	@Getter
	private Runnable onClose = null;

	@Getter
	private Consumer<String> onDone = null;

	@Getter
	private Consumer<String> onChanged = null;

	@Getter
	private int fontID = FontID.QUILL_8;

	// This is a lambda so I can have atomic updates for it's captures
	private ToIntFunction<MouseEvent> getCharOffset = null;
	private Predicate<MouseEvent> isInBounds = null;

	private boolean built = false;

	@Inject
	protected ChatboxTextInput(ChatboxPanelManager chatboxPanelManager, ClientThread clientThread)
	{
		this.chatboxPanelManager = chatboxPanelManager;
		this.clientThread = clientThread;
	}

	public ChatboxTextInput prompt(String prompt)
	{
		this.prompt = prompt;
		if (built)
		{
			clientThread.invoke(this::update);
		}
		return this;
	}

	public ChatboxTextInput value(String value)
	{
		this.value = new StringBuffer(value);
		cursorAt(this.value.length());
		return this;
	}

	public ChatboxTextInput cursorAt(int index)
	{
		return cursorAt(index, index);
	}

	public ChatboxTextInput cursorAt(int indexA, int indexB)
	{
		if (indexA < 0)
		{
			indexA = 0;
		}
		if (indexB < 0)
		{
			indexB = 0;
		}
		if (indexA > value.length())
		{
			indexA = value.length();
		}
		if (indexB > value.length())
		{
			indexB = value.length();
		}
		int start = indexA;
		int end = indexB;
		if (start > end)
		{
			int v = start;
			start = end;
			end = v;
		}

		this.cursor = start;
		this.cursorEnd = end;

		if (built)
		{
			clientThread.invoke(this::update);
		}

		return this;
	}

	public String getValue()
	{
		return value.toString();
	}

	public ChatboxTextInput charValidator(IntPredicate val)
	{
		if (val == null)
		{
			val = getDefaultCharValidator();
		}
		this.charValidator = val;
		return this;
	}

	public ChatboxTextInput onClose(Runnable onClose)
	{
		this.onClose = onClose;
		return this;
	}

	public ChatboxTextInput onDone(Consumer<String> onDone)
	{
		this.onDone = onDone;
		return this;
	}

	public ChatboxTextInput onChanged(Consumer<String> onChanged)
	{
		this.onChanged = onChanged;
		return this;
	}

	public ChatboxTextInput fontID(int fontID)
	{
		this.fontID = fontID;
		return this;
	}

	protected void update()
	{
		this.built = true;
		Widget container = chatboxPanelManager.getContainerWidget();
		container.deleteAllChildren();

		Widget promptWidget = container.createChild(-1, WidgetType.TEXT);
		promptWidget.setText(this.prompt);
		promptWidget.setTextColor(0x800000);
		promptWidget.setFontId(fontID);
		promptWidget.setXPositionMode(WidgetPositionMode.ABSOLUTE_CENTER);
		promptWidget.setOriginalX(0);
		promptWidget.setYPositionMode(WidgetPositionMode.ABSOLUTE_TOP);
		promptWidget.setOriginalY(8);
		promptWidget.setOriginalHeight(24);
		promptWidget.setXTextAlignment(WidgetTextAlignment.CENTER);
		promptWidget.setYTextAlignment(WidgetTextAlignment.CENTER);
		promptWidget.setWidthMode(WidgetSizeMode.MINUS);
		promptWidget.revalidate();

		buildEdit(0, 50, container.getWidth(), 0);
	}

	protected void buildEdit(int x, int y, int w, int h)
	{
		Widget container = chatboxPanelManager.getContainerWidget();

		String lt = Text.escapeJagex(value.substring(0, this.cursor));
		String mt = Text.escapeJagex(value.substring(this.cursor, this.cursorEnd));
		String rt = Text.escapeJagex(value.substring(this.cursorEnd));

		Widget leftText = container.createChild(-1, WidgetType.TEXT);
		Widget cursor = container.createChild(-1, WidgetType.RECTANGLE);
		Widget middleText = container.createChild(-1, WidgetType.TEXT);
		Widget rightText = container.createChild(-1, WidgetType.TEXT);

		leftText.setFontId(fontID);
		FontTypeFace font = leftText.getFont();

		if (h <= 0)
		{
			h = font.getBaseline();
		}

		int ltw = font.getTextWidth(lt);
		int mtw = font.getTextWidth(mt);
		int rtw = font.getTextWidth(rt);

		int fullWidth = ltw + mtw + rtw;

		int ox = x;
		if (w > 0)
		{
			x += (w - fullWidth) / 2;
		}

		int ltx = x;
		int mtx = ltx + ltw;
		int rtx = mtx + mtw;

		leftText.setText(lt);
		leftText.setOriginalX(ltx);
		leftText.setOriginalY(y);
		leftText.setOriginalWidth(ltw);
		leftText.setOriginalHeight(h);
		leftText.revalidate();

		if (!mt.isEmpty())
		{
			cursor.setTextColor(0x113399);
		}
		else
		{
			cursor.setTextColor(0xFFFFFF);
			long start = System.currentTimeMillis();
			cursor.setOnTimerListener((JavaScriptCallback) ev ->
			{
				boolean on = (System.currentTimeMillis() - start) % CURSOR_FLASH_RATE_MILLIS > (CURSOR_FLASH_RATE_MILLIS / 2);
				cursor.setOpacity(on ? 255 : 0);
			});
			cursor.setHasListener(true);
		}
		cursor.setFilled(true);
		cursor.setOriginalX(mtx - 1);
		cursor.setOriginalY(y);
		cursor.setOriginalWidth(2 + mtw);
		cursor.setOriginalHeight(h);
		cursor.revalidate();

		middleText.setText(mt);
		middleText.setFontId(fontID);
		middleText.setOriginalX(mtx);
		middleText.setOriginalY(y);
		middleText.setOriginalWidth(mtw);
		middleText.setOriginalHeight(h);
		middleText.setTextColor(0xFFFFFF);
		middleText.revalidate();

		rightText.setText(rt);
		rightText.setFontId(fontID);
		rightText.setOriginalX(rtx);
		rightText.setOriginalY(y);
		rightText.setOriginalWidth(rtw);
		rightText.setOriginalHeight(h);
		rightText.revalidate();

		net.runelite.api.Point ccl = container.getCanvasLocation();
		int canvasX = ltx + ccl.getX();
		Rectangle bounds = new Rectangle(ccl.getX() + ox, ccl.getY() + y, w > 0 ? w : fullWidth, h);

		String tsValue = value.toString();
		isInBounds = ev -> bounds.contains(ev.getPoint());
		getCharOffset = ev ->
		{
			if (fullWidth <= 0)
			{
				return 0;
			}

			int cx = ev.getX() - canvasX;

			int charIndex = (tsValue.length() * cx) / fullWidth;

			// `i` is used to track max execution time incase there is a font with ligature width data that causes this to fail
			for (int i = tsValue.length(); i >= 0 && charIndex >= 0 && charIndex <= tsValue.length(); i--)
			{
				int lcx = charIndex > 0 ? font.getTextWidth(Text.escapeJagex(tsValue.substring(0, charIndex - 1))) : 0;
				int mcx = font.getTextWidth(Text.escapeJagex(tsValue.substring(0, charIndex)));
				int rcx = charIndex + 1 <= tsValue.length() ? font.getTextWidth(Text.escapeJagex(tsValue.substring(0, charIndex + 1))) : mcx;

				int leftBound = (lcx + mcx) / 2;
				int rightBound = (mcx + rcx) / 2;

				if (cx < leftBound)
				{
					charIndex--;
					continue;
				}
				if (cx > rightBound)
				{
					charIndex++;
					continue;
				}
				break;
			}

			if (charIndex < 0)
			{
				charIndex = 0;
			}
			if (charIndex > tsValue.length())
			{
				charIndex = tsValue.length();
			}

			return charIndex;
		};
	}

	@Override
	protected void open()
	{
		update();
	}

	@Override
	protected void close()
	{
		if (this.onClose != null)
		{
			this.onClose.run();
		}
	}

	public ChatboxTextInput build()
	{
		if (prompt == null)
		{
			throw new IllegalStateException("prompt must be non-null");
		}
		chatboxPanelManager.openInput(this);

		return this;
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		char c = e.getKeyChar();
		if (charValidator.test(c))
		{
			if (cursor != cursorEnd)
			{
				value.delete(cursor, cursorEnd);
			}
			value.insert(cursor, c);
			cursorAt(cursor + 1);
			if (onChanged != null)
			{
				onChanged.accept(getValue());
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent ev)
	{
		int code = ev.getKeyCode();
		if (ev.isControlDown())
		{
			switch (code)
			{
				case KeyEvent.VK_X:
				case KeyEvent.VK_C:
					if (cursor != cursorEnd)
					{
						String s = value.substring(cursor, cursorEnd);
						if (code == KeyEvent.VK_X)
						{
							value.delete(cursor, cursorEnd);
							cursorAt(cursor);
						}
						Toolkit.getDefaultToolkit()
							.getSystemClipboard()
							.setContents(new StringSelection(s), null);
					}
					return;
				case KeyEvent.VK_V:
					try
					{
						String s = Toolkit.getDefaultToolkit()
							.getSystemClipboard()
							.getData(DataFlavor.stringFlavor)
							.toString();
						if (cursor != cursorEnd)
						{
							value.delete(cursor, cursorEnd);
						}
						for (int i = 0; i < s.length(); i++)
						{
							char ch = s.charAt(i);
							if (charValidator.test(ch))
							{
								value.insert(cursor, ch);
								cursor++;
							}
						}
						cursorAt(cursor);
						if (onChanged != null)
						{
							onChanged.accept(getValue());
						}
					}
					catch (IOException | UnsupportedFlavorException ex)
					{
						log.warn("Unable to get clipboard", ex);
					}
					return;
			}
			return;
		}
		int newPos = cursor;
		if (ev.isShiftDown())
		{
			if (selectionEnd == -1 || selectionStart == -1)
			{
				selectionStart = cursor;
				selectionEnd = cursor;
			}
			newPos = selectionEnd;
		}
		else
		{
			selectionStart = -1;
			selectionEnd = -1;
		}
		switch (code)
		{
			case KeyEvent.VK_DELETE:
				if (cursor != cursorEnd)
				{
					value.delete(cursor, cursorEnd);
					cursorAt(cursor);
					if (onChanged != null)
					{
						onChanged.accept(getValue());
					}
					return;
				}
				if (cursor < value.length())
				{
					value.deleteCharAt(cursor);
					cursorAt(cursor);
					if (onChanged != null)
					{
						onChanged.accept(getValue());
					}
				}
				return;
			case KeyEvent.VK_BACK_SPACE:
				if (cursor != cursorEnd)
				{
					value.delete(cursor, cursorEnd);
					cursorAt(cursor);
					if (onChanged != null)
					{
						onChanged.accept(getValue());
					}
					return;
				}
				if (cursor > 0)
				{
					value.deleteCharAt(cursor - 1);
					cursorAt(cursor - 1);
					if (onChanged != null)
					{
						onChanged.accept(getValue());
					}
				}
				return;
			case KeyEvent.VK_LEFT:
				ev.consume();
				newPos--;
				break;
			case KeyEvent.VK_RIGHT:
				ev.consume();
				newPos++;
				break;
			case KeyEvent.VK_HOME:
				ev.consume();
				newPos = 0;
				break;
			case KeyEvent.VK_END:
				ev.consume();
				newPos = value.length();
				break;
			case KeyEvent.VK_ENTER:
				ev.consume();
				if (onDone != null)
				{
					onDone.accept(getValue());
				}
				chatboxPanelManager.close();
				return;
			case KeyEvent.VK_ESCAPE:
				ev.consume();
				if (cursor != cursorEnd)
				{
					cursorAt(cursor);
					return;
				}
				chatboxPanelManager.close();
				return;
			default:
				return;
		}
		if (newPos > value.length())
		{
			newPos = value.length();
		}
		if (newPos < 0)
		{
			newPos = 0;
		}
		if (ev.isShiftDown())
		{
			selectionEnd = newPos;
			cursorAt(selectionStart, newPos);
		}
		else
		{
			cursorAt(newPos);
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}

	@Override
	public MouseEvent mouseClicked(MouseEvent mouseEvent)
	{
		return mouseEvent;
	}

	@Override
	public MouseEvent mousePressed(MouseEvent mouseEvent)
	{
		if (mouseEvent.getButton() != MouseEvent.BUTTON1)
		{
			return mouseEvent;
		}
		if (isInBounds == null || !isInBounds.test(mouseEvent))
		{
			if (cursor != cursorEnd)
			{
				selectionStart = -1;
				selectionEnd = -1;
				cursorAt(getCharOffset.applyAsInt(mouseEvent));
			}
			return mouseEvent;
		}

		int nco = getCharOffset.applyAsInt(mouseEvent);

		if (mouseEvent.isShiftDown() && selectionEnd != -1)
		{
			selectionEnd = nco;
			cursorAt(selectionStart, selectionEnd);
		}
		else
		{
			selectionStart = nco;
			cursorAt(nco);
		}

		return mouseEvent;
	}

	@Override
	public MouseEvent mouseReleased(MouseEvent mouseEvent)
	{
		return mouseEvent;
	}

	@Override
	public MouseEvent mouseEntered(MouseEvent mouseEvent)
	{
		return mouseEvent;
	}

	@Override
	public MouseEvent mouseExited(MouseEvent mouseEvent)
	{
		return mouseEvent;
	}

	@Override
	public MouseEvent mouseDragged(MouseEvent mouseEvent)
	{
		if (!SwingUtilities.isLeftMouseButton(mouseEvent))
		{
			return mouseEvent;
		}

		int nco = getCharOffset.applyAsInt(mouseEvent);
		if (selectionStart != -1)
		{
			selectionEnd = nco;
			cursorAt(selectionStart, selectionEnd);
		}

		return mouseEvent;
	}

	@Override
	public MouseEvent mouseMoved(MouseEvent mouseEvent)
	{
		return mouseEvent;
	}
}
