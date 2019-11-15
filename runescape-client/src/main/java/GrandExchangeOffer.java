import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
	@ObfuscatedName("aq")
	@Export("fontHelvetica13")
	static java.awt.Font fontHelvetica13;
	@ObfuscatedName("go")
	@ObfuscatedGetter(
		intValue = 1997230309
	)
	static int field61;
	@ObfuscatedName("jo")
	@ObfuscatedSignature(
		signature = "Lhi;"
	)
	@Export("dragInventoryWidget")
	static Widget dragInventoryWidget;
	@ObfuscatedName("a")
	@Export("state")
	byte state;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 517689507
	)
	@Export("id")
	public int id;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 969157751
	)
	@Export("unitPrice")
	public int unitPrice;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1699214933
	)
	@Export("totalQuantity")
	public int totalQuantity;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 573459647
	)
	@Export("currentQuantity")
	public int currentQuantity;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 494126965
	)
	@Export("currentPrice")
	public int currentPrice;

	public GrandExchangeOffer() {
	}

	@ObfuscatedSignature(
		signature = "(Lkc;Z)V",
		garbageValue = "0"
	)
	public GrandExchangeOffer(Buffer var1, boolean var2) {
		this.state = var1.readByte();
		this.id = var1.readUnsignedShort();
		this.unitPrice = var1.readInt();
		this.totalQuantity = var1.readInt();
		this.currentQuantity = var1.readInt();
		this.currentPrice = var1.readInt();
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-108"
	)
	@Export("status")
	public int status() {
		return this.state & 7;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-928896233"
	)
	@Export("type")
	public int type() {
		return (this.state & 8) == 8 ? 1 : 0;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IS)V",
		garbageValue = "-24365"
	)
	void method139(int var1) {
		this.state &= -8;
		this.state = (byte)(this.state | var1 & 7);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-268336020"
	)
	void method152(int var1) {
		this.state &= -9;
		if (var1 == 1) {
			this.state = (byte)(this.state | 8);
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(II)Lcj;",
		garbageValue = "538429635"
	)
	@Export("getScript")
	static Script getScript(int var0) {
		Script var1 = (Script)Script.Script_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = Occluder.archive12.takeFile(var0, 0);
			if (var2 == null) {
				return null;
			} else {
				var1 = WorldMapIcon_0.newScript(var2);
				Script.Script_cached.put(var1, (long)var0);
				return var1;
			}
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;II[BIB)I",
		garbageValue = "-73"
	)
	@Export("encodeStringCp1252")
	public static int encodeStringCp1252(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
		int var5 = var2 - var1;

		for (int var6 = 0; var6 < var5; ++var6) {
			char var7 = var0.charAt(var6 + var1);
			if (var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
				var3[var6 + var4] = (byte)var7;
			} else if (var7 == 8364) {
				var3[var6 + var4] = -128;
			} else if (var7 == 8218) {
				var3[var6 + var4] = -126;
			} else if (var7 == 402) {
				var3[var6 + var4] = -125;
			} else if (var7 == 8222) {
				var3[var6 + var4] = -124;
			} else if (var7 == 8230) {
				var3[var6 + var4] = -123;
			} else if (var7 == 8224) {
				var3[var6 + var4] = -122;
			} else if (var7 == 8225) {
				var3[var6 + var4] = -121;
			} else if (var7 == 710) {
				var3[var6 + var4] = -120;
			} else if (var7 == 8240) {
				var3[var6 + var4] = -119;
			} else if (var7 == 352) {
				var3[var6 + var4] = -118;
			} else if (var7 == 8249) {
				var3[var6 + var4] = -117;
			} else if (var7 == 338) {
				var3[var6 + var4] = -116;
			} else if (var7 == 381) {
				var3[var6 + var4] = -114;
			} else if (var7 == 8216) {
				var3[var6 + var4] = -111;
			} else if (var7 == 8217) {
				var3[var6 + var4] = -110;
			} else if (var7 == 8220) {
				var3[var6 + var4] = -109;
			} else if (var7 == 8221) {
				var3[var6 + var4] = -108;
			} else if (var7 == 8226) {
				var3[var6 + var4] = -107;
			} else if (var7 == 8211) {
				var3[var6 + var4] = -106;
			} else if (var7 == 8212) {
				var3[var6 + var4] = -105;
			} else if (var7 == 732) {
				var3[var6 + var4] = -104;
			} else if (var7 == 8482) {
				var3[var6 + var4] = -103;
			} else if (var7 == 353) {
				var3[var6 + var4] = -102;
			} else if (var7 == 8250) {
				var3[var6 + var4] = -101;
			} else if (var7 == 339) {
				var3[var6 + var4] = -100;
			} else if (var7 == 382) {
				var3[var6 + var4] = -98;
			} else if (var7 == 376) {
				var3[var6 + var4] = -97;
			} else {
				var3[var6 + var4] = 63;
			}
		}

		return var5;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "-1089712950"
	)
	@Export("setLoginResponseString")
	static void setLoginResponseString(String var0, String var1, String var2) {
		Login.Login_response1 = var0;
		Login.Login_response2 = var1;
		Login.Login_response3 = var2;
	}

	@ObfuscatedName("jm")
	@ObfuscatedSignature(
		signature = "(III)Ljava/lang/String;",
		garbageValue = "76295628"
	)
	static final String method159(int var0, int var1) {
		int var2 = var1 - var0;
		if (var2 < -9) {
			return AbstractArchive.colorStartTag(16711680);
		} else if (var2 < -6) {
			return AbstractArchive.colorStartTag(16723968);
		} else if (var2 < -3) {
			return AbstractArchive.colorStartTag(16740352);
		} else if (var2 < 0) {
			return AbstractArchive.colorStartTag(16756736);
		} else if (var2 > 9) {
			return AbstractArchive.colorStartTag(65280);
		} else if (var2 > 6) {
			return AbstractArchive.colorStartTag(4259584);
		} else if (var2 > 3) {
			return AbstractArchive.colorStartTag(8453888);
		} else {
			return var2 > 0 ? AbstractArchive.colorStartTag(12648192) : AbstractArchive.colorStartTag(16776960);
		}
	}

	@ObfuscatedName("jq")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "354835371"
	)
	@Export("formatItemStacks")
	static final String formatItemStacks(int var0) {
		String var1 = Integer.toString(var0);

		for (int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
			var1 = var1.substring(0, var2) + "," + var1.substring(var2);
		}

		if (var1.length() > 9) {
			return " " + AbstractArchive.colorStartTag(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>";
		} else {
			return var1.length() > 6 ? " " + AbstractArchive.colorStartTag(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>" : " " + AbstractArchive.colorStartTag(16776960) + var1 + "</col>";
		}
	}
}
