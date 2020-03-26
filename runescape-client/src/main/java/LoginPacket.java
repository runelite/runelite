import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
@Implements("LoginPacket")
public class LoginPacket implements class190 {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	public static final LoginPacket field2315;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	static final LoginPacket field2311;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	public static final LoginPacket field2317;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	public static final LoginPacket field2313;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	public static final LoginPacket field2314;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	static final LoginPacket field2319;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "[Lgb;"
	)
	static final LoginPacket[] LoginPacked_indexedValues;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lew;"
	)
	@Export("World_request")
	static UrlRequest World_request;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 774244909
	)
	@Export("id")
	public final int id;

	static {
		field2315 = new LoginPacket(14, 0);
		field2311 = new LoginPacket(15, 4);
		field2317 = new LoginPacket(16, -2);
		field2313 = new LoginPacket(18, -2);
		field2314 = new LoginPacket(19, -2);
		field2319 = new LoginPacket(27, 0);
		LoginPacked_indexedValues = new LoginPacket[32];
		LoginPacket[] var0 = class51.method895();

		for (int var1 = 0; var1 < var0.length; ++var1) {
			LoginPacked_indexedValues[var0[var1].id] = var0[var1];
		}

	}

	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "0"
	)
	LoginPacket(int var1, int var2) {
		this.id = var1;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1902674476"
	)
	static final void method3692() {
		GrandExchangeEvent.method165("Your friend list is full. Max of 200 for free users, and 400 for members");
	}
}
