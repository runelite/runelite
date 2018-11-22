package net.runelite.client.plugins.bosslog;

import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.text.NumberFormat;
import java.util.Locale;

class BossLogDropBox extends JPanel
{
	private int alpha = 255;

	BossLogDropBox(ItemManager itemManager, BossLogItem item, boolean isUnique)
	{
		setBackground(ColorScheme.DARKER_GRAY_COLOR);
		setMaximumSize(new Dimension(45, 42));
		setPreferredSize(new Dimension(45, 42));

		JLabel iconLabel = new JLabel();
		iconLabel.setToolTipText(buildToolTip(item));
		iconLabel.setIcon(new ImageIcon());
		AsyncBufferedImage icon;
		if (isUnique && item.getQuantity() == 0)
		{
			icon = itemManager.getImage(item.getId());
			alpha = 75;
			Runnable alphasize = () ->
			{
				BufferedImage subIcon = setAlpha((byte) alpha, deepCopy(icon));
				iconLabel.setIcon(new ImageIcon(subIcon));
			};
			icon.onChanged(alphasize);
			alphasize.run();
		}
		else
		{
			icon = itemManager.getImage(item.getId(), item.getQuantity(), item.getQuantity() > 0);
			icon.addTo(iconLabel);
		}
		add(iconLabel);
	}

	private static String buildToolTip(BossLogItem item)
	{
		final String name = item.getName();
		final int quantity = item.getQuantity();
		final long price = item.getPrice();
		return name + " x " + quantity + " ("
				+ NumberFormat.getNumberInstance(Locale.US).format(price * quantity) + ") ";
	}

	private BufferedImage setAlpha(byte alpha, BufferedImage img)
	{
		alpha %= 0xff;
		for (int cx = 0;cx < img.getWidth(); cx++)
		{
			for (int cy = 0; cy < img.getHeight(); cy++)
			{
				int color = img.getRGB(cx, cy);
				int mc = (alpha << 24) | 0x00ffffff;
				int newcolor = color & mc;
				img.setRGB(cx, cy, newcolor);
			}
		}
		return img;
	}

	static BufferedImage deepCopy(BufferedImage bi)
	{
		ColorModel cm = bi.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = bi.copyData(null);
		return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}
}
