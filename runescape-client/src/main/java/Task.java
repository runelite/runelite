import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
@Implements("Task")
public class Task {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	@Export("next")
	Task next;
	@ObfuscatedName("v")
	@Export("status")
	public volatile int status;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1457841363
	)
	@Export("type")
	int type;
	@ObfuscatedName("c")
	@Export("intArgument")
	public int intArgument;
	@ObfuscatedName("o")
	@Export("objectArgument")
	Object objectArgument;
	@ObfuscatedName("i")
	@Export("result")
	public volatile Object result;

	Task() {
		this.status = 0;
	}
}
