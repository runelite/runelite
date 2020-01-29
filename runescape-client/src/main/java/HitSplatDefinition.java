import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
@Implements("HitSplatDefinition")
public class HitSplatDefinition extends DualNode {
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	public static AbstractArchive field3329;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("HitSplatDefinition_fontsArchive")
	public static AbstractArchive HitSplatDefinition_fontsArchive;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("HitSplatDefinition_cached")
	public static EvictingDualNodeHashTable HitSplatDefinition_cached;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("HitSplatDefinition_cachedSprites")
	public static EvictingDualNodeHashTable HitSplatDefinition_cachedSprites;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("HitSplatDefinition_cachedFonts")
	public static EvictingDualNodeHashTable HitSplatDefinition_cachedFonts;
	@ObfuscatedName("hs")
	@ObfuscatedGetter(
		intValue = -1943215083
	)
	@Export("cameraX")
	static int cameraX;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -36563091
	)
	@Export("fontId")
	int fontId;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -549916475
	)
	@Export("textColor")
	public int textColor;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -795329979
	)
	public int field3328;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 2007057893
	)
	int field3339;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1439710291
	)
	int field3324;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -378798801
	)
	int field3331;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -403504011
	)
	int field3332;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1748437233
	)
	public int field3323;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1149201175
	)
	public int field3334;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -600429647
	)
	public int field3335;
	@ObfuscatedName("b")
	String field3322;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -960133159
	)
	public int field3337;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 465425557
	)
	public int field3338;
	@ObfuscatedName("a")
	@Export("transforms")
	public int[] transforms;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1372204811
	)
	@Export("transformVarbit")
	int transformVarbit;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = 1090071963
	)
	@Export("transformVarp")
	int transformVarp;

	static {
		HitSplatDefinition_cached = new EvictingDualNodeHashTable(64);
		HitSplatDefinition_cachedSprites = new EvictingDualNodeHashTable(64);
		HitSplatDefinition_cachedFonts = new EvictingDualNodeHashTable(20);
	}

	public HitSplatDefinition() {
		this.fontId = -1;
		this.textColor = 16777215;
		this.field3328 = 70;
		this.field3339 = -1;
		this.field3324 = -1;
		this.field3331 = -1;
		this.field3332 = -1;
		this.field3323 = 0;
		this.field3334 = 0;
		this.field3335 = -1;
		this.field3322 = "";
		this.field3337 = -1;
		this.field3338 = 0;
		this.transformVarbit = -1;
		this.transformVarp = -1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lkp;I)V",
		garbageValue = "1729846192"
	)
	@Export("decode")
	public void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkp;II)V",
		garbageValue = "-1144577894"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.fontId = var1.method5593();
		} else if (var2 == 2) {
			this.textColor = var1.readMedium();
		} else if (var2 == 3) {
			this.field3339 = var1.method5593();
		} else if (var2 == 4) {
			this.field3331 = var1.method5593();
		} else if (var2 == 5) {
			this.field3324 = var1.method5593();
		} else if (var2 == 6) {
			this.field3332 = var1.method5593();
		} else if (var2 == 7) {
			this.field3323 = var1.readShort();
		} else if (var2 == 8) {
			this.field3322 = var1.readStringCp1252NullCircumfixed();
		} else if (var2 == 9) {
			this.field3328 = var1.readUnsignedShort();
		} else if (var2 == 10) {
			this.field3334 = var1.readShort();
		} else if (var2 == 11) {
			this.field3335 = 0;
		} else if (var2 == 12) {
			this.field3337 = var1.readUnsignedByte();
		} else if (var2 == 13) {
			this.field3338 = var1.readShort();
		} else if (var2 == 14) {
			this.field3335 = var1.readUnsignedShort();
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

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(B)Lil;",
		garbageValue = "105"
	)
	@Export("transform")
	public final HitSplatDefinition transform() {
		int var1 = -1;
		if (this.transformVarbit != -1) {
			var1 = GrandExchangeOfferUnitPriceComparator.getVarbit(this.transformVarbit);
		} else if (this.transformVarp != -1) {
			var1 = Varps.Varps_main[this.transformVarp];
		}

		int var2;
		if (var1 >= 0 && var1 < this.transforms.length - 1) {
			var2 = this.transforms[var1];
		} else {
			var2 = this.transforms[this.transforms.length - 1];
		}

		if (var2 != -1) {
			HitSplatDefinition var4 = (HitSplatDefinition)HitSplatDefinition_cached.get((long)var2);
			HitSplatDefinition var3;
			if (var4 != null) {
				var3 = var4;
			} else {
				byte[] var5 = class49.HitSplatDefinition_archive.takeFile(32, var2);
				var4 = new HitSplatDefinition();
				if (var5 != null) {
					var4.decode(new Buffer(var5));
				}

				HitSplatDefinition_cached.put(var4, (long)var2);
				var3 = var4;
			}

			return var3;
		} else {
			return null;
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "1185099535"
	)
	@Export("getString")
	public String getString(int var1) {
		String var2 = this.field3322;

		while (true) {
			int var3 = var2.indexOf("%1");
			if (var3 < 0) {
				return var2;
			}

			var2 = var2.substring(0, var3) + ItemContainer.intToString(var1, false) + var2.substring(var3 + 2);
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Llt;",
		garbageValue = "1146038763"
	)
	public Sprite method4649() {
		if (this.field3339 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3339);
			if (var1 != null) {
				return var1;
			} else {
				var1 = WorldMapSection1.SpriteBuffer_getSprite(field3329, this.field3339, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3339);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)Llt;",
		garbageValue = "127"
	)
	public Sprite method4650() {
		if (this.field3324 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3324);
			if (var1 != null) {
				return var1;
			} else {
				var1 = WorldMapSection1.SpriteBuffer_getSprite(field3329, this.field3324, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3324);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)Llt;",
		garbageValue = "125"
	)
	public Sprite method4651() {
		if (this.field3331 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3331);
			if (var1 != null) {
				return var1;
			} else {
				var1 = WorldMapSection1.SpriteBuffer_getSprite(field3329, this.field3331, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3331);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(B)Llt;",
		garbageValue = "-109"
	)
	public Sprite method4652() {
		if (this.field3332 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3332);
			if (var1 != null) {
				return var1;
			} else {
				var1 = WorldMapSection1.SpriteBuffer_getSprite(field3329, this.field3332, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3332);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)Lko;",
		garbageValue = "-643633719"
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
				var1 = FaceNormal.method3335(field3329, HitSplatDefinition_fontsArchive, this.fontId, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedFonts.put(var1, (long)this.fontId);
				}

				return var1;
			}
		}
	}
}
