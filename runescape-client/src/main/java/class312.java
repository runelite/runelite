import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lc")
public enum class312 implements Enumerated {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Llc;"
	)
	field3799(0, 0),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Llc;"
	)
	field3798(4, 2),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Llc;"
	)
	field3800(3, 5),
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Llc;"
	)
	field3801(2, 6),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Llc;"
	)
	field3805(5, 7),
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Llc;"
	)
	field3802(1, 8);

	@ObfuscatedName("e")
	static String[] field3803;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 710760119
	)
	final int field3797;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1869652173
	)
	@Export("id")
	final int id;

	class312(int var3, int var4) {
		this.field3797 = var3;
		this.id = var4;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1993081102"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
		garbageValue = "-911741396"
	)
	public static String method6014(CharSequence var0) {
		int var1 = var0.length();
		StringBuilder var2 = new StringBuilder(var1);

		for (int var3 = 0; var3 < var1; ++var3) {
			char var4 = var0.charAt(var3);
			if ((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
				if (var4 == ' ') {
					var2.append('+');
				} else {
					byte var5 = WorldMapData_1.charToByteCp1252(var4);
					var2.append('%');
					int var6 = var5 >> 4 & 15;
					if (var6 >= 10) {
						var2.append((char)(var6 + 55));
					} else {
						var2.append((char)(var6 + 48));
					}

					var6 = var5 & 15;
					if (var6 >= 10) {
						var2.append((char)(var6 + 55));
					} else {
						var2.append((char)(var6 + 48));
					}
				}
			} else {
				var2.append(var4);
			}
		}

		return var2.toString();
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkc;IIIIIIB)V",
		garbageValue = "106"
	)
	@Export("loadTerrain")
	static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		int var7;
		if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
			Tiles.Tiles_renderFlags[var1][var2][var3] = 0;

			while (true) {
				var7 = var0.readUnsignedByte();
				if (var7 == 0) {
					if (var1 == 0) {
						Tiles.Tiles_heights[0][var2][var3] = -SpotAnimationDefinition.method4582(var2 + 932731 + var4, var5 + 556238 + var3) * 8;
					} else {
						Tiles.Tiles_heights[var1][var2][var3] = Tiles.Tiles_heights[var1 - 1][var2][var3] - 240;
					}
					break;
				}

				if (var7 == 1) {
					int var8 = var0.readUnsignedByte();
					if (var8 == 1) {
						var8 = 0;
					}

					if (var1 == 0) {
						Tiles.Tiles_heights[0][var2][var3] = -var8 * 8;
					} else {
						Tiles.Tiles_heights[var1][var2][var3] = Tiles.Tiles_heights[var1 - 1][var2][var3] - var8 * 8;
					}
					break;
				}

				if (var7 <= 49) {
					Tiles.field485[var1][var2][var3] = var0.readByte();
					Tiles.field482[var1][var2][var3] = (byte)((var7 - 2) / 4);
					Tiles.field483[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
				} else if (var7 <= 81) {
					Tiles.Tiles_renderFlags[var1][var2][var3] = (byte)(var7 - 49);
				} else {
					SoundSystem.field1414[var1][var2][var3] = (byte)(var7 - 81);
				}
			}
		} else {
			while (true) {
				var7 = var0.readUnsignedByte();
				if (var7 == 0) {
					break;
				}

				if (var7 == 1) {
					var0.readUnsignedByte();
					break;
				}

				if (var7 <= 49) {
					var0.readUnsignedByte();
				}
			}
		}

	}
}
