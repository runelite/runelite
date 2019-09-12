import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
@Implements("Tile")
public final class Tile extends Node {
	@ObfuscatedName("ha")
	@ObfuscatedGetter(
		intValue = -1915591411
	)
	@Export("cameraYaw")
	static int cameraYaw;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 255690453
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1658035031
	)
	@Export("y")
	int y;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 518252243
	)
	@Export("x")
	int x;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 2024380867
	)
	@Export("originalPlane")
	int originalPlane;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lec;"
	)
	@Export("paint")
	TilePaint paint;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Ldv;"
	)
	@Export("model")
	TileModel model;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lea;"
	)
	@Export("boundaryObject")
	BoundaryObject boundaryObject;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Les;"
	)
	@Export("wallDecoration")
	WallDecoration wallDecoration;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Ldb;"
	)
	@Export("floorDecoration")
	FloorDecoration floorDecoration;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Ldc;"
	)
	@Export("tileItemPile")
	TileItemPile tileItemPile;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 342071413
	)
	@Export("gameObjectsCount")
	int gameObjectsCount;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "[Lef;"
	)
	@Export("gameObjects")
	GameObject[] gameObjects;
	@ObfuscatedName("f")
	@Export("gameObjectEdgeMasks")
	int[] gameObjectEdgeMasks;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -247968309
	)
	@Export("gameObjectsEdgeMask")
	int gameObjectsEdgeMask;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1983266615
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("e")
	@Export("drawPrimary")
	boolean drawPrimary;
	@ObfuscatedName("i")
	@Export("drawSecondary")
	boolean drawSecondary;
	@ObfuscatedName("q")
	@Export("drawGameObjects")
	boolean drawGameObjects;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1182393573
	)
	@Export("drawGameObjectEdges")
	int drawGameObjectEdges;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1178282289
	)
	int field1632;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 340120719
	)
	int field1622;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 248240175
	)
	int field1613;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Ldq;"
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

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)[Lho;",
		garbageValue = "-1998452195"
	)
	public static ServerBuild[] method2830() {
		return new ServerBuild[]{ServerBuild.RC, ServerBuild.LIVE, ServerBuild.WIP, ServerBuild.BUILDLIVE};
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)[Lht;",
		garbageValue = "2061214511"
	)
	public static StudioGame[] method2831() {
		return new StudioGame[]{StudioGame.runescape, StudioGame.oldscape, StudioGame.game4, StudioGame.game3, StudioGame.game5, StudioGame.stellardawn};
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "2091898372"
	)
	@Export("runWidgetOnLoadListener")
	static void runWidgetOnLoadListener(int var0) {
		if (var0 != -1) {
			if (TaskHandler.loadInterface(var0)) {
				Widget[] var1 = class289.Widget_interfaceComponents[var0];

				for (int var2 = 0; var2 < var1.length; ++var2) {
					Widget var3 = var1[var2];
					if (var3.onLoad != null) {
						ScriptEvent var4 = new ScriptEvent();
						var4.widget = var3;
						var4.args = var3.onLoad;
						GameShell.runScript(var4, 5000000);
					}
				}

			}
		}
	}

	@ObfuscatedName("fa")
	@ObfuscatedSignature(
		signature = "(Lbe;IB)V",
		garbageValue = "2"
	)
	@Export("calculateActorPosition")
	static final void calculateActorPosition(Actor var0, int var1) {
		int var3;
		int var4;
		int var11;
		if (var0.field963 > Client.cycle) {
			WorldMapSection2.method299(var0);
		} else if (var0.field964 >= Client.cycle) {
			Login.method2075(var0);
		} else {
			var0.movementSequence = var0.readySequence;
			if (var0.pathLength == 0) {
				var0.field975 = 0;
			} else {
				label396: {
					if (var0.sequence != -1 && var0.sequenceDelay == 0) {
						SequenceDefinition var2 = class83.SequenceDefinition_get(var0.sequence);
						if (var0.field969 > 0 && var2.field3496 == 0) {
							++var0.field975;
							break label396;
						}

						if (var0.field969 <= 0 && var2.field3501 == 0) {
							++var0.field975;
							break label396;
						}
					}

					var11 = var0.x * -78439701;
					var3 = var0.y;
					var4 = var0.pathX[var0.pathLength - 1] * 128 + var0.size * 64;
					int var5 = var0.pathY[var0.pathLength - 1] * 128 + var0.size * 64;
					if (var11 < var4) {
						if (var3 < var5) {
							var0.orientation = 1280;
						} else if (var3 > var5) {
							var0.orientation = 1792;
						} else {
							var0.orientation = 1536;
						}
					} else if (var11 > var4) {
						if (var3 < var5) {
							var0.orientation = 768;
						} else if (var3 > var5) {
							var0.orientation = 256;
						} else {
							var0.orientation = 512;
						}
					} else if (var3 < var5) {
						var0.orientation = 1024;
					} else if (var3 > var5) {
						var0.orientation = 0;
					}

					byte var6 = var0.pathTraversed[var0.pathLength - 1];
					if (var4 - var11 <= 256 && var4 - var11 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
						int var7 = var0.orientation - var0.rotation & 2047;
						if (var7 > 1024) {
							var7 -= 2048;
						}

						int var8 = var0.walkBackSequence;
						if (var7 >= -256 && var7 <= 256) {
							var8 = var0.walkSequence;
						} else if (var7 >= 256 && var7 < 768) {
							var8 = var0.walkRightSequence;
						} else if (var7 >= -768 && var7 <= -256) {
							var8 = var0.walkLeftSequence;
						}

						if (var8 == -1) {
							var8 = var0.walkSequence;
						}

						var0.movementSequence = var8;
						int var9 = 4;
						boolean var10 = true;
						if (var0 instanceof NPC) {
							var10 = ((NPC)var0).definition.isClickable;
						}

						if (var10) {
							if (var0.rotation != var0.orientation && var0.targetIndex == -1 && var0.field953 != 0) {
								var9 = 2;
							}

							if (var0.pathLength > 2) {
								var9 = 6;
							}

							if (var0.pathLength > 3) {
								var9 = 8;
							}

							if (var0.field975 > 0 && var0.pathLength > 1) {
								var9 = 8;
								--var0.field975;
							}
						} else {
							if (var0.pathLength > 1) {
								var9 = 6;
							}

							if (var0.pathLength > 2) {
								var9 = 8;
							}

							if (var0.field975 > 0 && var0.pathLength > 1) {
								var9 = 8;
								--var0.field975;
							}
						}

						if (var6 == 2) {
							var9 <<= 1;
						}

						if (var9 >= 8 && var0.movementSequence == var0.walkSequence && var0.runSequence != -1) {
							var0.movementSequence = var0.runSequence;
						}

						if (var11 != var4 || var5 != var3) {
							if (var11 < var4) {
								var0.x += var9 * 62504387;
								if (var0.x * -78439701 > var4) {
									var0.x = var4 * 62504387;
								}
							} else if (var11 > var4) {
								var0.x -= var9 * 62504387;
								if (var0.x * -78439701 < var4) {
									var0.x = var4 * 62504387;
								}
							}

							if (var3 < var5) {
								var0.y += var9;
								if (var0.y > var5) {
									var0.y = var5;
								}
							} else if (var3 > var5) {
								var0.y -= var9;
								if (var0.y < var5) {
									var0.y = var5;
								}
							}
						}

						if (var0.x * -78439701 == var4 && var5 == var0.y) {
							--var0.pathLength;
							if (var0.field969 > 0) {
								--var0.field969;
							}
						}
					} else {
						var0.x = var4 * 62504387;
						var0.y = var5;
						--var0.pathLength;
						if (var0.field969 > 0) {
							--var0.field969;
						}
					}
				}
			}
		}

		if (var0.x * -78439701 < 128 || var0.y < 128 || var0.x * -78439701 >= 13184 || var0.y >= 13184) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.field963 = 0;
			var0.field964 = 0;
			var0.x = var0.pathX[0] * -589373056 + var0.size * -294686528;
			var0.y = var0.pathY[0] * 128 + var0.size * 64;
			var0.method1699();
		}

		if (Varps.localPlayer == var0 && (var0.x * -78439701 < 1536 || var0.y < 1536 || var0.x * -78439701 >= 11776 || var0.y >= 11776)) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.field963 = 0;
			var0.field964 = 0;
			var0.x = var0.size * -294686528 + var0.pathX[0] * -589373056;
			var0.y = var0.pathY[0] * 128 + var0.size * 64;
			var0.method1699();
		}

		if (var0.field953 != 0) {
			if (var0.targetIndex != -1) {
				Object var13 = null;
				if (var0.targetIndex < 32768) {
					var13 = Client.npcs[var0.targetIndex];
				} else if (var0.targetIndex >= 32768) {
					var13 = Client.players[var0.targetIndex - 32768];
				}

				if (var13 != null) {
					var3 = var0.x * -78439701 - ((Actor)var13).x * -78439701;
					var4 = var0.y - ((Actor)var13).y;
					if (var3 != 0 || var4 != 0) {
						var0.orientation = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
					}
				} else if (var0.false0) {
					var0.targetIndex = -1;
					var0.false0 = false;
				}
			}

			if (var0.field945 != -1 && (var0.pathLength == 0 || var0.field975 > 0)) {
				var0.orientation = var0.field945;
				var0.field945 = -1;
			}

			var11 = var0.orientation - var0.rotation & 2047;
			if (var11 == 0 && var0.false0) {
				var0.targetIndex = -1;
				var0.false0 = false;
			}

			if (var11 != 0) {
				++var0.field976;
				boolean var14;
				if (var11 > 1024) {
					var0.rotation -= var0.field953;
					var14 = true;
					if (var11 < var0.field953 || var11 > 2048 - var0.field953) {
						var0.rotation = var0.orientation;
						var14 = false;
					}

					if (var0.movementSequence == var0.readySequence && (var0.field976 > 25 || var14)) {
						if (var0.turnLeftSequence != -1) {
							var0.movementSequence = var0.turnLeftSequence;
						} else {
							var0.movementSequence = var0.walkSequence;
						}
					}
				} else {
					var0.rotation += var0.field953;
					var14 = true;
					if (var11 < var0.field953 || var11 > 2048 - var0.field953) {
						var0.rotation = var0.orientation;
						var14 = false;
					}

					if (var0.readySequence == var0.movementSequence && (var0.field976 > 25 || var14)) {
						if (var0.turnRightSequence != -1) {
							var0.movementSequence = var0.turnRightSequence;
						} else {
							var0.movementSequence = var0.walkSequence;
						}
					}
				}

				var0.rotation &= 2047;
			} else {
				var0.field976 = 0;
			}
		}

		HitSplatDefinition.method4558(var0);
	}

	@ObfuscatedName("iy")
	@ObfuscatedSignature(
		signature = "(Lhy;I)Z",
		garbageValue = "-2046780414"
	)
	@Export("runCs1")
	static final boolean runCs1(Widget var0) {
		if (var0.cs1Comparisons == null) {
			return false;
		} else {
			for (int var1 = 0; var1 < var0.cs1Comparisons.length; ++var1) {
				int var2 = class286.method5218(var0, var1);
				int var3 = var0.cs1ComparisonValues[var1];
				if (var0.cs1Comparisons[var1] == 2) {
					if (var2 >= var3) {
						return false;
					}
				} else if (var0.cs1Comparisons[var1] == 3) {
					if (var2 <= var3) {
						return false;
					}
				} else if (var0.cs1Comparisons[var1] == 4) {
					if (var2 == var3) {
						return false;
					}
				} else if (var3 != var2) {
					return false;
				}
			}

			return true;
		}
	}
}
