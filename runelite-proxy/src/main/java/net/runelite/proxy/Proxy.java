/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.proxy;

import java.io.IOException;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Proxy
{
	private static final Logger logger = LoggerFactory.getLogger(Proxy.class);

	public static final int REVISION = 140;

	// For revision 140
	public static final BigInteger SERVER_RSA_KEY_MODULUS = new BigInteger("9cb954af0865fabe3fcee77d0a91524f62b18e71b550fa614215edb36424cc57718697e30a7f074ed8bf30c15bb2fca615790d6b322606e48445c2b3393680f56874e5ae8a9f89cd7bbab8c2dd8d2b233b3731f5bb00e9ddb3eddc7a46db157ba848e3ba5fe1e71edde7e36d0976b7ba8dd2ad6c9712ccc9c788212347c3a517", 16);
	public static final BigInteger SERVER_RSA_KEY_EXPONENT = new BigInteger("10001", 16);
	public static final int[] PACKET_LENGHTS = new int[]
	{
			4, 0, -1, 0, 6, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 6, 4, 28, 0, 0, 0, -2, 7, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 6, 0, 0, 0, 5, 0, 0, 4, -2, 0, 0, 2, 1, 2, 5, 0, 0, 0, 0, 6, -1, 0, 0, 0, 0, -2, -2, 0, 0, 4, 0, -2, 0, -2, 0, -2, -2, 4, 6, 0, -2, 0, 0, 0, 0, 4, 5, 7, 0, 0, 0, 0, 0, 0, 0, 1, 0, 3, 8, 5, 0, 0, 15, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, -2, 0, 0, 4, 0, 3, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, -2, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 6, 6, -1, 1, 0, 0, -2, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 12, 0, 6, 8, -2, 0, 5, 0, 0, -2, 0, 6, 10, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 10, 14, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 6, -2, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0
	};

	public static final RSA myRsa = new RSA();
	public static final RSA rsRsa = new RSA(SERVER_RSA_KEY_MODULUS, null);

	public static void main(String[] args) throws IOException
	{
		ServerSocket socket = new ServerSocket(43594);

		logger.info("Running with RSA modulus {}", myRsa.getN().toString(16));

		Socket s;
		while ((s = socket.accept()) != null)
		{
			new ProxyRunner(s).start();
		}
	}
}
