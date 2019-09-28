import java.util.HashMap;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class195 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	@Export("options_buttons_0Sprite")
	static IndexedSprite options_buttons_0Sprite;

	static {
		new HashMap();
	}

	@ObfuscatedName("jz")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1399038807"
	)
	@Export("FriendSystem_invalidateIgnoreds")
	static final void FriendSystem_invalidateIgnoreds() {
		Iterator var0 = Messages.Messages_hashTable.iterator();

		while (var0.hasNext()) {
			Message var1 = (Message)var0.next();
			var1.clearIsFromIgnored();
		}

		if (Varps.clanChat != null) {
			Varps.clanChat.invalidateIgnoreds();
		}

	}
}
