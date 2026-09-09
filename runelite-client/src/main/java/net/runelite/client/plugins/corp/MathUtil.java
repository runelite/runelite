package net.runelite.client.plugins.corp;

public class MathUtil
{
	private static final double INV_SQRT_TWO = 1 / Math.sqrt(2.0);

	public static double cdf(double mu, double sigma, double z)
	{
		return cdf((z - mu) / sigma);
	}

	public static double cdf(double z)
	{
		if (z < -6 || z > 6)
		{
			return 0;
		}
		return 0.5 * (1 + erf(Math.abs(z) * INV_SQRT_TWO) * (z > 0 ? 1 : -1));
	}

	private static double erf(double x)
	{
		// https://math.stackexchange.com/questions/2185974/integration-of-unintegrable-function/2186054#2186054
		return Math.sqrt(1 - Math.exp(-4 * x * x / Math.PI));
	}
}
