import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
public class class185 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lgy;"
	)
	public static final class185 field2327;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lgy;"
	)
	public static final class185 field2315;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lgy;"
	)
	public static final class185 field2322;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lgy;"
	)
	public static final class185 field2317;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lgy;"
	)
	public static final class185 field2318;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lgy;"
	)
	public static final class185 field2320;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lgy;"
	)
	public static final class185 field2319;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lgy;"
	)
	public static final class185 field2314;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lgy;"
	)
	public static final class185 field2316;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lgy;"
	)
	public static final class185 field2323;
	@ObfuscatedName("js")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	@Export("dragInventoryWidget")
	static Widget dragInventoryWidget;

	static {
		field2327 = new class185(5);
		field2315 = new class185(7);
		field2322 = new class185(3);
		field2317 = new class185(5);
		field2318 = new class185(15);
		field2320 = new class185(14);
		field2319 = new class185(6);
		field2314 = new class185(2);
		field2316 = new class185(4);
		field2323 = new class185(4);
	}

	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "5"
	)
	class185(int var1) {
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Llp;IIB)I",
		garbageValue = "-67"
	)
	static int method3686(IterableNodeHashTable var0, int var1, int var2) {
		if (var0 == null) {
			return var2;
		} else {
			IntegerNode var3 = (IntegerNode)var0.get((long)var1);
			return var3 == null ? var2 : var3.integer;
		}
	}

	@ObfuscatedName("ge")
	@ObfuscatedSignature(
		signature = "(Lbx;I)V",
		garbageValue = "-46568974"
	)
	static final void method3685(Actor var0) {
		int var1 = Math.max(1, var0.field985 - Client.cycle);
		int var2 = var0.field981 * 128 + var0.field942 * 2013925376;
		int var3 = var0.field957 * 128 + var0.field942 * 2013925376;
		var0.x += (var2 - var0.x) / var1;
		var0.y += (var3 - var0.y) / var1;
		var0.field997 = 0;
		var0.orientation = var0.field987;
	}

	@ObfuscatedName("jl")
	@ObfuscatedSignature(
		signature = "(Lbe;ZI)V",
		garbageValue = "1102320238"
	)
	@Export("closeInterface")
	static final void closeInterface(InterfaceParent var0, boolean var1) {
		int var2 = var0.group;
		int var3 = (int)var0.key;
		var0.remove();
		if (var1) {
			ObjectSound.method1933(var2);
		}

		AbstractWorldMapIcon.method628(var2);
		Widget var4 = Varps.getWidget(var3);
		if (var4 != null) {
			NPCDefinition.invalidateWidget(var4);
		}

		GameObject.method3360();
		if (Client.rootInterface != -1) {
			class226.runIntfCloseListeners(Client.rootInterface, 1);
		}

	}
}
