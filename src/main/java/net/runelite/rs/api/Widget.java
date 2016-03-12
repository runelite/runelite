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

	@Import("heigth")
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

	@Import("itemId")
	int getItemId();

	@Import("itemQuantity")
	int getItemQuantity();

	@Import("x")
	int getX();

	@Import("y")
	int getY();
}
