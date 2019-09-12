import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
public class class60 {
	@ObfuscatedName("pg")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	@Export("sceneMinimapSprite")
	static Sprite sceneMinimapSprite;

	@ObfuscatedName("hv")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "1939345864"
	)
	static void method1122(int var0, String var1) {
		int var2 = Players.Players_count;
		int[] var3 = Players.Players_indices;
		boolean var4 = false;
		Username var5 = new Username(var1, class4.loginType);

		for (int var6 = 0; var6 < var2; ++var6) {
			Player var7 = Client.players[var3[var6]];
			if (var7 != null && var7 != Varps.localPlayer && var7.username != null && var7.username.equals(var5)) {
				PacketBufferNode var8;
				if (var0 == 1) {
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2237, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5500(var3[var6]);
					var8.packetBuffer.method5566(0);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 4) {
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2248, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeByte(0);
					var8.packetBuffer.method5500(var3[var6]);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 6) {
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2250, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5502(var3[var6]);
					var8.packetBuffer.method5491(0);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 7) {
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2268, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5491(0);
					var8.packetBuffer.method5500(var3[var6]);
					Client.packetWriter.addNode(var8);
				}

				var4 = true;
				break;
			}
		}

		if (!var4) {
			WorldMapCacheName.addGameMessage(4, "", "Unable to find " + var1);
		}

	}

	@ObfuscatedName("kn")
	@ObfuscatedSignature(
		signature = "(Lhy;S)I",
		garbageValue = "-12983"
	)
	@Export("getWidgetClickMask")
	static int getWidgetClickMask(Widget var0) {
		IntegerNode var1 = (IntegerNode)Client.widgetClickMasks.get(((long)var0.id << 32) + (long)var0.childIndex);
		return var1 != null ? var1.integer : var0.clickMask;
	}
}
