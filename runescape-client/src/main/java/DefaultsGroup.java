import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kp")
@Implements("DefaultsGroup")
public class DefaultsGroup {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lkp;"
	)
	static final DefaultsGroup field3794;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 779550305
	)
	@Export("group")
	final int group;

	static {
		field3794 = new DefaultsGroup(3);
	}

	DefaultsGroup(int var1) {
		this.group = var1;
	}
}
