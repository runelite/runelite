import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
@Implements("AbstractByteArrayCopier")
public abstract class AbstractByteArrayCopier {
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	@Export("leftTitleSprite")
	static Sprite leftTitleSprite;

	AbstractByteArrayCopier() {
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(S)[B",
		garbageValue = "18982"
	)
	@Export("get")
	abstract byte[] get();

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "([BI)V",
		garbageValue = "-1436271820"
	)
	@Export("set")
	public abstract void set(byte[] var1);

	@ObfuscatedName("kg")
	@ObfuscatedSignature(
		signature = "(Lhl;B)Z",
		garbageValue = "-78"
	)
	@Export("isComponentHidden")
	static boolean isComponentHidden(Widget var0) {
		return var0.isHidden;
	}
}
