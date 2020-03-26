import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
@Implements("MusicPatchNode")
public class MusicPatchNode extends Node {
	@ObfuscatedName("dl")
	@ObfuscatedSignature(
		signature = "Llt;"
	)
	@Export("js5Socket")
	static AbstractSocket js5Socket;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1338967265
	)
	int field2452;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lhy;"
	)
	@Export("patch")
	MusicPatch patch;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Ldm;"
	)
	@Export("rawSound")
	RawSound rawSound;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lgf;"
	)
	MusicPatchNode2 field2460;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1651211223
	)
	int field2467;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -454114325
	)
	int field2464;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1747303555
	)
	int field2451;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -289148489
	)
	int field2465;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1697812591
	)
	int field2445;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1048994435
	)
	int field2454;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -599358683
	)
	int field2455;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1836492369
	)
	int field2456;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 705413515
	)
	int field2457;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1352510901
	)
	int field2458;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 2063074809
	)
	int field2459;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1989506561
	)
	int field2448;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1064961041
	)
	int field2461;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 32368267
	)
	int field2449;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Ldy;"
	)
	@Export("stream")
	RawPcmStream stream;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -573766161
	)
	int field2453;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1090387417
	)
	int field2462;

	MusicPatchNode() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-392566943"
	)
	void method3917() {
		this.patch = null;
		this.rawSound = null;
		this.field2460 = null;
		this.stream = null;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/CharSequence;IIS)Ljava/lang/String;",
		garbageValue = "313"
	)
	public static String method3921(CharSequence[] var0, int var1, int var2) {
		if (var2 == 0) {
			return "";
		} else if (var2 == 1) {
			CharSequence var3 = var0[var1];
			return var3 == null ? "null" : var3.toString();
		} else {
			int var8 = var2 + var1;
			int var4 = 0;

			for (int var5 = var1; var5 < var8; ++var5) {
				CharSequence var6 = var0[var5];
				if (var6 == null) {
					var4 += 4;
				} else {
					var4 += var6.length();
				}
			}

			StringBuilder var9 = new StringBuilder(var4);

			for (int var10 = var1; var10 < var8; ++var10) {
				CharSequence var7 = var0[var10];
				if (var7 == null) {
					var9.append("null");
				} else {
					var9.append(var7);
				}
			}

			return var9.toString();
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)[Llu;",
		garbageValue = "-133902824"
	)
	@Export("FillMode_values")
	public static class332[] FillMode_values() {
		return new class332[]{class332.SOLID, class332.field3875, class332.field3874};
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IB)Lhe;",
		garbageValue = "-47"
	)
	@Export("getWidget")
	public static Widget getWidget(int var0) {
		int var1 = var0 >> 16;
		int var2 = var0 & 65535;
		if (Widget.Widget_interfaceComponents[var1] == null || Widget.Widget_interfaceComponents[var1][var2] == null) {
			boolean var3 = LoginScreenAnimation.loadInterface(var1);
			if (!var3) {
				return null;
			}
		}

		return Widget.Widget_interfaceComponents[var1][var2];
	}

	@ObfuscatedName("hx")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1143611655"
	)
	static void method3922(int var0, int var1) {
		int var2 = TaskHandler.fontBold12.stringWidth("Choose Option");

		int var3;
		for (var3 = 0; var3 < Client.menuOptionsCount; ++var3) {
			Font var4 = TaskHandler.fontBold12;
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
		if (var2 + var7 > WorldMapLabel.canvasWidth) {
			var7 = WorldMapLabel.canvasWidth - var2;
		}

		if (var7 < 0) {
			var7 = 0;
		}

		int var8 = var1;
		if (var1 + var3 > Varps.canvasHeight) {
			var8 = Varps.canvasHeight - var3;
		}

		if (var8 < 0) {
			var8 = 0;
		}

		WorldMapDecoration.menuX = var7;
		PacketBufferNode.menuY = var8;
		class49.menuWidth = var2;
		WorldMapData_1.menuHeight = Client.menuOptionsCount * 15 + 22;
	}
}
