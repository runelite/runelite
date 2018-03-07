/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.util;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.util.Enumeration;
import java.util.concurrent.Callable;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.LookAndFeel;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.plaf.FontUIResource;
import lombok.extern.slf4j.Slf4j;

/**
 * Various Swing utilities.
 */
@Slf4j
public class SwingUtil
{
	/**
	 * Sets some sensible defaults for swing.
	 * IMPORTANT! Needs to be called before main frame creation
	 */
	public static void setupDefaults()
	{
		// Force heavy-weight popups/tooltips.
		// Prevents them from being obscured by the game applet.
		ToolTipManager.sharedInstance().setLightWeightPopupEnabled(false);
		JPopupMenu.setDefaultLightWeightPopupEnabled(false);

		// Do not render shadows under popups/tooltips.
		// Fixes black boxes under popups that are above the game applet.
		System.setProperty("jgoodies.popupDropShadowEnabled", "false");

		// Do not fill in background on repaint. Reduces flickering when
		// the applet is resized.
		System.setProperty("sun.awt.noerasebackground", "true");
	}

	/**
	 * Safely sets Swing theme
	 *
	 * @param laf the swing look and feel
	 */
	public static void setTheme(@Nonnull final LookAndFeel laf)
	{
		try
		{
			UIManager.setLookAndFeel(laf);
		}
		catch (UnsupportedLookAndFeelException ex)
		{
			log.warn("Unable to set look and feel", ex);
		}
	}

	/**
	 * Sets default Swing font.
	 * IMPORTANT! Needs to be called before main frame creation
	 *
	 * @param font the new font to use
	 */
	public static void setFont(@Nonnull final Font font)
	{
		final FontUIResource f = new FontUIResource(font);
		final Enumeration keys = UIManager.getDefaults().keys();

		while (keys.hasMoreElements())
		{
			final Object key = keys.nextElement();
			final Object value = UIManager.get(key);

			if (value instanceof FontUIResource)
			{
				UIManager.put(key, f);
			}
		}
	}

	/**
	 * Create tray icon.
	 *
	 * @param icon  the icon
	 * @param title the title
	 * @param frame the frame
	 * @return the tray icon
	 */
	@Nullable
	public static TrayIcon createTrayIcon(@Nonnull final Image icon, @Nonnull final String title, @Nonnull final Frame frame)
	{
		if (!SystemTray.isSupported())
		{
			return null;
		}

		final SystemTray systemTray = SystemTray.getSystemTray();
		final TrayIcon trayIcon = new TrayIcon(icon, title);
		trayIcon.setImageAutoSize(true);

		try
		{
			systemTray.add(trayIcon);
		}
		catch (AWTException ex)
		{
			log.debug("Unable to add system tray icon", ex);
			return trayIcon;
		}

		// Bring to front when tray icon is clicked
		trayIcon.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				frame.setVisible(true);
				frame.setState(Frame.NORMAL); // Restore
			}
		});

		return trayIcon;
	}

	/**
	 * Check if point is in screen bounds.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the boolean
	 */
	public static boolean isInScreenBounds(final int x, final int y)
	{
		final Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		final Rectangle bounds = new Rectangle(size);
		return bounds.contains(x, y);
	}

	/**
	 * Add graceful exit callback.
	 *
	 * @param frame           the frame
	 * @param callback        the callback
	 * @param confirmRequired the confirm required
	 */
	public static void addGracefulExitCallback(@Nonnull final JFrame frame, @Nonnull final Runnable callback, @Nonnull final Callable<Boolean> confirmRequired)
	{
		frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent event)
			{
				int result = JOptionPane.OK_OPTION;

				try
				{
					if (confirmRequired.call())
					{
						result = JOptionPane.showConfirmDialog(
							frame,
							"Are you sure you want to exit?", "Exit",
							JOptionPane .OK_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					}
				}
				catch (Exception e)
				{
					log.warn("Unexpected exception occurred while check for confirm required", e);
				}

				if (result == JOptionPane.OK_OPTION)
				{
					callback.run();
					System.exit(0);
				}
			}
		});
	}

	/**
	 * Revalidate minimum frame size.
	 *
	 * @param frame the frame
	 */
	public static void revalidateMinimumSize(final JFrame frame)
	{
		// The JFrame only respects minimumSize if it was set by setMinimumSize, for some reason. (atleast on windows/native)
		frame.setMinimumSize(frame.getLayout().minimumLayoutSize(frame));
	}

	/**
	 * Create inverted buffered image
	 *
	 * @param image buffered image
	 * @return inverted buffered image
	 */
	public static BufferedImage createInvertedImage(BufferedImage image)
	{
		if (image.getType() != BufferedImage.TYPE_INT_ARGB)
		{
			image = convertToARGB(image);
		}

		final LookupTable lookup = new LookupTable(0, 4)
		{
			@Override
			public int[] lookupPixel(int[] src, int[] dest)
			{
				dest[0] = 255 - src[0];
				dest[1] = 255 - src[1];
				dest[2] = 255 - src[2];
				return dest;
			}
		};

		final LookupOp op = new LookupOp(lookup, new RenderingHints(null));
		return op.filter(image, null);
	}

	/**
	 * Resize buffered image.
	 *
	 * @param image  the image
	 * @param newWidth the new width
	 * @param newHeight the new height
	 * @return the buffered image
	 */
	public static BufferedImage resizeImage(BufferedImage image, int newWidth, int newHeight)
	{
		final Image tmp = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		final BufferedImage dimg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

		final Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		return dimg;
	}

	private static BufferedImage convertToARGB(final BufferedImage image)
	{
		final BufferedImage newImage = new BufferedImage(
			image.getWidth(), image.getHeight(),
			BufferedImage.TYPE_INT_ARGB);

		final Graphics2D g = newImage.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		return newImage;
	}
}
