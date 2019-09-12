import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ke")
@Implements("DefaultsGroup")
public class DefaultsGroup {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lke;"
	)
	static final DefaultsGroup field3792;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1766167295
	)
	@Export("group")
	final int group;

	static {
		field3792 = new DefaultsGroup(3);
	}

	DefaultsGroup(int var1) {
		this.group = var1;
	}
}
