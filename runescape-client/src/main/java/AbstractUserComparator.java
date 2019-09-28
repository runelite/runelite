import java.lang.management.GarbageCollectorMXBean;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
@Implements("AbstractUserComparator")
public abstract class AbstractUserComparator implements Comparator {
	@ObfuscatedName("ag")
	@Export("garbageCollector")
	static GarbageCollectorMXBean garbageCollector;
	@ObfuscatedName("n")
	@Export("nextComparator")
	Comparator nextComparator;

	protected AbstractUserComparator() {
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Ljava/util/Comparator;B)V",
		garbageValue = "0"
	)
	@Export("addComparator")
	final void addComparator(Comparator var1) {
		if (this.nextComparator == null) {
			this.nextComparator = var1;
		} else if (this.nextComparator instanceof AbstractUserComparator) {
			((AbstractUserComparator)this.nextComparator).addComparator(var1);
		}

	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Ljh;Ljh;B)I",
		garbageValue = "-78"
	)
	@Export("compareUser")
	protected final int compareUser(User var1, User var2) {
		return this.nextComparator == null ? 0 : this.nextComparator.compare(var1, var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}
}
