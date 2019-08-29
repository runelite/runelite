import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("WorldMapSection1")
public class WorldMapSection1 implements WorldMapSection {
	@ObfuscatedName("x")
	@Export("SpriteBuffer_pixels")
	public static byte[][] SpriteBuffer_pixels;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "[Lmw;"
	)
	@Export("JagexCache_idxFiles")
	public static BufferedFile[] JagexCache_idxFiles;
	@ObfuscatedName("bk")
	@Export("otp")
	static String otp;
	@ObfuscatedName("de")
	@ObfuscatedSignature(
		signature = "Lid;"
	)
	@Export("archive14")
	static Archive archive14;
	@ObfuscatedName("gn")
	@ObfuscatedGetter(
		intValue = 1628860217
	)
	static int field283;
	@ObfuscatedName("gy")
	@ObfuscatedSignature(
		signature = "[Lls;"
	)
	@Export("mapMarkerSprites")
	static Sprite[] mapMarkerSprites;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -164716821
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1156476113
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1419031029
	)
	@Export("regionStartX")
	int regionStartX;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 797218073
	)
	@Export("regionStartY")
	int regionStartY;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1475121161
	)
	@Export("regionEndX")
	int regionEndX;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1969567489
	)
	@Export("regionEndY")
	int regionEndY;

	WorldMapSection1() {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lav;I)V",
		garbageValue = "-1068467910"
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "1014871771"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.minPlane + this.planes) {
			return var2 >> 6 == this.regionStartX && var3 >> 6 == this.regionStartY;
		} else {
			return false;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "694688168"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 == this.regionEndX && var2 >> 6 == this.regionEndY;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "-45443461"
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(III)Lhd;",
		garbageValue = "1267204541"
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

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "1072299144"
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "24"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("ks")
	@ObfuscatedSignature(
		signature = "(Lhp;B)Z",
		garbageValue = "39"
	)
	static final boolean method563(Widget var0) {
		int var1 = var0.contentType;
		if (var1 == 205) {
			Client.logoutTimer = 250;
			return true;
		} else {
			int var2;
			int var3;
			if (var1 >= 300 && var1 <= 313) {
				var2 = (var1 - 300) / 2;
				var3 = var1 & 1;
				Client.playerAppearance.changeAppearance(var2, var3 == 1);
			}

			if (var1 >= 314 && var1 <= 323) {
				var2 = (var1 - 314) / 2;
				var3 = var1 & 1;
				Client.playerAppearance.method3930(var2, var3 == 1);
			}

			if (var1 == 324) {
				Client.playerAppearance.changeSex(false);
			}

			if (var1 == 325) {
				Client.playerAppearance.changeSex(true);
			}

			if (var1 == 326) {
				PacketBufferNode var4 = MenuAction.getPacketBufferNode(ClientPacket.field2197, Client.packetWriter.isaacCipher);
				Client.playerAppearance.write(var4.packetBuffer);
				Client.packetWriter.addNode(var4);
				return true;
			} else {
				return false;
			}
		}
	}
}
