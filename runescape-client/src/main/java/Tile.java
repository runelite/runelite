import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
@Implements("Tile")
public final class Tile extends Node {
	@ObfuscatedName("nn")
	@ObfuscatedGetter(
		intValue = -590587583
	)
	static int field1648;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1576668311
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -2142283815
	)
	@Export("x")
	int x;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 22720331
	)
	@Export("y")
	int y;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 322819535
	)
	@Export("originalPlane")
	int originalPlane;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("paint")
	TilePaint paint;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Ldg;"
	)
	@Export("model")
	TileModel model;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Ley;"
	)
	@Export("boundaryObject")
	BoundaryObject boundaryObject;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lec;"
	)
	@Export("wallDecoration")
	WallDecoration wallDecoration;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Ldy;"
	)
	@Export("floorDecoration")
	FloorDecoration floorDecoration;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Ldu;"
	)
	@Export("tileItemPile")
	TileItemPile tileItemPile;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -76351175
	)
	@Export("gameObjectsCount")
	int gameObjectsCount;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "[Lej;"
	)
	@Export("gameObjects")
	GameObject[] gameObjects;
	@ObfuscatedName("r")
	@Export("gameObjectEdgeMasks")
	int[] gameObjectEdgeMasks;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 832836189
	)
	@Export("gameObjectsEdgeMask")
	int gameObjectsEdgeMask;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1717986561
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("b")
	@Export("drawPrimary")
	boolean drawPrimary;
	@ObfuscatedName("g")
	@Export("drawSecondary")
	boolean drawSecondary;
	@ObfuscatedName("e")
	@Export("drawGameObjects")
	boolean drawGameObjects;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1859538339
	)
	@Export("drawGameObjectEdges")
	int drawGameObjectEdges;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -652671997
	)
	int field1637;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1052800923
	)
	int field1645;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 837010603
	)
	int field1636;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lde;"
	)
	@Export("linkedBelowTile")
	Tile linkedBelowTile;

	Tile(int var1, int var2, int var3) {
		this.gameObjects = new GameObject[5];
		this.gameObjectEdgeMasks = new int[5];
		this.gameObjectsEdgeMask = 0;
		this.originalPlane = this.plane = var1;
		this.x = var2;
		this.y = var3;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "([Lbl;II[I[IB)V",
		garbageValue = "-18"
	)
	@Export("sortWorlds")
	static void sortWorlds(World[] var0, int var1, int var2, int[] var3, int[] var4) {
		if (var1 < var2) {
			int var5 = var1 - 1;
			int var6 = var2 + 1;
			int var7 = (var2 + var1) / 2;
			World var8 = var0[var7];
			var0[var7] = var0[var1];
			var0[var1] = var8;

			while (var5 < var6) {
				boolean var9 = true;

				int var10;
				int var11;
				int var12;
				do {
					--var6;

					for (var10 = 0; var10 < 4; ++var10) {
						if (var3[var10] == 2) {
							var11 = var0[var6].index;
							var12 = var8.index;
						} else if (var3[var10] == 1) {
							var11 = var0[var6].population;
							var12 = var8.population;
							if (var11 == -1 && var4[var10] == 1) {
								var11 = 2001;
							}

							if (var12 == -1 && var4[var10] == 1) {
								var12 = 2001;
							}
						} else if (var3[var10] == 3) {
							var11 = var0[var6].isMembersOnly() ? 1 : 0;
							var12 = var8.isMembersOnly() ? 1 : 0;
						} else {
							var11 = var0[var6].id;
							var12 = var8.id;
						}

						if (var12 != var11) {
							if ((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
								var9 = false;
							}
							break;
						}

						if (var10 == 3) {
							var9 = false;
						}
					}
				} while(var9);

				var9 = true;

				do {
					++var5;

					for (var10 = 0; var10 < 4; ++var10) {
						if (var3[var10] == 2) {
							var11 = var0[var5].index;
							var12 = var8.index;
						} else if (var3[var10] == 1) {
							var11 = var0[var5].population;
							var12 = var8.population;
							if (var11 == -1 && var4[var10] == 1) {
								var11 = 2001;
							}

							if (var12 == -1 && var4[var10] == 1) {
								var12 = 2001;
							}
						} else if (var3[var10] == 3) {
							var11 = var0[var5].isMembersOnly() ? 1 : 0;
							var12 = var8.isMembersOnly() ? 1 : 0;
						} else {
							var11 = var0[var5].id;
							var12 = var8.id;
						}

						if (var11 != var12) {
							if ((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
								var9 = false;
							}
							break;
						}

						if (var10 == 3) {
							var9 = false;
						}
					}
				} while(var9);

				if (var5 < var6) {
					World var13 = var0[var5];
					var0[var5] = var0[var6];
					var0[var6] = var13;
				}
			}

			sortWorlds(var0, var1, var6, var3, var4);
			sortWorlds(var0, var6 + 1, var2, var3, var4);
		}

	}

	@ObfuscatedName("jj")
	@ObfuscatedSignature(
		signature = "([Lhp;II)V",
		garbageValue = "1415111680"
	)
	@Export("drawModelComponents")
	static final void drawModelComponents(Widget[] var0, int var1) {
		for (int var2 = 0; var2 < var0.length; ++var2) {
			Widget var3 = var0[var2];
			if (var3 != null && var3.parentId == var1 && (!var3.isIf3 || !WorldMapRectangle.isComponentHidden(var3))) {
				if (var3.type == 0) {
					if (!var3.isIf3 && WorldMapRectangle.isComponentHidden(var3) && var3 != class65.mousedOverWidgetIf1) {
						continue;
					}

					drawModelComponents(var0, var3.id);
					if (var3.children != null) {
						drawModelComponents(var3.children, var3.id);
					}

					InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var3.id);
					if (var4 != null) {
						CollisionMap.drawInterfaceModelComponents(var4.group);
					}
				}

				if (var3.type == 6) {
					int var5;
					if (var3.sequenceId != -1 || var3.sequenceId2 != -1) {
						boolean var7 = UserComparator10.runCs1(var3);
						if (var7) {
							var5 = var3.sequenceId2;
						} else {
							var5 = var3.sequenceId;
						}

						if (var5 != -1) {
							SequenceDefinition var6 = Widget.SequenceDefinition_get(var5);

							for (var3.modelFrameCycle += Client.field879; var3.modelFrameCycle > var6.frameLengths[var3.modelFrame]; FriendSystem.invalidateWidget(var3)) {
								var3.modelFrameCycle -= var6.frameLengths[var3.modelFrame];
								++var3.modelFrame;
								if (var3.modelFrame >= var6.frameIds.length) {
									var3.modelFrame -= var6.frameCount;
									if (var3.modelFrame < 0 || var3.modelFrame >= var6.frameIds.length) {
										var3.modelFrame = 0;
									}
								}
							}
						}
					}

					if (var3.field2602 != 0 && !var3.isIf3) {
						int var8 = var3.field2602 >> 16;
						var5 = var3.field2602 << 16 >> 16;
						var8 *= Client.field879;
						var5 *= Client.field879;
						var3.modelAngleX = var8 + var3.modelAngleX & 2047;
						var3.modelAngleY = var5 + var3.modelAngleY & 2047;
						FriendSystem.invalidateWidget(var3);
					}
				}
			}
		}

	}
}
