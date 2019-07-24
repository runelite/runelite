/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.twitch.irc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwitchIRCClient extends Thread implements AutoCloseable
{
	private static final String HOST = "irc.chat.twitch.tv";
	private static final int PORT = 6697;
	private static final int READ_TIMEOUT = 60000; // ms
	private static final int PING_TIMEOUT = 30000; // ms

	private final TwitchListener twitchListener;

	private final String username, password;
	private final String channel;

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private long last;
	private boolean pingSent;

	public TwitchIRCClient(final TwitchListener twitchListener, final String username, final String password, final String channel)
	{
		setName("Twitch");
		this.twitchListener = twitchListener;
		this.username = username;
		this.password = password;
		this.channel = channel;
	}

	@Override
	public void close()
	{
		try
		{
			socket.close();
		}
		catch (IOException ex)
		{
			log.warn("error closing socket", ex);
		}

		in = null;
		out = null;
	}

	@Override
	public void run()
	{
		try
		{
			SocketFactory socketFactory = SSLSocketFactory.getDefault();
			socket = socketFactory.createSocket(HOST, PORT);
			socket.setSoTimeout(READ_TIMEOUT);

			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
		}
		catch (IOException ex)
		{
			log.warn("unable to setup irc client", ex);
			return;
		}

		register(username, password);
		join(channel);

		try
		{
			String line;

			while ((line = read()) != null)
			{
				log.debug("<- {}", line);

				last = System.currentTimeMillis();
				pingSent = false;

				Message message = Message.parse(line);

				switch (message.getCommand())
				{
					case "PING":
						send("PONG", message.getArguments()[0]);
						break;
					case "PRIVMSG":
						twitchListener.privmsg(message.getTags(),
							message.getArguments()[1]);
						break;
					case "ROOMSTATE":
						twitchListener.roomstate(message.getTags());
						break;
					case "USERNOTICE":
						twitchListener.usernotice(message.getTags(),
							message.getArguments().length > 0 ? message.getArguments()[0] : null);
						break;
				}
			}
		}
		catch (IOException ex)
		{
			log.debug("error in twitch irc client", ex);
		}
		finally
		{
			try
			{
				socket.close();
			}
			catch (IOException e)
			{
				log.warn(null, e);
			}
		}
	}

	public boolean isConnected()
	{
		return socket != null && socket.isConnected() && !socket.isClosed();
	}

	public void pingCheck()
	{
		if (out == null)
		{
			// client is not connected yet
			return;
		}

		if (!pingSent && System.currentTimeMillis() - last >= PING_TIMEOUT)
		{
			ping("twitch");
			pingSent = true;
		}
		else if (pingSent)
		{
			log.debug("Ping timeout, disconnecting.");
			close();
		}
	}

	private void register(String username, String oauth)
	{
		send("CAP", "REQ", "twitch.tv/commands twitch.tv/tags");
		send("PASS", oauth);
		send("NICK", username);
	}

	private void join(String channel)
	{
		send("JOIN", channel);
	}

	private void ping(String destination)
	{
		send("PING", destination);
	}

	public void privmsg(String message)
	{
		send("PRIVMSG", channel, message);
	}

	private void send(String command, String... args)
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(command);
		for (int i = 0; i < args.length; ++i)
		{
			stringBuilder.append(' ');
			if (i + 1 == args.length)
			{
				stringBuilder.append(':');
			}
			stringBuilder.append(args[i]);
		}

		log.debug("-> {}", stringBuilder.toString());

		stringBuilder.append("\r\n");

		out.write(stringBuilder.toString());
		out.flush();
	}

	private String read() throws IOException
	{
		String line = in.readLine();
		if (line == null)
		{
			return null;
		}
		int len = line.length();
		while (len > 0 && (line.charAt(len - 1) == '\r' || line.charAt(len - 1) == '\n'))
		{
			--len;
		}

		return line.substring(0, len);
	}
}
