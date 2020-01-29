import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
@Implements("TextureLoader")
public interface TextureLoader {
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(II)[I",
		garbageValue = "1435702999"
	)
	@Export("getTexturePixels")
	int[] getTexturePixels(int var1);

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "16615935"
	)
	@Export("getAverageTextureRGB")
	int getAverageTextureRGB(int var1);

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "1"
	)
	boolean vmethod3347(int var1);

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "2100936507"
	)
	@Export("isLowDetail")
	boolean isLowDetail(int var1);
}
