/*
 * Copyright (c) 2019 Abex
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
package net.runelite.client.externalplugins;

import com.google.common.reflect.TypeToken;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.List;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import net.runelite.client.RuneLiteProperties;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.client.util.VerificationException;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSource;

public class ExternalPluginClient
{
	private final OkHttpClient cachingClient;

	@Inject
	public ExternalPluginClient(OkHttpClient cachingClient)
	{
		this.cachingClient = cachingClient;
	}

	public List<ExternalPluginManifest> downloadManifest() throws IOException, VerificationException
	{
		HttpUrl manifest = RuneLiteProperties.getPluginHubBase()
			.newBuilder()
			.addPathSegments("manifest.js")
			.build();
		try (Response res = cachingClient.newCall(new Request.Builder().url(manifest).build()).execute())
		{
			if (res.code() != 200)
			{
				throw new IOException("Non-OK response code: " + res.code());
			}

			BufferedSource src = res.body().source();

			byte[] signature = new byte[src.readInt()];
			src.readFully(signature);

			byte[] data = src.readByteArray();
			Signature s = Signature.getInstance("SHA256withRSA");
			s.initVerify(loadCertificate());
			s.update(data);

			if (!s.verify(signature))
			{
				throw new VerificationException("Unable to verify external plugin manifest");
			}

			return RuneLiteAPI.GSON.fromJson(new String(data, StandardCharsets.UTF_8),
				new TypeToken<List<ExternalPluginManifest>>()
				{
				}.getType());
		}
		catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e)
		{
			throw new RuntimeException(e);
		}
	}

	public BufferedImage downloadIcon(ExternalPluginManifest plugin) throws IOException
	{
		if (!plugin.hasIcon())
		{
			return null;
		}

		HttpUrl url = RuneLiteProperties.getPluginHubBase()
			.newBuilder()
			.addPathSegment(plugin.getInternalName())
			.addPathSegment(plugin.getCommit() + ".png")
			.build();

		try (Response res = cachingClient.newCall(new Request.Builder().url(url).build()).execute())
		{
			byte[] bytes = res.body().bytes();
			// We don't stream so the lock doesn't block the edt trying to load something at the same time
			synchronized (ImageIO.class)
			{
				return ImageIO.read(new ByteArrayInputStream(bytes));
			}
		}
	}

	private static Certificate loadCertificate()
	{
		try
		{
			CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
			Certificate certificate = certFactory.generateCertificate(ExternalPluginClient.class.getResourceAsStream("externalplugins.crt"));
			return certificate;
		}
		catch (CertificateException e)
		{
			throw new RuntimeException(e);
		}
	}
}
