import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kk")
@Implements("PrivateChatMode")
public class PrivateChatMode {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lkk;"
	)
	static final PrivateChatMode field3793;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lkk;"
	)
	public static final PrivateChatMode field3788;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lkk;"
	)
	static final PrivateChatMode field3790;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -2070508513
	)
	public final int field3791;

	static {
		field3793 = new PrivateChatMode(0);
		field3788 = new PrivateChatMode(1);
		field3790 = new PrivateChatMode(2);
	}

	PrivateChatMode(int var1) {
		this.field3791 = var1;
	}
}
