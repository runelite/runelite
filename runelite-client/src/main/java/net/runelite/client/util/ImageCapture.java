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
import com.google.common.collect.ImmutableSet;
import com.google.gson.Gson;
import java.awt.Color;
import java.awt.Composite;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Consumer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Point;
import net.runelite.api.SpriteID;
import net.runelite.api.WorldType;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.Notifier;
import static net.runelite.client.RuneLite.SCREENSHOT_DIR;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.DrawManager;
import net.runelite.client.ui.FontManager;
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
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("MMM. dd, yyyy");
	private static final int REPORT_BUTTON_X_OFFSET = 437;
	private static final Set<Integer> REPORT_BUTTON_TLIS = ImmutableSet.of(
		WidgetID.FIXED_VIEWPORT_GROUP_ID,
		WidgetID.RESIZABLE_VIEWPORT_OLD_SCHOOL_BOX_GROUP_ID,
		WidgetID.RESIZABLE_VIEWPORT_BOTTOM_LINE_GROUP_ID);

	private final Client client;
	private final Notifier notifier;
	private final OkHttpClient okHttpClient;
	private final Gson gson;
	private final DrawManager drawManager;
	private final ScheduledExecutorService executor;
	private final ClientUI clientUi;
	private final ClientThread clientThread;
	private final String imgurClientId;

	private BufferedImage reportButton;

	@Inject
	private ImageCapture(
		final Client client,
		final Notifier notifier,
		final OkHttpClient okHttpClient,
		final Gson gson,
		final DrawManager drawManager,
		final ScheduledExecutorService executor,
		final ClientUI clientUi,
		final ClientThread clientThread,
		final SpriteManager spriteManager,
		@Named("runelite.imgur.client.id") final String imgurClientId
	)
	{
		this.client = client;
		this.notifier = notifier;
		this.okHttpClient = okHttpClient;
		this.gson = gson;
		this.drawManager = drawManager;
		this.executor = executor;
		this.clientUi = clientUi;
		this.clientThread = clientThread;
		this.imgurClientId = imgurClientId;

		spriteManager.getSpriteAsync(SpriteID.CHATBOX_REPORT_BUTTON, 0, s -> reportButton = s);
	}

	/**
	 * Saves an image to RuneLite's screenshots directory.
	 *
	 * @param options The options to use to save the screenshot, such as {@code fileName}, {@code subDir},
	 *                {@code notify}, and {@code imageUploadStyle}.
	 *
	 * @see ImageCaptureOptions
	 */
	public void takeScreenshot(@Nonnull final ImageCaptureOptions options)
	{
		if (client.getGameState() == GameState.LOGIN_SCREEN)
		{
			// Prevent the screenshot from being captured
			log.info("Login screenshot prevented");
			return;
		}

		if (options.getScreenshot() == null)
		{
			captureScreenshot(options);
		}
		else
		{
			saveScreenshot(options.getScreenshot(), options);
		}
	}

	/**
	 * Captures a screenshot of the game and client frame to an image and saves it in RuneLite's screenshots directory.
	 *
	 * @param options The options to use to save the screenshot, such as {@code fileName}, {@code subDir},
	 *                {@code notify}, and {@code imageUploadStyle}.
	 *
	 * @see ImageCaptureOptions
	 */
	private void captureScreenshot(final ImageCaptureOptions options)
	{
		drawManager.requestNextFrameListener((img) ->
			executor.submit(() ->
			{
				final BufferedImage screenshot = options.isIncludeFrame()
					? new BufferedImage(clientUi.getWidth(), clientUi.getHeight(), BufferedImage.TYPE_INT_ARGB)
					: new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
				final Graphics2D graphics = screenshot.createGraphics();

				int gameOffsetX = 0;
				int gameOffsetY = 0;

				// Create client UI on screenshot before drawing game to it
				if (options.isIncludeFrame())
				{
					// Draw the client frame onto the screenshot
					try
					{
						SwingUtilities.invokeAndWait(() -> clientUi.paint(graphics));
					}
					catch (InterruptedException | InvocationTargetException e)
					{
						log.warn("unable to paint client UI on screenshot", e);
					}

					// Evaluate the position of the game inside the frame
					final Point canvasOffset = clientUi.getCanvasOffset();
					gameOffsetX = canvasOffset.getX();
					gameOffsetY = canvasOffset.getY();
				}

				// Create graphics and evaluate the position of the game inside the screenshot frame
				graphics.translate(gameOffsetX, gameOffsetY);

				// Draw the game onto the screenshot
				graphics.drawImage(img, 0, 0, null);

				// Save graphics2d properties so we can restore them later
				final AffineTransform transform = graphics.getTransform();
				final Stroke stroke = graphics.getStroke();
				final Composite composite = graphics.getComposite();
				final Paint paint = graphics.getPaint();
				final RenderingHints renderingHints = graphics.getRenderingHints();
				final Color background = graphics.getBackground();

				clientThread.invoke(() ->
				{
					// Draw overlays
					for (final Consumer<Graphics2D> overlay : options.getOverlays())
					{
						overlay.accept(graphics);

						// Restore graphics2d properties
						graphics.setTransform(transform);
						graphics.setStroke(stroke);
						graphics.setComposite(composite);
						graphics.setPaint(paint);
						graphics.setRenderingHints(renderingHints);
						graphics.setBackground(background);
					}

					// Save screenshot to file
					saveScreenshot(screenshot, options);
				});
			}));
	}

	/**
	 * Writes an image to a png image saves it in RuneLite's screenshots directory.
	 *
	 * @param screenshot The image to save
	 * @param options    The options to use to save the screenshot, such as {@code fileName}, {@code subDir},
	 *                   {@code notify}, and {@code imageUploadStyle}.
	 *
	 * @see ImageCaptureOptions
	 */
	private void saveScreenshot(final BufferedImage screenshot, final ImageCaptureOptions options)
	{
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
			else if (worldTypes.contains(WorldType.TOURNAMENT))
			{
				playerDir += "-Tournament";
			}

			if (!Strings.isNullOrEmpty(options.getSubDir()))
			{
				playerDir += File.separator + options.getSubDir();
			}

			playerFolder = new File(SCREENSHOT_DIR, playerDir);
		}
		else
		{
			playerFolder = SCREENSHOT_DIR;
		}

		playerFolder.mkdirs();

		String fileName = Strings.isNullOrEmpty(options.getFileName()) ? "" : options.getFileName();
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

			if (options.getImageUploadStyle() == ImageUploadStyle.IMGUR)
			{
				uploadScreenshot(screenshotFile, options.isNotify());
			}
			else if (options.getImageUploadStyle() == ImageUploadStyle.CLIPBOARD)
			{
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				TransferableBufferedImage transferableBufferedImage = new TransferableBufferedImage(screenshot);
				clipboard.setContents(transferableBufferedImage, null);

				if (options.isNotify())
				{
					notifier.notify("A screenshot was saved and inserted into your clipboard!", TrayIcon.MessageType.INFO);
				}
			}
			else if (options.isNotify())
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
	 * @deprecated Superseded in functionality by {@link ImageCapture#takeScreenshot(ImageCaptureOptions)}
	 * @param screenshot BufferedImage to capture.
	 * @param fileName Filename to use, without file extension.
	 * @param subDir Directory within the player screenshots dir to store the captured screenshot to.
	 * @param notify Send a notification to the system tray when the image is captured.
	 * @param imageUploadStyle which method to use to upload the screenshot (Imgur or directly to clipboard).
	 */
	@Deprecated
	public void takeScreenshot(BufferedImage screenshot, String fileName, @Nullable String subDir, boolean notify, ImageUploadStyle imageUploadStyle)
	{
		takeScreenshot(ImageCaptureOptions.builder()
			.screenshot(screenshot)
			.fileName(fileName)
			.subDir(subDir)
			.notify(notify)
			.imageUploadStyle(imageUploadStyle)
			.build());
	}

	/**
	 * Saves a screenshot of the client window to the screenshot folder as a PNG,
	 * and optionally uploads it to an image-hosting service.
	 *
	 * @deprecated Superseded in functionality by {@link ImageCapture#takeScreenshot(ImageCaptureOptions)}
	 * @param screenshot BufferedImage to capture.
	 * @param fileName Filename to use, without file extension.
	 * @param notify Send a notification to the system tray when the image is captured.
	 * @param imageUploadStyle which method to use to upload the screenshot (Imgur or directly to clipboard).
	 */
	@Deprecated
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

	/**
	 * Overlays the current date over the report button, replacing the "Report" text, in the format
	 * {@code Jan. 01 1970}.
	 *
	 * @param graphics Graphics used to draw on the game screen.
	 */
	public void displayDateOverlay(final Graphics2D graphics)
	{
		if (reportButton == null || !REPORT_BUTTON_TLIS.contains(client.getTopLevelInterfaceId()))
		{
			return;
		}

		final int clientHeight = client.getCanvasHeight();
		final int y = clientHeight - reportButton.getHeight() - 1;

		graphics.drawImage(reportButton, REPORT_BUTTON_X_OFFSET, y, null);

		graphics.setFont(FontManager.getRunescapeSmallFont());
		final FontMetrics fontMetrics = graphics.getFontMetrics();

		final String date = DATE_FORMAT.format(new Date());
		final int dateWidth = fontMetrics.stringWidth(date);
		final int dateHeight = fontMetrics.getHeight();

		final int textX = REPORT_BUTTON_X_OFFSET + reportButton.getWidth() / 2 - dateWidth / 2;
		final int textY = y + reportButton.getHeight() / 2 + dateHeight / 2;

		graphics.setColor(Color.BLACK);
		graphics.drawString(date, textX + 1, textY + 1);

		graphics.setColor(Color.WHITE);
		graphics.drawString(date, textX, textY);
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

		private ImageUploadRequest(File imageFile) throws IOException
		{
			this.image = Base64.getEncoder().encodeToString(Files.readAllBytes(imageFile.toPath()));
			this.type = "base64";
		}
	}
}
