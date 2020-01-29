import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lh")
@Implements("UserComparator2")
public class UserComparator2 implements Comparator {
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Ldl;"
	)
	@Export("soundSystem")
	static SoundSystem soundSystem;
	@ObfuscatedName("dp")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	@Export("archive18")
	static Archive archive18;
	@ObfuscatedName("c")
	@Export("reversed")
	final boolean reversed;

	public UserComparator2(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljk;Ljk;I)I",
		garbageValue = "258601457"
	)
	@Export("compare_bridged")
	int compare_bridged(User var1, User var2) {
		return this.reversed ? var1.getUsername().compareToTyped(var2.getUsername()) : var2.getUsername().compareToTyped(var1.getUsername());
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((User)var1, (User)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}
}
