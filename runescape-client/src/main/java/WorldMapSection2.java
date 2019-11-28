import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
@Implements("WorldMapSection2")
public class WorldMapSection2 implements WorldMapSection {
	@ObfuscatedName("nk")
	@ObfuscatedGetter(
		intValue = 1891389593
	)
	static int field200;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1524934865
	)
	@Export("clientTickTimeIdx")
	static int clientTickTimeIdx;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 955020079
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1414372251
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 779916199
	)
	@Export("regionStartX")
	int regionStartX;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1695825611
	)
	@Export("regionStartY")
	int regionStartY;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1541446225
	)
	@Export("regionEndX")
	int regionEndX;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1892372645
	)
	@Export("regionEndY")
	int regionEndY;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 1196441943
	)
	int field194;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1727293363
	)
	int field195;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1979439593
	)
	int field196;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 736473599
	)
	int field197;

	WorldMapSection2() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Laf;I)V",
		garbageValue = "-567179164"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field194) {
			var1.regionLowX = this.field194;
		}

		if (var1.regionHighX < this.field196) {
			var1.regionHighX = this.field196;
		}

		if (var1.regionLowY > this.field195) {
			var1.regionLowY = this.field195;
		}

		if (var1.regionHighY < this.field197) {
			var1.regionHighY = this.field197;
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IIIB)Z",
		garbageValue = "0"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.minPlane + this.planes) {
			return var2 >> 6 >= this.regionStartX && var2 >> 6 <= this.regionEndX && var3 >> 6 >= this.regionStartY && var3 >> 6 <= this.regionEndY;
		} else {
			return false;
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "110675609"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 >= this.field194 && var1 >> 6 <= this.field196 && var2 >> 6 >= this.field195 && var2 >> 6 <= this.field197;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(IIIB)[I",
		garbageValue = "69"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.field194 * 64 - this.regionStartX * 64 + var2, var3 + (this.field195 * 64 - this.regionStartY * 64)};
			return var4;
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(III)Lhx;",
		garbageValue = "1062204141"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.regionStartX * 64 - this.field194 * 64 + var1;
			int var4 = this.regionStartY * 64 - this.field195 * 64 + var2;
			return new Coord(this.minPlane, var3, var4);
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lkg;I)V",
		garbageValue = "-179898655"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte();
		this.planes = var1.readUnsignedByte();
		this.regionStartX = var1.readUnsignedShort();
		this.regionStartY = var1.readUnsignedShort();
		this.regionEndX = var1.readUnsignedShort();
		this.regionEndY = var1.readUnsignedShort();
		this.field194 = var1.readUnsignedShort();
		this.field195 = var1.readUnsignedShort();
		this.field196 = var1.readUnsignedShort();
		this.field197 = var1.readUnsignedShort();
		this.postRead();
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "8"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "582291691"
	)
	static final void method347(String var0) {
		GrandExchangeOfferAgeComparator.addGameMessage(30, "", var0);
	}

	@ObfuscatedName("hk")
	@ObfuscatedSignature(
		signature = "(ZLkj;I)V",
		garbageValue = "-1922958923"
	)
	@Export("updateNpcs")
	static final void updateNpcs(boolean var0, PacketBuffer var1) {
		Client.field814 = 0;
		Client.field687 = 0;
		WorldMapArea.method424();
		DynamicObject.method2262(var0, var1);

		int var2;
		int var3;
		for (var2 = 0; var2 < Client.field687; ++var2) {
			var3 = Client.field688[var2];
			NPC var4 = Client.npcs[var3];
			int var5 = var1.readUnsignedByte();
			int var6;
			int var7;
			int var8;
			int var9;
			if ((var5 & 4) != 0) {
				var6 = var1.method5689();
				int var10;
				int var11;
				int var12;
				if (var6 > 0) {
					for (var7 = 0; var7 < var6; ++var7) {
						var9 = -1;
						var10 = -1;
						var11 = -1;
						var8 = var1.readUShortSmart();
						if (var8 == 32767) {
							var8 = var1.readUShortSmart();
							var10 = var1.readUShortSmart();
							var9 = var1.readUShortSmart();
							var11 = var1.readUShortSmart();
						} else if (var8 != 32766) {
							var10 = var1.readUShortSmart();
						} else {
							var8 = -1;
						}

						var12 = var1.readUShortSmart();
						var4.addHitSplat(var8, var10, var9, var11, Client.cycle, var12);
					}
				}

				var7 = var1.method5631();
				if (var7 > 0) {
					for (var8 = 0; var8 < var7; ++var8) {
						var9 = var1.readUShortSmart();
						var10 = var1.readUShortSmart();
						if (var10 != 32767) {
							var11 = var1.readUShortSmart();
							var12 = var1.readUnsignedByte();
							int var13 = var10 > 0 ? var1.readUnsignedByte() : var12;
							var4.addHealthBar(var9, Client.cycle, var10, var11, var12, var13);
						} else {
							var4.removeHealthBar(var9);
						}
					}
				}
			}

			if ((var5 & 16) != 0) {
				var4.targetIndex = var1.readUnsignedShort();
				if (var4.targetIndex == 65535) {
					var4.targetIndex = -1;
				}
			}

			if ((var5 & 32) != 0) {
				var4.overheadText = var1.readStringCp1252NullTerminated();
				var4.overheadTextCyclesRemaining = 100;
			}

			if ((var5 & 2) != 0) {
				var6 = var1.readUnsignedShort();
				if (var6 == 65535) {
					var6 = -1;
				}

				var7 = var1.readUnsignedByte();
				if (var6 == var4.sequence && var6 != -1) {
					var8 = GrandExchangeOfferAgeComparator.SequenceDefinition_get(var6).field3533;
					if (var8 == 1) {
						var4.sequenceFrame = 0;
						var4.sequenceFrameCycle = 0;
						var4.sequenceDelay = var7;
						var4.field971 = 0;
					}

					if (var8 == 2) {
						var4.field971 = 0;
					}
				} else if (var6 == -1 || var4.sequence == -1 || GrandExchangeOfferAgeComparator.SequenceDefinition_get(var6).field3527 >= GrandExchangeOfferAgeComparator.SequenceDefinition_get(var4.sequence).field3527) {
					var4.sequence = var6;
					var4.sequenceFrame = 0;
					var4.sequenceFrameCycle = 0;
					var4.sequenceDelay = var7;
					var4.field971 = 0;
					var4.field994 = var4.pathLength;
				}
			}

			if ((var5 & 1) != 0) {
				var4.definition = VarcInt.getNpcDefinition(var1.method5640());
				var4.field938 = var4.definition.size;
				var4.field988 = var4.definition.rotation;
				var4.walkSequence = var4.definition.walkSequence;
				var4.walkBackSequence = var4.definition.walkBackSequence;
				var4.walkLeftSequence = var4.definition.walkLeftSequence;
				var4.walkRightSequence = var4.definition.walkRightSequence;
				var4.readySequence = var4.definition.readySequence;
				var4.turnLeftSequence = var4.definition.turnLeftSequence;
				var4.turnRightSequence = var4.definition.turnRightSequence;
			}

			if ((var5 & 64) != 0) {
				var4.spotAnimation = var1.method5640();
				var6 = var1.readInt();
				var4.field996 = var6 >> 16;
				var4.field975 = (var6 & 65535) + Client.cycle;
				var4.spotAnimationFrame = 0;
				var4.spotAnimationFrameCycle = 0;
				if (var4.field975 > Client.cycle) {
					var4.spotAnimationFrame = -1;
				}

				if (var4.spotAnimation == 65535) {
					var4.spotAnimation = -1;
				}
			}

			if ((var5 & 8) != 0) {
				var6 = var1.readUnsignedShort();
				var7 = var1.readUnsignedShort();
				var8 = var4.x - (var6 - class51.baseX * 64 - class51.baseX * 64) * 64;
				var9 = var4.y - (var7 - VarcInt.baseY * 64 - VarcInt.baseY * 64) * 64;
				if (var8 != 0 || var9 != 0) {
					var4.field965 = (int)(Math.atan2((double)var8, (double)var9) * 325.949D) & 2047;
				}
			}
		}

		for (var2 = 0; var2 < Client.field814; ++var2) {
			var3 = Client.field764[var2];
			if (Client.npcs[var3].npcCycle != Client.cycle) {
				Client.npcs[var3].definition = null;
				Client.npcs[var3] = null;
			}
		}

		if (var1.offset != Client.packetWriter.serverPacketLength) {
			throw new RuntimeException(var1.offset + "," + Client.packetWriter.serverPacketLength);
		} else {
			for (var2 = 0; var2 < Client.npcCount; ++var2) {
				if (Client.npcs[Client.npcIndices[var2]] == null) {
					throw new RuntimeException(var2 + "," + Client.npcCount);
				}
			}

		}
	}
}
