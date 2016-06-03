/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.cache.downloader;

import java.io.File;
import net.runelite.cache.fs.Store;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.impl.SimpleLogger;

public class CacheClientTest
{
	@Before
	public void before()
	{
		 System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "TRACE");
	}

	@Test
	@Ignore
	public void test() throws Exception
	{
		Store store = new Store(new File("d:/temp"));
		store.load();

		CacheClient c = new CacheClient(store);
		c.connect();

//		c.requestFile(0, 205).get();
//		c.requestFile(3, 278).get();
//		c.requestFile(3, 127).get();
//		c.requestFile(0, 1210).get();

//		c.requestFile(255, 255).get();
//		c.requestFile(255, 2).get();

//		c.requestFile(4, 2047);

//		c.requestFile(6, 546);

//		c.requestFile(255, 6).get();

		c.download();

		c.stop();

		store.save();
	}
}
