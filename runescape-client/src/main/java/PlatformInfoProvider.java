import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lb")
@Implements("PlatformInfoProvider")
public interface PlatformInfoProvider {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)Llk;",
		garbageValue = "-1540970685"
	)
	@Export("get")
	PlatformInfo get();
}
