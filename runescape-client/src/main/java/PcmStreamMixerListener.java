import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
@Implements("PcmStreamMixerListener")
public abstract class PcmStreamMixerListener extends Node {
	@ObfuscatedName("z")
	int field1421;

	@ObfuscatedName("z")
	@Export("remove2")
	abstract void remove2();

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lca;)I"
	)
	@Export("update")
	abstract int update();
}
