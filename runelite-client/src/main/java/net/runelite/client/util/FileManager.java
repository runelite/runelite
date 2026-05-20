/*
 * Copyright (c) 2026, Rikten X <riktenx@gmail.com>
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
package net.runelite.client.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import javax.inject.Inject;
import lombok.Value;
import net.runelite.client.plugins.Plugin;
import static net.runelite.client.RuneLite.RUNELITE_DIR;

/**
 * Utility class for file I/O performed by external plugins.
 */
public class FileManager
{
	private final Path root;

	@Inject
	public FileManager(Plugin plugin)
	{
		root = RUNELITE_DIR.toPath().resolve(plugin.getClass().getSimpleName()).toAbsolutePath().normalize();

		root.toFile().mkdir();
	}

	public InputStream read(String path, String... more) throws IOException
	{
		return new FileInputStream(resolve(path, more));
	}

	public OutputStream write(String path, String... more) throws IOException
	{
		return new FileOutputStream(resolve(path, more));
	}

	public boolean exists(String path, String... more) throws IOException
	{
		return resolve(path, more).exists();
	}

	public boolean mkdir(String path, String... more) throws IOException
	{
		return resolve(path, more).mkdir();
	}

	public boolean delete(String path, String... more) throws IOException
	{
		return resolve(path, more).delete();
	}

	public Stream<WalkEntry> walk(String path, String... more) throws IOException
	{
		Path start = resolve(path, more).toPath();
		return Files.walk(start)
			.map(it -> new WalkEntry(start.relativize(it).toString(), it.toFile().isDirectory()));
	}

	private File resolve(String path, String... more) throws IOException
	{
		Path resolved = root.resolve(Paths.get(path, more)).toAbsolutePath().normalize();
		if (!resolved.startsWith(root))
		{
			throw new IOException("path is invalid");
		}

		return resolved.toFile();
	}

	@Value
	public static class WalkEntry
	{
		String path;
		boolean isDirectory;
	}
}
