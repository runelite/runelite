import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kl")
@Implements("PrivateChatMode")
public class PrivateChatMode
{
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lkl;"
	)
	static final PrivateChatMode field3818;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lkl;"
	)
	public static final PrivateChatMode field3816;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lkl;"
	)
	static final PrivateChatMode field3817;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 721881779
	)
	public final int field3815;

	static {
		field3818 = new PrivateChatMode(0);
		field3816 = new PrivateChatMode(1);
		field3817 = new PrivateChatMode(2);
	}

	PrivateChatMode(int var1) {
		this.field3815 = var1;
	}
}
