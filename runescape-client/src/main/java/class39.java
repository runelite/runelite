import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class39 {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Laq;"
	)
	static final class39 field300;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Laq;"
	)
	static final class39 field297;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1809213565
	)
	@Export("value")
	final int value;

	static {
		field300 = new class39(0);
		field297 = new class39(1);
	}

	class39(int var1) {
		this.value = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;ZI)[B",
		garbageValue = "-185232058"
	)
	public static byte[] method644(Object var0, boolean var1) {
		if (var0 == null) {
			return null;
		} else if (var0 instanceof byte[]) {
			byte[] var3 = (byte[])((byte[])var0);
			return var1 ? HorizontalAlignment.method4782(var3) : var3;
		} else if (var0 instanceof AbstractByteArrayCopier) {
			AbstractByteArrayCopier var2 = (AbstractByteArrayCopier)var0;
			return var2.get();
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)[Lcb;",
		garbageValue = "-70"
	)
	static AttackOption[] method643() {
		return new AttackOption[]{AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_leftClickWhereAvailable, AttackOption.AttackOption_hidden, AttackOption.AttackOption_alwaysRightClick};
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Liy;Liy;Ljava/lang/String;Ljava/lang/String;I)Lkx;",
		garbageValue = "672122156"
	)
	public static Font method647(AbstractArchive var0, AbstractArchive var1, String var2, String var3) {
		int var4 = var0.getGroupId(var2);
		int var5 = var0.getFileId(var4, var3);
		Font var6;
		if (!UserComparator7.method3516(var0, var4, var5)) {
			var6 = null;
		} else {
			var6 = VertexNormal.method3094(var1.takeFile(var4, var5));
		}

		return var6;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1343024338"
	)
	static void method645(int var0) {
		Login.loginIndex = 12;
		Login.field1201 = var0;
	}

	@ObfuscatedName("ig")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;S)V",
		garbageValue = "19979"
	)
	static void method646(int var0, String var1) {
		int var2 = Players.Players_count;
		int[] var3 = Players.Players_indices;
		boolean var4 = false;
		Username var5 = new Username(var1, WorldMapIcon_0.loginType);

		for (int var6 = 0; var6 < var2; ++var6) {
			Player var7 = Client.players[var3[var6]];
			if (var7 != null && var7 != ByteArrayPool.localPlayer && var7.username != null && var7.username.equals(var5)) {
				PacketBufferNode var8;
				if (var0 == 1) {
					var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2267, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeByte(0);
					var8.packetBuffer.writeIntME(var3[var6]);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 4) {
					var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2282, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShort(var3[var6]);
					var8.packetBuffer.method5602(0);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 6) {
					var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2250, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5724(0);
					var8.packetBuffer.writeIntME(var3[var6]);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 7) {
					var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2301, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeByte(0);
					var8.packetBuffer.writeShort(var3[var6]);
					Client.packetWriter.addNode(var8);
				}

				var4 = true;
				break;
			}
		}

		if (!var4) {
			Skeleton.addGameMessage(4, "", "Unable to find " + var1);
		}

	}
}
