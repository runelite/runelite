import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class30 {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lap;"
	)
	static final class30 field253;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lap;"
	)
	static final class30 field250;
	@ObfuscatedName("fk")
	@ObfuscatedSignature(
		signature = "Lky;"
	)
	static AbstractSocket field251;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -2108473881
	)
	@Export("value")
	final int value;

	static {
		field253 = new class30(0);
		field250 = new class30(1);
	}

	class30(int var1) {
		this.value = var1;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)J",
		garbageValue = "1399044967"
	)
	@Export("currentTimeMillis")
	public static final synchronized long currentTimeMillis() {
		long var0 = System.currentTimeMillis();
		if (var0 < class296.field3688) {
			class296.field3689 += class296.field3688 - var0;
		}

		class296.field3688 = var0;
		return var0 + class296.field3689;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-476922485"
	)
	public static int method563(int var0, int var1) {
		int var2;
		for (var2 = 1; var1 > 1; var1 >>= 1) {
			if ((var1 & 1) != 0) {
				var2 = var0 * var2;
			}

			var0 *= var0;
		}

		if (var1 == 1) {
			return var0 * var2;
		} else {
			return var2;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(II)[B",
		garbageValue = "-2057426461"
	)
	@Export("ByteArrayPool_getArray")
	public static synchronized byte[] ByteArrayPool_getArray(int var0) {
		return ByteArrayPool.ByteArrayPool_getArrayBool(var0, false);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIIIB)V",
		garbageValue = "44"
	)
	static final void method561(int var0, int var1, int var2, int var3) {
		for (int var4 = var1; var4 <= var3 + var1; ++var4) {
			for (int var5 = var0; var5 <= var0 + var2; ++var5) {
				if (var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
					Tiles.field486[0][var5][var4] = 127;
					if (var0 == var5 && var5 > 0) {
						Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 - 1][var4];
					}

					if (var0 + var2 == var5 && var5 < 103) {
						Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 + 1][var4];
					}

					if (var4 == var1 && var4 > 0) {
						Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 - 1];
					}

					if (var4 == var3 + var1 && var4 < 103) {
						Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 + 1];
					}
				}
			}
		}

	}

	@ObfuscatedName("fo")
	@ObfuscatedSignature(
		signature = "(Lix;IIII)V",
		garbageValue = "1243298159"
	)
	@Export("addSequenceSoundEffect")
	static void addSequenceSoundEffect(SequenceDefinition var0, int var1, int var2, int var3) {
		if (Client.soundEffectCount < 50 && Client.field868 != 0) {
			if (var0.soundEffects != null && var1 < var0.soundEffects.length) {
				int var4 = var0.soundEffects[var1];
				if (var4 != 0) {
					int var5 = var4 >> 8;
					int var6 = var4 >> 4 & 7;
					int var7 = var4 & 15;
					Client.soundEffectIds[Client.soundEffectCount] = var5;
					Client.queuedSoundEffectLoops[Client.soundEffectCount] = var6;
					Client.queuedSoundEffectDelays[Client.soundEffectCount] = 0;
					Client.soundEffects[Client.soundEffectCount] = null;
					int var8 = (var2 - 64) / 128;
					int var9 = (var3 - 64) / 128;
					Client.soundLocations[Client.soundEffectCount] = var7 + (var9 << 8) + (var8 << 16);
					++Client.soundEffectCount;
				}
			}
		}
	}

	@ObfuscatedName("iw")
	@ObfuscatedSignature(
		signature = "(Lho;III)V",
		garbageValue = "-1445345740"
	)
	@Export("alignWidgetPosition")
	static void alignWidgetPosition(Widget var0, int var1, int var2) {
		if (var0.xAlignment == 0) {
			var0.x = var0.rawX;
		} else if (var0.xAlignment == 1) {
			var0.x = var0.rawX + (var1 - var0.width) / 2;
		} else if (var0.xAlignment == 2) {
			var0.x = var1 - var0.width - var0.rawX;
		} else if (var0.xAlignment == 3) {
			var0.x = var0.rawX * var1 >> 14;
		} else if (var0.xAlignment == 4) {
			var0.x = (var1 - var0.width) / 2 + (var0.rawX * var1 >> 14);
		} else {
			var0.x = var1 - var0.width - (var0.rawX * var1 >> 14);
		}

		if (var0.yAlignment == 0) {
			var0.y = var0.rawY;
		} else if (var0.yAlignment == 1) {
			var0.y = (var2 - var0.height) / 2 + var0.rawY;
		} else if (var0.yAlignment == 2) {
			var0.y = var2 - var0.height - var0.rawY;
		} else if (var0.yAlignment == 3) {
			var0.y = var2 * var0.rawY >> 14;
		} else if (var0.yAlignment == 4) {
			var0.y = (var2 * var0.rawY >> 14) + (var2 - var0.height) / 2;
		} else {
			var0.y = var2 - var0.height - (var2 * var0.rawY >> 14);
		}

	}
}
