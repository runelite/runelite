import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
@Implements("Task")
public class Task {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lfv;"
	)
	@Export("next")
	Task next;
	@ObfuscatedName("r")
	@Export("status")
	public volatile int status;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1191522307
	)
	@Export("type")
	int type;
	@ObfuscatedName("q")
	@Export("intArgument")
	public int intArgument;
	@ObfuscatedName("m")
	@Export("objectArgument")
	Object objectArgument;
	@ObfuscatedName("y")
	@Export("result")
	public volatile Object result;

	Task() {
		this.status = 0;
	}
}
