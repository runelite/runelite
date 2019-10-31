import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
@Implements("PcmStreamMixerListener")
public abstract class PcmStreamMixerListener extends Node {
	@ObfuscatedName("a")
	int field1420;

	@ObfuscatedName("a")
	@Export("remove2")
	abstract void remove2();

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lct;)I"
	)
	@Export("update")
	abstract int update();
}
