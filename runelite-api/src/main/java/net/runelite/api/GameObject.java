package net.runelite.api;

import java.awt.Shape;
import net.runelite.api.coords.Angle;

/**
 * Represents a game object.
 * <p>
 * Most object in the RuneScape world are considered as game objects. Things
 * such as trees, anvils, boxes, etc are all game objects.
 */
public interface GameObject extends TileObject
{

	/**
	 * Gets the minimum x and y scene coordinate pair for this game object.
	 *
	 * @return the minimum scene coordinate
	 */
	Point getSceneMinLocation();

	/**
	 * Gets the maximum x and y scene coordinate pair for this game object.
	 * <p>
	 * This value differs from {@link #getSceneMinLocation()} when the size
	 * of the object is more than 1 tile.
	 *
	 * @return the maximum scene coordinate
	 */
	Point getSceneMaxLocation();

	/**
	 * Gets the convex hull of the object's model.
	 *
	 * @return the convex hull
	 * @see //net.runelite.api.model.Jarvis
	 */
	Shape getConvexHull();

	/**
	 * Gets the orientation of the object.
	 *
	 * @return the orientation
	 */
	Angle getOrientation();

	Entity getEntity();

	int getRsOrientation();

	Model getModel();

	Renderable getRenderable();
}