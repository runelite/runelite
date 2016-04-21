package net.runelite.deob.clientver;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.Test;

public class ClientVersionTest
{
	@Test
	public void test() throws IOException, URISyntaxException
	{
		File f = new File(ClientVersionTest.class.getResource("/gamepack_v21.jar").toURI());
		ClientVersion ver = new ClientVersion(f);
		System.out.println(ver.getVersion());
	}

}
