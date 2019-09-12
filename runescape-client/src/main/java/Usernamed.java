import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
@Implements("Usernamed")
public interface Usernamed {
	@ObfuscatedSignature(
		signature = "()Ljt;"
	)
	Username aaa();

	@ObfuscatedSignature(
		signature = "()Ljt;"
	)
	Username aak();

	@ObfuscatedSignature(
		signature = "()Ljt;"
	)
	Username aap();

	@ObfuscatedSignature(
		signature = "()Ljt;"
	)
	Username aac();

	@ObfuscatedName("kp")
	@ObfuscatedSignature(
		signature = "(B)Ljt;",
		garbageValue = "1"
	)
	@Export("username")
	Username username();
}
