import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ka")
@Implements("DefaultsGroup")
public class DefaultsGroup {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lka;"
	)
	static final DefaultsGroup field3794;
	@ObfuscatedName("gs")
	@ObfuscatedSignature(
		signature = "[Lls;"
	)
	@Export("crossSprites")
	static Sprite[] crossSprites;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 879655985
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
