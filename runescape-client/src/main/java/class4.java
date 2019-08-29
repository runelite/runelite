import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
final class class4 implements class0 {
	@ObfuscatedName("x")
	static int[][] field31;
	@ObfuscatedName("au")
	@Export("null_string")
	protected static String null_string;

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lky;I)V",
		garbageValue = "254789492"
	)
	public void vmethod58(Object var1, Buffer var2) {
		this.method57((String)var1, var2);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lky;I)Ljava/lang/Object;",
		garbageValue = "1267204541"
	)
	public Object vmethod70(Buffer var1) {
		return var1.readStringCp1252NullTerminated();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lky;I)V",
		garbageValue = "779729893"
	)
	void method57(String var1, Buffer var2) {
		var2.writeStringCp1252NullTerminated(var1);
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;IB)Ljava/io/File;",
		garbageValue = "-122"
	)
	@Export("getCacheDir")
	public static File getCacheDir(String var0, String var1, int var2) {
		String var3 = var2 == 0 ? "" : "" + var2;
		class290.JagexCache_locationFile = new File(FontName.userHomeDirectory, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
		String var4 = null;
		String var5 = null;
		boolean var6 = false;
		File var22;
		if (class290.JagexCache_locationFile.exists()) {
			try {
				AccessFile var7 = new AccessFile(class290.JagexCache_locationFile, "rw", 10000L);

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
			} catch (IOException var20) {
				var20.printStackTrace();
			}

			if (var4 != null) {
				var22 = new File(var4);
				if (!var22.exists()) {
					var4 = null;
				}
			}

			if (var4 != null) {
				var22 = new File(var4, "test.dat");
				if (!GameShell.testReadWritePermissions(var22, true)) {
					var4 = null;
				}
			}
		}

		if (var4 == null && var2 == 0) {
			label123:
			for (int var15 = 0; var15 < Login.field1181.length; ++var15) {
				for (int var16 = 0; var16 < GrandExchangeEvent.field47.length; ++var16) {
					File var17 = new File(GrandExchangeEvent.field47[var16] + Login.field1181[var15] + File.separatorChar + var0 + File.separatorChar);
					if (var17.exists() && GameShell.testReadWritePermissions(new File(var17, "test.dat"), true)) {
						var4 = var17.toString();
						var6 = true;
						break label123;
					}
				}
			}
		}

		if (var4 == null) {
			var4 = FontName.userHomeDirectory + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
			var6 = true;
		}

		if (var5 != null) {
			File var21 = new File(var5);
			var22 = new File(var4);

			try {
				File[] var23 = var21.listFiles();
				File[] var18 = var23;

				for (int var11 = 0; var11 < var18.length; ++var11) {
					File var12 = var18[var11];
					File var13 = new File(var22, var12.getName());
					boolean var14 = var12.renameTo(var13);
					if (!var14) {
						throw new IOException();
					}
				}
			} catch (Exception var19) {
				var19.printStackTrace();
			}

			var6 = true;
		}

		if (var6) {
			MouseHandler.method1041(new File(var4), (File)null);
		}

		return new File(var4);
	}
}
