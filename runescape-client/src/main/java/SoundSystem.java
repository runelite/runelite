import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
@Implements("SoundSystem")
public class SoundSystem implements Runnable {
	@ObfuscatedName("j")
	@Export("SpriteBuffer_spriteHeights")
	public static int[] SpriteBuffer_spriteHeights;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "[Ldh;"
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
			class188.RunException_sendStackTrace((String)null, var4);
		}

	}
}
