import java.util.concurrent.Callable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public class class8 implements Callable {
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 878418019
	)
	@Export("cacheGamebuild")
	public static int cacheGamebuild;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lkb;"
	)
	final Buffer field42;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Ln;"
	)
	final class12 field43;
	// $FF: synthetic field
	@ObfuscatedSignature(
		signature = "Le;"
	)
	final class9 this$0;

	@ObfuscatedSignature(
		signature = "(Le;Lkb;Ln;)V"
	)
	class8(class9 var1, Buffer var2, class12 var3) {
		this.this$0 = var1;
		this.field42 = var2;
		this.field43 = var3;
	}

	public Object call() {
		return this.field43.vmethod131(this.field42);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "11"
	)
	public static void method109() {
		FloorOverlayDefinition.FloorOverlayDefinition_cached.clear();
	}
}
