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
	@ObfuscatedName("co")
	@ObfuscatedGetter(
		intValue = 749425319
	)
	public static int field1338;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1523966437
	)
	@Export("id")
	int id;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 970491183
	)
	@Export("size")
	int size;
	@ObfuscatedName("e")
	@Export("operations")
	int[] operations;
	@ObfuscatedName("p")
	@Export("creationErrors")
	int[] creationErrors;
	@ObfuscatedName("k")
	@Export("fields")
	Field[] fields;
	@ObfuscatedName("l")
	@Export("intReplaceValues")
	int[] intReplaceValues;
	@ObfuscatedName("b")
	@Export("methods")
	Method[] methods;
	@ObfuscatedName("i")
	@Export("arguments")
	byte[][][] arguments;

	ReflectionCheck() {
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2118101811"
	)
	@Export("savePreferences")
	static void savePreferences() {
		AccessFile var0 = null;

		try {
			var0 = WorldMapIcon_0.getPreferencesFile("", WorldMapRegion.field248.name, true);
			Buffer var1 = WorldMapLabelSize.clientPreferences.toBuffer();
			var0.write(var1.array, 0, var1.offset);
		} catch (Exception var3) {
		}

		try {
			if (var0 != null) {
				var0.closeSync(true);
			}
		} catch (Exception var2) {
		}

	}
}
