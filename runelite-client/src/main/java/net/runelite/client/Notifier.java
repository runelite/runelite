/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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

import com.google.common.base.Strings;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import com.google.inject.Inject;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.client.audio.AudioPlayer;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.FlashNotification;
import net.runelite.client.config.Notification;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.NotificationFired;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.util.OSType;

@Singleton
@Slf4j
public class Notifier
{
	private static final String DOUBLE_QUOTE = "\"";
	private static final Escaper SHELL_ESCAPE = Escapers.builder()
		.addEscape('"', "'")
		.build();

	// Notifier properties
	private static final int MINIMUM_FLASH_DURATION_MILLIS = 2000;
	private static final int MINIMUM_FLASH_DURATION_TICKS = MINIMUM_FLASH_DURATION_MILLIS / Constants.CLIENT_TICK_LENGTH;

	private static final File NOTIFICATION_FILE = new File(RuneLite.RUNELITE_DIR, "notification.wav");
	private static final File NOTIFICATIONS_DIR = RuneLite.NOTIFICATIONS_DIR;

	private final Client client;
	private final RuneLiteConfig runeLiteConfig;
	private final ClientUI clientUI;
	private final ScheduledExecutorService executorService;
	private final ChatMessageManager chatMessageManager;
	private final EventBus eventBus;
	private final AudioPlayer audioPlayer;
	private final String appName;
	private final Path notifyIconPath;
	private boolean terminalNotifierAvailable;
	private Instant flashStart;
	private FlashNotification flashNotification;
	private Color flashColor;
	private long mouseLastPressedMillis;

	@Inject
	private Notifier(
		final ClientUI clientUI,
		final Client client,
		final RuneLiteConfig runeliteConfig,
		final ScheduledExecutorService executorService,
		final ChatMessageManager chatMessageManager,
		final EventBus eventBus,
		final AudioPlayer audioPlayer,
		@Named("runelite.title") final String appName
	)
	{
		this.client = client;
		this.clientUI = clientUI;
		this.runeLiteConfig = runeliteConfig;
		this.executorService = executorService;
		this.chatMessageManager = chatMessageManager;
		this.eventBus = eventBus;
		this.audioPlayer = audioPlayer;
		this.appName = appName;
		this.notifyIconPath = RuneLite.RUNELITE_DIR.toPath().resolve("icon.png");

		// Check if we are running in the launcher because terminal-notifier notifications don't work
		// if the group/sender are unknown to it.
		if (!Strings.isNullOrEmpty(RuneLiteProperties.getLauncherVersion()) && OSType.getOSType() == OSType.MacOS)
		{
			executorService.execute(() -> terminalNotifierAvailable = isTerminalNotifierAvailable());
		}

		storeIcon();

		NOTIFICATIONS_DIR.mkdirs();
	}

	private Notification defaultNotification(TrayIcon.MessageType trayMessageType)
	{
		// Create a new notification just using the RuneLite notification settings
		return new Notification(true, true,
			true, // Not really overriden, but this it to avoid recreating the notification due to !override
			runeLiteConfig.enableTrayNotifications(), trayMessageType, runeLiteConfig.notificationRequestFocus(),
			runeLiteConfig.notificationSound(), null, // RuneLite notification settings doesn't support file sounds
			runeLiteConfig.notificationVolume(), runeLiteConfig.notificationTimeout(),
			runeLiteConfig.enableGameMessageNotification(), runeLiteConfig.flashNotification(), runeLiteConfig.notificationFlashColor(),
			runeLiteConfig.sendNotificationsWhenFocused());
	}

	public void notify(String message)
	{
		var notif = defaultNotification(TrayIcon.MessageType.NONE);
		notify(notif, message);
	}

	public void notify(String message, TrayIcon.MessageType type)
	{
		var notif = defaultNotification(type);
		notify(notif, message);
	}

	public void notify(Notification notification, String message)
	{
		if (!notification.isEnabled())
		{
			return;
		}

		// Non-overriden notifications use the default notification settings.
		if (!notification.isOverride() || !notification.isInitialized())
		{
			notification = defaultNotification(notification.getTrayIconType());
		}

		assert notification.isInitialized();

		log.debug("{}", message);
		eventBus.post(new NotificationFired(notification, message, notification.getTrayIconType()));

		if (!notification.isSendWhenFocused() && clientUI.isFocused())
		{
			return;
		}

		switch (notification.getRequestFocus())
		{
			case REQUEST:
				clientUI.requestFocus();
				break;
			case TASKBAR:
				clientUI.flashTaskbar();
				break;
			case FORCE:
				clientUI.forceFocus();
				break;
		}

		if (notification.isTray())
		{
			sendNotification(notification, buildTitle(), message);
		}

		switch (notification.getSound())
		{
			case NATIVE:
				Toolkit.getDefaultToolkit().beep();
				break;
			case CUSTOM:
				var n = notification;
				executorService.submit(() -> tryPlayCustomSound(n));
		}

		if (notification.isGameMessage() && client.getGameState() == GameState.LOGGED_IN)
		{
			final String formattedMessage = new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append(message)
				.build();

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.name(appName)
				.runeLiteFormattedMessage(formattedMessage)
				.build());
		}

		if (notification.getFlash() != FlashNotification.DISABLED)
		{
			flashNotification = notification.getFlash();
			flashColor = notification.getFlashColor();
			flashStart = Instant.now();
			mouseLastPressedMillis = client.getMouseLastPressedMillis();
		}
	}

	private String buildTitle()
	{
		Player player = client.getLocalPlayer();
		if (player == null)
		{
			return appName;
		}

		String name = player.getName();
		if (Strings.isNullOrEmpty(name))
		{
			return appName;
		}

		return appName + " - " + name;
	}

	public void processFlash(final Graphics2D graphics)
	{
		if (flashStart == null || flashNotification == null || flashColor == null
			|| client.getGameState() != GameState.LOGGED_IN
			|| flashNotification == FlashNotification.DISABLED)
		{
			flashStart = null;
			flashNotification = null;
			flashColor = null;
			return;
		}

		if (Instant.now().minusMillis(MINIMUM_FLASH_DURATION_MILLIS).isAfter(flashStart))
		{
			switch (flashNotification)
			{
				case FLASH_TWO_SECONDS:
				case SOLID_TWO_SECONDS:
					flashStart = null;
					flashNotification = null;
					flashColor = null;
					return;
				case SOLID_UNTIL_CANCELLED:
				case FLASH_UNTIL_CANCELLED:
					// Any interaction with the client since the notification started will cancel it after the minimum duration
					if ((client.getMouseIdleTicks() < MINIMUM_FLASH_DURATION_TICKS
						|| client.getKeyboardIdleTicks() < MINIMUM_FLASH_DURATION_TICKS
						|| client.getMouseLastPressedMillis() > mouseLastPressedMillis) && clientUI.isFocused())
					{
						flashStart = null;
						flashNotification = null;
						flashColor = null;
						return;
					}
					break;
			}
		}

		if (client.getGameCycle() % 40 >= 20
			// For solid colour, fall through every time.
			&& (flashNotification == FlashNotification.FLASH_TWO_SECONDS
			|| flashNotification == FlashNotification.FLASH_UNTIL_CANCELLED))
		{
			return;
		}

		final Color color = graphics.getColor();
		graphics.setColor(flashColor);
		graphics.fill(new Rectangle(client.getCanvas().getSize()));
		graphics.setColor(color);
	}

	private void sendNotification(
		final Notification notification,
		final String title,
		final String message)
	{
		switch (OSType.getOSType())
		{
			case Linux:
				sendLinuxNotification(notification, title, message);
				break;
			case MacOS:
				sendMacNotification(title, message);
				break;
			default:
				sendTrayNotification(notification, title, message);
		}
	}

	private void sendTrayNotification(
		final Notification notification,
		final String title,
		final String message)
	{
		if (clientUI.getTrayIcon() != null)
		{
			clientUI.getTrayIcon().displayMessage(title, message, notification.getTrayIconType());
		}
	}

	private void sendLinuxNotification(
		final Notification notification,
		final String title,
		final String message)
	{
		final List<String> commands = new ArrayList<>();
		commands.add("notify-send");
		commands.add(title);
		commands.add(message);
		commands.add("-a");
		commands.add(SHELL_ESCAPE.escape(appName));
		commands.add("-i");
		commands.add(SHELL_ESCAPE.escape(notifyIconPath.toAbsolutePath().toString()));
		commands.add("-u");
		commands.add(toUrgency(notification.getTrayIconType()));
		if (notification.getTimeout() > 0)
		{
			commands.add("-t");
			commands.add(String.valueOf(notification.getTimeout()));
		}

		executorService.submit(() ->
		{
			try
			{
				Process notificationProcess = sendCommand(commands);

				boolean exited = notificationProcess.waitFor(500, TimeUnit.MILLISECONDS);
				if (exited && notificationProcess.exitValue() == 0)
				{
					return;
				}
			}
			catch (IOException | InterruptedException ex)
			{
				log.debug("error sending notification", ex);
			}

			// fall back to tray notification
			sendTrayNotification(notification, title, message);
		});
	}

	private void sendMacNotification(final String title, final String message)
	{
		final List<String> commands = new ArrayList<>();

		if (terminalNotifierAvailable)
		{
			Collections.addAll(commands,
				"sh", "-lc", "\"$@\"", "--",
				"terminal-notifier",
				"-title", title,
				"-message", message,
				"-group", "net.runelite.launcher",
				"-sender", "net.runelite.launcher"
			);
		}
		else
		{
			commands.add("osascript");
			commands.add("-e");

			final String script = "display notification " + DOUBLE_QUOTE +
				SHELL_ESCAPE.escape(message) +
				DOUBLE_QUOTE +
				" with title " +
				DOUBLE_QUOTE +
				SHELL_ESCAPE.escape(title) +
				DOUBLE_QUOTE;

			commands.add(script);
		}

		try
		{
			sendCommand(commands);
		}
		catch (IOException ex)
		{
			log.warn("error sending notification", ex);
		}
	}

	private static Process sendCommand(final List<String> commands) throws IOException
	{
		return new ProcessBuilder(commands)
			.redirectErrorStream(true)
			.start();
	}

	private void storeIcon()
	{
		if (OSType.getOSType() == OSType.Linux && !Files.exists(notifyIconPath))
		{
			try (InputStream stream = Notifier.class.getResourceAsStream("/net/runelite/client/ui/runelite_128.png"))
			{
				Files.copy(stream, notifyIconPath);
			}
			catch (IOException ex)
			{
				log.warn(null, ex);
			}
		}
	}

	private boolean isTerminalNotifierAvailable()
	{
		try
		{
			// The PATH seen by Cocoa apps does not resemble that seen by the shell, so we defer to the latter.
			final Process exec = Runtime.getRuntime().exec(new String[]{"sh", "-lc", "terminal-notifier -help"});
			if (!exec.waitFor(2, TimeUnit.SECONDS))
			{
				return false;
			}
			return exec.exitValue() == 0;
		}
		catch (IOException | InterruptedException e)
		{
			return false;
		}
	}

	private static String toUrgency(TrayIcon.MessageType type)
	{
		switch (type)
		{
			case WARNING:
			case ERROR:
				return "critical";
			default:
				return "normal";
		}
	}

	private void tryPlayCustomSound(Notification notification)
	{
		// converts user controlled linear volume ranging 1-100 to exponential decibel gains
		float volume = notification.getVolume() / 100f;
		float gainDB = (float) Math.log10(volume) * 20;

		try
		{
			if (notification.getSoundName() != null)
			{
				audioPlayer.play(new File(NOTIFICATIONS_DIR, notification.getSoundName()), gainDB);
			}
			else if (NOTIFICATION_FILE.exists())
			{
				audioPlayer.play(NOTIFICATION_FILE, gainDB);
			}
			else
			{
				audioPlayer.play(Notifier.class, "notification.wav", gainDB);
			}
		}
		catch (Exception e)
		{
			log.warn("Unable to play notification sound", e);
		}
	}
}
