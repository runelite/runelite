package net.runelite.client.ui.tweenengine;

/**
 * Base class for every easing equation. You can create your own equations
 * and directly use them in the Tween engine by inheriting from this class.
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 * @see Tween
 */
public abstract class TweenEquation
{

	/**
	 * Computes the next value of the interpolation.
	 *
	 * @param t The current time, between 0 and 1.
	 * @return The current value.
	 */
	public abstract float compute(float t);

	/**
	 * Returns true if the given string is the name of this equation (the name
	 * is returned in the toString() method, don't forget to override it).
	 * This method is usually used to save/load a tween to/from a text file.
	 */
	public boolean isValueOf(String str)
	{
		return str.equals(toString());
	}
}
