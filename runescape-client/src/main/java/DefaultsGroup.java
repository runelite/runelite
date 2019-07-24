import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kt")
@Implements("DefaultsGroup")
public class DefaultsGroup {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lkt;"
	)
	static final DefaultsGroup field3821;
	@ObfuscatedName("go")
	@ObfuscatedGetter(
		intValue = -909445377
	)
	static int field3819;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1207021413
	)
	@Export("group")
	final int group;

	static {
		field3821 = new DefaultsGroup(3);
	}

	DefaultsGroup(int var1) {
		this.group = var1;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkf;B)Ljava/lang/String;",
		garbageValue = "39"
	)
	public static String method5898(Buffer var0) {
		return WorldMapIcon_0.method194(var0, 32767);
	}
}
