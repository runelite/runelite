import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
@Implements("TextureLoader")
public interface TextureLoader {
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(II)[I",
		garbageValue = "-1956127937"
	)
	@Export("getTexturePixels")
	int[] getTexturePixels(int var1);

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "-57"
	)
	@Export("getAverageTextureRGB")
	int getAverageTextureRGB(int var1);

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1875777180"
	)
	boolean vmethod3403(int var1);

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-1105399782"
	)
	@Export("isLowDetail")
	boolean isLowDetail(int var1);
}
