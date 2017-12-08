package net.runelite.client.ui.tweenengine;

/**
 * Base class for every paths. You can create your own paths and directly use
 * them in the Tween engine by inheriting from this class.
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public interface TweenPath
{

	/**
	 * Computes the next value of the interpolation, based on its waypoints and
	 * the current progress.
	 *
	 * @param t         The progress of the interpolation, between 0 and 1. May be out
	 *                  of these bounds if the easing equation involves some kind of rebounds.
	 * @param points    The waypoints of the tween, from start to target values.
	 * @param pointsCnt The number of valid points in the array.
	 * @return The next value of the interpolation.
	 */
	float compute(float t, float[] points, int pointsCnt);
}
