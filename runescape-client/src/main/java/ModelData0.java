import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
@Implements("ModelData0")
public class ModelData0 {
	ModelData0() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "-1209977249"
	)
	public static int method3322(int var0, int var1, int var2) {
		var2 &= 3;
		if (var2 == 0) {
			return var0;
		} else if (var2 == 1) {
			return var1;
		} else {
			return var2 == 2 ? 7 - var0 : 7 - var1;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-1996001757"
	)
	static final void method3323(String var0) {
		class60.method1188(var0 + " is already on your ignore list");
	}
}
