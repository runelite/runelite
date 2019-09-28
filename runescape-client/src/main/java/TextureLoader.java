import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
@Implements("TextureLoader")
public interface TextureLoader {
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IB)[I",
		garbageValue = "2"
	)
	@Export("getTexturePixels")
	int[] getTexturePixels(int var1);

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "1942090144"
	)
	@Export("getAverageTextureRGB")
	int getAverageTextureRGB(int var1);

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1238853491"
	)
	boolean vmethod3236(int var1);

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-818075958"
	)
	@Export("isLowDetail")
	boolean isLowDetail(int var1);
}
