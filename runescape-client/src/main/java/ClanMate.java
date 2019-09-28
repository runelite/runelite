import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jo")
@Implements("ClanMate")
public class ClanMate extends Buddy {
	@ObfuscatedName("dj")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("archive11")
	static Archive archive11;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	@Export("friend")
	TriBool friend;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	@Export("ignored")
	TriBool ignored;

	ClanMate() {
		this.friend = TriBool.TriBool_unknown;
		this.ignored = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-407939513"
	)
	@Export("clearIsFriend")
	void clearIsFriend() {
		this.friend = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1388018244"
	)
	@Export("isFriend")
	public final boolean isFriend() {
		if (this.friend == TriBool.TriBool_unknown) {
			this.fillIsFriend();
		}

		return this.friend == TriBool.TriBool_true;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2101732622"
	)
	@Export("fillIsFriend")
	void fillIsFriend() {
		this.friend = Tiles.friendSystem.friendsList.contains(super.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "349082109"
	)
	@Export("clearIsIgnored")
	void clearIsIgnored() {
		this.ignored = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1700541155"
	)
	@Export("isIgnored")
	public final boolean isIgnored() {
		if (this.ignored == TriBool.TriBool_unknown) {
			this.fillIsIgnored();
		}

		return this.ignored == TriBool.TriBool_true;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-735499948"
	)
	@Export("fillIsIgnored")
	void fillIsIgnored() {
		this.ignored = Tiles.friendSystem.ignoreList.contains(super.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lhp;Lhp;III)Lkn;",
		garbageValue = "-569680121"
	)
	public static Font method4976(AbstractArchive var0, AbstractArchive var1, int var2, int var3) {
		return !VertexNormal.method2962(var0, var2, var3) ? null : class49.method893(var1.takeFile(var2, var3));
	}
}
