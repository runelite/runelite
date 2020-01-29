import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
@Implements("PcmStreamMixerListener")
public abstract class PcmStreamMixerListener extends Node {
	@ObfuscatedName("c")
	int field1435;

	@ObfuscatedName("c")
	@Export("remove2")
	abstract void remove2();

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lch;)I"
	)
	@Export("update")
	abstract int update();
}
