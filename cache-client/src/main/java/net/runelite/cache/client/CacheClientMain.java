package net.runelite.cache.client;

import net.runelite.cache.fs.Store;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.protocol.api.login.HandshakeResponseType;
import org.apache.commons.cli.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CacheClientMain
{
	public static void main(String[] args) throws IOException, ExecutionException, InterruptedException
	{
		Options options = new Options();
		options.addOption("c", "cache", true, "cache base");

		CommandLineParser parser = new DefaultParser();
		CommandLine cmd;
		try
		{
			cmd = parser.parse(options, args);
		}
		catch (ParseException ex)
		{
			System.err.println("Error parsing command line options: " + ex.getMessage());
			System.exit(-1);
			return;
		}

		String cache = cmd.getOptionValue("cache");
		if (cache == null)
		{
			System.err.println("Cache directory must be specified with flag -c");
			System.exit(-1);
			return;
		}


		Store store = new Store(new File(cache));
		store.load();
		CacheClient c = new CacheClient(store, getRsVersion());
		c.connect();
		System.out.println("Connecting");
		CompletableFuture<HandshakeResponseType> handshake = c.handshake();
		HandshakeResponseType result = handshake.get();

		System.out.println("Downloading");
		c.download();

		System.out.println("Saving");
		c.close();
		store.save();

		System.out.println("Cache updated!");
	}

	private static Properties getProperties() throws IOException
	{
		Properties properties = new Properties();
		InputStream resourceAsStream = RuneLiteAPI.class.getResourceAsStream("/runelite.properties");
		properties.load(resourceAsStream);
		return properties;
	}

	public static int getRsVersion() throws IOException
	{
		return Integer.parseInt(getProperties().getProperty("rs.version"));
	}
}
