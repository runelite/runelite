import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
@Implements("HitSplatDefinition")
public class HitSplatDefinition extends DualNode {
	@ObfuscatedName("qv")
	@ObfuscatedGetter(
		intValue = -2106163673
	)
	static int field3312;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("HitSplatDefinition_archive")
	public static AbstractArchive HitSplatDefinition_archive;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	public static AbstractArchive field3290;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("HitSplatDefinition_cached")
	public static EvictingDualNodeHashTable HitSplatDefinition_cached;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("HitSplatDefinition_cachedSprites")
	public static EvictingDualNodeHashTable HitSplatDefinition_cachedSprites;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("HitSplatDefinition_cachedFonts")
	public static EvictingDualNodeHashTable HitSplatDefinition_cachedFonts;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 62489831
	)
	@Export("fontId")
	int fontId;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -167444243
	)
	@Export("textColor")
	public int textColor;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 491261365
	)
	public int field3298;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1424505111
	)
	int field3296;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1928448761
	)
	int field3300;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -524634903
	)
	int field3291;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -930676135
	)
	int field3302;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1984037709
	)
	public int field3303;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 2001520185
	)
	public int field3304;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1759745425
	)
	public int field3305;
	@ObfuscatedName("h")
	String field3306;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1901137879
	)
	public int field3299;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 411378659
	)
	public int field3308;
	@ObfuscatedName("r")
	@Export("transforms")
	public int[] transforms;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -42681817
	)
	@Export("transformVarbit")
	int transformVarbit;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = 380242275
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
		this.field3298 = 70;
		this.field3296 = -1;
		this.field3300 = -1;
		this.field3291 = -1;
		this.field3302 = -1;
		this.field3303 = 0;
		this.field3304 = 0;
		this.field3305 = -1;
		this.field3306 = "";
		this.field3299 = -1;
		this.field3308 = 0;
		this.transformVarbit = -1;
		this.transformVarp = -1;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lkq;I)V",
		garbageValue = "-13234196"
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

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Lkq;II)V",
		garbageValue = "-1783175438"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.fontId = var1.method5560();
		} else if (var2 == 2) {
			this.textColor = var1.readMedium();
		} else if (var2 == 3) {
			this.field3296 = var1.method5560();
		} else if (var2 == 4) {
			this.field3291 = var1.method5560();
		} else if (var2 == 5) {
			this.field3300 = var1.method5560();
		} else if (var2 == 6) {
			this.field3302 = var1.method5560();
		} else if (var2 == 7) {
			this.field3303 = var1.readShort();
		} else if (var2 == 8) {
			this.field3306 = var1.readStringCp1252NullCircumfixed();
		} else if (var2 == 9) {
			this.field3298 = var1.readUnsignedShort();
		} else if (var2 == 10) {
			this.field3304 = var1.readShort();
		} else if (var2 == 11) {
			this.field3305 = 0;
		} else if (var2 == 12) {
			this.field3299 = var1.readUnsignedByte();
		} else if (var2 == 13) {
			this.field3308 = var1.readShort();
		} else if (var2 == 14) {
			this.field3305 = var1.readUnsignedShort();
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

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(S)Lid;",
		garbageValue = "1000"
	)
	@Export("transform")
	public final HitSplatDefinition transform() {
		int var1 = -1;
		if (this.transformVarbit != -1) {
			var1 = GameShell.getVarbit(this.transformVarbit);
		} else if (this.transformVarp != -1) {
			var1 = Varps.Varps_main[this.transformVarp];
		}

		int var2;
		if (var1 >= 0 && var1 < this.transforms.length - 1) {
			var2 = this.transforms[var1];
		} else {
			var2 = this.transforms[this.transforms.length - 1];
		}

		return var2 != -1 ? MusicPatchNode.method3815(var2) : null;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "384079116"
	)
	@Export("getString")
	public String getString(int var1) {
		String var2 = this.field3306;

		while (true) {
			int var3 = var2.indexOf("%1");
			if (var3 < 0) {
				return var2;
			}

			var2 = var2.substring(0, var3) + class65.intToString(var1, false) + var2.substring(var3 + 2);
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(B)Lls;",
		garbageValue = "1"
	)
	public Sprite method4600() {
		if (this.field3296 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3296);
			if (var1 != null) {
				return var1;
			} else {
				var1 = FloorUnderlayDefinition.SpriteBuffer_getSprite(field3290, this.field3296, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3296);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)Lls;",
		garbageValue = "1869434079"
	)
	public Sprite method4576() {
		if (this.field3300 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3300);
			if (var1 != null) {
				return var1;
			} else {
				var1 = FloorUnderlayDefinition.SpriteBuffer_getSprite(field3290, this.field3300, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3300);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)Lls;",
		garbageValue = "-53"
	)
	public Sprite method4587() {
		if (this.field3291 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3291);
			if (var1 != null) {
				return var1;
			} else {
				var1 = FloorUnderlayDefinition.SpriteBuffer_getSprite(field3290, this.field3291, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3291);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(B)Lls;",
		garbageValue = "-100"
	)
	public Sprite method4596() {
		if (this.field3302 < 0) {
			return null;
		} else {
			Sprite var1 = (Sprite)HitSplatDefinition_cachedSprites.get((long)this.field3302);
			if (var1 != null) {
				return var1;
			} else {
				var1 = FloorUnderlayDefinition.SpriteBuffer_getSprite(field3290, this.field3302, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field3302);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)Lko;",
		garbageValue = "-24"
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
				var1 = class14.method160(field3290, class206.HitSplatDefinition_fontsArchive, this.fontId, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedFonts.put(var1, (long)this.fontId);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lhz;III)Z",
		garbageValue = "-1590564834"
	)
	public static boolean method4586(AbstractArchive var0, int var1, int var2) {
		byte[] var3 = var0.takeFile(var1, var2);
		if (var3 == null) {
			return false;
		} else {
			AbstractWorldMapIcon.SpriteBuffer_decode(var3);
			return true;
		}
	}

	@ObfuscatedName("hq")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1358506990"
	)
	static final void method4612() {
		PacketBuffer var0 = Client.packetWriter.packetBuffer;
		var0.importIndex();
		int var1 = var0.readBits(8);
		int var2;
		if (var1 < Client.npcCount) {
			for (var2 = var1; var2 < Client.npcCount; ++var2) {
				Client.field745[++Client.field815 - 1] = Client.npcIndices[var2];
			}
		}

		if (var1 > Client.npcCount) {
			throw new RuntimeException("");
		} else {
			Client.npcCount = 0;

			for (var2 = 0; var2 < var1; ++var2) {
				int var3 = Client.npcIndices[var2];
				NPC var4 = Client.npcs[var3];
				int var5 = var0.readBits(1);
				if (var5 == 0) {
					Client.npcIndices[++Client.npcCount - 1] = var3;
					var4.npcCycle = Client.cycle;
				} else {
					int var6 = var0.readBits(2);
					if (var6 == 0) {
						Client.npcIndices[++Client.npcCount - 1] = var3;
						var4.npcCycle = Client.cycle;
						Client.field720[++Client.field673 - 1] = var3;
					} else {
						int var7;
						int var8;
						if (var6 == 1) {
							Client.npcIndices[++Client.npcCount - 1] = var3;
							var4.npcCycle = Client.cycle;
							var7 = var0.readBits(3);
							var4.method2044(var7, (byte)1);
							var8 = var0.readBits(1);
							if (var8 == 1) {
								Client.field720[++Client.field673 - 1] = var3;
							}
						} else if (var6 == 2) {
							Client.npcIndices[++Client.npcCount - 1] = var3;
							var4.npcCycle = Client.cycle;
							var7 = var0.readBits(3);
							var4.method2044(var7, (byte)2);
							var8 = var0.readBits(3);
							var4.method2044(var8, (byte)2);
							int var9 = var0.readBits(1);
							if (var9 == 1) {
								Client.field720[++Client.field673 - 1] = var3;
							}
						} else if (var6 == 3) {
							Client.field745[++Client.field815 - 1] = var3;
						}
					}
				}
			}

		}
	}
}
