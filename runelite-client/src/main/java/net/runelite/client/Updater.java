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

import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.google.common.hash.HashingOutputStream;
import com.google.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.net.NetworkInterface;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import javax.inject.Named;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.ui.SplashScreen;
import net.runelite.client.util.OSType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Slf4j
class Updater
{
	private static final String LAUNCHER_EXECUTABLE_NAME_WIN = "RuneLite.exe";

	// Props can be overwritten by rtconfig, which is unsigned, and so is not safe for this
	private static final String WIN64_URL = "https://github.com/runelite/launcher/releases/download/2.6.7/RuneLiteSetup.exe";
	private static final String WIN64_CHECKSUM = "6e388243311622782deaed24555fdcc89672c6d22b843245d8514fdaeee4586c";
	private static final int WIN64_SIZE = 29440032;
	private static final String WIN32_URL = "https://github.com/runelite/launcher/releases/download/2.6.7/RuneLiteSetup32.exe";
	private static final String WIN32_CHECKSUM = "3e79a0aa4d09ff8782e8ca7a30b4948abb935eacdce8b71d6263fb92e1d25e79";
	private static final int WIN32_SIZE = 25299936;

	private final OkHttpClient okHttpClient;
	private final RuntimeConfig runtimeConfig;
	private final ConfigManager configManager;
	private final boolean noupdate;

	@Inject
	Updater(
		OkHttpClient okHttpClient,
		@Nullable RuntimeConfig runtimeConfig,
		ConfigManager configManager,
		@Named("noupdate") boolean noupdate
	)
	{
		this.okHttpClient = okHttpClient;
		this.runtimeConfig = runtimeConfig;
		this.configManager = configManager;
		this.noupdate = noupdate;
	}

	void update()
	{
		try
		{
			tryUpdate();
		}
		catch (Exception ex)
		{
			log.error("error updating", ex);
		}
	}

	void tryUpdate()
	{
		String osName = System.getProperty("os.name");
		if (!"Windows 10".equals(osName) && !"Windows 11".equals(osName))
		{
			log.debug("Unsupported OS: {}", osName);
			return;
		}

		String arch = System.getProperty("os.arch");
		final String downloadUrl, checksum;
		final int size;
		if ("amd64".equals(arch))
		{
			downloadUrl = WIN64_URL;
			checksum = WIN64_CHECKSUM;
			size = WIN64_SIZE;
		}
		else if ("x86".equals(arch))
		{
			downloadUrl = WIN32_URL;
			checksum = WIN32_CHECKSUM;
			size = WIN32_SIZE;
		}
		else
		{
			log.debug("Unsupported arch {}", arch);
			return;
		}

		ProcessHandle current = ProcessHandle.current();
		if (current.info().command().isEmpty())
		{
			log.debug("Running process has no command");
			return;
		}

		Path path = Paths.get(current.info().command().get());
		if (!path.getFileName().toString().equals(LAUNCHER_EXECUTABLE_NAME_WIN))
		{
			log.debug("Skipping update check due to not running from installer, command is {}",
				current.info().command().get());
			return;
		}

		String launcherVersion = RuneLiteProperties.getLauncherVersion();
		if (launcherVersion == null || launcherVersion.isEmpty())
		{
			log.debug("Skipping update check due to not running from installer, no launcher version");
			return;
		}

		log.debug("Running from installer");

		if (runtimeConfig == null || runtimeConfig.getUpdateLauncherWinVers() == null
			|| !Arrays.asList(runtimeConfig.getUpdateLauncherWinVers()).contains(launcherVersion))
		{
			log.debug("No update available");
			return;
		}

		if (noupdate)
		{
			log.info("Skipping update due to noupdate being set");
			return;
		}

		if (System.getenv("RUNELITE_UPGRADE") != null)
		{
			log.info("Skipping update due to launching from an upgrade");
			return;
		}

		Integer updateAttemptNum = configManager.getConfiguration("runelite", "updateNum", Integer.class);
		if (updateAttemptNum == null)
		{
			updateAttemptNum = 0;
		}

		Long updateAttemptTime = configManager.getConfiguration("runelite", "updateAttemptTime", Long.class);
		if (updateAttemptTime == null)
		{
			updateAttemptTime = 0L;
		}

		String lastUpdateHash = configManager.getConfiguration("runelite", "lastUpdateHash");

		int hours = 1 << Math.min(9, updateAttemptNum); // 512 hours = ~21 days
		if (checksum.equals(lastUpdateHash) && Instant.ofEpochMilli(updateAttemptTime).isAfter(Instant.now().minus(hours, ChronoUnit.HOURS)))
		{
			log.info("Previous upgrade attempt was at {} (backoff: {} hours), skipping",
				// logback logs are in local time, so use that to match it
				LocalTime.from(Instant.ofEpochMilli(updateAttemptTime).atZone(ZoneId.systemDefault())),
				hours);
			return;
		}

		// the installer kills running RuneLite processes, so check that there are no others running
		List<ProcessHandle> allProcesses = ProcessHandle.allProcesses().collect(Collectors.toList());
		for (ProcessHandle ph : allProcesses)
		{
			if (ph.pid() == current.pid())
			{
				continue;
			}

			if (ph.info().command().equals(current.info().command()))
			{
				log.info("Skipping update due to {} process {}", LAUNCHER_EXECUTABLE_NAME_WIN, ph);
				return;
			}
		}

		// check if rollout allows this update
		if (runtimeConfig.getUpdateRollout() > 0. && installRollout() > runtimeConfig.getUpdateRollout())
		{
			log.debug("Skipping update due to rollout");
			return;
		}

		log.info("Performing launcher update");

		// from here and below the update will be attempted. update settings early so a failed
		// download counts as an attempt.
		configManager.setConfiguration("runelite", "updateAttemptNum", updateAttemptNum + 1);
		configManager.setConfiguration("runelite", "updateAttemptTime", System.currentTimeMillis());
		configManager.setConfiguration("runelite", "lastUpdateHash", checksum);
		configManager.sendConfig();

		try
		{
			log.info("Downloading launcher update");

			Request request = new Request.Builder()
				.url(downloadUrl)
				.build();

			var tempExe = Files.createTempFile("rlupdate", "exe");
			HashCode hash;
			try (Response response = okHttpClient.newCall(request).execute();
				HashingOutputStream out = new HashingOutputStream(Hashing.sha256(), Files.newOutputStream(tempExe)))
			{
				if (!response.isSuccessful())
				{
					log.info("Bad response downloading {}", downloadUrl);
					return;
				}

				InputStream in = response.body().byteStream();
				byte[] buffer = new byte[1024 * 1024];
				int downloaded = 0;

				for (; ; )
				{
					int i = in.read(buffer);
					if (i == -1)
					{
						break;
					}

					downloaded += i;
					SplashScreen.stage(.6, 1., null, "RuneLite Setup", downloaded, size, true);
					out.write(buffer, 0, i);
				}

				hash = out.hash();
			}

			if (!hash.toString().equals(checksum))
			{
				log.info("Hash mismatch for update. Expected {} got {}.", checksum, hash);
				return;
			}

			log.info("Launching installer");

			var pb = new ProcessBuilder(
				tempExe.toFile().getAbsolutePath(),
				"/SILENT"
			);

			var env = pb.environment();
			env.put("RUNELITE_UPGRADE", "1");
			pb.start();

			System.exit(0);
		}
		catch (IOException e)
		{
			log.error("io error performing upgrade", e);
		}
	}

	private static double installRollout()
	{
		try
		{
			Hasher hasher = Hashing.sha256().newHasher();
			Runtime runtime = Runtime.getRuntime();

			hasher.putByte((byte) OSType.getOSType().ordinal());
			hasher.putByte((byte) runtime.availableProcessors());
			hasher.putUnencodedChars(System.getProperty("os.arch", ""));
			hasher.putUnencodedChars(System.getProperty("os.version", ""));
			hasher.putUnencodedChars(System.getProperty("user.name", ""));

			Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
			while (networkInterfaces.hasMoreElements())
			{
				NetworkInterface networkInterface = networkInterfaces.nextElement();
				byte[] hardwareAddress = networkInterface.getHardwareAddress();
				if (hardwareAddress != null)
				{
					hasher.putBytes(hardwareAddress);
				}
			}
			HashCode hash = hasher.hash();
			return (hash.asInt() & 0x7fffffff) / (double) Integer.MAX_VALUE;
		}
		catch (Exception ex)
		{
			log.error("unable to generate machine id", ex);
			return Math.random();
		}
	}
}
