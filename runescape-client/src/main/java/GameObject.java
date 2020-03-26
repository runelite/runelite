import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("ek")
@Implements("GameObject")
public final class GameObject {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1812382241
	)
	@Export("centerY")
	int centerY;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1894508257
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -67995329
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1055464323
	)
	@Export("height")
	int height;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 733420337
	)
	@Export("centerX")
	int centerX;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lee;"
	)
	@Export("entity")
	public Entity entity;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1786771811
	)
	@Export("startX")
	int startX;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 983334103
	)
	@Export("endX")
	int endX;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 364744081
	)
	@Export("startY")
	int startY;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1023700223
	)
	@Export("endY")
	int endY;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1872697875
	)
	int field1950;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -623014369
	)
	@Export("lastDrawn")
	int lastDrawn;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		longValue = 1416033697273847883L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 837500395
	)
	@Export("flags")
	int flags;

	GameObject() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/io/File;Ljava/io/File;S)V",
		garbageValue = "1603"
	)
	public static void method3408(File var0, File var1) {
		try {
			AccessFile var2 = new AccessFile(JagexCache.JagexCache_locationFile, "rw", 10000L);
			Buffer var3 = new Buffer(500);
			var3.writeByte(3);
			var3.writeByte(var1 != null ? 1 : 0);
			var3.writeCESU8(var0.getPath());
			if (var1 != null) {
				var3.writeCESU8("");
			}

			var2.write(var3.array, 0, var3.offset);
			var2.close();
		} catch (IOException var4) {
			var4.printStackTrace();
		}

	}

	@ObfuscatedName("m")
	public static String method3405(long var0) {
		if (var0 > 0L && var0 < 6582952005840035281L) {
			if (var0 % 37L == 0L) {
				return null;
			} else {
				int var2 = 0;

				for (long var3 = var0; var3 != 0L; var3 /= 37L) {
					++var2;
				}

				StringBuilder var5 = new StringBuilder(var2);

				while (var0 != 0L) {
					long var6 = var0;
					var0 /= 37L;
					var5.append(class298.base37Table[(int)(var6 - 37L * var0)]);
				}

				return var5.reverse().toString();
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lkj;I)V",
		garbageValue = "-137749117"
	)
	@Export("performReflectionCheck")
	public static void performReflectionCheck(PacketBuffer var0) {
		ReflectionCheck var1 = (ReflectionCheck)class105.reflectionChecks.last();
		if (var1 != null) {
			int var2 = var0.offset;
			var0.writeInt(var1.id);

			for (int var3 = 0; var3 < var1.size; ++var3) {
				if (var1.creationErrors[var3] != 0) {
					var0.writeByte(var1.creationErrors[var3]);
				} else {
					try {
						int var4 = var1.operations[var3];
						Field var5;
						int var6;
						if (var4 == 0) {
							var5 = var1.fields[var3];
							var6 = Reflection.getInt(var5, (Object)null);
							var0.writeByte(0);
							var0.writeInt(var6);
						} else if (var4 == 1) {
							var5 = var1.fields[var3];
							Reflection.setInt(var5, (Object)null, var1.intReplaceValues[var3]);
							var0.writeByte(0);
						} else if (var4 == 2) {
							var5 = var1.fields[var3];
							var6 = var5.getModifiers();
							var0.writeByte(0);
							var0.writeInt(var6);
						}

						Method var25;
						if (var4 != 3) {
							if (var4 == 4) {
								var25 = var1.methods[var3];
								var6 = var25.getModifiers();
								var0.writeByte(0);
								var0.writeInt(var6);
							}
						} else {
							var25 = var1.methods[var3];
							byte[][] var10 = var1.arguments[var3];
							Object[] var7 = new Object[var10.length];

							for (int var8 = 0; var8 < var10.length; ++var8) {
								ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
								var7[var8] = var9.readObject();
							}

							Object var11 = Reflection.invoke(var25, (Object)null, var7);
							if (var11 == null) {
								var0.writeByte(0);
							} else if (var11 instanceof Number) {
								var0.writeByte(1);
								var0.writeLong(((Number)var11).longValue());
							} else if (var11 instanceof String) {
								var0.writeByte(2);
								var0.writeStringCp1252NullTerminated((String)var11);
							} else {
								var0.writeByte(4);
							}
						}
					} catch (ClassNotFoundException var13) {
						var0.writeByte(-10);
					} catch (InvalidClassException var14) {
						var0.writeByte(-11);
					} catch (StreamCorruptedException var15) {
						var0.writeByte(-12);
					} catch (OptionalDataException var16) {
						var0.writeByte(-13);
					} catch (IllegalAccessException var17) {
						var0.writeByte(-14);
					} catch (IllegalArgumentException var18) {
						var0.writeByte(-15);
					} catch (InvocationTargetException var19) {
						var0.writeByte(-16);
					} catch (SecurityException var20) {
						var0.writeByte(-17);
					} catch (IOException var21) {
						var0.writeByte(-18);
					} catch (NullPointerException var22) {
						var0.writeByte(-19);
					} catch (Exception var23) {
						var0.writeByte(-20);
					} catch (Throwable var24) {
						var0.writeByte(-21);
					}
				}
			}

			var0.writeCrc(var2);
			var1.remove();
		}
	}

	@ObfuscatedName("fw")
	@ObfuscatedSignature(
		signature = "(Lih;Ljava/lang/String;B)V",
		garbageValue = "-1"
	)
	static void method3404(Archive var0, String var1) {
		ArchiveLoader var2 = new ArchiveLoader(var0, var1);
		Client.archiveLoaders.add(var2);
		Client.field898 += var2.groupCount;
	}

	@ObfuscatedName("hy")
	@ObfuscatedSignature(
		signature = "(ZLkj;I)V",
		garbageValue = "1045938723"
	)
	@Export("loadRegions")
	static final void loadRegions(boolean var0, PacketBuffer var1) {
		Client.isInInstance = var0;
		int var3;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		if (!Client.isInInstance) {
			int var2 = var1.readUnsignedShort();
			var3 = var1.method5564();
			var4 = var1.readUnsignedShort();
			UrlRequester.xteaKeys = new int[var4][4];

			for (var5 = 0; var5 < var4; ++var5) {
				for (var6 = 0; var6 < 4; ++var6) {
					UrlRequester.xteaKeys[var5][var6] = var1.readInt();
				}
			}

			StructDefinition.regions = new int[var4];
			KeyHandler.regionMapArchiveIds = new int[var4];
			WorldMapArea.regionLandArchiveIds = new int[var4];
			WorldMapData_0.regionLandArchives = new byte[var4][];
			class23.regionMapArchives = new byte[var4][];
			boolean var16 = false;
			if ((var3 / 8 == 48 || var3 / 8 == 49) && var2 / 8 == 48) {
				var16 = true;
			}

			if (var3 / 8 == 48 && var2 / 8 == 148) {
				var16 = true;
			}

			var4 = 0;

			for (var6 = (var3 - 6) / 8; var6 <= (var3 + 6) / 8; ++var6) {
				for (var7 = (var2 - 6) / 8; var7 <= (var2 + 6) / 8; ++var7) {
					var8 = var7 + (var6 << 8);
					if (!var16 || var7 != 49 && var7 != 149 && var7 != 147 && var6 != 50 && (var6 != 49 || var7 != 47)) {
						StructDefinition.regions[var4] = var8;
						KeyHandler.regionMapArchiveIds[var4] = WorldMapIcon_0.archive5.getGroupId("m" + var6 + "_" + var7);
						WorldMapArea.regionLandArchiveIds[var4] = WorldMapIcon_0.archive5.getGroupId("l" + var6 + "_" + var7);
						++var4;
					}
				}
			}

			GrandExchangeOfferNameComparator.method237(var3, var2, true);
		} else {
			boolean var15 = var1.readUnsignedByte() == 1;
			var3 = var1.method5564();
			var4 = var1.method5614();
			var5 = var1.readUnsignedShort();
			var1.importIndex();

			int var9;
			for (var6 = 0; var6 < 4; ++var6) {
				for (var7 = 0; var7 < 13; ++var7) {
					for (var8 = 0; var8 < 13; ++var8) {
						var9 = var1.readBits(1);
						if (var9 == 1) {
							Client.instanceChunkTemplates[var6][var7][var8] = var1.readBits(26);
						} else {
							Client.instanceChunkTemplates[var6][var7][var8] = -1;
						}
					}
				}
			}

			var1.exportIndex();
			UrlRequester.xteaKeys = new int[var5][4];

			for (var6 = 0; var6 < var5; ++var6) {
				for (var7 = 0; var7 < 4; ++var7) {
					UrlRequester.xteaKeys[var6][var7] = var1.readInt();
				}
			}

			StructDefinition.regions = new int[var5];
			KeyHandler.regionMapArchiveIds = new int[var5];
			WorldMapArea.regionLandArchiveIds = new int[var5];
			WorldMapData_0.regionLandArchives = new byte[var5][];
			class23.regionMapArchives = new byte[var5][];
			var5 = 0;

			for (var6 = 0; var6 < 4; ++var6) {
				for (var7 = 0; var7 < 13; ++var7) {
					for (var8 = 0; var8 < 13; ++var8) {
						var9 = Client.instanceChunkTemplates[var6][var7][var8];
						if (var9 != -1) {
							int var10 = var9 >> 14 & 1023;
							int var11 = var9 >> 3 & 2047;
							int var12 = (var10 / 8 << 8) + var11 / 8;

							int var13;
							for (var13 = 0; var13 < var5; ++var13) {
								if (StructDefinition.regions[var13] == var12) {
									var12 = -1;
									break;
								}
							}

							if (var12 != -1) {
								StructDefinition.regions[var5] = var12;
								var13 = var12 >> 8 & 255;
								int var14 = var12 & 255;
								KeyHandler.regionMapArchiveIds[var5] = WorldMapIcon_0.archive5.getGroupId("m" + var13 + "_" + var14);
								WorldMapArea.regionLandArchiveIds[var5] = WorldMapIcon_0.archive5.getGroupId("l" + var13 + "_" + var14);
								++var5;
							}
						}
					}
				}
			}

			GrandExchangeOfferNameComparator.method237(var3, var4, !var15);
		}

	}
}
