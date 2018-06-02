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

import com.google.common.base.Strings;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.inject.Singleton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;

/**
 * Utility class used for browser navigation
 */
@Singleton
@Slf4j
public class LinkBrowser
{
	/**
	 * Tries to navigate to specified URL in browser. In case operation fails, displays message box with message
	 * and copies link to clipboard to navigate to.
	 * @param url url to open
	 * @return true if operation was successful
	 */
	public static boolean browse(final String url)
	{
		if (Strings.isNullOrEmpty(url))
		{
			return false;
		}

		if (!Desktop.isDesktopSupported())
		{
			showMessageBox("Desktop is not supported. Press 'OK' and link will be copied to your clipboard.", url);
			return false;
		}

		final Desktop desktop = Desktop.getDesktop();

		if (!desktop.isSupported(Desktop.Action.BROWSE))
		{
			showMessageBox("Desktop browser is not supported. Press 'OK' and link will be copied to your clipboard.", url);
			return false;
		}

		try
		{
			desktop.browse(new URI(url));
			log.debug("Opened browser to {}", url);
			return true;
		}
		catch (IOException | URISyntaxException ex)
		{
			log.warn("Unable to open URL {}. Error: {}", url, ex);
			showMessageBox("Unable to open a URL. Press 'OK' and link will be copied to your clipboard.", url);
			return false;
		}
	}

	/**
	 * Open swing message box with specified message and copy data to clipboard
	 * @param message message to show
	 */
	private static void showMessageBox(final String message, final String data)
	{
		SwingUtilities.invokeLater(() ->
		{
			final int result = JOptionPane.showConfirmDialog(null, message, "Message",
				JOptionPane.OK_CANCEL_OPTION);

			if (result == JOptionPane.OK_OPTION)
			{
				final StringSelection stringSelection = new StringSelection(data);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			}
		});
	}
}
