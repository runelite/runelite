import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("WorldMapSection1")
public class WorldMapSection1 implements WorldMapSection {
	@ObfuscatedName("ra")
	@ObfuscatedGetter(
		intValue = -1957533263
	)
	static int field285;
	@ObfuscatedName("cy")
	@Export("mouseCam")
	static boolean mouseCam;
	@ObfuscatedName("ej")
	@ObfuscatedSignature(
		signature = "Lio;"
	)
	@Export("archive20")
	static Archive archive20;
	@ObfuscatedName("ek")
	@ObfuscatedGetter(
		intValue = 1031385521
	)
	@Export("port1")
	static int port1;
	@ObfuscatedName("gk")
	@ObfuscatedGetter(
		intValue = -2034428449
	)
	static int field286;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1694999719
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1331792243
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -37279275
	)
	@Export("regionStartX")
	int regionStartX;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 2016686439
	)
	@Export("regionStartY")
	int regionStartY;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1812547009
	)
	@Export("regionEndX")
	int regionEndX;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1750083521
	)
	@Export("regionEndY")
	int regionEndY;

	WorldMapSection1() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lag;S)V",
		garbageValue = "32767"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.regionEndX) {
			var1.regionLowX = this.regionEndX;
		}

		if (var1.regionHighX < this.regionEndX) {
			var1.regionHighX = this.regionEndX;
		}

		if (var1.regionLowY > this.regionEndY) {
			var1.regionLowY = this.regionEndY;
		}

		if (var1.regionHighY < this.regionEndY) {
			var1.regionHighY = this.regionEndY;
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "950167825"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.planes + this.minPlane) {
			return var2 >> 6 == this.regionStartX && var3 >> 6 == this.regionStartY;
		} else {
			return false;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "1510325414"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 == this.regionEndX && var2 >> 6 == this.regionEndY;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "-771447481"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.regionEndX * 64 - this.regionStartX * 64 + var2, var3 + (this.regionEndY * 64 - this.regionStartY * 64)};
			return var4;
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IIB)Lhj;",
		garbageValue = "0"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.regionStartX * 64 - this.regionEndX * 64 + var1;
			int var4 = this.regionStartY * 64 - this.regionEndY * 64 + var2;
			return new Coord(this.minPlane, var3, var4);
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "1954302512"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte();
		this.planes = var1.readUnsignedByte();
		this.regionStartX = var1.readUnsignedShort();
		this.regionStartY = var1.readUnsignedShort();
		this.regionEndX = var1.readUnsignedShort();
		this.regionEndY = var1.readUnsignedShort();
		this.postRead();
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-197052473"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(II)Liu;",
		garbageValue = "837782921"
	)
	@Export("WorldMapElement_get")
	public static WorldMapElement WorldMapElement_get(int var0) {
		return var0 >= 0 && var0 < WorldMapElement.WorldMapElement_cached.length && WorldMapElement.WorldMapElement_cached[var0] != null ? WorldMapElement.WorldMapElement_cached[var0] : new WorldMapElement(var0);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "544666683"
	)
	public static int method539(int var0, int var1) {
		int var2;
		for (var2 = 0; var1 > 0; --var1) {
			var2 = var2 << 1 | var0 & 1;
			var0 >>>= 1;
		}

		return var2;
	}

	@ObfuscatedName("ho")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "20"
	)
	@Export("resumePauseWidget")
	static void resumePauseWidget(int var0, int var1) {
		PacketBufferNode var2 = MenuAction.getPacketBufferNode(ClientPacket.field2276, Client.packetWriter.isaacCipher);
		var2.packetBuffer.writeIntLE16(var0);
		var2.packetBuffer.method5500(var1);
		Client.packetWriter.addNode(var2);
	}

	@ObfuscatedName("iu")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lhy;I)Ljava/lang/String;",
		garbageValue = "1800929391"
	)
	static String method551(String var0, Widget var1) {
		if (var0.indexOf("%") != -1) {
			for (int var2 = 1; var2 <= 5; ++var2) {
				while (true) {
					int var3 = var0.indexOf("%" + var2);
					if (var3 == -1) {
						break;
					}

					var0 = var0.substring(0, var3) + class81.method2032(class286.method5218(var1, var2 - 1)) + var0.substring(var3 + 2);
				}
			}
		}

		return var0;
	}
}
