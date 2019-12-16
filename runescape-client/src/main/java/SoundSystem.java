import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
@Implements("SoundSystem")
public class SoundSystem implements Runnable {
	@ObfuscatedName("r")
	@Export("BZip2Decompressor_block")
	static int[] BZip2Decompressor_block;
	@ObfuscatedName("dq")
	@ObfuscatedSignature(
		signature = "Lif;"
	)
	@Export("archive12")
	static Archive archive12;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "[Lcw;"
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
			DesktopPlatformInfoProvider.RunException_sendStackTrace((String)null, var4);
		}

	}

	@ObfuscatedName("kf")
	@ObfuscatedSignature(
		signature = "(Lha;B)V",
		garbageValue = "9"
	)
	static final void method2507(Widget var0) {
		int var1 = var0.contentType;
		if (var1 == 324) {
			if (Client.field893 == -1) {
				Client.field893 = var0.spriteId2;
				Client.field894 = var0.spriteId;
			}

			if (Client.playerAppearance.isFemale) {
				var0.spriteId2 = Client.field893;
			} else {
				var0.spriteId2 = Client.field894;
			}

		} else if (var1 == 325) {
			if (Client.field893 == -1) {
				Client.field893 = var0.spriteId2;
				Client.field894 = var0.spriteId;
			}

			if (Client.playerAppearance.isFemale) {
				var0.spriteId2 = Client.field894;
			} else {
				var0.spriteId2 = Client.field893;
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
}
