import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lw")
@Implements("PlatformInfoProvider")
public interface PlatformInfoProvider {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)Llx;",
		garbageValue = "-1719381077"
	)
	@Export("get")
	PlatformInfo get();
}
