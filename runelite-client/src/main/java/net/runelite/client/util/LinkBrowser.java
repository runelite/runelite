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
	private static boolean shouldAttemptXdg = OSType.getOSType() == OSType.Linux;

	/**
	 * Tries to navigate to specified URL in browser. In case operation fails, displays message box with message
	 * and copies link to clipboard to navigate to.
	 *
	 * @param url url to open
	 * @return true if operation was successful
	 */
	public static boolean browse(final String url)
	{
		if (Strings.isNullOrEmpty(url))
		{
			return false;
		}

		if (attemptDesktopBrowse(url))
		{
			log.debug("Opened browser through Desktop#browse to {}", url);
			return true;
		}

		if (shouldAttemptXdg && attemptXdgOpen(url))
		{
			log.debug("Opened browser through xdg-open to {}", url);
			return true;
		}

		showMessageBox("Unable to open link. Press 'OK' and link will be copied to your clipboard.", url);
		return false;
	}

	private static boolean attemptXdgOpen(String url)
	{
		try
		{
			final Process exec = Runtime.getRuntime().exec(new String[]{"xdg-open", url});
			exec.waitFor();

			final int ret = exec.exitValue();
			if (ret == 0)
			{
				return true;
			}

			log.warn("xdg-open {} returned with error code {}", url, ret);
			return false;
		}
		catch (IOException ex)
		{
			// xdg-open not found
			shouldAttemptXdg = false;
			return false;
		}
		catch (InterruptedException ex)
		{
			log.warn("Interrupted while waiting for xdg-open {} to execute", url);
			return false;
		}
	}

	private static boolean attemptDesktopBrowse(String url)
	{
		if (!Desktop.isDesktopSupported())
		{
			return false;
		}

		final Desktop desktop = Desktop.getDesktop();

		if (!desktop.isSupported(Desktop.Action.BROWSE))
		{
			return false;
		}

		try
		{
			desktop.browse(new URI(url));
			return true;
		}
		catch (IOException | URISyntaxException ex)
		{
			log.warn("Failed to open Desktop#browser {}", url, ex);
			return false;
		}
	}

	/**
	 * Open swing message box with specified message and copy data to clipboard
	 *
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
				Clipboard.store(data);
			}
		});
	}
}
