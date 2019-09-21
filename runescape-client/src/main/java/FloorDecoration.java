import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
@Implements("FloorDecoration")
public final class FloorDecoration {
	@ObfuscatedName("fg")
	@ObfuscatedGetter(
		intValue = 2143903215
	)
	static int field1585;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1477946129
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -662619385
	)
	@Export("y")
	int y;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1897979537
	)
	@Export("x")
	int x;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("entity")
	public Entity entity;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		longValue = -6178260684418985297L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 944766785
	)
	@Export("flags")
	int flags;

	FloorDecoration() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "423054360"
	)
	static final void method2813(int var0, int var1, int var2, int var3) {
		for (int var4 = var1; var4 <= var3 + var1; ++var4) {
			for (int var5 = var0; var5 <= var0 + var2; ++var5) {
				if (var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
					Tiles.field473[0][var5][var4] = 127;
					if (var0 == var5 && var5 > 0) {
						Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 - 1][var4];
					}

					if (var5 == var0 + var2 && var5 < 103) {
						Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 + 1][var4];
					}

					if (var4 == var1 && var4 > 0) {
						Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 - 1];
					}

					if (var3 + var1 == var4 && var4 < 103) {
						Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 + 1];
					}
				}
			}
		}

	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "3"
	)
	public static void method2811() {
		try {
			JagexCache.JagexCache_dat2File.close();

			for (int var0 = 0; var0 < JagexCache.idxCount; ++var0) {
				DevicePcmPlayerProvider.JagexCache_idxFiles[var0].close();
			}

			JagexCache.JagexCache_idx255File.close();
			JagexCache.JagexCache_randomDat.close();
		} catch (Exception var2) {
		}

	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "119"
	)
	static final int method2812(int var0, int var1) {
		if (var0 == -2) {
			return 12345678;
		} else if (var0 == -1) {
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return var1;
		} else {
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return (var0 & 65408) + var1;
		}
	}

	@ObfuscatedName("hx")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "932065265"
	)
	@Export("Widget_runOnTargetLeave")
	static void Widget_runOnTargetLeave() {
		if (Client.isSpellSelected) {
			Widget var0 = class49.getWidgetChild(class83.selectedSpellWidget, Client.selectedSpellChildIndex);
			if (var0 != null && var0.onTargetLeave != null) {
				ScriptEvent var1 = new ScriptEvent();
				var1.widget = var0;
				var1.args = var0.onTargetLeave;
				SecureRandomFuture.runScriptEvent(var1);
			}

			Client.isSpellSelected = false;
			WorldMapID.invalidateWidget(var0);
		}
	}
}
