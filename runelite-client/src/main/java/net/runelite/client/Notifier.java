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
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.FlashNotification;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.NotificationFired;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.util.OSType;

@Singleton
@Slf4j
public class Notifier
{
	@Getter
	@RequiredArgsConstructor
	public enum NativeCustomOff
	{
		NATIVE("Native"),
		CUSTOM("Custom"),
		OFF("Off");

		private final String name;

		@Override
		public String toString()
		{
			return name;
		}
	}

	private static final String DOUBLE_QUOTE = "\"";
	private static final Escaper SHELL_ESCAPE = Escapers.builder()
		.addEscape('"', "'")
		.build();

	// Notifier properties
	private static final int MINIMUM_FLASH_DURATION_MILLIS = 2000;
	private static final int MINIMUM_FLASH_DURATION_TICKS = MINIMUM_FLASH_DURATION_MILLIS / Constants.CLIENT_TICK_LENGTH;

	private static final File NOTIFICATION_FILE = new File(RuneLite.RUNELITE_DIR, "notification.wav");
	private static final long CLIP_MTIME_UNLOADED = -2;
	private static final long CLIP_MTIME_BUILTIN = -1;

	private final Client client;
	private final RuneLiteConfig runeLiteConfig;
	private final ClientUI clientUI;
	private final ScheduledExecutorService executorService;
	private final ChatMessageManager chatMessageManager;
	private final EventBus eventBus;
	private final String appName;
	private final Path notifyIconPath;
	private boolean terminalNotifierAvailable;
	private Instant flashStart;
	private long mouseLastPressedMillis;
	private long lastClipMTime = CLIP_MTIME_UNLOADED;
	private Clip clip = null;

	@Inject
	private Notifier(
		final ClientUI clientUI,
		final Client client,
		final RuneLiteConfig runeliteConfig,
		final ScheduledExecutorService executorService,
		final ChatMessageManager chatMessageManager,
		final EventBus eventBus,
		@Named("runelite.title") final String appName
	)
	{
		this.client = client;
		this.clientUI = clientUI;
		this.runeLiteConfig = runeliteConfig;
		this.executorService = executorService;
		this.chatMessageManager = chatMessageManager;
		this.eventBus = eventBus;
		this.appName = appName;
		this.notifyIconPath = RuneLite.RUNELITE_DIR.toPath().resolve("icon.png");

		// Check if we are running in the launcher because terminal-notifier notifications don't work
		// if the group/sender are unknown to it.
		if (!Strings.isNullOrEmpty(RuneLiteProperties.getLauncherVersion()) && OSType.getOSType() == OSType.MacOS)
		{
			executorService.execute(() -> terminalNotifierAvailable = isTerminalNotifierAvailable());
		}

		storeIcon();
	}

	public void notify(String message)
	{
		notify(message, TrayIcon.MessageType.NONE);
	}

	public void notify(String message, TrayIcon.MessageType type)
	{
		eventBus.post(new NotificationFired(message, type));

		if (!runeLiteConfig.sendNotificationsWhenFocused() && clientUI.isFocused())
		{
			return;
		}

		switch (runeLiteConfig.notificationRequestFocus())
		{
			case REQUEST:
				clientUI.requestFocus();
				break;
			case FORCE:
				clientUI.forceFocus();
				break;
		}

		if (runeLiteConfig.enableTrayNotifications())
		{
			sendNotification(buildTitle(), message, type);
		}

		switch (runeLiteConfig.notificationSound())
		{
			case NATIVE:
				Toolkit.getDefaultToolkit().beep();
				break;
			case CUSTOM:
				executorService.submit(this::playCustomSound);
		}

		if (runeLiteConfig.enableGameMessageNotification() && client.getGameState() == GameState.LOGGED_IN)
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

		if (runeLiteConfig.flashNotification() != FlashNotification.DISABLED)
		{
			flashStart = Instant.now();
			mouseLastPressedMillis = client.getMouseLastPressedMillis();
		}

		log.debug(message);
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
		FlashNotification flashNotification = runeLiteConfig.flashNotification();

		if (flashStart == null || client.getGameState() != GameState.LOGGED_IN
			|| flashNotification == FlashNotification.DISABLED)
		{
			flashStart = null;
			return;
		}

		if (Instant.now().minusMillis(MINIMUM_FLASH_DURATION_MILLIS).isAfter(flashStart))
		{
			switch (flashNotification)
			{
				case FLASH_TWO_SECONDS:
				case SOLID_TWO_SECONDS:
					flashStart = null;
					return;
				case SOLID_UNTIL_CANCELLED:
				case FLASH_UNTIL_CANCELLED:
					// Any interaction with the client since the notification started will cancel it after the minimum duration
					if ((client.getMouseIdleTicks() < MINIMUM_FLASH_DURATION_TICKS
						|| client.getKeyboardIdleTicks() < MINIMUM_FLASH_DURATION_TICKS
						|| client.getMouseLastPressedMillis() > mouseLastPressedMillis) && clientUI.isFocused())
					{
						flashStart = null;
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
		graphics.setColor(runeLiteConfig.notificationFlashColor());
		graphics.fill(new Rectangle(client.getCanvas().getSize()));
		graphics.setColor(color);
	}

	private void sendNotification(
		final String title,
		final String message,
		final TrayIcon.MessageType type)
	{
		final String escapedTitle = SHELL_ESCAPE.escape(title);
		final String escapedMessage = SHELL_ESCAPE.escape(message);

		switch (OSType.getOSType())
		{
			case Linux:
				sendLinuxNotification(escapedTitle, escapedMessage, type);
				break;
			case MacOS:
				sendMacNotification(escapedTitle, escapedMessage);
				break;
			default:
				sendTrayNotification(title, message, type);
		}
	}

	private void sendTrayNotification(
		final String title,
		final String message,
		final TrayIcon.MessageType type)
	{
		if (clientUI.getTrayIcon() != null)
		{
			clientUI.getTrayIcon().displayMessage(title, message, type);
		}
	}

	private void sendLinuxNotification(
		final String title,
		final String message,
		final TrayIcon.MessageType type)
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
		commands.add(toUrgency(type));
		if (runeLiteConfig.notificationTimeout() > 0)
		{
			commands.add("-t");
			commands.add(String.valueOf(runeLiteConfig.notificationTimeout()));
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
			sendTrayNotification(title, message, type);
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
				message +
				DOUBLE_QUOTE +
				" with title " +
				DOUBLE_QUOTE +
				title +
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
			try (InputStream stream = Notifier.class.getResourceAsStream("/runelite.png"))
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

	private synchronized void playCustomSound()
	{
		long currentMTime = NOTIFICATION_FILE.exists() ? NOTIFICATION_FILE.lastModified() : CLIP_MTIME_BUILTIN;
		if (clip == null || currentMTime != lastClipMTime || !clip.isOpen())
		{
			if (clip != null)
			{
				clip.close();
			}

			try
			{
				clip = AudioSystem.getClip();
			}
			catch (LineUnavailableException e)
			{
				lastClipMTime = CLIP_MTIME_UNLOADED;
				log.warn("Unable to play notification", e);
				Toolkit.getDefaultToolkit().beep();
				return;
			}

			lastClipMTime = currentMTime;

			if (!tryLoadNotification())
			{
				Toolkit.getDefaultToolkit().beep();
				return;
			}
		}

		// Using loop instead of start + setFramePosition prevents a the clip
		// from not being played sometimes, presumably a race condition in the
		// underlying line driver
		clip.loop(1);
	}

	private boolean tryLoadNotification()
	{
		if (NOTIFICATION_FILE.exists())
		{
			try (InputStream fileStream = new BufferedInputStream(new FileInputStream(NOTIFICATION_FILE));
				AudioInputStream sound = AudioSystem.getAudioInputStream(fileStream))
			{
				clip.open(sound);
				return true;
			}
			catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
			{
				log.warn("Unable to load notification sound", e);
			}
		}

		// Otherwise load from the classpath
		try (InputStream fileStream = new BufferedInputStream(Notifier.class.getResourceAsStream("notification.wav"));
			AudioInputStream sound = AudioSystem.getAudioInputStream(fileStream))
		{
			clip.open(sound);
			return true;
		}
		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
		{
			log.warn("Unable to load builtin notification sound", e);
		}
		return false;
	}
}
