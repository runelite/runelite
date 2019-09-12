import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
@Implements("Entity")
public abstract class Entity extends DualNode {
	@ObfuscatedName("jn")
	@ObfuscatedSignature(
		signature = "Lhy;"
	)
	static Widget field1835;
	@ObfuscatedName("cw")
	@ObfuscatedGetter(
		intValue = -160272347
	)
	@Export("height")
	public int height;

	protected Entity() {
		this.height = 1000;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)Ldr;",
		garbageValue = "-35"
	)
	@Export("getModel")
	protected Model getModel() {
		return null;
	}

	@ObfuscatedName("cm")
	@Export("draw")
	void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9) {
		Model var11 = this.getModel();
		if (var11 != null) {
			this.height = var11.height;
			var11.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
		garbageValue = "1018244137"
	)
	@Export("getCacheDir")
	static File getCacheDir(String var0, String var1, int var2) {
		String var3 = var2 == 0 ? "" : "" + var2;
		JagexCache.JagexCache_locationFile = new File(Message.userHomeDirectory, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
		String var4 = null;
		String var5 = null;
		boolean var6 = false;
		int var11;
		File var26;
		if (JagexCache.JagexCache_locationFile.exists()) {
			try {
				AccessFile var7 = new AccessFile(JagexCache.JagexCache_locationFile, "rw", 10000L);

				Buffer var8;
				int var9;
				for (var8 = new Buffer((int)var7.length()); var8.offset < var8.array.length; var8.offset += var9) {
					var9 = var7.read(var8.array, var8.offset, var8.array.length - var8.offset);
					if (var9 == -1) {
						throw new IOException();
					}
				}

				var8.offset = 0;
				var9 = var8.readUnsignedByte();
				if (var9 < 1 || var9 > 3) {
					throw new IOException("" + var9);
				}

				int var10 = 0;
				if (var9 > 1) {
					var10 = var8.readUnsignedByte();
				}

				if (var9 <= 2) {
					var4 = var8.readStringCp1252NullCircumfixed();
					if (var10 == 1) {
						var5 = var8.readStringCp1252NullCircumfixed();
					}
				} else {
					var4 = var8.readCESU8();
					if (var10 == 1) {
						var5 = var8.readCESU8();
					}
				}

				var7.close();
			} catch (IOException var24) {
				var24.printStackTrace();
			}

			if (var4 != null) {
				var26 = new File(var4);
				if (!var26.exists()) {
					var4 = null;
				}
			}

			if (var4 != null) {
				var26 = new File(var4, "test.dat");

				boolean var27;
				try {
					RandomAccessFile var15 = new RandomAccessFile(var26, "rw");
					var11 = var15.read();
					var15.seek(0L);
					var15.write(var11);
					var15.seek(0L);
					var15.close();
					var26.delete();
					var27 = true;
				} catch (Exception var22) {
					var27 = false;
				}

				if (!var27) {
					var4 = null;
				}
			}
		}

		if (var4 == null && var2 == 0) {
			label139:
			for (int var16 = 0; var16 < NetFileRequest.field3096.length; ++var16) {
				for (int var17 = 0; var17 < GrandExchangeOfferWorldComparator.field30.length; ++var17) {
					File var18 = new File(GrandExchangeOfferWorldComparator.field30[var17] + NetFileRequest.field3096[var16] + File.separatorChar + var0 + File.separatorChar);
					if (var18.exists()) {
						File var19 = new File(var18, "test.dat");

						boolean var28;
						try {
							RandomAccessFile var12 = new RandomAccessFile(var19, "rw");
							int var13 = var12.read();
							var12.seek(0L);
							var12.write(var13);
							var12.seek(0L);
							var12.close();
							var19.delete();
							var28 = true;
						} catch (Exception var21) {
							var28 = false;
						}

						if (var28) {
							var4 = var18.toString();
							var6 = true;
							break label139;
						}
					}
				}
			}
		}

		if (var4 == null) {
			var4 = Message.userHomeDirectory + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
			var6 = true;
		}

		if (var5 != null) {
			File var25 = new File(var5);
			var26 = new File(var4);

			try {
				File[] var31 = var25.listFiles();
				File[] var30 = var31;

				for (var11 = 0; var11 < var30.length; ++var11) {
					File var29 = var30[var11];
					File var20 = new File(var26, var29.getName());
					boolean var14 = var29.renameTo(var20);
					if (!var14) {
						throw new IOException();
					}
				}
			} catch (Exception var23) {
				var23.printStackTrace();
			}

			var6 = true;
		}

		if (var6) {
			WorldMapManager.method611(new File(var4), (File)null);
		}

		return new File(var4);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "-284240639"
	)
	@Export("hslToRgb")
	static final int hslToRgb(int var0, int var1, int var2) {
		if (var2 > 179) {
			var1 /= 2;
		}

		if (var2 > 192) {
			var1 /= 2;
		}

		if (var2 > 217) {
			var1 /= 2;
		}

		if (var2 > 243) {
			var1 /= 2;
		}

		int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
		return var3;
	}

	@ObfuscatedName("er")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-16"
	)
	static void method3228() {
		Client.packetWriter.clearBuffer();
		Client.packetWriter.packetBuffer.offset = 0;
		Client.packetWriter.serverPacket = null;
		Client.packetWriter.field1274 = null;
		Client.packetWriter.field1286 = null;
		Client.packetWriter.field1287 = null;
		Client.packetWriter.serverPacketLength = 0;
		Client.packetWriter.field1283 = 0;
		Client.rebootTimer = 0;
		Client.menuOptionsCount = 0;
		Client.isMenuOpen = false;
		Client.minimapState = 0;
		Client.destinationX = 0;

		int var0;
		for (var0 = 0; var0 < 2048; ++var0) {
			Client.players[var0] = null;
		}

		Varps.localPlayer = null;

		for (var0 = 0; var0 < Client.npcs.length; ++var0) {
			NPC var1 = Client.npcs[var0];
			if (var1 != null) {
				var1.targetIndex = -1;
				var1.false0 = false;
			}
		}

		class286.method5221();
		WorldMapIcon_0.updateGameState(30);

		for (var0 = 0; var0 < 100; ++var0) {
			Client.field827[var0] = true;
		}

		MouseRecorder.method1145();
	}
}
