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

import net.runelite.mapping.Import;

public interface Widget
{
    @Import("parent")
    Widget getParent();

    @Import("dynamicValues")
    int[][] getDynamicValues();

    @Import("children")
    Widget[] getChildren();

    @Import("id")
    int getId();

    @Import("parentId")
    int getParentId();

    @Import("boundsIndex")
    int getBoundsIndex();

    @Import("modelId")
    int getModelId();

    @Import("itemIds")
    int[] getItemIds();

    @Import("itemQuantities")
    int[] getItemQuantities();

    @Import("modelType")
    int getModelType();

    @Import("actions")
    String[] getActions();

    @Import("text")
    String getText();

    @Import("name")
    String getName();

    @Import("textColor")
    int getTextColor();

    @Import("opacity")
    int getOpacity();

    @Import("relativeX")
    int getRelativeX();

    @Import("relativeY")
    int getRelativeY();

    @Import("width")
    int getWidth();

    @Import("height")
    int getHeight();

    @Import("isHidden")
    boolean isHidden();

    @Import("index")
    int getIndex();

    @Import("rotationX")
    int getRotationX();

    @Import("rotationY")
    int getRotationY();

    @Import("rotationZ")
    int getRotationZ();

    @Import("contentType")
    int getContentType();

    @Import("type")
    int getType();

    @Import("scrollX")
    int getScrollX();

    @Import("scrollY")
    int getScrollY();

    @Import("textureId")
    int getTextureId();

    @Import("borderThickness")
    int getBorderThickness();

    @Import("itemQuantity")
    int getItemQuantity();

    @Import("x")
    int getX();

    @Import("y")
    int getY();
}
