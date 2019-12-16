import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ff")
@Implements("Wrapper")
public abstract class Wrapper extends DualNode {
	@ObfuscatedName("i")
	@Export("size")
	final int size;

	Wrapper(int var1) {
		this.size = var1;
	}

	@ObfuscatedName("f")
	@Export("get")
	abstract Object get();

	@ObfuscatedName("i")
	@Export("isSoft")
	abstract boolean isSoft();
}
