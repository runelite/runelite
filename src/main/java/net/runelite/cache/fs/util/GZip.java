package net.runelite.cache.fs.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import net.runelite.cache.fs.io.Stream;

public class GZip {
	private static final Inflater inflaterInstance = new Inflater(true);

	public static final byte[] compress(byte[] data)
	{
		ByteArrayOutputStream compressedBytes = new ByteArrayOutputStream();

		try
		{
			GZIPOutputStream e = new GZIPOutputStream(compressedBytes);
			e.write(data);
			e.finish();
			e.close();
			return compressedBytes.toByteArray();
		}
		catch (IOException var3)
		{
			var3.printStackTrace();
			return null;
		}
	}

	public static final void decompress(Stream stream, byte[] data)
	{
		Inflater var2 = inflaterInstance;
		synchronized (inflaterInstance)
		{
			if (stream.getBuffer()[stream.getOffset()] == 31 && stream.getBuffer()[stream.getOffset() + 1] == -117)
			{
				try
				{
					inflaterInstance.setInput(stream.getBuffer(), stream.getOffset() + 10, -stream.getOffset() - 18 + stream.getBuffer().length);
					inflaterInstance.inflate(data);
				}
				catch (Exception var4)
				{
					inflaterInstance.reset();
					data = (byte[]) null;
				}

				inflaterInstance.reset();
			}
			else
			{
				data = (byte[]) null;
			}
		}
	}
}
