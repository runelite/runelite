import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
@Implements("ClanMate")
public class ClanMate extends Buddy {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	@Export("friend")
	TriBool friend;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	@Export("ignored")
	TriBool ignored;

	ClanMate() {
		this.friend = TriBool.TriBool_unknown;
		this.ignored = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1629200475"
	)
	@Export("clearIsFriend")
	void clearIsFriend() {
		this.friend = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-431370449"
	)
	@Export("isFriend")
	public final boolean isFriend() {
		if (this.friend == TriBool.TriBool_unknown) {
			this.fillIsFriend();
		}

		return this.friend == TriBool.TriBool_true;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2053877048"
	)
	@Export("fillIsFriend")
	void fillIsFriend() {
		this.friend = class32.friendSystem.friendsList.contains(super.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-72"
	)
	@Export("clearIsIgnored")
	void clearIsIgnored() {
		this.ignored = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1045653770"
	)
	@Export("isIgnored")
	public final boolean isIgnored() {
		if (this.ignored == TriBool.TriBool_unknown) {
			this.fillIsIgnored();
		}

		return this.ignored == TriBool.TriBool_true;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1531975898"
	)
	@Export("fillIsIgnored")
	void fillIsIgnored() {
		this.ignored = class32.friendSystem.ignoreList.contains(super.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(CB)Z",
		garbageValue = "96"
	)
	@Export("isCharAlphabetic")
	public static boolean isCharAlphabetic(char var0) {
		return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
	}
}
