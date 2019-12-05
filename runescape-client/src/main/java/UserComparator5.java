import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
@Implements("UserComparator5")
public class UserComparator5 extends AbstractUserComparator {
	@ObfuscatedName("u")
	@Export("reversed")
	final boolean reversed;

	public UserComparator5(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljt;Ljt;I)I",
		garbageValue = "1252723685"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (var1.world != 0) {
			if (var2.world == 0) {
				return this.reversed ? -1 : 1;
			}
		} else if (var2.world != 0) {
			return this.reversed ? 1 : -1;
		}

		return this.compareUser(var1, var2);
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lhf;IIB)[Lln;",
		garbageValue = "0"
	)
	@Export("SpriteBuffer_getSpriteArray")
	public static Sprite[] SpriteBuffer_getSpriteArray(AbstractArchive var0, int var1, int var2) {
		if (!GraphicsObject.method2030(var0, var1, var2)) {
			return null;
		} else {
			Sprite[] var4 = new Sprite[class325.SpriteBuffer_spriteCount];

			for (int var5 = 0; var5 < class325.SpriteBuffer_spriteCount; ++var5) {
				Sprite var6 = var4[var5] = new Sprite();
				var6.width = class325.SpriteBuffer_spriteWidth;
				var6.height = UserComparator9.SpriteBuffer_spriteHeight;
				var6.xOffset = UrlRequester.SpriteBuffer_xOffsets[var5];
				var6.yOffset = class216.SpriteBuffer_yOffsets[var5];
				var6.subWidth = class325.SpriteBuffer_spriteWidths[var5];
				var6.subHeight = VarcInt.SpriteBuffer_spriteHeights[var5];
				int var7 = var6.subWidth * var6.subHeight;
				byte[] var8 = FillMode.SpriteBuffer_pixels[var5];
				var6.pixels = new int[var7];

				for (int var9 = 0; var9 < var7; ++var9) {
					var6.pixels[var9] = class325.SpriteBuffer_spritePalette[var8[var9] & 255];
				}
			}

			PcmPlayer.method2510();
			return var4;
		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "([BIII)I",
		garbageValue = "1975760321"
	)
	public static int method3467(byte[] var0, int var1, int var2) {
		int var3 = -1;

		for (int var4 = var1; var4 < var2; ++var4) {
			var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
		}

		var3 = ~var3;
		return var3;
	}

	@ObfuscatedName("fb")
	@ObfuscatedSignature(
		signature = "(Lbt;B)V",
		garbageValue = "4"
	)
	static final void method3461(Actor var0) {
		int var1 = var0.field934 - Client.cycle;
		int var2 = var0.field946 * 128 + var0.field938 * 64;
		int var3 = var0.field979 * 128 + var0.field938 * 64;
		var0.x += (var2 - var0.x) / var1;
		var0.y += (var3 - var0.y) / var1;
		var0.field976 = 0;
		var0.orientation = var0.field983;
	}

	@ObfuscatedName("ic")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "-165860818"
	)
	static void method3466(int var0, String var1) {
		int var2 = Players.Players_count;
		int[] var3 = Players.Players_indices;
		boolean var4 = false;
		Username var5 = new Username(var1, WorldMapLabelSize.loginType);

		for (int var6 = 0; var6 < var2; ++var6) {
			Player var7 = Client.players[var3[var6]];
			if (var7 != null && var7 != class215.localPlayer && var7.username != null && var7.username.equals(var5)) {
				PacketBufferNode var8;
				if (var0 == 1) {
					var8 = ModelData0.getPacketBufferNode(ClientPacket.field2231, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5598(0);
					var8.packetBuffer.method5613(var3[var6]);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 4) {
					var8 = ModelData0.getPacketBufferNode(ClientPacket.field2267, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5613(var3[var6]);
					var8.packetBuffer.writeByte(0);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 6) {
					var8 = ModelData0.getPacketBufferNode(ClientPacket.field2241, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5628(0);
					var8.packetBuffer.method5636(var3[var6]);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 7) {
					var8 = ModelData0.getPacketBufferNode(ClientPacket.field2251, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShort(var3[var6]);
					var8.packetBuffer.writeByte(0);
					Client.packetWriter.addNode(var8);
				}

				var4 = true;
				break;
			}
		}

		if (!var4) {
			GrandExchangeOfferAgeComparator.addGameMessage(4, "", "Unable to find " + var1);
		}

	}
}
