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
package net.runelite.cache.client;

import java.io.File;
import java.util.concurrent.CompletableFuture;
import net.runelite.cache.CacheProperties;
import net.runelite.cache.fs.Store;
import net.runelite.protocol.api.login.HandshakeResponseType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.SimpleLogger;

public class CacheClientTest
{
	private static final Logger logger = LoggerFactory.getLogger(CacheClientTest.class);

	@Before
	public void before()
	{
		System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "TRACE");
	}

	@Test
	@Ignore
	public void test() throws Exception
	{
		try (Store store = new Store(new File("D:\\rs\\07\\temp\\cache")))
		{
			store.load();

			CacheClient c = new CacheClient(store, CacheProperties.getRsVersion());
			c.connect();
			CompletableFuture<HandshakeResponseType> handshake = c.handshake();

			HandshakeResponseType result = handshake.get();
			logger.info("Handshake result: {}", result);

			Assert.assertEquals(HandshakeResponseType.RESPONSE_OK, result);

			c.download();

			c.close();

			store.save();
		}
	}
}
