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

	public static final int REVISION = 139;

	// For revision 139
	public static final BigInteger SERVER_RSA_KEY_MODULUS = new BigInteger("a0211b55eb8010fd56feae6b163a67945b2ffcb6b3cd976a477f2d88e4cafefebd7174268fa9708acf26dbb44a772d4781f41ecb812f9ae459cf23fd7dc76bd70ac5b9ddaee2c1f6de8f8a8a39750f5f4a5c784079d6e7ba39a8915a6336cd681f3ce8083a344072adf5eec02a7221a05b8fda1e4ff4cf117ea89d290ed6fb7d", 16);
	public static final BigInteger SERVER_RSA_KEY_EXPONENT = new BigInteger("10001", 16);
	public static final int[] PACKET_LENGHTS = new int[]
	{
		0, 0, 0, 0, 0, -1, 0, -2, 0, 5, 0, 0, 6, 0, 0, 0, 2, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 4, 4, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 6, -2, 8, 0, 0, 0, 0, -2, -1, 0, 0, -2, 6, 0, 0, 0, 0, 0, 6, 0, 0, 0, 7, 0, 0, 0, 0, 0, 10, 0, 0, -2, 0, 0, 0, 0, 2, 0, 0, 3, -2, 0, 0, 0, 8, 0, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, -1, -2, 1, 0, 0, 0, 0, 6, 0, 0, 0, 28, 0, 6, 0, 0, 6, 0, 0, 0, 0, 3, -2, 6, 0, 0, 2, 0, 0, 0, 0, 0, 0, 6, 2, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, -2, 6, 0, -2, 5, 0, 5, 0, 0, 0, 0, 0, 0, 0, -1, 2, 4, 0, 0, 0, 2, 0, -2, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 15, 0, 0, 0, -2, 0, 0, 0, 0, 0, -2, 14, 8, 20, 0, 2, 0, 0, 0, -2, 5, 4, 0, 0, 0, 10, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 8, 0, 4, 0, 1, -2, 7, 0, 12, 0, 6, 4, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0
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
