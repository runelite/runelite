import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
public class class81 {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljava/awt/Component;I)V",
		garbageValue = "481246027"
	)
	static void method1990(Component var0) {
		var0.setFocusTraversalKeysEnabled(false);
		var0.addKeyListener(KeyHandler.KeyHandler_instance);
		var0.addFocusListener(KeyHandler.KeyHandler_instance);
	}

	@ObfuscatedName("fm")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "1510929763"
	)
	@Export("queueSoundEffect")
	static void queueSoundEffect(int var0, int var1, int var2) {
		if (Client.soundEffectVolume != 0 && var1 != 0 && Client.soundEffectCount < 50) {
			Client.soundEffectIds[Client.soundEffectCount] = var0;
			Client.queuedSoundEffectLoops[Client.soundEffectCount] = var1;
			Client.queuedSoundEffectDelays[Client.soundEffectCount] = var2;
			Client.soundEffects[Client.soundEffectCount] = null;
			Client.soundLocations[Client.soundEffectCount] = 0;
			++Client.soundEffectCount;
		}

	}

	@ObfuscatedName("ho")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "-1296265536"
	)
	static void method1988(int var0, String var1) {
		int var2 = Players.Players_count;
		int[] var3 = Players.Players_indices;
		boolean var4 = false;
		Username var5 = new Username(var1, class40.loginType);

		for (int var6 = 0; var6 < var2; ++var6) {
			Player var7 = Client.players[var3[var6]];
			if (var7 != null && var7 != Client.localPlayer && var7.username != null && var7.username.equals(var5)) {
				PacketBufferNode var8;
				if (var0 == 1) {
					var8 = Archive.method4265(ClientPacket.field2250, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShort(var3[var6]);
					var8.packetBuffer.method5521(0);
					Client.packetWriter.method2219(var8);
				} else if (var0 == 4) {
					var8 = Archive.method4265(ClientPacket.field2230, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5475(var3[var6]);
					var8.packetBuffer.method5521(0);
					Client.packetWriter.method2219(var8);
				} else if (var0 == 6) {
					var8 = Archive.method4265(ClientPacket.field2257, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5530(var3[var6]);
					var8.packetBuffer.method5502(0);
					Client.packetWriter.method2219(var8);
				} else if (var0 == 7) {
					var8 = Archive.method4265(ClientPacket.field2278, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5502(0);
					var8.packetBuffer.writeShortLE(var3[var6]);
					Client.packetWriter.method2219(var8);
				}

				var4 = true;
				break;
			}
		}

		if (!var4) {
			ScriptEvent.addGameMessage(4, "", "Unable to find " + var1);
		}

	}
}
