import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("FaceNormal")
public class FaceNormal {
	@ObfuscatedName("iz")
	@ObfuscatedGetter(
		intValue = -98471287
	)
	@Export("selectedItemId")
	static int selectedItemId;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 62688093
	)
	@Export("y")
	int y;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 152436141
	)
	@Export("x")
	int x;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 567855277
	)
	@Export("z")
	int z;

	FaceNormal() {
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lgn;Llp;I)Lgq;",
		garbageValue = "-1746993437"
	)
	@Export("getPacketBufferNode")
	public static PacketBufferNode getPacketBufferNode(ClientPacket var0, IsaacCipher var1) {
		PacketBufferNode var2 = UserComparator9.method3496();
		var2.clientPacket = var0;
		var2.clientPacketLength = var0.length;
		if (var2.clientPacketLength == -1) {
			var2.packetBuffer = new PacketBuffer(260);
		} else if (var2.clientPacketLength == -2) {
			var2.packetBuffer = new PacketBuffer(10000);
		} else if (var2.clientPacketLength <= 18) {
			var2.packetBuffer = new PacketBuffer(20);
		} else if (var2.clientPacketLength <= 98) {
			var2.packetBuffer = new PacketBuffer(100);
		} else {
			var2.packetBuffer = new PacketBuffer(260);
		}

		var2.packetBuffer.setIsaacCipher(var1);
		var2.packetBuffer.writeByteIsaac(var2.clientPacket.id);
		var2.index = 0;
		return var2;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(CLgl;B)C",
		garbageValue = "-64"
	)
	@Export("standardizeChar")
	static char standardizeChar(char var0, Language var1) {
		if (var0 >= 192 && var0 <= 255) {
			if (var0 >= 192 && var0 <= 198) {
				return 'A';
			}

			if (var0 == 199) {
				return 'C';
			}

			if (var0 >= 200 && var0 <= 203) {
				return 'E';
			}

			if (var0 >= 204 && var0 <= 207) {
				return 'I';
			}

			if (var0 == 209 && var1 != Language.Language_ES) {
				return 'N';
			}

			if (var0 >= 210 && var0 <= 214) {
				return 'O';
			}

			if (var0 >= 217 && var0 <= 220) {
				return 'U';
			}

			if (var0 == 221) {
				return 'Y';
			}

			if (var0 == 223) {
				return 's';
			}

			if (var0 >= 224 && var0 <= 230) {
				return 'a';
			}

			if (var0 == 231) {
				return 'c';
			}

			if (var0 >= 232 && var0 <= 235) {
				return 'e';
			}

			if (var0 >= 236 && var0 <= 239) {
				return 'i';
			}

			if (var0 == 241 && var1 != Language.Language_ES) {
				return 'n';
			}

			if (var0 >= 242 && var0 <= 246) {
				return 'o';
			}

			if (var0 >= 249 && var0 <= 252) {
				return 'u';
			}

			if (var0 == 253 || var0 == 255) {
				return 'y';
			}
		}

		if (var0 == 338) {
			return 'O';
		} else if (var0 == 339) {
			return 'o';
		} else {
			return var0 == 376 ? 'Y' : var0;
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(ILiy;IIIZB)V",
		garbageValue = "-88"
	)
	@Export("playMusicTrack")
	public static void playMusicTrack(int var0, AbstractArchive var1, int var2, int var3, int var4, boolean var5) {
		class206.field2406 = 1;
		class206.musicTrackArchive = var1;
		class206.musicTrackGroupId = var2;
		class206.musicTrackFileId = var3;
		class219.musicTrackVolume = var4;
		GrandExchangeOfferUnitPriceComparator.musicTrackBoolean = var5;
		AttackOption.field1187 = var0;
	}

	@ObfuscatedName("lk")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "2112938441"
	)
	public static boolean method3379() {
		return Client.staffModLevel >= 2;
	}
}
