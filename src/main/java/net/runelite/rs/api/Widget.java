package net.runelite.rs.api;

public interface Widget
{
	Widget getParent();

	int[][] getDynamicValues();

	Widget[] getChildren();

	int getId();

	int getParentId();

	int getBoundsIndex();

	int getModelId();

	int[] getItemIds();

	int[] getItemQuantities();

	int getModelType();

	String[] getActions();

	String getText();

	String getName();

	int getTextColor();

	int getOpacity();

	int getRelativeX();

	int getRelativeY();

	int getWidth();

	int getHeight();

	boolean isHidden();

	int getIndex();

	int getRotationX();

	int getRotationY();

	int getRotationZ();

	int getContentType();

	int getType();

	int getScrollX();

	int getScrollY();

	int getTextureId();

	int getBorderThickness();

	int getItemId();

	int getItemQuantity();

	int getX();

	int getY();
}
