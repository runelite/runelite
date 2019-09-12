import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kc")
@Implements("PrivateChatMode")
public class PrivateChatMode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lkc;"
	)
	static final PrivateChatMode field3789;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lkc;"
	)
	public static final PrivateChatMode field3786;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lkc;"
	)
	static final PrivateChatMode field3788;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -2108036815
	)
	public final int field3787;

	static {
		field3789 = new PrivateChatMode(0);
		field3786 = new PrivateChatMode(1);
		field3788 = new PrivateChatMode(2);
	}

	PrivateChatMode(int var1) {
		this.field3787 = var1;
	}
}
