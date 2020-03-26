import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("TextureLoader")
public interface TextureLoader {
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)[I",
		garbageValue = "-1464136827"
	)
	@Export("getTexturePixels")
	int[] getTexturePixels(int var1);

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IS)I",
		garbageValue = "-26354"
	)
	@Export("getAverageTextureRGB")
	int getAverageTextureRGB(int var1);

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "19136776"
	)
	boolean vmethod3388(int var1);

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "649013843"
	)
	@Export("isLowDetail")
	boolean isLowDetail(int var1);
}
