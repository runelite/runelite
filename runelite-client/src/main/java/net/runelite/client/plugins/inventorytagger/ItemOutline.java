package net.runelite.client.plugins.inventorytagger;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import net.runelite.api.Client;
import net.runelite.api.SpritePixels;

class ItemOutline
{
	private final BufferedImage image = new BufferedImage(36, 36, BufferedImage.TYPE_INT_ARGB);

	public static Map<String, BufferedImage> storedOutlines = new HashMap<>();
	private final int id;
	private final int stroke;
	private final Color color;
	private final Client client;

	public ItemOutline(Client client, int id, int stroke, Color color)
	{
		this.id = id;
		this.stroke = stroke;
		this.color = color;
		this.client = client;
	}

	private String getStringGeneratedId()
	{
		return this.id + "." + this.stroke + "." + this.color.getRGB();
	}

	public BufferedImage getPicture()
	{
		if (storedOutlines.containsKey(getStringGeneratedId()))
		{
			return storedOutlines.get(getStringGeneratedId());
		}

		SpritePixels itemSprite = client.createItemSprite(id, 1, this.stroke, 0, 0, true, 710);
		itemSprite.setOutline(16777215);

		Graphics2D graphics2D = image.createGraphics();
		graphics2D.setColor(color);
		int x = 0;
		int y = 0;
		for (int ddsd : itemSprite.getPixels())
		{
			if (x == 36)
			{
				y++;
				x = 0 ;
			}

			if (ddsd == 16777215)
			{
				graphics2D.drawLine(x, y, x, y);
			}

			x++;
		}
		storedOutlines.put(getStringGeneratedId(), this.image);
		return this.image;
	}
}
