import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
@Implements("PlayerType")
public enum PlayerType implements Enumerated {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	@Export("PlayerType_normal")
	PlayerType_normal(0, -1, true, false, true),
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	@Export("PlayerType_playerModerator")
	PlayerType_playerModerator(1, 0, true, true, true),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	@Export("PlayerType_jagexModerator")
	PlayerType_jagexModerator(2, 1, true, true, false),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	@Export("PlayerType_ironman")
	PlayerType_ironman(3, 2, false, false, true),
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	@Export("PlayerType_ultimateIronman")
	PlayerType_ultimateIronman(4, 3, false, false, true),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	@Export("PlayerType_hardcoreIronman")
	PlayerType_hardcoreIronman(5, 10, false, false, true);

	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -226803421
	)
	@Export("id")
	final int id;
	@ObfuscatedName("q")
	@Export("modIcon")
	public final int modIcon;
	@ObfuscatedName("x")
	@Export("isPrivileged")
	public final boolean isPrivileged;
	@ObfuscatedName("d")
	@Export("isUser")
	public final boolean isUser;

	PlayerType(int var3, int var4, boolean var5, boolean var6, boolean var7) {
		this.id = var3;
		this.modIcon = var4 * 840543109;
		this.isPrivileged = var6;
		this.isUser = var7;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-32"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;Lhz;Lgp;I)Z",
		garbageValue = "1965364942"
	)
	@Export("setAudioArchives")
	public static boolean setAudioArchives(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2, MidiPcmStream var3) {
		class197.musicPatchesArchive = var0;
		class197.musicSamplesArchive = var1;
		class197.soundEffectsArchive = var2;
		class197.midiPcmStream = var3;
		return true;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(IZII)V",
		garbageValue = "912146837"
	)
	@Export("PcmPlayer_configure")
	public static final void PcmPlayer_configure(int var0, boolean var1, int var2) {
		if (var0 >= 8000 && var0 <= 48000) {
			PcmPlayer.PcmPlayer_sampleRate = var0;
			PcmPlayer.PcmPlayer_stereo = var1;
			FloorDecoration.PcmPlayer_count = var2;
		} else {
			throw new IllegalArgumentException();
		}
	}
}
