import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("MenuAction")
public class MenuAction {
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 237272937
	)
	@Export("PcmPlayer_count")
	public static int PcmPlayer_count;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1746809863
	)
	@Export("opcode")
	int opcode;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -950426859
	)
	@Export("argument1")
	int argument1;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -290789191
	)
	@Export("argument2")
	int argument2;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1009688897
	)
	@Export("argument0")
	int argument0;
	@ObfuscatedName("r")
	@Export("action")
	String action;

	MenuAction() {
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lky;ZS)V",
		garbageValue = "-32250"
	)
	public static void method2067(AbstractSocket var0, boolean var1) {
		if (NetCache.NetCache_socket != null) {
			try {
				NetCache.NetCache_socket.close();
			} catch (Exception var6) {
			}

			NetCache.NetCache_socket = null;
		}

		NetCache.NetCache_socket = var0;
		DirectByteArrayCopier.method3924(var1);
		NetCache.NetCache_responseHeaderBuffer.offset = 0;
		WorldMapEvent.NetCache_currentResponse = null;
		FaceNormal.NetCache_responseArchiveBuffer = null;
		NetCache.field3140 = 0;

		while (true) {
			NetFileRequest var2 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.first();
			if (var2 == null) {
				while (true) {
					var2 = (NetFileRequest)NetCache.NetCache_pendingResponses.first();
					if (var2 == null) {
						if (NetCache.field3156 != 0) {
							try {
								Buffer var7 = new Buffer(4);
								var7.writeByte(4);
								var7.writeByte(NetCache.field3156);
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
						NetCache.field3142 = class30.currentTimeMillis();
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

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1201643852"
	)
	public static final void method2066() {
		ViewportMouse.ViewportMouse_isInViewport = false;
		ViewportMouse.ViewportMouse_entityCount = 0;
	}
}
