import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class16 {
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -2115324593
	)
	public static int field98;
	@ObfuscatedName("fk")
	@ObfuscatedGetter(
		intValue = -713701469
	)
	static int field101;

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)[Lge;",
		garbageValue = "1297368600"
	)
	static LoginPacket[] method183() {
		return new LoginPacket[]{LoginPacket.field2291, LoginPacket.field2292, LoginPacket.field2289, LoginPacket.field2295, LoginPacket.field2293};
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lls;IIII)V",
		garbageValue = "-1463584611"
	)
	static void method181(Sprite var0, int var1, int var2, int var3) {
		WorldMapRegion.WorldMapRegion_cachedSprites.put(var0, ClientPacket.getWorldMapSpriteHash(var1, var2, var3), var0.pixels.length * 4);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "-1438659033"
	)
	@Export("colorStartTag")
	static String colorStartTag(int var0) {
		return "<col=" + Integer.toHexString(var0) + ">";
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IB)Lin;",
		garbageValue = "91"
	)
	public static VarpDefinition method180(int var0) {
		VarpDefinition var1 = (VarpDefinition)VarpDefinition.VarpDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = VarpDefinition.VarpDefinition_archive.takeFile(16, var0);
			var1 = new VarpDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			VarpDefinition.VarpDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}
