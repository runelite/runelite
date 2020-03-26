import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fw")
@Implements("Wrapper")
public abstract class Wrapper extends DualNode {
	@ObfuscatedName("m")
	@Export("size")
	final int size;

	Wrapper(int var1) {
		this.size = var1;
	}

	@ObfuscatedName("x")
	@Export("get")
	abstract Object get();

	@ObfuscatedName("m")
	@Export("isSoft")
	abstract boolean isSoft();
}
