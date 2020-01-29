import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
@Implements("AbstractByteArrayCopier")
public abstract class AbstractByteArrayCopier {
	@ObfuscatedName("se")
	@ObfuscatedGetter(
		intValue = -1844063971
	)
	@Export("foundItemIndex")
	static int foundItemIndex;

	AbstractByteArrayCopier() {
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)[B",
		garbageValue = "-571467457"
	)
	@Export("get")
	public abstract byte[] get();

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "([BI)V",
		garbageValue = "1471312739"
	)
	@Export("set")
	public abstract void set(byte[] var1);
}
