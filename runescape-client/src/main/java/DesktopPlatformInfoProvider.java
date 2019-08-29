import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lk")
@Implements("DesktopPlatformInfoProvider")
public class DesktopPlatformInfoProvider implements PlatformInfoProvider {
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1435561195
	)
	int field3903;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1717280991
	)
	int field3901;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1506800737
	)
	int field3904;

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)Llx;",
		garbageValue = "-1719381077"
	)
	@Export("get")
	public PlatformInfo get() {
		byte var1;
		if (ByteArrayPool.field3708.startsWith("win")) {
			var1 = 1;
		} else if (ByteArrayPool.field3708.startsWith("mac")) {
			var1 = 2;
		} else if (ByteArrayPool.field3708.startsWith("linux")) {
			var1 = 3;
		} else {
			var1 = 4;
		}

		String var2;
		try {
			var2 = System.getProperty("os.arch").toLowerCase();
		} catch (Exception var27) {
			var2 = "";
		}

		String var3;
		try {
			var3 = System.getProperty("os.version").toLowerCase();
		} catch (Exception var26) {
			var3 = "";
		}

		String var4 = "Unknown";
		String var5 = "1.1";

		try {
			var4 = System.getProperty("java.vendor");
			var5 = System.getProperty("java.version");
		} catch (Exception var25) {
		}

		boolean var24;
		if (!var2.startsWith("amd64") && !var2.startsWith("x86_64")) {
			var24 = false;
		} else {
			var24 = true;
		}

		byte var7 = 0;
		if (var1 == 1) {
			if (var3.indexOf("4.0") != -1) {
				var7 = 1;
			} else if (var3.indexOf("4.1") != -1) {
				var7 = 2;
			} else if (var3.indexOf("4.9") != -1) {
				var7 = 3;
			} else if (var3.indexOf("5.0") != -1) {
				var7 = 4;
			} else if (var3.indexOf("5.1") != -1) {
				var7 = 5;
			} else if (var3.indexOf("5.2") != -1) {
				var7 = 8;
			} else if (var3.indexOf("6.0") != -1) {
				var7 = 6;
			} else if (var3.indexOf("6.1") != -1) {
				var7 = 7;
			} else if (var3.indexOf("6.2") != -1) {
				var7 = 9;
			} else if (var3.indexOf("6.3") != -1) {
				var7 = 10;
			} else if (var3.indexOf("10.0") != -1) {
				var7 = 11;
			}
		} else if (var1 == 2) {
			if (var3.indexOf("10.4") != -1) {
				var7 = 20;
			} else if (var3.indexOf("10.5") != -1) {
				var7 = 21;
			} else if (var3.indexOf("10.6") != -1) {
				var7 = 22;
			} else if (var3.indexOf("10.7") != -1) {
				var7 = 23;
			} else if (var3.indexOf("10.8") != -1) {
				var7 = 24;
			} else if (var3.indexOf("10.9") != -1) {
				var7 = 25;
			} else if (var3.indexOf("10.10") != -1) {
				var7 = 26;
			} else if (var3.indexOf("10.11") != -1) {
				var7 = 27;
			} else if (var3.indexOf("10.12") != -1) {
				var7 = 28;
			} else if (var3.indexOf("10.13") != -1) {
				var7 = 29;
			}
		}

		byte var8;
		if (var4.toLowerCase().indexOf("sun") != -1) {
			var8 = 1;
		} else if (var4.toLowerCase().indexOf("microsoft") != -1) {
			var8 = 2;
		} else if (var4.toLowerCase().indexOf("apple") != -1) {
			var8 = 3;
		} else if (var4.toLowerCase().indexOf("oracle") != -1) {
			var8 = 5;
		} else {
			var8 = 4;
		}

		this.method6147(var5);
		Runtime.getRuntime();
		int var10 = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
		int var11;
		if (this.field3903 > 3) {
			var11 = Runtime.getRuntime().availableProcessors();
		} else {
			var11 = 0;
		}

		byte var12 = 0;
		String var13 = "";
		String var14 = "";
		String var15 = "";
		String var16 = "";
		String var17 = "";
		String var18 = "";
		int[] var23 = new int[3];
		return new PlatformInfo(var1, var24, var7, var8, this.field3903, this.field3901, this.field3904, false, var10, var11, var12, 0, var13, var14, var15, var16, 0, 0, 0, 0, var17, var18, var23, 0, "");
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "28"
	)
	void method6147(String var1) {
		if (var1.startsWith("1.")) {
			this.method6148(var1);
		} else {
			this.method6145(var1);
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "1225882646"
	)
	void method6148(String var1) {
		String[] var2 = var1.split("\\.");

		try {
			this.field3903 = Integer.parseInt(var2[1]);
			var2 = var2[2].split("_");
			this.field3901 = Integer.parseInt(var2[0]);
			this.field3904 = Integer.parseInt(var2[1]);
		} catch (Exception var4) {
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;S)V",
		garbageValue = "-31875"
	)
	void method6145(String var1) {
		String[] var2 = var1.split("\\.");

		try {
			this.field3903 = Integer.parseInt(var2[0]);
			this.field3901 = Integer.parseInt(var2[1]);
			this.field3904 = Integer.parseInt(var2[2]);
		} catch (Exception var4) {
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "([BS)Lcr;",
		garbageValue = "10322"
	)
	@Export("newScript")
	static Script newScript(byte[] var0) {
		Script var1 = new Script();
		Buffer var2 = new Buffer(var0);
		var2.offset = var2.array.length - 2;
		int var3 = var2.readUnsignedShort();
		int var4 = var2.array.length - 2 - var3 - 12;
		var2.offset = var4;
		int var5 = var2.readInt();
		var1.localIntCount = var2.readUnsignedShort();
		var1.localStringCount = var2.readUnsignedShort();
		var1.intArgumentCount = var2.readUnsignedShort();
		var1.stringArgumentCount = var2.readUnsignedShort();
		int var6 = var2.readUnsignedByte();
		int var7;
		int var8;
		if (var6 > 0) {
			var1.switches = var1.newIterableNodeHashTable(var6);

			for (var7 = 0; var7 < var6; ++var7) {
				var8 = var2.readUnsignedShort();
				int var9;
				int var11;
				if (var8 > 0) {
					var11 = var8 - 1;
					var11 |= var11 >>> 1;
					var11 |= var11 >>> 2;
					var11 |= var11 >>> 4;
					var11 |= var11 >>> 8;
					var11 |= var11 >>> 16;
					int var10 = var11 + 1;
					var9 = var10;
				} else {
					var9 = 1;
				}

				IterableNodeHashTable var13 = new IterableNodeHashTable(var9);
				var1.switches[var7] = var13;

				while (var8-- > 0) {
					var11 = var2.readInt();
					int var12 = var2.readInt();
					var13.put(new IntegerNode(var12), (long)var11);
				}
			}
		}

		var2.offset = 0;
		var2.readStringCp1252NullTerminatedOrNull();
		var1.opcodes = new int[var5];
		var1.intOperands = new int[var5];
		var1.stringOperands = new String[var5];

		for (var7 = 0; var2.offset < var4; var1.opcodes[var7++] = var8) {
			var8 = var2.readUnsignedShort();
			if (var8 == 3) {
				var1.stringOperands[var7] = var2.readStringCp1252NullTerminated();
			} else if (var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
				var1.intOperands[var7] = var2.readInt();
			} else {
				var1.intOperands[var7] = var2.readUnsignedByte();
			}
		}

		return var1;
	}
}
