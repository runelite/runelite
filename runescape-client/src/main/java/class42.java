import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ad")
public class class42 implements WorldMapSection {
	@ObfuscatedName("q")
	public static String[] field373;
	@ObfuscatedName("aj")
	@Export("loginScreenFontMetrics")
	static FontMetrics loginScreenFontMetrics;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -794430173
	)
	int field371;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1085068769
	)
	int field367;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1005090491
	)
	int field366;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 283016431
	)
	int field369;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -15254045
	)
	int field372;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -865271583
	)
	int field370;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1602446289
	)
	int field376;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -2003918993
	)
	int field368;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -500974497
	)
	int field374;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1662707559
	)
	int field375;

	class42() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lae;I)V",
		garbageValue = "-1034100543"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field372) {
			var1.regionLowX = this.field372;
		}

		if (var1.regionHighX < this.field372) {
			var1.regionHighX = this.field372;
		}

		if (var1.regionLowY > this.field370) {
			var1.regionLowY = this.field370;
		}

		if (var1.regionHighY < this.field370) {
			var1.regionHighY = this.field370;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIIB)Z",
		garbageValue = "-110"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.field371 && var1 < this.field371 + this.field367) {
			return var2 >= (this.field366 << 6) + (this.field376 << 3) && var2 <= (this.field366 << 6) + (this.field376 << 3) + 7 && var3 >= (this.field369 << 6) + (this.field368 << 3) && var3 <= (this.field369 << 6) + (this.field368 << 3) + 7;
		} else {
			return false;
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "37"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.field372 << 6) + (this.field374 << 3) && var1 <= (this.field372 << 6) + (this.field374 << 3) + 7 && var2 >= (this.field370 << 6) + (this.field375 << 3) && var2 <= (this.field370 << 6) + (this.field375 << 3) + 7;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "-96920779"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.field372 * 64 - this.field366 * 64 + var2 + (this.field374 * 8 - this.field376 * 8), var3 + (this.field370 * 64 - this.field369 * 64) + (this.field375 * 8 - this.field368 * 8)};
			return var4;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)Lhj;",
		garbageValue = "911083222"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.field366 * 64 - this.field372 * 64 + (this.field376 * 8 - this.field374 * 8) + var1;
			int var4 = this.field369 * 64 - this.field370 * 64 + var2 + (this.field368 * 8 - this.field375 * 8);
			return new Coord(this.field371, var3, var4);
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkp;B)V",
		garbageValue = "76"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.field371 = var1.readUnsignedByte();
		this.field367 = var1.readUnsignedByte();
		this.field366 = var1.readUnsignedShort();
		this.field376 = var1.readUnsignedByte();
		this.field369 = var1.readUnsignedShort();
		this.field368 = var1.readUnsignedByte();
		this.field372 = var1.readUnsignedShort();
		this.field374 = var1.readUnsignedByte();
		this.field370 = var1.readUnsignedShort();
		this.field375 = var1.readUnsignedByte();
		this.method788();
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-111"
	)
	void method788() {
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(CLgl;B)I",
		garbageValue = "15"
	)
	@Export("lowercaseChar")
	static int lowercaseChar(char var0, Language var1) {
		int var2 = var0 << 4;
		if (Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
			var0 = Character.toLowerCase(var0);
			var2 = (var0 << 4) + 1;
		}

		if (var0 == 241 && var1 == Language.Language_ES) {
			var2 = 1762;
		}

		return var2;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(ILce;ZB)I",
		garbageValue = "1"
	)
	static int method810(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = Varps.getWidget(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? class186.field2331 : MidiPcmStream.field2444;
		}

		if (var0 == ScriptOpcodes.CC_CALLONRESIZE) {
			if (Interpreter.field1088 >= 10) {
				throw new RuntimeException();
			} else if (var3.onResize == null) {
				return 0;
			} else {
				ScriptEvent var4 = new ScriptEvent();
				var4.widget = var3;
				var4.args = var3.onResize;
				var4.field582 = Interpreter.field1088 + 1;
				Client.scriptEvents.addFirst(var4);
				return 1;
			}
		} else {
			return 2;
		}
	}

	@ObfuscatedName("kf")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZS)Ljava/lang/String;",
		garbageValue = "-9068"
	)
	static String method809(String var0, boolean var1) {
		String var2 = var1 ? "https://" : "http://";
		if (Client.gameBuild == 1) {
			var0 = var0 + "-wtrc";
		} else if (Client.gameBuild == 2) {
			var0 = var0 + "-wtqa";
		} else if (Client.gameBuild == 3) {
			var0 = var0 + "-wtwip";
		} else if (Client.gameBuild == 5) {
			var0 = var0 + "-wti";
		} else if (Client.gameBuild == 4) {
			var0 = "local";
		}

		String var3 = "";
		if (GameShell.field477 != null) {
			var3 = "/p=" + GameShell.field477;
		}

		String var4 = "runescape.com";
		return var2 + var0 + "." + var4 + "/l=" + FriendLoginUpdate.clientLanguage + "/a=" + Client.field672 + var3 + "/";
	}

	@ObfuscatedName("kw")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZI)V",
		garbageValue = "572595678"
	)
	@Export("findItemDefinitions")
	static void findItemDefinitions(String var0, boolean var1) {
		var0 = var0.toLowerCase();
		short[] var2 = new short[16];
		int var3 = 0;

		for (int var4 = 0; var4 < ItemDefinition.ItemDefinition_fileCount; ++var4) {
			ItemDefinition var5 = HealthBarDefinition.ItemDefinition_get(var4);
			if ((!var1 || var5.isTradable) && var5.noteTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
				if (var3 >= 250) {
					class162.foundItemIdCount = -1;
					WorldMapData_0.foundItemIds = null;
					return;
				}

				if (var3 >= var2.length) {
					short[] var6 = new short[var2.length * 2];

					for (int var7 = 0; var7 < var3; ++var7) {
						var6[var7] = var2[var7];
					}

					var2 = var6;
				}

				var2[var3++] = (short)var4;
			}
		}

		WorldMapData_0.foundItemIds = var2;
		AbstractByteArrayCopier.foundItemIndex = 0;
		class162.foundItemIdCount = var3;
		String[] var8 = new String[class162.foundItemIdCount];

		for (int var9 = 0; var9 < class162.foundItemIdCount; ++var9) {
			var8[var9] = HealthBarDefinition.ItemDefinition_get(var2[var9]).name;
		}

		short[] var10 = WorldMapData_0.foundItemIds;
		FriendLoginUpdate.sortItemsByName(var8, var10, 0, var8.length - 1);
	}
}
