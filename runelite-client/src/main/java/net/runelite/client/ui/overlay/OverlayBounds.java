/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.ui.overlay;

import java.awt.Rectangle;
import java.util.Arrays;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Value;
import static net.runelite.client.ui.overlay.OverlayPosition.ABOVE_CHATBOX_RIGHT;
import static net.runelite.client.ui.overlay.OverlayPosition.BOTTOM_LEFT;
import static net.runelite.client.ui.overlay.OverlayPosition.BOTTOM_RIGHT;
import static net.runelite.client.ui.overlay.OverlayPosition.CANVAS_TOP_RIGHT;
import static net.runelite.client.ui.overlay.OverlayPosition.TOP_CENTER;
import static net.runelite.client.ui.overlay.OverlayPosition.TOP_LEFT;
import static net.runelite.client.ui.overlay.OverlayPosition.TOP_RIGHT;

@AllArgsConstructor
@Value
class OverlayBounds
{
	private final Rectangle topLeft, topCenter, topRight, bottomLeft, bottomRight, aboveChatboxRight, canvasTopRight;

	OverlayBounds(OverlayBounds other)
	{
		topLeft = new Rectangle(other.topLeft);
		topCenter = new Rectangle(other.topCenter);
		topRight = new Rectangle(other.topRight);
		bottomLeft = new Rectangle(other.bottomLeft);
		bottomRight = new Rectangle(other.bottomRight);
		aboveChatboxRight = new Rectangle(other.aboveChatboxRight);
		canvasTopRight = new Rectangle(other.canvasTopRight);
	}

	OverlayBounds translated(final int x, final int y)
	{
		final OverlayBounds translated = new OverlayBounds(this);
		translated.getTopRight().translate(x, 0);
		translated.getTopCenter().translate(x / 2, 0);
		translated.getBottomLeft().translate(0, y);
		translated.getBottomRight().translate(x, y);
		translated.getAboveChatboxRight().translate(x, y);
		translated.getCanvasTopRight().translate(x, 0);
		return translated;
	}

	Rectangle forPosition(OverlayPosition overlayPosition)
	{
		switch (overlayPosition)
		{
			case TOP_LEFT:
				return topLeft;
			case TOP_CENTER:
				return topCenter;
			case TOP_RIGHT:
				return topRight;
			case BOTTOM_LEFT:
				return bottomLeft;
			case BOTTOM_RIGHT:
				return bottomRight;
			case ABOVE_CHATBOX_RIGHT:
				return aboveChatboxRight;
			case CANVAS_TOP_RIGHT:
				return canvasTopRight;
			default:
				throw new IllegalArgumentException();
		}
	}

	OverlayPosition fromBounds(Rectangle bounds)
	{
		if (bounds == topLeft)
		{
			return TOP_LEFT;
		}
		else if (bounds == topCenter)
		{
			return TOP_CENTER;
		}
		else if (bounds == topRight)
		{
			return TOP_RIGHT;
		}
		else if (bounds == bottomLeft)
		{
			return BOTTOM_LEFT;
		}
		else if (bounds == bottomRight)
		{
			return BOTTOM_RIGHT;
		}
		else if (bounds == aboveChatboxRight)
		{
			return ABOVE_CHATBOX_RIGHT;
		}
		else if (bounds == canvasTopRight)
		{
			return CANVAS_TOP_RIGHT;
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	Collection<Rectangle> getBounds()
	{
		return Arrays.asList(topLeft, topCenter, topRight, bottomLeft, bottomRight, aboveChatboxRight, canvasTopRight);
	}
}
