import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ed")
@Implements("Wrapper")
public abstract class Wrapper extends DualNode {
	@ObfuscatedName("j")
	@Export("size")
	final int size;

	Wrapper(int var1) {
		this.size = var1;
	}

	@ObfuscatedName("s")
	@Export("get")
	abstract Object get();

	@ObfuscatedName("j")
	@Export("isSoft")
	abstract boolean isSoft();
}
