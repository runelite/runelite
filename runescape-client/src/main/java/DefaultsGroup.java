import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lf")
@Implements("DefaultsGroup")
public class DefaultsGroup {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Llf;"
	)
	static final DefaultsGroup field3811;
	@ObfuscatedName("z")
	@Export("SpriteBuffer_spritePalette")
	static int[] SpriteBuffer_spritePalette;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1057296275
	)
	@Export("group")
	final int group;

	static {
		field3811 = new DefaultsGroup(3);
	}

	DefaultsGroup(int var1) {
		this.group = var1;
	}
}
