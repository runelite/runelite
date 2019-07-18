import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
@Implements("TextureLoader")
public interface TextureLoader {
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II)[I",
		garbageValue = "726289343"
	)
	@Export("load")
	int[] load(int var1);

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "1833085397"
	)
	@Export("getAverageTextureRGB")
	int getAverageTextureRGB(int var1);

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "100"
	)
	boolean vmethod3278(int var1);

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "0"
	)
	@Export("isLowDetail")
	boolean isLowDetail(int var1);
}
