import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("WorldMapSection0")
public class WorldMapSection0 implements WorldMapSection {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 713824535
	)
	@Export("oldZ")
	int oldZ;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1876975141
	)
	@Export("newZ")
	int newZ;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1131302305
	)
	@Export("oldX")
	int oldX;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -676651519
	)
	@Export("oldY")
	int oldY;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1875954061
	)
	@Export("newX")
	int newX;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -391734637
	)
	@Export("newY")
	int newY;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 858906315
	)
	@Export("oldChunkXLow")
	int oldChunkXLow;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 2112793997
	)
	@Export("oldChunkYLow")
	int oldChunkYLow;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -902525679
	)
	@Export("oldChunkXHigh")
	int oldChunkXHigh;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 519445535
	)
	@Export("oldChunkYHigh")
	int oldChunkYHigh;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -2051517669
	)
	@Export("newChunkXLow")
	int newChunkXLow;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 878808507
	)
	@Export("newChunkYLow")
	int newChunkYLow;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 671796187
	)
	@Export("newChunkXHigh")
	int newChunkXHigh;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -362726853
	)
	@Export("newChunkYHigh")
	int newChunkYHigh;

	WorldMapSection0() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Las;I)V",
		garbageValue = "1890497148"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.newX) {
			var1.regionLowX = this.newX;
		}

		if (var1.regionHighX < this.newX) {
			var1.regionHighX = this.newX;
		}

		if (var1.regionLowY > this.newY) {
			var1.regionLowY = this.newY;
		}

		if (var1.regionHighY < this.newY) {
			var1.regionHighY = this.newY;
		}

	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "-65934716"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.oldZ && var1 < this.newZ + this.oldZ) {
			return var2 >= (this.oldX << 6) + (this.oldChunkXLow << 3) && var2 <= (this.oldX << 6) + (this.oldChunkXHigh << 3) + 7 && var3 >= (this.oldY << 6) + (this.oldChunkYLow << 3) && var3 <= (this.oldY << 6) + (this.oldChunkYHigh << 3) + 7;
		} else {
			return false;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-240937232"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.newX << 6) + (this.newChunkXLow << 3) && var1 <= (this.newX << 6) + (this.newChunkXHigh << 3) + 7 && var2 >= (this.newY << 6) + (this.newChunkYLow << 3) && var2 <= (this.newY << 6) + (this.newChunkYHigh << 3) + 7;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "1656767825"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{var2 + (this.newX * 64 - this.oldX * 64) + (this.newChunkXLow * 8 - this.oldChunkXLow * 8), var3 + (this.newY * 64 - this.oldY * 64) + (this.newChunkYLow * 8 - this.oldChunkYLow * 8)};
			return var4;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(III)Lhj;",
		garbageValue = "-226825052"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.oldX * 64 - this.newX * 64 + (this.oldChunkXLow * 8 - this.newChunkXLow * 8) + var1;
			int var4 = var2 + (this.oldY * 64 - this.newY * 64) + (this.oldChunkYLow * 8 - this.newChunkYLow * 8);
			return new Coord(this.oldZ, var3, var4);
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "-1393433755"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.oldZ = var1.readUnsignedByte();
		this.newZ = var1.readUnsignedByte();
		this.oldX = var1.readUnsignedShort();
		this.oldChunkXLow = var1.readUnsignedByte();
		this.oldChunkXHigh = var1.readUnsignedByte();
		this.oldY = var1.readUnsignedShort();
		this.oldChunkYLow = var1.readUnsignedByte();
		this.oldChunkYHigh = var1.readUnsignedByte();
		this.newX = var1.readUnsignedShort();
		this.newChunkXLow = var1.readUnsignedByte();
		this.newChunkXHigh = var1.readUnsignedByte();
		this.newY = var1.readUnsignedShort();
		this.newChunkYLow = var1.readUnsignedByte();
		this.newChunkYHigh = var1.readUnsignedByte();
		this.postRead();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1832298319"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("gi")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-1632092038"
	)
	@Export("worldToScreen")
	static final void worldToScreen(int var0, int var1, int var2) {
		if (var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
			int var3 = class277.getTileHeight(var0, var1, ScriptEvent.Client_plane) - var2;
			var0 -= WorldMapRectangle.cameraX;
			var3 -= GrandExchangeOfferWorldComparator.cameraY;
			var1 -= class200.cameraZ;
			int var4 = Rasterizer3D.Rasterizer3D_sine[class74.cameraPitch];
			int var5 = Rasterizer3D.Rasterizer3D_cosine[class74.cameraPitch];
			int var6 = Rasterizer3D.Rasterizer3D_sine[WorldMapIcon_1.cameraYaw];
			int var7 = Rasterizer3D.Rasterizer3D_cosine[WorldMapIcon_1.cameraYaw];
			int var8 = var0 * var7 + var6 * var1 >> 16;
			var1 = var7 * var1 - var0 * var6 >> 16;
			var0 = var8;
			var8 = var5 * var3 - var4 * var1 >> 16;
			var1 = var5 * var1 + var4 * var3 >> 16;
			if (var1 >= 50) {
				Client.viewportTempX = var0 * Client.viewportZoom / var1 + Client.viewportWidth / 2;
				Client.viewportTempY = var8 * Client.viewportZoom / var1 + Client.viewportHeight / 2;
			} else {
				Client.viewportTempX = -1;
				Client.viewportTempY = -1;
			}

		} else {
			Client.viewportTempX = -1;
			Client.viewportTempY = -1;
		}
	}

	@ObfuscatedName("hm")
	@ObfuscatedSignature(
		signature = "(Lkj;I)V",
		garbageValue = "1398134743"
	)
	static final void method335(PacketBuffer var0) {
		for (int var1 = 0; var1 < Client.field851; ++var1) {
			int var2 = Client.field725[var1];
			NPC var3 = Client.npcs[var2];
			int var4 = var0.readUnsignedByte();
			int var5;
			int var6;
			int var7;
			if ((var4 & 128) != 0) {
				var5 = var0.method5614();
				if (var5 == 65535) {
					var5 = -1;
				}

				var6 = var0.readUnsignedByte();
				if (var5 == var3.sequence && var5 != -1) {
					var7 = SpotAnimationDefinition.SequenceDefinition_get(var5).field3525;
					if (var7 == 1) {
						var3.sequenceFrame = 0;
						var3.sequenceFrameCycle = 0;
						var3.sequenceDelay = var6;
						var3.field1011 = 0;
					}

					if (var7 == 2) {
						var3.field1011 = 0;
					}
				} else if (var5 == -1 || var3.sequence == -1 || SpotAnimationDefinition.SequenceDefinition_get(var5).field3519 >= SpotAnimationDefinition.SequenceDefinition_get(var3.sequence).field3519) {
					var3.sequence = var5;
					var3.sequenceFrame = 0;
					var3.sequenceFrameCycle = 0;
					var3.sequenceDelay = var6;
					var3.field1011 = 0;
					var3.field1032 = var3.pathLength;
				}
			}

			int var8;
			if ((var4 & 16) != 0) {
				var5 = var0.method5613();
				var6 = var0.method5614();
				var7 = var3.x - (var5 - class69.baseX - class69.baseX) * 64;
				var8 = var3.y - (var6 - class89.baseY - class89.baseY) * 64;
				if (var7 != 0 || var8 != 0) {
					var3.field1015 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
				}
			}

			if ((var4 & 32) != 0) {
				var3.definition = class237.getNpcDefinition(var0.method5614());
				var3.field976 = var3.definition.size;
				var3.field1026 = var3.definition.rotation;
				var3.walkSequence = var3.definition.walkSequence;
				var3.walkBackSequence = var3.definition.walkBackSequence;
				var3.walkLeftSequence = var3.definition.walkLeftSequence;
				var3.walkRightSequence = var3.definition.walkRightSequence;
				var3.readySequence = var3.definition.readySequence;
				var3.turnLeftSequence = var3.definition.turnLeftSequence;
				var3.turnRightSequence = var3.definition.turnRightSequence;
			}

			if ((var4 & 8) != 0) {
				var3.targetIndex = var0.readUnsignedShort();
				if (var3.targetIndex == 65535) {
					var3.targetIndex = -1;
				}
			}

			if ((var4 & 2) != 0) {
				var3.spotAnimation = var0.method5614();
				var5 = var0.method5621();
				var3.field1033 = var5 >> 16;
				var3.field1013 = (var5 & 65535) + Client.cycle;
				var3.spotAnimationFrame = 0;
				var3.spotAnimationFrameCycle = 0;
				if (var3.field1013 > Client.cycle) {
					var3.spotAnimationFrame = -1;
				}

				if (var3.spotAnimation == 65535) {
					var3.spotAnimation = -1;
				}
			}

			if ((var4 & 64) != 0) {
				var3.overheadText = var0.readStringCp1252NullTerminated();
				var3.overheadTextCyclesRemaining = 100;
			}

			if ((var4 & 1) != 0) {
				var5 = var0.method5605();
				int var9;
				int var10;
				int var11;
				if (var5 > 0) {
					for (var6 = 0; var6 < var5; ++var6) {
						var8 = -1;
						var9 = -1;
						var10 = -1;
						var7 = var0.readUShortSmart();
						if (var7 == 32767) {
							var7 = var0.readUShortSmart();
							var9 = var0.readUShortSmart();
							var8 = var0.readUShortSmart();
							var10 = var0.readUShortSmart();
						} else if (var7 != 32766) {
							var9 = var0.readUShortSmart();
						} else {
							var7 = -1;
						}

						var11 = var0.readUShortSmart();
						var3.addHitSplat(var7, var9, var8, var10, Client.cycle, var11);
					}
				}

				var6 = var0.method5604();
				if (var6 > 0) {
					for (var7 = 0; var7 < var6; ++var7) {
						var8 = var0.readUShortSmart();
						var9 = var0.readUShortSmart();
						if (var9 != 32767) {
							var10 = var0.readUShortSmart();
							var11 = var0.method5604();
							int var12 = var9 > 0 ? var0.method5605() : var11;
							var3.addHealthBar(var8, Client.cycle, var9, var10, var11, var12);
						} else {
							var3.removeHealthBar(var8);
						}
					}
				}
			}

			if ((var4 & 4) != 0) {
				var3.field990 = var0.method5607();
				var3.field1017 = var0.method5608();
				var3.field972 = var0.method5606();
				var3.field1018 = var0.readByte();
				var3.field1019 = var0.method5564() + Client.cycle;
				var3.field1020 = var0.method5613() + Client.cycle;
				var3.field1021 = var0.readUnsignedShort();
				var3.pathLength = 1;
				var3.field1032 = 0;
				var3.field990 += var3.pathX[0];
				var3.field1017 += var3.pathY[0];
				var3.field972 += var3.pathX[0];
				var3.field1018 += var3.pathY[0];
			}
		}

	}
}
