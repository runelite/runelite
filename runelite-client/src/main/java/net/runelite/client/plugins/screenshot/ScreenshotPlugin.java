/*
 * Copyright (c) 2018, UniquePassive <https://github.com/uniquepassive>
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
package net.runelite.client.plugins.screenshot;

import net.runelite.client.plugins.screenshot.imgur.ImageUploadRequest;
import net.runelite.client.plugins.screenshot.imgur.ImageUploadResponse;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.InputStreamReader;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import net.runelite.api.Client;
import net.runelite.client.events.ClientUILoaded;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.Notifier;
import net.runelite.client.RuneLite;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.OverlayRenderer;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.pushingpixels.substance.internal.utils.SubstanceCoreUtilities;
import static net.runelite.api.widgets.WidgetID.LEVEL_UP_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.QUEST_COMPLETED_GROUP_ID;
import static net.runelite.api.widgets.WidgetInfo.TO_GROUP;
import okhttp3.HttpUrl;

@PluginDescriptor(
	name = "Screenshot plugin"
)
@Slf4j
public class ScreenshotPlugin extends Plugin
{
	private static final String IMGUR_CLIENT_ID = "30d71e5f6860809";
	private static final HttpUrl IMGUR_IMAGE_UPLOAD_URL = HttpUrl.parse("https://api.imgur.com/3/image");
	private static final MediaType JSON = MediaType.parse("application/json");

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("MMM. dd, yyyy", Locale.US);
	private static final DateFormat TIME_FORMAT = new SimpleDateFormat("h.m.s a d MMM. yyyy", Locale.US);

	@Inject
	ScreenshotConfig config;

	@Inject
	Notifier notifier;

	@Inject
	Client client;

	@Inject
	ClientUI clientUi;

	@Inject
	OverlayRenderer overlayRenderer;

	private JButton titleBarButton;

	@Provides
	ScreenshotConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ScreenshotConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		// prior to UI loading this does nothing
		addButtonToTitleBar();
	}

	@Override
	protected void shutDown() throws Exception
	{
		removeButtonFromTitlebar();
	}

	@Subscribe
	public void clientUiLoaded(ClientUILoaded e)
	{
		addButtonToTitleBar();
	}

	private void addButtonToTitleBar()
	{
		try
		{
			BufferedImage iconImage = ImageIO.read(ScreenshotPlugin.class.getResourceAsStream("screenshot.png"));
			BufferedImage invertedIconImage = ImageIO.read(ScreenshotPlugin.class.getResourceAsStream("screenshot_inverted.png"));

			SwingUtilities.invokeLater(() ->
			{
				titleBarButton = new JButton();
				titleBarButton.setToolTipText("Take screenshot");
				titleBarButton.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mouseClicked(MouseEvent e)
					{
						super.mouseClicked(e);
						takeScreenshot(TIME_FORMAT.format(new Date()), client.getLocalPlayer() != null);
					}
				});

				clientUi.addButtonToTitleBar(titleBarButton, iconImage, invertedIconImage, 130);
			});
		}
		catch (IOException ex)
		{
			log.warn("Error adding screenshot button to titlebar", ex);
		}
	}

	private void removeButtonFromTitlebar()
	{
		SwingUtilities.invokeLater(() ->
		{
			JComponent titleBar = SubstanceCoreUtilities.getTitlePaneComponent(clientUi);

			if (titleBar != null)
			{
				titleBar.remove(titleBarButton);
				clientUi.revalidate();
				clientUi.repaint();
			}
		});
	}

	@Subscribe
	public void hideWidgets(WidgetHiddenChanged event)
	{
		Widget widget = event.getWidget();

		if (widget.isHidden())
		{
			return;
		}

		String fileName;

		switch (TO_GROUP(widget.getId()))
		{
			case LEVEL_UP_GROUP_ID:
			{
				Widget textChild = client.getWidget(WidgetInfo.LEVEL_UP_TEXT);

				if (textChild == null)
				{
					return;
				}

				// "Your Firemaking level is now 9."
				String text = textChild.getText();

				String skillName = text.substring(5, text.indexOf(" level"));
				String skillLevel = text.substring(text.lastIndexOf(" ") + 1, text.length() - 1);

				fileName = skillName + " (" + skillLevel + ")";
				break;
			}
			case QUEST_COMPLETED_GROUP_ID:
			{
				Widget textChild = client.getWidget(WidgetInfo.QUEST_COMPLETED_NAME_TEXT);

				if (textChild == null)
				{
					return;
				}

				// "You have completed The Corsair Curse!"
				String text = textChild.getText();

				fileName = text.substring(19, text.length() - 1);
				break;
			}
			default:
				return;
		}

		takeScreenshot(fileName, config.displayDate());
	}

	private void takeScreenshot(String fileName, boolean displayDate)
	{
		overlayRenderer.requestScreenshot(image ->
		{
			BufferedImage screenshot = config.includeFrame()
				? new BufferedImage(clientUi.getWidth(), clientUi.getHeight(), BufferedImage.TYPE_INT_ARGB)
				: new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

			Graphics graphics = screenshot.getGraphics();

			int gameOffsetX = 0;
			int gameOffsetY = 0;

			if (config.includeFrame())
			{
				// Draw the client frame onto the screenshot
				clientUi.paint(graphics);

				// Evaluate the position of the game inside the frame
				Point gamePoint = SwingUtilities.convertPoint(client.getCanvas(), 0, 0, clientUi);
				gameOffsetX = gamePoint.x;
				gameOffsetY = gamePoint.y;
			}

			// Draw the game onto the screenshot
			graphics.drawImage(image, gameOffsetX, gameOffsetY, null);

			if (displayDate)
			{
				try (InputStream reportButton = ScreenshotPlugin.class.getResourceAsStream("report_button.png"))
				{
					BufferedImage reportButtonImage = ImageIO.read(reportButton);

					int x = gameOffsetX + 403;
					int y = gameOffsetY + image.getHeight() - reportButtonImage.getHeight() - 1;

					graphics.drawImage(reportButtonImage, x, y, null);

					graphics.setFont(FontManager.getRunescapeSmallFont());
					FontMetrics fontMetrics = graphics.getFontMetrics();

					String date = DATE_FORMAT.format(new Date());
					int dateWidth = fontMetrics.stringWidth(date);
					int dateHeight = fontMetrics.getHeight();

					int textX = x + reportButtonImage.getWidth() / 2 - dateWidth / 2;
					int textY = y + reportButtonImage.getHeight() / 2 + dateHeight / 2;

					graphics.setColor(Color.BLACK);
					graphics.drawString(date, textX + 1, textY + 1);

					graphics.setColor(Color.WHITE);
					graphics.drawString(date, textX, textY);
				}
				catch (Exception ex)
				{
					log.warn("error displaying date on screenshot", ex);
				}
			}

			File playerFolder = RuneLite.SCREENSHOT_DIR;

			if (client.getLocalPlayer() != null)
			{
				playerFolder = new File(RuneLite.SCREENSHOT_DIR, client.getLocalPlayer().getName());
			}

			playerFolder.mkdirs();

			try
			{
				File screenshotFile = new File(playerFolder, fileName + ".png");

				ImageIO.write(screenshot, "PNG", screenshotFile);

				if (config.uploadScreenshot())
				{
					uploadScreenshot(screenshotFile);
				}
				else if (config.notifyWhenTaken())
				{
					notifier.notify("A screenshot was saved to " + screenshotFile, TrayIcon.MessageType.INFO);
				}
			}
			catch (IOException ex)
			{
				log.warn("error writing screenshot", ex);
			}
		});
	}

	private void uploadScreenshot(File screenshotFile) throws IOException
	{
		String json = RuneLiteAPI.GSON.toJson(new ImageUploadRequest(screenshotFile));

		Request request = new Request.Builder()
			.url(IMGUR_IMAGE_UPLOAD_URL)
			.addHeader("Authorization", "Client-ID " + IMGUR_CLIENT_ID)
			.post(RequestBody.create(JSON, json))
			.build();

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
				InputStream in = response.body().byteStream();
				ImageUploadResponse imageUploadResponse = RuneLiteAPI.GSON
					.fromJson(new InputStreamReader(in), ImageUploadResponse.class);

				if (imageUploadResponse.isSuccess())
				{
					String link = imageUploadResponse.getData().getLink();

					StringSelection selection = new StringSelection(link);
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(selection, selection);

					if (config.notifyWhenTaken())
					{
						notifier.notify("A screenshot was uploaded and inserted into your clipboard!", TrayIcon.MessageType.INFO);
					}
				}
			}
		});
	}
}
