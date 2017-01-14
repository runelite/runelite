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

package net.runelite.deob.updater;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpdateDetector
{
	public static void main(String[] args) throws IOException
	{
		if (args.length < 1)
			System.exit(-1);

		File saveFile = new File(args[0]);
		if (!saveFile.exists())
		{
			GameConfig config = new GameConfig();
			config.fetch();
			save(config, saveFile);
			System.out.println("update: uncached");
			System.exit(-1);
		}

		GameConfig saved = load(saveFile);

		GameConfig current = new GameConfig();
		current.fetch();

		GameConfigUpdateDetector gcud = new GameConfigUpdateDetector(saved, current);
		boolean updated = gcud.hasUpdated();

		if (updated)
			save(current, saveFile);

		System.out.println("update: " + updated);
		System.exit(updated ? 0 : -1);
	}


	public static void save(GameConfig conf, File f) throws IOException
	{
		try (FileOutputStream fout = new FileOutputStream(f))
		{
			Gson g = new Gson();
			String s = g.toJson(conf);
			fout.write(s.getBytes());
		}
	}

	public static GameConfig load(File f) throws IOException
	{
		try (FileInputStream fin = new FileInputStream(f))
		{
			Gson g = new Gson();
			return g.fromJson(new InputStreamReader(fin), GameConfig.class);
		}
	}

}
