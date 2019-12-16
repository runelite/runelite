import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ly")
@Implements("PlatformInfoProvider")
public interface PlatformInfoProvider {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)Llx;",
		garbageValue = "-83"
	)
	@Export("get")
	PlatformInfo get();
}
