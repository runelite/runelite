/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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

import com.apple.eawt.Application;
import com.apple.eawt.FullScreenUtilities;
import javax.swing.JFrame;
import lombok.extern.slf4j.Slf4j;

/**
 * A class with OSX-specific functions to improve integration.
 */
@Slf4j
public class OSXUtil
{
	/**
	 * Enables the osx native fullscreen if running on a Mac.
	 *
	 * @param gui The gui to enable the fullscreen on.
	 */
	public static void tryEnableFullscreen(JFrame gui)
	{
		if (OSType.getOSType() == OSType.MacOS)
		{
			OSXFullScreenAdapter.install(gui);
			FullScreenUtilities.setWindowCanFullScreen(gui, true);
			log.debug("Enabled fullscreen on macOS");
		}
	}

	/**
	 * Request user attention on macOS
	 */
	public static void requestUserAttention()
	{
		Application app = Application.getApplication();
		app.requestUserAttention(true);
		log.debug("Requested user attention on macOS");
	}

	/**
	 * Requests the foreground in a macOS friendly way.
	 */
	public static void requestForeground()
	{
		Application app = Application.getApplication();
		app.requestForeground(true);
		log.debug("Forced focus on macOS");
	}
}
