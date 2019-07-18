import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
@Implements("PcmStreamMixerListener")
public abstract class PcmStreamMixerListener extends Node {
	@ObfuscatedName("q")
	int field1452;

	@ObfuscatedName("q")
	@Export("remove2")
	abstract void remove2();

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lcz;)I"
	)
	@Export("update")
	abstract int update();
}
