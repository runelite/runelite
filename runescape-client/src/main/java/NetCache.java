import java.security.SecureRandom;
import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
@Implements("NetCache")
public class NetCache {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lkn;"
	)
	@Export("NetCache_socket")
	public static AbstractSocket NetCache_socket;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 264322769
	)
	@Export("NetCache_loadTime")
	static int NetCache_loadTime;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		longValue = 5787144864761896795L
	)
	static long field3171;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("NetCache_pendingPriorityWrites")
	static NodeHashTable NetCache_pendingPriorityWrites;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -889206253
	)
	@Export("NetCache_pendingPriorityWritesCount")
	static int NetCache_pendingPriorityWritesCount;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("NetCache_pendingPriorityResponses")
	static NodeHashTable NetCache_pendingPriorityResponses;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -837346681
	)
	@Export("NetCache_pendingPriorityResponsesCount")
	static int NetCache_pendingPriorityResponsesCount;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Liw;"
	)
	@Export("NetCache_pendingWritesQueue")
	static DualNodeDeque NetCache_pendingWritesQueue;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("NetCache_pendingWrites")
	static NodeHashTable NetCache_pendingWrites;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1003289655
	)
	@Export("NetCache_pendingWritesCount")
	static int NetCache_pendingWritesCount;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("NetCache_pendingResponses")
	static NodeHashTable NetCache_pendingResponses;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -798851663
	)
	@Export("NetCache_pendingResponsesCount")
	static int NetCache_pendingResponsesCount;
	@ObfuscatedName("o")
	static boolean field3181;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lhi;"
	)
	@Export("NetCache_currentResponse")
	static NetFileRequest NetCache_currentResponse;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lkg;"
	)
	@Export("NetCache_responseHeaderBuffer")
	static Buffer NetCache_responseHeaderBuffer;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1164709819
	)
	static int field3188;
	@ObfuscatedName("d")
	@Export("NetCache_crc")
	static CRC32 NetCache_crc;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "[Lij;"
	)
	@Export("NetCache_archives")
	static Archive[] NetCache_archives;
	@ObfuscatedName("m")
	static byte field3184;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1730449229
	)
	@Export("NetCache_crcMismatches")
	public static int NetCache_crcMismatches;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1846767251
	)
	@Export("NetCache_ioExceptions")
	public static int NetCache_ioExceptions;

	static {
		NetCache_loadTime = 0;
		NetCache_pendingPriorityWrites = new NodeHashTable(4096);
		NetCache_pendingPriorityWritesCount = 0;
		NetCache_pendingPriorityResponses = new NodeHashTable(32);
		NetCache_pendingPriorityResponsesCount = 0;
		NetCache_pendingWritesQueue = new DualNodeDeque();
		NetCache_pendingWrites = new NodeHashTable(4096);
		NetCache_pendingWritesCount = 0;
		NetCache_pendingResponses = new NodeHashTable(4096);
		NetCache_pendingResponsesCount = 0;
		NetCache_responseHeaderBuffer = new Buffer(8);
		field3188 = 0;
		NetCache_crc = new CRC32();
		NetCache_archives = new Archive[256];
		field3184 = 0;
		NetCache_crcMismatches = 0;
		NetCache_ioExceptions = 0;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Ljava/security/SecureRandom;",
		garbageValue = "967007361"
	)
	static SecureRandom method4394() {
		SecureRandom var0 = new SecureRandom();
		var0.nextInt();
		return var0;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)Lib;",
		garbageValue = "1375057388"
	)
	@Export("VarpDefinition_get")
	public static VarpDefinition VarpDefinition_get(int var0) {
		VarpDefinition var1 = (VarpDefinition)VarpDefinition.VarpDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = VarpDefinition.VarpDefinition_archive.takeFile(16, var0);
			var1 = new VarpDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			VarpDefinition.VarpDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(ILci;ZI)I",
		garbageValue = "1873047599"
	)
	static int method4397(int var0, Script var1, boolean var2) {
		if (var0 < 1000) {
			return ServerPacket.method3657(var0, var1, var2);
		} else if (var0 < 1100) {
			return GameShell.method952(var0, var1, var2);
		} else if (var0 < 1200) {
			return SecureRandomCallable.method1171(var0, var1, var2);
		} else if (var0 < 1300) {
			return Interpreter.method1995(var0, var1, var2);
		} else if (var0 < 1400) {
			return class189.method3698(var0, var1, var2);
		} else if (var0 < 1500) {
			return Varcs.method2201(var0, var1, var2);
		} else if (var0 < 1600) {
			return Canvas.method873(var0, var1, var2);
		} else if (var0 < 1700) {
			return Varcs.method2220(var0, var1, var2);
		} else if (var0 < 1800) {
			return Decimator.method2564(var0, var1, var2);
		} else if (var0 < 1900) {
			return Messages.method2241(var0, var1, var2);
		} else if (var0 < 2000) {
			return Actor.method1774(var0, var1, var2);
		} else if (var0 < 2100) {
			return GameShell.method952(var0, var1, var2);
		} else if (var0 < 2200) {
			return SecureRandomCallable.method1171(var0, var1, var2);
		} else if (var0 < 2300) {
			return Interpreter.method1995(var0, var1, var2);
		} else if (var0 < 2400) {
			return class189.method3698(var0, var1, var2);
		} else if (var0 < 2500) {
			return Varcs.method2201(var0, var1, var2);
		} else if (var0 < 2600) {
			return Language.method3710(var0, var1, var2);
		} else if (var0 < 2700) {
			return AbstractWorldMapIcon.method618(var0, var1, var2);
		} else if (var0 < 2800) {
			return class267.method5067(var0, var1, var2);
		} else if (var0 < 2900) {
			return WorldMapDecoration.method355(var0, var1, var2);
		} else if (var0 < 3000) {
			return Actor.method1774(var0, var1, var2);
		} else if (var0 < 3200) {
			return Timer.method5098(var0, var1, var2);
		} else if (var0 < 3300) {
			return Skeleton.method3107(var0, var1, var2);
		} else if (var0 < 3400) {
			return WorldMapSection1.method608(var0, var1, var2);
		} else if (var0 < 3500) {
			return class83.method2091(var0, var1, var2);
		} else if (var0 < 3700) {
			return class16.method195(var0, var1, var2);
		} else if (var0 < 4000) {
			return SoundSystem.method2530(var0, var1, var2);
		} else if (var0 < 4100) {
			return BoundaryObject.method3313(var0, var1, var2);
		} else if (var0 < 4200) {
			return WorldMapArea.method396(var0, var1, var2);
		} else if (var0 < 4300) {
			return class4.method66(var0, var1, var2);
		} else if (var0 < 5100) {
			return MusicPatchNode2.method3747(var0, var1, var2);
		} else if (var0 < 5400) {
			return WorldMapData_0.method193(var0, var1, var2);
		} else if (var0 < 5600) {
			return class16.method196(var0, var1, var2);
		} else if (var0 < 5700) {
			return Varcs.method2194(var0, var1, var2);
		} else if (var0 < 6300) {
			return class16.method197(var0, var1, var2);
		} else if (var0 < 6600) {
			return ModelData0.method3299(var0, var1, var2);
		} else {
			return var0 < 6700 ? GrandExchangeOfferWorldComparator.method78(var0, var1, var2) : 2;
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2033375403"
	)
	public static void method4399() {
		while (true) {
			ArchiveDiskAction var0;
			synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
				var0 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_responseQueue.removeLast();
			}

			if (var0 == null) {
				return;
			}

			var0.archive.load(var0.archiveDisk, (int)var0.key, var0.data, false);
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "([BIIB)Ljava/lang/String;",
		garbageValue = "-77"
	)
	@Export("decodeStringCp1252")
	public static String decodeStringCp1252(byte[] var0, int var1, int var2) {
		char[] var3 = new char[var2];
		int var4 = 0;

		for (int var5 = 0; var5 < var2; ++var5) {
			int var6 = var0[var5 + var1] & 255;
			if (var6 != 0) {
				if (var6 >= 128 && var6 < 160) {
					char var7 = class287.cp1252AsciiExtension[var6 - 128];
					if (var7 == 0) {
						var7 = '?';
					}

					var6 = var7;
				}

				var3[var4++] = (char)var6;
			}
		}

		return new String(var3, 0, var4);
	}
}
