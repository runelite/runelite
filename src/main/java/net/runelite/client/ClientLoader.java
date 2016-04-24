package net.runelite.client;

import java.applet.Applet;
import java.io.IOException;
import java.net.MalformedURLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientLoader
{
	private static final Logger logger = LoggerFactory.getLogger(ClientLoader.class);

	public Applet load() throws MalformedURLException, ClassNotFoundException, IOException, InstantiationException, IllegalAccessException
	{
		ConfigLoader config = new ConfigLoader();

		config.fetch();
		
		String initialClass = config.getProperty(ConfigLoader.INITIAL_CLASS).replace(".class", "");

		Class<?> clientClass = this.getClass().getClassLoader().loadClass(initialClass);
		Applet rs = (Applet) clientClass.newInstance();

		rs.setStub(new RSStub(config, rs));
		
		return rs;
	}
}
