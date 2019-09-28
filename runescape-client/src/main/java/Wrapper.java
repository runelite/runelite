import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ec")
@Implements("Wrapper")
public abstract class Wrapper extends DualNode {
	@ObfuscatedName("n")
	@Export("size")
	final int size;

	Wrapper(int var1) {
		this.size = var1;
	}

	@ObfuscatedName("z")
	@Export("get")
	abstract Object get();

	@ObfuscatedName("n")
	@Export("isSoft")
	abstract boolean isSoft();
}
