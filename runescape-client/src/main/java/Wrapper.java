import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ey")
@Implements("Wrapper")
public abstract class Wrapper extends DualNode {
	@ObfuscatedName("x")
	@Export("size")
	final int size;

	Wrapper(int var1) {
		this.size = var1;
	}

	@ObfuscatedName("c")
	@Export("get")
	abstract Object get();

	@ObfuscatedName("x")
	@Export("isSoft")
	abstract boolean isSoft();
}
