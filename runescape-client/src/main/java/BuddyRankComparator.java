import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
@Implements("BuddyRankComparator")
public class BuddyRankComparator extends AbstractUserComparator {
	@ObfuscatedName("rm")
	@ObfuscatedGetter(
		intValue = -773868241
	)
	static int field1998;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lfp;"
	)
	@Export("clock")
	protected static Clock clock;
	@ObfuscatedName("gd")
	@Export("regionMapArchiveIds")
	static int[] regionMapArchiveIds;
	@ObfuscatedName("u")
	@Export("reversed")
	final boolean reversed;

	public BuddyRankComparator(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljt;Ljt;I)I",
		garbageValue = "-525022889"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (var2.rank != var1.rank) {
			return this.reversed ? var1.rank - var2.rank : var2.rank - var1.rank;
		} else {
			return this.compareUser(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lhf;Lhf;Lhf;Lgz;I)Z",
		garbageValue = "-2130405669"
	)
	public static boolean method3483(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2, MidiPcmStream var3) {
		class197.musicPatchesArchive = var0;
		class197.musicSamplesArchive = var1;
		class197.soundEffectsArchive = var2;
		FaceNormal.midiPcmStream = var3;
		return true;
	}
}
