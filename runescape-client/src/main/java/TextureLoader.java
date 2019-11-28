import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
@Implements("TextureLoader")
public interface TextureLoader {
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IB)[I",
		garbageValue = "-64"
	)
	@Export("getTexturePixels")
	int[] getTexturePixels(int var1);

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "298398688"
	)
	@Export("getAverageTextureRGB")
	int getAverageTextureRGB(int var1);

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "561655524"
	)
	boolean vmethod3330(int var1);

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-959544558"
	)
	@Export("isLowDetail")
	boolean isLowDetail(int var1);
}
