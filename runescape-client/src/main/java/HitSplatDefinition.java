import java.io.DataInputStream;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
@Implements("HitSplatDefinition")
public class HitSplatDefinition extends DualNode {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("HitSplatDefinition_archive")
	public static AbstractArchive HitSplatDefinition_archive;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("HitSplatDefinition_spritesArchive")
	public static AbstractArchive HitSplatDefinition_spritesArchive;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("HitSplatDefinition_fontsArchive")
	public static AbstractArchive HitSplatDefinition_fontsArchive;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("HitSplatDefinition_cached")
	public static EvictingDualNodeHashTable HitSplatDefinition_cached;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("HitSplatDefinition_cachedSprites")
	public static EvictingDualNodeHashTable HitSplatDefinition_cachedSprites;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("HitSplatDefinition_cachedFonts")
	public static EvictingDualNodeHashTable HitSplatDefinition_cachedFonts;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 676904717
	)
	@Export("fontId")
	int fontId;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1445466235
	)
	public int field3333;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1814689987
	)
	public int field3344;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 499426669
	)
	int field3334;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 919035525
	)
	int field3336;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1569596867
	)
	int field3337;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -2118170041
	)
	int field3338;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -751318081
	)
	public int field3335;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 184032475
	)
	public int field3340;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -604427311
	)
	public int field3341;
	@ObfuscatedName("o")
	String field3342;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -916102957
	)
	public int field3348;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1597610159
	)
	public int field3328;
	@ObfuscatedName("s")
	@Export("transforms")
	public int[] transforms;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1769273857
	)
	@Export("transformVarbit")
	int transformVarbit;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 468792805
	)
	@Export("transformVarp")
	int transformVarp;

	static {
		HitSplatDefinition_cached = new EvictingDualNodeHashTable(64);
		HitSplatDefinition_cachedSprites = new EvictingDualNodeHashTable(64);
		HitSplatDefinition_cachedFonts = new EvictingDualNodeHashTable(20);
	}

	HitSplatDefinition() {
		this.fontId = -1;
		this.field3333 = 16777215;
		this.field3344 = 70;
		this.field3334 = -1;
		this.field3336 = -1;
		this.field3337 = -1;
		this.field3338 = -1;
		this.field3335 = 0;
		this.field3340 = 0;
		this.field3341 = -1;
		this.field3342 = "";
		this.field3348 = -1;
		this.field3328 = 0;
		this.transformVarbit = -1;
		this.transformVarp = -1;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkf;B)V",
		garbageValue = "1"
	)
	@Export("decode")
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lkf;II)V",
		garbageValue = "1504666290"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.fontId = var1.method5511();
		} else if (var2 == 2) {
			this.field3333 = var1.readMedium();
		} else if (var2 == 3) {
			this.field3334 = var1.method5511();
		} else if (var2 == 4) {
			this.field3337 = var1.method5511();
		} else if (var2 == 5) {
			this.field3336 = var1.method5511();
		} else if (var2 == 6) {
			this.field3338 = var1.method5511();
		} else if (var2 == 7) {
			this.field3335 = var1.readShort();
		} else if (var2 == 8) {
			this.field3342 = var1.readStringCp1252NullCircumfixed();
		} else if (var2 == 9) {
			this.field3344 = var1.readUnsignedShort();
		} else if (var2 == 10) {
			this.field3340 = var1.readShort();
		} else if (var2 == 11) {
			this.field3341 = 0;
		} else if (var2 == 12) {
			this.field3348 = var1.readUnsignedByte();
		} else if (var2 == 13) {
			this.field3328 = var1.readShort();
		} else if (var2 == 14) {
			this.field3341 = var1.readUnsignedShort();
		} else if (var2 == 17 || var2 == 18) {
			this.transformVarbit = var1.readUnsignedShort();
			if (this.transformVarbit == 65535) {
				this.transformVarbit = -1;
			}

			this.transformVarp = var1.readUnsignedShort();
			if (this.transformVarp == 65535) {
				this.transformVarp = -1;
			}

			int var3 = -1;
			if (var2 == 18) {
				var3 = var1.readUnsignedShort();
				if (var3 == 65535) {
					var3 = -1;
				}
			}

			int var4 = var1.readUnsignedByte();
			this.transforms = new int[var4 + 2];

			for (int var5 = 0; var5 <= var4; ++var5) {
				this.transforms[var5] = var1.readUnsignedShort();
				if (this.transforms[var5] == 65535) {
					this.transforms[var5] = -1;
				}
			}

			this.transforms[var4 + 1] = var3;
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)Lio;",
		garbageValue = "0"
	)
	@Export("transform")
	public final HitSplatDefinition transform() {
		int var1 = -1;
		if (this.transformVarbit != -1) {
			var1 = GrandExchangeOfferOwnWorldComparator.getVarbit(this.transformVarbit);
		} else if (this.transformVarp != -1) {
			var1 = Varps.Varps_main[this.transformVarp];
		}

		int var2;
		if (var1 >= 0 && var1 < this.transforms.length - 1) {
			var2 = this.transforms[var1];
		} else {
			var2 = this.transforms[this.transforms.length - 1];
		}

		return var2 != -1 ? Projectile.getHitSplatDefinition(var2) : null;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "-1319187584"
	)
	@Export("getString")
	public String getString(int var1) {
		String var2 = this.field3342;

		while (true) {
			int var3 = var2.indexOf("%1");
			if (var3 < 0) {
				return var2;
			}

			var2 = var2.substring(0, var3) + class195.intToString(var1, false) + var2.substring(var3 + 2);
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)Lly;",
		garbageValue = "-1354583226"
	)
	public Sprite method4551() {
		if (this.field3334 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3334);
			if (var1 != null) {
				return var1;
			} else {
				var1 = class65.SpriteBuffer_tryCreateSprite(HitSplatDefinition_spritesArchive, this.field3334, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3334);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)Lly;",
		garbageValue = "-2099712719"
	)
	public Sprite method4557() {
		if (this.field3336 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3336);
			if (var1 != null) {
				return var1;
			} else {
				var1 = class65.SpriteBuffer_tryCreateSprite(HitSplatDefinition_spritesArchive, this.field3336, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3336);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)Lly;",
		garbageValue = "-48"
	)
	public Sprite method4558() {
		if (this.field3337 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3337);
			if (var1 != null) {
				return var1;
			} else {
				var1 = class65.SpriteBuffer_tryCreateSprite(HitSplatDefinition_spritesArchive, this.field3337, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3337);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Lly;",
		garbageValue = "-1606516448"
	)
	public Sprite method4583() {
		if (this.field3338 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3338);
			if (var1 != null) {
				return var1;
			} else {
				var1 = class65.SpriteBuffer_tryCreateSprite(HitSplatDefinition_spritesArchive, this.field3338, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3338);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Lke;",
		garbageValue = "-1472977599"
	)
	@Export("getFont")
	public Font getFont() {
		if (this.fontId == -1) {
			return null;
		} else {
			Font var1 = (Font)HitSplatDefinition_cachedFonts.get((long)this.fontId);
			if (var1 != null) {
				return var1;
			} else {
				AbstractArchive var3 = HitSplatDefinition_spritesArchive;
				AbstractArchive var4 = HitSplatDefinition_fontsArchive;
				int var5 = this.fontId;
				Font var2;
				if (!Friend.SpriteBuffer_loadSprite(var3, var5, 0)) {
					var2 = null;
				} else {
					var2 = WallDecoration.getWorldMapSprite(var4.takeFile(var5, 0));
				}

				if (var2 != null) {
					HitSplatDefinition_cachedFonts.put(var2, (long)this.fontId);
				}

				return var2;
			}
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/Throwable;B)V",
		garbageValue = "40"
	)
	@Export("sendStackTrace")
	public static void sendStackTrace(String var0, Throwable var1) {
		if (var1 != null) {
			var1.printStackTrace();
		} else {
			try {
				String var2 = "";
				if (var1 != null) {
					var2 = FloorDecoration.method2843(var1);
				}

				if (var0 != null) {
					if (var1 != null) {
						var2 = var2 + " | ";
					}

					var2 = var2 + var0;
				}

				System.out.println("Error: " + var2);
				var2 = var2.replace(':', '.');
				var2 = var2.replace('@', '_');
				var2 = var2.replace('&', '_');
				var2 = var2.replace('#', '_');
				if (RunException.RunException_applet == null) {
					return;
				}

				URL var3 = new URL(RunException.RunException_applet.getCodeBase(), "clienterror.ws?c=" + RunException.revision + "&u=" + GrandExchangeOfferUnitPriceComparator.localPlayerName + "&v1=" + TaskHandler.javaVendor + "&v2=" + TaskHandler.javaVersion + "&ct=" + RunException.field4066 + "&e=" + var2);
				DataInputStream var4 = new DataInputStream(var3.openStream());
				var4.read();
				var4.close();
			} catch (Exception var5) {
			}

		}
	}
}
