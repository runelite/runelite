/*
 * Copyright (c) 2026, Adam <Adam@sigterm.info>
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
package net.runelite.client.rs.auth;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JagexAuthJwt
{
	@SerializedName("sub")
	private String sub;

	@SerializedName("nickname")
	private String nickname;

	public static JagexAuthJwt decode(String token, Gson gson) throws IOException
	{
		String[] parts = token.split("\\.", -1);
		if (parts.length != 3 || parts[1].isEmpty())
		{
			throw new IOException("Invalid JWT");
		}

		try
		{
			byte[] payload = Base64.getUrlDecoder().decode(parts[1]);
			JagexAuthJwt jwt = gson.fromJson(new String(payload, StandardCharsets.UTF_8), JagexAuthJwt.class);
			if (jwt == null || jwt.sub == null || jwt.sub.isEmpty() || jwt.nickname == null || jwt.nickname.isEmpty())
			{
				throw new IOException("JWT is missing sub or nickname");
			}
			return jwt;
		}
		catch (IllegalArgumentException | JsonParseException e)
		{
			throw new IOException("Unable to decode JWT", e);
		}
	}
}
