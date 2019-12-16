import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("Messages")
public class Messages {
	@ObfuscatedName("f")
	@Export("Messages_channels")
	static final Map Messages_channels;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Llc;"
	)
	@Export("Messages_hashTable")
	static final IterableNodeHashTable Messages_hashTable;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lji;"
	)
	@Export("Messages_queue")
	static final IterableDualNodeQueue Messages_queue;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -984405515
	)
	@Export("Messages_count")
	static int Messages_count;

	static {
		Messages_channels = new HashMap();
		Messages_hashTable = new IterableNodeHashTable(1024);
		Messages_queue = new IterableDualNodeQueue();
		Messages_count = 0;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-2062774197"
	)
	public static boolean method2240(int var0) {
		return var0 >= WorldMapDecorationType.field2719.id && var0 <= WorldMapDecorationType.field2708.id || var0 == WorldMapDecorationType.field2707.id;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lhz;I)V",
		garbageValue = "2079698916"
	)
	public static void method2227(AbstractArchive var0) {
		StructDefinition.StructDefinition_archive = var0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IB)Lib;",
		garbageValue = "83"
	)
	@Export("FloorUnderlayDefinition_get")
	public static FloorOverlayDefinition FloorUnderlayDefinition_get(int var0) {
		FloorOverlayDefinition var1 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var0);
			var1 = new FloorOverlayDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2), var0);
			}

			var1.postDecode();
			FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Lmk;",
		garbageValue = "1038906134"
	)
	@Export("getPreferencesFile")
	public static AccessFile getPreferencesFile(String var0, String var1, boolean var2) {
		File var3 = new File(JagexCache.cacheDir, "preferences" + var0 + ".dat");
		if (var3.exists()) {
			try {
				AccessFile var10 = new AccessFile(var3, "rw", 10000L);
				return var10;
			} catch (IOException var9) {
			}
		}

		String var4 = "";
		if (VertexNormal.cacheGamebuild == 33) {
			var4 = "_rc";
		} else if (VertexNormal.cacheGamebuild == 34) {
			var4 = "_wip";
		}

		File var5 = new File(ReflectionCheck.userHomeDirectory, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
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

	@ObfuscatedName("it")
	@ObfuscatedSignature(
		signature = "(Lcq;III)V",
		garbageValue = "-1826909304"
	)
	static final void method2231(MenuAction var0, int var1, int var2) {
		AbstractWorldMapData.menuAction(var0.param0, var0.param1, var0.opcode, var0.identifier, var0.action, var0.action, var1, var2);
	}

	@ObfuscatedName("jo")
	@ObfuscatedSignature(
		signature = "([Lha;Lha;ZI)V",
		garbageValue = "1663251439"
	)
	@Export("revalidateWidgetScroll")
	static void revalidateWidgetScroll(Widget[] var0, Widget var1, boolean var2) {
		int var3 = var1.scrollWidth != 0 ? var1.scrollWidth : var1.width;
		int var4 = var1.scrollHeight != 0 ? var1.scrollHeight : var1.height;
		FloorOverlayDefinition.resizeInterface(var0, var1.id, var3, var4, var2);
		if (var1.children != null) {
			FloorOverlayDefinition.resizeInterface(var1.children, var1.id, var3, var4, var2);
		}

		InterfaceParent var5 = (InterfaceParent)Client.interfaceParents.get((long)var1.id);
		if (var5 != null) {
			LoginPacket.method3572(var5.group, var3, var4, var2);
		}

		if (var1.contentType == 1337) {
		}

	}
}
