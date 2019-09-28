import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("Message")
public class Message extends DualNode {
	@ObfuscatedName("eh")
	@ObfuscatedGetter(
		intValue = -1928576619
	)
	static int field592;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 36313413
	)
	@Export("count")
	int count;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1483460383
	)
	@Export("cycle")
	int cycle;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -991694021
	)
	@Export("type")
	int type;
	@ObfuscatedName("u")
	@Export("sender")
	String sender;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Ljq;"
	)
	@Export("senderUsername")
	Username senderUsername;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	@Export("isFromFriend0")
	TriBool isFromFriend0;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	@Export("isFromIgnored0")
	TriBool isFromIgnored0;
	@ObfuscatedName("m")
	@Export("prefix")
	String prefix;
	@ObfuscatedName("y")
	@Export("text")
	String text;

	Message(int var1, String var2, String var3, String var4) {
		this.isFromFriend0 = TriBool.TriBool_unknown;
		this.isFromIgnored0 = TriBool.TriBool_unknown;
		this.set(var1, var2, var3, var4);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
		garbageValue = "29"
	)
	@Export("set")
	void set(int var1, String var2, String var3, String var4) {
		int var5 = ++Messages.Messages_count - 1;
		this.count = var5;
		this.cycle = Client.cycle;
		this.type = var1;
		this.sender = var2;
		this.fillSenderUsername();
		this.prefix = var3;
		this.text = var4;
		this.clearIsFromFriend();
		this.clearIsFromIgnored();
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "10"
	)
	@Export("clearIsFromFriend")
	void clearIsFromFriend() {
		this.isFromFriend0 = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1794465193"
	)
	@Export("isFromFriend")
	final boolean isFromFriend() {
		if (this.isFromFriend0 == TriBool.TriBool_unknown) {
			this.fillIsFromFriend();
		}

		return this.isFromFriend0 == TriBool.TriBool_true;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1169950855"
	)
	@Export("fillIsFromFriend")
	void fillIsFromFriend() {
		this.isFromFriend0 = Tiles.friendSystem.friendsList.contains(this.senderUsername) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1690653176"
	)
	@Export("clearIsFromIgnored")
	void clearIsFromIgnored() {
		this.isFromIgnored0 = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-759719202"
	)
	@Export("isFromIgnored")
	final boolean isFromIgnored() {
		if (this.isFromIgnored0 == TriBool.TriBool_unknown) {
			this.fillIsFromIgnored();
		}

		return this.isFromIgnored0 == TriBool.TriBool_true;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1328990032"
	)
	@Export("fillIsFromIgnored")
	void fillIsFromIgnored() {
		this.isFromIgnored0 = Tiles.friendSystem.ignoreList.contains(this.senderUsername) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1885223886"
	)
	@Export("fillSenderUsername")
	final void fillSenderUsername() {
		if (this.sender != null) {
			this.senderUsername = new Username(WorldMapSectionType.method250(this.sender), WorldMapSection1.loginType);
		} else {
			this.senderUsername = null;
		}

	}

	@ObfuscatedName("fk")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "2017032545"
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

	@ObfuscatedName("gi")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "200131202"
	)
	static final void method1231(int var0, int var1) {
		if (Client.hintArrowType == 2) {
			PlayerAppearance.worldToScreen(Client.hintArrowSubX * 64 + (Client.hintArrowX - class223.baseX * 64 << 7), Client.hintArrowSubY * 64 + (Client.hintArrowY - class286.baseY * 64 << 7), Client.hintArrowHeight * 4);
			if (Client.viewportTempX > -1 && Client.cycle % 20 < 10) {
				ReflectionCheck.headIconHintSprites[0].drawTransBgAt(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - 28);
			}

		}
	}
}
