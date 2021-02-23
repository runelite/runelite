/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * Copyright (c) 2019, Alexsuperfly <https://github.com/Alexsuperfly>
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
package net.runelite.client.util;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.EnumSet;
import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.WorldType;
import net.runelite.client.Notifier;
import static net.runelite.client.RuneLite.SCREENSHOT_DIR;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Slf4j
@Singleton
public class ImageCapture
{
	private static final DateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	private static final HttpUrl IMGUR_IMAGE_UPLOAD_URL = HttpUrl.parse("https://api.imgur.com/3/image");
	private static final MediaType JSON = MediaType.parse("application/json");

	private final Client client;
	private final Notifier notifier;
	private final OkHttpClient okHttpClient;
	private final Gson gson;
	private final String imgurClientId;

	@Inject
	private ImageCapture(
		final Client client,
		final Notifier notifier,
		final OkHttpClient okHttpClient,
		final Gson gson,
		@Named("runelite.imgur.client.id") final String imgurClientId
	)
	{
		this.client = client;
		this.notifier = notifier;
		this.okHttpClient = okHttpClient;
		this.gson = gson;
		this.imgurClientId = imgurClientId;
	}

	/**
	 * Saves a screenshot of the client window to the screenshot folder as a PNG,
	 * and optionally uploads it to an image-hosting service.
	 *
	 * @param screenshot BufferedImage to capture.
	 * @param fileName Filename to use, without file extension.
	 * @param subDir Directory within the player screenshots dir to store the captured screenshot to.
	 * @param notify Send a notification to the system tray when the image is captured.
	 * @param imageUploadStyle which method to use to upload the screenshot (Imgur or directly to clipboard).
	 */
	public void takeScreenshot(BufferedImage screenshot, String fileName, @Nullable String subDir, boolean notify, ImageUploadStyle imageUploadStyle)
	{
		if (client.getGameState() == GameState.LOGIN_SCREEN)
		{
			// Prevent the screenshot from being captured
			log.info("Login screenshot prevented");
			return;
		}

		File playerFolder;
		if (client.getLocalPlayer() != null && client.getLocalPlayer().getName() != null)
		{
			final EnumSet<WorldType> worldTypes = client.getWorldType();

			String playerDir = client.getLocalPlayer().getName();
			if (worldTypes.contains(WorldType.DEADMAN))
			{
				playerDir += "-Deadman";
			}
			else if (worldTypes.contains(WorldType.LEAGUE))
			{
				playerDir += "-League";
			}

			if (!Strings.isNullOrEmpty(subDir))
			{
				playerDir += File.separator + subDir;
			}

			playerFolder = new File(SCREENSHOT_DIR, playerDir);
		}
		else
		{
			playerFolder = SCREENSHOT_DIR;
		}

		playerFolder.mkdirs();

		fileName += (fileName.isEmpty() ? "" : " ") + format(new Date());

		try
		{
			File screenshotFile = new File(playerFolder, fileName + ".png");

			// To make sure that screenshots don't get overwritten, check if file exists,
			// and if it does create file with same name and suffix.
			int i = 1;
			while (screenshotFile.exists())
			{
				screenshotFile = new File(playerFolder, fileName + String.format("(%d)", i++) + ".png");
			}

			ImageIO.write(screenshot, "PNG", screenshotFile);

			if (imageUploadStyle == ImageUploadStyle.IMGUR)
			{
				uploadScreenshot(screenshotFile, notify);
			}
			else if (imageUploadStyle == ImageUploadStyle.CLIPBOARD)
			{
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				TransferableBufferedImage transferableBufferedImage = new TransferableBufferedImage(screenshot);
				clipboard.setContents(transferableBufferedImage, null);

				if (notify)
				{
					notifier.notify("A screenshot was saved and inserted into your clipboard!", TrayIcon.MessageType.INFO);
				}
			}
			else if (notify)
			{
				notifier.notify("A screenshot was saved to " + screenshotFile, TrayIcon.MessageType.INFO);
			}
		}
		catch (IOException ex)
		{
			log.warn("error writing screenshot", ex);
		}
	}

	/**
	 * Saves a screenshot of the client window to the screenshot folder as a PNG,
	 * and optionally uploads it to an image-hosting service.
	 *
	 * @param screenshot BufferedImage to capture.
	 * @param fileName Filename to use, without file extension.
	 * @param notify Send a notification to the system tray when the image is captured.
	 * @param imageUploadStyle which method to use to upload the screenshot (Imgur or directly to clipboard).
	 */
	public void takeScreenshot(BufferedImage screenshot, String fileName, boolean notify, ImageUploadStyle imageUploadStyle)
	{
		takeScreenshot(screenshot, fileName, null, notify, imageUploadStyle);
	}

	/**
	 * Uploads a screenshot to the Imgur image-hosting service,
	 * and copies the image link to the clipboard.
	 *
	 * @param screenshotFile Image file to upload.
	 * @throws IOException Thrown if the file cannot be read.
	 */
	private void uploadScreenshot(File screenshotFile, boolean notify) throws IOException
	{
		String json = gson.toJson(new ImageUploadRequest(screenshotFile));

		Request request = new Request.Builder()
			.url(IMGUR_IMAGE_UPLOAD_URL)
			.addHeader("Authorization", "Client-ID " + imgurClientId)
			.post(RequestBody.create(JSON, json))
			.build();

		okHttpClient.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException ex)
			{
				log.warn("error uploading screenshot", ex);
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException
			{
				try (InputStream in = response.body().byteStream())
				{
					ImageUploadResponse imageUploadResponse =
						gson.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), ImageUploadResponse.class);

					if (imageUploadResponse.isSuccess())
					{
						String link = imageUploadResponse.getData().getLink();

						StringSelection selection = new StringSelection(link);
						Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
						clipboard.setContents(selection, selection);

						if (notify)
						{
							notifier.notify("A screenshot was uploaded and inserted into your clipboard!", TrayIcon.MessageType.INFO);
						}
					}
				}
			}
		});
	}

	private static String format(Date date)
	{
		synchronized (TIME_FORMAT)
		{
			return TIME_FORMAT.format(date);
		}
	}

	@Data
	private static class ImageUploadResponse
	{
		private Data data;
		private boolean success;

		@lombok.Data
		private static class Data
		{
			private String link;
		}
	}

	@Data
	private static class ImageUploadRequest
	{
		private final String image;
		private final String type;

		ImageUploadRequest(File imageFile) throws IOException
		{
			this.image = Base64.getEncoder().encodeToString(Files.readAllBytes(imageFile.toPath()));
			this.type = "base64";
		}
	}
}
