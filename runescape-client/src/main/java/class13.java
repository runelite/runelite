import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public class class13 {
	@ObfuscatedName("dz")
	@ObfuscatedSignature(
		signature = "Lio;"
	)
	@Export("archive4")
	static Archive archive4;

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)[Lgz;",
		garbageValue = "519142630"
	)
	static LoginPacket[] method139() {
		return new LoginPacket[]{LoginPacket.field2290, LoginPacket.field2288, LoginPacket.field2289, LoginPacket.field2291, LoginPacket.field2295};
	}
}
