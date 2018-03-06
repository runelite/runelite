package net.runelite.client.ui.overlay.tooltip;

import net.runelite.api.IndexedSprite;

/**
 * Used in conjunction with the TooltipManager
 * to signify that the component uses mod icons.
 */
public interface ModIconReceiver
{
	public void setModIcons(IndexedSprite[] icons);
}
