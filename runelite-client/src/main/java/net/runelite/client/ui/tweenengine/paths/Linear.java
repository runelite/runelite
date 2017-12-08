package net.runelite.client.ui.tweenengine.paths;

import net.runelite.client.ui.tweenengine.TweenPath;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class Linear implements TweenPath
{
	@Override
	public float compute(float t, float[] points, int pointsCnt)
	{
		int segment = (int) Math.floor((pointsCnt - 1) * t);
		segment = Math.max(segment, 0);
		segment = Math.min(segment, pointsCnt - 2);

		t = t * (pointsCnt - 1) - segment;

		return points[segment] + t * (points[segment + 1] - points[segment]);
	}
}
