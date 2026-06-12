/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.rs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.AllArgsConstructor;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@AllArgsConstructor
class ClientConfigLoader
{
	private final OkHttpClient okHttpClient;

	RSConfig fetch(String location) throws IOException
	{
		if (location.startsWith("http://") || location.startsWith("https://"))
		{
			return fetch(HttpUrl.get(location));
		}

		Path path = location.startsWith("file:")
			? Paths.get(URI.create(location)).toAbsolutePath().normalize()
			: Paths.get(location).toAbsolutePath().normalize();
		if (!Files.isRegularFile(path))
		{
			throw new IOException("jav_config file does not exist: " + path);
		}

		try (FileInputStream inputStream = new FileInputStream(path.toFile()))
		{
			return parse(new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)));
		}
	}

	RSConfig fetch(HttpUrl url) throws IOException
	{
		final Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = okHttpClient.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unsuccessful response: " + response.message());
			}

			return parse(new BufferedReader(new InputStreamReader(response.body().byteStream(), StandardCharsets.UTF_8)));
		}
	}

	private RSConfig parse(BufferedReader in) throws IOException
	{
		final RSConfig config = new RSConfig();

		try (in)
		{
			String str;
			while ((str = in.readLine()) != null)
			{
				int idx = str.indexOf('=');

				if (idx == -1)
				{
					continue;
				}

				String s = str.substring(0, idx);

				switch (s)
				{
					case "param":
						str = str.substring(idx + 1);
						idx = str.indexOf('=');
						s = str.substring(0, idx);

						config.getAppletProperties().put(s, str.substring(idx + 1));
						break;
					case "msg":
						// ignore
						break;
					default:
						config.getClassLoaderProperties().put(s, str.substring(idx + 1));
						break;
				}
			}
		}

		return config;
	}
}
