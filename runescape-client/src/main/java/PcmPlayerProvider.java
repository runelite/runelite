import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("PcmPlayerProvider")
public interface PcmPlayerProvider {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)Ldn;",
		garbageValue = "1"
	)
	@Export("player")
	PcmPlayer player();
}
