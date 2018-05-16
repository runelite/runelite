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
import java.util.Optional;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Provider;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.ui.ClientUI;
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
	private static final String MESSAGE_COLOR = "FF0000";

	private final Provider<Client> client;
	private final String appName;
	private final RuneLiteConfig runeLiteConfig;
	private final Provider<ClientUI> clientUI;
	private final ScheduledExecutorService executorService;
	private final Path notifyIconPath;
	private Instant flashStart;

	@Inject
	private Notifier(
			final Provider<ClientUI> clientUI,
			final Provider<Client> client,
			final RuneLiteConfig runeliteConfig,
			final RuneLiteProperties runeLiteProperties,
			final ScheduledExecutorService executorService)
	{
		this.client = client;
		this.appName = runeLiteProperties.getTitle();
		this.clientUI = clientUI;
		this.runeLiteConfig = runeliteConfig;
		this.executorService = executorService;
		this.notifyIconPath = RuneLite.RUNELITE_DIR.toPath().resolve("icon.png");
		storeIcon();
	}

	public void notify(String message)
	{
		notify(message, TrayIcon.MessageType.NONE);
	}

	public void notify(String message, TrayIcon.MessageType type)
	{
		final ClientUI clientUI = this.clientUI.get();

		if (clientUI == null)
		{
			return;
		}

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

		if (runeLiteConfig.enableGameMessageNotification())
		{
			final Client client = this.client.get();

			if (client != null && client.getGameState() == GameState.LOGGED_IN)
			{
				client.addChatMessage(ChatMessageType.GAME, appName,
					"<col=" + MESSAGE_COLOR + ">" + message + "</col>", "");
			}
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

		final Client client = this.client.get();

		if (client == null || client.getGameCycle() % 40 >= 20)
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
		final String escapedSubtitle = null;

		switch (OSType.getOSType())
		{
			case Linux:
				sendLinuxNotification(escapedTitle, escapedMessage, type);
				break;
			case MacOS:
				sendMacNotification(escapedTitle, escapedMessage, escapedSubtitle);
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
		final ClientUI clientUI = this.clientUI.get();

		if (clientUI == null)
		{
			return;
		}

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
			final boolean success = sendCommand(commands)
					.map(process -> process.exitValue() == 0)
					.orElse(false);

			if (!success)
			{
				sendTrayNotification(title, message, type);
			}
		});
	}

	private void sendMacNotification(
		final String title,
		final String message,
		final String subtitle)
	{
		final List<String> commands = new ArrayList<>();
		commands.add("osascript");
		commands.add("-e");

		final StringBuilder script = new StringBuilder("display notification ");

		script.append(DOUBLE_QUOTE)
			.append(message)
			.append(DOUBLE_QUOTE);

		script.append(" with title ")
			.append(DOUBLE_QUOTE)
			.append(title)
			.append(DOUBLE_QUOTE);

		if (subtitle != null)
		{
			script.append(" subtitle ")
				.append(DOUBLE_QUOTE)
				.append(subtitle)
				.append(DOUBLE_QUOTE);
		}

		commands.add(script.toString());
		sendCommand(commands);
	}

	private Optional<Process> sendCommand(final List<String> commands)
	{
		try
		{
			return Optional.of(new ProcessBuilder(commands.toArray(new String[commands.size()]))
				.redirectErrorStream(true)
				.start());
		}
		catch (IOException ex)
		{
			log.warn(null, ex);
		}

		return Optional.empty();
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
