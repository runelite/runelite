/*
 * Copyright (c) 2020 Abex
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

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.Instant;

// Just add water!
public class InstantTypeAdapter extends TypeAdapter<Instant>
{
	@Override
	public void write(JsonWriter out, Instant value) throws IOException
	{
		if (value == null)
		{
			out.nullValue();
			return;
		}

		out.value(value.toEpochMilli());
	}

	@Override
	public Instant read(JsonReader in) throws IOException
	{
		if (in.peek() == JsonToken.NULL)
		{
			in.nextNull();
			return null;
		}

		if (in.peek() == JsonToken.NUMBER)
		{
			long jsTime = in.nextLong();
			return Instant.ofEpochMilli(jsTime);
		}

		long seconds = 0;
		int nanos = 0;
		in.beginObject();
		while (in.peek() != JsonToken.END_OBJECT)
		{
			switch (in.nextName())
			{
				case "nanos":
					nanos = in.nextInt();
					break;
				case "seconds":
					seconds = in.nextLong();
					break;
			}
		}
		in.endObject();

		return Instant.ofEpochSecond(seconds, nanos);
	}
}
