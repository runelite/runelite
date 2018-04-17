/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.api.widgets;

import java.awt.Rectangle;
import java.util.Collection;
import net.runelite.api.Point;

public interface Widget
{
	int getId();

	int getType();

	void setType(int type);

	int getContentType();

	void setContentType(int contentType);

	int getClickMask();

	void setClickMask(int mask);

	Widget getParent();

	int getParentId();

	Widget getChild(int index);

	Widget[] getChildren();

	Widget[] getDynamicChildren();

	Widget[] getStaticChildren();

	Widget[] getNestedChildren();

	int getRelativeX();

	void setRelativeX(int x);

	int getRelativeY();

	void setRelativeY(int y);

	String getText();

	void setText(String text);

	int getTextColor();

	void setTextColor(int textColor);

	String getName();

	void setName(String name);

	int getModelId();

	int getSpriteId();

	void setSpriteId(int spriteId);

	/**
	 * @return True if this widget or any of it's parents are hidden
	 */
	boolean isHidden();

	/**
	 * @return True if this widget, regardless of it's parent's state
	 */
	boolean isSelfHidden();

	/**
	 * Sets if this element is hidden as returned by isSelfHidden()
	 */
	void setHidden(boolean hidden);

	Point getCanvasLocation();

	int getWidth();

	void setWidth(int width);

	int getHeight();

	void setHeight(int height);

	Rectangle getBounds();

	Collection<WidgetItem> getWidgetItems();

	WidgetItem getWidgetItem(int index);

	int getItemId();

	int getItemQuantity();
	
	boolean contains(Point point);

	int getScrollX();

	void setScrollX(int scrollX);

	int getScrollY();

	void setScrollY(int scrollY);

	int getOriginalX();

	void setOriginalX(int originalX);

	int getOriginalY();

	void setOriginalY(int originalY);

	int getPaddingX();

	void setPaddingX(int paddingX);

	int getPaddingY();

	void setPaddingY(int paddingY);

	String[] getActions();
}
