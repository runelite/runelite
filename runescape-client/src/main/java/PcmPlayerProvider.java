import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("PcmPlayerProvider")
public interface PcmPlayerProvider {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(S)Ldd;",
		garbageValue = "-22145"
	)
	@Export("player")
	PcmPlayer player();
}
