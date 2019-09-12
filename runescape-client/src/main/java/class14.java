import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class14 {
	@ObfuscatedName("g")
	@Export("Interpreter_stringLocals")
	static String[] Interpreter_stringLocals;
	@ObfuscatedName("hs")
	@ObfuscatedGetter(
		intValue = 887087521
	)
	@Export("cameraZ")
	static int cameraZ;

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "-284135930"
	)
	static String method145() {
		String var0 = "";

		Message var2;
		for (Iterator var1 = Messages.Messages_hashTable.iterator(); var1.hasNext(); var0 = var0 + var2.sender + ':' + var2.text + '\n') {
			var2 = (Message)var1.next();
		}

		return var0;
	}

	@ObfuscatedName("et")
	@ObfuscatedSignature(
		signature = "(Lio;Ljava/lang/String;I)V",
		garbageValue = "1397921952"
	)
	static void method142(Archive var0, String var1) {
		ArchiveLoader var2 = new ArchiveLoader(var0, var1);
		Client.archiveLoaders.add(var2);
		Client.field895 += var2.groupCount;
	}

	@ObfuscatedName("jw")
	@ObfuscatedSignature(
		signature = "(Lhy;I)V",
		garbageValue = "-1667373140"
	)
	static final void method143(Widget var0) {
		int var1 = var0.contentType;
		if (var1 == 324) {
			if (Client.field703 == -1) {
				Client.field703 = var0.spriteId2;
				Client.field888 = var0.spriteId;
			}

			if (Client.playerAppearance.isFemale) {
				var0.spriteId2 = Client.field703;
			} else {
				var0.spriteId2 = Client.field888;
			}

		} else if (var1 == 325) {
			if (Client.field703 == -1) {
				Client.field703 = var0.spriteId2;
				Client.field888 = var0.spriteId;
			}

			if (Client.playerAppearance.isFemale) {
				var0.spriteId2 = Client.field888;
			} else {
				var0.spriteId2 = Client.field703;
			}

		} else if (var1 == 327) {
			var0.modelAngleX = 150;
			var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
			var0.modelType = 5;
			var0.modelId = 0;
		} else if (var1 == 328) {
			var0.modelAngleX = 150;
			var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
			var0.modelType = 5;
			var0.modelId = 1;
		}
	}

	@ObfuscatedName("ks")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "71"
	)
	static void method144() {
		if (Client.oculusOrbState == 1) {
			Client.field824 = true;
		}

	}
}
