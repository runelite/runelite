package net.runelite.deob.clientver;

import java.io.File;
import java.io.IOException;

public class ClientVersionMain
{
	public static void main(String[] args) throws IOException
	{
		File jar = new File(args[0]);
		ClientVersion cv = new ClientVersion(jar);
		System.out.println(cv.getVersion());
	}
}
