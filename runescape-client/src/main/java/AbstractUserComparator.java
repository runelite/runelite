import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
@Implements("AbstractUserComparator")
public abstract class AbstractUserComparator implements Comparator {
	@ObfuscatedName("j")
	@Export("nextComparator")
	Comparator nextComparator;

	protected AbstractUserComparator() {
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljava/util/Comparator;B)V",
		garbageValue = "102"
	)
	@Export("addComparator")
	final void addComparator(Comparator var1) {
		if (this.nextComparator == null) {
			this.nextComparator = var1;
		} else if (this.nextComparator instanceof AbstractUserComparator) {
			((AbstractUserComparator)this.nextComparator).addComparator(var1);
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lju;Lju;I)I",
		garbageValue = "760812985"
	)
	@Export("compareUser")
	protected final int compareUser(User var1, User var2) {
		return this.nextComparator == null ? 0 : this.nextComparator.compare(var1, var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}
}
