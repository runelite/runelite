/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.client;

import java.io.File;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import net.runelite.api.Client;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.overlay.OverlayRenderer;


public class RuneLite
{
	public static final File RUNELITE_DIR = new File(System.getProperty("user.home"), ".runelite");
	public static final File REPO_DIR = new File(RUNELITE_DIR, "repository");

	private static OptionSet options;
	private static Client client;
	private static RuneLite runelite;

	private ClientUI gui;
	private PluginManager pluginManager;
	private OverlayRenderer renderer;

	public static void main(String[] args) throws Exception
	{
		OptionParser parser = new OptionParser();
		parser.accepts("developer-mode");
		options = parser.parse(args);
		
		runelite = new RuneLite();
		runelite.start();
	}

	public void start() throws Exception
	{
		gui = new ClientUI();
		gui.setVisible(true);

		pluginManager = new PluginManager();
		pluginManager.loadAll();

		renderer = new OverlayRenderer();
	}

	public static Client getClient()
	{
		return client;
	}

	public static void setClient(Client client)
	{
		RuneLite.client = client;
	}

	public static RuneLite getRunelite()
	{
		return runelite;
	}

	public PluginManager getPluginManager()
	{
		return pluginManager;
	}

	public OverlayRenderer getRenderer()
	{
		return renderer;
	}

	public static OptionSet getOptions()
	{
		return options;
	}
}
