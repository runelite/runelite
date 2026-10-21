/*
 * Copyright (c) 2026, Adam <Adam@sigterm.info>
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
package net.runelite.client.rs.auth;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.client.RuneLite;
import net.runelite.client.util.OSType;

@Singleton
public class SessionStore
{
	private static final Path SESSIONS_FILE = RuneLite.RUNELITE_DIR.toPath().resolve("jagex-accounts.dat");

	private final Gson gson;

	@Inject
	private SessionStore(Gson gson)
	{
		this.gson = gson;
	}

	public List<Session> load() throws IOException
	{
		if (!Files.exists(SESSIONS_FILE))
		{
			return Collections.emptyList();
		}

		byte[] encrypted = Files.readAllBytes(SESSIONS_FILE);
		byte[] key = getEncryptionKey();
		byte[] json;
		try
		{
			json = Crypt.decryptData(encrypted, key);
		}
		finally
		{
			Arrays.fill(key, (byte) 0);
		}
		// CHECKSTYLE:OFF
		List<Session> sessions = gson.fromJson(new String(json, StandardCharsets.UTF_8), new TypeToken<List<Session>>(){}.getType());
		// CHECKSTYLE:ON
		return sessions == null ? Collections.emptyList() : sessions;
	}

	public void save(List<Session> sessions) throws IOException
	{
		Files.createDirectories(SESSIONS_FILE.getParent());
		// CHECKSTYLE:OFF
		byte[] json = gson.toJson(sessions, new TypeToken<List<Session>>(){}.getType()).getBytes(StandardCharsets.UTF_8);
		// CHECKSTYLE:ON
		byte[] key = getEncryptionKey();
		try
		{
			Files.write(SESSIONS_FILE, Crypt.encryptData(json, key));
		}
		finally
		{
			Arrays.fill(key, (byte) 0);
			Arrays.fill(json, (byte) 0);
		}
	}

	private static byte[] getEncryptionKey() throws IOException
	{
		switch (OSType.getOSType())
		{
			case Windows:
				return WindowsCredentialStore.getOrCreateKey();
			case MacOS:
				return MacOSCredentialStore.getOrCreateKey();
			default:
				return getEncryptionKeyDefault();
		}
	}

	private static byte[] getEncryptionKeyDefault()
	{
		try
		{
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] username = System.getProperty("user.name", "").getBytes(StandardCharsets.UTF_8);
			digest.update(username);
			try
			{
				byte[] machineid = Files.readAllBytes(Path.of("/etc/machine-id"));
				digest.update(machineid);
			}
			catch (IOException ignored)
			{
			}
			return digest.digest();
		}
		catch (NoSuchAlgorithmException e)
		{
			throw new RuntimeException("Unable to derive session store key", e);
		}
	}

}
