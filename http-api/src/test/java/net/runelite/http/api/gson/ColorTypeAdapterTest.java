/*
 * Copyright (c) 2021 Abex
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
package net.runelite.http.api.gson;

import java.awt.Color;
import net.runelite.http.api.RuneLiteAPI;
import org.junit.Assert;
import org.junit.Test;

public class ColorTypeAdapterTest
{
	@Test
	public void test()
	{
		test("null", null, true);
		test("{\"value\":-13347208,\"falpha\":0.0}", new Color(0x12345678, false), false);
		test("{\"value\":305419896,\"falpha\":0.0}", new Color(0x12345678, true), false);
		test("{\"value\":-1.4221317E7,\"falpha\":0.0}", new Color(0xFF26FFFB, true), false);
		test("\"#FF345678\"", new Color(0x12345678, false), true);
		test("\"#12345678\"", new Color(0x12345678, true), true);
		test("\"#FF26FFFB\"", new Color(0xFF26FFFB, true), true);
	}

	private void test(String json, Color object, boolean exactEncoding)
	{
		Color parsed = RuneLiteAPI.GSON.fromJson(json, Color.class);
		Assert.assertEquals(object, parsed);
		String serialized = RuneLiteAPI.GSON.toJson(object);
		if (exactEncoding)
		{
			Assert.assertEquals(json, serialized);
		}
		Color roundTripped = RuneLiteAPI.GSON.fromJson(serialized, Color.class);
		Assert.assertEquals(object, roundTripped);
	}
}