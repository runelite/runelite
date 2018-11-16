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
import net.runelite.api.FontTypeFace;
import net.runelite.api.Point;

/**
 * Represents an on-screen UI element that is drawn on the canvas.
 * <p>
 * It should be noted that unique RuneLite elements are note widgets
 * themselves, and that Widgets are primarily RuneScape elements.
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
	 * @return the widget ID
	 * @see WidgetID
	 */
	int getId();

	/**
	 * Gets the type of the widget.
	 *
	 * @return the widget type
	 */
	int getType();

	/**
	 * Sets the type of the widget.
	 *
	 * @param type the new widget type
	 */
	void setType(int type);

	/**
	 * Gets the type of content displayed by the widget.
	 *
	 * @return the content type
	 */
	int getContentType();

	/**
	 * Sets the type of content displayed by the widget.
	 *
	 * @param contentType the new content type
	 */
	void setContentType(int contentType);

	/**
	 * Gets the current click configuration of the widget.
	 *
	 * @return the click configuration
	 */
	int getClickMask();

	/**
	 * Sets the click configuration of the widget.
	 *
	 * @param mask the new configuration
	 */
	void setClickMask(int mask);

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
	 * Safely gets a child widget at a specific index from {@link #getChildren}.
	 *
	 * @param index the raw index into the array
	 * @return child widget, or null if the index does not exist
	 */
	Widget getChild(int index);

	/**
	 * Gets all children of this widget.
	 *
	 * @return the widgets children
	 */
	Widget[] getChildren();

	/**
	 * Sets the widget children
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
	 * @param x the new relative coordinate
	 */
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
	 * @param y the new relative coordinate
	 */
	void setRelativeY(int y);

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
	void setText(String text);

	/**
	 * Gets the text color as an RGB value.
	 *
	 * @return the text color
	 * @see java.awt.Color#getRGB()
	 */
	int getTextColor();

	/**
	 * Sets the RGB color of the displayed text or rectangle.
	 *
	 * @param textColor the new text color
	 * @see java.awt.Color#getRGB()
	 */
	void setTextColor(int textColor);

	/**
	 * Sets the opacity of the rectangle
	 */
	int getOpacity();
	/**
	 * Gets the opacity of the rectangle
	 */
	void setOpacity(int opacity);

	/**
	 * Gets the name of the widget.
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
	void setName(String name);

	/**
	 * Gets the model ID displayed in the widget.
	 *
	 * @return the model ID
	 */
	int getModelId();

	/**
	 * Gets the sprite ID displayed in the widget.
	 *
	 * @return the sprite ID
	 * @see net.runelite.api.SpriteID
	 */
	int getSpriteId();

	/**
	 * Sets the sprite ID displayed in the widget.
	 *
	 * @param spriteId the sprite ID
	 * @see net.runelite.api.SpriteID
	 */
	void setSpriteId(int spriteId);

	/**
	 * Checks whether this widget or any of its parents are hidden.
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
	 * Sets the hidden state of this widget.
	 *
	 * @param hidden new hidden state
	 */
	void setHidden(boolean hidden);

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
	 * @param width the new width
	 */
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
	 * @param height the new height
	 */
	void setHeight(int height);

	/**
	 * Gets the area where the widget is drawn on the canvas.
	 *
	 * @return the occupied area of the widget
	 */
	Rectangle getBounds();

	/**
	 * Gets any items that are being displayed in the widget.
	 *
	 * @return any items displayed, or null if there are no items
	 */
	Collection<WidgetItem> getWidgetItems();

	/**
	 * Gets a widget item at a specific index.
	 *
	 * @param index index of the item
	 * @return the widget item at index, or null if an item at index
	 * does not exist
	 */
	WidgetItem getWidgetItem(int index);

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
	void setItemId(int itemId);

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
	void setItemQuantity(int quantity);

	/**
	 * Checks whether or not the drawn area of this widget contains
	 * a point on the canvas.
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
	void setScrollX(int scrollX);

	/**
	 * Gets the amount of pixels the widget is scrolled in the Y axis
	 */
	int getScrollY();

	/**
	 * sets the amount of pixels the widget is scrolled in the Y axis
	 */
	void setScrollY(int scrollY);

	/**
	 * Gets the size of the widget's viewport in the X axis
	 */
	int getScrollWidth();

	/**
	 * Sets the size of the widget's viewport in the X axis
	 */
	void setScrollWidth(int width);

	/**
	 * Gets the size of the widget's viewport in the Y axis
	 */
	int getScrollHeight();

	/**
	 * Sets the size of the widget's viewport in the Y axis
	 */
	void setScrollHeight(int height);

	/**
	 * Gets the original x-axis coordinate.
	 *
	 * @return the original coordinate
	 */
	int getOriginalX();

	/**
	 * Sets the original x-axis coordinate.
	 *
	 * @param originalX the new coordinate
	 */
	void setOriginalX(int originalX);

	/**
	 * Gets the original y-axis coordinate.
	 *
	 * @return the original coordinate
	 */
	int getOriginalY();

	/**
	 * Sets the original y-axis coordinate.
	 *
	 * @param originalY the new coordinate
	 */
	void setOriginalY(int originalY);

	/**
	 * Gets the original height of the widget.
	 *
	 * @return the original height
	 */
	int getOriginalHeight();

	/**
	 * Sets the original height of the widget.
	 *
	 * @param originalHeight the original height
	 */
	void setOriginalHeight(int originalHeight);

	/**
	 * Gets the original width of the widget.
	 *
	 * @return the original width
	 */
	int getOriginalWidth();

	/**
	 * Sets the original width of the widget.
	 *
	 * @param originalWidth the original width
	 */
	void setOriginalWidth(int originalWidth);

	/**
	 * Gets the actions available on the widget.
	 *
	 * @return the actions
	 */
	String[] getActions();

	/**
	 * Creates a dynamic widget child
	 *
	 * @param index the index of the new widget in the children list or -1 to append to the back
	 * @param type  the type of the widget
	 */
	Widget createChild(int index, int type);

	/**
	 * Removes all of this widget's dynamic children
	 */
	void deleteAllChildren();

	/**
	 * Creates a menu action on the widget
	 *
	 * @param index  The index of the menu
	 * @param action The string to be displayed next to the widget's name in the context menu
	 */
	void setAction(int index, String action);

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
	 * Sets a script to be ran when the mouse leaves the widget bounds
	 *
	 * @param args A ScriptID, then the args for the script
	 */
	void setOnMouseLeaveListener(Object... args);

	/**
	 * Sets a script to be ran every frame
	 *
	 * @param args A ScriptID, then the args for the script
	 */
	void setOnTimerListener(Object... args);

	/**
	 * If this widget has any listeners on it
	 */
	boolean hasListener();

	/**
	 * Sets if the widget has any listeners. This should be called whenever a setXListener function is called
	 */
	void setHasListener(boolean hasListener);

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
	 * Array of widget key listeners
	 */
	Object[] getOnKeyListener();

	/**
	 * Array of widget load listeners
	 */
	Object[] getOnLoadListener();

	/**
	 * Returns the archive id of the font used
	 */
	int getFontId();

	/**
	 * Sets the archive id of the font
	 */
	void setFontId(int id);

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
	void setTextShadowed(boolean shadowed);

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
	int getItemQuantityMode();

	/**
	 * Sets the widget {@link net.runelite.api.widgets.ItemQuantityMode}
	 */
	void setItemQuantityMode(int itemQuantityMode);

	/**
	 * Gets the mode that the X position is calculated from the original X position
	 *
	 * @see WidgetPositionMode
	 */
	int getXPositionMode();

	/**
	 * Sets the mode that the X position is calculated from the original X position
	 *
	 * @see WidgetPositionMode
	 */
	void setXPositionMode(int xpm);

	/**
	 * Gets the mode that the Y position is calculated from the original Y position
	 *
	 * @see WidgetPositionMode
	 */
	int getYPositionMode();

	/**
	 * Sets the mode that the Y position is calculated from the original Y position
	 *
	 * @see WidgetPositionMode
	 */
	void setYPositionMode(int ypm);

	/**
	 * Gets the X axis text position mode
	 *
	 * @see WidgetTextAlignment
	 */
	int getXTextAlignment();

	/**
	 * Sets the X axis text position mode
	 *
	 * @see WidgetTextAlignment
	 */
	void setXTextAlignment(int xta);

	/**
	 * Gets the Y axis text position mode
	 *
	 * @see WidgetTextAlignment
	 */
	int getYTextAlignment();

	/**
	 * Sets the Y axis text position mode
	 *
	 * @see WidgetTextAlignment
	 */
	void setYTextAlignment(int yta);

	/**
	 * Gets the mode controlling widget width
	 *
	 * @see WidgetSizeMode
	 */
	int getWidthMode();

	/**
	 * Sets the mode controlling widget width
	 *
	 * @see WidgetSizeMode
	 */
	void setWidthMode(int widthMode);

	/**
	 * Gets the mode controlling widget width
	 *
	 * @see WidgetSizeMode
	 */
	int getHeightMode();

	/**
	 * Sets the mode controlling widget width
	 *
	 * @see WidgetSizeMode
	 */
	void setHeightMode(int heightMode);

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
	void setFilled(boolean filled);
}
