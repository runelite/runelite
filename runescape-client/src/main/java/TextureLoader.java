import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
@Implements("TextureLoader")
public interface TextureLoader {
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II)[I",
		garbageValue = "-414302740"
	)
	@Export("getTexturePixels")
	int[] getTexturePixels(int var1);

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "87"
	)
	@Export("getAverageTextureRGB")
	int getAverageTextureRGB(int var1);

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-39304153"
	)
	boolean vmethod3229(int var1);

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IS)Z",
		garbageValue = "17414"
	)
	@Export("isLowDetail")
	boolean isLowDetail(int var1);
}
