package net.runelite.client.plugins.prayer;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.client.plugins.itemstats.stats.Stat;
import net.runelite.client.plugins.itemstats.stats.Stats;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.api.ItemID;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Slf4j
public class PrayerPotionAlerterOverlay extends Overlay
{
	private final Client client;
	private final Stat prayer = Stats.PRAYER;
	private BufferedImage prayerPotionImg;

	@Inject
	private PrayerConfig config;

	@Inject
	public PrayerPotionAlerterOverlay(Client client)
	{
		setPosition(OverlayPosition.TOP_RIGHT);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		int prayerLevel = getPrayerLevel();
		int prayerPoints = getPrayerPoints();
		boolean drink = drinkPrayerPotion(prayerLevel, prayerPoints);
		boolean hasPrayerPotion = checkInventoryForPotion();

		if (config.prayerPotionAlerter() && drink && hasPrayerPotion)
		{
			graphics.translate(-100, 15);
			graphics.setColor(new Color(0.2f, 0.2f, 0.2f, 0.5f));
			graphics.fillRect(0, 0, 100, 50);

			graphics.drawImage(getPrayerPotionImage(), null, 14, 7);

			Font dropShadow = FontManager.getRunescapeFont();
			dropShadow = dropShadow.deriveFont(Font.PLAIN, 20);
			graphics.setFont(dropShadow);
			graphics.setColor(new Color(0f, 0f, 0f, 0.6f));
			graphics.drawString("Drink", 53, 35);

			Font drinkFont = FontManager.getRunescapeFont();
			drinkFont = drinkFont.deriveFont(Font.PLAIN, 20);
			graphics.setFont(drinkFont);
			graphics.setColor(new Color(1.0f, 0.03529412f, 0.0f));
			graphics.translate(-0.8, -0.8);
			graphics.drawString("Drink", 53, 35);
		}

		return new Dimension();
	}

	private int getPrayerLevel()
	{
		return prayer.getMaximum(client);
	}

	private int getPrayerPoints()
	{
		return prayer.getValue(client);
	}

	private boolean drinkPrayerPotion(int prayerLevel, int prayerPoints)
	{
		boolean drink = false;
		int prayerPotionRestoreValue = 7;
		double quarterOfPrayerLevel = (0.25) * (double) prayerLevel;

		prayerPotionRestoreValue = prayerPotionRestoreValue + (int) quarterOfPrayerLevel;

		if (prayerPoints < (prayerLevel - prayerPotionRestoreValue))
		{
			drink = true;
		}

		return drink;
	}

	private boolean checkInventoryForPotion()
	{
		ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
		Item[] inventoryItems;
		boolean hasPrayerPotion = false;

		int[] potionID = {ItemID.PRAYER_POTION1, ItemID.PRAYER_POTION2, ItemID.PRAYER_POTION3, ItemID.PRAYER_POTION4, ItemID.PRAYER_POTION1_20396, ItemID.PRAYER_POTION2_20395,
				ItemID.PRAYER_POTION3_20394, ItemID.PRAYER_POTION4_20393, ItemID.PRAYER_MIX1, ItemID.PRAYER_MIX2, ItemID.SUPER_RESTORE1, ItemID.SUPER_RESTORE2,
				ItemID.SUPER_RESTORE3, ItemID.SUPER_RESTORE4, ItemID.SUPER_RESTORE_MIX1, ItemID.SUPER_RESTORE_MIX2};

		if (inventory != null)
		{
			inventoryItems = inventory.getItems();
			for (Item item : inventoryItems)
			{
				for (int prayerPotionId : potionID)
				{
					if (item.getId() == prayerPotionId)
					{
						hasPrayerPotion = true;
					}
				}
			}
		}

		return hasPrayerPotion;
	}

	private BufferedImage getPrayerPotionImage()
	{
		if (prayerPotionImg == null)
		{
			String path = "/prayers/prayer_potion.png";
			prayerPotionImg = getImage(path);
		}

		prayerPotionImg = resize(prayerPotionImg);

		return prayerPotionImg;
	}

	private BufferedImage getImage(String path)
	{
		BufferedImage image = null;
		try
		{
			synchronized (ImageIO.class)
			{
				image = ImageIO.read(PrayerPotionAlerterOverlay.class.getResourceAsStream(path));
			}
		}
		catch (IOException e)
		{
			log.warn("Error fetching image" , e);
		}
		return image;
	}

	private static BufferedImage resize(BufferedImage img)
	{
		int width = 26;
		int height = 37;
		Image temp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		BufferedImage newImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = newImg.createGraphics();
		g2d.drawImage(temp, 0, 0, null);
		g2d.dispose();

		return newImg;
	}
}
