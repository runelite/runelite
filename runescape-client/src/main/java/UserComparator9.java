import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("UserComparator9")
public class UserComparator9 extends AbstractUserComparator {
	@ObfuscatedName("et")
	@ObfuscatedSignature(
		signature = "Lif;"
	)
	@Export("archive20")
	static Archive archive20;
	@ObfuscatedName("hg")
	@ObfuscatedGetter(
		intValue = -864409125
	)
	@Export("cameraZ")
	static int cameraZ;
	@ObfuscatedName("f")
	@Export("reversed")
	final boolean reversed;

	public UserComparator9(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljt;Ljt;I)I",
		garbageValue = "1918568840"
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

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IB)Liq;",
		garbageValue = "35"
	)
	public static VarbitDefinition method3319(int var0) {
		VarbitDefinition var1 = (VarbitDefinition)VarbitDefinition.VarbitDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = VarbitDefinition.VarbitDefinition_archive.takeFile(14, var0);
			var1 = new VarbitDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			VarbitDefinition.VarbitDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}
