import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("ReflectionCheck")
public class ReflectionCheck extends Node {
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 200973425
	)
	@Export("id")
	int id;
	@ObfuscatedName("f")
	@Export("intReplaceValues")
	int[] intReplaceValues;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 648866297
	)
	@Export("size")
	int size;
	@ObfuscatedName("g")
	@Export("operations")
	int[] operations;
	@ObfuscatedName("z")
	@Export("creationErrors")
	int[] creationErrors;
	@ObfuscatedName("p")
	@Export("fields")
	Field[] fields;
	@ObfuscatedName("h")
	@Export("methods")
	Method[] methods;
	@ObfuscatedName("y")
	@Export("arguments")
	byte[][][] arguments;

	ReflectionCheck() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIIIB)V",
		garbageValue = "-15"
	)
	static final void method2316(int var0, int var1, int var2, int var3) {
		for (int var4 = var1; var4 <= var3 + var1; ++var4) {
			for (int var5 = var0; var5 <= var0 + var2; ++var5) {
				if (var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
					class51.field423[0][var5][var4] = 127;
					if (var0 == var5 && var5 > 0) {
						Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 - 1][var4];
					}

					if (var5 == var0 + var2 && var5 < 103) {
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
}
