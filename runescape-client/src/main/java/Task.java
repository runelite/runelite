import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
@Implements("Task")
public class Task {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	@Export("next")
	Task next;
	@ObfuscatedName("i")
	@Export("status")
	public volatile int status;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1842661257
	)
	@Export("type")
	int type;
	@ObfuscatedName("d")
	@Export("intArgument")
	public int intArgument;
	@ObfuscatedName("l")
	@Export("objectArgument")
	Object objectArgument;
	@ObfuscatedName("j")
	@Export("result")
	public volatile Object result;

	Task() {
		this.status = 0;
	}
}
