import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("PcmPlayerProvider")
public interface PcmPlayerProvider {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Ldh;",
		garbageValue = "-131796443"
	)
	@Export("player")
	PcmPlayer player();
}
