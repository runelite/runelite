import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
@Implements("AbstractWorldMapData")
public abstract class AbstractWorldMapData {
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -136523776
	)
	@Export("regionXLow")
	int regionXLow;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1537560576
	)
	@Export("regionYLow")
	int regionYLow;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -756440995
	)
	@Export("regionX")
	int regionX;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 2087702297
	)
	@Export("regionY")
	int regionY;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -489051341
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1972038717
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 156978213
	)
	@Export("groupId")
	int groupId;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1797648451
	)
	@Export("fileId")
	int fileId;
	@ObfuscatedName("x")
	@Export("floorUnderlayIds")
	short[][][] floorUnderlayIds;
	@ObfuscatedName("d")
	@Export("floorOverlayIds")
	short[][][] floorOverlayIds;
	@ObfuscatedName("f")
	byte[][][] field145;
	@ObfuscatedName("c")
	byte[][][] field156;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "[[[[Lo;"
	)
	@Export("decorations")
	WorldMapDecoration[][][][] decorations;
	@ObfuscatedName("y")
	boolean field158;
	@ObfuscatedName("p")
	boolean field159;

	AbstractWorldMapData() {
		this.groupId = -1;
		this.fileId = -1;
		new LinkedList();
		this.field158 = false;
		this.field159 = false;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lky;B)V",
		garbageValue = "120"
	)
	@Export("readGeography")
	abstract void readGeography(Buffer var1);

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-103"
	)
	@Export("isFullyLoaded")
	boolean isFullyLoaded() {
		return this.field158 && this.field159;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lhz;I)V",
		garbageValue = "-1580621275"
	)
	@Export("loadGeography")
	void loadGeography(AbstractArchive var1) {
		if (!this.isFullyLoaded()) {
			byte[] var2 = var1.takeFile(this.groupId, this.fileId);
			if (var2 != null) {
				this.readGeography(new Buffer(var2));
				this.field158 = true;
				this.field159 = true;
			}

		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2145144649"
	)
	@Export("reset")
	void reset() {
		this.floorUnderlayIds = null;
		this.floorOverlayIds = null;
		this.field145 = null;
		this.field156 = null;
		this.decorations = null;
		this.field158 = false;
		this.field159 = false;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IILky;I)V",
		garbageValue = "1320309065"
	)
	@Export("readTile")
	void readTile(int var1, int var2, Buffer var3) {
		int var4 = var3.readUnsignedByte();
		if (var4 != 0) {
			if ((var4 & 1) != 0) {
				this.method247(var1, var2, var3, var4);
			} else {
				this.method259(var1, var2, var3, var4);
			}

		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IILky;IB)V",
		garbageValue = "85"
	)
	void method247(int var1, int var2, Buffer var3, int var4) {
		boolean var5 = (var4 & 2) != 0;
		if (var5) {
			this.floorOverlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
		}

		this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IILky;IS)V",
		garbageValue = "320"
	)
	void method259(int var1, int var2, Buffer var3, int var4) {
		int var5 = ((var4 & 24) >> 3) + 1;
		boolean var6 = (var4 & 2) != 0;
		boolean var7 = (var4 & 4) != 0;
		this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
		int var8;
		int var9;
		int var11;
		if (var6) {
			var8 = var3.readUnsignedByte();

			for (var9 = 0; var9 < var8; ++var9) {
				int var10 = var3.readUnsignedByte();
				if (var10 != 0) {
					this.floorOverlayIds[var9][var1][var2] = (short)var10;
					var11 = var3.readUnsignedByte();
					this.field145[var9][var1][var2] = (byte)(var11 >> 2);
					this.field156[var9][var1][var2] = (byte)(var11 & 3);
				}
			}
		}

		if (var7) {
			for (var8 = 0; var8 < var5; ++var8) {
				var9 = var3.readUnsignedByte();
				if (var9 != 0) {
					WorldMapDecoration[] var14 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						int var12 = var3.method5602();
						int var13 = var3.readUnsignedByte();
						var14[var11] = new WorldMapDecoration(var12, var13 >> 2, var13 & 3);
					}
				}
			}
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-88"
	)
	@Export("getRegionX")
	int getRegionX() {
		return this.regionX;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-79"
	)
	@Export("getRegionY")
	int getRegionY() {
		return this.regionY;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IS)Ljava/lang/String;",
		garbageValue = "30202"
	)
	static String method278(int var0) {
		return "<img=" + var0 + ">";
	}

	@ObfuscatedName("gb")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1514757872"
	)
	static final void method264(int var0) {
		int[] var1 = ParamDefinition.sceneMinimapSprite.pixels;
		int var2 = var1.length;

		int var3;
		for (var3 = 0; var3 < var2; ++var3) {
			var1[var3] = 0;
		}

		int var4;
		int var5;
		for (var3 = 1; var3 < 103; ++var3) {
			var4 = (103 - var3) * 2048 + 24628;

			for (var5 = 1; var5 < 103; ++var5) {
				if ((Tiles.Tiles_renderFlags[var0][var5][var3] & 24) == 0) {
					Player.scene.drawTileMinimap(var1, var4, 512, var0, var5, var3);
				}

				if (var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var5][var3] & 8) != 0) {
					Player.scene.drawTileMinimap(var1, var4, 512, var0 + 1, var5, var3);
				}

				var4 += 4;
			}
		}

		var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
		var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
		ParamDefinition.sceneMinimapSprite.setRaster();

		int var6;
		for (var5 = 1; var5 < 103; ++var5) {
			for (var6 = 1; var6 < 103; ++var6) {
				if ((Tiles.Tiles_renderFlags[var0][var6][var5] & 24) == 0) {
					UserComparator10.drawObject(var0, var6, var5, var3, var4);
				}

				if (var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var6][var5] & 8) != 0) {
					UserComparator10.drawObject(var0 + 1, var6, var5, var3, var4);
				}
			}
		}

		Client.mapIconCount = 0;

		for (var5 = 0; var5 < 104; ++var5) {
			for (var6 = 0; var6 < 104; ++var6) {
				long var7 = Player.scene.getFloorDecorationTag(ItemContainer.plane, var5, var6);
				if (var7 != 0L) {
					int var9 = BoundaryObject.Entity_unpackID(var7);
					int var10 = class215.getObjectDefinition(var9).mapIconId;
					if (var10 >= 0) {
						Client.mapIcons[Client.mapIconCount] = WorldMapData_0.WorldMapElement_get(var10).getSpriteBool(false);
						Client.mapIconXs[Client.mapIconCount] = var5;
						Client.mapIconYs[Client.mapIconCount] = var6;
						++Client.mapIconCount;
					}
				}
			}
		}

		SpotAnimationDefinition.rasterProvider.apply();
	}

	@ObfuscatedName("kp")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-61"
	)
	static void method272(int var0) {
		Client.oculusOrbState = var0;
	}
}
