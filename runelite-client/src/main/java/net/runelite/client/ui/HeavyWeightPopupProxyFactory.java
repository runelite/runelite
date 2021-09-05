package net.runelite.client.ui;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.client.util.OSType;

@Slf4j
public class HeavyWeightPopupProxyFactory extends PopupFactory
{

	private static final HeavyWeightPopupProxyFactory INSTANCE = new HeavyWeightPopupProxyFactory();

	private HeavyWeightPopupProxyFactory()
	{
	}

	private static Method setPopupType = null;
	private static int heavyweightPopupType = -1;

	private PopupFactory backingFactory;

	@Override
	public Popup getPopup(Component owner, Component contents, int x, int y) throws IllegalArgumentException
	{
		// force heavyweight to render over canvas
		if (setPopupType != null && heavyweightPopupType != -1)
		{
			try
			{
				setPopupType.invoke(heavyweightPopupType);
			}
			catch (IllegalAccessException | InvocationTargetException e)
			{
				log.error("Failed to invoke setPopupType on tooltip", e);
			}
		}

		return backingFactory.getPopup(owner, contents, x, y);
	}

	public static void install()
	{
		if (OSType.getOSType() != OSType.MacOS)
		{
			log.debug("Skipping installation of ");
			return;
		}

		// inject proxy factory if it has not yet been done
		PopupFactory backingFactory = PopupFactory.getSharedInstance();
		if (!(backingFactory instanceof HeavyWeightPopupProxyFactory))
		{
			INSTANCE.backingFactory = backingFactory;
			PopupFactory.setSharedInstance(INSTANCE);
		}

		// locate PopupFactory.setPopupType internal method via reflection
		if (setPopupType == null)
		{
			try
			{
				setPopupType = PopupFactory.class.getDeclaredMethod("setPopupType", int.class);
				setPopupType.setAccessible(true);
			}
			catch (NoSuchMethodException e)
			{
				log.error("Failed to locate setPopupType method. Cannot force heavyweight tooltips.", e);
			}
		}

		// locate parameter value for setPopupType, HEAVY_WEIGHT_POPUP
		if (heavyweightPopupType == -1)
		{
			try
			{
				Field heavyweightPopupTypeField = PopupFactory.class.getDeclaredField("HEAVY_WEIGHT_POPUP");
				heavyweightPopupTypeField.setAccessible(true);
				heavyweightPopupType = (int) heavyweightPopupTypeField.get(null);
			}
			catch (NoSuchFieldException | IllegalAccessException e)
			{
				log.warn("Failed to locate HEAVY_WEIGHT_POPUP field value. Falling back to static value 2.", e);
				heavyweightPopupType = 2;
			}
		}
	}
}
