import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("do")
@Implements("TextureProvider")
public class TextureProvider implements TextureLoader {
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -95819679
	)
	static int field1539;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "[Ldb;"
	)
	@Export("textures")
	Texture[] textures;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	@Export("deque")
	NodeDeque deque;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1484225311
	)
	@Export("capacity")
	int capacity;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1374200931
	)
	@Export("remaining")
	int remaining;
	@ObfuscatedName("k")
	@Export("brightness")
	double brightness;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -907088153
	)
	@Export("textureSize")
	int textureSize;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("archive")
	AbstractArchive archive;

	@ObfuscatedSignature(
		signature = "(Lhp;Lhp;IDI)V"
	)
	public TextureProvider(AbstractArchive var1, AbstractArchive var2, int var3, double var4, int var6) {
		this.deque = new NodeDeque();
		this.remaining = 0;
		this.brightness = 1.0D;
		this.textureSize = 128;
		this.archive = var2;
		this.capacity = var3;
		this.remaining = this.capacity;
		this.brightness = var4;
		this.textureSize = var6;
		int[] var7 = var1.getGroupFileIds(0);
		int var8 = var7.length;
		this.textures = new Texture[var1.getGroupFileCount(0)];

		for (int var9 = 0; var9 < var8; ++var9) {
			Buffer var10 = new Buffer(var1.takeFile(0, var7[var9]));
			this.textures[var7[var9]] = new Texture(var10);
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "2052170496"
	)
	@Export("getLoadedPercentage")
	public int getLoadedPercentage() {
		int var1 = 0;
		int var2 = 0;
		Texture[] var3 = this.textures;

		for (int var4 = 0; var4 < var3.length; ++var4) {
			Texture var5 = var3[var4];
			if (var5 != null && var5.records != null) {
				var1 += var5.records.length;
				int[] var6 = var5.records;

				for (int var7 = 0; var7 < var6.length; ++var7) {
					int var8 = var6[var7];
					if (this.archive.method4147(var8)) {
						++var2;
					}
				}
			}
		}

		if (var1 == 0) {
			return 0;
		} else {
			return var2 * 100 / var1;
		}
	}

	@ObfuscatedName("w")
	@Export("setBrightness")
	public void setBrightness(double var1) {
		this.brightness = var1;
		this.clear();
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II)[I",
		garbageValue = "726289343"
	)
	@Export("load")
	public int[] load(int var1) {
		Texture var2 = this.textures[var1];
		if (var2 != null) {
			if (var2.pixels != null) {
				this.deque.addLast(var2);
				var2.isLoaded = true;
				return var2.pixels;
			}

			boolean var3 = var2.method2846(this.brightness, this.textureSize, this.archive);
			if (var3) {
				if (this.remaining == 0) {
					Texture var4 = (Texture)this.deque.removeFirst();
					var4.reset();
				} else {
					--this.remaining;
				}

				this.deque.addLast(var2);
				var2.isLoaded = true;
				return var2.pixels;
			}
		}

		return null;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "1833085397"
	)
	@Export("getAverageTextureRGB")
	public int getAverageTextureRGB(int var1) {
		return this.textures[var1] != null ? this.textures[var1].averageRGB : 0;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "100"
	)
	public boolean vmethod3278(int var1) {
		return this.textures[var1].field1624;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "0"
	)
	@Export("isLowDetail")
	public boolean isLowDetail(int var1) {
		return this.textureSize == 64;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1945022462"
	)
	@Export("clear")
	public void clear() {
		for (int var1 = 0; var1 < this.textures.length; ++var1) {
			if (this.textures[var1] != null) {
				this.textures[var1].reset();
			}
		}

		this.deque = new NodeDeque();
		this.remaining = this.capacity;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1054980439"
	)
	@Export("animate")
	public void animate(int var1) {
		for (int var2 = 0; var2 < this.textures.length; ++var2) {
			Texture var3 = this.textures[var2];
			if (var3 != null && var3.animationDirection != 0 && var3.isLoaded) {
				var3.animate(var1);
				var3.isLoaded = false;
			}
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)[B",
		garbageValue = "506694111"
	)
	public static synchronized byte[] method2729(int var0) {
		return ByteArrayPool.ByteArrayPool_get(var0, false);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
		garbageValue = "-1682877008"
	)
	static File method2760(String var0, String var1, int var2) {
		String var3 = var2 == 0 ? "" : "" + var2;
		class167.field2038 = new File(PlayerType.userHomeDirectory, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
		String var4 = null;
		String var5 = null;
		boolean var6 = false;
		Buffer var8;
		File var23;
		if (class167.field2038.exists()) {
			try {
				AccessFile var7 = new AccessFile(class167.field2038, "rw", 10000L);

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
			} catch (IOException var21) {
				var21.printStackTrace();
			}

			if (var4 != null) {
				var23 = new File(var4);
				if (!var23.exists()) {
					var4 = null;
				}
			}

			if (var4 != null) {
				var23 = new File(var4, "test.dat");
				if (!class186.method3618(var23, true)) {
					var4 = null;
				}
			}
		}

		if (var4 == null && var2 == 0) {
			label139:
			for (int var15 = 0; var15 < LoginPacket.field2309.length; ++var15) {
				for (int var16 = 0; var16 < class167.field2043.length; ++var16) {
					File var17 = new File(class167.field2043[var16] + LoginPacket.field2309[var15] + File.separatorChar + var0 + File.separatorChar);
					if (var17.exists() && class186.method3618(new File(var17, "test.dat"), true)) {
						var4 = var17.toString();
						var6 = true;
						break label139;
					}
				}
			}
		}

		if (var4 == null) {
			var4 = PlayerType.userHomeDirectory + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
			var6 = true;
		}

		File var22;
		if (var5 != null) {
			var22 = new File(var5);
			var23 = new File(var4);

			try {
				File[] var24 = var22.listFiles();
				File[] var18 = var24;

				for (int var11 = 0; var11 < var18.length; ++var11) {
					File var12 = var18[var11];
					File var13 = new File(var23, var12.getName());
					boolean var14 = var12.renameTo(var13);
					if (!var14) {
						throw new IOException();
					}
				}
			} catch (Exception var20) {
				var20.printStackTrace();
			}

			var6 = true;
		}

		if (var6) {
			var22 = new File(var4);
			var8 = null;

			try {
				AccessFile var25 = new AccessFile(class167.field2038, "rw", 10000L);
				Buffer var26 = new Buffer(500);
				var26.writeByte(3);
				var26.writeByte(var8 != null ? 1 : 0);
				var26.writeCESU8(var22.getPath());
				if (var8 != null) {
					var26.writeCESU8("");
				}

				var25.write(var26.array, 0, var26.offset);
				var25.close();
			} catch (IOException var19) {
				var19.printStackTrace();
			}
		}

		return new File(var4);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lhp;Ljava/lang/String;Ljava/lang/String;IZB)V",
		garbageValue = "-92"
	)
	public static void method2761(AbstractArchive var0, String var1, String var2, int var3, boolean var4) {
		int var5 = var0.getGroupId(var1);
		int var6 = var0.getFileId(var5, var2);
		class169.method3503(var0, var5, var6, var3, var4);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(ILcx;ZI)I",
		garbageValue = "465921756"
	)
	static int method2743(int var0, Script var1, boolean var2) {
		Widget var3 = class80.getWidget(Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize]);
		if (var0 == ScriptOpcodes.IF_GETSCROLLX) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.scrollX;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETSCROLLY) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.scrollY;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETTEXT) {
			Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var3.text;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETSCROLLWIDTH) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.scrollWidth;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETSCROLLHEIGHT) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.scrollHeight;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETMODELZOOM) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.modelZoom;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETMODELANGLE_X) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.modelAngleX;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETMODELANGLE_Z) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.modelAngleZ;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETMODELANGLE_Y) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.modelAngleY;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETTRANSTOP) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.transparencyTop;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETTRANSBOT) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.transparencyBot;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETCOLOUR) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.color;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETFILLCOLOUR) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.color2;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETFILLMODE) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.fillMode.rsOrdinal();
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETMODELTRANSPARENT) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.modelTransparency ? 1 : 0;
			return 1;
		} else {
			return 2;
		}
	}
}
