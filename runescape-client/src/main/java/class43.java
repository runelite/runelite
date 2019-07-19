import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public final class class43 {
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("SpotAnimationDefinition_modelArchive")
	public static AbstractArchive SpotAnimationDefinition_modelArchive;
	@ObfuscatedName("i")
	@Export("ByteArrayPool_altSizeArrayCounts")
	public static int[] ByteArrayPool_altSizeArrayCounts;
	@ObfuscatedName("ak")
	@Export("garbageCollector")
	static GarbageCollectorMXBean garbageCollector;
	@ObfuscatedName("dx")
	@ObfuscatedSignature(
		signature = "Liu;"
	)
	@Export("archive3")
	static Archive archive3;
	@ObfuscatedName("hj")
	@ObfuscatedGetter(
		intValue = 2040004627
	)
	@Export("cameraY")
	static int cameraY;

	@ObfuscatedName("l")
	public static int method770(long var0) {
		return (int)(var0 >>> 17 & 4294967295L);
	}
}
