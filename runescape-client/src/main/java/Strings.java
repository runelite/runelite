import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
@Implements("Strings")
public class Strings {
	@ObfuscatedName("bk")
	public static String field2798;
	@ObfuscatedName("ct")
	public static String field2837;
	@ObfuscatedName("jk")
	public static String field2834;
	@ObfuscatedName("jx")
	public static String field3014;
	@ObfuscatedName("jd")
	public static String field3015;

	static {
		field2798 = "Please visit the support page for assistance.";
		field2837 = "Please visit the support page for assistance.";
		field2834 = "";
		field3014 = "Page has opened in a new window.";
		field3015 = "(Please check your popup blocker.)";
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "([BILjava/lang/CharSequence;B)I",
		garbageValue = "-83"
	)
	public static int method4095(byte[] var0, int var1, CharSequence var2) {
		int var3 = var2.length();
		int var4 = var1;

		for (int var5 = 0; var5 < var3; ++var5) {
			char var6 = var2.charAt(var5);
			if (var6 <= 127) {
				var0[var4++] = (byte)var6;
			} else if (var6 <= 2047) {
				var0[var4++] = (byte)(192 | var6 >> 6);
				var0[var4++] = (byte)(128 | var6 & '?');
			} else {
				var0[var4++] = (byte)(224 | var6 >> '\f');
				var0[var4++] = (byte)(128 | var6 >> 6 & 63);
				var0[var4++] = (byte)(128 | var6 & '?');
			}
		}

		return var4 - var1;
	}

	@ObfuscatedName("id")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1938003429"
	)
	static void method4096() {
		int var0;
		int var2;
		int var3;
		for (var0 = 0; var0 < Client.menuOptionsCount; ++var0) {
			var2 = Client.menuOpcodes[var0];
			boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
			if (var1) {
				if (var0 < Client.menuOptionsCount - 1) {
					for (var3 = var0; var3 < Client.menuOptionsCount - 1; ++var3) {
						Client.menuActions[var3] = Client.menuActions[var3 + 1];
						Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
						Client.menuOpcodes[var3] = Client.menuOpcodes[var3 + 1];
						Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
						Client.menuArguments1[var3] = Client.menuArguments1[var3 + 1];
						Client.menuArguments2[var3] = Client.menuArguments2[var3 + 1];
						Client.menuShiftClick[var3] = Client.menuShiftClick[var3 + 1];
					}
				}

				--var0;
				--Client.menuOptionsCount;
			}
		}

		var0 = KeyHandler.menuWidth / 2 + GrandExchangeEvent.menuX;
		int var9 = WorldMapManager.menuY;
		var2 = GrandExchangeOffer.fontBold12.stringWidth("Choose Option");

		for (var3 = 0; var3 < Client.menuOptionsCount; ++var3) {
			Font var4 = GrandExchangeOffer.fontBold12;
			String var5;
			if (var3 < 0) {
				var5 = "";
			} else if (Client.menuTargets[var3].length() > 0) {
				var5 = Client.menuActions[var3] + " " + Client.menuTargets[var3];
			} else {
				var5 = Client.menuActions[var3];
			}

			int var6 = var4.stringWidth(var5);
			if (var6 > var2) {
				var2 = var6;
			}
		}

		var2 += 8;
		var3 = Client.menuOptionsCount * 15 + 22;
		int var7 = var0 - var2 / 2;
		if (var7 + var2 > GrandExchangeOfferTotalQuantityComparator.canvasWidth) {
			var7 = GrandExchangeOfferTotalQuantityComparator.canvasWidth - var2;
		}

		if (var7 < 0) {
			var7 = 0;
		}

		int var8 = var9;
		if (var9 + var3 > AttackOption.canvasHeight) {
			var8 = AttackOption.canvasHeight - var3;
		}

		if (var8 < 0) {
			var8 = 0;
		}

		GrandExchangeEvent.menuX = var7;
		WorldMapManager.menuY = var8;
		KeyHandler.menuWidth = var2;
		class54.menuHeight = Client.menuOptionsCount * 15 + 22;
	}
}
