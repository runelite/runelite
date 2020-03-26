import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mm")
@Implements("PlatformInfoProvider")
public interface PlatformInfoProvider {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)Lmq;",
		garbageValue = "1"
	)
	@Export("get")
	PlatformInfo get();
}
