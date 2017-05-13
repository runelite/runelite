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

import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProxyRunner extends Thread
{
	private static final Logger logger = LoggerFactory.getLogger(ProxyRunner.class);

	private final Socket client;
	private final Socket server;

	private RLISAACCipher clientInCipher;
	private RLISAACCipher clientOutCipher;

	private RLISAACCipher serverInCipher;
	private RLISAACCipher serverOutCipher;

	public ProxyRunner(Socket client) throws IOException
	{
		this.client = client;
		this.server = new Socket("oldschool84.runescape.com", 43594);
	}

	@Override
	public void run()
	{
		try
		{
			go();
		}
		catch (IOException ex)
		{
			logger.error(null, ex);
		}
	}

	private void go() throws IOException
	{
		DataInputStream in = new DataInputStream(client.getInputStream());
		DataOutputStream out = new DataOutputStream(client.getOutputStream());

		DataInputStream serverIn = new DataInputStream(server.getInputStream());
		DataOutputStream serverOut = new DataOutputStream(server.getOutputStream());

		int handshakeType = in.read();
		logger.info("Handshake from client: {}", handshakeType);

		// Forward to server
		serverOut.write(handshakeType);

		if (handshakeType != 14) // 14 = login, 15 = ondemand
		{
			new IOCopy("OnDemand C2S", in, serverOut).start();
			new IOCopy("OnDemand S2C", serverIn, out).start();
			return;
		}

		int handshakeResponse = serverIn.read();
		logger.info("Handshake response from server: {}", handshakeResponse);

		// Forward to client
		out.write(handshakeResponse);

		byte[] b = new byte[8];
		int len = serverIn.read(b);
		assert len == 8;

		logger.info("Nonce from server: {}", Longs.fromByteArray(b));

		// Forward to client
		out.write(b);

		// Now the client sends the login packet, some of it is rsa encrypted with a rsa key
		// that is hardcoded into the client. In this data is the xtea key which is used later
		// for the isaac cipher seeding and for encrypting the rest of the packet.
		int gameState = in.read(); // 18 or 16 depending on some game state
		int length = in.readShort(); // length of remaining packet
		int revision = in.readInt(); // client revision

		logger.info("Client game state: {}, revision: {}", gameState, revision);

		if (revision != Proxy.REVISION)
		{
			client.close();
			server.close();
			return;
		}

		int encrypedDataLength = in.readShort();
		byte[] rsaData = new byte[encrypedDataLength];
		len = in.read(rsaData);
		assert len == encrypedDataLength;

		rsaData = Proxy.myRsa.decrypt(rsaData);

		// Reencrypt data
		byte[] reencrypted = Proxy.rsRsa.encrypt(rsaData);

		// Extract xtea key
		b = rsaData;
		int key1 = Ints.fromBytes(b[2], b[3], b[4], b[5]);
		int key2 = Ints.fromBytes(b[6], b[7], b[8], b[9]);
		int key3 = Ints.fromBytes(b[10], b[11], b[12], b[13]);
		int key4 = Ints.fromBytes(b[14], b[15], b[16], b[17]);
		int[] keys = new int[]
		{
			key1, key2, key3, key4
		};

		logger.info("Xtea key is {} {} {} {}", key1, key2, key3, key4);

		clientInCipher = new RLISAACCipher(keys);
		serverOutCipher = new RLISAACCipher(keys);

		for(int i = 0; i < 4; i++)
		{
			keys[i] += 50;
		}

		clientOutCipher = new RLISAACCipher(keys);
		serverInCipher = new RLISAACCipher(keys);

		// Following this is xtea encrypted data
		int xteaDataLength = length - 4 - encrypedDataLength - 2; // total length - revision - rsa encrypted data - rsa encrypted data length
		byte[] xteaData = new byte[xteaDataLength];
		len = in.read(xteaData);
		assert len == xteaDataLength;

		ByteBuffer buffer = ByteBuffer.allocate(4096);
		buffer.put((byte) gameState);
		buffer.putShort((short) 0); // length
		buffer.putInt(revision);

		buffer.putShort((short) reencrypted.length);
		buffer.put(reencrypted);
		buffer.put(xteaData);

		len = buffer.position();
		buffer.putShort(1, (short) (len - 3));
		serverOut.write(buffer.array(), 0, len);

		handshakeResponse = serverIn.read();
		logger.info("Handshake response: {}", handshakeResponse);
		out.write(handshakeResponse);

		if (handshakeResponse != 2)
		{
			client.close();
			server.close();
			return;
		}

		int isTrusted = serverIn.read();
		int trustedValue = serverIn.readInt();
		logger.info("is trusted value: {}", isTrusted);
		out.write(isTrusted);
		out.writeInt(trustedValue);

		int permission = serverIn.read();//0 = player, 1 = player_mod, 2 = jagex_mod
		int byte2 = serverIn.read();//some boolean, pushed onto intStack in script opcode 3323
		int interactingIndex = serverIn.readShort() & 0xffff;//index of player in server array
		int worldType = serverIn.read();//0 = f2p, 1 = p2p, only used for checking friends/ignores list size

		logger.info("permission/B2/interactingIndex/worldType: {}/{}/{}/{}", permission, byte2, interactingIndex, worldType);

		out.write(permission);
		out.write(byte2);
		out.writeShort(interactingIndex);
		out.write(worldType);

		int staticMapOpcode = readOpcode(serverInCipher, serverIn);
		int packetLength = serverIn.readShort() & 0xffff;

		logger.info("staticMap opcode: {}", staticMapOpcode);

		writeOpcode(clientOutCipher, out, staticMapOpcode);
		out.writeShort(packetLength);

		byte[] packetData = new byte[packetLength];
		len = serverIn.read(packetData);
		assert len == packetData.length;
		out.write(packetData);

		new PacketCopy("Game C2S", in, serverOut, clientInCipher, serverOutCipher).start();
		new PacketCopy("Game S2C", serverIn, out, serverInCipher, clientOutCipher).start();
	}

	public static int readOpcode(RLISAACCipher cipher, InputStream in) throws IOException
	{
		return (in.read() - cipher.nextInt()) & 0xff;
	}

	public static void writeOpcode(RLISAACCipher cipher, OutputStream out, int opcode) throws IOException
	{
		byte encrytpedOpcode = (byte) (opcode + cipher.nextInt());
		out.write(encrytpedOpcode & 0xff);
	}
}
