import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
@Implements("Tiles")
public final class Tiles {
	@ObfuscatedName("qs")
	@ObfuscatedSignature(
		signature = "Ldz;"
	)
	@Export("pcmStreamMixer")
	static PcmStreamMixer pcmStreamMixer;
	@ObfuscatedName("x")
	@Export("Tiles_heights")
	static int[][][] Tiles_heights;
	@ObfuscatedName("m")
	@Export("Tiles_renderFlags")
	static byte[][][] Tiles_renderFlags;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -824487333
	)
	@Export("Tiles_minPlane")
	static int Tiles_minPlane;
	@ObfuscatedName("d")
	static byte[][][] field538;
	@ObfuscatedName("v")
	static byte[][][] field539;
	@ObfuscatedName("q")
	static byte[][][] field540;
	@ObfuscatedName("t")
	static int[][] field545;
	@ObfuscatedName("n")
	@Export("Tiles_hueMultiplier")
	static int[] Tiles_hueMultiplier;
	@ObfuscatedName("b")
	static final int[] field544;
	@ObfuscatedName("l")
	static final int[] field542;
	@ObfuscatedName("r")
	static final int[] field541;
	@ObfuscatedName("o")
	static final int[] field547;
	@ObfuscatedName("c")
	static final int[] field546;
	@ObfuscatedName("j")
	static final int[] field552;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -408208893
	)
	static int field550;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 747701179
	)
	static int field548;

	static {
		Tiles_heights = new int[4][105][105];
		Tiles_renderFlags = new byte[4][104][104];
		Tiles_minPlane = 99;
		field544 = new int[]{1, 2, 4, 8};
		field542 = new int[]{16, 32, 64, 128};
		field541 = new int[]{1, 0, -1, 0};
		field547 = new int[]{0, -1, 0, 1};
		field546 = new int[]{1, -1, -1, 1};
		field552 = new int[]{-1, -1, 1, 1};
		field550 = (int)(Math.random() * 17.0D) - 8;
		field548 = (int)(Math.random() * 33.0D) - 16;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)I",
		garbageValue = "3344543"
	)
	@Export("parseInt")
	public static int parseInt(CharSequence var0) {
		return class105.parseIntCustomRadix(var0, 10, true);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(Ljw;I)Z",
		garbageValue = "-1065823023"
	)
	static boolean method1239(ObjectDefinition var0) {
		if (var0.transforms != null) {
			int[] var1 = var0.transforms;

			for (int var2 = 0; var2 < var1.length; ++var2) {
				int var3 = var1[var2];
				ObjectDefinition var4 = WorldMapSection2.getObjectDefinition(var3);
				if (var4.mapIconId != -1) {
					return true;
				}
			}
		} else if (var0.mapIconId != -1) {
			return true;
		}

		return false;
	}

	@ObfuscatedName("gl")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "29"
	)
	static final int method1238() {
		if (GrandExchangeOfferOwnWorldComparator.clientPreferences.roofsHidden) {
			return ScriptEvent.Client_plane;
		} else {
			int var0 = class277.getTileHeight(WorldMapRectangle.cameraX, class200.cameraZ, ScriptEvent.Client_plane);
			return var0 - GrandExchangeOfferWorldComparator.cameraY < 800 && (Tiles_renderFlags[ScriptEvent.Client_plane][WorldMapRectangle.cameraX >> 7][class200.cameraZ >> 7] & 4) != 0 ? ScriptEvent.Client_plane : 3;
		}
	}

	@ObfuscatedName("jx")
	@ObfuscatedSignature(
		signature = "(Lhe;II)I",
		garbageValue = "2058882289"
	)
	static final int method1227(Widget var0, int var1) {
		if (var0.cs1Instructions != null && var1 < var0.cs1Instructions.length) {
			try {
				int[] var2 = var0.cs1Instructions[var1];
				int var3 = 0;
				int var4 = 0;
				byte var5 = 0;

				while (true) {
					int var6 = var2[var4++];
					int var7 = 0;
					byte var8 = 0;
					if (var6 == 0) {
						return var3;
					}

					if (var6 == 1) {
						var7 = Client.currentLevels[var2[var4++]];
					}

					if (var6 == 2) {
						var7 = Client.levels[var2[var4++]];
					}

					if (var6 == 3) {
						var7 = Client.experience[var2[var4++]];
					}

					int var9;
					Widget var10;
					int var11;
					int var12;
					if (var6 == 4) {
						var9 = var2[var4++] << 16;
						var9 += var2[var4++];
						var10 = MusicPatchNode.getWidget(var9);
						var11 = var2[var4++];
						if (var11 != -1 && (!AbstractWorldMapData.ItemDefinition_get(var11).isMembersOnly || Client.isMembersWorld)) {
							for (var12 = 0; var12 < var10.itemIds.length; ++var12) {
								if (var11 + 1 == var10.itemIds[var12]) {
									var7 += var10.itemQuantities[var12];
								}
							}
						}
					}

					if (var6 == 5) {
						var7 = Varps.Varps_main[var2[var4++]];
					}

					if (var6 == 6) {
						var7 = Skills.Skills_experienceTable[Client.levels[var2[var4++]] - 1];
					}

					if (var6 == 7) {
						var7 = Varps.Varps_main[var2[var4++]] * 100 / 46875;
					}

					if (var6 == 8) {
						var7 = ByteArrayPool.localPlayer.combatLevel;
					}

					if (var6 == 9) {
						for (var9 = 0; var9 < 25; ++var9) {
							if (Skills.Skills_enabled[var9]) {
								var7 += Client.levels[var9];
							}
						}
					}

					if (var6 == 10) {
						var9 = var2[var4++] << 16;
						var9 += var2[var4++];
						var10 = MusicPatchNode.getWidget(var9);
						var11 = var2[var4++];
						if (var11 != -1 && (!AbstractWorldMapData.ItemDefinition_get(var11).isMembersOnly || Client.isMembersWorld)) {
							for (var12 = 0; var12 < var10.itemIds.length; ++var12) {
								if (var11 + 1 == var10.itemIds[var12]) {
									var7 = 999999999;
									break;
								}
							}
						}
					}

					if (var6 == 11) {
						var7 = Client.runEnergy;
					}

					if (var6 == 12) {
						var7 = Client.weight;
					}

					if (var6 == 13) {
						var9 = Varps.Varps_main[var2[var4++]];
						int var13 = var2[var4++];
						var7 = (var9 & 1 << var13) != 0 ? 1 : 0;
					}

					if (var6 == 14) {
						var9 = var2[var4++];
						var7 = Projectile.getVarbit(var9);
					}

					if (var6 == 15) {
						var8 = 1;
					}

					if (var6 == 16) {
						var8 = 2;
					}

					if (var6 == 17) {
						var8 = 3;
					}

					if (var6 == 18) {
						var7 = (ByteArrayPool.localPlayer.x >> 7) + class69.baseX;
					}

					if (var6 == 19) {
						var7 = (ByteArrayPool.localPlayer.y >> 7) + class89.baseY;
					}

					if (var6 == 20) {
						var7 = var2[var4++];
					}

					if (var8 == 0) {
						if (var5 == 0) {
							var3 += var7;
						}

						if (var5 == 1) {
							var3 -= var7;
						}

						if (var5 == 2 && var7 != 0) {
							var3 /= var7;
						}

						if (var5 == 3) {
							var3 *= var7;
						}

						var5 = 0;
					} else {
						var5 = var8;
					}
				}
			} catch (Exception var14) {
				return -1;
			}
		} else {
			return -2;
		}
	}
}
