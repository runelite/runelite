package net.runelite.client.util;

import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.concurrent.ScheduledExecutorService;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.WorldType;
import net.runelite.client.Notifier;
import static net.runelite.client.RuneLite.SCREENSHOT_DIR;
import net.runelite.client.plugins.screenshot.imgur.ImageUploadRequest;
import net.runelite.client.plugins.screenshot.imgur.ImageUploadResponse;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Slf4j
@Singleton
public class ScreenCapture
{
	private static final String IMGUR_CLIENT_ID = "30d71e5f6860809";
	private static final HttpUrl IMGUR_IMAGE_UPLOAD_URL = HttpUrl.parse("https://api.imgur.com/3/image");
	private static final MediaType JSON = MediaType.parse("application/json");
	private static final DateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");

	@Inject
	private ScheduledExecutorService executor;

	@Inject
	private Client client;

	@Inject
	private Notifier notifier;

	/**
	 * Saves a screenshot of the client window to the screenshot folder as a PNG,
	 * sends a notification to the system tray, and uploads it to an image-hosting service.
	 *
	 * @param screenshot BufferedImage to capture.
	 * @param notify Send a notification to the system tray when the image is captured.
	 * @param subDirectory Subdirectory of the default screenshot directory to save the image in.
	 */
	public void takeScreenshot(BufferedImage screenshot, boolean notify, String subDirectory)
	{
		takeScreenshot(screenshot, null, notify, true, subDirectory);
	}

	/**
	 * Saves a screenshot of the client window to the screenshot folder as a PNG,
	 * and optionally uploads it to an image-hosting service.
	 *
	 * @param screenshot BufferedImage to capture.
	 * @param name Filename to use, without file extension.
	 * @param notify Send a notification to the system tray when the image is captured.
	 * @param upload Upload the image to a hosting service.
	 */
	public void takeScreenshot(BufferedImage screenshot, String name, boolean notify, boolean upload)
	{
		takeScreenshot(screenshot, name, notify, upload, null);
	}

	/**
	 * Saves a screenshot of the client window to the screenshot folder as a PNG,
	 * and optionally uploads it to an image-hosting service.
	 *
	 * @param screenshot BufferedImage to capture.
	 * @param name Filename to use, without file extension.
	 * @param subDirectory Subdirectory of the default screenshot directory to save the image in.
	 * @param notify Send a notification to the system tray when the image is captured.
	 * @param upload Upload the image to a hosting service.
	 */
	public void takeScreenshot(BufferedImage screenshot, String name, boolean notify, boolean upload, String subDirectory)
	{
		if (client.getGameState() == GameState.LOGIN_SCREEN)
		{
			// Prevent the screenshot from being captured
			log.info("Login screenshot prevented");
			return;
		}

		if (name == null)
			name = format(new Date());

		String fileName = name;
		File imageDirectory;
		if (client.getLocalPlayer() != null && client.getLocalPlayer().getName() != null)
		{
			final EnumSet<WorldType> worldTypes = client.getWorldType();
			final boolean dmm = worldTypes.contains(WorldType.DEADMAN);
			final boolean sdmm = worldTypes.contains(WorldType.SEASONAL_DEADMAN);
			final boolean dmmt = worldTypes.contains(WorldType.DEADMAN_TOURNAMENT);
			final boolean isDmmWorld = dmm || sdmm || dmmt;

			String playerDir = client.getLocalPlayer().getName();
			if (isDmmWorld)
				playerDir += "-Deadman";
			imageDirectory = new File(SCREENSHOT_DIR, playerDir);
		}
		else
		{
			imageDirectory = SCREENSHOT_DIR;
		}
		if (subDirectory != null)
			imageDirectory = new File(imageDirectory, subDirectory);

		imageDirectory.mkdirs();
		File writeDirectory = imageDirectory;

		executor.execute(() ->
		{
			try
			{
				File screenshotFile = new File(writeDirectory, fileName + ".png");

				ImageIO.write(screenshot, "PNG", screenshotFile);

				if (upload)
					uploadScreenshot(screenshotFile, notify);
				else if (notify)
					notifier.notify("A screenshot was saved to " + screenshotFile, TrayIcon.MessageType.INFO);
			}
			catch (IOException ex)
			{
				log.warn("error writing screenshot", ex);
			}
		});
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
		String json = RuneLiteAPI.GSON.toJson(new ImageUploadRequest(screenshotFile));

		Request request = new Request.Builder()
			.url(IMGUR_IMAGE_UPLOAD_URL)
			.addHeader("Authorization", "Client-ID " + IMGUR_CLIENT_ID)
			.post(RequestBody.create(JSON, json))
			.build();

		executor.execute(() ->
			RuneLiteAPI.CLIENT.newCall(request).enqueue(new Callback()
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
						ImageUploadResponse imageUploadResponse = RuneLiteAPI.GSON
							.fromJson(new InputStreamReader(in), ImageUploadResponse.class);

						if (imageUploadResponse.isSuccess())
						{
							String link = imageUploadResponse.getData().getLink();

							StringSelection selection = new StringSelection(link);
							Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
							clipboard.setContents(selection, selection);
							if (notify)
								notifier.notify("A screenshot was uploaded and inserted into your clipboard!", TrayIcon.MessageType.INFO);
						}
					}
				}
			})
		);
	}

	private static String format(Date date)
	{
		synchronized (TIME_FORMAT)
		{
			return TIME_FORMAT.format(date);
		}
	}
}