import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
@Implements("LoginPacket")
public class LoginPacket implements class181 {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lgs;"
	)
	public static final LoginPacket field2283;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lgs;"
	)
	static final LoginPacket field2284;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lgs;"
	)
	public static final LoginPacket field2285;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lgs;"
	)
	public static final LoginPacket field2286;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lgs;"
	)
	static final LoginPacket field2287;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "[Lgs;"
	)
	@Export("LoginPacket_indexedValues")
	static final LoginPacket[] LoginPacket_indexedValues;
	@ObfuscatedName("ds")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive1")
	static Archive archive1;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -975966301
	)
	@Export("id")
	public final int id;

	static {
		field2283 = new LoginPacket(14, 0);
		field2284 = new LoginPacket(15, 4);
		field2285 = new LoginPacket(16, -2);
		field2286 = new LoginPacket(18, -2);
		field2287 = new LoginPacket(27, 0);
		LoginPacket_indexedValues = new LoginPacket[32];
		LoginPacket[] var0 = GrandExchangeOfferWorldComparator.method105();

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

	@ObfuscatedName("lb")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "19"
	)
	static void method3767() {
		Client.packetWriter.addNode(SoundSystem.getPacketBufferNode(ClientPacket.field2210, Client.packetWriter.isaacCipher));
		Client.oculusOrbState = 0;
	}
}
