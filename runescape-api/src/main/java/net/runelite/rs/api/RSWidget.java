/*
 * BSD 2-Clause License
 *
 * Copyright (c) 2019, ThatGamerBlue <thatgamerblue@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 *  Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
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

	//@Import("boundsIndex") -- unused for now
	//int getBoundsIndex();

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

	@Import("dataText")
	String getRSName();

	@Import("dataText")
	void setRSName(String name);

	@Import("text")
	@Override
	void setText(String text);

	@Import("color")
	@Override
	int getTextColor();

	@Import("color")
	@Override
	void setTextColor(int textColor);

	@Import("transparencyTop")
	@Override
	int getOpacity();

	@Import("transparencyTop")
	@Override
	void setOpacity(int opacity);

	@Import("x")
	@Override
	int getRelativeX();

	@Import("x")
	@Override
	void setRelativeX(int x);

	@Import("y")
	@Override
	int getRelativeY();

	@Import("y")
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

	@Import("childIndex")
	int getIndex();

	@Import("childIndex")
	void setIndex(int index);

	//@Import("rotationX")
	//int getRotationX();

	//@Import("rotationY") --- All unused
	//int getRotationY();

	//@Import("rotationZ")
	//int getRotationZ();

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

	@Import("spriteId2")
	@Override
	int getSpriteId();

	@Import("spriteId2")
	@Override
	void setSpriteId(int spriteId);

	@Import("outline")
	@Override
	int getBorderType();

	@Import("outline")
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

	@Import("rawX")
	@Override
	int getOriginalX();

	@Import("rawX")
	@Override
	void setOriginalX(int originalX);

	@Import("rawY")
	@Override
	int getOriginalY();

	@Import("rawY")
	@Override
	void setOriginalY(int originalY);

	@Import("rawHeight")
	@Override
	int getOriginalHeight();

	@Import("rawHeight")
	@Override
	void setOriginalHeight(int originalHeight);

	@Import("rawWidth")
	@Override
	int getOriginalWidth();

	@Import("rawWidth")
	@Override
	void setOriginalWidth(int originalWidth);

	@Import("paddingX")
	int getXPitch();

	@Import("paddingY")
	int getYPitch();

	void broadcastHidden(boolean hidden);

	@Import("onOp")
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

	@Import("onKey")
	@Override
	Object[] getOnKeyListener();

	@Import("onLoad")
	@Override
	Object[] getOnLoadListener();

	@Import("onOp")
	@Override
	Object[] getOnOp();

	@Import("onDialogAbort")
	@Override
	void setOnDialogAbortListener(Object... args);

	@Import("onKey")
	@Override
	void setOnKeyListener(Object... args);

	@Import("onMouseOver")
	@Override
	void setOnMouseOverListener(Object... args);

	@Import("onMouseRepeat")
	@Override
	void setOnMouseRepeatListener(Object... args);

	@Import("onMouseLeave")
	@Override
	void setOnMouseLeaveListener(Object... args);

	@Import("onTimer")
	@Override
	void setOnTimerListener(Object... args);

	@Import("onTargetEnter")
	@Override
	void setOnTargetEnterListener(Object... args);

	@Import("onTargetLeave")
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

	@Import("dragZoneSize")
	@Override
	int getDragDeadZone();

	@Import("dragZoneSize")
	@Override
	void setDragDeadZone(int deadZone);

	@Import("dragThreshold")
	@Override
	int getDragDeadTime();

	@Import("dragThreshold")
	@Override
	void setDragDeadTime(int deadTime);

	@Import("itemQuantityMode")
	@Override
	int getItemQuantityMode();

	@Import("itemQuantityMode")
	@Override
	void setItemQuantityMode(int itemQuantityMode);

	@Import("xAlignment")
	@Override
	int getXPositionMode();

	@Import("xAlignment")
	@Override
	void setXPositionMode(int xpm);

	@Import("yAlignment")
	@Override
	int getYPositionMode();

	@Import("yAlignment")
	@Override
	void setYPositionMode(int ypm);

	@Import("textXAlignment")
	@Override
	int getXTextAlignment();

	@Import("textXAlignment")
	@Override
	void setXTextAlignment(int xta);

	@Import("textYAlignment")
	@Override
	int getYTextAlignment();

	@Import("textYAlignment")
	@Override
	void setYTextAlignment(int yta);

	@Import("widthAlignment")
	@Override
	int getWidthMode();

	@Import("widthAlignment")
	@Override
	void setWidthMode(int widthMode);

	@Import("heightAlignment")
	@Override
	int getHeightMode();

	@Import("heightAlignment")
	@Override
	void setHeightMode(int heightMode);

	@Import("getFont")
	@Override
	RSAbstractFont getFont();

	@Import("fill")
	@Override
	boolean isFilled();

	@Import("fill")
	@Override
	void setFilled(boolean filled);

	@Import("spellActionName")
	@Override
	String getTargetVerb();

	@Import("spellActionName")
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

	@Import("modelFrame")
	int getModelFrame();

	@Import("modelFrameCycle")
	int getModelFrameCycle();

	@Import("onInvTransmit")
	@Override
	Object[] getOnInvTransmit();

	@Import("containsMouse")
	@Override
	boolean containsMouse();

	@Import("getSprite")
	RSSprite getSprite(boolean b);
}
