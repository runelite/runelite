package net.runelite.client.ui.tweenengine;

import net.runelite.client.ui.tweenengine.paths.CatmullRom;
import net.runelite.client.ui.tweenengine.paths.Linear;

/**
 * Collection of built-in paths.
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public interface TweenPaths
{
	Linear linear = new Linear();
	CatmullRom catmullRom = new CatmullRom();
}
