import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
@Implements("Task")
public class Task {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lfa;"
	)
	@Export("next")
	Task next;
	@ObfuscatedName("k")
	@Export("status")
	public volatile int status;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -819233797
	)
	@Export("type")
	int type;
	@ObfuscatedName("b")
	@Export("intArgument")
	public int intArgument;
	@ObfuscatedName("i")
	@Export("objectArgument")
	Object objectArgument;
	@ObfuscatedName("c")
	@Export("result")
	public volatile Object result;

	Task() {
		this.status = 0;
	}
}
