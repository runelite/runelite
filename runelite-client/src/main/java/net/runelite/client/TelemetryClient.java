/*
 * Copyright (c) 2022, Adam <Adam@sigterm.info>
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
package net.runelite.client;

import com.google.gson.Gson;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.telemetry.Telemetry;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Slf4j
class TelemetryClient
{
	private final OkHttpClient okHttpClient;
	private final Gson gson;
	private final HttpUrl apiBase;

	@Inject
	private TelemetryClient(OkHttpClient okHttpClient,
		Gson gson,
		@Named("runelite.api.base") HttpUrl apiBase
	)
	{
		this.okHttpClient = okHttpClient;
		this.gson = gson;
		this.apiBase = apiBase;
	}

	void submitTelemetry()
	{
		HttpUrl url = apiBase.newBuilder()
			.addPathSegment("telemetry")
			.build();

		Request request = new Request.Builder()
			.url(url)
			.post(RequestBody.create(RuneLiteAPI.JSON, gson.toJson(buildTelemetry())))
			.build();

		okHttpClient.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException e)
			{
				log.debug("Error submitting telemetry", e);
			}

			@Override
			public void onResponse(Call call, Response response)
			{
				log.debug("Submitted telemetry");
				response.close();
			}
		});
	}

	private static Telemetry buildTelemetry()
	{
		Telemetry telemetry = new Telemetry();
		telemetry.setJavaVendor(System.getProperty("java.vendor"));
		telemetry.setJavaVersion(System.getProperty("java.version"));
		telemetry.setOsName(System.getProperty("os.name"));
		telemetry.setOsVersion(System.getProperty("os.version"));
		telemetry.setOsArch(System.getProperty("os.arch"));
		telemetry.setLauncherVersion(System.getProperty("runelite.launcher.version"));
		OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
		if (operatingSystemMXBean instanceof com.sun.management.OperatingSystemMXBean)
		{
			long totalPhysicalMemorySize = ((com.sun.management.OperatingSystemMXBean) operatingSystemMXBean).getTotalPhysicalMemorySize();
			telemetry.setTotalMemory(totalPhysicalMemorySize);
		}
		return telemetry;
	}
}
