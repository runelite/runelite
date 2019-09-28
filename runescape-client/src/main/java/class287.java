import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kk")
public class class287 {
	@ObfuscatedName("z")
	@Export("cp1252AsciiExtension")
	static final char[] cp1252AsciiExtension;
	@ObfuscatedName("q")
	static byte[][][] field3634;

	static {
		cp1252AsciiExtension = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(DDII)[D",
		garbageValue = "-1793531075"
	)
	public static double[] method5221(double var0, double var2, int var4) {
		int var5 = var4 * 2 + 1;
		double[] var6 = new double[var5];
		int var7 = -var4;

		for (int var8 = 0; var7 <= var4; ++var8) {
			var6[var8] = TaskHandler.method3429((double)var7, var0, var2);
			++var7;
		}

		return var6;
	}

	@ObfuscatedName("kf")
	@ObfuscatedSignature(
		signature = "(IIIZI)V",
		garbageValue = "326242369"
	)
	public static void method5220(int var0, int var1, int var2, boolean var3) {
		PacketBufferNode var4 = InterfaceParent.getPacketBufferNode(ClientPacket.field2191, Client.packetWriter.isaacCipher);
		var4.packetBuffer.method5461(var2);
		var4.packetBuffer.writeIntLE16(var3 ? Client.field718 : 0);
		var4.packetBuffer.writeShort(var1);
		var4.packetBuffer.writeShortLE(var0);
		Client.packetWriter.addNode(var4);
	}
}
