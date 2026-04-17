/*
 * Copyright (c) 2026, Adam <Adam@sigterm.info>
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

import java.util.Arrays;
import java.util.Collection;

class SnapCorners
{
	final SnapCorner topLeft, topCenter, topRight, bottomLeft, bottomRight, aboveChatboxRight, canvasTopRight;

	SnapCorners()
	{
		this.topLeft = new SnapCorner(OverlayPosition.TOP_LEFT, SnapCorner.EXPAND_DOWN);
		this.topCenter = new SnapCorner(OverlayPosition.TOP_CENTER, SnapCorner.ALIGNMENT_CENTER_HORIZONTAL | SnapCorner.EXPAND_DOWN);
		this.topRight = new SnapCorner(OverlayPosition.TOP_RIGHT, SnapCorner.ALIGNMENT_RIGHT | SnapCorner.EXPAND_DOWN);
		this.bottomLeft = new SnapCorner(OverlayPosition.BOTTOM_LEFT, SnapCorner.ALIGNMENT_BOTTOM | SnapCorner.EXPAND_RIGHT);
		this.bottomRight = new SnapCorner(OverlayPosition.BOTTOM_RIGHT, SnapCorner.ALIGNMENT_RIGHT | SnapCorner.ALIGNMENT_BOTTOM | SnapCorner.EXPAND_LEFT);
		this.aboveChatboxRight = new SnapCorner(OverlayPosition.ABOVE_CHATBOX_RIGHT, SnapCorner.ALIGNMENT_RIGHT | SnapCorner.ALIGNMENT_BOTTOM | SnapCorner.EXPAND_UP);
		this.canvasTopRight = new SnapCorner(OverlayPosition.CANVAS_TOP_RIGHT, SnapCorner.ALIGNMENT_RIGHT | SnapCorner.EXPAND_DOWN);
	}

	SnapCorner forPosition(OverlayPosition overlayPosition)
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

	Collection<SnapCorner> getSnapCorners()
	{
		return Arrays.asList(topLeft, topCenter, topRight, bottomLeft, bottomRight, aboveChatboxRight, canvasTopRight);
	}

	void reset()
	{
		topLeft.reset();
		topCenter.reset();
		topRight.reset();
		bottomLeft.reset();
		bottomRight.reset();
		aboveChatboxRight.reset();
		canvasTopRight.reset();
	}
}
