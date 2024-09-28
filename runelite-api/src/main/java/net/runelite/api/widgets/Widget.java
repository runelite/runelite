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
import javax.annotation.Nullable;
import net.runelite.api.FontTypeFace;
import net.runelite.api.Point;
import net.runelite.api.annotations.Component;
import org.intellij.lang.annotations.MagicConstant;
import org.jetbrains.annotations.Range;

/**
 * Represents an on-screen UI element that is drawn on the canvas.
 * <p>
 * It should be noted that most RuneLite-added elements are not Widgets, but are
 * an Overlay. Notable exceptions include bank tag tabs and chatbox inputs
 * <p>
 * Examples of Widgets include:
 * <ul>
 * <li>The fairy ring configuration selector</li>
 * <li>The mini-map</li>
 * <li>The bank inventory</li>
 * </ul>
 * <p>
 * For a more complete idea of what is classified as a widget, see {@link WidgetID}.
 */
public interface Widget
{
	/**
	 * Gets the widgets ID.
	 *
	 * @see WidgetID
	 */
	@Component
	int getId();

	/**
	 * Gets the type of the widget.
	 *
	 * @see WidgetType
	 */
	@MagicConstant(valuesFromClass = WidgetType.class)
	int getType();

	/**
	 * Sets the type of the widget.
	 *
	 * @see WidgetType
	 */
	void setType(@MagicConstant(valuesFromClass = WidgetType.class) int type);

	/**
	 * Gets the type of content displayed by the widget.
	 */
	int getContentType();

	/**
	 * Sets the type of content displayed by the widget.
	 */
	Widget setContentType(int contentType);

	/**
	 * Gets the current click configuration of the widget.
	 * @see WidgetConfig
	 */
	@MagicConstant(flagsFromClass = WidgetConfig.class)
	int getClickMask();

	/**
	 * Sets the click configuration of the widget.
	 *
	 * @see WidgetConfig
	 */
	Widget setClickMask(@MagicConstant(flagsFromClass = WidgetConfig.class) int mask);

	/**
	 * Gets the parent widget, if this widget is a child.
	 *
	 * @return the parent widget, or null
	 */
	Widget getParent();

	/**
	 * Gets the ID of the parent widget.
	 *
	 * @return the parent ID, or -1 if this widget is not a child
	 */
	int getParentId();

	/**
	 * Gets a dynamic child by index
	 */
	@Nullable
	Widget getChild(int index);

	/**
	 * Gets the dynamic children of this widget in a sparse array
	 */
	@Nullable
	Widget[] getChildren();

	/**
	 * Sets the dynamic children sparse array
	 */
	void setChildren(Widget[] children);

	/**
	 * Gets all dynamic children.
	 *
	 * @return the dynamic children
	 */
	Widget[] getDynamicChildren();

	/**
	 * Gets all static children.
	 *
	 * @return the static children
	 */
	Widget[] getStaticChildren();

	/**
	 * Gets all nested children.
	 *
	 * @return the nested children
	 */
	Widget[] getNestedChildren();

	/**
	 * Gets the relative x-axis coordinate to the widgets parent.
	 *
	 * @return the relative x-axis coordinate
	 */
	int getRelativeX();

	/**
	 * Sets the relative x-axis coordinate to the widgets parent.
	 *
	 * You do not want to use this. Use {@link #setOriginalX(int)}, {@link #setXPositionMode(int)}
	 * and {@link #revalidate()}. Almost any interaction with this widget from a clientscript will
	 * recalculate this value.
	 */
	@Deprecated
	void setRelativeX(int x);

	/**
	 * Gets the relative y-axis coordinate to the widgets parent.
	 *
	 * @return the relative coordinate
	 */
	int getRelativeY();

	/**
	 * Sets the relative y-axis coordinate to the widgets parent.
	 *
	 * You do not want to use this. Use {@link #setOriginalY(int)}, {@link #setYPositionMode(int)}
	 * and {@link #revalidate()}. Almost any interaction with this widget from a clientscript will
	 * recalculate this value.
	 */
	@Deprecated
	void setRelativeY(int y);

	/**
	 * Set a forced position for the widget. This position overrides the relative x/y for the
	 * widget, even if the widget is revalidated. To clear the forced position pass -1 for x/y.
	 * @param x x pos relative to the parent
	 * @param y y pos relative to the parent
	 */
	void setForcedPosition(int x, int y);

	/**
	 * Gets the text displayed on this widget.
	 *
	 * @return the displayed text
	 */
	String getText();

	/**
	 * Sets the text displayed on this widget.
	 *
	 * @param text the text to display
	 */
	Widget setText(String text);

	/**
	 * Gets the color as an RGB value.
	 *
	 * @return RGB24 color
	 * @see java.awt.Color#getRGB()
	 */
	int getTextColor();

	/**
	 * Sets the RGB color of the displayed text or rectangle.
	 *
	 * @param textColor RGB24 color
	 * @see java.awt.Color#getRGB()
	 */
	Widget setTextColor(int textColor);

	/**
	 * Gets the transparency of the rectangle
	 *
	 * @return 0 = fully opaque, 255 = fully transparent
	 */
	int getOpacity();

	/**
	 * Sets the transparency of the rectangle
	 *
	 * @param transparency 0 = fully opaque, 255 = fully transparent
	 */
	Widget setOpacity(int transparency);

	/**
	 * Gets the name "op base" of the widget.
	 * <p>
	 * The name of the widget is used in the tooltip when an action is
	 * available. For example, the widget that activates quick prayers
	 * has the name "Quick-prayers" so when hovering there is a tooltip
	 * that says "Activate Quick-prayers".
	 *
	 * @return the name
	 */
	String getName();

	/**
	 * Sets the name of the widget.
	 *
	 * @param name the new name
	 */
	Widget setName(String name);

	/**
	 * Gets the Model/NPC/Item ID displayed in the widget.
	 *
	 * @see #getModelType()
	 */
	int getModelId();

	/**
	 * Sets the Model/NPC/Item ID displayed in the widget.
	 *
	 * @see WidgetModelType
	 */
	Widget setModelId(int id);

	/**
	 * Gets the model type of the widget.
	 *
	 * @see WidgetModelType
	 */
	@MagicConstant(valuesFromClass = WidgetModelType.class)
	int getModelType();

	/**
	 * Sets the model type of the widget.
	 *
	 * @param type the new model type
	 * @see WidgetModelType
	 */
	Widget setModelType(@MagicConstant(valuesFromClass = WidgetModelType.class) int type);

	/**
	 * Gets the sequence ID used to animate the model in the widget
	 *
	 * @see net.runelite.api.AnimationID
	 */
	int getAnimationId();

	/**
	 * Sets the sequence ID used to animate the model in the widget
	 *
	 * @see net.runelite.api.AnimationID
	 */
	Widget setAnimationId(int animationId);

	/**
	 * Gets the x rotation of the model displayed in the widget.
	 * 0 = no rotation, 2047 = full rotation
	 */
	@Range(from = 0, to = 2047)
	int getRotationX();

	/**
	 * Sets the x rotation of the model displayed in the widget.
	 * <br>
	 * Note: Setting this value outside of the input range defined by {@link Widget#getRotationX()} will cause a client
	 *       crash.
	 *
	 * @param modelX the new model x rotation value
	 */
	Widget setRotationX(@Range(from = 0, to = 2047) int modelX);

	/**
	 * Gets the y rotation of the model displayed in the widget.
	 * 0 = no rotation, 2047 = full rotation
	 */
	@Range(from = 0, to = 2047)
	int getRotationY();

	/**
	 * Sets the y rotation of the model displayed in the widget.
	 * <br>
	 * Note: Setting this value outside of the input range defined by {@link Widget#getRotationY()} will cause a client
	 *       crash.
	 *
	 * @param modelY the new model y rotation value
	 */
	Widget setRotationY(@Range(from = 0, to = 2047) int modelY);

	/**
	 * Gets the z rotation of the model displayed in the widget.
	 * 0 = no rotation, 2047 = full rotation
	 */
	@Range(from = 0, to = 2047)
	int getRotationZ();

	/**
	 * Sets the z rotation of the model displayed in the widget.
	 * <br>
	 * Note: Setting this value outside of the input range defined by {@link Widget#getRotationZ()} will cause a client
	 *       crash.
	 *
	 * @param modelZ the new model z rotation value
	 */
	Widget setRotationZ(@Range(from = 0, to = 2047) int modelZ);

	/**
	 * Gets the amount zoomed in on the model displayed in the widget.
	 */
	int getModelZoom();

	/**
	 * Sets the amount zoomed in on the model displayed in the widget.
	 *
	 * @param modelZoom the new model zoom value
	 */
	Widget setModelZoom(int modelZoom);

	/**
	 * Gets the sprite ID displayed in the widget.
	 *
	 * @return the sprite ID
	 * @see net.runelite.api.SpriteID
	 */
	int getSpriteId();

	/**
	 * Gets if sprites are repeated or stretched
	 */
	boolean getSpriteTiling();

	/**
	 * Sets if sprites are repeated or stretched
	 */
	Widget setSpriteTiling(boolean tiling);

	/**
	 * Sets the sprite ID displayed in the widget.
	 *
	 * @param spriteId the sprite ID
	 * @see net.runelite.api.SpriteID
	 */
	Widget setSpriteId(int spriteId);

	/**
	 * Checks whether this widget or any of its parents are hidden.
	 *
	 * This must be ran on the client thread
	 *
	 * @return true if this widget or any parent is hidden, false otherwise
	 */
	boolean isHidden();

	/**
	 * Checks whether this widget is hidden, not taking into account
	 * any parent hidden states.
	 *
	 * @return true if this widget is hidden, false otherwise
	 */
	boolean isSelfHidden();

	/**
	 * Sets the self-hidden state of this widget.
	 *
	 * @param hidden new hidden state
	 */
	Widget setHidden(boolean hidden);

	/**
	 * The index of this widget in it's parent's children array
	 */
	int getIndex();

	/**
	 * Gets the location the widget is being drawn on the canvas.
	 * <p>
	 * This method accounts for the relative coordinates and bounds
	 * of any parent widgets.
	 *
	 * @return the upper-left coordinate of where this widget is drawn
	 */
	Point getCanvasLocation();

	/**
	 * Gets the width of the widget.
	 * <p>
	 * If this widget is storing any {@link WidgetItem}s, this value is
	 * used to store the number of item slot columns.
	 *
	 * @return the width
	 */
	int getWidth();

	/**
	 * Sets the width of the widget.
	 *
	 * You do not want to use this. Use {@link #setOriginalWidth(int)}, {@link #setWidthMode(int)}
	 * and {@link #revalidate()}. Almost any interaction with this widget from a clientscript will
	 * recalculate this value.
	 */
	@Deprecated
	void setWidth(int width);

	/**
	 * Gets the height of the widget.
	 *
	 * @return the height
	 */
	int getHeight();

	/**
	 * Sets the height of the widget.
	 *
	 * You do not want to use this. Use {@link #setOriginalHeight(int)}, {@link #setHeightMode(int)}
	 * and {@link #revalidate()}. Almost any interaction with this widget from a clientscript will
	 * recalculate this value.
	 */
	@Deprecated
	void setHeight(int height);

	/**
	 * Gets the area where the widget is drawn on the canvas.
	 *
	 * @return the occupied area of the widget
	 */
	Rectangle getBounds();

	/**
	 * Gets the item ID displayed by the widget.
	 *
	 * @return the item ID
	 */
	int getItemId();

	/**
	 * Sets the item ID displayed by the widget.
	 *
	 * @param itemId the item ID
	 */
	Widget setItemId(int itemId);

	/**
	 * Gets the quantity of the item displayed by the widget.
	 *
	 * @return the item quantity
	 */
	int getItemQuantity();

	/**
	 * Sets the item quantity displayed by the widget.
	 *
	 * @param quantity the quantity of the item
	 */
	Widget setItemQuantity(int quantity);

	/**
	 * Checks if the passed canvas points is inside of this widget's
	 * {@link #getBounds() bounds}
	 *
	 * @param point the canvas point
	 * @return true if this widget contains the point, false otherwise
	 */
	boolean contains(Point point);

	/**
	 * Gets the amount of pixels the widget is scrolled in the X axis
	 */
	int getScrollX();

	/**
	 * Sets the amount of pixels the widget is scrolled in the X axis
	 */
	Widget setScrollX(int scrollX);

	/**
	 * Gets the amount of pixels the widget is scrolled in the Y axis
	 */
	int getScrollY();

	/**
	 * sets the amount of pixels the widget is scrolled in the Y axis
	 */
	Widget setScrollY(int scrollY);

	/**
	 * Gets the size of the widget's viewport in the X axis
	 */
	int getScrollWidth();

	/**
	 * Sets the size of the widget's viewport in the X axis
	 */
	Widget setScrollWidth(int width);

	/**
	 * Gets the size of the widget's viewport in the Y axis
	 */
	int getScrollHeight();

	/**
	 * Sets the size of the widget's viewport in the Y axis
	 */
	Widget setScrollHeight(int height);

	/**
	 * Gets the X coordinate of this widget before being adjusted by
	 * {@link #getXPositionMode()}}.
	 */
	int getOriginalX();

	/**
	 * Sets the X input to the {@link WidgetPositionMode}. {@link #revalidate()} must be
	 * called for the new values to take effect.
	 *
	 * @see #setXPositionMode(int)
	 */
	Widget setOriginalX(int originalX);

	/**
	 * Gets the Y coordinate of this widget before being adjusted by
	 * {@link #getYPositionMode()}}
	 */
	int getOriginalY();

	/**
	 * Sets the Y input to the {@link WidgetPositionMode}. {@link #revalidate()} must be
	 * called for the new values to take effect.
	 *
	 * @see #setYPositionMode(int)
	 */
	Widget setOriginalY(int originalY);

	/**
	 * Sets the X/Y coordinates
	 */
	Widget setPos(int x, int y);
	Widget setPos(int x, int y,
		@MagicConstant(valuesFromClass = WidgetPositionMode.class) int xMode,
		@MagicConstant(valuesFromClass = WidgetPositionMode.class) int yMode);

	/**
	 * Gets the height coordinate of this widget before being adjusted by
	 * {@link #getHeightMode()}
	 */
	int getOriginalHeight();

	/**
	 * Sets the height input to the {@link WidgetSizeMode}. {@link #revalidate()} must be
	 * called for the new values to take effect.
	 *
	 * @see #setHeightMode(int)
	 */
	Widget setOriginalHeight(int originalHeight);

	/**
	 * Gets the width coordinate of this widget before being adjusted by
	 * {@link #getWidthMode()}
	 */
	int getOriginalWidth();

	/**
	 * Sets the width input to the {@link WidgetSizeMode}. {@link #revalidate()} must be
	 * called for the new values to take effect.
	 *
	 * @see #setWidthMode(int)
	 */
	Widget setOriginalWidth(int originalWidth);

	Widget setSize(int width, int height);
	Widget setSize(int width, int height,
		@MagicConstant(valuesFromClass = WidgetSizeMode.class) int widthMode,
		@MagicConstant(valuesFromClass = WidgetSizeMode.class) int heightMode);

	/**
	 * Gets the menu options available on the widget as a sparse array.
	 */
	@Nullable
	String[] getActions();

	/**
	 * Creates a dynamic widget child
	 *
	 * @param index the index of the new widget in the children list or -1 to append to the back
	 * @param type  the {@link WidgetType} of the widget
	 */
	Widget createChild(int index, @MagicConstant(valuesFromClass = WidgetType.class) int type);

	/**
	 * Creates a dynamic widget child at the end of the children list
	 *
	 * @param type  the {@link WidgetType} of the widget
	 */
	Widget createChild(@MagicConstant(valuesFromClass = WidgetType.class) int type);

	/**
	 * Removes all of this widget's dynamic children
	 */
	void deleteAllChildren();

	/**
	 * Creates a menu option on the widget
	 *
	 * @param index  The index of the menu
	 * @param action The verb to be displayed next to the widget's name in the context menu
	 */
	void setAction(int index, String action);

	/**
	 * Clear the menu options on a widget.
	 */
	void clearActions();

	/**
	 * Sets a script to be ran when the a menu action is clicked.
	 * hasListener must be true for this to take effect
	 *
	 * @param args A ScriptID, then the args for the script
	 */
	void setOnOpListener(Object... args);

	/**
	 * Sets a script to be ran when the dialog is canceled
	 *
	 * @param args A ScriptID, then the args for the script
	 */
	void setOnDialogAbortListener(Object... args);

	/**
	 * Sets a script to be ran on key input
	 *
	 * @param args A ScriptID, then the args for the script
	 */
	void setOnKeyListener(Object... args);

	/**
	 * Sets a script to be ran when the mouse enters the widget bounds
	 *
	 * @param args A ScriptID, then the args for the script
	 */
	void setOnMouseOverListener(Object... args);

	/**
	 * Sets a script to be ran every client tick when the mouse is in the widget bounds
	 *
	 * @param args A ScriptID, then the args for the script
	 */
	void setOnMouseRepeatListener(Object... args);

	/**
	 * Sets a script to be ran when the mouse leaves the widget bounds
	 *
	 * @param args A ScriptID, then the args for the script
	 */
	void setOnMouseLeaveListener(Object... args);

	/**
	 * Sets a script to be ran every client tick
	 *
	 * @param args A ScriptID, then the args for the script
	 */
	void setOnTimerListener(Object... args);

	/**
	 * Sets a script to be ran when the target mode has been activated for this widget
	 *
	 * @param args A ScriptID, then the args for the script
	 */
	void setOnTargetEnterListener(Object... args);

	/**
	 * Sets a script to be ran when the target mode has been deactivated for this widget
	 *
	 * @param args A ScriptID, then the args for the script
	 */
	void setOnTargetLeaveListener(Object... args);

	/**
	 * If this widget has any listeners on it
	 */
	boolean hasListener();

	/**
	 * Sets if the widget has any listeners. This should be called whenever a setXListener function is called
	 */
	Widget setHasListener(boolean hasListener);

	/**
	 * This is true if the widget is from an if3 interface, or is dynamically created
	 */
	boolean isIf3();

	/**
	 * Recomputes this widget's x/y/w/h, excluding scroll
	 */
	void revalidate();

	/**
	 * Recomputes this widget's group's x/y/w/h including scroll
	 */
	void revalidateScroll();

	/**
	 * Gets the script and arguments to be ran when a menu action is clicked.
	 *
	 * @return
	 */
	Object[] getOnOpListener();

	/**
	 * Gets the script and arguments to be ran when a key is pressed.
	 *
	 * @return
	 */
	Object[] getOnKeyListener();

	/**
	 * Gets the script and arguments to be ran when a interface is loaded.
	 *
	 * @return
	 */
	Object[] getOnLoadListener();

	/**
	 * Gets the script and arguments to be ran when one of the listened for inventories changes.
	 *
	 * @return
	 */
	Object[] getOnInvTransmitListener();

	/**
	 * Returns the archive id of the font used
	 *
	 * @see net.runelite.api.FontID
	 */
	int getFontId();

	/**
	 * Sets the archive id of the font
	 *
	 * @see net.runelite.api.FontID
	 */
	Widget setFontId(int id);

	/**
	 * Returns the border type of item/sprite on the widget
	 * 0 - No border
	 * 1 - 1px black border
	 * 2 - 1px black under 1px white border (selected item)
	 */
	int getBorderType();

	/**
	 * @see #getBorderType
	 */
	void setBorderType(int thickness);

	/**
	 * Returns if text is shadowed
	 */
	boolean getTextShadowed();

	/**
	 * Sets if text should be shadowed
	 */
	Widget setTextShadowed(boolean shadowed);

	/**
	 * Returns the widget drag dead zone
	 */
	int getDragDeadZone();

	/**
	 * Sets the widget drag dead zone
	 */
	void setDragDeadZone(int deadZone);

	/**
	 * Returns the widget drag dead time
	 */
	int getDragDeadTime();

	/**
	 * Sets the widget drag dead time
	 */
	void setDragDeadTime(int deadTime);

	/**
	 * Returns widget {@link net.runelite.api.widgets.ItemQuantityMode}.
	 */
	@MagicConstant(valuesFromClass = ItemQuantityMode.class)
	int getItemQuantityMode();

	/**
	 * Sets the widget {@link net.runelite.api.widgets.ItemQuantityMode}
	 */
	@MagicConstant(valuesFromClass = ItemQuantityMode.class)
	Widget setItemQuantityMode(int itemQuantityMode);

	/**
	 * Gets the mode that the X position is calculated from the original X position
	 *
	 * @see WidgetPositionMode
	 */
	@MagicConstant(valuesFromClass = WidgetPositionMode.class)
	int getXPositionMode();

	/**
	 * Sets the mode that the X position is calculated from the original X position.
	 * {@link #revalidate()} must be called for new values to take effect.
	 *
	 * @see WidgetPositionMode
	 */
	Widget setXPositionMode(@MagicConstant(valuesFromClass = WidgetPositionMode.class) int xpm);

	/**
	 * Gets the mode that the Y position is calculated from the original Y position
	 *
	 * @see WidgetPositionMode
	 */
	@MagicConstant(valuesFromClass = WidgetPositionMode.class)
	int getYPositionMode();

	/**
	 * Sets the mode that the Y position is calculated from the original Y position.
	 * {@link #revalidate()} must be called for new values to take effect.
	 *
	 * @see WidgetPositionMode
	 */
	Widget setYPositionMode(@MagicConstant(valuesFromClass = WidgetPositionMode.class) int ypm);

	/**
	 * Get the line height for this widget.
	 *
	 * @return
	 */
	int getLineHeight();

	/**
	 * Set the line height for this widget. If set to 0, the line height is taken from the font instead.
	 *
	 * @param lineHeight
	 */
	Widget setLineHeight(int lineHeight);

	/**
	 * Gets the X axis text position mode
	 *
	 * @see WidgetTextAlignment
	 */
	@MagicConstant(valuesFromClass = WidgetTextAlignment.class)
	int getXTextAlignment();

	/**
	 * Sets the X axis text position mode
	 *
	 * @see WidgetTextAlignment
	 */
	Widget setXTextAlignment(@MagicConstant(valuesFromClass = WidgetTextAlignment.class) int xta);

	/**
	 * Gets the Y axis text position mode
	 *
	 * @see WidgetTextAlignment
	 */
	@MagicConstant(valuesFromClass = WidgetTextAlignment.class)
	int getYTextAlignment();

	/**
	 * Sets the Y axis text position mode
	 *
	 * @see WidgetTextAlignment
	 */
	Widget setYTextAlignment(@MagicConstant(valuesFromClass = WidgetTextAlignment.class) int yta);

	/**
	 * Gets the mode controlling widget width
	 *
	 * @see WidgetSizeMode
	 */
	@MagicConstant(valuesFromClass = WidgetSizeMode.class)
	int getWidthMode();

	/**
	 * Sets the mode controlling widget width.
	 * {@link #revalidate()} must be called for new values to take effect.
	 *
	 * @see WidgetSizeMode
	 */
	Widget setWidthMode(@MagicConstant(valuesFromClass = WidgetSizeMode.class) int widthMode);

	/**
	 * Gets the mode controlling widget width
	 *
	 * @see WidgetSizeMode
	 */
	@MagicConstant(valuesFromClass = WidgetSizeMode.class)
	int getHeightMode();

	/**
	 * Sets the mode controlling widget width.
	 * {@link #revalidate()} must be called for new values to take effect.
	 *
	 * @see WidgetSizeMode
	 */
	Widget setHeightMode(@MagicConstant(valuesFromClass = WidgetSizeMode.class) int heightMode);

	/**
	 * Gets the font that this widget uses
	 */
	FontTypeFace getFont();

	/**
	 * Gets if the rectangle is filled or just stroked
	 */
	boolean isFilled();

	/**
	 * Sets if the rectangle is filled or just stroked
	 */
	Widget setFilled(boolean filled);

	/**
	 * Verb for spell targets
	 */
	String getTargetVerb();

	/**
	 * Verb for spell targets
	 */
	void setTargetVerb(String targetVerb);

	/**
	 * Can widgets under this widgets be clicked in this widgets bounding box
	 */
	boolean getNoClickThrough();

	/**
	 * Can widgets under this widgets be clicked in this widgets bounding box
	 */
	void setNoClickThrough(boolean noClickThrough);

	/**
	 * Can widgets under this widgets be scrolled in this widgets bounding box
	 */
	boolean getNoScrollThrough();

	/**
	 * Can widgets under this widgets be scrolled in this widgets bounding box
	 */
	void setNoScrollThrough(boolean noScrollThrough);

	/**
	 * {@link net.runelite.api.VarPlayer}s that triggers this widgets varTransmitListener
	 */
	void setVarTransmitTrigger(int ...trigger);

	/**
	 * Sets a script to be ran the first client tick the mouse is held ontop of this widget
	 *
	 * @param args A ScriptID, then the args for the script
	 */
	void setOnClickListener(Object ...args);

	/**
	 * Sets a script to be ran the every client tick the mouse is held ontop of this widget,
	 * except the first client tick.
	 *
	 * @param args A ScriptID, then the args for the script
	 */
	void setOnHoldListener(Object ...args);

	/**
	 * Sets a script to be ran the first client tick the mouse is not held ontop of this widget
	 *
	 * @param args A ScriptID, then the args for the script
	 */
	void setOnReleaseListener(Object ...args);

	/**
	 * Sets a script to be ran when a drag operation is finished on this widget
	 *
	 * @param args A ScriptID, then the args for the script
	 */
	void setOnDragCompleteListener(Object ...args);

	/**
	 * Sets a script to be ran when this widget moves due to a drag
	 *
	 * @param args A ScriptID, then the args for the script
	 */
	void setOnDragListener(Object ...args);

	/**
	 * Sets a script to be ran when the mouse is scrolled when on the widget
	 *
	 * @param args A ScriptID, then the args for the script
	 */
	void setOnScrollWheelListener(Object ...args);

	/**
	 * Container this can be dragged in
	 */
	Widget getDragParent();

	/**
	 * Container this can be dragged in
	 */
	Widget setDragParent(Widget dragParent);

	/**
	 * Gets the script and arguments to be ran when one of the listened for vars changes.
	 *
	 * @return
	 */
	Object[] getOnVarTransmitListener();

	/**
	 * Sets a script to be ran when a varplayer changes
	 *
	 * @param args A ScriptID, then the args for the script
	 */
	void setOnVarTransmitListener(Object ...args);
}
