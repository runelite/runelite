import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("ItemContainer")
public class ItemContainer extends Node {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Llh;"
	)
	@Export("itemContainers")
	static NodeHashTable itemContainers;
	@ObfuscatedName("t")
	@Export("ids")
	int[] ids;
	@ObfuscatedName("n")
	@Export("quantities")
	int[] quantities;

	static {
		itemContainers = new NodeHashTable(32);
	}

	ItemContainer() {
		this.ids = new int[]{-1};
		this.quantities = new int[]{0};
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "4"
	)
	static void method1250() {
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
			if (ArchiveDiskActionHandler.field3132 == 0) {
				ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread = new Thread(new ArchiveDiskActionHandler());
				ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.setDaemon(true);
				ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.start();
				ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.setPriority(5);
			}

			ArchiveDiskActionHandler.field3132 = 600;
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "([BIII)Ljava/lang/String;",
		garbageValue = "2029003644"
	)
	public static String method1252(byte[] var0, int var1, int var2) {
		StringBuilder var3 = new StringBuilder();

		for (int var4 = var1; var4 < var2 + var1; var4 += 3) {
			int var5 = var0[var4] & 255;
			var3.append(class289.field3636[var5 >>> 2]);
			if (var4 < var2 - 1) {
				int var6 = var0[var4 + 1] & 255;
				var3.append(class289.field3636[(var5 & 3) << 4 | var6 >>> 4]);
				if (var4 < var2 - 2) {
					int var7 = var0[var4 + 2] & 255;
					var3.append(class289.field3636[(var6 & 15) << 2 | var7 >>> 6]).append(class289.field3636[var7 & 63]);
				} else {
					var3.append(class289.field3636[(var6 & 15) << 2]).append("=");
				}
			} else {
				var3.append(class289.field3636[(var5 & 3) << 4]).append("==");
			}
		}

		return var3.toString();
	}
}
