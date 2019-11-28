import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("go")
public enum class192 implements Enumerated {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgo;"
	)
	field2381("", 0, new class191[]{class191.field2375}),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lgo;"
	)
	field2378("", 1, new class191[]{class191.field2372, class191.field2375}),
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lgo;"
	)
	field2379("", 2, new class191[]{class191.field2372, class191.field2376, class191.field2375}),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lgo;"
	)
	field2392("", 3, new class191[]{class191.field2372}),
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lgo;"
	)
	field2390("", 4),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lgo;"
	)
	field2384("", 5, new class191[]{class191.field2372, class191.field2375}),
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lgo;"
	)
	field2383("", 6, new class191[]{class191.field2375}),
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lgo;"
	)
	field2385("", 8, new class191[]{class191.field2372, class191.field2375}),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lgo;"
	)
	field2389("", 9, new class191[]{class191.field2372, class191.field2376}),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lgo;"
	)
	field2386("", 10, new class191[]{class191.field2372}),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lgo;"
	)
	field2387("", 11, new class191[]{class191.field2372}),
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lgo;"
	)
	field2388("", 12, new class191[]{class191.field2372, class191.field2375}),
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lgo;"
	)
	field2382("", 13, new class191[]{class191.field2372});

	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = 2041641327
	)
	static int field2395;
	@ObfuscatedName("gf")
	@ObfuscatedSignature(
		signature = "[Llm;"
	)
	@Export("modIconSprites")
	static IndexedSprite[] modIconSprites;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -130205167
	)
	@Export("id")
	final int id;
	@ObfuscatedName("n")
	final Set field2391;

	static {
		method3733();
	}

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I[Lgw;)V"
	)
	class192(String var3, int var4, class191[] var5) {
		this.field2391 = new HashSet();
		this.id = var4;
		class191[] var6 = var5;

		for (int var7 = 0; var7 < var6.length; ++var7) {
			class191 var8 = var6[var7];
			this.field2391.add(var8);
		}

	}

	class192(String var3, int var4) {
		this.field2391 = new HashSet();
		this.id = var4;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "7"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)[Lgo;",
		garbageValue = "1222259750"
	)
	static class192[] method3733() {
		return new class192[]{field2383, field2379, field2392, field2388, field2387, field2384, field2385, field2378, field2386, field2390, field2389, field2382, field2381};
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkg;IB)V",
		garbageValue = "-107"
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
							var21[var12] = VarcInt.loadClassFromDescriptor(var8[var12]);
						}

						Class var22 = VarcInt.loadClassFromDescriptor(var20);
						if (VarcInt.loadClassFromDescriptor(var5).getClassLoader() == null) {
							throw new SecurityException();
						}

						Method[] var13 = VarcInt.loadClassFromDescriptor(var5).getDeclaredMethods();
						Method[] var14 = var13;

						for (int var15 = 0; var15 < var14.length; ++var15) {
							Method var16 = var14[var15];
							if (Reflection.getMethodName(var16).equals(var6)) {
								Class[] var17 = Reflection.getParameterTypes(var16);
								if (var21.length == var17.length) {
									boolean var18 = true;

									for (int var19 = 0; var19 < var21.length; ++var19) {
										if (var21[var19] != var17[var19]) {
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
					if (VarcInt.loadClassFromDescriptor(var5).getClassLoader() == null) {
						throw new SecurityException();
					}

					var2.fields[var3] = Reflection.findField(VarcInt.loadClassFromDescriptor(var5), var6);
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

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "25"
	)
	static final int method3730() {
		return ViewportMouse.ViewportMouse_y;
	}

	@ObfuscatedName("ku")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1031778889"
	)
	static void method3732(int var0) {
		Client.oculusOrbState = var0;
	}
}
