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

import java.applet.AppletContext;
import java.applet.AppletStub;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import lombok.RequiredArgsConstructor;
import net.runelite.client.RuneLite;
import net.runelite.client.util.StringFileUtils;

@RequiredArgsConstructor
class RSAppletStub implements AppletStub
{
	private final RSConfig config;

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
			if (RuneLite.allowPrivateServer)
			{
				File f = new File(RuneLite.RUNELITE_DIR + "/codebase");
				if (!f.exists())
				{
					StringFileUtils.writeStringToFile(f.getAbsolutePath(), "http://127.0.0.1");
				}
				return new URL(StringFileUtils.readStringFromFile(f.getAbsolutePath()));
			}

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
		return null;
	}

	@Override
	public void appletResize(int width, int height)
	{
	}
}