import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
@Implements("UserComparator4")
public class UserComparator4 implements Comparator {
	@ObfuscatedName("ot")
	@ObfuscatedSignature(
		signature = "Lcp;"
	)
	@Export("varcs")
	static Varcs varcs;
	@ObfuscatedName("x")
	@Export("reversed")
	final boolean reversed;

	public UserComparator4(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lke;Lke;I)I",
		garbageValue = "1812606392"
	)
	@Export("compare_bridged")
	int compare_bridged(Buddy var1, Buddy var2) {
		return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2;
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("fy")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "120"
	)
	static int method3482(int var0) {
		return var0 * 3 + 600;
	}

	@ObfuscatedName("gy")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1975650180"
	)
	static final void method3490(int var0, int var1) {
		if (Client.hintArrowType == 2) {
			WorldMapSection0.worldToScreen((Client.hintArrowX - class69.baseX << 7) + Client.hintArrowSubX, (Client.hintArrowY - class89.baseY << 7) + Client.hintArrowSubY, Client.hintArrowHeight * 2);
			if (Client.viewportTempX > -1 && Client.cycle % 20 < 10) {
				class4.headIconHintSprites[0].drawTransBgAt(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - 28);
			}

		}
	}
}
