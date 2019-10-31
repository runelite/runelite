import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kt")
@Implements("PrivateChatMode")
public class PrivateChatMode {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lkt;"
	)
	static final PrivateChatMode field3778;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lkt;"
	)
	public static final PrivateChatMode field3779;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lkt;"
	)
	static final PrivateChatMode field3782;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1472825575
	)
	public final int field3781;

	static {
		field3778 = new PrivateChatMode(0);
		field3779 = new PrivateChatMode(1);
		field3782 = new PrivateChatMode(2);
	}

	PrivateChatMode(int var1) {
		this.field3781 = var1;
	}
}
