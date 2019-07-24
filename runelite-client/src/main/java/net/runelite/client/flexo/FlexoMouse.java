
/*
 *
 *   Copyright (c) 2019, Zeruth <TheRealNull@gmail.com>
 *   All rights reserved.
 *
 *   Redistribution and use in source and binary forms, with or without
 *   modification, are permitted provided that the following conditions are met:
 *
 *   1. Redistributions of source code must retain the above copyright notice, this
 *      list of conditions and the following disclaimer.
 *   2. Redistributions in binary form must reproduce the above copyright notice,
 *      this list of conditions and the following disclaimer in the documentation
 *      and/or other materials provided with the distribution.
 *
 *   THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *   ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *   WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *   DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *   ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *   (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *   LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *   ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *   (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *   SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package net.runelite.client.flexo;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;
import java.util.logging.Logger;
import net.runelite.api.Constants;
import net.runelite.client.ui.ClientUI;

public class FlexoMouse
{

	/*
	Should pass unstretched coords, handles all conversions here.
	*/
	public static Point getClickPoint(Rectangle rect)
	{
		if (rect != null)
		{
			Random r = new Random();
			int x = -1;
			int y = -1;
			x = rect.x + r.nextInt(rect.width);
			y = rect.y + r.nextInt(rect.height);

			if (Flexo.isStretched)
			{
				double wScale;
				double hScale;

				if (Flexo.client.isResized())
				{
					wScale = (Flexo.client.getStretchedDimensions().width / (double) Flexo.client.getRealDimensions().width);
					hScale = (Flexo.client.getStretchedDimensions().height / (double) Flexo.client.getRealDimensions().height);
					int newX = (int) (x * wScale);
					int newY = (int) (y * hScale);
					if (newX > 0 && newX < ClientUI.frame.getWidth())
					{
						if (newY > 0 && newY < ClientUI.frame.getHeight())
						{
							return new Point(newX, newY);
						}
					}
					Logger.getAnonymousLogger().warning("[RuneLit]Flexo - Off screen point attempted. Split the step, or rotate the screen.");
					return null;
				}
				else
				{
					if (x > 0 && x < ClientUI.frame.getWidth())
					{
						if (y > 0 && y < ClientUI.frame.getHeight())
						{
							return new Point(x, y);
						}
					}
					Logger.getAnonymousLogger().warning("[RuneLit]Flexo - Off screen point attempted. Split the step, or rotate the screen.");
					return null;
				}

			}
			else if (!Flexo.client.isResized())
			{
				final int fixedWidth = Constants.GAME_FIXED_WIDTH;
				int widthDif = ClientUI.frame.getWidth();

				if (ClientUI.pluginToolbar.isVisible())
				{
					widthDif -= ClientUI.pluginToolbar.getWidth();
				}
				if (ClientUI.pluginPanel != null)
				{
					widthDif -= ClientUI.pluginPanel.getWidth();
				}

				widthDif -= fixedWidth;
				if (x + (widthDif / 2) > 0 && x + (widthDif / 2) < ClientUI.frame.getWidth())
				{
					if (y > 0 && y < ClientUI.frame.getHeight())
					{
						return new Point(x, y);
					}
				}
				Logger.getAnonymousLogger().warning("[RuneLit]Flexo - Off screen point attempted. Split the step, or rotate the screen.");
				return null;
			}
			else
			{
				if (x > 0 && x < ClientUI.frame.getWidth())
				{
					if (y > 0 && y < ClientUI.frame.getHeight())
					{
						return new Point(x, y);
					}
				}
				Logger.getAnonymousLogger().warning("[RuneLit]Flexo - Off screen point attempted. Split the step, or rotate the screen.");
				return null;
			}
		}
		return null;
	}

	public static Rectangle getClickArea(Rectangle rect)
	{
		if (Flexo.isStretched)
		{
			double wScale;
			double hScale;

			if (Flexo.client.isResized())
			{
				wScale = (Flexo.client.getStretchedDimensions().width / (double) Flexo.client.getRealDimensions().width);
				hScale = (Flexo.client.getStretchedDimensions().height / (double) Flexo.client.getRealDimensions().height);
			}
			else
			{
				wScale = (Flexo.client.getStretchedDimensions().width) / (double) Flexo.fixedWidth;
				hScale = (Flexo.client.getStretchedDimensions().height) / (double) Flexo.fixedHeight;
			}

			int xPadding = (int) rect.getWidth() / 5;
			int yPadding = (int) rect.getHeight() / 5;
			Random r = new Random();
			Rectangle clickRect = new Rectangle();
			clickRect.width = rect.width - xPadding * 2;
			clickRect.height = rect.height - yPadding * 2;
			clickRect.x = rect.x + xPadding;
			clickRect.y = rect.y + yPadding;
			if (clickRect.width > 0 && clickRect.height > 0)
			{
				int x = clickRect.x + r.nextInt(clickRect.width);
				int y = clickRect.y + r.nextInt(clickRect.height);
				double tScale = 1 + (Flexo.scale / 100);

				if (Flexo.client.isResized())
				{
					return new Rectangle((int) (clickRect.x * wScale), (int) (clickRect.y * wScale), (int) (clickRect.width * wScale), (int) (clickRect.getHeight() * hScale));
				}
				else
				{
					return new Rectangle(clickRect.x, clickRect.y, clickRect.width, (int) (clickRect.getHeight()));
				}
			}

		}
		//Fixed, not stretched
		else if (!Flexo.client.isResized())
		{
			int fixedWidth = 765;
			int widthDif = ClientUI.frame.getWidth();

			if (ClientUI.pluginToolbar.isVisible())
			{
				widthDif -= ClientUI.pluginToolbar.getWidth();
			}
			if (ClientUI.pluginPanel != null)
			{
				widthDif -= ClientUI.pluginPanel.getWidth();
			}

			widthDif -= fixedWidth;
			int xPadding = (int) rect.getWidth() / 5;
			int yPadding = (int) rect.getHeight() / 5;
			Random r = new Random();
			Rectangle clickRect = new Rectangle();
			clickRect.width = rect.width - xPadding;
			clickRect.height = rect.height - yPadding;
			clickRect.x = rect.x + xPadding;
			clickRect.y = rect.y + yPadding;
			if (clickRect.height > 0 && clickRect.width > 0)
			{
				int x = clickRect.x + r.nextInt(clickRect.width);
				int y = clickRect.y + r.nextInt(clickRect.height);
				return new Rectangle(clickRect.x, clickRect.y, clickRect.width, (int) (clickRect.getHeight()));
			}
		}
		//Resizable, not stretched
		else
		{
			int xPadding = (int) rect.getWidth() / 5;
			int yPadding = (int) rect.getHeight() / 5;
			Random r = new Random();
			Rectangle clickRect = new Rectangle();
			clickRect.width = rect.width - xPadding * 2;
			clickRect.height = rect.height - yPadding * 2;
			clickRect.x = rect.x + xPadding;
			clickRect.y = rect.y + yPadding;
			if (clickRect.height > 0 && clickRect.width > 0)
			{
				int x = clickRect.x + r.nextInt(clickRect.width);
				int y = clickRect.y + r.nextInt(clickRect.height);
				return new Rectangle(clickRect.x, clickRect.y, clickRect.width, (int) (clickRect.getHeight()));
			}
		}

		return null;
	}
}
