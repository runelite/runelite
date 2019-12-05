import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("TileItem")
public final class TileItem extends Entity {
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1378813027
	)
	@Export("id")
	int id;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -744056543
	)
	@Export("quantity")
	int quantity;

	TileItem() {
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)Ldf;",
		garbageValue = "-174129419"
	)
	@Export("getModel")
	protected final Model getModel() {
		return Interpreter.ItemDefinition_get(this.id).getModel(this.quantity);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-657071617"
	)
	static int method2142() {
		return ++Messages.Messages_count - 1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I[BLke;I)V",
		garbageValue = "261282715"
	)
	static void method2144(int var0, byte[] var1, ArchiveDisk var2) {
		ArchiveDiskAction var3 = new ArchiveDiskAction();
		var3.type = 0;
		var3.key = (long)var0;
		var3.data = var1;
		var3.archiveDisk = var2;
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
			ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var3);
		}

		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
			if (ArchiveDiskActionHandler.field3155 == 0) {
				ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread = new Thread(new ArchiveDiskActionHandler());
				ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.setDaemon(true);
				ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.start();
				ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.setPriority(5);
			}

			ArchiveDiskActionHandler.field3155 = 600;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)[Llz;",
		garbageValue = "1567603779"
	)
	@Export("FillMode_values")
	public static FillMode[] FillMode_values() {
		return new FillMode[]{FillMode.field3854, FillMode.SOLID, FillMode.field3855};
	}

	@ObfuscatedName("km")
	@ObfuscatedSignature(
		signature = "(Lhl;IIIB)V",
		garbageValue = "123"
	)
	@Export("drawCompass")
	static final void drawCompass(Widget var0, int var1, int var2, int var3) {
		SpriteMask var4 = var0.getSpriteMask(false);
		if (var4 != null) {
			if (Client.minimapState < 3) {
				class40.compass.drawRotatedMaskedCenteredAround(var1, var2, var4.width, var4.height, 25, 25, Client.camAngleY, 256, var4.xStarts, var4.xWidths);
			} else {
				Rasterizer2D.Rasterizer2D_fillMaskedRectangle(var1, var2, 0, var4.xStarts, var4.xWidths);
			}

		}
	}
}
