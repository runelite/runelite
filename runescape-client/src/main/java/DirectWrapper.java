import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ei")
@Implements("DirectWrapper")
public class DirectWrapper extends Wrapper {
	@ObfuscatedName("c")
	@Export("obj")
	Object obj;

	DirectWrapper(Object var1, int var2) {
		super(var2);
		this.obj = var1;
	}

	@ObfuscatedName("c")
	@Export("get")
	Object get() {
		return this.obj;
	}

	@ObfuscatedName("x")
	@Export("isSoft")
	boolean isSoft() {
		return false;
	}
}
