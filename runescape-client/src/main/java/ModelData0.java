import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
@Implements("ModelData0")
public class ModelData0 {
	@ObfuscatedName("fl")
	@ObfuscatedSignature(
		signature = "Lko;"
	)
	@Export("WorldMapElement_fonts")
	static Fonts WorldMapElement_fonts;

	ModelData0() {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "1770861677"
	)
	public static boolean method3379(int var0, int var1) {
		return (var0 >> var1 + 1 & 1) != 0;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIIZIZI)V",
		garbageValue = "1985291940"
	)
	@Export("doWorldSorting")
	static void doWorldSorting(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
		if (var0 < var1) {
			int var6 = (var0 + var1) / 2;
			int var7 = var0;
			World var8 = Username.World_worlds[var6];
			Username.World_worlds[var6] = Username.World_worlds[var1];
			Username.World_worlds[var1] = var8;

			for (int var9 = var0; var9 < var1; ++var9) {
				World var11 = Username.World_worlds[var9];
				int var12 = ScriptFrame.compareWorlds(var11, var8, var2, var3);
				int var10;
				if (var12 != 0) {
					if (var3) {
						var10 = -var12;
					} else {
						var10 = var12;
					}
				} else if (var4 == -1) {
					var10 = 0;
				} else {
					int var13 = ScriptFrame.compareWorlds(var11, var8, var4, var5);
					if (var5) {
						var10 = -var13;
					} else {
						var10 = var13;
					}
				}

				if (var10 <= 0) {
					World var14 = Username.World_worlds[var9];
					Username.World_worlds[var9] = Username.World_worlds[var7];
					Username.World_worlds[var7++] = var14;
				}
			}

			Username.World_worlds[var1] = Username.World_worlds[var7];
			Username.World_worlds[var7] = var8;
			doWorldSorting(var0, var7 - 1, var2, var3, var4, var5);
			doWorldSorting(var7 + 1, var1, var2, var3, var4, var5);
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1344492505"
	)
	static final void method3380() {
		Object var10000 = null;
		String var0 = "Your ignore list is full. Max of 100 for free users, and 400 for members";
		class30.addGameMessage(30, "", var0);
	}

	@ObfuscatedName("gx")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-39"
	)
	static final void method3378() {
		if (Ignored.ClanChat_inClanChat) {
			if (class4.clanChat != null) {
				class4.clanChat.sort();
			}

			WorldMapSectionType.method294();
			Ignored.ClanChat_inClanChat = false;
		}

	}

	@ObfuscatedName("gm")
	@ObfuscatedSignature(
		signature = "(Lbz;I)V",
		garbageValue = "-1736230875"
	)
	static final void method3377(Actor var0) {
		var0.movementSequence = var0.readySequence;
		if (var0.pathLength == 0) {
			var0.field982 = 0;
		} else {
			if (var0.sequence != -1 && var0.sequenceDelay == 0) {
				SequenceDefinition var1 = PlayerType.SequenceDefinition_get(var0.sequence);
				if (var0.field983 > 0 && var1.field3504 == 0) {
					++var0.field982;
					return;
				}

				if (var0.field983 <= 0 && var1.field3513 == 0) {
					++var0.field982;
					return;
				}
			}

			int var10 = var0.x;
			int var2 = var0.y;
			int var3 = var0.pathX[var0.pathLength - 1] * 128 + var0.field927 * 64;
			int var4 = var0.pathY[var0.pathLength - 1] * 128 + var0.field927 * 64;
			if (var10 < var3) {
				if (var2 < var4) {
					var0.orientation = 1280;
				} else if (var2 > var4) {
					var0.orientation = 1792;
				} else {
					var0.orientation = 1536;
				}
			} else if (var10 > var3) {
				if (var2 < var4) {
					var0.orientation = 768;
				} else if (var2 > var4) {
					var0.orientation = 256;
				} else {
					var0.orientation = 512;
				}
			} else if (var2 < var4) {
				var0.orientation = 1024;
			} else if (var2 > var4) {
				var0.orientation = 0;
			}

			byte var5 = var0.pathTraversed[var0.pathLength - 1];
			if (var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
				int var6 = var0.orientation - var0.rotation & 2047;
				if (var6 > 1024) {
					var6 -= 2048;
				}

				int var7 = var0.walkBackSequence;
				if (var6 >= -256 && var6 <= 256) {
					var7 = var0.walkSequence;
				} else if (var6 >= 256 && var6 < 768) {
					var7 = var0.walkRightSequence;
				} else if (var6 >= -768 && var6 <= -256) {
					var7 = var0.walkLeftSequence;
				}

				if (var7 == -1) {
					var7 = var0.walkSequence;
				}

				var0.movementSequence = var7;
				int var8 = 4;
				boolean var9 = true;
				if (var0 instanceof NPC) {
					var9 = ((NPC)var0).definition.isClickable;
				}

				if (var9) {
					if (var0.orientation != var0.rotation && var0.targetIndex == -1 && var0.field977 != 0) {
						var8 = 2;
					}

					if (var0.pathLength > 2) {
						var8 = 6;
					}

					if (var0.pathLength > 3) {
						var8 = 8;
					}

					if (var0.field982 > 0 && var0.pathLength > 1) {
						var8 = 8;
						--var0.field982;
					}
				} else {
					if (var0.pathLength > 1) {
						var8 = 6;
					}

					if (var0.pathLength > 2) {
						var8 = 8;
					}

					if (var0.field982 > 0 && var0.pathLength > 1) {
						var8 = 8;
						--var0.field982;
					}
				}

				if (var5 == 2) {
					var8 <<= 1;
				}

				if (var8 >= 8 && var0.movementSequence == var0.walkSequence && var0.runSequence != -1) {
					var0.movementSequence = var0.runSequence;
				}

				if (var10 != var3 || var4 != var2) {
					if (var10 < var3) {
						var0.x += var8;
						if (var0.x > var3) {
							var0.x = var3;
						}
					} else if (var10 > var3) {
						var0.x -= var8;
						if (var0.x < var3) {
							var0.x = var3;
						}
					}

					if (var2 < var4) {
						var0.y += var8;
						if (var0.y > var4) {
							var0.y = var4;
						}
					} else if (var2 > var4) {
						var0.y -= var8;
						if (var0.y < var4) {
							var0.y = var4;
						}
					}
				}

				if (var3 == var0.x && var4 == var0.y) {
					--var0.pathLength;
					if (var0.field983 > 0) {
						--var0.field983;
					}
				}

			} else {
				var0.x = var3;
				var0.y = var4;
				--var0.pathLength;
				if (var0.field983 > 0) {
					--var0.field983;
				}

			}
		}
	}
}
