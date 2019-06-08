package net.runelite.api;

/**
 * Represents a widget as an iterable node.
 */
public interface WidgetNode extends Node
{
	/**
	 * The ID of the widget.
	 *
	 * @return the ID of the widget
	 * @see net.runelite.api.widgets.Widget
	 */
	int getId();
}
