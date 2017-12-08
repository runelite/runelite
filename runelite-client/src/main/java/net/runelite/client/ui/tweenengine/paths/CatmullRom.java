package net.runelite.client.ui.tweenengine.paths;

import net.runelite.client.ui.tweenengine.TweenPath;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class CatmullRom implements TweenPath
{
	@Override
	public float compute(float t, float[] points, int pointsCnt)
	{
		int segment = (int) Math.floor((pointsCnt - 1) * t);
		segment = Math.max(segment, 0);
		segment = Math.min(segment, pointsCnt - 2);

		t = t * (pointsCnt - 1) - segment;

		if (segment == 0)
		{
			return catmullRomSpline(points[0], points[0], points[1], points[2], t);
		}

		if (segment == pointsCnt - 2)
		{
			return catmullRomSpline(points[pointsCnt - 3], points[pointsCnt - 2], points[pointsCnt - 1], points[pointsCnt - 1], t);
		}

		return catmullRomSpline(points[segment - 1], points[segment], points[segment + 1], points[segment + 2], t);
	}

	private float catmullRomSpline(float a, float b, float c, float d, float t)
	{
		float t1 = (c - a) * 0.5f;
		float t2 = (d - b) * 0.5f;

		float h1 = +2 * t * t * t - 3 * t * t + 1;
		float h2 = -2 * t * t * t + 3 * t * t;
		float h3 = t * t * t - 2 * t * t + t;
		float h4 = t * t * t - t * t;

		return b * h1 + c * h2 + t1 * h3 + t2 * h4;
	}
}
