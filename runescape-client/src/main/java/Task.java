import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
@Implements("Task")
public class Task {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lft;"
	)
	@Export("next")
	Task next;
	@ObfuscatedName("u")
	@Export("status")
	public volatile int status;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 693617751
	)
	@Export("type")
	int type;
	@ObfuscatedName("t")
	@Export("intArgument")
	public int intArgument;
	@ObfuscatedName("q")
	@Export("objectArgument")
	Object objectArgument;
	@ObfuscatedName("x")
	@Export("result")
	public volatile Object result;

	Task() {
		this.status = 0;
	}
}
