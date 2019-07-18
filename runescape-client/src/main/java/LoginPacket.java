import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
@Implements("LoginPacket")
public class LoginPacket implements class181 {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lgh;"
	)
	public static final LoginPacket field2306;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lgh;"
	)
	static final LoginPacket field2307;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lgh;"
	)
	public static final LoginPacket field2308;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lgh;"
	)
	public static final LoginPacket field2311;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lgh;"
	)
	static final LoginPacket field2310;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "[Lgh;"
	)
	@Export("LoginPacket_indexedValues")
	static final LoginPacket[] LoginPacket_indexedValues;
	@ObfuscatedName("a")
	static String[] field2309;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1829786709
	)
	@Export("id")
	public final int id;

	static {
		field2306 = new LoginPacket(14, 0);
		field2307 = new LoginPacket(15, 4);
		field2308 = new LoginPacket(16, -2);
		field2311 = new LoginPacket(18, -2);
		field2310 = new LoginPacket(27, 0);
		LoginPacket_indexedValues = new LoginPacket[32];
		LoginPacket[] var0 = new LoginPacket[]{field2310, field2306, field2308, field2311, field2307};
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lbb;B)V",
		garbageValue = "-119"
	)
	@Export("runScriptEvent")
	public static void runScriptEvent(ScriptEvent var0) {
		class96.runScript(var0, 500000);
	}
}
