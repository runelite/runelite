package net.runelite.cache.fs.util;

import java.util.zip.CRC32;

public final class CRC32HGenerator
{
	public static final CRC32 CRC32Instance = new CRC32();

	public static int getHash(byte[] data, int len)
	{
		synchronized (CRC32Instance)
		{
			CRC32Instance.update(data, 0, len);
			int hash = (int) CRC32Instance.getValue();
			CRC32Instance.reset();
			return hash;
		}
	}
}
