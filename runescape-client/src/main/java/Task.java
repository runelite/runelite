import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
@Implements("Task")
public class Task {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lfo;"
	)
	@Export("next")
	Task next;
	@ObfuscatedName("z")
	@Export("status")
	public volatile int status;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 400750529
	)
	@Export("type")
	int type;
	@ObfuscatedName("h")
	@Export("intArgument")
	public int intArgument;
	@ObfuscatedName("y")
	@Export("objectArgument")
	Object objectArgument;
	@ObfuscatedName("w")
	@Export("result")
	public volatile Object result;

	Task() {
		this.status = 0;
	}
}
