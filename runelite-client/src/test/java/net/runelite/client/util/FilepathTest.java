/*
 * Copyright (c) 2026 Abex
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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class FilepathTest
{
	@Rule
	public TemporaryFolder temp = new TemporaryFolder();

	private Path dotRunelite;

	@Before
	public void before() throws IOException
	{
		dotRunelite = temp.getRoot().toPath().resolve(".runelite").toAbsolutePath();
		Files.createDirectory(dotRunelite);
	}

	@Test(expected = IllegalArgumentException.class)
	public void pluginCannotEscape()
	{
		Filepath.Unchecked.getLegacyPluginDirectory(dotRunelite, "..");
	}

	@Test
	public void dosDevicesAreLowercase()
	{
		for (var v : Filepath.DOS_DEVICES)
		{
			if (!v.toLowerCase(Locale.ROOT).equals(v))
			{
				Assert.fail(v + " is not lowercase");
			}
		}
	}

	@Test
	public void dotRuneliteDirsAreLowercase()
	{
		for (var v : Filepath.Unchecked.DOT_RUNELITE_DIRS)
		{
			if (!v.toLowerCase(Locale.ROOT).equals(v))
			{
				Assert.fail(v + " is not lowercase");
			}
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void pluginCannotUseBadName()
	{
		Filepath.Unchecked.getLegacyPluginDirectory(dotRunelite, "../.runelite/Profiles2");
	}

	@Test(expected = IllegalArgumentException.class)
	public void pluginCannotAbsolute()
	{
		Filepath.Unchecked.getLegacyPluginDirectory(dotRunelite, "/home/whatever");
	}

	@Test(expected = IllegalArgumentException.class)
	public void pluginCannotShortName()
	{
		Filepath.Unchecked.getLegacyPluginDirectory(dotRunelite, "profil~1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRootUnslashed()
	{
		var root = Filepath.Unchecked.getRooted(dotRunelite.resolve("foo"));
		root.join("../foobar");
	}

	@Test(expected = Exception.class)
	public void testTempDirEscape() throws IOException
	{
		var path = Filepath.Unchecked.getRooted(dotRunelite);
		path.createTempDir("../foo");
	}

	@Test(expected = Exception.class)
	public void testTempFileEscape() throws IOException
	{
		var path = Filepath.Unchecked.getRooted(dotRunelite);
		path.createTempFile("../foo", "test");
	}

	@Test(expected = IllegalArgumentException.class)
	public void joinAlternateStream()
	{
		Filepath.Unchecked.getRooted(dotRunelite).join("file:stream");
	}

	@Test(expected = IllegalArgumentException.class)
	public void joinDosDevice()
	{
		Filepath.Unchecked.getRooted(dotRunelite).join("com¹ .txt");
	}

	@Test
	public void traversal()
	{
		var path = Filepath.Unchecked.getLegacyPluginDirectory(dotRunelite, "my-plugin");
		var subdir = path.join("../", "my-plugin/foo");
		Assert.assertEquals(subdir.getParent(), path);
		Assert.assertTrue(path.isRoot());
		Assert.assertFalse(subdir.isRoot());

		try
		{
			path.getParent();
			Assert.fail();
		}
		catch (IllegalArgumentException ignored)
		{
		}

		try
		{
			subdir.getParent().getParent();
			Assert.fail();
		}
		catch (IllegalArgumentException ignored)
		{
		}

		try
		{
			subdir.join("..", "..");
			Assert.fail();
		}
		catch (IllegalArgumentException ignored)
		{
		}
	}

	@Test
	public void testDeleteRecursive() throws IOException
	{
		var path = Filepath.Unchecked.getLegacyPluginDirectory(dotRunelite, "my-plugin");
		path.createDirectory();
		path.join("test-file").write(new byte[0]);
		var subdir = path.join("test-dir/something/whatever");
		subdir.createDirectories();
		var file = subdir.join("file");
		file.write("Hello");
		Assert.assertTrue(file.exists());

		path.deleteRecursively();
		Assert.assertFalse(file.exists());
		Assert.assertFalse(path.exists());
	}
}
