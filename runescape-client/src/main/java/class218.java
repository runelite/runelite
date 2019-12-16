import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class218 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	@Export("options_buttons_0Sprite")
	static IndexedSprite options_buttons_0Sprite;

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(IB)[B",
		garbageValue = "1"
	)
	@Export("ByteArrayPool_getArray")
	public static synchronized byte[] ByteArrayPool_getArray(int var0) {
		return ByteArrayPool.ByteArrayPool_getArrayBool(var0, false);
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "450645435"
	)
	static final int method4074() {
		return ViewportMouse.ViewportMouse_x;
	}
}
