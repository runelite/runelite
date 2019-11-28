import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kd")
@Implements("DefaultsGroup")
public class DefaultsGroup {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lkd;"
	)
	static final DefaultsGroup field3797;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -757733349
	)
	@Export("group")
	final int group;

	static {
		field3797 = new DefaultsGroup(3);
	}

	DefaultsGroup(int var1) {
		this.group = var1;
	}
}
