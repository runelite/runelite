package net.runelite.cache.fs.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BZip2
{
	private static final Logger logger = LoggerFactory.getLogger(BZip2.class);

	private static final byte[] BZIP_HEADER = new byte[] {
		'B', 'Z', // magic
		'h',      // 'h' for Bzip2 ('H'uffman coding)
		'1'       // block size
	};
	
	public static byte[] compress(byte[] bytes)
	{
		try
		{
			InputStream is = new ByteArrayInputStream(bytes);
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			try (OutputStream os = new BZip2CompressorOutputStream(bout))
			{
				IOUtils.copy(is, os);
			}

			byte[] out = bout.toByteArray();
			return Arrays.copyOfRange(out, BZIP_HEADER.length, out.length); // remove header..
		}
		catch (IOException ex)
		{
			logger.warn(null, ex);
			return null;
		}
	}

	public static byte[] decompress(byte[] bytes)
	{
		try
		{
			byte[] data = new byte[bytes.length + BZIP_HEADER.length];

			// add header
			System.arraycopy(BZIP_HEADER, 0, data, 0, BZIP_HEADER.length);
			System.arraycopy(bytes, 0, data, BZIP_HEADER.length, bytes.length);

			ByteArrayOutputStream os = new ByteArrayOutputStream();

			try (InputStream is = new BZip2CompressorInputStream(new ByteArrayInputStream(data)))
			{
				IOUtils.copy(is, os);
			}

			return os.toByteArray();
		}
		catch (IOException ex)
		{
			logger.warn(null, ex);
			return null;
		}
	}
}
