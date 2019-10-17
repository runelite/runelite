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

import com.google.common.base.Strings;
import com.google.inject.Inject;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.regex.Pattern;
import javax.swing.SwingUtilities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.FontID;
import net.runelite.api.FontTypeFace;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetPositionMode;
import net.runelite.api.widgets.WidgetSizeMode;
import net.runelite.api.widgets.WidgetTextAlignment;
import net.runelite.api.widgets.WidgetType;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseListener;
import net.runelite.client.util.MiscUtils;
import net.runelite.api.util.Text;

@Slf4j
public class ChatboxTextInput extends ChatboxInput implements KeyListener, MouseListener
{
	private static final int CURSOR_FLASH_RATE_MILLIS = 1000;
	private static final Pattern BREAK_MATCHER = Pattern.compile("[^a-zA-Z0-9']");

	private final ChatboxPanelManager chatboxPanelManager;
	protected final ClientThread clientThread;

	private static IntPredicate getDefaultCharValidator()
	{
		return i -> i >= 32 && i < 127;
	}

	@AllArgsConstructor
	private static class Line
	{
		private final int start;
		private final int end;
		private final String text;
	}

	@Getter
	private String prompt;

	@Getter
	private int lines;

	private StringBuffer value = new StringBuffer();

	@Getter
	private int cursorStart = 0;

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

	@Getter
	private boolean built = false;

	// These are lambdas for atomic updates
	private Predicate<MouseEvent> isInBounds = null;
	private ToIntFunction<Integer> getLineOffset = null;
	private ToIntFunction<Point> getPointCharOffset = null;

	@Inject
	protected ChatboxTextInput(ChatboxPanelManager chatboxPanelManager, ClientThread clientThread)
	{
		this.chatboxPanelManager = chatboxPanelManager;
		this.clientThread = clientThread;
	}

	public ChatboxTextInput addCharValidator(IntPredicate validator)
	{
		this.charValidator = this.charValidator.and(validator);
		return this;
	}

	public ChatboxTextInput lines(int lines)
	{
		this.lines = lines;
		if (built)
		{
			clientThread.invoke(this::update);
		}
		return this;
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
		StringBuffer sb = new StringBuffer();
		for (char c : value.toCharArray())
		{
			if (charValidator.test(c))
			{
				sb.append(c);
			}
		}
		this.value = sb;
		cursorAt(this.value.length());
		return this;
	}

	private ChatboxTextInput cursorAt(int index)
	{
		return cursorAt(index, index);
	}

	private ChatboxTextInput cursorAt(int indexA, int indexB)
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

		this.cursorStart = start;
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
		final List<Line> editLines = new ArrayList<>();

		Widget container = chatboxPanelManager.getContainerWidget();

		final Widget cursor = container.createChild(-1, WidgetType.RECTANGLE);
		long start = System.currentTimeMillis();
		cursor.setOnTimerListener((JavaScriptCallback) ev ->
		{
			boolean on = (System.currentTimeMillis() - start) % CURSOR_FLASH_RATE_MILLIS > (CURSOR_FLASH_RATE_MILLIS / 2);
			cursor.setOpacity(on ? 255 : 0);
		});
		cursor.setTextColor(0xFFFFFF);
		cursor.setHasListener(true);
		cursor.setFilled(true);
		cursor.setFontId(fontID);

		FontTypeFace font = cursor.getFont();
		if (h <= 0)
		{
			h = font.getBaseline();
		}

		final int oy = y;
		final int ox = x;
		final int oh = h;

		int breakIndex = -1;
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < value.length(); i++)
		{
			int count = i - sb.length();
			final String c = value.charAt(i) + "";
			sb.append(c);
			if (BREAK_MATCHER.matcher(c).matches())
			{
				breakIndex = sb.length();
			}

			if (i == value.length() - 1)
			{
				Line line = new Line(count, count + sb.length() - 1, sb.toString());
				editLines.add(line);
				break;
			}

			if (font.getTextWidth(sb.toString() + value.charAt(i + 1)) < w)
			{
				continue;
			}

			if (editLines.size() < this.lines - 1 || this.lines == 0)
			{
				if (breakIndex > 1)
				{
					String str = sb.substring(0, breakIndex);
					Line line = new Line(count, count + str.length() - 1, str);
					editLines.add(line);

					sb.replace(0, breakIndex, "");
					breakIndex = -1;
					continue;
				}

				Line line = new Line(count, count + sb.length() - 1, sb.toString());
				editLines.add(line);
				sb.replace(0, sb.length(), "");
			}
		}

		Rectangle bounds = new Rectangle(container.getCanvasLocation().getX() + container.getWidth(), y, 0, editLines.size() * oh);
		for (int i = 0; i < editLines.size() || i == 0; i++)
		{
			final Line line = editLines.size() > 0 ? editLines.get(i) : new Line(0, 0, "");
			final String text = line.text;
			final int len = text.length();

			String lt = Text.escapeJagex(text);
			String mt = "";
			String rt = "";

			final boolean isStartLine = cursorOnLine(cursorStart, line.start, line.end)
				|| (cursorOnLine(cursorStart, line.start, line.end + 1) && i == editLines.size() - 1);

			final boolean isEndLine = cursorOnLine(cursorEnd, line.start, line.end);

			if (isStartLine || isEndLine || (cursorEnd > line.end && cursorStart < line.start))
			{
				final int cIdx = MiscUtils.clamp(cursorStart - line.start, 0, len);
				final int ceIdx = MiscUtils.clamp(cursorEnd - line.start, 0, len);

				lt = Text.escapeJagex(text.substring(0, cIdx));
				mt = Text.escapeJagex(text.substring(cIdx, ceIdx));
				rt = Text.escapeJagex(text.substring(ceIdx));
			}

			final int ltw = font.getTextWidth(lt);
			final int mtw = font.getTextWidth(mt);
			final int rtw = font.getTextWidth(rt);
			final int fullWidth = ltw + mtw + rtw;

			int ltx = ox;
			if (w > 0)
			{
				ltx += (w - fullWidth) / 2;
			}

			final int mtx = ltx + ltw;
			final int rtx = mtx + mtw;

			if (ltx < bounds.x)
			{
				bounds.setLocation(ltx, bounds.y);
			}

			if (fullWidth > bounds.width)
			{
				bounds.setSize(fullWidth, bounds.height);
			}

			if (editLines.size() == 0 || isStartLine)
			{
				cursor.setOriginalX(mtx - 1);
				cursor.setOriginalY(y);
				cursor.setOriginalWidth(2);
				cursor.setOriginalHeight(h);
				cursor.revalidate();
			}

			if (!Strings.isNullOrEmpty(lt))
			{
				final Widget leftText = container.createChild(-1, WidgetType.TEXT);
				leftText.setFontId(fontID);
				leftText.setText(lt);
				leftText.setOriginalX(ltx);
				leftText.setOriginalY(y);
				leftText.setOriginalWidth(ltw);
				leftText.setOriginalHeight(h);
				leftText.revalidate();
			}

			if (!Strings.isNullOrEmpty(mt))
			{
				final Widget background = container.createChild(-1, WidgetType.RECTANGLE);
				background.setTextColor(0x113399);
				background.setFilled(true);
				background.setOriginalX(mtx - 1);
				background.setOriginalY(y);
				background.setOriginalWidth(2 + mtw);
				background.setOriginalHeight(h);
				background.revalidate();

				final Widget middleText = container.createChild(-1, WidgetType.TEXT);
				middleText.setText(mt);
				middleText.setFontId(fontID);
				middleText.setOriginalX(mtx);
				middleText.setOriginalY(y);
				middleText.setOriginalWidth(mtw);
				middleText.setOriginalHeight(h);
				middleText.setTextColor(0xFFFFFF);
				middleText.revalidate();
			}

			if (!Strings.isNullOrEmpty(rt))
			{
				final Widget rightText = container.createChild(-1, WidgetType.TEXT);
				rightText.setText(rt);
				rightText.setFontId(fontID);
				rightText.setOriginalX(rtx);
				rightText.setOriginalY(y);
				rightText.setOriginalWidth(rtw);
				rightText.setOriginalHeight(h);
				rightText.revalidate();
			}

			y += h;
		}

		net.runelite.api.Point ccl = container.getCanvasLocation();

		isInBounds = ev -> bounds.contains(new Point(ev.getX() - ccl.getX(), ev.getY() - ccl.getY()));
		getPointCharOffset = p ->
		{
			if (bounds.width <= 0)
			{
				return 0;
			}

			int cx = p.x - ccl.getX() - ox;
			int cy = p.y - ccl.getY() - oy;

			int currentLine = MiscUtils.clamp(cy / oh, 0, editLines.size() - 1);

			final Line line = editLines.get(currentLine);
			final String tsValue = line.text;
			int charIndex = tsValue.length();
			int fullWidth = font.getTextWidth(tsValue);

			int tx = ox;
			if (w > 0)
			{
				tx += (w - fullWidth) / 2;
			}
			cx -= tx;

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

			charIndex = MiscUtils.clamp(charIndex, 0, tsValue.length());
			return line.start + charIndex;
		};

		getLineOffset = code ->
		{
			if (editLines.size() < 2)
			{
				return cursorStart;
			}

			int currentLine = -1;
			for (int i = 0; i < editLines.size(); i++)
			{
				Line l = editLines.get(i);
				if (cursorOnLine(cursorStart, l.start, l.end)
					|| (cursorOnLine(cursorStart, l.start, l.end + 1) && i == editLines.size() - 1))
				{
					currentLine = i;
					break;
				}
			}

			if (currentLine == -1
				|| (code == KeyEvent.VK_UP && currentLine == 0)
				|| (code == KeyEvent.VK_DOWN && currentLine == editLines.size() - 1))
			{
				return cursorStart;
			}

			final Line line = editLines.get(currentLine);
			final int direction = code == KeyEvent.VK_UP ? -1 : 1;
			final Point dest = new Point(cursor.getCanvasLocation().getX(), cursor.getCanvasLocation().getY() + (direction * oh));
			final int charOffset = getPointCharOffset.applyAsInt(dest);

			// Place cursor on right line if whitespace keep it on the same line or skip a line
			final Line nextLine = editLines.get(currentLine + direction);
			if ((direction == -1 && charOffset >= line.start)
				|| (direction == 1 && (charOffset > nextLine.end && (currentLine + direction != editLines.size() - 1))))
			{
				return nextLine.end;
			}

			return charOffset;
		};
	}

	private boolean cursorOnLine(final int cursor, final int start, final int end)
	{
		return (cursor >= start) && (cursor <= end);
	}

	private int getCharOffset(MouseEvent ev)
	{
		if (getPointCharOffset == null)
		{
			return 0;
		}

		return getPointCharOffset.applyAsInt(ev.getPoint());
	}

	@Override
	protected void open()
	{
		this.built = true;
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
			if (cursorStart != cursorEnd)
			{
				value.delete(cursorStart, cursorEnd);
			}
			value.insert(cursorStart, c);
			cursorAt(cursorStart + 1);
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
					if (cursorStart != cursorEnd)
					{
						String s = value.substring(cursorStart, cursorEnd);
						if (code == KeyEvent.VK_X)
						{
							value.delete(cursorStart, cursorEnd);
							cursorAt(cursorStart);
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
						if (cursorStart != cursorEnd)
						{
							value.delete(cursorStart, cursorEnd);
						}
						for (int i = 0; i < s.length(); i++)
						{
							char ch = s.charAt(i);
							if (charValidator.test(ch))
							{
								value.insert(cursorStart, ch);
								cursorStart++;
							}
						}
						cursorAt(cursorStart);
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
		int newPos = cursorStart;
		if (ev.isShiftDown())
		{
			if (selectionEnd == -1 || selectionStart == -1)
			{
				selectionStart = cursorStart;
				selectionEnd = cursorStart;
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
				if (cursorStart != cursorEnd)
				{
					value.delete(cursorStart, cursorEnd);
					cursorAt(cursorStart);
					if (onChanged != null)
					{
						onChanged.accept(getValue());
					}
					return;
				}
				if (cursorStart < value.length())
				{
					value.deleteCharAt(cursorStart);
					cursorAt(cursorStart);
					if (onChanged != null)
					{
						onChanged.accept(getValue());
					}
				}
				return;
			case KeyEvent.VK_BACK_SPACE:
				if (cursorStart != cursorEnd)
				{
					value.delete(cursorStart, cursorEnd);
					cursorAt(cursorStart);
					if (onChanged != null)
					{
						onChanged.accept(getValue());
					}
					return;
				}
				if (cursorStart > 0)
				{
					value.deleteCharAt(cursorStart - 1);
					cursorAt(cursorStart - 1);
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
			case KeyEvent.VK_UP:
			case KeyEvent.VK_DOWN:
				ev.consume();
				newPos = getLineOffset.applyAsInt(code);
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
				if (cursorStart != cursorEnd)
				{
					cursorAt(cursorStart);
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
			if (cursorStart != cursorEnd)
			{
				selectionStart = -1;
				selectionEnd = -1;
				cursorAt(getCharOffset(mouseEvent));
			}
			return mouseEvent;
		}

		int nco = getCharOffset(mouseEvent);

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

		int nco = getCharOffset(mouseEvent);
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
