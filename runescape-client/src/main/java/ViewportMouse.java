import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
@Implements("ViewportMouse")
public class ViewportMouse {
	@ObfuscatedName("q")
	@Export("ViewportMouse_isInViewport")
	public static boolean ViewportMouse_isInViewport;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 284050525
	)
	@Export("ViewportMouse_x")
	public static int ViewportMouse_x;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -245246371
	)
	@Export("ViewportMouse_y")
	public static int ViewportMouse_y;
	@ObfuscatedName("p")
	@Export("ViewportMouse_false0")
	public static boolean ViewportMouse_false0;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -933115495
	)
	static int field1745;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -401508143
	)
	static int field1746;
	@ObfuscatedName("i")
	@Export("loadedInterfaces")
	public static boolean[] loadedInterfaces;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("Widget_modelsArchive")
	static AbstractArchive Widget_modelsArchive;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -900084985
	)
	static int field1741;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1866489791
	)
	@Export("ViewportMouse_entityCount")
	public static int ViewportMouse_entityCount;
	@ObfuscatedName("v")
	@Export("ViewportMouse_entityTags")
	public static long[] ViewportMouse_entityTags;
	@ObfuscatedName("fq")
	@ObfuscatedGetter(
		intValue = -572146471
	)
	static int field1747;

	static {
		ViewportMouse_isInViewport = false;
		ViewportMouse_x = 0;
		ViewportMouse_y = 0;
		ViewportMouse_false0 = false;
		ViewportMouse_entityCount = 0;
		ViewportMouse_entityTags = new long[1000];
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IS)Liy;",
		garbageValue = "4095"
	)
	@Export("getObjectDefinition")
	public static ObjectDefinition getObjectDefinition(int var0) {
		ObjectDefinition var1 = (ObjectDefinition)ObjectDefinition.ObjectDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = ObjectDefinition.ObjectDefinition_archive.takeFile(6, var0);
			var1 = new ObjectDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			if (var1.isSolid) {
				var1.interactType = 0;
				var1.boolean1 = false;
			}

			ObjectDefinition.ObjectDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IB)Lcx;",
		garbageValue = "1"
	)
	@Export("getScript")
	static Script getScript(int var0) {
		Script var1 = (Script)Script.Script_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = UserComparator4.archive12.takeFile(var0, 0);
			if (var2 == null) {
				return null;
			} else {
				var1 = World.newScript(var2);
				Script.Script_cached.put(var1, (long)var0);
				return var1;
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Liu;IIIBZI)V",
		garbageValue = "-913325342"
	)
	@Export("requestNetFile")
	static void requestNetFile(Archive var0, int var1, int var2, int var3, byte var4, boolean var5) {
		long var6 = (long)((var1 << 16) + var2);
		NetFileRequest var8 = (NetFileRequest)NetCache.NetCache_pendingPriorityWrites.get(var6);
		if (var8 == null) {
			var8 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.get(var6);
			if (var8 == null) {
				var8 = (NetFileRequest)NetCache.NetCache_pendingWrites.get(var6);
				if (var8 != null) {
					if (var5) {
						var8.removeDual();
						NetCache.NetCache_pendingPriorityWrites.put(var8, var6);
						--NetCache.NetCache_pendingWritesCount;
						++NetCache.NetCache_pendingPriorityWritesCount;
					}

				} else {
					if (!var5) {
						var8 = (NetFileRequest)NetCache.NetCache_pendingResponses.get(var6);
						if (var8 != null) {
							return;
						}
					}

					var8 = new NetFileRequest();
					var8.archive = var0;
					var8.crc = var3;
					var8.padding = var4;
					if (var5) {
						NetCache.NetCache_pendingPriorityWrites.put(var8, var6);
						++NetCache.NetCache_pendingPriorityWritesCount;
					} else {
						NetCache.NetCache_pendingWritesQueue.addFirst(var8);
						NetCache.NetCache_pendingWrites.put(var8, var6);
						++NetCache.NetCache_pendingWritesCount;
					}

				}
			}
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)I",
		garbageValue = "-1418597327"
	)
	public static int method2971(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			var2 = (var2 << 5) - var2 + var0.charAt(var3);
		}

		return var2;
	}
}
