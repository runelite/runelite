import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
@Implements("PcmStreamMixerListener")
public abstract class PcmStreamMixerListener extends Node {
	@ObfuscatedName("s")
	int field1429;

	@ObfuscatedName("s")
	@Export("remove2")
	abstract void remove2();

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lcq;)I"
	)
	@Export("update")
	abstract int update();
}
