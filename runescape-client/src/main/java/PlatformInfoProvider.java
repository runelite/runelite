import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lb")
@Implements("PlatformInfoProvider")
public interface PlatformInfoProvider {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Lla;",
		garbageValue = "-2012824793"
	)
	@Export("get")
	PlatformInfo get();
}
