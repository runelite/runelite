import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
@Implements("UserComparator3")
public class UserComparator3 extends AbstractUserComparator {
	@ObfuscatedName("v")
	@Export("Widget_loadedInterfaces")
	static boolean[] Widget_loadedInterfaces;
	@ObfuscatedName("p")
	static int[][][] field1961;
	@ObfuscatedName("c")
	@Export("reversed")
	final boolean reversed;

	public UserComparator3(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lje;Lje;I)I",
		garbageValue = "-434078847"
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1668063844"
	)
	@Export("HealthBarDefinition_clearCached")
	public static void HealthBarDefinition_clearCached() {
		HealthBarDefinition.HealthBarDefinition_cached.clear();
		HealthBarDefinition.HealthBarDefinition_cachedSprites.clear();
	}

	@ObfuscatedName("jk")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1258062289"
	)
	static void method3399(int var0) {
		SoundCache.tempMenuAction = new MenuAction();
		SoundCache.tempMenuAction.argument1 = Client.menuArguments1[var0];
		SoundCache.tempMenuAction.argument2 = Client.menuArguments2[var0];
		SoundCache.tempMenuAction.opcode = Client.menuOpcodes[var0];
		SoundCache.tempMenuAction.argument0 = Client.menuIdentifiers[var0];
		SoundCache.tempMenuAction.action = Client.menuActions[var0];
	}
}
