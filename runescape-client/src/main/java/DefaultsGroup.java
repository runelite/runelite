import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kn")
@Implements("DefaultsGroup")
public class DefaultsGroup {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lkn;"
	)
	static final DefaultsGroup field3793;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1864717017
	)
	@Export("group")
	final int group;

	static {
		field3793 = new DefaultsGroup(3);
	}

	DefaultsGroup(int var1) {
		this.group = var1;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)Lbg;",
		garbageValue = "310437659"
	)
	@Export("getNextWorldListWorld")
	static World getNextWorldListWorld() {
		return World.World_listCount < World.World_count ? class96.World_worlds[++World.World_listCount - 1] : null;
	}

	@ObfuscatedName("kz")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-245092845"
	)
	static final void method5953() {
		for (int var0 = 0; var0 < Players.Players_count; ++var0) {
			Player var1 = Client.players[Players.Players_indices[var0]];
			var1.clearIsInClanChat();
		}

	}
}
