/*
 * Copyright (c) 2026, SteveScape
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
package net.runelite.client.rs;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
final class SteveScapeConfigServer
{
	private static final String WORLD_LIST_PLACEHOLDER = "stevescape:world_list";
	private static HttpServer server;
	private static byte[] worldList;

	private SteveScapeConfigServer()
	{
	}

	static synchronized void applyLocalWorldList(RSConfig config, String javConfigLocation) throws IOException
	{
		String worldListParam = config.getAppletProperties().get("17");
		if (!WORLD_LIST_PLACEHOLDER.equals(worldListParam))
		{
			return;
		}

		Path configPath = javConfigLocation.startsWith("file:")
			? Paths.get(URI.create(javConfigLocation)).toAbsolutePath().normalize()
			: Paths.get(javConfigLocation).toAbsolutePath().normalize();
		Path configDir = configPath.getParent();
		if (configDir == null)
		{
			configDir = Paths.get(".").toAbsolutePath().normalize();
		}

		if (server == null)
		{
			worldList = encodeWorldList(configDir.resolve("worlds.properties"));
			server = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
			server.createContext("/world_list.ws", SteveScapeConfigServer::serveWorldList);
			server.setExecutor(Executors.newSingleThreadExecutor(r ->
			{
				Thread thread = new Thread(r, "SteveScape config server");
				thread.setDaemon(true);
				return thread;
			}));
			server.start();
			log.info("SteveScape config server listening on {}", server.getAddress());
		}

		config.getAppletProperties().put("17", "http://127.0.0.1:" + server.getAddress().getPort() + "/world_list.ws");
	}

	private static void serveWorldList(HttpExchange exchange) throws IOException
	{
		exchange.getResponseHeaders().set("Content-Type", "application/octet-stream");
		exchange.sendResponseHeaders(200, worldList.length);
		try (OutputStream response = exchange.getResponseBody())
		{
			response.write(worldList);
		}
	}

	private static byte[] encodeWorldList(Path path) throws IOException
	{
		Properties properties = new Properties();
		try (var input = java.nio.file.Files.newInputStream(path))
		{
			properties.load(input);
		}

		int worldId = integer(properties, "world.id");
		int mask = integer(properties, "world.mask");
		String address = properties.getProperty("world.address", "127.0.0.1");
		String activity = properties.getProperty("world.activity", "Development");
		int location = integer(properties, "world.location");
		int players = integer(properties, "world.players");

		ByteArrayOutputStream payloadBytes = new ByteArrayOutputStream();
		try (DataOutputStream payload = new DataOutputStream(payloadBytes))
		{
			payload.writeShort(1);
			payload.writeShort(worldId);
			payload.writeInt(mask);
			writeString(payload, address);
			writeString(payload, activity);
			payload.writeByte(location);
			payload.writeShort(players);
		}

		byte[] payload = payloadBytes.toByteArray();
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		try (DataOutputStream out = new DataOutputStream(bytes))
		{
			out.writeInt(payload.length);
			out.write(payload);
		}
		return bytes.toByteArray();
	}

	private static int integer(Properties properties, String key)
	{
		return Integer.parseInt(properties.getProperty(key));
	}

	private static void writeString(DataOutputStream out, String value) throws IOException
	{
		out.write(value.getBytes(StandardCharsets.ISO_8859_1));
		out.writeByte(0);
	}
}
