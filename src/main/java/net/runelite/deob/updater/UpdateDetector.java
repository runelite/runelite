package net.runelite.deob.updater;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpdateDetector
{
	public static void main(String[] args) throws IOException
	{
		if (args.length < 1)
			System.exit(-1);

		File saveFile = new File(args[0]);
		if (!saveFile.exists())
		{
			GameConfig config = new GameConfig();
			config.fetch();
			save(config, saveFile);
			return;
		}

		GameConfig saved = load(saveFile);

		GameConfig current = new GameConfig();
		current.fetch();

		GameConfigUpdateDetector gcud = new GameConfigUpdateDetector(saved, current);
		boolean updated = gcud.hasUpdated();

		System.exit(updated ? 0 : -1);
	}


	public static void save(GameConfig conf, File f) throws IOException
	{
		try (FileOutputStream fout = new FileOutputStream(f))
		{
			Gson g = new Gson();
			String s = g.toJson(conf);
			fout.write(s.getBytes());
		}
	}

	public static GameConfig load(File f) throws IOException
	{
		try (FileInputStream fin = new FileInputStream(f))
		{
			Gson g = new Gson();
			return g.fromJson(new InputStreamReader(fin), GameConfig.class);
		}
	}

}
