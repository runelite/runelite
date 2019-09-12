import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
@Implements("WorldMapElement")
public class WorldMapElement extends DualNode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("WorldMapElement_archive")
	public static AbstractArchive WorldMapElement_archive;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "[Liu;"
	)
	@Export("WorldMapElement_cached")
	public static WorldMapElement[] WorldMapElement_cached;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 471217631
	)
	@Export("WorldMapElement_count")
	public static int WorldMapElement_count;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Let;"
	)
	@Export("WorldMapElement_cachedSprites")
	static EvictingDualNodeHashTable WorldMapElement_cachedSprites;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1264216493
	)
	@Export("objectId")
	public final int objectId;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -617299153
	)
	@Export("sprite1")
	public int sprite1;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 599415769
	)
	@Export("sprite2")
	int sprite2;
	@ObfuscatedName("v")
	@Export("name")
	public String name;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -732973265
	)
	public int field3195;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -215017427
	)
	@Export("textSize")
	public int textSize;
	@ObfuscatedName("h")
	@Export("menuActions")
	public String[] menuActions;
	@ObfuscatedName("f")
	@Export("menuTargetName")
	public String menuTargetName;
	@ObfuscatedName("s")
	int[] field3183;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -391425933
	)
	int field3194;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1176780449
	)
	int field3198;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 284270197
	)
	int field3199;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -572189601
	)
	int field3200;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("horizontalAlignment")
	public HorizontalAlignment horizontalAlignment;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("verticalAlignment")
	public VerticalAlignment verticalAlignment;
	@ObfuscatedName("k")
	int[] field3203;
	@ObfuscatedName("w")
	byte[] field3204;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1900378841
	)
	@Export("category")
	public int category;

	static {
		WorldMapElement_cachedSprites = new EvictingDualNodeHashTable(256);
	}

	public WorldMapElement(int var1) {
		this.sprite1 = -1;
		this.sprite2 = -1;
		this.textSize = 0;
		this.menuActions = new String[5];
		this.field3194 = Integer.MAX_VALUE;
		this.field3198 = Integer.MAX_VALUE;
		this.field3199 = Integer.MIN_VALUE;
		this.field3200 = Integer.MIN_VALUE;
		this.horizontalAlignment = HorizontalAlignment.HorizontalAlignment_centered;
		this.verticalAlignment = VerticalAlignment.VerticalAlignment_centered;
		this.category = -1;
		this.objectId = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "-766770853"
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
		signature = "(Lkz;II)V",
		garbageValue = "801744823"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.sprite1 = var1.method5623();
		} else if (var2 == 2) {
			this.sprite2 = var1.method5623();
		} else if (var2 == 3) {
			this.name = var1.readStringCp1252NullTerminated();
		} else if (var2 == 4) {
			this.field3195 = var1.readMedium();
		} else if (var2 == 5) {
			var1.readMedium();
		} else if (var2 == 6) {
			this.textSize = var1.readUnsignedByte();
		} else {
			int var3;
			if (var2 == 7) {
				var3 = var1.readUnsignedByte();
				if ((var3 & 1) == 0) {
				}

				if ((var3 & 2) == 2) {
				}
			} else if (var2 == 8) {
				var1.readUnsignedByte();
			} else if (var2 >= 10 && var2 <= 14) {
				this.menuActions[var2 - 10] = var1.readStringCp1252NullTerminated();
			} else if (var2 == 15) {
				var3 = var1.readUnsignedByte();
				this.field3183 = new int[var3 * 2];

				int var4;
				for (var4 = 0; var4 < var3 * 2; ++var4) {
					this.field3183[var4] = var1.readShort();
				}

				var1.readInt();
				var4 = var1.readUnsignedByte();
				this.field3203 = new int[var4];

				int var5;
				for (var5 = 0; var5 < this.field3203.length; ++var5) {
					this.field3203[var5] = var1.readInt();
				}

				this.field3204 = new byte[var3];

				for (var5 = 0; var5 < var3; ++var5) {
					this.field3204[var5] = var1.readByte();
				}
			} else if (var2 != 16) {
				if (var2 == 17) {
					this.menuTargetName = var1.readStringCp1252NullTerminated();
				} else if (var2 == 18) {
					var1.method5623();
				} else if (var2 == 19) {
					this.category = var1.readUnsignedShort();
				} else if (var2 == 21) {
					var1.readInt();
				} else if (var2 == 22) {
					var1.readInt();
				} else if (var2 == 23) {
					var1.readUnsignedByte();
					var1.readUnsignedByte();
					var1.readUnsignedByte();
				} else if (var2 == 24) {
					var1.readShort();
					var1.readShort();
				} else if (var2 == 25) {
					var1.method5623();
				} else if (var2 == 28) {
					var1.readUnsignedByte();
				} else if (var2 == 29) {
					this.horizontalAlignment = (HorizontalAlignment)ServerPacket.findEnumerated(VarcInt.method4396(), var1.readUnsignedByte());
				} else if (var2 == 30) {
					this.verticalAlignment = (VerticalAlignment)ServerPacket.findEnumerated(ItemContainer.method1120(), var1.readUnsignedByte());
				}
			}
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1597557891"
	)
	public void method4378() {
		if (this.field3183 != null) {
			for (int var1 = 0; var1 < this.field3183.length; var1 += 2) {
				if (this.field3183[var1] < this.field3194) {
					this.field3194 = this.field3183[var1];
				} else if (this.field3183[var1] > this.field3199) {
					this.field3199 = this.field3183[var1];
				}

				if (this.field3183[var1 + 1] < this.field3198) {
					this.field3198 = this.field3183[var1 + 1];
				} else if (this.field3183[var1 + 1] > this.field3200) {
					this.field3200 = this.field3183[var1 + 1];
				}
			}
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(ZB)Lli;",
		garbageValue = "24"
	)
	@Export("getSpriteBool")
	public Sprite getSpriteBool(boolean var1) {
		int var2 = this.sprite1;
		return this.getSprite(var2);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IB)Lli;",
		garbageValue = "37"
	)
	@Export("getSprite")
	Sprite getSprite(int var1) {
		if (var1 < 0) {
			return null;
		} else {
			Sprite var2 = (Sprite)WorldMapElement_cachedSprites.get((long)var1);
			if (var2 != null) {
				return var2;
			} else {
				var2 = FillMode.SpriteBuffer_getSprite(WorldMapElement_archive, var1, 0);
				if (var2 != null) {
					WorldMapElement_cachedSprites.put(var2, (long)var1);
				}

				return var2;
			}
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-854181096"
	)
	@Export("getObjectId")
	public int getObjectId() {
		return this.objectId;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "-13"
	)
	public static int method4390(int var0) {
		return var0 >> 11 & 63;
	}

	@ObfuscatedName("hi")
	@ObfuscatedSignature(
		signature = "(ZLkt;B)V",
		garbageValue = "-4"
	)
	@Export("updateNpcs")
	static final void updateNpcs(boolean var0, PacketBuffer var1) {
		Client.field742 = 0;
		Client.field666 = 0;
		PacketBuffer var2 = Client.packetWriter.packetBuffer;
		var2.importIndex();
		int var3 = var2.readBits(8);
		int var4;
		if (var3 < Client.npcCount) {
			for (var4 = var3; var4 < Client.npcCount; ++var4) {
				Client.field731[++Client.field742 - 1] = Client.npcIndices[var4];
			}
		}

		if (var3 > Client.npcCount) {
			throw new RuntimeException("");
		} else {
			Client.npcCount = 0;

			for (var4 = 0; var4 < var3; ++var4) {
				int var5 = Client.npcIndices[var4];
				NPC var6 = Client.npcs[var5];
				int var7 = var2.readBits(1);
				if (var7 == 0) {
					Client.npcIndices[++Client.npcCount - 1] = var5;
					var6.npcCycle = Client.cycle;
				} else {
					int var8 = var2.readBits(2);
					if (var8 == 0) {
						Client.npcIndices[++Client.npcCount - 1] = var5;
						var6.npcCycle = Client.cycle;
						Client.field881[++Client.field666 - 1] = var5;
					} else {
						int var9;
						int var10;
						if (var8 == 1) {
							Client.npcIndices[++Client.npcCount - 1] = var5;
							var6.npcCycle = Client.cycle;
							var9 = var2.readBits(3);
							var6.method2010(var9, (byte)1);
							var10 = var2.readBits(1);
							if (var10 == 1) {
								Client.field881[++Client.field666 - 1] = var5;
							}
						} else if (var8 == 2) {
							Client.npcIndices[++Client.npcCount - 1] = var5;
							var6.npcCycle = Client.cycle;
							var9 = var2.readBits(3);
							var6.method2010(var9, (byte)2);
							var10 = var2.readBits(3);
							var6.method2010(var10, (byte)2);
							int var11 = var2.readBits(1);
							if (var11 == 1) {
								Client.field881[++Client.field666 - 1] = var5;
							}
						} else if (var8 == 3) {
							Client.field731[++Client.field742 - 1] = var5;
						}
					}
				}
			}

			class1.method15(var0, var1);
			ObjectSound.method1888(var1);

			int var12;
			for (var12 = 0; var12 < Client.field742; ++var12) {
				var3 = Client.field731[var12];
				if (Client.npcs[var3].npcCycle != Client.cycle) {
					Client.npcs[var3].definition = null;
					Client.npcs[var3] = null;
				}
			}

			if (var1.offset != Client.packetWriter.serverPacketLength) {
				throw new RuntimeException(var1.offset + "," + Client.packetWriter.serverPacketLength);
			} else {
				for (var12 = 0; var12 < Client.npcCount; ++var12) {
					if (Client.npcs[Client.npcIndices[var12]] == null) {
						throw new RuntimeException(var12 + "," + Client.npcCount);
					}
				}

			}
		}
	}

	@ObfuscatedName("hs")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-1891347440"
	)
	static final void method4392(int var0, int var1, int var2, int var3) {
		for (int var4 = 0; var4 < Client.rootWidgetCount; ++var4) {
			if (Client.rootWidgetXs[var4] + Client.rootWidgetWidths[var4] > var0 && Client.rootWidgetXs[var4] < var0 + var2 && Client.rootWidgetHeights[var4] + Client.rootWidgetYs[var4] > var1 && Client.rootWidgetYs[var4] < var3 + var1) {
				Client.field828[var4] = true;
			}
		}

	}
}
