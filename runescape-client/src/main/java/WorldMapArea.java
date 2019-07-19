import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("WorldMapArea")
public class WorldMapArea {
	@ObfuscatedName("bo")
	static String field213;
	@ObfuscatedName("hc")
	@ObfuscatedGetter(
		intValue = 143213649
	)
	@Export("oculusOrbFocalPointY")
	static int oculusOrbFocalPointY;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1977211607
	)
	@Export("id")
	int id;
	@ObfuscatedName("w")
	@Export("internalName")
	String internalName;
	@ObfuscatedName("e")
	@Export("externalName")
	String externalName;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -162659739
	)
	@Export("backGroundColor")
	int backGroundColor;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 19158817
	)
	@Export("zoom")
	int zoom;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	@Export("origin")
	Coord origin;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1024999231
	)
	@Export("regionLowX")
	int regionLowX;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1660950761
	)
	@Export("regionHighX")
	int regionHighX;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1294876503
	)
	@Export("regionLowY")
	int regionLowY;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -341254141
	)
	@Export("regionHighY")
	int regionHighY;
	@ObfuscatedName("m")
	@Export("isMain")
	boolean isMain;
	@ObfuscatedName("u")
	@Export("sections")
	LinkedList sections;

	public WorldMapArea() {
		this.id = -1;
		this.backGroundColor = -1;
		this.zoom = -1;
		this.origin = null;
		this.regionLowX = Integer.MAX_VALUE;
		this.regionHighX = 0;
		this.regionLowY = Integer.MAX_VALUE;
		this.regionHighY = 0;
		this.isMain = false;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lkf;IB)V",
		garbageValue = "0"
	)
	@Export("read")
	public void read(Buffer var1, int var2) {
		this.id = var2;
		this.internalName = var1.readStringCp1252NullTerminated();
		this.externalName = var1.readStringCp1252NullTerminated();
		this.origin = new Coord(var1.readInt());
		this.backGroundColor = var1.readInt();
		var1.readUnsignedByte();
		this.isMain = var1.readUnsignedByte() == 1;
		this.zoom = var1.readUnsignedByte();
		int var3 = var1.readUnsignedByte();
		this.sections = new LinkedList();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.sections.add(this.readWorldMapSection(var1));
		}

		this.setBounds();
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkf;I)Laj;",
		garbageValue = "-1426808810"
	)
	@Export("readWorldMapSection")
	WorldMapSection readWorldMapSection(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		WorldMapSectionType[] var3 = new WorldMapSectionType[]{WorldMapSectionType.WORLDMAPSECTIONTYPE3, WorldMapSectionType.WORLDMAPSECTIONTYPE1, WorldMapSectionType.WORLDMAPSECTIONTYPE0, WorldMapSectionType.WORLDMAPSECTIONTYPE2};
		WorldMapSectionType var4 = (WorldMapSectionType)SoundSystem.findEnumerated(var3, var2);
		Object var5 = null;
		switch(var4.type) {
		case 0:
			var5 = new WorldMapSection0();
			break;
		case 1:
			var5 = new WorldMapSection2();
			break;
		case 2:
			var5 = new WorldMapSection1();
			break;
		case 3:
			var5 = new class42();
			break;
		default:
			throw new IllegalStateException("");
		}

		((WorldMapSection)var5).read(var1);
		return (WorldMapSection)var5;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "772882794"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		Iterator var4 = this.sections.iterator();

		WorldMapSection var5;
		do {
			if (!var4.hasNext()) {
				return false;
			}

			var5 = (WorldMapSection)var4.next();
		} while(!var5.containsCoord(var1, var2, var3));

		return true;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "431640899"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		int var3 = var1 / 64;
		int var4 = var2 / 64;
		if (var3 >= this.regionLowX && var3 <= this.regionHighX) {
			if (var4 >= this.regionLowY && var4 <= this.regionHighY) {
				Iterator var5 = this.sections.iterator();

				WorldMapSection var6;
				do {
					if (!var5.hasNext()) {
						return false;
					}

					var6 = (WorldMapSection)var5.next();
				} while(!var6.containsPosition(var1, var2));

				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "1197175712"
	)
	@Export("position")
	public int[] position(int var1, int var2, int var3) {
		Iterator var4 = this.sections.iterator();

		WorldMapSection var5;
		do {
			if (!var4.hasNext()) {
				return null;
			}

			var5 = (WorldMapSection)var4.next();
		} while(!var5.containsCoord(var1, var2, var3));

		return var5.getBorderTileLengths(var1, var2, var3);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(III)Lhv;",
		garbageValue = "1177032245"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		Iterator var3 = this.sections.iterator();

		WorldMapSection var4;
		do {
			if (!var3.hasNext()) {
				return null;
			}

			var4 = (WorldMapSection)var3.next();
		} while(!var4.containsPosition(var1, var2));

		return var4.coord(var1, var2);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1983561837"
	)
	@Export("setBounds")
	void setBounds() {
		Iterator var1 = this.sections.iterator();

		while (var1.hasNext()) {
			WorldMapSection var2 = (WorldMapSection)var1.next();
			var2.expandBounds(this);
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "11"
	)
	@Export("getId")
	public int getId() {
		return this.id;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1524903705"
	)
	@Export("getIsMain")
	public boolean getIsMain() {
		return this.isMain;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "-229522962"
	)
	@Export("getInternalName")
	public String getInternalName() {
		return this.internalName;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "-1054173331"
	)
	@Export("getExternalName")
	public String getExternalName() {
		return this.externalName;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-26"
	)
	@Export("getBackGroundColor")
	int getBackGroundColor() {
		return this.backGroundColor;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "459716843"
	)
	@Export("getZoom")
	public int getZoom() {
		return this.zoom;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1607087713"
	)
	@Export("getRegionLowX")
	public int getRegionLowX() {
		return this.regionLowX;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1992426641"
	)
	@Export("getRegionHighX")
	public int getRegionHighX() {
		return this.regionHighX;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "426909580"
	)
	@Export("getRegionLowY")
	public int getRegionLowY() {
		return this.regionLowY;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-308162102"
	)
	@Export("getRegionHighY")
	public int getRegionHighY() {
		return this.regionHighY;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-30"
	)
	@Export("getOriginX")
	public int getOriginX() {
		return this.origin.x;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1111611912"
	)
	@Export("getOriginPlane")
	public int getOriginPlane() {
		return this.origin.plane;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-16"
	)
	@Export("getOriginY")
	public int getOriginY() {
		return this.origin.y;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Lhv;",
		garbageValue = "1084515082"
	)
	@Export("getOrigin")
	public Coord getOrigin() {
		return new Coord(this.origin);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(II)Liq;",
		garbageValue = "44972047"
	)
	@Export("getItemDefinition")
	public static ItemDefinition getItemDefinition(int var0) {
		ItemDefinition var1 = (ItemDefinition)ItemDefinition.ItemDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = Messages.ItemDefinition_archive.takeFile(10, var0);
			var1 = new ItemDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.post();
			if (var1.noteTemplate != -1) {
				var1.genCert(getItemDefinition(var1.noteTemplate), getItemDefinition(var1.note));
			}

			if (var1.notedId != -1) {
				var1.genBought(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
			}

			if (var1.placeholderTemplate != -1) {
				var1.genPlaceholder(getItemDefinition(var1.placeholderTemplate), getItemDefinition(var1.placeholder));
			}

			if (!ModelData0.inMembersWorld && var1.isMembersOnly) {
				var1.name = "Members object";
				var1.isTradable = false;
				var1.groundActions = null;
				var1.inventoryActions = null;
				var1.shiftClickIndex = -1;
				var1.team = 0;
				if (var1.params != null) {
					boolean var3 = false;

					for (Node var4 = var1.params.first(); var4 != null; var4 = var1.params.next()) {
						ParamDefinition var5 = WorldMapIcon_0.getParamDefinition((int)var4.key);
						if (var5.autoDisable) {
							var4.remove();
						} else {
							var3 = true;
						}
					}

					if (!var3) {
						var1.params = null;
					}
				}
			}

			ItemDefinition.ItemDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-296796650"
	)
	public static boolean method365() {
		long var0 = DirectByteArrayCopier.currentTimeMs();
		int var2 = (int)(var0 - NetCache.field3169);
		NetCache.field3169 = var0;
		if (var2 > 200) {
			var2 = 200;
		}

		NetCache.field3163 += var2;
		if (NetCache.NetCache_pendingResponsesCount == 0 && NetCache.NetCache_pendingPriorityResponsesCount == 0 && NetCache.NetCache_pendingWritesCount == 0 && NetCache.NetCache_pendingPriorityWritesCount == 0) {
			return true;
		} else if (NetCache.NetCache_socket == null) {
			return false;
		} else {
			try {
				if (NetCache.field3163 > 30000) {
					throw new IOException();
				} else {
					NetFileRequest var3;
					Buffer var4;
					while (NetCache.NetCache_pendingPriorityResponsesCount < 200 && NetCache.NetCache_pendingPriorityWritesCount > 0) {
						var3 = (NetFileRequest)NetCache.NetCache_pendingPriorityWrites.first();
						var4 = new Buffer(4);
						var4.writeByte(1);
						var4.writeMedium((int)var3.key);
						NetCache.NetCache_socket.write(var4.array, 0, 4);
						NetCache.NetCache_pendingPriorityResponses.put(var3, var3.key);
						--NetCache.NetCache_pendingPriorityWritesCount;
						++NetCache.NetCache_pendingPriorityResponsesCount;
					}

					while (NetCache.NetCache_pendingResponsesCount < 200 && NetCache.NetCache_pendingWritesCount > 0) {
						var3 = (NetFileRequest)NetCache.NetCache_pendingWritesQueue.removeLast();
						var4 = new Buffer(4);
						var4.writeByte(0);
						var4.writeMedium((int)var3.key);
						NetCache.NetCache_socket.write(var4.array, 0, 4);
						var3.removeDual();
						NetCache.NetCache_pendingResponses.put(var3, var3.key);
						--NetCache.NetCache_pendingWritesCount;
						++NetCache.NetCache_pendingResponsesCount;
					}

					for (int var15 = 0; var15 < 100; ++var15) {
						int var16 = NetCache.NetCache_socket.available();
						if (var16 < 0) {
							throw new IOException();
						}

						if (var16 == 0) {
							break;
						}

						NetCache.field3163 = 0;
						byte var5 = 0;
						if (class226.NetCache_currentResponse == null) {
							var5 = 8;
						} else if (NetCache.field3175 == 0) {
							var5 = 1;
						}

						int var6;
						int var7;
						int var8;
						int var10;
						byte[] var10000;
						int var10001;
						Buffer var22;
						if (var5 > 0) {
							var6 = var5 - NetCache.NetCache_responseHeaderBuffer.offset;
							if (var6 > var16) {
								var6 = var16;
							}

							NetCache.NetCache_socket.read(NetCache.NetCache_responseHeaderBuffer.array, NetCache.NetCache_responseHeaderBuffer.offset, var6);
							if (NetCache.field3181 != 0) {
								for (var7 = 0; var7 < var6; ++var7) {
									var10000 = NetCache.NetCache_responseHeaderBuffer.array;
									var10001 = var7 + NetCache.NetCache_responseHeaderBuffer.offset;
									var10000[var10001] ^= NetCache.field3181;
								}
							}

							var22 = NetCache.NetCache_responseHeaderBuffer;
							var22.offset += var6;
							if (NetCache.NetCache_responseHeaderBuffer.offset < var5) {
								break;
							}

							if (class226.NetCache_currentResponse == null) {
								NetCache.NetCache_responseHeaderBuffer.offset = 0;
								var7 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
								var8 = NetCache.NetCache_responseHeaderBuffer.readUnsignedShort();
								int var9 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
								var10 = NetCache.NetCache_responseHeaderBuffer.readInt();
								long var11 = (long)(var8 + (var7 << 16));
								NetFileRequest var13 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.get(var11);
								class215.field2545 = true;
								if (var13 == null) {
									var13 = (NetFileRequest)NetCache.NetCache_pendingResponses.get(var11);
									class215.field2545 = false;
								}

								if (var13 == null) {
									throw new IOException();
								}

								int var14 = var9 == 0 ? 5 : 9;
								class226.NetCache_currentResponse = var13;
								VarpDefinition.NetCache_responseArchiveBuffer = new Buffer(var14 + var10 + class226.NetCache_currentResponse.padding);
								VarpDefinition.NetCache_responseArchiveBuffer.writeByte(var9);
								VarpDefinition.NetCache_responseArchiveBuffer.writeInt(var10);
								NetCache.field3175 = 8;
								NetCache.NetCache_responseHeaderBuffer.offset = 0;
							} else if (NetCache.field3175 == 0) {
								if (NetCache.NetCache_responseHeaderBuffer.array[0] == -1) {
									NetCache.field3175 = 1;
									NetCache.NetCache_responseHeaderBuffer.offset = 0;
								} else {
									class226.NetCache_currentResponse = null;
								}
							}
						} else {
							var6 = VarpDefinition.NetCache_responseArchiveBuffer.array.length - class226.NetCache_currentResponse.padding;
							var7 = 512 - NetCache.field3175;
							if (var7 > var6 - VarpDefinition.NetCache_responseArchiveBuffer.offset) {
								var7 = var6 - VarpDefinition.NetCache_responseArchiveBuffer.offset;
							}

							if (var7 > var16) {
								var7 = var16;
							}

							NetCache.NetCache_socket.read(VarpDefinition.NetCache_responseArchiveBuffer.array, VarpDefinition.NetCache_responseArchiveBuffer.offset, var7);
							if (NetCache.field3181 != 0) {
								for (var8 = 0; var8 < var7; ++var8) {
									var10000 = VarpDefinition.NetCache_responseArchiveBuffer.array;
									var10001 = VarpDefinition.NetCache_responseArchiveBuffer.offset + var8;
									var10000[var10001] ^= NetCache.field3181;
								}
							}

							var22 = VarpDefinition.NetCache_responseArchiveBuffer;
							var22.offset += var7;
							NetCache.field3175 += var7;
							if (var6 == VarpDefinition.NetCache_responseArchiveBuffer.offset) {
								if (16711935L == class226.NetCache_currentResponse.key) {
									AbstractRasterProvider.NetCache_reference = VarpDefinition.NetCache_responseArchiveBuffer;

									for (var8 = 0; var8 < 256; ++var8) {
										Archive var17 = NetCache.NetCache_archives[var8];
										if (var17 != null) {
											AbstractRasterProvider.NetCache_reference.offset = var8 * 8 + 5;
											var10 = AbstractRasterProvider.NetCache_reference.readInt();
											int var18 = AbstractRasterProvider.NetCache_reference.readInt();
											var17.loadIndex(var10, var18);
										}
									}
								} else {
									NetCache.NetCache_crc.reset();
									NetCache.NetCache_crc.update(VarpDefinition.NetCache_responseArchiveBuffer.array, 0, var6);
									var8 = (int)NetCache.NetCache_crc.getValue();
									if (var8 != class226.NetCache_currentResponse.crc) {
										try {
											NetCache.NetCache_socket.close();
										} catch (Exception var20) {
										}

										++NetCache.NetCache_crcMismatches;
										NetCache.NetCache_socket = null;
										NetCache.field3181 = (byte)((int)(Math.random() * 255.0D + 1.0D));
										return false;
									}

									NetCache.NetCache_crcMismatches = 0;
									NetCache.NetCache_ioExceptions = 0;
									class226.NetCache_currentResponse.archive.write((int)(class226.NetCache_currentResponse.key & 65535L), VarpDefinition.NetCache_responseArchiveBuffer.array, (class226.NetCache_currentResponse.key & 16711680L) == 16711680L, class215.field2545);
								}

								class226.NetCache_currentResponse.remove();
								if (class215.field2545) {
									--NetCache.NetCache_pendingPriorityResponsesCount;
								} else {
									--NetCache.NetCache_pendingResponsesCount;
								}

								NetCache.field3175 = 0;
								class226.NetCache_currentResponse = null;
								VarpDefinition.NetCache_responseArchiveBuffer = null;
							} else {
								if (NetCache.field3175 != 512) {
									break;
								}

								NetCache.field3175 = 0;
							}
						}
					}

					return true;
				}
			} catch (IOException var21) {
				try {
					NetCache.NetCache_socket.close();
				} catch (Exception var19) {
				}

				++NetCache.NetCache_ioExceptions;
				NetCache.NetCache_socket = null;
				return false;
			}
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lkf;Lla;I)Lla;",
		garbageValue = "-2066495425"
	)
	@Export("readStringIntParameters")
	static final IterableNodeHashTable readStringIntParameters(Buffer var0, IterableNodeHashTable var1) {
		int var2 = var0.readUnsignedByte();
		int var3;
		if (var1 == null) {
			int var4 = var2 - 1;
			var4 |= var4 >>> 1;
			var4 |= var4 >>> 2;
			var4 |= var4 >>> 4;
			var4 |= var4 >>> 8;
			var4 |= var4 >>> 16;
			var3 = var4 + 1;
			var1 = new IterableNodeHashTable(var3);
		}

		for (var3 = 0; var3 < var2; ++var3) {
			boolean var7 = var0.readUnsignedByte() == 1;
			int var5 = var0.readMedium();
			Object var6;
			if (var7) {
				var6 = new ObjectNode(var0.readStringCp1252NullTerminated());
			} else {
				var6 = new IntegerNode(var0.readInt());
			}

			var1.put((Node)var6, (long)var5);
		}

		return var1;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(CLgu;I)I",
		garbageValue = "-2081105774"
	)
	static int method387(char var0, class190 var1) {
		int var2 = var0 << 4;
		if (Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
			var0 = Character.toLowerCase(var0);
			var2 = (var0 << 4) + 1;
		}

		if (var0 == 241 && var1 == class190.field2350) {
			var2 = 1762;
		}

		return var2;
	}
}
