import java.io.IOException;
import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
public class class83 {
	@ObfuscatedName("s")
	static final BigInteger field1138;
	@ObfuscatedName("j")
	static final BigInteger field1137;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	static IndexedSprite field1136;

	static {
		field1138 = new BigInteger("10001", 16);
		field1137 = new BigInteger("83ff79a3e258b99ead1a70e1049883e78e513c4cdec538d8da9483879a9f81689c0c7d146d7b82b52d05cf26132b1cda5930eeef894e4ccf3d41eebc3aabe54598c4ca48eb5a31d736bfeea17875a35558b9e3fcd4aebe2a9cc970312a477771b36e173dc2ece6001ab895c553e2770de40073ea278026f36961c94428d8d7db", 16);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lkg;ZI)V",
		garbageValue = "-1903041730"
	)
	@Export("NetCache_connect")
	public static void NetCache_connect(AbstractSocket var0, boolean var1) {
		if (NetCache.NetCache_socket != null) {
			try {
				NetCache.NetCache_socket.close();
			} catch (Exception var6) {
			}

			NetCache.NetCache_socket = null;
		}

		NetCache.NetCache_socket = var0;
		NPC.method1977(var1);
		NetCache.NetCache_responseHeaderBuffer.offset = 0;
		NetCache.NetCache_currentResponse = null;
		NetCache.NetCache_responseArchiveBuffer = null;
		NetCache.field3156 = 0;

		while (true) {
			NetFileRequest var2 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.first();
			if (var2 == null) {
				while (true) {
					var2 = (NetFileRequest)NetCache.NetCache_pendingResponses.first();
					if (var2 == null) {
						if (NetCache.field3159 != 0) {
							try {
								Buffer var7 = new Buffer(4);
								var7.writeByte(4);
								var7.writeByte(NetCache.field3159);
								var7.writeShort(0);
								NetCache.NetCache_socket.write(var7.array, 0, 4);
							} catch (IOException var5) {
								try {
									NetCache.NetCache_socket.close();
								} catch (Exception var4) {
								}

								++NetCache.NetCache_ioExceptions;
								NetCache.NetCache_socket = null;
							}
						}

						NetCache.NetCache_loadTime = 0;
						NetCache.field3145 = SequenceDefinition.method4686();
						return;
					}

					NetCache.NetCache_pendingWritesQueue.addLast(var2);
					NetCache.NetCache_pendingWrites.put(var2, var2.key);
					++NetCache.NetCache_pendingWritesCount;
					--NetCache.NetCache_pendingResponsesCount;
				}
			}

			NetCache.NetCache_pendingPriorityWrites.put(var2, var2.key);
			++NetCache.NetCache_pendingPriorityWritesCount;
			--NetCache.NetCache_pendingPriorityResponsesCount;
		}
	}

	@ObfuscatedName("fd")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1982108989"
	)
	static final void method1997(int var0) {
		class65.method1182();
		switch(var0) {
		case 1:
			PendingSpawn.method1661();
			break;
		case 2:
			Login.loginIndex = 24;
			GrandExchangeOfferOwnWorldComparator.setLoginResponseString("The game servers are currently being updated.", "Please wait a few minutes and try again.", "");
		}

	}
}
