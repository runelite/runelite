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
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.util.OSType;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.telemetry.Telemetry;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Slf4j
@RequiredArgsConstructor
public class TelemetryClient
{
	private final OkHttpClient okHttpClient;
	private final Gson gson;
	private final HttpUrl apiBase;

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

	void submitVmErrors(File logsDir)
	{
		try
		{
			long yesterday = System.currentTimeMillis() - Duration.ofDays(1).toMillis();
			for (File f : logsDir.listFiles())
			{
				if (!f.getName().startsWith("jvm_crash_") || !f.getName().endsWith(".log") // jvm_crash_pid_12345.log
					|| f.getName().endsWith("_r.log") // avoid sending logs multiple times
					|| f.lastModified() < yesterday)
				{
					continue;
				}

				String hsErr = Files.readString(f.toPath());

				String destName = f.getName().substring(0, f.getName().length() - 4) + "_r.log";
				File dest = new File(logsDir, destName);
				if (!f.renameTo(dest))
				{
					continue;
				}

				// strip username and home directory from the error log
				String username = System.getProperty("user.name");
				String home = System.getProperty("user.home");
				hsErr = hsErr
					.replace(username, "%USERNAME%")
					.replace(home, "%HOME%");

				submitError("vm crash", hsErr, Collections.emptyMap());
			}
		}
		catch (Exception ex)
		{
			log.error("error reporting errors", ex);
		}
	}

	public void submitError(String type, String error, Map<String, String> params)
	{
		HttpUrl.Builder urlBuilder = apiBase.newBuilder()
			.addPathSegment("telemetry")
			.addPathSegment("error")
			.addQueryParameter("type", type)
			.addQueryParameter("osname", System.getProperty("os.name"))
			.addQueryParameter("osver", System.getProperty("os.version"))
			.addQueryParameter("osarch", System.getProperty("os.arch"))
			.addQueryParameter("javaversion", System.getProperty("java.version"))
			.addQueryParameter("javavendor", System.getProperty("java.vendor"))
			.addQueryParameter("cpumodel", cpuName());
		params.forEach(urlBuilder::addQueryParameter);

		HttpUrl url = urlBuilder.build();

		Request request = new Request.Builder()
			.url(url)
			.post(RequestBody.create(MediaType.get("text/plain"), error))
			.build();

		okHttpClient.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException e)
			{
				log.debug("Error submitting error", e);
			}

			@Override
			public void onResponse(Call call, Response response)
			{
				log.debug("Submitted error");
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
		telemetry.setCpuName(cpuName());
		return telemetry;
	}

	private static String cpuName()
	{
		if (OSType.getOSType() != OSType.Windows)
		{
			return null;
		}

		try
		{
			Process p = Runtime.getRuntime().exec("wmic cpu get name");

			try (var in = new BufferedReader(new InputStreamReader(p.getInputStream())))
			{
				String line;
				while ((line = in.readLine()) != null)
				{
					line = line.trim();
					if (line.isEmpty() || line.equalsIgnoreCase("name"))
					{
						continue;
					}

					return line;
				}
			}
		}
		catch (IOException ex)
		{
			log.debug("unable to get cpu name", ex);
		}
		return null;
	}
}
