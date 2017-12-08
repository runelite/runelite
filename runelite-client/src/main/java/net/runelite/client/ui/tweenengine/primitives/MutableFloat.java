package net.runelite.client.ui.tweenengine.primitives;

import net.runelite.client.ui.tweenengine.TweenAccessor;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class MutableFloat extends Number implements TweenAccessor<MutableFloat>
{
	private float value;

	public MutableFloat(float value)
	{
		this.value = value;
	}

	public void setValue(float value)
	{
		this.value = value;
	}

	@Override
	public int intValue() {return (int) value;}

	@Override
	public long longValue() {return (long) value;}

	@Override
	public float floatValue() {return (float) value;}

	@Override
	public double doubleValue() {return (double) value;}

	@Override
	public int getValues(MutableFloat target, int tweenType, float[] returnValues)
	{
		returnValues[0] = target.value;
		return 1;
	}

	@Override
	public void setValues(MutableFloat target, int tweenType, float[] newValues)
	{
		target.value = newValues[0];
	}
}
