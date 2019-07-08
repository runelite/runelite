package net.runelite.client.util.bootstrap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;

public class Bootstrapper
{

	public static void main(String[] args)
	{
		Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
		File dir = new File("./live/");
		dir.mkdir();
		try (FileWriter fw = new FileWriter("./live/bootstrap.json"))
		{
			gson.toJson(new Bootstrap(), fw);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
