import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
@Implements("PcmStreamMixerListener")
public abstract class PcmStreamMixerListener extends Node {
	@ObfuscatedName("f")
	int field1410;

	@ObfuscatedName("f")
	@Export("remove2")
	abstract void remove2();

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lcy;)I"
	)
	@Export("update")
	abstract int update();
}
