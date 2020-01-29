import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
@Implements("LoginPacket")
public class LoginPacket implements class181 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	public static final LoginPacket field2310;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	static final LoginPacket field2307;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	public static final LoginPacket field2308;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	public static final LoginPacket field2313;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	static final LoginPacket field2306;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "[Lge;"
	)
	@Export("LoginPacket_indexedValues")
	static final LoginPacket[] LoginPacket_indexedValues;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 707604483
	)
	@Export("id")
	public final int id;

	static {
		field2310 = new LoginPacket(14, 0);
		field2307 = new LoginPacket(15, 4);
		field2308 = new LoginPacket(16, -2);
		field2313 = new LoginPacket(18, -2);
		field2306 = new LoginPacket(27, 0);
		LoginPacket_indexedValues = new LoginPacket[32];
		LoginPacket[] var0 = new LoginPacket[]{field2310, field2306, field2308, field2313, field2307};
		LoginPacket[] var1 = var0;

		for (int var2 = 0; var2 < var1.length; ++var2) {
			LoginPacket_indexedValues[var1[var2].id] = var1[var2];
		}

	}

	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "0"
	)
	LoginPacket(int var1, int var2) {
		this.id = var1;
	}
}
