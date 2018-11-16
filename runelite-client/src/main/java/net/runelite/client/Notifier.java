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
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.OSType;

@Singleton
@Slf4j
public class Notifier
{
	// Default timeout of notification in milliseconds
	private static final int DEFAULT_TIMEOUT = 10000;
	private static final String DOUBLE_QUOTE = "\"";
	private static final Escaper SHELL_ESCAPE = Escapers.builder()
		.addEscape('"', "'")
		.build();

	// Notifier properties
	private static final Color FLASH_COLOR = new Color(255, 0, 0, 70);
	private static final int FLASH_DURATION = 2000;
	private static final Color MESSAGE_COLOR = Color.RED;

	private final Client client;
	private final String appName;
	private final RuneLiteConfig runeLiteConfig;
	private final ClientUI clientUI;
	private final ScheduledExecutorService executorService;
	private final ChatMessageManager chatMessageManager;
	private final Path notifyIconPath;
	private final boolean terminalNotifierAvailable;
	private Instant flashStart;

	@Inject
	private Notifier(
		final ClientUI clientUI,
		final Client client,
		final RuneLiteConfig runeliteConfig,
		final RuneLiteProperties runeLiteProperties,
		final ScheduledExecutorService executorService,
		final ChatMessageManager chatMessageManager)
	{
		this.client = client;
		this.appName = runeLiteProperties.getTitle();
		this.clientUI = clientUI;
		this.runeLiteConfig = runeliteConfig;
		this.executorService = executorService;
		this.chatMessageManager = chatMessageManager;
		this.notifyIconPath = RuneLite.RUNELITE_DIR.toPath().resolve("icon.png");

		// First check if we are running in launcher
		this.terminalNotifierAvailable =
			!Strings.isNullOrEmpty(RuneLiteProperties.getLauncherVersion())
			&& isTerminalNotifierAvailable();

		storeIcon();
	}

	public void notify(String message)
	{
		notify(message, TrayIcon.MessageType.NONE);
	}

	public void notify(String message, TrayIcon.MessageType type)
	{
		if (!runeLiteConfig.sendNotificationsWhenFocused() && clientUI.isFocused())
		{
			return;
		}

		if (runeLiteConfig.requestFocusOnNotification())
		{
			clientUI.requestFocus();
		}

		if (runeLiteConfig.enableTrayNotifications())
		{
			sendNotification(appName, message, type);
		}

		if (runeLiteConfig.enableNotificationSound())
		{
			Toolkit.getDefaultToolkit().beep();
		}

		if (runeLiteConfig.enableGameMessageNotification() && client.getGameState() == GameState.LOGGED_IN)
		{
			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.GAME)
				.name(appName)
				.value(ColorUtil.wrapWithColorTag(message, MESSAGE_COLOR))
				.build());
		}

		if (runeLiteConfig.enableFlashNotification())
		{
			flashStart = Instant.now();
		}
	}

	public void processFlash(final Graphics2D graphics)
	{
		if (flashStart == null)
		{
			return;
		}

		if (client.getGameCycle() % 40 >= 20)
		{
			return;
		}

		final Color color = graphics.getColor();
		graphics.setColor(FLASH_COLOR);
		graphics.fill(new Rectangle(client.getCanvas().getSize()));
		graphics.setColor(color);

		if (Instant.now().minusMillis(FLASH_DURATION).isAfter(flashStart))
		{
			flashStart = null;
		}
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
		commands.add("-i");
		commands.add(SHELL_ESCAPE.escape(notifyIconPath.toAbsolutePath().toString()));
		commands.add("-u");
		commands.add(toUrgency(type));
		commands.add("-t");
		commands.add(String.valueOf(DEFAULT_TIMEOUT));

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
			commands.add("terminal-notifier");
			commands.add("-group");
			commands.add("net.runelite.launcher");
			commands.add("-sender");
			commands.add("net.runelite.launcher");
			commands.add("-message");
			commands.add(DOUBLE_QUOTE + message + DOUBLE_QUOTE);
			commands.add("-title");
			commands.add(DOUBLE_QUOTE + title + DOUBLE_QUOTE);
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
		return new ProcessBuilder(commands.toArray(new String[commands.size()]))
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
		if (OSType.getOSType() == OSType.MacOS)
		{
			try
			{
				final Process exec = Runtime.getRuntime().exec(new String[]{"terminal-notifier", "-help"});
				exec.waitFor();
				return exec.exitValue() == 0;
			}
			catch (IOException | InterruptedException e)
			{
				return false;
			}
		}

		return false;
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
}
