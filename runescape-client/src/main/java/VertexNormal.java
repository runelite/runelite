import java.util.Iterator;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
@Implements("VertexNormal")
public class VertexNormal {
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 741962059
	)
	int field1759;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1828551341
	)
	int field1760;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1911535461
	)
	int field1758;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -171249661
	)
	int field1761;

	VertexNormal() {
	}

	@ObfuscatedSignature(
		signature = "(Ldd;)V"
	)
	VertexNormal(VertexNormal var1) {
		this.field1759 = var1.field1759;
		this.field1760 = var1.field1760;
		this.field1758 = var1.field1758;
		this.field1761 = var1.field1761;
	}

	@ObfuscatedName("jz")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "6"
	)
	static final void method2972() {
		for (int var0 = 0; var0 < Players.Players_count; ++var0) {
			Player var1 = Client.players[Players.Players_indices[var0]];
			var1.clearIsFriend();
		}

		Iterator var2 = Messages.Messages_hashTable.iterator();

		while (var2.hasNext()) {
			Message var3 = (Message)var2.next();
			var3.clearIsFromFriend();
		}

		if (DevicePcmPlayerProvider.clanChat != null) {
			DevicePcmPlayerProvider.clanChat.clearFriends();
		}

	}
}
