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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PacketCopy extends Thread
{
	private static final Logger logger = LoggerFactory.getLogger(PacketCopy.class);

	private final DataInputStream in;
	private final DataOutputStream out;
	private final RLISAACCipher inCipher;
	private final RLISAACCipher outCipher;

	public PacketCopy(String name, DataInputStream in, DataOutputStream out, RLISAACCipher inCipher, RLISAACCipher outCipher)
	{
		super(name);
		this.in = in;
		this.out = out;
		this.inCipher = inCipher;
		this.outCipher = outCipher;
	}

	@Override
	public void run()
	{
		try
		{
			for (;;)
			{
				int packetOpcode = ProxyRunner.readOpcode(inCipher, in);
				int packetLength = Proxy.PACKET_LENGHTS[packetOpcode];

				if (packetLength == -1)
				{
					packetLength = in.read() & 0xff;
				}

				if (packetLength == -2)
				{
					packetLength = in.readShort() & 0xffff;
				}

				byte[] b = new byte[packetLength];
				int read = 0;

				while (read < packetLength)
				{
					int r = in.read(b, read, packetLength - read);
					if (r <= 0)
					{
						throw new IOException();
					}
					read += r;
				}

				logger.info("Read packet opcode {} length {}", packetOpcode, packetLength);

				// Write out
				ProxyRunner.writeOpcode(outCipher, out, packetOpcode);

				switch (Proxy.PACKET_LENGHTS[packetOpcode])
				{
					case -1:
						assert packetLength >= 0 && packetLength < 256;
						out.write(packetLength);
						break;
					case -2:
						out.writeShort(packetLength);
						break;
				}

				out.write(b);

			}
		}
		catch (IOException ex)
		{
			logger.error(null, ex);
		}
	}
}
