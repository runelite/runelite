import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kc")
@Implements("PrivateChatMode")
public class PrivateChatMode {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lkc;"
	)
	static final PrivateChatMode field3790;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lkc;"
	)
	public static final PrivateChatMode field3791;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lkc;"
	)
	static final PrivateChatMode field3792;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1358406113
	)
	public final int field3793;

	static {
		field3790 = new PrivateChatMode(0);
		field3791 = new PrivateChatMode(1);
		field3792 = new PrivateChatMode(2);
	}

	PrivateChatMode(int var1) {
		this.field3793 = var1;
	}
}
