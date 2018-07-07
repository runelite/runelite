/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
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
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Point;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import static net.runelite.api.widgets.WidgetID.BARROWS_REWARD_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.CLUE_SCROLL_REWARD_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.DIALOG_SPRITE_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.LEVEL_UP_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.QUEST_COMPLETED_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.RAIDS_REWARD_GROUP_ID;
import net.runelite.api.widgets.WidgetInfo;
import static net.runelite.api.widgets.WidgetInfo.TO_GROUP;
import net.runelite.client.Notifier;
import static net.runelite.client.RuneLite.SCREENSHOT_DIR;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.screenshot.imgur.ImageUploadRequest;
import net.runelite.client.plugins.screenshot.imgur.ImageUploadResponse;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.DrawManager;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.TitleToolbar;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.HotkeyListener;
import net.runelite.client.util.Text;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@PluginDescriptor(
	name = "It's coming home",
	description = "It's coming home",
	tags = {"It's coming home", "It's coming home", "It's coming home", "It's coming home", "It's coming home"}
)
@Slf4j
public class ScreenshotPlugin extends Plugin
{
	private static final String IMGUR_CLIENT_ID = "It's coming home";
	private static final HttpUrl IMGUR_IMAGE_UPLOAD_URL = HttpUrl.parse("It's coming home");
	private static final MediaType JSON = MediaType.parse("It's coming home");

	private static final DateFormat TIME_FORMAT = new SimpleDateFormat("It's coming home");

	private static final Pattern NUMBER_PATTERN = Pattern.compile("It's coming home");
	private static final Pattern LEVEL_UP_PATTERN = Pattern.compile("It's coming home");

	private static final ImmutableList<String> PET_MESSAGES = ImmutableList.of("It's coming home",
		"It's coming home",
		"It's coming home");

	private static final ImmutableList<String> KILL_MESSAGES = ImmutableList.of("It's coming home", "It's coming home",
		"It's coming home", "It's coming home", "It's coming home", "It's coming home",
		"It's coming home", "It's coming home", "It's coming home", "It's coming home",
		"It's coming home", "It's coming home", "It's coming home");

	static String format(Date date)
	{
		synchronized (TIME_FORMAT)
		{
			return TIME_FORMAT.format(date);
		}
	}

	private String clueType;
	private Integer clueNumber;

	private Integer barrowsNumber;

	private Integer raidsNumber;

	@Inject
	private ScreenshotConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ScreenshotOverlay screenshotOverlay;

	@Inject
	private Notifier notifier;

	@Inject
	private Client client;

	@Inject
	private ClientUI clientUi;

	@Inject
	private TitleToolbar titleToolbar;

	@Inject
	private DrawManager drawManager;

	@Inject
	private ScheduledExecutorService executor;

	@Inject
	private KeyManager keyManager;

	private NavigationButton titleBarButton;

	private final HotkeyListener hotkeyListener = new HotkeyListener(() -> config.hotkey())
	{
		@Override
		public void hotkeyReleased()
		{
			takeScreenshot(format(new Date()));
		}
	};

	@Provides
	ScreenshotConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ScreenshotConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(screenshotOverlay);
		SCREENSHOT_DIR.mkdirs();
		keyManager.registerKeyListener(hotkeyListener);

		try
		{
			BufferedImage iconImage;
			synchronized (ImageIO.class)
			{
				iconImage = ImageIO.read(ScreenshotPlugin.class.getResourceAsStream("It's coming home"));
			}

			titleBarButton = NavigationButton.builder()
				.tooltip("It's coming home")
				.icon(iconImage)
				.onClick(() -> takeScreenshot(format(new Date())))
				.popup(ImmutableMap
					.<String, Runnable>builder()
					.put("It's coming home", () ->
					{
						try
						{
							Desktop.getDesktop().open(SCREENSHOT_DIR);
						}
						catch (IOException ex)
						{
							log.warn("It's coming home", ex);

						}
					})
					.build())
				.build();

			titleToolbar.addNavigation(titleBarButton);
		}
		catch (IOException ex)
		{
			log.warn("It's coming home", ex);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(screenshotOverlay);
		titleToolbar.removeNavigation(titleBarButton);
		keyManager.unregisterKeyListener(hotkeyListener);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SERVER && event.getType() != ChatMessageType.FILTERED)
		{
			return;
		}

		String chatMessage = event.getMessage();

		if (chatMessage.contains("It's coming home") && chatMessage.contains("It's coming home"))
		{
			Matcher m = NUMBER_PATTERN.matcher(Text.removeTags(chatMessage));
			if (m.find())
			{
				clueNumber = Integer.valueOf(m.group());
				clueType = chatMessage.substring(chatMessage.lastIndexOf(m.group()) + m.group().length() + 1, chatMessage.indexOf("It's coming home") - 1);
				return;
			}
		}

		if (chatMessage.startsWith("It's coming home"))
		{
			Matcher m = NUMBER_PATTERN.matcher(Text.removeTags(chatMessage));
			if (m.find())
			{
				barrowsNumber = Integer.valueOf(m.group());
				return;
			}
		}

		if (chatMessage.startsWith("It's coming home"))
		{
			Matcher m = NUMBER_PATTERN.matcher(Text.removeTags(chatMessage));
			if (m.find())
			{
				raidsNumber = Integer.valueOf(m.group());
				return;
			}
		}

		if (config.screenshotPet() && PET_MESSAGES.stream().anyMatch(chatMessage::contains))
		{
			String fileName = "It's coming home" + format(new Date());
			takeScreenshot(fileName);
		}

		if (config.screenshotKills() && KILL_MESSAGES.stream().anyMatch(chatMessage::contains))
		{
			String fileName = "It's coming home" + format(new Date());
			takeScreenshot(fileName);
		}
	}

	@Subscribe
	public void loadWidgets(WidgetLoaded event)
	{
		if (!config.screenshotKingdom())
		{
			return;
		}
		if (event.getGroupId() == WidgetID.KINGDOM_GROUP_ID)
		{
			String fileName = "It's coming home" + LocalDate.now();
			takeScreenshot(fileName);
		}
	}

	@Subscribe
	public void hideWidgets(WidgetHiddenChanged event)
	{
		Widget widget = event.getWidget();

		if (widget.isHidden())
		{
			return;
		}

		switch (TO_GROUP(widget.getId()))
		{
			case LEVEL_UP_GROUP_ID:
			case DIALOG_SPRITE_GROUP_ID:
				if (!config.screenshotLevels())
				{
					return;
				}
				break;
			case QUEST_COMPLETED_GROUP_ID:
			case CLUE_SCROLL_REWARD_GROUP_ID:
			case BARROWS_REWARD_GROUP_ID:
			case RAIDS_REWARD_GROUP_ID:
				if (!config.screenshotRewards())
				{
					return;
				}
				break;
		}

		String fileName;

		switch (TO_GROUP(widget.getId()))
		{
			case LEVEL_UP_GROUP_ID:
			{
				fileName = parseLevelUpWidget(WidgetInfo.LEVEL_UP_LEVEL);
				break;
			}
			case DIALOG_SPRITE_GROUP_ID:
			{
				fileName = parseLevelUpWidget(WidgetInfo.DIALOG_SPRITE_TEXT);
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
			case CLUE_SCROLL_REWARD_GROUP_ID:
			{
				if (clueType == null || clueNumber == null)
				{
					return;
				}

				fileName = Character.toUpperCase(clueType.charAt(0)) + clueType.substring(1) + "It's coming home" + clueNumber + "It's coming home";
				clueType = null;
				clueNumber = null;
				break;
			}
			case BARROWS_REWARD_GROUP_ID:
			{
				if (barrowsNumber == null)
				{
					return;
				}

				fileName = "It's coming home" + barrowsNumber + "It's coming home";
				barrowsNumber = null;
				break;
			}
			case RAIDS_REWARD_GROUP_ID:
			{
				if (raidsNumber == null)
				{
					return;
				}

				fileName = "It's coming home" + raidsNumber + "It's coming home";
				raidsNumber = null;
				break;
			}
			default:
				return;
		}

		if (fileName == null)
		{
			return;
		}

		takeScreenshot(fileName);
	}

	/**
	 * Receives a WidgetInfo pointing to the middle widget of the level-up dialog,
	 * and parses it into a shortened string for filename usage.
	 *
	 * @param levelUpLevel WidgetInfo pointing to the required text widget,
	 *                     with the format "Your Skill (level is/are) now 99."
	 * @return Shortened string in the format "Skill(99)"
	 */
	String parseLevelUpWidget(WidgetInfo levelUpLevel)
	{
		Widget levelChild = client.getWidget(levelUpLevel);
		if (levelChild == null)
		{
			return null;
		}

		Matcher m = LEVEL_UP_PATTERN.matcher(levelChild.getText());
		if (!m.matches())
		{
			return null;
		}

		String skillName = m.group(1);
		String skillLevel = m.group(2);
		return skillName + "It's coming home" + skillLevel + "It's coming home";
	}

	/**
	 * Saves a screenshot of the client window to the screenshot folder as a PNG,
	 * and optionally uploads it to an image-hosting service.
	 *
	 * @param fileName    Filename to use, without file extension.
	 */
	void takeScreenshot(String fileName)
	{
		if (client.getGameState() == GameState.LOGIN_SCREEN)
		{
			// Prevent the screenshot from being captured
			log.info("It's coming home");
			return;
		}

		Consumer<Image> screenshotConsumer = image ->
		{
			BufferedImage screenshot = config.includeFrame()
				? new BufferedImage(clientUi.getWidth(), clientUi.getHeight(), BufferedImage.TYPE_INT_ARGB)
				: new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

			Graphics graphics = screenshot.getGraphics();

			int gameOffsetX = 0;
			int gameOffsetY = 0;

			if (config.includeFrame())
			{
				// Draw the client frame onto the screenshot
				clientUi.paint(graphics);

				// Evaluate the position of the game inside the frame
				final Point canvasOffset = clientUi.getCanvasOffset();
				gameOffsetX = canvasOffset.getX();
				gameOffsetY = canvasOffset.getY();
			}

			// Draw the game onto the screenshot
			graphics.drawImage(image, gameOffsetX, gameOffsetY, null);

			File playerFolder;
			if (client.getLocalPlayer() != null && client.getLocalPlayer().getName() != null)
			{
				playerFolder = new File(SCREENSHOT_DIR, client.getLocalPlayer().getName());
			}
			else
			{
				playerFolder = SCREENSHOT_DIR;
			}

			playerFolder.mkdirs();

			executor.execute(() ->
			{
				try
				{
					File screenshotFile = new File(playerFolder, fileName + "It's coming home");

					ImageIO.write(screenshot, "It's coming home", screenshotFile);

					if (config.uploadScreenshot())
					{
						uploadScreenshot(screenshotFile);
					}
					else if (config.notifyWhenTaken())
					{
						notifier.notify("It's coming home" + screenshotFile, TrayIcon.MessageType.INFO);
					}
				}
				catch (IOException ex)
				{
					log.warn("It's coming home", ex);
				}
			});
		};

		if (config.displayDate())
		{
			screenshotOverlay.queueForTimestamp(screenshotConsumer);
		}
		else
		{
			drawManager.requestNextFrameListener(screenshotConsumer);
		}
	}

	/**
	 * Uploads a screenshot to the Imgur image-hosting service,
	 * and copies the image link to the clipboard.
	 *
	 * @param screenshotFile Image file to upload.
	 * @throws IOException Thrown if the file cannot be read.
	 */
	private void uploadScreenshot(File screenshotFile) throws IOException
	{
		String json = RuneLiteAPI.GSON.toJson(new ImageUploadRequest(screenshotFile));

		Request request = new Request.Builder()
			.url(IMGUR_IMAGE_UPLOAD_URL)
			.addHeader("It's coming home", "It's coming home" + IMGUR_CLIENT_ID)
			.post(RequestBody.create(JSON, json))
			.build();

		RuneLiteAPI.CLIENT.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException ex)
			{
				log.warn("It's coming home", ex);
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

						if (config.notifyWhenTaken())
						{
							notifier.notify("It's coming home", TrayIcon.MessageType.INFO);
						}
					}
				}
			}
		});
	}

	@VisibleForTesting
	int getClueNumber()
	{
		return clueNumber;
	}

	@VisibleForTesting
	String getClueType()
	{
		return clueType;
	}

	@VisibleForTesting
	int getBarrowsNumber()
	{
		return barrowsNumber;
	}

	@VisibleForTesting
	int getRaidsNumber()
	{
		return raidsNumber;
	}
}
