import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class30 {
	@ObfuscatedName("sb")
	@ObfuscatedSignature(
		signature = "Lke;"
	)
	@Export("masterDisk")
	static ArchiveDisk masterDisk;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lag;"
	)
	static final class30 field258;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lag;"
	)
	static final class30 field262;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 908407325
	)
	static int field261;
	@ObfuscatedName("hv")
	@ObfuscatedGetter(
		intValue = -378303491
	)
	@Export("cameraX")
	static int cameraX;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 549808295
	)
	@Export("value")
	final int value;

	static {
		field258 = new class30(0);
		field262 = new class30(1);
	}

	class30(int var1) {
		this.value = var1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "2"
	)
	public static boolean method565() {
		long var0 = TaskHandler.currentTimeMillis();
		int var2 = (int)(var0 - NetCache.field3171);
		NetCache.field3171 = var0;
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
						} else if (NetCache.field3188 == 0) {
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
							if (NetCache.field3184 != 0) {
								for (var7 = 0; var7 < var6; ++var7) {
									var10000 = NetCache.NetCache_responseHeaderBuffer.array;
									var10001 = NetCache.NetCache_responseHeaderBuffer.offset + var7;
									var10000[var10001] ^= NetCache.field3184;
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
								NetCache.field3181 = true;
								if (var13 == null) {
									var13 = (NetFileRequest)NetCache.NetCache_pendingResponses.get(var11);
									NetCache.field3181 = false;
								}

								if (var13 == null) {
									throw new IOException();
								}

								int var14 = var9 == 0 ? 5 : 9;
								NetCache.NetCache_currentResponse = var13;
								class32.NetCache_responseArchiveBuffer = new Buffer(var10 + var14 + NetCache.NetCache_currentResponse.padding);
								class32.NetCache_responseArchiveBuffer.writeByte(var9);
								class32.NetCache_responseArchiveBuffer.writeInt(var10);
								NetCache.field3188 = 8;
								NetCache.NetCache_responseHeaderBuffer.offset = 0;
							} else if (NetCache.field3188 == 0) {
								if (NetCache.NetCache_responseHeaderBuffer.array[0] == -1) {
									NetCache.field3188 = 1;
									NetCache.NetCache_responseHeaderBuffer.offset = 0;
								} else {
									NetCache.NetCache_currentResponse = null;
								}
							}
						} else {
							var6 = class32.NetCache_responseArchiveBuffer.array.length - NetCache.NetCache_currentResponse.padding;
							var7 = 512 - NetCache.field3188;
							if (var7 > var6 - class32.NetCache_responseArchiveBuffer.offset) {
								var7 = var6 - class32.NetCache_responseArchiveBuffer.offset;
							}

							if (var7 > var16) {
								var7 = var16;
							}

							NetCache.NetCache_socket.read(class32.NetCache_responseArchiveBuffer.array, class32.NetCache_responseArchiveBuffer.offset, var7);
							if (NetCache.field3184 != 0) {
								for (var8 = 0; var8 < var7; ++var8) {
									var10000 = class32.NetCache_responseArchiveBuffer.array;
									var10001 = class32.NetCache_responseArchiveBuffer.offset + var8;
									var10000[var10001] ^= NetCache.field3184;
								}
							}

							var22 = class32.NetCache_responseArchiveBuffer;
							var22.offset += var7;
							NetCache.field3188 += var7;
							if (var6 == class32.NetCache_responseArchiveBuffer.offset) {
								if (16711935L == NetCache.NetCache_currentResponse.key) {
									class83.NetCache_reference = class32.NetCache_responseArchiveBuffer;

									for (var8 = 0; var8 < 256; ++var8) {
										Archive var17 = NetCache.NetCache_archives[var8];
										if (var17 != null) {
											class83.NetCache_reference.offset = var8 * 8 + 5;
											var10 = class83.NetCache_reference.readInt();
											int var18 = class83.NetCache_reference.readInt();
											var17.loadIndex(var10, var18);
										}
									}
								} else {
									NetCache.NetCache_crc.reset();
									NetCache.NetCache_crc.update(class32.NetCache_responseArchiveBuffer.array, 0, var6);
									var8 = (int)NetCache.NetCache_crc.getValue();
									if (var8 != NetCache.NetCache_currentResponse.crc) {
										try {
											NetCache.NetCache_socket.close();
										} catch (Exception var20) {
										}

										++NetCache.NetCache_crcMismatches;
										NetCache.NetCache_socket = null;
										NetCache.field3184 = (byte)((int)(Math.random() * 255.0D + 1.0D));
										return false;
									}

									NetCache.NetCache_crcMismatches = 0;
									NetCache.NetCache_ioExceptions = 0;
									NetCache.NetCache_currentResponse.archive.write((int)(NetCache.NetCache_currentResponse.key & 65535L), class32.NetCache_responseArchiveBuffer.array, 16711680L == (NetCache.NetCache_currentResponse.key & 16711680L), NetCache.field3181);
								}

								NetCache.NetCache_currentResponse.remove();
								if (NetCache.field3181) {
									--NetCache.NetCache_pendingPriorityResponsesCount;
								} else {
									--NetCache.NetCache_pendingResponsesCount;
								}

								NetCache.field3188 = 0;
								NetCache.NetCache_currentResponse = null;
								class32.NetCache_responseArchiveBuffer = null;
							} else {
								if (NetCache.field3188 != 512) {
									break;
								}

								NetCache.field3188 = 0;
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)Lci;",
		garbageValue = "-900188617"
	)
	@Export("getScript")
	static Script getScript(int var0) {
		Script var1 = (Script)Script.Script_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = class267.archive12.takeFile(var0, 0);
			if (var2 == null) {
				return null;
			} else {
				var1 = WorldMapArea.newScript(var2);
				Script.Script_cached.put(var1, (long)var0);
				return var1;
			}
		}
	}

	@ObfuscatedName("gg")
	@ObfuscatedSignature(
		signature = "(Lbg;I)Z",
		garbageValue = "-276383338"
	)
	static boolean method563(Player var0) {
		if (Client.drawPlayerNames == 0) {
			return false;
		} else if (class215.localPlayer == var0) {
			boolean var1 = (Client.drawPlayerNames & 8) != 0;
			return var1;
		} else {
			return WorldMapSection0.method257() || class1.method16() && var0.isFriend() || FriendSystem.method1920() && var0.isClanMember();
		}
	}
}
