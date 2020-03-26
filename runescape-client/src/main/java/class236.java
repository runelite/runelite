import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
public final class class236 {
	@ObfuscatedName("ju")
	@ObfuscatedSignature(
		signature = "Lhe;"
	)
	@Export("dragInventoryWidget")
	static Widget dragInventoryWidget;

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(BI)C",
		garbageValue = "-1712005839"
	)
	public static char method4223(byte var0) {
		int var1 = var0 & 255;
		if (var1 == 0) {
			throw new IllegalArgumentException("" + Integer.toString(var1, 16));
		} else {
			if (var1 >= 128 && var1 < 160) {
				char var2 = class297.cp1252AsciiExtension[var1 - 128];
				if (var2 == 0) {
					var2 = '?';
				}

				var1 = var2;
			}

			return (char)var1;
		}
	}

	@ObfuscatedName("kr")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "121"
	)
	@Export("FriendSystem_invalidateFriends")
	static final void FriendSystem_invalidateFriends() {
		for (int var0 = 0; var0 < Players.Players_count; ++var0) {
			Player var1 = Client.players[Players.Players_indices[var0]];
			var1.clearIsFriend();
		}

		Iterator var2 = Messages.Messages_hashTable.iterator();

		while (var2.hasNext()) {
			Message var3 = (Message)var2.next();
			var3.clearIsFromFriend();
		}

		if (InterfaceParent.clanChat != null) {
			InterfaceParent.clanChat.clearFriends();
		}

	}
}
