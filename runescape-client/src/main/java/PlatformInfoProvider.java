import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lh")
@Implements("PlatformInfoProvider")
public interface PlatformInfoProvider {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)Llj;",
		garbageValue = "-40"
	)
	@Export("get")
	PlatformInfo get();
}
