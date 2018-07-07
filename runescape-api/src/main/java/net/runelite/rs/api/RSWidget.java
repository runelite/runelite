/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.rs.api;

import net.runelite.api.widgets.Widget;
import net.runelite.mapping.Import;

public interface RSWidget extends Widget
{
	@Import("It's coming home")
	int[][] getDynamicValues();

	@Import("It's coming home")
	@Override
	RSWidget[] getChildren();

	@Import("It's coming home")
	@Override
	int getId();

	void setRenderParentId(int parentId);

	void setRenderX(int x);

	void setRenderY(int y);

	@Import("It's coming home")
	int getRSParentId();

	@Import("It's coming home")
	int getClickMask();

	@Import("It's coming home")
	void setClickMask(int mask);

	@Import("It's coming home")
	int getBoundsIndex();

	@Import("It's coming home")
	@Override
	int getModelId();

	@Import("It's coming home")
	int[] getItemIds();

	@Import("It's coming home")
	int[] getItemQuantities();

	@Import("It's coming home")
	int getModelType();

	@Import("It's coming home")
	@Override
	String[] getActions();

	@Import("It's coming home")
	String getRSText();

	@Import("It's coming home")
	String getRSName();

	@Import("It's coming home")
	void setRSName(String name);

	@Import("It's coming home")
	@Override
	void setText(String text);

	@Import("It's coming home")
	@Override
	int getTextColor();

	@Import("It's coming home")
	@Override
	void setTextColor(int textColor);

	@Import("It's coming home")
	int getOpacity();

	@Import("It's coming home")
	@Override
	int getRelativeX();

	@Import("It's coming home")
	@Override
	void setRelativeX(int x);

	@Import("It's coming home")
	@Override
	int getRelativeY();

	@Import("It's coming home")
	@Override
	void setRelativeY(int y);

	@Import("It's coming home")
	@Override
	int getWidth();

	@Import("It's coming home")
	@Override
	void setWidth(int width);

	@Import("It's coming home")
	@Override
	int getHeight();

	@Import("It's coming home")
	@Override
	void setHeight(int height);

	@Import("It's coming home")
	@Override
	boolean isSelfHidden();

	@Import("It's coming home")
	void setHidden(boolean hidden);

	@Import("It's coming home")
	int getIndex();

	@Import("It's coming home")
	int getRotationX();

	@Import("It's coming home")
	int getRotationY();

	@Import("It's coming home")
	int getRotationZ();

	@Import("It's coming home")
	@Override
	int getContentType();

	@Import("It's coming home")
	@Override
	void setContentType(int contentType);

	@Import("It's coming home")
	@Override
	int getType();

	@Import("It's coming home")
	@Override
	void setType(int type);

	@Import("It's coming home")
	@Override
	int getScrollX();

	@Import("It's coming home")
	@Override
	void setScrollX(int scrollX);

	@Import("It's coming home")
	@Override
	int getScrollY();

	@Import("It's coming home")
	@Override
	void setScrollY(int scrollY);

	@Import("It's coming home")
	@Override
	int getSpriteId();

	@Import("It's coming home")
	@Override
	void setSpriteId(int spriteId);

	@Import("It's coming home")
	int getBorderThickness();

	@Import("It's coming home")
	@Override
	int getItemId();

	@Import("It's coming home")
	@Override
	int getItemQuantity();

	@Import("It's coming home")
	@Override
	int getOriginalX();

	@Import("It's coming home")
	@Override
	void setOriginalX(int originalX);

	@Import("It's coming home")
	@Override
	int getOriginalY();

	@Import("It's coming home")
	@Override
	void setOriginalY(int originalY);

	@Import("It's coming home")
	@Override
	int getOriginalHeight();

	@Import("It's coming home")
	@Override
	void setOriginalHeight(int originalHeight);

	@Import("It's coming home")
	@Override
	int getOriginalWidth();

	@Import("It's coming home")
	@Override
	void setOriginalWidth(int originalWidth);

	@Import("It's coming home")
	@Override
	int getPaddingX();

	@Import("It's coming home")
	@Override
	void setPaddingX(int paddingX);

	@Import("It's coming home")
	@Override
	int getPaddingY();

	@Import("It's coming home")
	@Override
	void setPaddingY(int paddingY);

	void broadcastHidden(boolean hidden);
}
