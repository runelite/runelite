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

import io.reactivex.Single;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

class ClientConfigLoader
{
	private ClientConfigLoader()
	{
		throw new RuntimeException();
	}

	private static final String CONFIG_URL = "http://oldschool.runescape.com/jav_config.ws";
	private static final int MAX_ATTEMPTS = 16;

	static Single<RSConfig> fetch()
	{
		return Single.create(obs ->
		{
			int attempt = 0;

			HostSupplier supplier = null;
			HttpUrl url = HttpUrl.parse(CONFIG_URL);

			final RSConfig config = new RSConfig();

			while (attempt++ < MAX_ATTEMPTS)
			{
				final Request request = new Request.Builder()
					.url(url)
					.build();

				try (final Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
				{
					if (!response.isSuccessful())
					{
						if (supplier == null)
						{
							supplier = new HostSupplier();
						}

						url = supplier.get();
						continue;
					}

					String str;
					final BufferedReader in = new BufferedReader(new InputStreamReader(response.body().byteStream()));
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

					obs.onSuccess(config);
					return;
				}
			}

			obs.onError(new IOException("Too many attempts"));
		});
	}
}
