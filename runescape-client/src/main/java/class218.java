import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
public class class218 {
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(CB)Z",
		garbageValue = "0"
	)
	public static boolean method4019(char var0) {
		if ((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
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
		} else {
			return true;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-617749686"
	)
	@Export("ViewportMouse_unpackX")
	public static int ViewportMouse_unpackX(int var0) {
		long var2 = ViewportMouse.ViewportMouse_entityTags[var0];
		int var1 = (int)(var2 >>> 0 & 127L);
		return var1;
	}
}
