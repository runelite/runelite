package net.runelite.client.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StringFileUtils
{
	//Read file content into string with - Files.readAllBytes(Path path)

	public static String readStringFromFile(String filePath)
	{
		String content = "";

		try
		{
			content = new String(Files.readAllBytes(Paths.get(filePath)));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return content;
	}

	public static void writeStringToFile(String file, String string)
	{
		File f = new File(file);
		if (!f.exists())
		{
			try
			{
				f.createNewFile();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		try (PrintWriter out = new PrintWriter(file))
		{
			out.println(string);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}