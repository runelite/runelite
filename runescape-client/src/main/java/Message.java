import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
@Implements("Message")
public class Message extends DualNode {
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1109124741
	)
	@Export("count")
	int count;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1203211479
	)
	@Export("cycle")
	int cycle;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1935064875
	)
	@Export("type")
	int type;
	@ObfuscatedName("g")
	@Export("sender")
	String sender;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	@Export("senderUsername")
	Username senderUsername;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lja;"
	)
	@Export("isFromFriend0")
	TriBool isFromFriend0;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lja;"
	)
	@Export("isFromIgnored0")
	TriBool isFromIgnored0;
	@ObfuscatedName("y")
	@Export("prefix")
	String prefix;
	@ObfuscatedName("w")
	@Export("text")
	String text;

	Message(int var1, String var2, String var3, String var4) {
		this.isFromFriend0 = TriBool.TriBool_unknown;
		this.isFromIgnored0 = TriBool.TriBool_unknown;
		this.set(var1, var2, var3, var4);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "1827197731"
	)
	@Export("set")
	void set(int var1, String var2, String var3, String var4) {
		this.count = TileItem.method2142();
		this.cycle = Client.cycle;
		this.type = var1;
		this.sender = var2;
		this.fillSenderUsername();
		this.prefix = var3;
		this.text = var4;
		this.clearIsFromFriend();
		this.clearIsFromIgnored();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-565259576"
	)
	@Export("clearIsFromFriend")
	void clearIsFromFriend() {
		this.isFromFriend0 = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-285390523"
	)
	@Export("isFromFriend")
	final boolean isFromFriend() {
		if (this.isFromFriend0 == TriBool.TriBool_unknown) {
			this.fillIsFromFriend();
		}

		return this.isFromFriend0 == TriBool.TriBool_true;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-28"
	)
	@Export("fillIsFromFriend")
	void fillIsFromFriend() {
		this.isFromFriend0 = VertexNormal.friendSystem.friendsList.contains(this.senderUsername) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1848382853"
	)
	@Export("clearIsFromIgnored")
	void clearIsFromIgnored() {
		this.isFromIgnored0 = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1891538421"
	)
	@Export("isFromIgnored")
	final boolean isFromIgnored() {
		if (this.isFromIgnored0 == TriBool.TriBool_unknown) {
			this.fillIsFromIgnored();
		}

		return this.isFromIgnored0 == TriBool.TriBool_true;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1953664490"
	)
	@Export("fillIsFromIgnored")
	void fillIsFromIgnored() {
		this.isFromIgnored0 = VertexNormal.friendSystem.ignoreList.contains(this.senderUsername) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-324543817"
	)
	@Export("fillSenderUsername")
	final void fillSenderUsername() {
		if (this.sender != null) {
			this.senderUsername = new Username(VertexNormal.method3017(this.sender), WorldMapLabelSize.loginType);
		} else {
			this.senderUsername = null;
		}

	}

	@ObfuscatedName("kn")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZI)V",
		garbageValue = "432259312"
	)
	@Export("findItemDefinitions")
	static void findItemDefinitions(String var0, boolean var1) {
		var0 = var0.toLowerCase();
		short[] var2 = new short[16];
		int var3 = 0;

		for (int var4 = 0; var4 < class81.ItemDefinition_fileCount; ++var4) {
			ItemDefinition var5 = Interpreter.ItemDefinition_get(var4);
			if ((!var1 || var5.isTradable) && var5.noteTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
				if (var3 >= 250) {
					UserComparator10.foundItemIdCount = -1;
					MusicPatch.foundItemIds = null;
					return;
				}

				if (var3 >= var2.length) {
					short[] var6 = new short[var2.length * 2];

					for (int var7 = 0; var7 < var3; ++var7) {
						var6[var7] = var2[var7];
					}

					var2 = var6;
				}

				var2[var3++] = (short)var4;
			}
		}

		MusicPatch.foundItemIds = var2;
		GrandExchangeOfferAgeComparator.foundItemIndex = 0;
		UserComparator10.foundItemIdCount = var3;
		String[] var8 = new String[UserComparator10.foundItemIdCount];

		for (int var9 = 0; var9 < UserComparator10.foundItemIdCount; ++var9) {
			var8[var9] = Interpreter.ItemDefinition_get(var2[var9]).name;
		}

		class3.method42(var8, MusicPatch.foundItemIds);
	}
}
