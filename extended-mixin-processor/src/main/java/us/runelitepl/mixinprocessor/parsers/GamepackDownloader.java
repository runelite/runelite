/*
 *  Copyright (c) 2019, ThatGamerBlue <thatgamerblue@gmail.com>
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package us.runelitepl.mixinprocessor.parsers;

import us.runelitepl.mixinprocessor.util.WebUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class GamepackDownloader
{
	
	private static final String CONFIG_URL = "http://oldschool.runescape.com/jav_config.ws";
	private static String codebase;
	private static String initial_jar;
	
	public static void downloadGamepack(HashMap<String, byte[]> output) throws IOException
	{
		parseConfig();
		byte[] gamepackJarAry = WebUtils.downloadFile(getGamepackUrl());
		ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(gamepackJarAry));
		byte[] buffer = new byte[2048];
		ZipEntry entry;
		ByteArrayOutputStream fileContent = new ByteArrayOutputStream(1024*1024*4);
		while ((entry = zipInputStream.getNextEntry()) != null)
		{
			if (entry.getName().startsWith("META-INF"))
			{
				continue;
			}
			String key = entry.getName().replace(".class", "");
			int len = 0;
			while((len = zipInputStream.read(buffer)) > 0)
			{
				fileContent.write(buffer, 0, len);
			}
			output.put(key, fileContent.toByteArray());
			fileContent.reset();
		}
		zipInputStream.close();
	}
	
	private static void parseConfig() throws IOException
	{
		String pageText = WebUtils.getUrlContent(CONFIG_URL);
		for (String line : pageText.split("\n"))
		{
			if (line.startsWith("codebase="))
			{
				codebase = line.replace("codebase=", "");
			}
			else if (line.startsWith("initial_jar="))
			{
				initial_jar = line.replace("initial_jar=", "");
			}
		}
	}
	
	public static String getGamepackUrl()
	{
		return codebase + initial_jar;
	}
	
}
