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
	@Import("children")
	@Override
	RSWidget[] getChildren();

	@Import("children")
	@Override
	void setChildren(Widget[] children);

	@Import("id")
	@Override
	int getId();

	void setRenderParentId(int parentId);

	void setRenderX(int x);

	void setRenderY(int y);

	@Import("id")
	void setId(int id);

	@Import("parentId")
	int getRSParentId();

	@Import("parentId")
	void setParentId(int id);

	@Import("clickMask")
	int getClickMask();

	@Import("clickMask")
	void setClickMask(int mask);

	@Import("boundsIndex")
	int getBoundsIndex();

	@Import("modelId")
	@Override
	int getModelId();

	@Import("itemIds")
	int[] getItemIds();

	@Import("itemQuantities")
	int[] getItemQuantities();

	@Import("modelType")
	int getModelType();

	@Import("actions")
	@Override
	String[] getActions();

	@Import("text")
	String getRSText();

	@Import("name")
	String getRSName();

	@Import("name")
	void setRSName(String name);

	@Import("text")
	@Override
	void setText(String text);

	@Import("textColor")
	@Override
	int getTextColor();

	@Import("textColor")
	@Override
	void setTextColor(int textColor);

	@Import("opacity")
	@Override
	int getOpacity();

	@Import("opacity")
	@Override
	void setOpacity(int opacity);

	@Import("relativeX")
	@Override
	int getRelativeX();

	@Import("relativeX")
	@Override
	void setRelativeX(int x);

	@Import("relativeY")
	@Override
	int getRelativeY();

	@Import("relativeY")
	@Override
	void setRelativeY(int y);

	@Import("width")
	@Override
	int getWidth();

	@Import("width")
	@Override
	void setWidth(int width);

	@Import("height")
	@Override
	int getHeight();

	@Import("height")
	@Override
	void setHeight(int height);

	@Import("isHidden")
	@Override
	boolean isSelfHidden();

	@Import("isHidden")
	void setHidden(boolean hidden);

	@Import("index")
	int getIndex();

	@Import("index")
	void setIndex(int index);

	@Import("rotationX")
	int getRotationX();

	@Import("rotationY")
	int getRotationY();

	@Import("rotationZ")
	int getRotationZ();

	@Import("contentType")
	@Override
	int getContentType();

	@Import("contentType")
	@Override
	void setContentType(int contentType);

	@Import("type")
	@Override
	int getType();

	@Import("type")
	@Override
	void setType(int type);

	@Import("scrollX")
	@Override
	int getScrollX();

	@Import("scrollX")
	@Override
	void setScrollX(int scrollX);

	@Import("scrollY")
	@Override
	int getScrollY();

	@Import("scrollY")
	@Override
	void setScrollY(int scrollY);

	@Import("scrollWidth")
	@Override
	int getScrollWidth();

	@Import("scrollWidth")
	@Override
	void setScrollWidth(int width);

	@Import("scrollHeight")
	@Override
	int getScrollHeight();

	@Import("scrollHeight")
	@Override
	void setScrollHeight(int height);

	@Import("spriteId")
	@Override
	int getSpriteId();

	@Import("spriteId")
	@Override
	void setSpriteId(int spriteId);

	@Import("borderType")
	@Override
	int getBorderType();

	@Import("borderType")
	@Override
	void setBorderType(int type);

	@Import("itemId")
	@Override
	int getItemId();

	@Import("itemId")
	@Override
	void setItemId(int itemId);

	@Import("itemQuantity")
	@Override
	int getItemQuantity();

	@Import("itemQuantity")
	@Override
	void setItemQuantity(int quantity);

	@Import("originalX")
	@Override
	int getOriginalX();

	@Import("originalX")
	@Override
	void setOriginalX(int originalX);

	@Import("originalY")
	@Override
	int getOriginalY();

	@Import("originalY")
	@Override
	void setOriginalY(int originalY);

	@Import("originalHeight")
	@Override
	int getOriginalHeight();

	@Import("originalHeight")
	@Override
	void setOriginalHeight(int originalHeight);

	@Import("originalWidth")
	@Override
	int getOriginalWidth();

	@Import("originalWidth")
	@Override
	void setOriginalWidth(int originalWidth);

	@Import("xPitch")
	int getXPitch();

	@Import("yPitch")
	int getYPitch();

	void broadcastHidden(boolean hidden);

	@Import("onOpListener")
	@Override
	void setOnOpListener(Object... args);

	@Import("setAction")
	@Override
	void setAction(int idx, String action);

	@Import("isIf3")
	@Override
	boolean isIf3();

	@Import("isIf3")
	void setIsIf3(boolean isIf3);

	@Import("hasListener")
	@Override
	boolean hasListener();

	@Import("hasListener")
	@Override
	void setHasListener(boolean hasListener);

	@Import("onKeyListener")
	@Override
	Object[] getOnKeyListener();

	@Import("onLoadListener")
	@Override
	Object[] getOnLoadListener();

	@Import("onDialogAbortListener")
	@Override
	void setOnDialogAbortListener(Object... args);

	@Import("onKeyListener")
	@Override
	void setOnKeyListener(Object... args);

	@Import("onMouseOverListener")
	@Override
	void setOnMouseOverListener(Object... args);

	@Import("onMouseRepeatListener")
	@Override
	void setOnMouseRepeatListener(Object... args);

	@Import("onMouseLeaveListener")
	@Override
	void setOnMouseLeaveListener(Object... args);

	@Import("onTimerListener")
	@Override
	void setOnTimerListener(Object... args);

	@Import("onTargetEnterListener")
	@Override
	void setOnTargetEnterListener(Object... args);

	@Import("onTargetLeaveListener")
	@Override
	void setOnTargetLeaveListener(Object... args);

	@Import("fontId")
	@Override
	int getFontId();

	@Import("fontId")
	@Override
	void setFontId(int id);

	@Import("textShadowed")
	@Override
	boolean getTextShadowed();

	@Import("textShadowed")
	@Override
	void setTextShadowed(boolean shadowed);

	@Import("dragDeadZone")
	@Override
	int getDragDeadZone();

	@Import("dragDeadZone")
	@Override
	void setDragDeadZone(int deadZone);

	@Import("dragDeadTime")
	@Override
	int getDragDeadTime();

	@Import("dragDeadTime")
	@Override
	void setDragDeadTime(int deadTime);

	@Import("itemQuantityMode")
	@Override
	int getItemQuantityMode();

	@Import("itemQuantityMode")
	@Override
	void setItemQuantityMode(int itemQuantityMode);

	@Import("xPositionMode")
	@Override
	int getXPositionMode();

	@Import("xPositionMode")
	@Override
	void setXPositionMode(int xpm);

	@Import("yPositionMode")
	@Override
	int getYPositionMode();

	@Import("yPositionMode")
	@Override
	void setYPositionMode(int ypm);

	@Import("xTextAlignment")
	@Override
	int getXTextAlignment();

	@Import("xTextAlignment")
	@Override
	void setXTextAlignment(int xta);

	@Import("yTextAlignment")
	@Override
	int getYTextAlignment();

	@Import("yTextAlignment")
	@Override
	void setYTextAlignment(int yta);

	@Import("widthMode")
	@Override
	int getWidthMode();

	@Import("widthMode")
	@Override
	void setWidthMode(int widthMode);
	
	@Import("heightMode")
	@Override
	int getHeightMode();

	@Import("heightMode")
	@Override
	void setHeightMode(int heightMode);

	@Import("getFont")
	@Override
	RSFontTypeFace getFont();

	@Import("filled")
	@Override
	boolean isFilled();

	@Import("filled")
	@Override
	void setFilled(boolean filled);

	@Import("targetVerb")
	@Override
	String getTargetVerb();

	@Import("targetVerb")
	@Override
	void setTargetVerb(String targetVerb);

	@Import("noClickThrough")
	@Override
	boolean getNoClickThrough();

	@Import("noClickThrough")
	@Override
	void setNoClickThrough(boolean noClickThrough);

	@Import("noScrollThrough")
	@Override
	boolean getNoScrollThrough();

	@Import("noScrollThrough")
	@Override
	void setNoScrollThrough(boolean noScrollThrough);
}
