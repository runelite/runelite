/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.rs;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.applet.AudioClip;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import javax.swing.SwingUtilities;
import lombok.RequiredArgsConstructor;
import net.runelite.client.RuntimeConfig;
import net.runelite.client.RuntimeConfigLoader;
import net.runelite.client.ui.FatalErrorDialog;

@RequiredArgsConstructor
class RSAppletStub implements AppletStub
{
	private final RSConfig config;
	private final RuntimeConfigLoader runtimeConfigLoader;

	@Override
	public boolean isActive()
	{
		return true;
	}

	@Override
	public URL getDocumentBase()
	{
		return getCodeBase();
	}

	@Override
	public URL getCodeBase()
	{
		try
		{
			return new URL(config.getCodeBase());
		}
		catch (MalformedURLException ex)
		{
			return null;
		}
	}

	@Override
	public String getParameter(String name)
	{
		return config.getAppletProperties().get(name);
	}

	@Override
	public AppletContext getAppletContext()
	{
		return new AppletContext()
		{
			@Override
			public AudioClip getAudioClip(URL url)
			{
				return null;
			}

			@Override
			public Image getImage(URL url)
			{
				return null;
			}

			@Override
			public Applet getApplet(String name)
			{
				return null;
			}

			@Override
			public Enumeration<Applet> getApplets()
			{
				return null;
			}

			@Override
			public void showDocument(URL url)
			{
				if (url.getPath().startsWith("/error_game_"))
				{
					try
					{
						RuntimeConfig rtc = runtimeConfigLoader.get();
						if (rtc.showOutageMessage())
						{
							return;
						}
					}
					catch (Exception e)
					{
					}

					String code = url.getPath()
						.replace("/", "")
						.replace(".ws", "");

					SwingUtilities.invokeLater(() ->
						new FatalErrorDialog("OldSchool RuneScape has crashed with the message: " + code + "")
							.setTitle("RuneLite", "OldSchool RuneScape has crashed")
							.addHelpButtons()
							.open());
				}
			}

			@Override
			public void showDocument(URL url, String target)
			{
				showDocument(url);
			}

			@Override
			public void showStatus(String status)
			{
			}

			@Override
			public void setStream(String key, InputStream stream) throws IOException
			{
			}

			@Override
			public InputStream getStream(String key)
			{
				return null;
			}

			@Override
			public Iterator<String> getStreamKeys()
			{
				return null;
			}
		};
	}

	@Override
	public void appletResize(int width, int height)
	{
	}
}