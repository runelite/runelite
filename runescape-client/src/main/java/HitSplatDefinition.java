import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
@Implements("HitSplatDefinition")
public class HitSplatDefinition extends DualNode {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("HitSplatDefinition_archive")
	public static AbstractArchive HitSplatDefinition_archive;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("HitSplatDefinition_cached")
	static EvictingDualNodeHashTable HitSplatDefinition_cached;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("HitSplatDefinition_cachedSprites")
	static EvictingDualNodeHashTable HitSplatDefinition_cachedSprites;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("HitSplatDefinition_cachedFonts")
	static EvictingDualNodeHashTable HitSplatDefinition_cachedFonts;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1215732899
	)
	@Export("fontId")
	int fontId;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1479775449
	)
	@Export("textColor")
	public int textColor;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -999843627
	)
	public int field3314;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -478859311
	)
	int field3315;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1276859251
	)
	int field3316;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -348958833
	)
	int field3311;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 740187387
	)
	int field3312;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 417347841
	)
	public int field3319;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1914679
	)
	public int field3307;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 348395975
	)
	public int field3318;
	@ObfuscatedName("l")
	String field3322;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -172728541
	)
	public int field3323;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1823926687
	)
	public int field3324;
	@ObfuscatedName("m")
	@Export("transforms")
	public int[] transforms;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1435373639
	)
	@Export("transformVarbit")
	int transformVarbit;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -1817930543
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
		this.textColor = 16777215;
		this.field3314 = 70;
		this.field3315 = -1;
		this.field3316 = -1;
		this.field3311 = -1;
		this.field3312 = -1;
		this.field3319 = 0;
		this.field3307 = 0;
		this.field3318 = -1;
		this.field3322 = "";
		this.field3323 = -1;
		this.field3324 = 0;
		this.transformVarbit = -1;
		this.transformVarp = -1;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "513120287"
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

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lky;II)V",
		garbageValue = "198357624"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.fontId = var1.method5602();
		} else if (var2 == 2) {
			this.textColor = var1.readMedium();
		} else if (var2 == 3) {
			this.field3315 = var1.method5602();
		} else if (var2 == 4) {
			this.field3311 = var1.method5602();
		} else if (var2 == 5) {
			this.field3316 = var1.method5602();
		} else if (var2 == 6) {
			this.field3312 = var1.method5602();
		} else if (var2 == 7) {
			this.field3319 = var1.readShort();
		} else if (var2 == 8) {
			this.field3322 = var1.readStringCp1252NullCircumfixed();
		} else if (var2 == 9) {
			this.field3314 = var1.readUnsignedShort();
		} else if (var2 == 10) {
			this.field3307 = var1.readShort();
		} else if (var2 == 11) {
			this.field3318 = 0;
		} else if (var2 == 12) {
			this.field3323 = var1.readUnsignedByte();
		} else if (var2 == 13) {
			this.field3324 = var1.readShort();
		} else if (var2 == 14) {
			this.field3318 = var1.readUnsignedShort();
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

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)Lio;",
		garbageValue = "-1634643296"
	)
	@Export("transform")
	public final HitSplatDefinition transform() {
		int var1 = -1;
		if (this.transformVarbit != -1) {
			var1 = class208.getVarbit(this.transformVarbit);
		} else if (this.transformVarp != -1) {
			var1 = Varps.Varps_main[this.transformVarp];
		}

		int var2;
		if (var1 >= 0 && var1 < this.transforms.length - 1) {
			var2 = this.transforms[var1];
		} else {
			var2 = this.transforms[this.transforms.length - 1];
		}

		return var2 != -1 ? StructDefinition.HitSplatDefinition_get(var2) : null;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "188489511"
	)
	@Export("getString")
	public String getString(int var1) {
		String var2 = this.field3322;

		while (true) {
			int var3 = var2.indexOf("%1");
			if (var3 < 0) {
				return var2;
			}

			var2 = var2.substring(0, var3) + Friend.intToString(var1, false) + var2.substring(var3 + 2);
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(B)Lls;",
		garbageValue = "108"
	)
	public Sprite method4494() {
		if (this.field3315 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3315);
			if (var1 != null) {
				return var1;
			} else {
				var1 = TilePaint.SpriteBuffer_getSprite(GrandExchangeOfferTotalQuantityComparator.HitSplatDefinition_spritesArchive, this.field3315, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3315);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Lls;",
		garbageValue = "1004292382"
	)
	public Sprite method4468() {
		if (this.field3316 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3316);
			if (var1 != null) {
				return var1;
			} else {
				var1 = TilePaint.SpriteBuffer_getSprite(GrandExchangeOfferTotalQuantityComparator.HitSplatDefinition_spritesArchive, this.field3316, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3316);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)Lls;",
		garbageValue = "101"
	)
	public Sprite method4472() {
		if (this.field3311 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3311);
			if (var1 != null) {
				return var1;
			} else {
				var1 = TilePaint.SpriteBuffer_getSprite(GrandExchangeOfferTotalQuantityComparator.HitSplatDefinition_spritesArchive, this.field3311, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3311);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)Lls;",
		garbageValue = "-74"
	)
	public Sprite method4470() {
		if (this.field3312 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3312);
			if (var1 != null) {
				return var1;
			} else {
				var1 = TilePaint.SpriteBuffer_getSprite(GrandExchangeOfferTotalQuantityComparator.HitSplatDefinition_spritesArchive, this.field3312, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3312);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)Lkb;",
		garbageValue = "489170470"
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
				var1 = FileSystem.SpriteBuffer_getFont(GrandExchangeOfferTotalQuantityComparator.HitSplatDefinition_spritesArchive, class43.HitSplatDefinition_fontsArchive, this.fontId, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedFonts.put(var1, (long)this.fontId);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("gn")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-977763631"
	)
	static boolean method4497() {
		return (Client.drawPlayerNames & 4) != 0;
	}

	@ObfuscatedName("ih")
	@ObfuscatedSignature(
		signature = "(IIIIII)V",
		garbageValue = "-380288285"
	)
	@Export("drawScrollBar")
	static final void drawScrollBar(int var0, int var1, int var2, int var3, int var4) {
		ClientPreferences.scrollBarSprites[0].drawAt(var0, var1);
		ClientPreferences.scrollBarSprites[1].drawAt(var0, var3 + var1 - 16);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1 + 16, 16, var3 - 32, Client.field702);
		int var5 = var3 * (var3 - 32) / var4;
		if (var5 < 8) {
			var5 = 8;
		}

		int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var6 + var1 + 16, 16, var5, Client.field687);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0, var6 + var1 + 16, var5, Client.field689);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 1, var6 + var1 + 16, var5, Client.field689);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 16, 16, Client.field689);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 17, 16, Client.field689);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 15, var6 + var1 + 16, var5, Client.field688);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field688);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var5 + var1 + 15, 16, Client.field688);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0 + 1, var5 + var6 + var1 + 14, 15, Client.field688);
	}
}
