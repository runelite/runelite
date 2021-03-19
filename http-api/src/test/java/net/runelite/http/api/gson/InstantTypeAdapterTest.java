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

import java.time.Instant;
import net.runelite.http.api.RuneLiteAPI;
import org.junit.Assert;
import org.junit.Test;

public class InstantTypeAdapterTest
{
	@Test
	public void test()
	{
		test("null", null, true);
		test("{\"seconds\":1609538310,\"nanos\":291000000}", Instant.ofEpochSecond(1609538310, 291_000_000), false);
		test("1609538310291", Instant.ofEpochSecond(1609538310, 291_000_000), true);
	}

	private void test(String json, Instant object, boolean exactEncoding)
	{
		Instant parsed = RuneLiteAPI.GSON.fromJson(json, Instant.class);
		Assert.assertEquals(object, parsed);
		String serialized = RuneLiteAPI.GSON.toJson(object);
		if (exactEncoding)
		{
			Assert.assertEquals(json, serialized);
		}
		Instant roundTripped = RuneLiteAPI.GSON.fromJson(serialized, Instant.class);
		Assert.assertEquals(object, roundTripped);
	}
}