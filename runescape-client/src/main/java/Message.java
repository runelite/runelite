import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("Message")
public class Message extends DualNode {
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1052025849
	)
	@Export("Interpreter_stringStackSize")
	static int Interpreter_stringStackSize;
	@ObfuscatedName("kn")
	@ObfuscatedGetter(
		intValue = -757596803
	)
	@Export("menuHeight")
	static int menuHeight;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 586338987
	)
	@Export("count")
	int count;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1201129701
	)
	@Export("cycle")
	int cycle;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 213775829
	)
	@Export("type")
	int type;
	@ObfuscatedName("e")
	@Export("sender")
	String sender;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Ljz;"
	)
	@Export("senderUsername")
	Username senderUsername;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lju;"
	)
	@Export("isFromFriend0")
	TriBool isFromFriend0;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lju;"
	)
	@Export("isFromIgnored0")
	TriBool isFromIgnored0;
	@ObfuscatedName("l")
	@Export("prefix")
	String prefix;
	@ObfuscatedName("j")
	@Export("text")
	String text;

	Message(int var1, String var2, String var3, String var4) {
		this.isFromFriend0 = TriBool.TriBool_unknown;
		this.isFromIgnored0 = TriBool.TriBool_unknown;
		this.set(var1, var2, var3, var4);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "-1939777476"
	)
	@Export("set")
	void set(int var1, String var2, String var3, String var4) {
		this.count = class4.method57();
		this.cycle = Client.cycle;
		this.type = var1;
		this.sender = var2;
		this.fillSenderUsername();
		this.prefix = var3;
		this.text = var4;
		this.clearIsFromFriend();
		this.clearIsFromIgnored();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "503642535"
	)
	@Export("clearIsFromFriend")
	void clearIsFromFriend() {
		this.isFromFriend0 = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "0"
	)
	@Export("isFromFriend")
	final boolean isFromFriend() {
		if (this.isFromFriend0 == TriBool.TriBool_unknown) {
			this.fillIsFromFriend();
		}

		return this.isFromFriend0 == TriBool.TriBool_true;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	@Export("fillIsFromFriend")
	void fillIsFromFriend() {
		this.isFromFriend0 = KeyHandler.friendSystem.friendsList.contains(this.senderUsername) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2064859672"
	)
	@Export("clearIsFromIgnored")
	void clearIsFromIgnored() {
		this.isFromIgnored0 = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-435736879"
	)
	@Export("isFromIgnored")
	final boolean isFromIgnored() {
		if (this.isFromIgnored0 == TriBool.TriBool_unknown) {
			this.fillIsFromIgnored();
		}

		return this.isFromIgnored0 == TriBool.TriBool_true;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1506874350"
	)
	@Export("fillIsFromIgnored")
	void fillIsFromIgnored() {
		this.isFromIgnored0 = KeyHandler.friendSystem.ignoreList.contains(this.senderUsername) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1639936728"
	)
	@Export("fillSenderUsername")
	final void fillSenderUsername() {
		if (this.sender != null) {
			this.senderUsername = new Username(MouseRecorder.method1207(this.sender), class192.loginType);
		} else {
			this.senderUsername = null;
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)[Lic;",
		garbageValue = "16777215"
	)
	static VerticalAlignment[] method1229() {
		return new VerticalAlignment[]{VerticalAlignment.VerticalAlignment_centered, VerticalAlignment.field3198, VerticalAlignment.field3196};
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-71"
	)
	static void method1228() {
		Iterator var0 = Messages.Messages_hashTable.iterator();

		while (var0.hasNext()) {
			Message var1 = (Message)var0.next();
			var1.clearIsFromFriend();
		}

	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1913324083"
	)
	public static final void method1246(int var0, int var1) {
		ViewportMouse.ViewportMouse_x = var0;
		ViewportMouse.ViewportMouse_y = var1;
		ViewportMouse.ViewportMouse_isInViewport = true;
		ViewportMouse.ViewportMouse_entityCount = 0;
		ViewportMouse.ViewportMouse_false0 = false;
	}

	@ObfuscatedName("jb")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-53"
	)
	@Export("getTapToDrop")
	static boolean getTapToDrop() {
		return Client.tapToDrop;
	}
}
