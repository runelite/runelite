package net.runelite.gamepack;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Downloader
{
	private static final String REPLACE = "%archive%";
	private static final String GAMEPACK_URL = "http://oldschool1.runescape.com/" + REPLACE;

	private static String getGamepackUrl()
	{
		String archive = Checker.getGamePack();
		return archive == null ? "" : GAMEPACK_URL.replace(REPLACE, archive);
	}

	public static String gamepack()
	{
		Path path = Paths.get(System.getProperty("user.home"), "gamepack");
		final File folder = new File(String.valueOf(path));

		if (!folder.exists())
		{
			folder.mkdir();
		}

		downloadLatest(folder);

		return path + File.separator + "gamepack.jar";
	}

	private static void downloadLatest(File folder)
	{
		File output = new File(folder, "gamepack.jar");

		try
		{
			URL url = new URL(getGamepackUrl());

			final URLDownloader downloader = new URLDownloader(url, output);
			downloader.download();

			try
			{
				Thread.sleep(100);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}