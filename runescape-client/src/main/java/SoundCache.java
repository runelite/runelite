import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
@Implements("SoundCache")
public class SoundCache {
	@ObfuscatedName("sr")
	@ObfuscatedSignature(
		signature = "Lh;"
	)
	@Export("grandExchangeEvents")
	static GrandExchangeEvents grandExchangeEvents;
	@ObfuscatedName("fd")
	@ObfuscatedGetter(
		intValue = -1460777927
	)
	static int field1438;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("soundEffectIndex")
	AbstractArchive soundEffectIndex;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("musicSampleIndex")
	AbstractArchive musicSampleIndex;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("musicSamples")
	NodeHashTable musicSamples;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("rawSounds")
	NodeHashTable rawSounds;

	@ObfuscatedSignature(
		signature = "(Lhf;Lhf;)V"
	)
	public SoundCache(AbstractArchive var1, AbstractArchive var2) {
		this.musicSamples = new NodeHashTable(256);
		this.rawSounds = new NodeHashTable(256);
		this.soundEffectIndex = var1;
		this.musicSampleIndex = var2;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II[II)Lcw;",
		garbageValue = "1674765898"
	)
	@Export("getSoundEffect0")
	RawSound getSoundEffect0(int var1, int var2, int[] var3) {
		int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
		var4 |= var1 << 16;
		long var5 = (long)var4;
		RawSound var7 = (RawSound)this.rawSounds.get(var5);
		if (var7 != null) {
			return var7;
		} else if (var3 != null && var3[0] <= 0) {
			return null;
		} else {
			SoundEffect var8 = SoundEffect.readSoundEffect(this.soundEffectIndex, var1, var2);
			if (var8 == null) {
				return null;
			} else {
				var7 = var8.toRawSound();
				this.rawSounds.put(var7, var5);
				if (var3 != null) {
					var3[0] -= var7.samples.length;
				}

				return var7;
			}
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II[IB)Lcw;",
		garbageValue = "-43"
	)
	@Export("getMusicSample0")
	RawSound getMusicSample0(int var1, int var2, int[] var3) {
		int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
		var4 |= var1 << 16;
		long var5 = (long)var4 ^ 4294967296L;
		RawSound var7 = (RawSound)this.rawSounds.get(var5);
		if (var7 != null) {
			return var7;
		} else if (var3 != null && var3[0] <= 0) {
			return null;
		} else {
			VorbisSample var8 = (VorbisSample)this.musicSamples.get(var5);
			if (var8 == null) {
				var8 = VorbisSample.readMusicSample(this.musicSampleIndex, var1, var2);
				if (var8 == null) {
					return null;
				}

				this.musicSamples.put(var8, var5);
			}

			var7 = var8.toRawSound(var3);
			if (var7 == null) {
				return null;
			} else {
				var8.remove();
				this.rawSounds.put(var7, var5);
				return var7;
			}
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I[II)Lcw;",
		garbageValue = "1055604971"
	)
	@Export("getSoundEffect")
	public RawSound getSoundEffect(int var1, int[] var2) {
		if (this.soundEffectIndex.getGroupCount() == 1) {
			return this.getSoundEffect0(0, var1, var2);
		} else if (this.soundEffectIndex.getGroupFileCount(var1) == 1) {
			return this.getSoundEffect0(var1, 0, var2);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I[IB)Lcw;",
		garbageValue = "93"
	)
	@Export("getMusicSample")
	public RawSound getMusicSample(int var1, int[] var2) {
		if (this.musicSampleIndex.getGroupCount() == 1) {
			return this.getMusicSample0(0, var1, var2);
		} else if (this.musicSampleIndex.getGroupFileCount(var1) == 1) {
			return this.getMusicSample0(var1, 0, var2);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "851722270"
	)
	public static boolean method2544(int var0) {
		return (var0 & 1) != 0;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(II)J",
		garbageValue = "-1448942759"
	)
	public static long method2531(int var0) {
		return ViewportMouse.ViewportMouse_entityTags[var0];
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)I",
		garbageValue = "-1986305068"
	)
	@Export("parseInt")
	public static int parseInt(CharSequence var0) {
		return UserComparator8.parseIntCustomRadix(var0, 10, true);
	}
}
