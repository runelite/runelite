package net.runelite.client;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.awt.Dimension;
import java.net.MalformedURLException;
import java.net.URL;

public class RSStub implements AppletStub
{
	private final ConfigLoader config;
	private final Applet app;
	
	public RSStub(ConfigLoader config, Applet app)
	{
		this.config = config;
		this.app = app;
	}

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
			return new URL(config.getProperty(ConfigLoader.CODEBASE));
		}
		catch (MalformedURLException ex)
		{
			return null;
		}
	}

	@Override
	public String getParameter(String name)
	{
		return config.getAppletProperty(name);
	}

	@Override
	public AppletContext getAppletContext()
	{
		return null;
	}

	@Override
	public void appletResize(int width, int height)
	{
		Dimension d = new Dimension(width, height);

		app.setSize(d);
		app.setPreferredSize(d);
	}
	
}
