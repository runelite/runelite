/*
 * Copyright (c) 2019 Abex
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
package net.runelite.client.rs;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Response;

@Slf4j
class BufferSizeLimitInterceptor implements Interceptor
{
	private final Set<Connection> connections = new HashSet<>();

	@Getter
	private int recvBufferSize = 64 * 1024;

	@Override
	public Response intercept(Chain chain) throws IOException
	{
		Connection con = chain.connection();
		connections.add(con);
		setConBufferSize(con, recvBufferSize);
		return chain.proceed(chain.request());
	}

	public synchronized void setRecvBufferSize(int size)
	{
		if (this.recvBufferSize == size)
		{
			return;
		}

		this.recvBufferSize = size;
		for (Connection con : connections)
		{
			setConBufferSize(con, size);
		}
	}

	private static void setConBufferSize(Connection con, int size)
	{
		try
		{
			con.socket().setReceiveBufferSize(size);
		}
		catch (IOException e)
		{
			log.info("Setting recvbuf", e);
		}
	}
}
