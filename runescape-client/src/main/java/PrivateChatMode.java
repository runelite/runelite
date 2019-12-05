import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kc")
@Implements("PrivateChatMode")
public class PrivateChatMode {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lkc;"
	)
	static final PrivateChatMode field3794;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lkc;"
	)
	public static final PrivateChatMode field3792;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lkc;"
	)
	static final PrivateChatMode field3793;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 749453675
	)
	public final int field3795;

	static {
		field3794 = new PrivateChatMode(0);
		field3792 = new PrivateChatMode(1);
		field3793 = new PrivateChatMode(2);
	}

	PrivateChatMode(int var1) {
		this.field3795 = var1;
	}
}
