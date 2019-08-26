package net.runelite.client.util.bootstrap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;

public class Bootstrapper
{

	public static String remoteLocation;
	public static String localLocation;

	public static void main(boolean staging)
	{

		if (staging)
		{
			remoteLocation = "staging/";
			localLocation = "./staging/";
			Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
			File dir = new File("./staging/");
			dir.mkdir();
			try (FileWriter fw = new FileWriter("./staging/bootstrap-staging.json"))
			{
				gson.toJson(new Bootstrap(), fw);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			remoteLocation = "live/";
			localLocation = "./live/";
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
}
