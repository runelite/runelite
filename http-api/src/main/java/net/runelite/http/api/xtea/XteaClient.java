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
package net.runelite.http.api.xtea;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import net.runelite.http.api.RuneliteAPI;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XteaClient
{
	private static final Logger logger = LoggerFactory.getLogger(XteaClient.class);

	private static final String URL = RuneliteAPI.getApiBase() + "/xtea";

	private final Gson gson = new Gson();

	public void submit(int revision, int region, int[] keys) throws URISyntaxException, UnsupportedEncodingException, IOException
	{
		URIBuilder builder = new URIBuilder(URL);

		URI uri = builder.build();

		logger.debug("Built URI: {}", uri);

		XteaRequest xteaRequest = new XteaRequest();
		xteaRequest.setRevision(revision);

		XteaKey xteaKey = new XteaKey();
		xteaKey.setRegion(region);
		xteaKey.setKeys(keys);

		xteaRequest.addKey(xteaKey);

		String json = gson.toJson(xteaRequest);

		HttpPost request = new HttpPost(uri);
		request.setEntity(new StringEntity(json));

		try (CloseableHttpClient client = HttpClients.createDefault();
			CloseableHttpResponse response = client.execute(request))
		{
			logger.debug("Submitted XTEA key for region {}", region);
		}
	}
}
