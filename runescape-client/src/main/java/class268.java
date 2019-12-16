import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
public class class268 {
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1635748915
	)
	public static int field3524;
	@ObfuscatedName("x")
	@Export("SpriteBuffer_spritePalette")
	public static int[] SpriteBuffer_spritePalette;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Ldx;"
	)
	@Export("soundCache")
	public static SoundCache soundCache;

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;ZI)[B",
		garbageValue = "-1997721504"
	)
	@Export("serialize")
	public static byte[] serialize(Object var0, boolean var1) {
		if (var0 == null) {
			return null;
		} else if (var0 instanceof byte[]) {
			byte[] var6 = (byte[])((byte[])var0);
			int var4 = var6.length;
			byte[] var5 = new byte[var4];
			System.arraycopy(var6, 0, var5, 0, var4);
			return var5;
		} else if (var0 instanceof AbstractByteArrayCopier) {
			AbstractByteArrayCopier var2 = (AbstractByteArrayCopier)var0;
			return var2.get();
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("e")
	static int method5012(long var0) {
		return (int)(var0 >>> 14 & 3L);
	}

	@ObfuscatedName("fh")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-1968592284"
	)
	@Export("queueSoundEffect")
	static void queueSoundEffect(int var0, int var1, int var2) {
		if (Client.soundEffectVolume != 0 && var1 != 0 && Client.soundEffectCount < 50) {
			Client.soundEffectIds[Client.soundEffectCount] = var0;
			Client.queuedSoundEffectLoops[Client.soundEffectCount] = var1;
			Client.queuedSoundEffectDelays[Client.soundEffectCount] = var2;
			Client.soundEffects[Client.soundEffectCount] = null;
			Client.soundLocations[Client.soundEffectCount] = 0;
			++Client.soundEffectCount;
		}

	}
}
