/*
 * Copyright (c) 2018, Damien <https://github.com/ADHDDamien>
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
package net.runelite.client.plugins.devtools;

import java.awt.Rectangle;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Point;
import net.runelite.api.widgets.Widget;

@Slf4j
public class WidgetSearch
{
	private HashMap<String, Object> searchTerms = new HashMap<>();

	public void searchRequest(String search)
	{
		searchTerms.clear();
		search = search.toLowerCase();
		String segments[] = search.split("[:|]");

		for (int i = 0; i < segments.length; i++)
		{
			switch (segments[i])
			{
				case "id":
					searchTerms.put("Id", Integer.parseInt(segments[i + 1]));
					break;
				case "type":
					searchTerms.put("Type", Integer.parseInt(segments[i + 1]));
					break;
				case "contenttype":
					searchTerms.put("ContentType", Integer.parseInt(segments[i + 1]));
					break;
				case "parentid":
					searchTerms.put("ParentId", Integer.parseInt(segments[i + 1]));
					break;
				case "selfhidden":
					if (segments[i + 1].equals("true"))
					{
						searchTerms.put("SelfHidden", true);
					}
					else
					{
						searchTerms.put("SelfHidden", false);
					}
					break;
				case "hidden":
					if (segments[i + 1].equals("true"))
					{
						searchTerms.put("Hidden", true);
					}
					else
					{
						searchTerms.put("Hidden", false);
					}
					break;
				case "text":
					searchTerms.put("Text", segments[i + 1]);
					break;
				case "textcolor":
					searchTerms.put("TextColor", segments[i + 1]);
					break;
				case "name":
					searchTerms.put("Name", segments[i + 1]);
					break;
				case "itemid":
					searchTerms.put("ItemId", Integer.parseInt(segments[i + 1]));
					break;
				case "itemquantity":
					searchTerms.put("ItemQuantity", Integer.parseInt(segments[i + 1]));
					break;
				case "modelid":
					searchTerms.put("ModelId", Integer.parseInt(segments[i + 1]));
					break;
				case "spriteid":
					searchTerms.put("SpriteId", Integer.parseInt(segments[i + 1]));
					break;
				case "width":
					searchTerms.put("Width", Integer.parseInt(segments[i + 1]));
					break;
				case "height":
					searchTerms.put("Height", Integer.parseInt(segments[i + 1]));
					break;
				case "relativex":
					searchTerms.put("RelativeX", Integer.parseInt(segments[i + 1]));
					break;
				case "relativey":
					searchTerms.put("RelativeY", Integer.parseInt(segments[i + 1]));
					break;
				case "canvaslocation":
					String canvasSegments[] = segments[i + 1].split("[,]");
					searchTerms.put("CanvasLocation", new Point(Integer.parseInt(canvasSegments[0]), Integer.parseInt(canvasSegments[1])));
					break;
				case "bounds":
					String boundsSegments[] = segments[i + 1].split("[,]");
					searchTerms.put("Bounds", new Rectangle(Integer.parseInt(boundsSegments[0]), Integer.parseInt(boundsSegments[1]), Integer.parseInt(boundsSegments[2]), Integer.parseInt(boundsSegments[3])));
					break;
				case "scrollx":
					searchTerms.put("ScrollX", Integer.parseInt(segments[i + 1]));
					break;
				case "scrolly":
					searchTerms.put("ScrollY", Integer.parseInt(segments[i + 1]));
					break;
				case "originalx":
					searchTerms.put("OriginalX", Integer.parseInt(segments[i + 1]));
					break;
				case "originaly":
					searchTerms.put("OriginalY", Integer.parseInt(segments[i + 1]));
					break;
				case "paddingx":
					searchTerms.put("PaddingX", Integer.parseInt(segments[i + 1]));
					break;
				case "paddingy":
					searchTerms.put("PaddingY", Integer.parseInt(segments[i + 1]));
					break;
			}
		}
	}

	public boolean isMatch(Widget widget)
	{
		int counter = 0;

		for (Object key : searchTerms.keySet())
		{
			switch ((String) key)
			{
				case "Id":
					counter += ((widget.getId() == (Integer) searchTerms.get("Id")) ? 1 : -100);
					break;
				case "Type":
					counter += ((widget.getType() == (Integer) searchTerms.get("Type")) ? 1 : -100);
					break;
				case "ContentType":
					counter += ((widget.getContentType() == (Integer) searchTerms.get("ContentType")) ? 1 : -100);
					break;
				case "ParentId":
					counter += ((widget.getParentId() == (Integer) searchTerms.get("ParentId")) ? 1 : -100);
					break;
				case "SelfHidden":
					counter += ((widget.isSelfHidden() == (Boolean) searchTerms.get("SelfHidden")) ? 1 : -100);
					break;
				case "Hidden":
					counter += ((widget.isHidden() == (Boolean) searchTerms.get("Hidden")) ? 1 : -100);
					break;
				case "Text":
					counter += ((widget.getText().toLowerCase().contains((String) searchTerms.get("Text"))) ? 1 : -100);
					break;
				case "TextColor":
					counter += ((Integer.toString(widget.getTextColor(), 16).equals((searchTerms.get("TextColor"))) ? 1 : -100));
					break;
				case "Name":
					counter += ((widget.getName().toLowerCase().contains((String) searchTerms.get("Name"))) ? 1 : -100);
					break;
				case "ItemId":
					counter += ((widget.getItemId() == (Integer) searchTerms.get("ItemId")) ? 1 : -100);
					break;
				case "ItemQuantity":
					counter += ((widget.getItemQuantity() == (Integer) searchTerms.get("ItemQuantity")) ? 1 : -100);
					break;
				case "ModelId":
					counter += ((widget.getModelId() == (Integer) searchTerms.get("ModelId")) ? 1 : -100);
					break;
				case "SpriteId":
					counter += ((widget.getSpriteId() == (Integer) searchTerms.get("SpriteId")) ? 1 : -100);
					break;
				case "Width":
					counter += ((widget.getWidth() == (Integer) searchTerms.get("Width")) ? 1 : -100);
					break;
				case "Height":
					counter += ((widget.getHeight() == (Integer) searchTerms.get("Height")) ? 1 : -100);
					break;
				case "RelativeX":
					counter += ((widget.getRelativeX() == (Integer) searchTerms.get("RelativeX")) ? 1 : -100);
					break;
				case "RelativeY":
					counter += ((widget.getRelativeY() == (Integer) searchTerms.get("RelativeY")) ? 1 : -100);
					break;
				case "CanvasLocation":
					counter += ((widget.getCanvasLocation().equals((searchTerms.get("CanvasLocation"))) ? 1 : -100));
					break;
				case "Bounds":
					counter += ((widget.getBounds().equals(searchTerms.get("Bounds"))) ? 1 : -100);
					break;
				case "ScrollX":
					counter += ((widget.getScrollX() == (Integer) searchTerms.get("ScrollX")) ? 1 : -100);
					break;
				case "ScrollY":
					counter += ((widget.getScrollY() == (Integer) searchTerms.get("ScrollY")) ? 1 : -100);
					break;
				case "OriginalX":
					counter += ((widget.getOriginalX() == (Integer) searchTerms.get("OriginalX")) ? 1 : -100);
					break;
				case "OriginalY":
					counter += ((widget.getOriginalY() == (Integer) searchTerms.get("OriginalY")) ? 1 : -100);
					break;
				case "PaddingX":
					counter += ((widget.getPaddingX() == (Integer) searchTerms.get("PaddingX")) ? 1 : -100);
					break;
				case "PaddingY":
					counter += ((widget.getPaddingY() == (Integer) searchTerms.get("PaddingY")) ? 1 : -100);
					break;
			}
		}

		//If any case is entered and doesn't match it sets the value to -100 this way all search terms have to match a widgetIDs fields or it's impossible to return true
		if (counter < 1)
		{
			return false;
		}
		else
		{
			return true;
		}

	}

	public boolean matchesMousePosition(Rectangle bounds, Point mousePos)
	{
		return ((mousePos.getX() >= bounds.x) && (mousePos.getY() >= bounds.y) && (mousePos.getX() < bounds.x + bounds.width) && (mousePos.getY() < bounds.y + bounds.height));
	}
}