import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("km")
@Implements("DefaultsGroup")
public class DefaultsGroup {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lkm;"
	)
	static final DefaultsGroup field3785;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1787952601
	)
	@Export("group")
	final int group;

	static {
		field3785 = new DefaultsGroup(3);
	}

	DefaultsGroup(int var1) {
		this.group = var1;
	}
}
