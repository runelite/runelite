/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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

package net.runelite.client;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import java.io.File;
import java.awt.TrayIcon;
import java.awt.SystemTray;
import java.awt.Image;
import java.awt.Toolkit;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import net.runelite.api.Client;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.overlay.OverlayRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RuneLite
{
	private static final Logger logger = LoggerFactory.getLogger(RuneLite.class);

	public static final File RUNELITE_DIR = new File(System.getProperty("user.home"), ".runelite");
	public static final File REPO_DIR = new File(RUNELITE_DIR, "repository");

	private static OptionSet options;
	private static Client client;
	private static RuneLite runelite;

	private TrayIcon icon;
	private SystemTray tray;
	private Image trayIconImage;

	private ClientUI gui;
	private PluginManager pluginManager;
	private OverlayRenderer renderer;
	private EventBus eventBus = new EventBus(this::eventExceptionHandler);

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

		if(SystemTray.isSupported())
		{
			trayIconImage = Toolkit.getDefaultToolkit().getImage("trayIcon.jpg");
			tray = SystemTray.getSystemTray();
			icon = new TrayIcon(trayIconImage, "RuneLite");
			icon.setImageAutoSize(true);
			tray.add(icon);
		}
		pluginManager = new PluginManager(this);
		pluginManager.loadAll();

		renderer = new OverlayRenderer();
	}

	private void eventExceptionHandler(Throwable exception, SubscriberExceptionContext context)
	{
		logger.warn("uncaught exception in event subscriber", exception);
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

	public ClientUI getGui()
	{
		return gui;
	}

	public PluginManager getPluginManager()
	{
		return pluginManager;
	}

	public OverlayRenderer getRenderer()
	{
		return renderer;
	}

	public EventBus getEventBus()
	{
		return eventBus;
	}

	public static OptionSet getOptions()
	{
		return options;
	}

	public TrayIcon getIcon()
	{
		return icon;
	}
}
