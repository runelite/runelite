import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
@Implements("DevicePcmPlayerProvider")
public class DevicePcmPlayerProvider implements class99 {
	@ObfuscatedName("pf")
	@ObfuscatedSignature(
		signature = "Ljx;"
	)
	@Export("clanChat")
	static ClanChat clanChat;
	@ObfuscatedName("qn")
	@ObfuscatedGetter(
		intValue = 490221952
	)
	static int field412;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		longValue = 95792887242414313L
	)
	static long field416;
	@ObfuscatedName("ci")
	@Export("mouseCam")
	static boolean mouseCam;

	DevicePcmPlayerProvider() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)Ldn;",
		garbageValue = "1"
	)
	@Export("player")
	public PcmPlayer player() {
		return new DevicePcmPlayer();
	}

	@ObfuscatedName("kn")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-5"
	)
	static void method805() {
		Client.packetWriter.method2219(Archive.method4265(ClientPacket.field2240, Client.packetWriter.isaacCipher));
		Client.oculusOrbState = 0;
	}
}
