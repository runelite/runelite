import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class3 implements Enumerated {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Ld;"
	)
	static final class3 field11;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Ld;"
	)
	static final class3 field13;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Ld;"
	)
	static final class3 field7;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("logoSprite")
	static IndexedSprite logoSprite;
	@ObfuscatedName("cx")
	@ObfuscatedGetter(
		intValue = 778706931
	)
	public static int field16;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1188320115
	)
	final int field8;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1711821185
	)
	public final int field9;
	@ObfuscatedName("v")
	final Class field10;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lx;"
	)
	final class0 field5;

	static {
		field11 = new class3(2, 0, Integer.class, new class1());
		field13 = new class3(0, 1, Long.class, new class2());
		field7 = new class3(1, 2, String.class, new class4());
	}

	@ObfuscatedSignature(
		signature = "(IILjava/lang/Class;Lx;)V"
	)
	class3(int var1, int var2, Class var3, class0 var4) {
		this.field8 = var1;
		this.field9 = var2;
		this.field10 = var3;
		this.field5 = var4;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "56"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field9;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkb;B)Ljava/lang/Object;",
		garbageValue = "22"
	)
	public Object method42(Buffer var1) {
		return this.field5.vmethod74(var1);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)[Ld;",
		garbageValue = "1248290062"
	)
	public static class3[] method46() {
		return new class3[]{field7, field11, field13};
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lih;II)V",
		garbageValue = "-1889898476"
	)
	static void method58(Archive var0, int var1) {
		if (class13.NetCache_reference != null) {
			class13.NetCache_reference.offset = var1 * 8 + 5;
			int var2 = class13.NetCache_reference.readInt();
			int var3 = class13.NetCache_reference.readInt();
			var0.loadIndex(var2, var3);
		} else {
			Frames.requestNetFile((Archive)null, 255, 255, 0, (byte)0, true);
			NetCache.NetCache_archives[var1] = var0;
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Class;I)Ld;",
		garbageValue = "-1981111471"
	)
	public static class3 method38(Class var0) {
		class3[] var1 = method46();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			class3 var3 = var1[var2];
			if (var3.field10 == var0) {
				return var3;
			}
		}

		return null;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Class;I)Lx;",
		garbageValue = "-334212288"
	)
	public static class0 method40(Class var0) {
		class3 var1 = method38(var0);
		if (var1 == null) {
			throw new IllegalArgumentException();
		} else {
			return var1.field5;
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-61779781"
	)
	static int method59(int var0, int var1) {
		long var2 = (long)((var0 << 16) + var1);
		return NetCache.NetCache_currentResponse != null && var2 == NetCache.NetCache_currentResponse.key ? NetCache.NetCache_responseArchiveBuffer.offset * 99 / (NetCache.NetCache_responseArchiveBuffer.array.length - NetCache.NetCache_currentResponse.padding) + 1 : 0;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(ILhj;ZI)V",
		garbageValue = "-728814712"
	)
	static void method57(int var0, Coord var1, boolean var2) {
		WorldMapArea var3 = class13.getWorldMap().getMapArea(var0);
		int var4 = ByteArrayPool.localPlayer.plane;
		int var5 = (ByteArrayPool.localPlayer.x >> 7) + class69.baseX;
		int var6 = (ByteArrayPool.localPlayer.y >> 7) + class89.baseY;
		Coord var7 = new Coord(var4, var5, var6);
		class13.getWorldMap().method6588(var3, var7, var1, var2);
	}

	@ObfuscatedName("fb")
	@ObfuscatedSignature(
		signature = "(Lhe;III)V",
		garbageValue = "1782995068"
	)
	@Export("checkIfMinimapClicked")
	static final void checkIfMinimapClicked(Widget var0, int var1, int var2) {
		if (Client.minimapState == 0 || Client.minimapState == 3) {
			if (!Client.isMenuOpen && (MouseHandler.MouseHandler_lastButton == 1 || !class217.mouseCam && MouseHandler.MouseHandler_lastButton == 4)) {
				SpriteMask var3 = var0.getSpriteMask(true);
				if (var3 == null) {
					return;
				}

				int var4 = MouseHandler.MouseHandler_lastPressedX - var1;
				int var5 = MouseHandler.MouseHandler_lastPressedY - var2;
				if (var3.contains(var4, var5)) {
					var4 -= var3.width / 2;
					var5 -= var3.height / 2;
					int var6 = Client.camAngleY & 2047;
					int var7 = Rasterizer3D.Rasterizer3D_sine[var6];
					int var8 = Rasterizer3D.Rasterizer3D_cosine[var6];
					int var9 = var7 * var5 + var4 * var8 >> 11;
					int var10 = var8 * var5 - var7 * var4 >> 11;
					int var11 = var9 + ByteArrayPool.localPlayer.x >> 7;
					int var12 = ByteArrayPool.localPlayer.y - var10 >> 7;
					PacketBufferNode var13 = FaceNormal.getPacketBufferNode(ClientPacket.field2207, Client.packetWriter.isaacCipher);
					var13.packetBuffer.writeByte(18);
					var13.packetBuffer.writeShort(var11 + class69.baseX);
					var13.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? (KeyHandler.KeyHandler_pressedKeys[81] ? 2 : 1) : 0);
					var13.packetBuffer.writeShort(var12 + class89.baseY);
					var13.packetBuffer.writeByte(var4);
					var13.packetBuffer.writeByte(var5);
					var13.packetBuffer.writeShort(Client.camAngleY);
					var13.packetBuffer.writeByte(57);
					var13.packetBuffer.writeByte(0);
					var13.packetBuffer.writeByte(0);
					var13.packetBuffer.writeByte(89);
					var13.packetBuffer.writeShort(ByteArrayPool.localPlayer.x);
					var13.packetBuffer.writeShort(ByteArrayPool.localPlayer.y);
					var13.packetBuffer.writeByte(63);
					Client.packetWriter.addNode(var13);
					Client.destinationX = var11;
					Client.destinationY = var12;
				}
			}

		}
	}

	@ObfuscatedName("lt")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "14702"
	)
	static void method48() {
		if (Client.oculusOrbState == 1) {
			Client.field770 = true;
		}

	}
}
