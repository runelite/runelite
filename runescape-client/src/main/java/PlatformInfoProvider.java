import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ly")
@Implements("PlatformInfoProvider")
public interface PlatformInfoProvider {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Llt;",
		garbageValue = "2006662723"
	)
	@Export("get")
	PlatformInfo get();
}
