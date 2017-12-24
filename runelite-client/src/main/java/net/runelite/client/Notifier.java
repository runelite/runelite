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
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Notifier
{
	private enum OSType
	{
		Windows, MacOS, Linux, Other
	};

	private static final String DOUBLE_QUOTE = "\"";
	private static final Escaper SHELL_ESCAPE;
	private static final OSType DETECTED_OS;

	static
	{
		final Escapers.Builder builder = Escapers.builder();
		builder.addEscape('"', "'");
		SHELL_ESCAPE = builder.build();

		final String OS = System
			.getProperty("os.name", "generic")
			.toLowerCase();

		if ((OS.contains("mac")) || (OS.contains("darwin")))
		{
			DETECTED_OS = OSType.MacOS;
		}
		else if (OS.contains("win"))
		{
			DETECTED_OS = OSType.Windows;
		}
		else if (OS.contains("nux"))
		{
			DETECTED_OS = OSType.Linux;
		}
		else
		{
			DETECTED_OS = OSType.Other;
		}

		log.debug("Detect OS: {}", DETECTED_OS);
	}

	private final String appName;
	private final TrayIcon trayIcon;

	Notifier(final String appName, final TrayIcon trayIcon)
	{
		this.appName = appName;
		this.trayIcon = trayIcon;
	}


	public void notify(String message)
	{
		notify(message, TrayIcon.MessageType.NONE);
	}

	public void notify(String message, TrayIcon.MessageType type)
	{
		sendNotification(appName, message, type, null);
		Toolkit.getDefaultToolkit().beep();
	}

	private void sendNotification(
		final String title,
		final String message,
		final TrayIcon.MessageType type,
		final String subtitle)
	{
		final String escapedTitle = SHELL_ESCAPE.escape(title);
		final String escapedMessage = SHELL_ESCAPE.escape(message);
		final String escapedSubtitle = subtitle != null ? SHELL_ESCAPE.escape(subtitle) : null;

		switch (DETECTED_OS)
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
		if (trayIcon != null)
		{
			trayIcon.displayMessage(title, message, type);
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
		commands.add("-u");
		commands.add(toUrgency(type));
		sendCommand(commands);
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

	private void sendCommand(final List<String> commands)
	{
		try
		{
			new ProcessBuilder(commands.toArray(new String[commands.size()]))
				.redirectErrorStream(true)
				.start();
		}
		catch (IOException ex)
		{
			log.warn(null, ex);
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
