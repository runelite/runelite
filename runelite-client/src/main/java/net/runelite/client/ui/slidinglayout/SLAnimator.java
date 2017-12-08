package net.runelite.client.ui.slidinglayout;


import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenAccessor;
import aurelienribon.tweenengine.TweenManager;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class SLAnimator
{
	private static final List<TweenManager> tweenManagers = new ArrayList<>();
	private static boolean running = false;

	static
	{
		ComponentAccessor accessor = new ComponentAccessor();
		Tween.registerAccessor(JComponent.class, accessor);
		Tween.registerAccessor(JFrame.class, accessor);
		Tween.setCombinedAttributesLimit(4);
	}

	public static TweenManager createTweenManager()
	{
		TweenManager tm = new TweenManager();
		tweenManagers.add(tm);
		return tm;
	}

	public static void start()
	{
		running = true;

		Runnable runnable = () ->
		{
			long lastMillis = System.currentTimeMillis();
			long deltaLastMillis = System.currentTimeMillis();

			while (running)
			{
				long newMillis = System.currentTimeMillis();
				long sleep = 15 - (newMillis - lastMillis);
				lastMillis = newMillis;

				if (sleep > 1) try
				{
					Thread.sleep(sleep);
				}
				catch (InterruptedException ignored)
				{
				}

				long deltaNewMillis = System.currentTimeMillis();
				final float delta = (deltaNewMillis - deltaLastMillis) / 1000f;

				try
				{
					SwingUtilities.invokeAndWait(() ->
					{
						for (TweenManager tweenManager : tweenManagers) tweenManager.update(delta);
					});
				}
				catch (InterruptedException | InvocationTargetException ignored)
				{
				}

				deltaLastMillis = newMillis;
			}
		};

		new Thread(runnable).start();
	}

	public static void stop()
	{
		running = false;
	}

	// -------------------------------------------------------------------------
	// Accessors
	// -------------------------------------------------------------------------

	public static class ComponentAccessor implements TweenAccessor<Component>
	{
		public static final int X = 1;
		public static final int Y = 2;
		public static final int XY = 3;
		public static final int W = 4;
		public static final int H = 5;
		public static final int WH = 6;
		public static final int XYWH = 7;

		@Override
		public int getValues(Component target, int tweenType, float[] returnValues)
		{
			switch (tweenType)
			{
				case X:
					returnValues[0] = target.getX();
					return 1;
				case Y:
					returnValues[0] = target.getY();
					return 1;
				case XY:
					returnValues[0] = target.getX();
					returnValues[1] = target.getY();
					return 2;
				case W:
					returnValues[0] = target.getWidth();
					return 1;
				case H:
					returnValues[0] = target.getHeight();
					return 1;
				case WH:
					returnValues[0] = target.getWidth();
					returnValues[1] = target.getHeight();
					return 2;
				case XYWH:
					returnValues[0] = target.getX();
					returnValues[1] = target.getY();
					returnValues[2] = target.getWidth();
					returnValues[3] = target.getHeight();
					return 4;
				default:
					return -1;
			}
		}

		@Override
		public void setValues(Component target, int tweenType, float[] newValues)
		{
			switch (tweenType)
			{
				case X:
					target.setLocation(Math.round(newValues[0]), target.getY());
					break;
				case Y:
					target.setLocation(target.getX(), Math.round(newValues[0]));
					break;
				case XY:
					target.setLocation(Math.round(newValues[0]), Math.round(newValues[1]));
					break;
				case W:
					target.setSize(Math.round(newValues[0]), target.getHeight());
					target.setMinimumSize(new Dimension(Math.round(newValues[0]), target.getHeight()));
					target.validate();
					break;
				case H:
					target.setSize(target.getWidth(), Math.round(newValues[0]));
					target.validate();
					break;
				case WH:
					target.setSize(Math.round(newValues[0]), Math.round(newValues[1]));
					target.validate();
					break;
				case XYWH:
					target.setBounds(Math.round(newValues[0]), Math.round(newValues[1]), Math.round(newValues[2]), Math.round(newValues[3]));
					target.validate();
					break;
			}
		}
	}
}
