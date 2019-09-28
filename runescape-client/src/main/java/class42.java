import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class42 implements WorldMapSection {
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	@Export("options_buttons_2Sprite")
	static IndexedSprite options_buttons_2Sprite;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	@Export("rasterProvider")
	public static AbstractRasterProvider rasterProvider;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1607509985
	)
	int field337;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1391505979
	)
	int field338;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 558153755
	)
	int field339;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -246228093
	)
	int field342;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1950186217
	)
	int field341;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -766889275
	)
	int field351;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1083558581
	)
	int field343;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1036531637
	)
	int field344;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 796855403
	)
	int field345;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 301384915
	)
	int field340;

	class42() {
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lac;I)V",
		garbageValue = "2098672163"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field341) {
			var1.regionLowX = this.field341;
		}

		if (var1.regionHighX < this.field341) {
			var1.regionHighX = this.field341;
		}

		if (var1.regionLowY > this.field351) {
			var1.regionLowY = this.field351;
		}

		if (var1.regionHighY < this.field351) {
			var1.regionHighY = this.field351;
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "-327883108"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.field337 && var1 < this.field338 + this.field337) {
			return var2 >= (this.field339 << 6) + (this.field343 << 3) && var2 <= (this.field339 << 6) + (this.field343 << 3) + 7 && var3 >= (this.field342 << 6) + (this.field344 << 3) && var3 <= (this.field342 << 6) + (this.field344 << 3) + 7;
		} else {
			return false;
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-1535371561"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.field341 << 6) + (this.field345 << 3) && var1 <= (this.field341 << 6) + (this.field345 << 3) + 7 && var2 >= (this.field351 << 6) + (this.field340 << 3) && var2 <= (this.field351 << 6) + (this.field340 << 3) + 7;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "-1322751923"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.field341 * 64 - this.field339 * 64 + var2 + (this.field345 * 8 - this.field343 * 8), var3 + (this.field351 * 64 - this.field342 * 64) + (this.field340 * 8 - this.field344 * 8)};
			return var4;
		}
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(III)Lhb;",
		garbageValue = "1439979703"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.field339 * 64 - this.field341 * 64 + (this.field343 * 8 - this.field345 * 8) + var1;
			int var4 = this.field342 * 64 - this.field351 * 64 + var2 + (this.field344 * 8 - this.field340 * 8);
			return new Coord(this.field337, var3, var4);
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lkl;B)V",
		garbageValue = "-99"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.field337 = var1.readUnsignedByte();
		this.field338 = var1.readUnsignedByte();
		this.field339 = var1.readUnsignedShort();
		this.field343 = var1.readUnsignedByte();
		this.field342 = var1.readUnsignedShort();
		this.field344 = var1.readUnsignedByte();
		this.field341 = var1.readUnsignedShort();
		this.field345 = var1.readUnsignedByte();
		this.field351 = var1.readUnsignedShort();
		this.field340 = var1.readUnsignedByte();
		this.method810();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1301595386"
	)
	void method810() {
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IIII)Lcu;",
		garbageValue = "-994648590"
	)
	@Export("getWorldMapScript")
	static Script getWorldMapScript(int var0, int var1, int var2) {
		int var3 = (var1 << 8) + var0;
		Script var5 = WorldMapSection1.method591(var3, var0);
		if (var5 != null) {
			return var5;
		} else {
			int var6 = (var2 + 40000 << 8) + var0;
			var5 = WorldMapSection1.method591(var6, var0);
			return var5 != null ? var5 : null;
		}
	}

	@ObfuscatedName("gp")
	@ObfuscatedSignature(
		signature = "(IIIIIB)V",
		garbageValue = "127"
	)
	@Export("drawObject")
	static final void drawObject(int var0, int var1, int var2, int var3, int var4) {
		long var5 = PacketWriter.scene.getBoundaryObjectTag(var0, var1, var2);
		int var7;
		int var8;
		int var9;
		int var10;
		int var12;
		int var13;
		if (var5 != 0L) {
			var7 = PacketWriter.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = var3;
			if (Language.method3635(var5)) {
				var10 = var4;
			}

			int[] var11 = ObjectSound.sceneMinimapSprite.pixels;
			var12 = var1 * 4 + (103 - var2) * 2048 + 24624;
			var13 = class81.Entity_unpackID(var5);
			ObjectDefinition var14 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(var13);
			if (var14.mapSceneId != -1) {
				IndexedSprite var15 = class14.mapSceneSprites[var14.mapSceneId];
				if (var15 != null) {
					int var16 = (var14.sizeX * 4 - var15.subWidth) / 2;
					int var17 = (var14.sizeY * 4 - var15.subHeight) / 2;
					var15.drawAt(var1 * 4 + var16 + 48, var17 + (104 - var2 - var14.sizeY) * 4 + 48);
				}
			} else {
				if (var9 == 0 || var9 == 2) {
					if (var8 == 0) {
						var11[var12] = var10;
						var11[var12 + 512] = var10;
						var11[var12 + 1024] = var10;
						var11[var12 + 1536] = var10;
					} else if (var8 == 1) {
						var11[var12] = var10;
						var11[var12 + 1] = var10;
						var11[var12 + 2] = var10;
						var11[var12 + 3] = var10;
					} else if (var8 == 2) {
						var11[var12 + 3] = var10;
						var11[var12 + 512 + 3] = var10;
						var11[var12 + 1024 + 3] = var10;
						var11[var12 + 1536 + 3] = var10;
					} else if (var8 == 3) {
						var11[var12 + 1536] = var10;
						var11[var12 + 1536 + 1] = var10;
						var11[var12 + 1536 + 2] = var10;
						var11[var12 + 1536 + 3] = var10;
					}
				}

				if (var9 == 3) {
					if (var8 == 0) {
						var11[var12] = var10;
					} else if (var8 == 1) {
						var11[var12 + 3] = var10;
					} else if (var8 == 2) {
						var11[var12 + 1536 + 3] = var10;
					} else if (var8 == 3) {
						var11[var12 + 1536] = var10;
					}
				}

				if (var9 == 2) {
					if (var8 == 3) {
						var11[var12] = var10;
						var11[var12 + 512] = var10;
						var11[var12 + 1024] = var10;
						var11[var12 + 1536] = var10;
					} else if (var8 == 0) {
						var11[var12] = var10;
						var11[var12 + 1] = var10;
						var11[var12 + 2] = var10;
						var11[var12 + 3] = var10;
					} else if (var8 == 1) {
						var11[var12 + 3] = var10;
						var11[var12 + 512 + 3] = var10;
						var11[var12 + 1024 + 3] = var10;
						var11[var12 + 1536 + 3] = var10;
					} else if (var8 == 2) {
						var11[var12 + 1536] = var10;
						var11[var12 + 1536 + 1] = var10;
						var11[var12 + 1536 + 2] = var10;
						var11[var12 + 1536 + 3] = var10;
					}
				}
			}
		}

		var5 = PacketWriter.scene.getGameObjectTag(var0, var1, var2);
		if (var5 != 0L) {
			var7 = PacketWriter.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = class81.Entity_unpackID(var5);
			ObjectDefinition var24 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(var10);
			int var19;
			if (var24.mapSceneId != -1) {
				IndexedSprite var18 = class14.mapSceneSprites[var24.mapSceneId];
				if (var18 != null) {
					var13 = (var24.sizeX * 4 - var18.subWidth) / 2;
					var19 = (var24.sizeY * 4 - var18.subHeight) / 2;
					var18.drawAt(var1 * 4 + var13 + 48, var19 + (104 - var2 - var24.sizeY) * 4 + 48);
				}
			} else if (var9 == 9) {
				var12 = 15658734;
				if (Language.method3635(var5)) {
					var12 = 15597568;
				}

				int[] var23 = ObjectSound.sceneMinimapSprite.pixels;
				var19 = var1 * 4 + (103 - var2) * 2048 + 24624;
				if (var8 != 0 && var8 != 2) {
					var23[var19] = var12;
					var23[var19 + 1 + 512] = var12;
					var23[var19 + 1024 + 2] = var12;
					var23[var19 + 1536 + 3] = var12;
				} else {
					var23[var19 + 1536] = var12;
					var23[var19 + 1 + 1024] = var12;
					var23[var19 + 512 + 2] = var12;
					var23[var19 + 3] = var12;
				}
			}
		}

		var5 = PacketWriter.scene.getFloorDecorationTag(var0, var1, var2);
		if (var5 != 0L) {
			var7 = class81.Entity_unpackID(var5);
			ObjectDefinition var20 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(var7);
			if (var20.mapSceneId != -1) {
				IndexedSprite var21 = class14.mapSceneSprites[var20.mapSceneId];
				if (var21 != null) {
					var10 = (var20.sizeX * 4 - var21.subWidth) / 2;
					int var22 = (var20.sizeY * 4 - var21.subHeight) / 2;
					var21.drawAt(var1 * 4 + var10 + 48, (104 - var2 - var20.sizeY) * 4 + var22 + 48);
				}
			}
		}

	}

	@ObfuscatedName("iq")
	@ObfuscatedSignature(
		signature = "(IS)Ljava/lang/String;",
		garbageValue = "-6160"
	)
	@Export("formatItemStacks")
	static final String formatItemStacks(int var0) {
		String var1 = Integer.toString(var0);

		for (int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
			var1 = var1.substring(0, var2) + "," + var1.substring(var2);
		}

		if (var1.length() > 9) {
			return " " + World.colorStartTag(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>";
		} else {
			return var1.length() > 6 ? " " + World.colorStartTag(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>" : " " + World.colorStartTag(16776960) + var1 + "</col>";
		}
	}
}
