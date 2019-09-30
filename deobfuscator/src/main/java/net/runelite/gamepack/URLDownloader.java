package net.runelite.gamepack;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

class URLDownloader
{
	private URL url;
	private File output;

	URLDownloader(URL url, File output)
	{
		this.url = url;
		this.output = output;
	}

	void download() throws IOException
	{
		this.downloadFromURL();
	}

	private void downloadFromURL() throws IOException
	{
		ReadableByteChannel rbc = Channels.newChannel(url.openStream());
		FileOutputStream fos = new FileOutputStream(output);

		FileChannel channel = fos.getChannel();
		channel.transferFrom(rbc, 0, Long.MAX_VALUE);
	}
}