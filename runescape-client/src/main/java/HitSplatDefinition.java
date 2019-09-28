import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("HitSplatDefinition")
public class HitSplatDefinition extends DualNode {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("HitSplatDefinition_archive")
	public static AbstractArchive HitSplatDefinition_archive;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("HitSplatDefinition_fontsArchive")
	static AbstractArchive HitSplatDefinition_fontsArchive;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("HitSplatDefinition_cached")
	public static EvictingDualNodeHashTable HitSplatDefinition_cached;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("HitSplatDefinition_cachedSprites")
	static EvictingDualNodeHashTable HitSplatDefinition_cachedSprites;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("HitSplatDefinition_cachedFonts")
	static EvictingDualNodeHashTable HitSplatDefinition_cachedFonts;
	@ObfuscatedName("es")
	@ObfuscatedGetter(
		intValue = 290330035
	)
	@Export("port1")
	static int port1;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -135266261
	)
	@Export("fontId")
	int fontId;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -296610035
	)
	@Export("textColor")
	public int textColor;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 31719475
	)
	public int field3318;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1509097345
	)
	int field3319;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -591877115
	)
	int field3332;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -2011301745
	)
	int field3321;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1974829897
	)
	int field3322;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -87931297
	)
	public int field3323;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -577071813
	)
	public int field3311;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1569661547
	)
	public int field3325;
	@ObfuscatedName("f")
	String field3316;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1618086973
	)
	public int field3327;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1970000523
	)
	public int field3334;
	@ObfuscatedName("l")
	@Export("transforms")
	public int[] transforms;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 354517383
	)
	@Export("transformVarbit")
	int transformVarbit;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = -168749029
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
		this.field3318 = 70;
		this.field3319 = -1;
		this.field3332 = -1;
		this.field3321 = -1;
		this.field3322 = -1;
		this.field3323 = 0;
		this.field3311 = 0;
		this.field3325 = -1;
		this.field3316 = "";
		this.field3327 = -1;
		this.field3334 = 0;
		this.transformVarbit = -1;
		this.transformVarp = -1;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkl;B)V",
		garbageValue = "-110"
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkl;II)V",
		garbageValue = "1800631473"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.fontId = var1.method5453();
		} else if (var2 == 2) {
			this.textColor = var1.readMedium();
		} else if (var2 == 3) {
			this.field3319 = var1.method5453();
		} else if (var2 == 4) {
			this.field3321 = var1.method5453();
		} else if (var2 == 5) {
			this.field3332 = var1.method5453();
		} else if (var2 == 6) {
			this.field3322 = var1.method5453();
		} else if (var2 == 7) {
			this.field3323 = var1.readShort();
		} else if (var2 == 8) {
			this.field3316 = var1.readStringCp1252NullCircumfixed();
		} else if (var2 == 9) {
			this.field3318 = var1.readUnsignedShort();
		} else if (var2 == 10) {
			this.field3311 = var1.readShort();
		} else if (var2 == 11) {
			this.field3325 = 0;
		} else if (var2 == 12) {
			this.field3327 = var1.readUnsignedByte();
		} else if (var2 == 13) {
			this.field3334 = var1.readShort();
		} else if (var2 == 14) {
			this.field3325 = var1.readUnsignedShort();
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Liv;",
		garbageValue = "723685"
	)
	@Export("transform")
	public final HitSplatDefinition transform() {
		int var1 = -1;
		if (this.transformVarbit != -1) {
			var1 = WorldMapSprite.getVarbit(this.transformVarbit);
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
				byte[] var5 = HitSplatDefinition_archive.takeFile(32, var2);
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

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(IB)Ljava/lang/String;",
		garbageValue = "13"
	)
	@Export("getString")
	public String getString(int var1) {
		String var2 = this.field3316;

		while (true) {
			int var3 = var2.indexOf("%1");
			if (var3 < 0) {
				return var2;
			}

			var2 = var2.substring(0, var3) + HealthBar.intToString(var1, false) + var2.substring(var3 + 2);
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)Llf;",
		garbageValue = "106816510"
	)
	public Sprite method4520() {
		if (this.field3319 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3319);
			if (var1 != null) {
				return var1;
			} else {
				var1 = NPCDefinition.SpriteBuffer_getSprite(GrandExchangeOfferNameComparator.field66, this.field3319, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3319);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)Llf;",
		garbageValue = "-123360505"
	)
	public Sprite method4517() {
		if (this.field3332 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3332);
			if (var1 != null) {
				return var1;
			} else {
				var1 = NPCDefinition.SpriteBuffer_getSprite(GrandExchangeOfferNameComparator.field66, this.field3332, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3332);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(B)Llf;",
		garbageValue = "88"
	)
	public Sprite method4518() {
		if (this.field3321 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3321);
			if (var1 != null) {
				return var1;
			} else {
				var1 = NPCDefinition.SpriteBuffer_getSprite(GrandExchangeOfferNameComparator.field66, this.field3321, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3321);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)Llf;",
		garbageValue = "750571201"
	)
	public Sprite method4542() {
		if (this.field3322 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3322);
			if (var1 != null) {
				return var1;
			} else {
				var1 = NPCDefinition.SpriteBuffer_getSprite(GrandExchangeOfferNameComparator.field66, this.field3322, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3322);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Lkn;",
		garbageValue = "-1418238828"
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
				var1 = ClanMate.method4976(GrandExchangeOfferNameComparator.field66, HitSplatDefinition_fontsArchive, this.fontId, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedFonts.put(var1, (long)this.fontId);
				}

				return var1;
			}
		}
	}
}
