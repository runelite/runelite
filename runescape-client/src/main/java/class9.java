import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public class class9 {
	@ObfuscatedName("ls")
	@ObfuscatedSignature(
		signature = "Lhe;"
	)
	@Export("mousedOverWidgetIf1")
	static Widget mousedOverWidgetIf1;
	@ObfuscatedName("x")
	ExecutorService field49;
	@ObfuscatedName("m")
	Future field45;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lkb;"
	)
	final Buffer field44;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Ln;"
	)
	final class12 field46;

	@ObfuscatedSignature(
		signature = "(Lkb;Ln;)V"
	)
	public class9(Buffer var1, class12 var2) {
		this.field49 = Executors.newSingleThreadExecutor();
		this.field44 = var1;
		this.field46 = var2;
		this.method114();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1753641099"
	)
	public boolean method111() {
		return this.field45.isDone();
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-194627920"
	)
	public void method110() {
		this.field49.shutdown();
		this.field49 = null;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)Lkb;",
		garbageValue = "357894272"
	)
	public Buffer method113() {
		try {
			return (Buffer)this.field45.get();
		} catch (Exception var2) {
			return null;
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2043166937"
	)
	void method114() {
		this.field45 = this.field49.submit(new class8(this, this.field44, this.field46));
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lln;ILjava/lang/String;S)Ljava/lang/String;",
		garbageValue = "171"
	)
	static String method122(IterableNodeHashTable var0, int var1, String var2) {
		if (var0 == null) {
			return var2;
		} else {
			ObjectNode var3 = (ObjectNode)var0.get((long)var1);
			return var3 == null ? var2 : (String)var3.obj;
		}
	}

	@ObfuscatedName("im")
	@ObfuscatedSignature(
		signature = "(IS)Z",
		garbageValue = "32767"
	)
	static final boolean method121(int var0) {
		if (var0 < 0) {
			return false;
		} else {
			int var1 = Client.menuOpcodes[var0];
			if (var1 >= 2000) {
				var1 -= 2000;
			}

			return var1 == 1007;
		}
	}
}
