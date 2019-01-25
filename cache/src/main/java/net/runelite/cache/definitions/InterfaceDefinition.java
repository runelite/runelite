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
package net.runelite.cache.definitions;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class InterfaceDefinition
{
	public int id = -1;
	public boolean isIf3 = false;
	public int type;
	public int contentType;
	public int originalX;
	public int originalY;
	public int originalWidth;
	public int originalHeight;
	public int widthMode;
	public int heightMode;
	public int xPositionMode;
	public int yPositionMode;
	public int parentId = -1;
	public boolean isHidden;
	public int scrollWidth;
	public int scrollHeight;
	public boolean noClickThrough;
	public int spriteId;
	public int textureId;
	public boolean spriteTiling;
	public int opacity;
	public int borderType;
	public int shadowColor;
	public boolean flippedVertically;
	public boolean flippedHorizontally;
	public int modelType;
	public int modelId;
	public int offsetX2d;
	public int offsetY2d;
	public int rotationX;
	public int rotationY;
	public int rotationZ;
	public int modelZoom;
	public int animation;
	public boolean orthogonal;
	public int modelHeightOverride;
	public int fontId;
	public String text;
	public int lineHeight;
	public int xTextAlignment;
	public int yTextAlignment;
	public boolean textShadowed;
	public int textColor;
	public boolean filled;
	public int lineWidth;
	public boolean lineDirection;
	public int clickMask;
	public String name;
	public String[] actions;
	public int dragDeadZone;
	public int dragDeadTime;
	public boolean dragRenderBehavior;
	public String targetVerb;
	public Object[] onLoadListener;
	public Object[] onMouseOverListener;
	public Object[] onMouseLeaveListener;
	public Object[] onTargetLeaveListener;
	public Object[] onTargetEnterListener;
	public Object[] onVarTransmitListener;
	public Object[] onInvTransmitListener;
	public Object[] onStatTransmitListener;
	public Object[] onTimerListener;
	public Object[] onOpListener;
	public Object[] onMouseRepeatListener;
	public Object[] onClickListener;
	public Object[] onClickRepeatListener;
	public Object[] onReleaseListener;
	public Object[] onHoldListener;
	public Object[] onDragListener;
	public Object[] onDragCompleteListener;
	public Object[] onScrollWheelListener;
	public int[] varTransmitTriggers;
	public int[] invTransmitTriggers;
	public int[] statTransmitTriggers;
	public boolean hasListener;
	
	public int menuType;
	// This is set to a siblings' child id when that widget should get a hover effect when this one is hovered
	public int hoveredSiblingId;
	public int[] alternateOperators;
	public int[] alternateRhs;
	public ClientScript1Instruction[][] clientScripts;
	public int[] itemIds;
	public int[] itemQuantities;
	public int xPitch;
	public int yPitch;
	public int[] xOffsets;
	public int[] yOffsets;
	public int[] sprites;
	public String[] configActions;
	public String alternateText;
	public int alternateTextColor;
	public int hoveredTextColor;
	public int alternateHoveredTextColor;
	public int alternateSpriteId;
	public int alternateModelId;
	public int alternateAnimation;
	public String spellName;
	public String tooltip;
}
