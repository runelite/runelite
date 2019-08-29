import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("ReflectionCheck")
public class ReflectionCheck extends Node {
	@ObfuscatedName("cm")
	@ObfuscatedGetter(
		intValue = -391486769
	)
	public static int field1307;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1136310453
	)
	@Export("id")
	int id;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 563211099
	)
	@Export("size")
	int size;
	@ObfuscatedName("i")
	@Export("operations")
	int[] operations;
	@ObfuscatedName("k")
	@Export("creationErrors")
	int[] creationErrors;
	@ObfuscatedName("u")
	@Export("fields")
	Field[] fields;
	@ObfuscatedName("n")
	@Export("intReplaceValues")
	int[] intReplaceValues;
	@ObfuscatedName("t")
	@Export("methods")
	Method[] methods;
	@ObfuscatedName("q")
	@Export("arguments")
	byte[][][] arguments;

	ReflectionCheck() {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IIIB)I",
		garbageValue = "4"
	)
	public static int method2213(int var0, int var1, int var2) {
		var2 &= 3;
		if (var2 == 0) {
			return var0;
		} else if (var2 == 1) {
			return var1;
		} else {
			return var2 == 2 ? 7 - var0 : 7 - var1;
		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-125143607"
	)
	public static int method2212(int var0, int var1) {
		return (var0 << 8) + var1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)I",
		garbageValue = "482373296"
	)
	@Export("hashString")
	public static int hashString(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			var2 = (var2 << 5) - var2 + class14.charToByteCp1252(var0.charAt(var3));
		}

		return var2;
	}
}
