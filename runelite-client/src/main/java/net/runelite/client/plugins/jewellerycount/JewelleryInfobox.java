package net.runelite.client.plugins.jewellerycount;

import java.awt.Color;
import java.awt.image.BufferedImage;
import lombok.Getter;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.infobox.InfoBox;

public class JewelleryInfobox extends InfoBox
{
	private int charges;

	@Getter
	private EquipmentInventorySlot slotID;

	public JewelleryInfobox(BufferedImage image, Plugin plugin, int charges, EquipmentInventorySlot slotID)
	{
		super(image, plugin);

		this.charges = charges;
		this.slotID = slotID;
	}

	@Override
	public String getText()
	{
		return String.valueOf(charges);
	}

	@Override
	public Color getTextColor()
	{
		return Color.WHITE;
	}
}
