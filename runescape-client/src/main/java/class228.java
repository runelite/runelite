import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class228 {
	@ObfuscatedName("dc")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	@Export("archive8")
	static Archive archive8;

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lmx;I)I",
		garbageValue = "-1599704151"
	)
	public static final int method4205(LoginType var0) {
		if (var0 == null) {
			return 12;
		} else {
			switch(var0.field4058) {
			case 7:
				return 20;
			default:
				return 12;
			}
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IB)Lik;",
		garbageValue = "2"
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

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(ILlq;Lih;I)V",
		garbageValue = "-70206811"
	)
	static void method4204(int var0, ArchiveDisk var1, Archive var2) {
		ArchiveDiskAction var3 = new ArchiveDiskAction();
		var3.type = 1;
		var3.key = (long)var0;
		var3.archiveDisk = var1;
		var3.archive = var2;
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
			ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var3);
		}

		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
			if (ArchiveDiskActionHandler.field3151 == 0) {
				class197.ArchiveDiskActionHandler_thread = new Thread(new ArchiveDiskActionHandler());
				class197.ArchiveDiskActionHandler_thread.setDaemon(true);
				class197.ArchiveDiskActionHandler_thread.start();
				class197.ArchiveDiskActionHandler_thread.setPriority(5);
			}

			ArchiveDiskActionHandler.field3151 = 600;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Liy;II)Z",
		garbageValue = "-2041528291"
	)
	static boolean method4202(AbstractArchive var0, int var1) {
		byte[] var2 = var0.takeFileFlat(var1);
		if (var2 == null) {
			return false;
		} else {
			MusicPatch.SpriteBuffer_decode(var2);
			return true;
		}
	}
}
