import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eo")
@Implements("Wrapper")
public abstract class Wrapper extends DualNode {
	@ObfuscatedName("t")
	@Export("size")
	final int size;

	Wrapper(int var1) {
		this.size = var1;
	}

	@ObfuscatedName("a")
	@Export("get")
	abstract Object get();

	@ObfuscatedName("t")
	@Export("isSoft")
	abstract boolean isSoft();
}
