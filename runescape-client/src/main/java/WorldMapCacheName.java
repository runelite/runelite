import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
@Implements("WorldMapCacheName")
public class WorldMapCacheName {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Laz;"
	)
	public static final WorldMapCacheName field339;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Laz;"
	)
	public static final WorldMapCacheName field340;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Laz;"
	)
	public static final WorldMapCacheName field341;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Laz;"
	)
	static final WorldMapCacheName field345;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Laz;"
	)
	public static final WorldMapCacheName field343;
	@ObfuscatedName("aq")
	@Export("null_string")
	protected static String null_string;
	@ObfuscatedName("v")
	@Export("name")
	public final String name;

	static {
		field339 = new WorldMapCacheName("details");
		field340 = new WorldMapCacheName("compositemap");
		field341 = new WorldMapCacheName("compositetexture");
		field345 = new WorldMapCacheName("area");
		field343 = new WorldMapCacheName("labels");
	}

	WorldMapCacheName(String var1) {
		this.name = var1;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;B)[B",
		garbageValue = "-93"
	)
	public static byte[] method715(CharSequence var0) {
		int var1 = var0.length();
		byte[] var2 = new byte[var1];

		for (int var3 = 0; var3 < var1; ++var3) {
			char var4 = var0.charAt(var3);
			if (var4 > 0 && var4 < 128 || var4 >= 160 && var4 <= 255) {
				var2[var3] = (byte)var4;
			} else if (var4 == 8364) {
				var2[var3] = -128;
			} else if (var4 == 8218) {
				var2[var3] = -126;
			} else if (var4 == 402) {
				var2[var3] = -125;
			} else if (var4 == 8222) {
				var2[var3] = -124;
			} else if (var4 == 8230) {
				var2[var3] = -123;
			} else if (var4 == 8224) {
				var2[var3] = -122;
			} else if (var4 == 8225) {
				var2[var3] = -121;
			} else if (var4 == 710) {
				var2[var3] = -120;
			} else if (var4 == 8240) {
				var2[var3] = -119;
			} else if (var4 == 352) {
				var2[var3] = -118;
			} else if (var4 == 8249) {
				var2[var3] = -117;
			} else if (var4 == 338) {
				var2[var3] = -116;
			} else if (var4 == 381) {
				var2[var3] = -114;
			} else if (var4 == 8216) {
				var2[var3] = -111;
			} else if (var4 == 8217) {
				var2[var3] = -110;
			} else if (var4 == 8220) {
				var2[var3] = -109;
			} else if (var4 == 8221) {
				var2[var3] = -108;
			} else if (var4 == 8226) {
				var2[var3] = -107;
			} else if (var4 == 8211) {
				var2[var3] = -106;
			} else if (var4 == 8212) {
				var2[var3] = -105;
			} else if (var4 == 732) {
				var2[var3] = -104;
			} else if (var4 == 8482) {
				var2[var3] = -103;
			} else if (var4 == 353) {
				var2[var3] = -102;
			} else if (var4 == 8250) {
				var2[var3] = -101;
			} else if (var4 == 339) {
				var2[var3] = -100;
			} else if (var4 == 382) {
				var2[var3] = -98;
			} else if (var4 == 376) {
				var2[var3] = -97;
			} else {
				var2[var3] = 63;
			}
		}

		return var2;
	}

	@ObfuscatedName("gh")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2140521670"
	)
	static void method716() {
		if (Client.combatTargetPlayerIndex >= 0 && Client.players[Client.combatTargetPlayerIndex] != null) {
			class22.addPlayerToScene(Client.players[Client.combatTargetPlayerIndex], false);
		}

	}
}
