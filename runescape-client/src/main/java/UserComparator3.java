import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
@Implements("UserComparator3")
public class UserComparator3 extends AbstractUserComparator {
	@ObfuscatedName("pl")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	@Export("privateChatMode")
	static PrivateChatMode privateChatMode;
	@ObfuscatedName("x")
	@Export("reversed")
	final boolean reversed;

	public UserComparator3(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lke;Lke;I)I",
		garbageValue = "1767041351"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (var2.world != var1.world) {
			return this.reversed ? var1.world - var2.world : var2.world - var1.world;
		} else {
			return this.compareUser(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lch;S)V",
		garbageValue = "5308"
	)
	@Export("changeWorld")
	static void changeWorld(World var0) {
		if (var0.isMembersOnly() != Client.isMembersWorld) {
			Client.isMembersWorld = var0.isMembersOnly();
			ArchiveLoader.method1254(var0.isMembersOnly());
		}

		Script.worldHost = var0.host;
		Client.worldId = var0.id;
		Client.worldProperties = var0.properties;
		WorldMapLabelSize.port1 = Client.gameBuild == 0 ? 43594 : var0.id + 40000;
		GrandExchangeOfferAgeComparator.port2 = Client.gameBuild == 0 ? 443 : var0.id + 50000;
		class280.port3 = WorldMapLabelSize.port1;
	}
}
