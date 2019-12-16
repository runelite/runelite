import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
@Implements("Task")
public class Task {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lfu;"
	)
	@Export("next")
	Task next;
	@ObfuscatedName("p")
	@Export("status")
	public volatile int status;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -2104654437
	)
	@Export("type")
	int type;
	@ObfuscatedName("e")
	@Export("intArgument")
	public int intArgument;
	@ObfuscatedName("x")
	@Export("objectArgument")
	Object objectArgument;
	@ObfuscatedName("a")
	@Export("result")
	public volatile Object result;

	Task() {
		this.status = 0;
	}
}
