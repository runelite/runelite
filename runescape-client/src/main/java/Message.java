import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
@Implements("Message")
public class Message extends DualNode {
	@ObfuscatedName("f")
	public static short[][] field604;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	static IndexedSprite field606;
	@ObfuscatedName("gf")
	@ObfuscatedSignature(
		signature = "Lly;"
	)
	@Export("compass")
	static Sprite compass;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -235508607
	)
	@Export("count")
	int count;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 468304279
	)
	@Export("cycle")
	int cycle;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1991230871
	)
	@Export("type")
	int type;
	@ObfuscatedName("p")
	@Export("sender")
	String sender;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("senderUsername")
	Username senderUsername;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Ljy;"
	)
	@Export("isFromFriend0")
	TriBool isFromFriend0;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Ljy;"
	)
	@Export("isFromIgnored0")
	TriBool isFromIgnored0;
	@ObfuscatedName("i")
	@Export("prefix")
	String prefix;
	@ObfuscatedName("c")
	@Export("text")
	String text;

	Message(int var1, String var2, String var3, String var4) {
		this.isFromFriend0 = TriBool.TriBool_unknown;
		this.isFromIgnored0 = TriBool.TriBool_unknown;
		this.set(var1, var2, var3, var4);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
		garbageValue = "-46"
	)
	@Export("set")
	void set(int var1, String var2, String var3, String var4) {
		this.count = HorizontalAlignment.method4701();
		this.cycle = Client.cycle;
		this.type = var1;
		this.sender = var2;
		this.fillSenderUsername();
		this.prefix = var3;
		this.text = var4;
		this.clearIsFromFriend();
		this.clearIsFromIgnored();
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1828914917"
	)
	@Export("clearIsFromFriend")
	void clearIsFromFriend() {
		this.isFromFriend0 = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1322141944"
	)
	@Export("isFromFriend")
	final boolean isFromFriend() {
		if (this.isFromFriend0 == TriBool.TriBool_unknown) {
			this.fillIsFromFriend();
		}

		return this.isFromFriend0 == TriBool.TriBool_true;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-728879206"
	)
	@Export("fillIsFromFriend")
	void fillIsFromFriend() {
		this.isFromFriend0 = ArchiveLoader.friendSystem.friendsList.contains(this.senderUsername) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-391302038"
	)
	@Export("clearIsFromIgnored")
	void clearIsFromIgnored() {
		this.isFromIgnored0 = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1146765519"
	)
	@Export("isFromIgnored")
	final boolean isFromIgnored() {
		if (this.isFromIgnored0 == TriBool.TriBool_unknown) {
			this.fillIsFromIgnored();
		}

		return this.isFromIgnored0 == TriBool.TriBool_true;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1299937735"
	)
	@Export("fillIsFromIgnored")
	void fillIsFromIgnored() {
		this.isFromIgnored0 = ArchiveLoader.friendSystem.ignoreList.contains(this.senderUsername) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1250059182"
	)
	@Export("fillSenderUsername")
	final void fillSenderUsername() {
		if (this.sender != null) {
			this.senderUsername = new Username(GrandExchangeOfferTotalQuantityComparator.removeImageTag(this.sender), class40.loginType);
		} else {
			this.senderUsername = null;
		}

	}
}
