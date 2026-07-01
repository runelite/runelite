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

import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.SwingUtilities;
import lombok.RequiredArgsConstructor;
import net.runelite.api.ClientConfiguration;
import net.runelite.client.RuntimeConfig;
import net.runelite.client.RuntimeConfigLoader;
import net.runelite.client.ui.FatalErrorDialog;
import net.runelite.client.util.LinkBrowser;

@RequiredArgsConstructor
class RSAppletStub implements ClientConfiguration
{
	private final RSConfig config;
	private final RuntimeConfigLoader runtimeConfigLoader;

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
	public void onError(String code)
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

		if (code.equals("error_game_js5connect"))
		{
			SwingUtilities.invokeLater(() ->
				new FatalErrorDialog("RuneLite is unable to connect to the RuneScape update server. " +
					"RuneScape might be offline for an update, check the game status page. If the game " +
					"is online, then either a firewall is blocking RuneLite, or you don't have internet access.")
					.setTitle("RuneLite", "Unable to connect to update server")
					.addButton("Game Status", () -> LinkBrowser.browse("https://secure.runescape.com/m=news/game-status-information-centre?oldschool=1"))
					.open());
		}
		else if (code.equals("error_game_js5io"))
		{
			SwingUtilities.invokeLater(() ->
				new FatalErrorDialog("OldSchool RuneScape is unable to retrieve updates from its update server. " +
					"This is likely due to a firewall blocking the RuneScape server. Try disabling your firewall, or use " +
					"a different network.")
					.setTitle("RuneLite", "Unable to connect to update server")
					.addHelpButtons()
					.open());
		}
		else if (code.equals("error_game_crash"))
		{
			SwingUtilities.invokeLater(() ->
				new FatalErrorDialog("OldSchool RuneScape has crashed. Crashes are most commonly caused by plugin hub plugins, " +
					"but can also be caused by RuneLite or Jagex client bugs. If you receive this message commonly, try playing in " +
					"safe mode to eliminate the potential of plugins causing the crash. The client log file will contain additional " +
					"information about the crash.")
					.setTitle("RuneLite", "OldSchool RuneScape has crashed")
					.addHelpButtons()
					.open());
		}
		else
		{
			SwingUtilities.invokeLater(() ->
				new FatalErrorDialog("OldSchool RuneScape has crashed with the message: " + code)
					.setTitle("RuneLite", "OldSchool RuneScape has crashed")
					.addHelpButtons()
					.open());
		}
	}
}