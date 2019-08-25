import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lu")
@Implements("PlatformInfoProvider")
public interface PlatformInfoProvider {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)Llo;",
		garbageValue = "1619784372"
	)
	@Export("get")
	PlatformInfo get();
}
