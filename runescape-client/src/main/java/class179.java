import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class179 {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lfi;"
	)
	public static final class179 field2291;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lfi;"
	)
	public static final class179 field2290;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lfi;"
	)
	public static final class179 field2292;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lfi;"
	)
	public static final class179 field2289;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lfi;"
	)
	public static final class179 field2293;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lfi;"
	)
	public static final class179 field2294;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lfi;"
	)
	public static final class179 field2295;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lfi;"
	)
	public static final class179 field2296;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lfi;"
	)
	public static final class179 field2297;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lfi;"
	)
	public static final class179 field2298;

	static {
		field2291 = new class179(3);
		field2290 = new class179(6);
		field2292 = new class179(4);
		field2289 = new class179(15);
		field2293 = new class179(4);
		field2294 = new class179(7);
		field2295 = new class179(5);
		field2296 = new class179(2);
		field2297 = new class179(5);
		field2298 = new class179(14);
	}

	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "3"
	)
	class179(int var1) {
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "-60"
	)
	public static int method3580(int var0, int var1) {
		int var2;
		if (var1 > var0) {
			var2 = var0;
			var0 = var1;
			var1 = var2;
		}

		while (var1 != 0) {
			var2 = var0 % var1;
			var0 = var1;
			var1 = var2;
		}

		return var0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "-1453878926"
	)
	public static boolean method3581(char var0) {
		if (var0 >= ' ' && var0 < 127 || var0 > 127 && var0 < 160 || var0 > 160 && var0 <= 255) {
			return true;
		} else {
			if (var0 != 0) {
				char[] var1 = class287.cp1252AsciiExtension;

				for (int var2 = 0; var2 < var1.length; ++var2) {
					char var3 = var1[var2];
					if (var0 == var3) {
						return true;
					}
				}
			}

			return false;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-340612518"
	)
	public static void method3579() {
		if (KeyHandler.KeyHandler_instance != null) {
			synchronized(KeyHandler.KeyHandler_instance) {
				KeyHandler.KeyHandler_instance = null;
			}
		}

	}
}
