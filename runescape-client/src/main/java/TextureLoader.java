import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("TextureLoader")
public interface TextureLoader {
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)[I",
		garbageValue = "-1189972175"
	)
	@Export("getTexturePixels")
	int[] getTexturePixels(int var1);

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "168409140"
	)
	@Export("getAverageTextureRGB")
	int getAverageTextureRGB(int var1);

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1740870730"
	)
	boolean vmethod3240(int var1);

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-1205212261"
	)
	@Export("isLowDetail")
	boolean isLowDetail(int var1);
}
