import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("l")
@Implements("WorldMapSection2")
public class WorldMapSection2 implements WorldMapSection {
	@ObfuscatedName("go")
	@ObfuscatedGetter(
		intValue = -963712193
	)
	static int field195;
	@ObfuscatedName("hn")
	@ObfuscatedGetter(
		intValue = -4402151
	)
	@Export("cameraYaw")
	static int cameraYaw;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -879876937
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -208083253
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -940491027
	)
	@Export("regionStartX")
	int regionStartX;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1613337015
	)
	@Export("regionStartY")
	int regionStartY;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1112500481
	)
	@Export("regionEndX")
	int regionEndX;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1241448217
	)
	@Export("regionEndY")
	int regionEndY;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1756578177
	)
	int field191;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1979201453
	)
	int field192;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -783213001
	)
	int field193;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 634589909
	)
	int field196;

	WorldMapSection2() {
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lac;I)V",
		garbageValue = "2098672163"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field191) {
			var1.regionLowX = this.field191;
		}

		if (var1.regionHighX < this.field193) {
			var1.regionHighX = this.field193;
		}

		if (var1.regionLowY > this.field192) {
			var1.regionLowY = this.field192;
		}

		if (var1.regionHighY < this.field196) {
			var1.regionHighY = this.field196;
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "-327883108"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.planes + this.minPlane) {
			return var2 >> 6 >= this.regionStartX && var2 >> 6 <= this.regionEndX && var3 >> 6 >= this.regionStartY && var3 >> 6 <= this.regionEndY;
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
		return var1 >> 6 >= this.field191 && var1 >> 6 <= this.field193 && var2 >> 6 >= this.field192 && var2 >> 6 <= this.field196;
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
			int[] var4 = new int[]{this.field191 * 64 - this.regionStartX * 64 + var2, var3 + (this.field192 * 64 - this.regionStartY * 64)};
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
			int var3 = this.regionStartX * 64 - this.field191 * 64 + var1;
			int var4 = this.regionStartY * 64 - this.field192 * 64 + var2;
			return new Coord(this.minPlane, var3, var4);
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lkl;B)V",
		garbageValue = "-99"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte();
		this.planes = var1.readUnsignedByte();
		this.regionStartX = var1.readUnsignedShort();
		this.regionStartY = var1.readUnsignedShort();
		this.regionEndX = var1.readUnsignedShort();
		this.regionEndY = var1.readUnsignedShort();
		this.field191 = var1.readUnsignedShort();
		this.field192 = var1.readUnsignedShort();
		this.field193 = var1.readUnsignedShort();
		this.field196 = var1.readUnsignedShort();
		this.postRead();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-3"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "-1894474277"
	)
	static int method342(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		if (var0 == ScriptOpcodes.CC_CREATE) {
			Interpreter.Interpreter_intStackSize -= 3;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			int var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			if (var4 == 0) {
				throw new RuntimeException();
			} else {
				Widget var6 = Canvas.getWidget(var3);
				if (var6.children == null) {
					var6.children = new Widget[var5 + 1];
				}

				if (var6.children.length <= var5) {
					Widget[] var7 = new Widget[var5 + 1];

					for (int var8 = 0; var8 < var6.children.length; ++var8) {
						var7[var8] = var6.children[var8];
					}

					var6.children = var7;
				}

				if (var5 > 0 && var6.children[var5 - 1] == null) {
					throw new RuntimeException("" + (var5 - 1));
				} else {
					Widget var12 = new Widget();
					var12.type = var4;
					var12.parentId = var12.id = var6.id;
					var12.childIndex = var5;
					var12.isIf3 = true;
					var6.children[var5] = var12;
					if (var2) {
						GrandExchangeOfferAgeComparator.field76 = var12;
					} else {
						KitDefinition.field3252 = var12;
					}

					WorldMapSectionType.invalidateWidget(var6);
					return 1;
				}
			}
		} else {
			Widget var9;
			if (var0 == ScriptOpcodes.CC_DELETE) {
				var9 = var2 ? GrandExchangeOfferAgeComparator.field76 : KitDefinition.field3252;
				Widget var10 = Canvas.getWidget(var9.id);
				var10.children[var9.childIndex] = null;
				WorldMapSectionType.invalidateWidget(var10);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_DELETEALL) {
				var9 = Canvas.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
				var9.children = null;
				WorldMapSectionType.invalidateWidget(var9);
				return 1;
			} else if (var0 != ScriptOpcodes.CC_FIND) {
				if (var0 == ScriptOpcodes.IF_FIND) {
					var9 = Canvas.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
					if (var9 != null) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
						if (var2) {
							GrandExchangeOfferAgeComparator.field76 = var9;
						} else {
							KitDefinition.field3252 = var9;
						}
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else {
					return 2;
				}
			} else {
				Interpreter.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				Widget var11 = GrandExchangeOfferWorldComparator.getWidgetChild(var3, var4);
				if (var11 != null && var4 != -1) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
					if (var2) {
						GrandExchangeOfferAgeComparator.field76 = var11;
					} else {
						KitDefinition.field3252 = var11;
					}
				} else {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			}
		}
	}
}
