/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.cache.updater;

import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
import io.minio.MinioClient;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidArgumentException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.NoResponseException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import net.runelite.cache.fs.Archive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xmlpull.v1.XmlPullParserException;

public class CacheUploader implements Runnable
{
	private static final Logger logger = LoggerFactory.getLogger(CacheUploader.class);

	private final MinioClient minioClient;
	private final String minioBucket;
	private final Archive archive;
	private final byte[] data;

	public CacheUploader(MinioClient minioClient, String minioBucket, Archive archive, byte[] data)
	{
		this.minioClient = minioClient;
		this.minioBucket = minioBucket;
		this.archive = archive;
		this.data = data;
	}

	@Override
	public void run()
	{
		byte[] hash = Hashing.sha256().hashBytes(data).asBytes();
		String hashStr = BaseEncoding.base16().encode(hash);

		archive.setHash(hash);

		String path = new StringBuilder()
			.append(hashStr, 0, 2)
			.append('/')
			.append(hashStr.substring(2))
			.toString();

		try
		{
			try (InputStream in = minioClient.getObject(minioBucket, path))
			{
				return; // already exists
			}
			catch (ErrorResponseException ex)
			{
				// doesn't exist
			}

			minioClient.putObject(minioBucket, path, new ByteArrayInputStream(data), data.length, "binary/octet-stream");
		}
		catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidArgumentException | InvalidBucketNameException | NoResponseException | IOException | InvalidKeyException | NoSuchAlgorithmException | XmlPullParserException | InvalidResponseException ex)
		{
			logger.warn("unable to upload data to store", ex);
		}
	}

}
