import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("gw")
public class class185 {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	public static final class185 field2299;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	public static final class185 field2300;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	public static final class185 field2298;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	public static final class185 field2297;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	public static final class185 field2295;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	public static final class185 field2296;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	public static final class185 field2301;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	public static final class185 field2302;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	public static final class185 field2303;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	public static final class185 field2304;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = 1987889023
	)
	static int field2305;

	static {
		field2299 = new class185(4);
		field2300 = new class185(5);
		field2298 = new class185(14);
		field2297 = new class185(5);
		field2295 = new class185(15);
		field2296 = new class185(2);
		field2301 = new class185(6);
		field2302 = new class185(4);
		field2303 = new class185(7);
		field2304 = new class185(3);
	}

	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "4"
	)
	class185(int var1) {
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;ZS)Lmh;",
		garbageValue = "3503"
	)
	@Export("getPreferencesFile")
	public static AccessFile getPreferencesFile(String var0, String var1, boolean var2) {
		File var3 = new File(GrandExchangeOfferOwnWorldComparator.cacheDir, "preferences" + var0 + ".dat");
		if (var3.exists()) {
			try {
				AccessFile var10 = new AccessFile(var3, "rw", 10000L);
				return var10;
			} catch (IOException var9) {
			}
		}

		String var4 = "";
		if (BufferedNetSocket.cacheGamebuild == 33) {
			var4 = "_rc";
		} else if (BufferedNetSocket.cacheGamebuild == 34) {
			var4 = "_wip";
		}

		File var5 = new File(JagexCache.userHomeDirectory, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
		AccessFile var6;
		if (!var2 && var5.exists()) {
			try {
				var6 = new AccessFile(var5, "rw", 10000L);
				return var6;
			} catch (IOException var8) {
			}
		}

		try {
			var6 = new AccessFile(var3, "rw", 10000L);
			return var6;
		} catch (IOException var7) {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkl;II)V",
		garbageValue = "65280"
	)
	@Export("readReflectionCheck")
	public static void readReflectionCheck(Buffer var0, int var1) {
		ReflectionCheck var2 = new ReflectionCheck();
		var2.size = var0.readUnsignedByte();
		var2.id = var0.readInt();
		var2.operations = new int[var2.size];
		var2.creationErrors = new int[var2.size];
		var2.fields = new Field[var2.size];
		var2.intReplaceValues = new int[var2.size];
		var2.methods = new Method[var2.size];
		var2.arguments = new byte[var2.size][][];

		for (int var3 = 0; var3 < var2.size; ++var3) {
			try {
				int var4 = var0.readUnsignedByte();
				String var5;
				String var6;
				int var7;
				if (var4 != 0 && var4 != 1 && var4 != 2) {
					if (var4 == 3 || var4 == 4) {
						var5 = var0.readStringCp1252NullTerminated();
						var6 = var0.readStringCp1252NullTerminated();
						var7 = var0.readUnsignedByte();
						String[] var8 = new String[var7];

						for (int var9 = 0; var9 < var7; ++var9) {
							var8[var9] = var0.readStringCp1252NullTerminated();
						}

						String var20 = var0.readStringCp1252NullTerminated();
						byte[][] var10 = new byte[var7][];
						int var12;
						if (var4 == 3) {
							for (int var11 = 0; var11 < var7; ++var11) {
								var12 = var0.readInt();
								var10[var11] = new byte[var12];
								var0.readBytes(var10[var11], 0, var12);
							}
						}

						var2.operations[var3] = var4;
						Class[] var21 = new Class[var7];

						for (var12 = 0; var12 < var7; ++var12) {
							var21[var12] = TextureProvider.loadClassFromDescriptor(var8[var12]);
						}

						Class var22 = TextureProvider.loadClassFromDescriptor(var20);
						if (TextureProvider.loadClassFromDescriptor(var5).getClassLoader() == null) {
							throw new SecurityException();
						}

						Method[] var13 = TextureProvider.loadClassFromDescriptor(var5).getDeclaredMethods();
						Method[] var14 = var13;

						for (int var15 = 0; var15 < var14.length; ++var15) {
							Method var16 = var14[var15];
							if (Reflection.getMethodName(var16).equals(var6)) {
								Class[] var17 = Reflection.getParameterTypes(var16);
								if (var21.length == var17.length) {
									boolean var18 = true;

									for (int var19 = 0; var19 < var21.length; ++var19) {
										if (var17[var19] != var21[var19]) {
											var18 = false;
											break;
										}
									}

									if (var18 && var22 == var16.getReturnType()) {
										var2.methods[var3] = var16;
									}
								}
							}
						}

						var2.arguments[var3] = var10;
					}
				} else {
					var5 = var0.readStringCp1252NullTerminated();
					var6 = var0.readStringCp1252NullTerminated();
					var7 = 0;
					if (var4 == 1) {
						var7 = var0.readInt();
					}

					var2.operations[var3] = var4;
					var2.intReplaceValues[var3] = var7;
					if (TextureProvider.loadClassFromDescriptor(var5).getClassLoader() == null) {
						throw new SecurityException();
					}

					var2.fields[var3] = Reflection.findField(TextureProvider.loadClassFromDescriptor(var5), var6);
				}
			} catch (ClassNotFoundException var24) {
				var2.creationErrors[var3] = -1;
			} catch (SecurityException var25) {
				var2.creationErrors[var3] = -2;
			} catch (NullPointerException var26) {
				var2.creationErrors[var3] = -3;
			} catch (Exception var27) {
				var2.creationErrors[var3] = -4;
			} catch (Throwable var28) {
				var2.creationErrors[var3] = -5;
			}
		}

		class96.reflectionChecks.addFirst(var2);
	}

	@ObfuscatedName("jy")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "16256"
	)
	static final void method3587() {
		Client.field830 = Client.cycleCntr;
		GrandExchangeOfferAgeComparator.ClanChat_inClanChat = true;
	}
}
