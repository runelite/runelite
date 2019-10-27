/*
 * MIT License
 *
 * Copyright (c) 2018 Tomas Slusny
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.runelite.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import net.runelite.cache.fs.Store;
import net.runelite.data.dump.MediaWiki;
import net.runelite.data.dump.wiki.ItemLimitsDumper;
import net.runelite.data.dump.wiki.ItemStatsDumper;
import net.runelite.data.dump.wiki.NpcStatsDumper;

public class App
{
	public static final Gson GSON = new GsonBuilder()
		// .setPrettyPrinting()
		.disableHtmlEscaping()
		.create();

	private final static MediaWiki wiki = new MediaWiki("https://oldschool.runescape.wiki");

	public static void main(String[] args) throws IOException
	{
		if (args.length < 2)
		{
			System.exit(-1);
		}

		switch (args[0])
		{
			case "npcStats":
				npcStats(new File(args[1]));
				break;
			case "itemStats":
				itemStats(new File(args[1]));
				break;
			case "itemLimits":
				itemLimits(new File(args[1]));
				break;
		}
	}

	private static Store cacheStore() throws IOException
	{
		Path path = Paths.get(System.getProperty("user.home"), "jagexcache" + File.separator + "oldschool" + File.separator + "LIVE");
		final File jagexcache = new File(String.valueOf(path));

		if (!Files.exists(path))
		{
			return null;
		}

		final Store cacheStore = new Store(jagexcache);

		cacheStore.load();

		// Try to make this go faster (probably not very smart)
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "100");

		return cacheStore;
	}

	private static void npcStats(File path) throws IOException
	{
		NpcStatsDumper.dump(cacheStore(), wiki, path);
	}

	private static void itemStats(File path) throws IOException
	{
		ItemStatsDumper.dump(cacheStore(), wiki, path);
	}

	private static void itemLimits(File path) throws IOException
	{
		ItemLimitsDumper.dump(cacheStore(), wiki, path);
	}
}