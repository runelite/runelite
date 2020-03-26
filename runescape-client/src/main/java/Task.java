import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
@Implements("Task")
public class Task {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lfr;"
	)
	@Export("next")
	Task next;
	@ObfuscatedName("w")
	@Export("status")
	public volatile int status;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -2125226355
	)
	@Export("type")
	int type;
	@ObfuscatedName("q")
	@Export("intArgument")
	public int intArgument;
	@ObfuscatedName("z")
	@Export("objectArgument")
	Object objectArgument;
	@ObfuscatedName("t")
	@Export("result")
	public volatile Object result;

	Task() {
		this.status = 0;
	}
}
