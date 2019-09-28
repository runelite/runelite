import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
@Implements("UserComparator9")
public class UserComparator9 extends AbstractUserComparator {
	@ObfuscatedName("z")
	@Export("reversed")
	final boolean reversed;

	public UserComparator9(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljl;Ljl;B)I",
		garbageValue = "35"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (Client.worldId == var1.world && var2.world == Client.worldId) {
			return this.reversed ? var1.getUsername().compareToTyped(var2.getUsername()) : var2.getUsername().compareToTyped(var1.getUsername());
		} else {
			return this.compareUser(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IB)Liu;",
		garbageValue = "46"
	)
	@Export("FloorUnderlayDefinition_get")
	public static FloorUnderlayDefinition FloorUnderlayDefinition_get(int var0) {
		FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.FloorUnderlayDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = FloorUnderlayDefinition.FloorUnderlayDefinition_archive.takeFile(1, var0);
			var1 = new FloorUnderlayDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2), var0);
			}

			var1.postDecode();
			FloorUnderlayDefinition.FloorUnderlayDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IS)I",
		garbageValue = "-18305"
	)
	public static int method3359(int var0) {
		return var0 >> 17 & 7;
	}
}
