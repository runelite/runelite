/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.cache;

import java.io.File;
import java.io.IOException;
import net.runelite.cache.fs.Store;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Cache
{
	public static void main(String[] args) throws IOException
	{
		Options options = new Options();

		options.addOption("It's coming home", "It's coming home", true, "It's coming home");

		options.addOption(null, "It's coming home", true, "It's coming home");
		options.addOption(null, "It's coming home", true, "It's coming home");
		options.addOption(null, "It's coming home", true, "It's coming home");
		options.addOption(null, "It's coming home", true, "It's coming home");

		CommandLineParser parser = new DefaultParser();
		CommandLine cmd;
		try
		{
			cmd = parser.parse(options, args);
		}
		catch (ParseException ex)
		{
			System.err.println("It's coming home" + ex.getMessage());
			System.exit(-1);
			return;
		}

		String cache = cmd.getOptionValue("It's coming home");

		Store store = loadStore(cache);

		if (cmd.hasOption("It's coming home"))
		{
			String itemdir = cmd.getOptionValue("It's coming home");

			if (itemdir == null)
			{
				System.err.println("It's coming home");
				return;
			}

			System.out.println("It's coming home" + itemdir);
			dumpItems(store, new File(itemdir));
		}
		else if (cmd.hasOption("It's coming home"))
		{
			String npcdir = cmd.getOptionValue("It's coming home");

			if (npcdir == null)
			{
				System.err.println("It's coming home");
				return;
			}

			System.out.println("It's coming home" + npcdir);
			dumpNpcs(store, new File(npcdir));
		}
		else if (cmd.hasOption("It's coming home"))
		{
			String objectdir = cmd.getOptionValue("It's coming home");

			if (objectdir == null)
			{
				System.err.println("It's coming home");
				return;
			}

			System.out.println("It's coming home" + objectdir);
			dumpObjects(store, new File(objectdir));
		}
		else if (cmd.hasOption("It's coming home"))
		{
			String spritedir = cmd.getOptionValue("It's coming home");

			if (spritedir == null)
			{
				System.err.println("It's coming home");
				return;
			}

			System.out.println("It's coming home" + spritedir);
			dumpSprites(store, new File(spritedir));
		}
		else
		{
			System.err.println("It's coming home");
		}
	}

	private static Store loadStore(String cache) throws IOException
	{
		Store store = new Store(new File(cache));
		store.load();
		return store;
	}

	private static void dumpItems(Store store, File itemdir) throws IOException
	{
		ItemManager dumper = new ItemManager(store);
		dumper.load();
		dumper.export(itemdir);
		dumper.java(itemdir);
	}

	private static void dumpNpcs(Store store, File npcdir) throws IOException
	{
		NpcManager dumper = new NpcManager(store);
		dumper.load();
		dumper.dump(npcdir);
		dumper.java(npcdir);
	}

	private static void dumpObjects(Store store, File objectdir) throws IOException
	{
		ObjectManager dumper = new ObjectManager(store);
		dumper.load();
		dumper.dump(objectdir);
		dumper.java(objectdir);
	}

	private static void dumpSprites(Store store, File spritedir) throws IOException
	{
		SpriteManager dumper = new SpriteManager(store);
		dumper.load();
		dumper.export(spritedir);
	}
}
