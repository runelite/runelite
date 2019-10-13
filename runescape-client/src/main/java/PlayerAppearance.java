import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
@Implements("PlayerAppearance")
public class PlayerAppearance {
	@ObfuscatedName("m")
	public static short[][] field2519;
	@ObfuscatedName("y")
	public static short[] field2525;
	@ObfuscatedName("c")
	@Export("equipmentIndices")
	static final int[] equipmentIndices;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("PlayerAppearance_cachedModels")
	static EvictingDualNodeHashTable PlayerAppearance_cachedModels;
	@ObfuscatedName("z")
	@Export("equipment")
	int[] equipment;
	@ObfuscatedName("n")
	@Export("bodyColors")
	int[] bodyColors;
	@ObfuscatedName("v")
	@Export("isFemale")
	public boolean isFemale;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 297413953
	)
	@Export("npcTransformId")
	public int npcTransformId;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		longValue = 720398240330286877L
	)
	long field2526;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		longValue = -4457276035074261541L
	)
	long field2522;

	static {
		equipmentIndices = new int[]{8, 11, 4, 6, 9, 7, 10};
		PlayerAppearance_cachedModels = new EvictingDualNodeHashTable(260);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "([I[IZII)V",
		garbageValue = "16711680"
	)
	@Export("update")
	public void update(int[] var1, int[] var2, boolean var3, int var4) {
		if (var1 == null) {
			var1 = new int[12];

			for (int var5 = 0; var5 < 7; ++var5) {
				for (int var6 = 0; var6 < DevicePcmPlayerProvider.KitDefinition_fileCount; ++var6) {
					KitDefinition var7 = class216.KitDefinition_get(var6);
					if (var7 != null && !var7.nonSelectable && var5 + (var3 ? 7 : 0) == var7.bodypartID) {
						var1[equipmentIndices[var5]] = var6 + 256;
						break;
					}
				}
			}
		}

		this.equipment = var1;
		this.bodyColors = var2;
		this.isFemale = var3;
		this.npcTransformId = var4;
		this.setHash();
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IZI)V",
		garbageValue = "-317022193"
	)
	@Export("changeAppearance")
	public void changeAppearance(int var1, boolean var2) {
		if (var1 != 1 || !this.isFemale) {
			int var3 = this.equipment[equipmentIndices[var1]];
			if (var3 != 0) {
				var3 -= 256;

				KitDefinition var4;
				do {
					if (!var2) {
						--var3;
						if (var3 < 0) {
							var3 = DevicePcmPlayerProvider.KitDefinition_fileCount - 1;
						}
					} else {
						++var3;
						if (var3 >= DevicePcmPlayerProvider.KitDefinition_fileCount) {
							var3 = 0;
						}
					}

					var4 = class216.KitDefinition_get(var3);
				} while(var4 == null || var4.nonSelectable || var4.bodypartID != var1 + (this.isFemale ? 7 : 0));

				this.equipment[equipmentIndices[var1]] = var3 + 256;
				this.setHash();
			}
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IZI)V",
		garbageValue = "-278552632"
	)
	public void method3977(int var1, boolean var2) {
		int var3 = this.bodyColors[var1];
		if (!var2) {
			do {
				--var3;
				if (var3 < 0) {
					var3 = field2519[var1].length - 1;
				}
			} while(!NetCache.method4296(var1, var3));
		} else {
			do {
				++var3;
				if (var3 >= field2519[var1].length) {
					var3 = 0;
				}
			} while(!NetCache.method4296(var1, var3));
		}

		this.bodyColors[var1] = var3;
		this.setHash();
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-1564425789"
	)
	@Export("changeSex")
	public void changeSex(boolean var1) {
		if (this.isFemale != var1) {
			this.update((int[])null, this.bodyColors, var1, -1);
		}
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(Lkl;I)V",
		garbageValue = "-1319583567"
	)
	@Export("write")
	public void write(Buffer var1) {
		var1.writeByte(this.isFemale ? 1 : 0);

		int var2;
		for (var2 = 0; var2 < 7; ++var2) {
			int var3 = this.equipment[equipmentIndices[var2]];
			if (var3 == 0) {
				var1.writeByte(-1);
			} else {
				var1.writeByte(var3 - 256);
			}
		}

		for (var2 = 0; var2 < 5; ++var2) {
			var1.writeByte(this.bodyColors[var2]);
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1673165778"
	)
	@Export("setHash")
	void setHash() {
		long var1 = this.field2526;
		int var3 = this.equipment[5];
		int var4 = this.equipment[9];
		this.equipment[5] = var4;
		this.equipment[9] = var3;
		this.field2526 = 0L;

		int var5;
		for (var5 = 0; var5 < 12; ++var5) {
			this.field2526 <<= 4;
			if (this.equipment[var5] >= 256) {
				this.field2526 += (long)(this.equipment[var5] - 256);
			}
		}

		if (this.equipment[0] >= 256) {
			this.field2526 += (long)(this.equipment[0] - 256 >> 4);
		}

		if (this.equipment[1] >= 256) {
			this.field2526 += (long)(this.equipment[1] - 256 >> 8);
		}

		for (var5 = 0; var5 < 5; ++var5) {
			this.field2526 <<= 3;
			this.field2526 += (long)this.bodyColors[var5];
		}

		this.field2526 <<= 1;
		this.field2526 += (long)(this.isFemale ? 1 : 0);
		this.equipment[5] = var3;
		this.equipment[9] = var4;
		if (var1 != 0L && this.field2526 != var1) {
			PlayerAppearance_cachedModels.remove(var1);
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lix;ILix;IB)Ldh;",
		garbageValue = "2"
	)
	@Export("getModel")
	public Model getModel(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4) {
		if (this.npcTransformId != -1) {
			return PacketBufferNode.getNpcDefinition(this.npcTransformId).getModel(var1, var2, var3, var4);
		} else {
			long var5 = this.field2526;
			int[] var7 = this.equipment;
			if (var1 != null && (var1.shield >= 0 || var1.weapon >= 0)) {
				var7 = new int[12];

				for (int var15 = 0; var15 < 12; ++var15) {
					var7[var15] = this.equipment[var15];
				}

				if (var1.shield >= 0) {
					var5 += (long)(var1.shield - this.equipment[5] << 40);
					var7[5] = var1.shield;
				}

				if (var1.weapon >= 0) {
					var5 += (long)(var1.weapon - this.equipment[3] << 48);
					var7[3] = var1.weapon;
				}
			}

			Model var8 = (Model)PlayerAppearance_cachedModels.get(var5);
			if (var8 == null) {
				boolean var9 = false;

				int var11;
				for (int var10 = 0; var10 < 12; ++var10) {
					var11 = var7[var10];
					if (var11 >= 256 && var11 < 512 && !class216.KitDefinition_get(var11 - 256).ready()) {
						var9 = true;
					}

					if (var11 >= 512 && !Occluder.ItemDefinition_get(var11 - 512).hasNoValidModel(this.isFemale)) {
						var9 = true;
					}
				}

				if (var9) {
					if (-1L != this.field2522) {
						var8 = (Model)PlayerAppearance_cachedModels.get(this.field2522);
					}

					if (var8 == null) {
						return null;
					}
				}

				if (var8 == null) {
					ModelData[] var16 = new ModelData[12];
					var11 = 0;

					int var13;
					for (int var12 = 0; var12 < 12; ++var12) {
						var13 = var7[var12];
						ModelData var14;
						if (var13 >= 256 && var13 < 512) {
							var14 = class216.KitDefinition_get(var13 - 256).getModelData();
							if (var14 != null) {
								var16[var11++] = var14;
							}
						}

						if (var13 >= 512) {
							var14 = Occluder.ItemDefinition_get(var13 - 512).method4605(this.isFemale);
							if (var14 != null) {
								var16[var11++] = var14;
							}
						}
					}

					ModelData var18 = new ModelData(var16, var11);

					for (var13 = 0; var13 < 5; ++var13) {
						if (this.bodyColors[var13] < field2519[var13].length) {
							var18.recolor(HorizontalAlignment.field3447[var13], field2519[var13][this.bodyColors[var13]]);
						}

						if (this.bodyColors[var13] < DevicePcmPlayerProvider.field390[var13].length) {
							var18.recolor(field2525[var13], DevicePcmPlayerProvider.field390[var13][this.bodyColors[var13]]);
						}
					}

					var8 = var18.toModel(64, 850, -30, -50, -30);
					PlayerAppearance_cachedModels.put(var8, var5);
					this.field2522 = var5;
				}
			}

			if (var1 == null && var3 == null) {
				return var8;
			} else {
				Model var17;
				if (var1 != null && var3 != null) {
					var17 = var1.applyTransformations(var8, var2, var3, var4);
				} else if (var1 != null) {
					var17 = var1.transformActorModel(var8, var2);
				} else {
					var17 = var3.transformActorModel(var8, var4);
				}

				return var17;
			}
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(B)Ldw;",
		garbageValue = "65"
	)
	@Export("getModelData")
	ModelData getModelData() {
		if (this.npcTransformId != -1) {
			return PacketBufferNode.getNpcDefinition(this.npcTransformId).getModelData();
		} else {
			boolean var1 = false;

			int var3;
			for (int var2 = 0; var2 < 12; ++var2) {
				var3 = this.equipment[var2];
				if (var3 >= 256 && var3 < 512 && !class216.KitDefinition_get(var3 - 256).method4423()) {
					var1 = true;
				}

				if (var3 >= 512 && !Occluder.ItemDefinition_get(var3 - 512).method4623(this.isFemale)) {
					var1 = true;
				}
			}

			if (var1) {
				return null;
			} else {
				ModelData[] var7 = new ModelData[12];
				var3 = 0;

				int var5;
				for (int var4 = 0; var4 < 12; ++var4) {
					var5 = this.equipment[var4];
					ModelData var6;
					if (var5 >= 256 && var5 < 512) {
						var6 = class216.KitDefinition_get(var5 - 256).getKitDefinitionModels();
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}

					if (var5 >= 512) {
						var6 = Occluder.ItemDefinition_get(var5 - 512).method4607(this.isFemale);
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}
				}

				ModelData var8 = new ModelData(var7, var3);

				for (var5 = 0; var5 < 5; ++var5) {
					if (this.bodyColors[var5] < field2519[var5].length) {
						var8.recolor(HorizontalAlignment.field3447[var5], field2519[var5][this.bodyColors[var5]]);
					}

					if (this.bodyColors[var5] < DevicePcmPlayerProvider.field390[var5].length) {
						var8.recolor(field2525[var5], DevicePcmPlayerProvider.field390[var5][this.bodyColors[var5]]);
					}
				}

				return var8;
			}
		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2085645902"
	)
	@Export("getChatHeadId")
	public int getChatHeadId() {
		return this.npcTransformId == -1 ? (this.equipment[0] << 15) + this.equipment[1] + (this.equipment[11] << 5) + (this.equipment[8] << 10) + (this.bodyColors[0] << 25) + (this.bodyColors[4] << 20) : 305419896 + PacketBufferNode.getNpcDefinition(this.npcTransformId).id;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1021250910"
	)
	public static boolean method4010() {
		long var0 = class30.currentTimeMillis();
		int var2 = (int)(var0 - NetCache.field3142);
		NetCache.field3142 = var0;
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
						if (WorldMapEvent.NetCache_currentResponse == null) {
							var5 = 8;
						} else if (NetCache.field3140 == 0) {
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
							if (NetCache.field3156 != 0) {
								for (var7 = 0; var7 < var6; ++var7) {
									var10000 = NetCache.NetCache_responseHeaderBuffer.array;
									var10001 = NetCache.NetCache_responseHeaderBuffer.offset + var7;
									var10000[var10001] ^= NetCache.field3156;
								}
							}

							var22 = NetCache.NetCache_responseHeaderBuffer;
							var22.offset += var6;
							if (NetCache.NetCache_responseHeaderBuffer.offset < var5) {
								break;
							}

							if (WorldMapEvent.NetCache_currentResponse == null) {
								NetCache.NetCache_responseHeaderBuffer.offset = 0;
								var7 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
								var8 = NetCache.NetCache_responseHeaderBuffer.readUnsignedShort();
								int var9 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
								var10 = NetCache.NetCache_responseHeaderBuffer.readInt();
								long var11 = (long)(var8 + (var7 << 16));
								NetFileRequest var13 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.get(var11);
								UserComparator10.field1957 = true;
								if (var13 == null) {
									var13 = (NetFileRequest)NetCache.NetCache_pendingResponses.get(var11);
									UserComparator10.field1957 = false;
								}

								if (var13 == null) {
									throw new IOException();
								}

								int var14 = var9 == 0 ? 5 : 9;
								WorldMapEvent.NetCache_currentResponse = var13;
								FaceNormal.NetCache_responseArchiveBuffer = new Buffer(var10 + var14 + WorldMapEvent.NetCache_currentResponse.padding);
								FaceNormal.NetCache_responseArchiveBuffer.writeByte(var9);
								FaceNormal.NetCache_responseArchiveBuffer.writeInt(var10);
								NetCache.field3140 = 8;
								NetCache.NetCache_responseHeaderBuffer.offset = 0;
							} else if (NetCache.field3140 == 0) {
								if (NetCache.NetCache_responseHeaderBuffer.array[0] == -1) {
									NetCache.field3140 = 1;
									NetCache.NetCache_responseHeaderBuffer.offset = 0;
								} else {
									WorldMapEvent.NetCache_currentResponse = null;
								}
							}
						} else {
							var6 = FaceNormal.NetCache_responseArchiveBuffer.array.length - WorldMapEvent.NetCache_currentResponse.padding;
							var7 = 512 - NetCache.field3140;
							if (var7 > var6 - FaceNormal.NetCache_responseArchiveBuffer.offset) {
								var7 = var6 - FaceNormal.NetCache_responseArchiveBuffer.offset;
							}

							if (var7 > var16) {
								var7 = var16;
							}

							NetCache.NetCache_socket.read(FaceNormal.NetCache_responseArchiveBuffer.array, FaceNormal.NetCache_responseArchiveBuffer.offset, var7);
							if (NetCache.field3156 != 0) {
								for (var8 = 0; var8 < var7; ++var8) {
									var10000 = FaceNormal.NetCache_responseArchiveBuffer.array;
									var10001 = var8 + FaceNormal.NetCache_responseArchiveBuffer.offset;
									var10000[var10001] ^= NetCache.field3156;
								}
							}

							var22 = FaceNormal.NetCache_responseArchiveBuffer;
							var22.offset += var7;
							NetCache.field3140 += var7;
							if (var6 == FaceNormal.NetCache_responseArchiveBuffer.offset) {
								if (16711935L == WorldMapEvent.NetCache_currentResponse.key) {
									AbstractWorldMapIcon.NetCache_reference = FaceNormal.NetCache_responseArchiveBuffer;

									for (var8 = 0; var8 < 256; ++var8) {
										Archive var17 = NetCache.NetCache_archives[var8];
										if (var17 != null) {
											AbstractWorldMapIcon.NetCache_reference.offset = var8 * 8 + 5;
											var10 = AbstractWorldMapIcon.NetCache_reference.readInt();
											int var18 = AbstractWorldMapIcon.NetCache_reference.readInt();
											var17.loadIndex(var10, var18);
										}
									}
								} else {
									NetCache.NetCache_crc.reset();
									NetCache.NetCache_crc.update(FaceNormal.NetCache_responseArchiveBuffer.array, 0, var6);
									var8 = (int)NetCache.NetCache_crc.getValue();
									if (var8 != WorldMapEvent.NetCache_currentResponse.crc) {
										try {
											NetCache.NetCache_socket.close();
										} catch (Exception var20) {
										}

										++NetCache.NetCache_crcMismatches;
										NetCache.NetCache_socket = null;
										NetCache.field3156 = (byte)((int)(Math.random() * 255.0D + 1.0D));
										return false;
									}

									NetCache.NetCache_crcMismatches = 0;
									NetCache.NetCache_ioExceptions = 0;
									WorldMapEvent.NetCache_currentResponse.archive.write((int)(WorldMapEvent.NetCache_currentResponse.key & 65535L), FaceNormal.NetCache_responseArchiveBuffer.array, (WorldMapEvent.NetCache_currentResponse.key & 16711680L) == 16711680L, UserComparator10.field1957);
								}

								WorldMapEvent.NetCache_currentResponse.remove();
								if (UserComparator10.field1957) {
									--NetCache.NetCache_pendingPriorityResponsesCount;
								} else {
									--NetCache.NetCache_pendingResponsesCount;
								}

								NetCache.field3140 = 0;
								WorldMapEvent.NetCache_currentResponse = null;
								FaceNormal.NetCache_responseArchiveBuffer = null;
							} else {
								if (NetCache.field3140 != 512) {
									break;
								}

								NetCache.field3140 = 0;
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

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)[Lin;",
		garbageValue = "101"
	)
	static HorizontalAlignment[] method4012() {
		return new HorizontalAlignment[]{HorizontalAlignment.field3442, HorizontalAlignment.field3444, HorizontalAlignment.HorizontalAlignment_centered};
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "1781991052"
	)
	static int method3978(int var0) {
		return (int)Math.pow(2.0D, (double)(7.0F + (float)var0 / 256.0F));
	}

	@ObfuscatedName("go")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "1898502945"
	)
	@Export("worldToScreen")
	static final void worldToScreen(int var0, int var1, int var2) {
		if (var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
			int var3 = MusicPatchPcmStream.getTileHeight(var0, var1, WorldMapRectangle.plane) - var2;
			var0 -= GrandExchangeOfferOwnWorldComparator.cameraX;
			var3 -= Varcs.cameraY;
			var1 -= WorldMapIcon_1.cameraZ;
			int var4 = Rasterizer3D.Rasterizer3D_sine[IgnoreList.cameraPitch];
			int var5 = Rasterizer3D.Rasterizer3D_cosine[IgnoreList.cameraPitch];
			int var6 = Rasterizer3D.Rasterizer3D_sine[WorldMapSection2.cameraYaw];
			int var7 = Rasterizer3D.Rasterizer3D_cosine[WorldMapSection2.cameraYaw];
			int var8 = var6 * var1 + var0 * var7 >> 16;
			var1 = var7 * var1 - var0 * var6 >> 16;
			var0 = var8;
			var8 = var3 * var5 - var4 * var1 >> 16;
			var1 = var5 * var1 + var4 * var3 >> 16;
			if (var1 >= 50) {
				Client.viewportTempX = var0 * Client.viewportZoom / var1 + Client.viewportWidth / 2;
				Client.viewportTempY = Client.viewportHeight / 2 + var8 * Client.viewportZoom / var1;
			} else {
				Client.viewportTempX = -1;
				Client.viewportTempY = -1;
			}

		} else {
			Client.viewportTempX = -1;
			Client.viewportTempY = -1;
		}
	}
}
