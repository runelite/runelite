import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("PcmPlayerProvider")
public interface PcmPlayerProvider {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Ldv;",
		garbageValue = "-79742550"
	)
	@Export("player")
	PcmPlayer player();
}
