import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
@Implements("LoginPacket")
public class LoginPacket implements class181 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lgz;"
	)
	public static final LoginPacket field2291;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lgz;"
	)
	static final LoginPacket field2288;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lgz;"
	)
	public static final LoginPacket field2289;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lgz;"
	)
	public static final LoginPacket field2290;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lgz;"
	)
	static final LoginPacket field2295;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "[Lgz;"
	)
	@Export("LoginPacket_indexedValues")
	static final LoginPacket[] LoginPacket_indexedValues;
	@ObfuscatedName("ef")
	@ObfuscatedGetter(
		intValue = 922550263
	)
	@Export("port3")
	static int port3;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1283459325
	)
	@Export("id")
	public final int id;

	static {
		field2291 = new LoginPacket(14, 0);
		field2288 = new LoginPacket(15, 4);
		field2289 = new LoginPacket(16, -2);
		field2290 = new LoginPacket(18, -2);
		field2295 = new LoginPacket(27, 0);
		LoginPacket_indexedValues = new LoginPacket[32];
		LoginPacket[] var0 = class13.method139();

		for (int var1 = 0; var1 < var0.length; ++var1) {
			LoginPacket_indexedValues[var0[var1].id] = var0[var1];
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
