import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
@Implements("PcmStreamMixerListener")
public abstract class PcmStreamMixerListener extends Node {
	@ObfuscatedName("x")
	int field1466;

	@ObfuscatedName("x")
	@Export("remove2")
	abstract void remove2();

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Ldz;)I"
	)
	@Export("update")
	abstract int update();
}
