import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
@Implements("Task")
public class Task {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lfc;"
	)
	@Export("next")
	Task next;
	@ObfuscatedName("l")
	@Export("status")
	public volatile int status;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -2110229229
	)
	@Export("type")
	int type;
	@ObfuscatedName("j")
	@Export("intArgument")
	public int intArgument;
	@ObfuscatedName("v")
	@Export("objectArgument")
	Object objectArgument;
	@ObfuscatedName("d")
	@Export("result")
	public volatile Object result;

	Task() {
		this.status = 0;
	}
}
