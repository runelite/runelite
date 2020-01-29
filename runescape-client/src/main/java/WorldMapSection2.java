import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
@Implements("WorldMapSection2")
public class WorldMapSection2 implements WorldMapSection {
	@ObfuscatedName("sp")
	@ObfuscatedSignature(
		signature = "Lbj;"
	)
	@Export("clientPreferences")
	static ClientPreferences clientPreferences;
	@ObfuscatedName("ea")
	@ObfuscatedGetter(
		intValue = 1716794499
	)
	@Export("port3")
	static int port3;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 62157229
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 808318479
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 521626037
	)
	@Export("regionStartX")
	int regionStartX;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 694874349
	)
	@Export("regionStartY")
	int regionStartY;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 316477089
	)
	@Export("regionEndX")
	int regionEndX;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 911714159
	)
	@Export("regionEndY")
	int regionEndY;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1254748989
	)
	int field214;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 389719751
	)
	int field216;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -363427247
	)
	int field215;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 467774707
	)
	int field217;

	WorldMapSection2() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lae;I)V",
		garbageValue = "-1034100543"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field214) {
			var1.regionLowX = this.field214;
		}

		if (var1.regionHighX < this.field215) {
			var1.regionHighX = this.field215;
		}

		if (var1.regionLowY > this.field216) {
			var1.regionLowY = this.field216;
		}

		if (var1.regionHighY < this.field217) {
			var1.regionHighY = this.field217;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIIB)Z",
		garbageValue = "-110"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.minPlane + this.planes) {
			return var2 >> 6 >= this.regionStartX && var2 >> 6 <= this.regionEndX && var3 >> 6 >= this.regionStartY && var3 >> 6 <= this.regionEndY;
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
		return var1 >> 6 >= this.field214 && var1 >> 6 <= this.field215 && var2 >> 6 >= this.field216 && var2 >> 6 <= this.field217;
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
			int[] var4 = new int[]{this.field214 * 64 - this.regionStartX * 64 + var2, var3 + (this.field216 * 64 - this.regionStartY * 64)};
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
			int var3 = this.regionStartX * 64 - this.field214 * 64 + var1;
			int var4 = this.regionStartY * 64 - this.field216 * 64 + var2;
			return new Coord(this.minPlane, var3, var4);
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkp;B)V",
		garbageValue = "76"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte();
		this.planes = var1.readUnsignedByte();
		this.regionStartX = var1.readUnsignedShort();
		this.regionStartY = var1.readUnsignedShort();
		this.regionEndX = var1.readUnsignedShort();
		this.regionEndY = var1.readUnsignedShort();
		this.field214 = var1.readUnsignedShort();
		this.field216 = var1.readUnsignedShort();
		this.field215 = var1.readUnsignedShort();
		this.field217 = var1.readUnsignedShort();
		this.postRead();
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1425625159"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(II)Lio;",
		garbageValue = "-1814151694"
	)
	@Export("KitDefinition_get")
	public static KitDefinition KitDefinition_get(int var0) {
		KitDefinition var1 = (KitDefinition)KitDefinition.KitDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = KitDefinition.KitDefinition_archive.takeFile(3, var0);
			var1 = new KitDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			KitDefinition.KitDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1693295942"
	)
	public static void method342() {
		VarbitDefinition.VarbitDefinition_cached.clear();
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1579745096"
	)
	static int method340(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return 0;
		} else if (var1 == -1) {
			return 0;
		} else {
			int var3 = 0;

			for (int var4 = 0; var4 < var2.quantities.length; ++var4) {
				if (var2.ids[var4] == var1) {
					var3 += var2.quantities[var4];
				}
			}

			return var3;
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1868356098"
	)
	static void method344() {
		Login.Login_username = Login.Login_username.trim();
		if (Login.Login_username.length() == 0) {
			Tiles.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
		} else {
			long var1 = class30.method567();
			int var0;
			if (0L == var1) {
				var0 = 5;
			} else {
				var0 = GraphicsObject.method2060(var1, Login.Login_username);
			}

			switch(var0) {
			case 2:
				Tiles.setLoginResponseString(Strings.field3036, Strings.field3037, Strings.field2933);
				Login.loginIndex = 6;
				break;
			case 3:
				Tiles.setLoginResponseString("", "Error connecting to server.", "");
				break;
			case 4:
				Tiles.setLoginResponseString("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
				break;
			case 5:
				Tiles.setLoginResponseString("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
				break;
			case 6:
				Tiles.setLoginResponseString("", "Error connecting to server.", "");
				break;
			case 7:
				Tiles.setLoginResponseString("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
			}

		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
		garbageValue = "11"
	)
	public static String method321(CharSequence var0) {
		int var2 = var0.length();
		char[] var3 = new char[var2];

		for (int var4 = 0; var4 < var2; ++var4) {
			var3[var4] = '*';
		}

		String var1 = new String(var3);
		return var1;
	}
}
