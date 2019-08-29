import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
@Implements("TilePaint")
public final class TilePaint {
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1005153033
	)
	@Export("swColor")
	int swColor;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -62371409
	)
	@Export("seColor")
	int seColor;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 732641473
	)
	@Export("neColor")
	int neColor;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1434155121
	)
	@Export("nwColor")
	int nwColor;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 974605461
	)
	@Export("texture")
	int texture;
	@ObfuscatedName("n")
	@Export("isFlat")
	boolean isFlat;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1074682835
	)
	@Export("rgb")
	int rgb;

	TilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
		this.isFlat = true;
		this.swColor = var1;
		this.seColor = var2;
		this.neColor = var3;
		this.nwColor = var4;
		this.texture = var5;
		this.rgb = var6;
		this.isFlat = var7;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-2050253727"
	)
	public static boolean method3007() {
		long var0 = SequenceDefinition.method4686();
		int var2 = (int)(var0 - NetCache.field3145);
		NetCache.field3145 = var0;
		if (var2 > 200) {
			var2 = 200;
		}

		NetCache.NetCache_loadTime += var2;
		if (NetCache.NetCache_pendingResponsesCount == 0 && NetCache.NetCache_pendingPriorityResponsesCount == 0 && NetCache.NetCache_pendingWritesCount == 0 && NetCache.NetCache_pendingPriorityWritesCount == 0) {
			return true;
		} else if (NetCache.NetCache_socket == null) {
			return false;
		} else {
			try {
				if (NetCache.NetCache_loadTime > 30000) {
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

						NetCache.NetCache_loadTime = 0;
						byte var5 = 0;
						if (NetCache.NetCache_currentResponse == null) {
							var5 = 8;
						} else if (NetCache.field3156 == 0) {
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
							if (NetCache.field3159 != 0) {
								for (var7 = 0; var7 < var6; ++var7) {
									var10000 = NetCache.NetCache_responseHeaderBuffer.array;
									var10001 = var7 + NetCache.NetCache_responseHeaderBuffer.offset;
									var10000[var10001] ^= NetCache.field3159;
								}
							}

							var22 = NetCache.NetCache_responseHeaderBuffer;
							var22.offset += var6;
							if (NetCache.NetCache_responseHeaderBuffer.offset < var5) {
								break;
							}

							if (NetCache.NetCache_currentResponse == null) {
								NetCache.NetCache_responseHeaderBuffer.offset = 0;
								var7 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
								var8 = NetCache.NetCache_responseHeaderBuffer.readUnsignedShort();
								int var9 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
								var10 = NetCache.NetCache_responseHeaderBuffer.readInt();
								long var11 = (long)(var8 + (var7 << 16));
								NetFileRequest var13 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.get(var11);
								Huffman.field2486 = true;
								if (var13 == null) {
									var13 = (NetFileRequest)NetCache.NetCache_pendingResponses.get(var11);
									Huffman.field2486 = false;
								}

								if (var13 == null) {
									throw new IOException();
								}

								int var14 = var9 == 0 ? 5 : 9;
								NetCache.NetCache_currentResponse = var13;
								NetCache.NetCache_responseArchiveBuffer = new Buffer(var14 + var10 + NetCache.NetCache_currentResponse.padding);
								NetCache.NetCache_responseArchiveBuffer.writeByte(var9);
								NetCache.NetCache_responseArchiveBuffer.writeInt(var10);
								NetCache.field3156 = 8;
								NetCache.NetCache_responseHeaderBuffer.offset = 0;
							} else if (NetCache.field3156 == 0) {
								if (NetCache.NetCache_responseHeaderBuffer.array[0] == -1) {
									NetCache.field3156 = 1;
									NetCache.NetCache_responseHeaderBuffer.offset = 0;
								} else {
									NetCache.NetCache_currentResponse = null;
								}
							}
						} else {
							var6 = NetCache.NetCache_responseArchiveBuffer.array.length - NetCache.NetCache_currentResponse.padding;
							var7 = 512 - NetCache.field3156;
							if (var7 > var6 - NetCache.NetCache_responseArchiveBuffer.offset) {
								var7 = var6 - NetCache.NetCache_responseArchiveBuffer.offset;
							}

							if (var7 > var16) {
								var7 = var16;
							}

							NetCache.NetCache_socket.read(NetCache.NetCache_responseArchiveBuffer.array, NetCache.NetCache_responseArchiveBuffer.offset, var7);
							if (NetCache.field3159 != 0) {
								for (var8 = 0; var8 < var7; ++var8) {
									var10000 = NetCache.NetCache_responseArchiveBuffer.array;
									var10001 = NetCache.NetCache_responseArchiveBuffer.offset + var8;
									var10000[var10001] ^= NetCache.field3159;
								}
							}

							var22 = NetCache.NetCache_responseArchiveBuffer;
							var22.offset += var7;
							NetCache.field3156 += var7;
							if (var6 == NetCache.NetCache_responseArchiveBuffer.offset) {
								if (NetCache.NetCache_currentResponse.key == 16711935L) {
									Decimator.NetCache_reference = NetCache.NetCache_responseArchiveBuffer;

									for (var8 = 0; var8 < 256; ++var8) {
										Archive var17 = NetCache.NetCache_archives[var8];
										if (var17 != null) {
											Decimator.NetCache_reference.offset = var8 * 8 + 5;
											var10 = Decimator.NetCache_reference.readInt();
											int var18 = Decimator.NetCache_reference.readInt();
											var17.loadIndex(var10, var18);
										}
									}
								} else {
									NetCache.NetCache_crc.reset();
									NetCache.NetCache_crc.update(NetCache.NetCache_responseArchiveBuffer.array, 0, var6);
									var8 = (int)NetCache.NetCache_crc.getValue();
									if (var8 != NetCache.NetCache_currentResponse.crc) {
										try {
											NetCache.NetCache_socket.close();
										} catch (Exception var20) {
										}

										++NetCache.NetCache_crcMismatches;
										NetCache.NetCache_socket = null;
										NetCache.field3159 = (byte)((int)(Math.random() * 255.0D + 1.0D));
										return false;
									}

									NetCache.NetCache_crcMismatches = 0;
									NetCache.NetCache_ioExceptions = 0;
									NetCache.NetCache_currentResponse.archive.write((int)(NetCache.NetCache_currentResponse.key & 65535L), NetCache.NetCache_responseArchiveBuffer.array, (NetCache.NetCache_currentResponse.key & 16711680L) == 16711680L, Huffman.field2486);
								}

								NetCache.NetCache_currentResponse.remove();
								if (Huffman.field2486) {
									--NetCache.NetCache_pendingPriorityResponsesCount;
								} else {
									--NetCache.NetCache_pendingResponsesCount;
								}

								NetCache.field3156 = 0;
								NetCache.NetCache_currentResponse = null;
								NetCache.NetCache_responseArchiveBuffer = null;
							} else {
								if (NetCache.field3156 != 512) {
									break;
								}

								NetCache.field3156 = 0;
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

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lhz;III)Lls;",
		garbageValue = "869538043"
	)
	@Export("SpriteBuffer_getSprite")
	public static Sprite SpriteBuffer_getSprite(AbstractArchive var0, int var1, int var2) {
		if (!World.SpriteBuffer_bufferFile(var0, var1, var2)) {
			return null;
		} else {
			Sprite var4 = new Sprite();
			var4.width = GrandExchangeOfferUnitPriceComparator.SpriteBuffer_spriteWidth;
			var4.height = class325.SpriteBuffer_spriteHeight;
			var4.xOffset = class325.SpriteBuffer_xOffsets[0];
			var4.yOffset = class325.SpriteBuffer_yOffsets[0];
			var4.subWidth = class325.SpriteBuffer_spriteWidths[0];
			var4.subHeight = class225.SpriteBuffer_spriteHeights[0];
			int var5 = var4.subHeight * var4.subWidth;
			byte[] var6 = WorldMapSection1.SpriteBuffer_pixels[0];
			var4.pixels = new int[var5];

			for (int var7 = 0; var7 < var5; ++var7) {
				var4.pixels[var7] = class325.SpriteBuffer_spritePalette[var6[var7] & 255];
			}

			UserComparator7.SpriteBuffer_clear();
			return var4;
		}
	}

	@ObfuscatedName("ez")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "812603626"
	)
	static void method3005(int var0, int var1) {
		int[] var2 = new int[9];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			int var4 = var3 * 32 + 15 + 128;
			int var5 = var4 * 3 + 600;
			int var7 = Rasterizer3D.Rasterizer3D_sine[var4];
			int var6 = ArchiveLoader.method1100(var5, var1);
			var2[var3] = var6 * var7 >> 16;
		}

		Scene.Scene_buildVisiblityMap(var2, 500, 800, var0 * 334 / var1, 334);
	}
}
