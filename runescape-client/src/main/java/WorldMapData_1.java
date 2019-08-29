import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
@Implements("WorldMapData_1")
public class WorldMapData_1 extends AbstractWorldMapData {
	@ObfuscatedName("af")
	@Export("fontHelvetica13")
	static java.awt.Font fontHelvetica13;
	@ObfuscatedName("gh")
	@ObfuscatedSignature(
		signature = "[Lls;"
	)
	@Export("headIconHintSprites")
	static Sprite[] headIconHintSprites;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 481404885
	)
	@Export("chunkXLow")
	int chunkXLow;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1912285693
	)
	@Export("chunkYLow")
	int chunkYLow;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1552157643
	)
	@Export("chunkX")
	int chunkX;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 730581483
	)
	@Export("chunkY")
	int chunkY;

	WorldMapData_1() {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "-1265892747"
	)
	@Export("init")
	void init(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		if (var2 != WorldMapID.field257.value) {
			throw new IllegalStateException("");
		} else {
			super.minPlane = var1.readUnsignedByte();
			super.planes = var1.readUnsignedByte();
			super.regionXLow = var1.readUnsignedShort() * 4096;
			super.regionYLow = var1.readUnsignedShort() * 4096;
			this.chunkXLow = var1.readUnsignedByte();
			this.chunkYLow = var1.readUnsignedByte();
			super.regionX = var1.readUnsignedShort();
			super.regionY = var1.readUnsignedShort();
			this.chunkX = var1.readUnsignedByte();
			this.chunkY = var1.readUnsignedByte();
			super.groupId = var1.method5602();
			super.fileId = var1.method5602();
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lky;B)V",
		garbageValue = "120"
	)
	@Export("readGeography")
	void readGeography(Buffer var1) {
		super.planes = Math.min(super.planes, 4);
		super.floorUnderlayIds = new short[1][64][64];
		super.floorOverlayIds = new short[super.planes][64][64];
		super.field145 = new byte[super.planes][64][64];
		super.field156 = new byte[super.planes][64][64];
		super.decorations = new WorldMapDecoration[super.planes][64][64][];
		int var2 = var1.readUnsignedByte();
		if (var2 != class30.field250.value) {
			throw new IllegalStateException("");
		} else {
			int var3 = var1.readUnsignedByte();
			int var4 = var1.readUnsignedByte();
			int var5 = var1.readUnsignedByte();
			int var6 = var1.readUnsignedByte();
			if (var3 == super.regionX && var4 == super.regionY && var5 == this.chunkX && var6 == this.chunkY) {
				for (int var7 = 0; var7 < 8; ++var7) {
					for (int var8 = 0; var8 < 8; ++var8) {
						this.readTile(var7 + this.chunkX * 8, var8 + this.chunkY * 8, var1);
					}
				}

			} else {
				throw new IllegalStateException("");
			}
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "18"
	)
	@Export("getChunkXLow")
	int getChunkXLow() {
		return this.chunkXLow;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1399552642"
	)
	@Export("getChunkYLow")
	int getChunkYLow() {
		return this.chunkYLow;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "234574049"
	)
	@Export("getChunkX")
	int getChunkX() {
		return this.chunkX;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "2005972449"
	)
	@Export("getChunkY")
	int getChunkY() {
		return this.chunkY;
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof WorldMapData_1)) {
			return false;
		} else {
			WorldMapData_1 var2 = (WorldMapData_1)var1;
			if (var2.regionX == super.regionX && var2.regionY == super.regionY) {
				return this.chunkX == var2.chunkX && this.chunkY == var2.chunkY;
			} else {
				return false;
			}
		}
	}

	public int hashCode() {
		return super.regionX | super.regionY << 8 | this.chunkX << 16 | this.chunkY << 24;
	}

	@ObfuscatedName("ha")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "129676953"
	)
	@Export("calculateMenuBounds")
	static void calculateMenuBounds(int var0, int var1) {
		int var2 = class43.fontBold12.stringWidth("Choose Option");

		int var3;
		for (var3 = 0; var3 < Client.menuOptionsCount; ++var3) {
			Font var4 = class43.fontBold12;
			String var5;
			if (var3 < 0) {
				var5 = "";
			} else if (Client.menuTargets[var3].length() > 0) {
				var5 = Client.menuActions[var3] + " " + Client.menuTargets[var3];
			} else {
				var5 = Client.menuActions[var3];
			}

			int var6 = var4.stringWidth(var5);
			if (var6 > var2) {
				var2 = var6;
			}
		}

		var2 += 8;
		var3 = Client.menuOptionsCount * 15 + 22;
		int var7 = var0 - var2 / 2;
		if (var7 + var2 > KitDefinition.canvasWidth) {
			var7 = KitDefinition.canvasWidth - var2;
		}

		if (var7 < 0) {
			var7 = 0;
		}

		int var8 = var1;
		if (var3 + var1 > class30.canvasHeight) {
			var8 = class30.canvasHeight - var3;
		}

		if (var8 < 0) {
			var8 = 0;
		}

		MilliClock.menuX = var7;
		class96.menuY = var8;
		World.menuWidth = var2;
		class1.menuHeight = Client.menuOptionsCount * 15 + 22;
	}

	@ObfuscatedName("ij")
	@ObfuscatedSignature(
		signature = "(Lhp;IIIIIII)V",
		garbageValue = "-599054515"
	)
	static final void method682(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (Client.field725) {
			Client.alternativeScrollbarWidth = 32;
		} else {
			Client.alternativeScrollbarWidth = 0;
		}

		Client.field725 = false;
		int var7;
		if (MouseHandler.MouseHandler_currentButton == 1 || !FriendSystem.mouseCam && MouseHandler.MouseHandler_currentButton == 4) {
			if (var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
				var0.scrollY -= 4;
				FriendSystem.invalidateWidget(var0);
			} else if (var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
				var0.scrollY += 4;
				FriendSystem.invalidateWidget(var0);
			} else if (var5 >= var1 - Client.alternativeScrollbarWidth && var5 < Client.alternativeScrollbarWidth + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
				var7 = var3 * (var3 - 32) / var4;
				if (var7 < 8) {
					var7 = 8;
				}

				int var8 = var6 - var2 - 16 - var7 / 2;
				int var9 = var3 - 32 - var7;
				var0.scrollY = var8 * (var4 - var3) / var9;
				FriendSystem.invalidateWidget(var0);
				Client.field725 = true;
			}
		}

		if (Client.mouseWheelRotation != 0) {
			var7 = var0.width;
			if (var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
				var0.scrollY += Client.mouseWheelRotation * 45;
				FriendSystem.invalidateWidget(var0);
			}
		}

	}
}
