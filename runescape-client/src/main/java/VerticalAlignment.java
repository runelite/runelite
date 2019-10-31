import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
@Implements("VerticalAlignment")
public enum VerticalAlignment implements Enumerated {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lik;"
	)
	field3182(0, 0),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lik;"
	)
	@Export("VerticalAlignment_centered")
	VerticalAlignment_centered(1, 1),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lik;"
	)
	field3183(2, 2);

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Ldl;"
	)
	@Export("soundSystem")
	static SoundSystem soundSystem;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 190875525
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1999098453
	)
	@Export("id")
	final int id;

	VerticalAlignment(int var3, int var4) {
		this.value = var3;
		this.id = var4;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1993081102"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lhx;B)V",
		garbageValue = "-60"
	)
	public static void method4504(Huffman var0) {
		class210.huffman = var0;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lku;ZI)V",
		garbageValue = "-239852992"
	)
	public static void method4503(AbstractSocket var0, boolean var1) {
		if (NetCache.NetCache_socket != null) {
			try {
				NetCache.NetCache_socket.close();
			} catch (Exception var6) {
			}

			NetCache.NetCache_socket = null;
		}

		NetCache.NetCache_socket = var0;
		UrlRequester.method3428(var1);
		NetCache.NetCache_responseHeaderBuffer.offset = 0;
		UserComparator6.NetCache_currentResponse = null;
		Frames.NetCache_responseArchiveBuffer = null;
		NetCache.field3161 = 0;

		while (true) {
			NetFileRequest var2 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.first();
			if (var2 == null) {
				while (true) {
					var2 = (NetFileRequest)NetCache.NetCache_pendingResponses.first();
					if (var2 == null) {
						if (NetCache.field3165 != 0) {
							try {
								Buffer var7 = new Buffer(4);
								var7.writeByte(4);
								var7.writeByte(NetCache.field3165);
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
						NetCache.field3149 = PlayerAppearance.currentTimeMillis();
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
}
