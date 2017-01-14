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

package net.runelite.cache.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XteaKeyManager
{
	private static final Logger logger = LoggerFactory.getLogger(XteaKeyManager.class);
	
	private final Map<Integer, Integer[]> keys = new HashMap<>();

	public void loadKeys() throws IOException
	{
		Properties properties = new Properties();
		properties.load(XteaKeyManager.class.getResourceAsStream("/keys.properties"));

		for (Object key : properties.keySet())
		{
			int region = Integer.parseInt((String) key);

			String[] values = properties.getProperty((String) key).split(",");

			assert values.length == 4;

			Integer[] k = (Integer[]) Stream.of(values)
				.map(i -> Integer.parseInt(i))
				.toArray(Integer[]::new);

			keys.put(region, k);
		}

		logger.info("Loaded {} keys", keys.size());
	}

	public int[] getKeys(int region)
	{
		Integer[] k = keys.get(region);
		if (k == null)
			return null;

		return Stream.of(k)
			.mapToInt(Integer::intValue)
			.toArray();
	}
}
