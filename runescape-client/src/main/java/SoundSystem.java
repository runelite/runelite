import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
@Implements("SoundSystem")
public class SoundSystem implements Runnable {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "[Ldw;"
	)
	@Export("players")
	volatile PcmPlayer[] players;

	SoundSystem() {
		this.players = new PcmPlayer[2];
	}

	public void run() {
		try {
			for (int var1 = 0; var1 < 2; ++var1) {
				PcmPlayer var2 = this.players[var1];
				if (var2 != null) {
					var2.run();
				}
			}
		} catch (Exception var4) {
			class225.RunException_sendStackTrace((String)null, var4);
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lii;Lii;Lii;Lii;I)V",
		garbageValue = "-1591363880"
	)
	public static void method2562(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2, AbstractArchive var3) {
		class197.Widget_archive = var0;
		Calendar.Widget_modelsArchive = var1;
		Username.Widget_spritesArchive = var2;
		class162.Widget_fontsArchive = var3;
		WorldMapLabel.Widget_interfaceComponents = new Widget[class197.Widget_archive.getGroupCount()][];
		class197.Widget_loadedInterfaces = new boolean[class197.Widget_archive.getGroupCount()];
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-660130030"
	)
	@Export("isKeyDown")
	public static final boolean isKeyDown() {
		synchronized(KeyHandler.KeyHandler_instance) {
			if (KeyHandler.field408 == KeyHandler.field406) {
				return false;
			} else {
				RouteStrategy.field2102 = KeyHandler.field403[KeyHandler.field406];
				class51.field432 = KeyHandler.field410[KeyHandler.field406];
				KeyHandler.field406 = KeyHandler.field406 + 1 & 127;
				return true;
			}
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1995069725"
	)
	static void method2563() {
		Messages.Messages_channels.clear();
		Messages.Messages_hashTable.clear();
		Messages.Messages_queue.clear();
		Messages.Messages_count = 0;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(Lir;I)Z",
		garbageValue = "-676934548"
	)
	static boolean method2565(ObjectDefinition var0) {
		if (var0.transforms != null) {
			int[] var1 = var0.transforms;

			for (int var2 = 0; var2 < var1.length; ++var2) {
				int var3 = var1[var2];
				ObjectDefinition var4 = Occluder.getObjectDefinition(var3);
				if (var4.mapIconId != -1) {
					return true;
				}
			}
		} else if (var0.mapIconId != -1) {
			return true;
		}

		return false;
	}
}
