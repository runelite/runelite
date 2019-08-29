import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
@Implements("Usernamed")
public interface Usernamed {
	@ObfuscatedSignature(
		signature = "()Ljx;"
	)
	Username aba();

	@ObfuscatedSignature(
		signature = "()Ljx;"
	)
	Username aaj();

	@ObfuscatedSignature(
		signature = "()Ljx;"
	)
	Username aag();

	@ObfuscatedSignature(
		signature = "()Ljx;"
	)
	Username abc();

	@ObfuscatedName("kk")
	@ObfuscatedSignature(
		signature = "(I)Ljx;",
		garbageValue = "962934553"
	)
	@Export("username")
	Username username();
}
